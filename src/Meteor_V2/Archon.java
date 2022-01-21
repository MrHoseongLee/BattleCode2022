package Meteor_V2;

import battlecode.common.*;

public strictfp class Archon extends Building {

    private int minerCnt = 0;
    private MapLocation repairTarget = null;

    private int previousArchonSignal;

    private final int archonIdx;

    public Archon(RobotController rc) throws GameActionException {
        super(rc);

        archonIdx = rc.readSharedArray(Idx.teamArchonCount);
        RNG.setSeed(archonIdx);

        previousArchonSignal = ~rc.readSharedArray(Idx.teamArchonSurvivalSignal);

        rc.writeSharedArray(Idx.teamArchonCount, archonIdx + 1);
        rc.writeSharedArray(archonIdx + Idx.teamArchonDataOffset, encode(currentLocation, rc.getID()));

        if (archonIdx == rc.getArchonCount() - 1) { calculatePossibleEnemyArchonLocations(); }
    }

    public void step() throws GameActionException {
        super.step();

        final int n = rc.readSharedArray(Idx.teamArchonCount);
        final int lead = rc.getTeamLeadAmount(rc.getTeam());
        final boolean attacking = rc.getRoundNum() >= rc.readSharedArray(Idx.teamArchonCount) * 100 + 100;

        // Reset the minimap (by the archon that is currently alive and has the smallest ID)
        if (archonIdx == getFirstAliveTeamArchonIdx()) {
            minimap.reset();

            // Report undiscovered enemy archon
            for (int i = 0; i < n * 3; ++i) {
                int code = rc.readSharedArray(i + Idx.enemyArchonLocationOffset);

                if (code == 60) { continue; }

                int state = decodeID(code);
                MapLocation location = decodeLocation(code);

                if (state == 0) { minimap.reportEnemy(location, attacking ? 2 : 1); }
            }

            // Report alive enemy archon
            for (int i = 0; i < rc.readSharedArray(Idx.enemyArchonCount); ++i) {
                int code = rc.readSharedArray(i + Idx.enemyArchonDataOffset);

                MapLocation location = decodeLocation(code);

                if (location.x == 60) { continue; }

                minimap.reportEnemy(location, attacking ? 2 : 1);
            }
        }

        updateTeamArchonSurvivalStatus();

        RobotInfo[] nearbyEnemies = rc.senseNearbyRobots(-1, team.opponent());

        minimap.reportNearbyEnemies(nearbyEnemies);

        updateRepairTarget();

        boolean underAttack = false;

        if (lead <= 500) {
            for (RobotInfo robot : nearbyEnemies) {
                if (!isRobotOnSameTeam(robot)) {
                    underAttack = true;
                    if (robot.getType() == RobotType.SOLDIER) minimap.reportEnemy(robot.location, 3);
                }
            }
        }

        if (rc.isActionReady()) {
            if (underAttack) { buildDroid(RobotType.SOLDIER); }
            else if (minerCnt < rc.getMapWidth() * rc.getMapHeight() / (240.0 * n)) {
                if (lead >= 50 * countAliveTeamArchonsAfter(archonIdx) || (lead >= 50 && rc.readSharedArray(Idx.nextArchonToBuild) == archonIdx)) {
                    buildDroid(RobotType.MINER);
                    minerCnt += 1;
                    rc.writeSharedArray(Idx.nextArchonToBuild, (archonIdx + 1) % n);
                }
            }
            //else if (lead >= 200 && RNG.nextInt(10) < 2) { buildDroid(RobotType.BUILDER); }
            else if (lead >= 75) {
                if (lead >= 75 * countAliveTeamArchonsAfter(archonIdx) || rc.readSharedArray(Idx.nextArchonToBuild) == archonIdx) {
                    int k = 3; //Math.min(3, rc.getRoundNum() / 50);
                    if (lead >= 1000 || RNG.nextInt(10) < 6 + k) { buildDroid(RobotType.SOLDIER); }
                    else { buildDroid(RobotType.MINER); }
                    rc.writeSharedArray(Idx.nextArchonToBuild, (archonIdx + 1) % n);
                }
            }
        }

        if (repairTarget != null && rc.canRepair(repairTarget)) { rc.repair(repairTarget); }
    }

    private void buildDroid(RobotType robotType) throws GameActionException {
        Direction bestDirection = Direction.CENTER; int minRubble = INF;

        for (Direction direction : directions) {
            int rubble = rc.senseRubble(rc.adjacentLocation(direction));
            if (rc.canBuildRobot(robotType, direction) && minRubble > rubble) { bestDirection = direction; minRubble = rubble; }
        }

        if (bestDirection != Direction.CENTER) { rc.buildRobot(robotType, bestDirection); }
    }

    private int countAliveTeamArchonsAfter(int offset) throws GameActionException {
        int count = 0;

        int n = rc.readSharedArray(Idx.teamArchonCount);
        for (int i = offset; i < n; ++i) {
            if (rc.readSharedArray(i + Idx.teamArchonDataOffset) != 60) {
                count += 1;
            }
        }

        return count;
    }

    private int getFirstAliveTeamArchonIdx() throws GameActionException {
        for (int i = 0; i < archonIdx; ++i) {
            if (rc.readSharedArray(i + Idx.teamArchonDataOffset) != 60) {
                return i;
            }
        }

        return archonIdx;
    }

    private void calculatePossibleEnemyArchonLocations() throws GameActionException {
        int width = rc.getMapWidth() - 1, height = rc.getMapHeight() - 1;
        int n = rc.readSharedArray(Idx.teamArchonCount);

        // Horizontal, Vertical, Rotational symmetry for all team archon locations
        for (int i = 0; i < n; ++i) {
            MapLocation teamArchonLocation = decodeLocation(rc.readSharedArray(i + Idx.teamArchonDataOffset));
            int x = teamArchonLocation.x, y = teamArchonLocation.y;

            rc.writeSharedArray(i * 3 + 0 + Idx.enemyArchonLocationOffset, encode(width - x, y));
            rc.writeSharedArray(i * 3 + 1 + Idx.enemyArchonLocationOffset, encode(x, height - y));
            rc.writeSharedArray(i * 3 + 2 + Idx.enemyArchonLocationOffset, encode(width - x, height - y));
        }

        // Remove Duplicates
        for (int i = 0; i < n * 3; ++i) {
            for(int j = 0; j < i; ++j) {
                if ((rc.readSharedArray(i + Idx.enemyArchonLocationOffset) & 0xFFF) == (rc.readSharedArray(j + Idx.enemyArchonLocationOffset) & 0xFFF)) {
                    rc.writeSharedArray(i + Idx.enemyArchonLocationOffset, 60);
                    break;
                }
            }
        }
    }

    private void updateTeamArchonSurvivalStatus() throws GameActionException {
        int signal = rc.readSharedArray(Idx.teamArchonSurvivalSignal);

        int n = rc.readSharedArray(Idx.teamArchonCount);
        int diff = signal ^ previousArchonSignal;

        for (int i = 0; i < n; ++i) {
            if ((diff & (1 << i)) == 0) {
                if (rc.readSharedArray(i + Idx.teamArchonDataOffset) == 60) { continue; }
                rc.writeSharedArray(i + Idx.teamArchonDataOffset, 60);
            }
        }

        previousArchonSignal = signal;
        rc.writeSharedArray(Idx.teamArchonSurvivalSignal, signal ^ (1 << archonIdx));
    }

    private void updateRepairTarget() {
        int minHealth = INF;
        repairTarget = null;

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots(RobotType.ARCHON.actionRadiusSquared, team);

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType().isBuilding()) { continue; }
            if (robot.getHealth() == robot.getType().getMaxHealth(1)) { continue; }

            int health = robot.getHealth();
            if (robot.getType() == RobotType.SOLDIER) { health -= 50; }

            if(health < minHealth) { minHealth = health; repairTarget = robot.location; }
        }
    }
}
