package Meteor_V2;

import battlecode.common.*;

public strictfp class Archon extends Building {

    private int minerCnt = 0;
    private boolean dead = false;
    private MapLocation repairTarget = null;

    private final int archonIdx;

    public Archon(RobotController rc) throws GameActionException {
        super(rc);

        archonIdx = rc.readSharedArray(Idx.teamArchonCount);
        RNG.setSeed(archonIdx);

        rc.writeSharedArray(Idx.teamArchonCount, archonIdx + 1);
        rc.writeSharedArray(archonIdx + Idx.teamArchonDataOffset, encode(currentLocation, rc.getID()));

        if (archonIdx == rc.getArchonCount() - 1) { calculatePossibleEnemyArchonLocations(); }
    }

    public void step() throws GameActionException {
        super.step();

        final int n = rc.readSharedArray(Idx.teamArchonCount);
        final int lead = rc.getTeamLeadAmount(rc.getTeam());

        if(archonIdx == getFirstLivingTeamArchonIdx()) {
            minimap.initTurn();

            for (int i = 0; i < n * 3; ++i) {
                int code = rc.readSharedArray(i + Idx.enemyArchonLocationOffset);

                int state = decodeID(code);
                MapLocation location = decodeLocation(code);

                if (state <= 1) { minimap.reportEnemy(location, 1); }
            }
        }

        if(!dead && rc.getHealth() <= 100) {
            dead = true;
            rc.writeSharedArray(archonIdx + Idx.teamArchonDataOffset, 60);
        }

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();

        minimap.reportNearbyEnemies(nearbyRobots);

        findRepairTarget();

        boolean underAttack = false;

        if (lead <= 500) {
            for (RobotInfo robot : nearbyRobots) {
                if (!isRobotOnSameTeam(robot)) {
                    underAttack = true;
                    minimap.reportEnemy(currentLocation, 3);
                    break;
                }
            }
        }

        if (rc.isActionReady()) {
            if (underAttack) buildDroid(RobotType.SOLDIER);
            else if (minerCnt < rc.getMapWidth() * rc.getMapHeight() / (180 * n)) {
                if (lead >= 50 * countLivingTeamArchonsAfter(archonIdx) || (lead >= 50 && rc.readSharedArray(Idx.nextArchonToBuild) == archonIdx)) {
                    buildDroid(RobotType.MINER);
                    minerCnt += 1;
                    rc.writeSharedArray(Idx.nextArchonToBuild, (archonIdx + 1) % n);
                }
            }
            else if (lead >= 200 && RNG.nextInt(10) < 2) buildDroid(RobotType.BUILDER);
            else if (lead >= 75) {
                if (lead >= 75 * countLivingTeamArchonsAfter(archonIdx) || rc.readSharedArray(Idx.nextArchonToBuild) == archonIdx) {
                    int k = 2; //Math.min(3, rc.getRoundNum() / 50);
                    if (lead >= 1000 || RNG.nextInt(10) < 6 + k) { buildDroid(RobotType.SOLDIER); }
                    else { buildDroid(RobotType.MINER); }
                    rc.writeSharedArray(Idx.nextArchonToBuild, (archonIdx + 1) % n);
                }
            }
        }

        if (repairTarget != null && rc.canRepair(repairTarget)) rc.repair(repairTarget);
    }

    private void buildDroid(RobotType robotType) throws GameActionException {
        Direction bestDirection = Direction.CENTER; int minRubble = INF;

        for (Direction direction : directions) {
            int rubble = rc.senseRubble(rc.adjacentLocation(direction));
            if (rc.canBuildRobot(robotType, direction) && minRubble > rubble) { bestDirection = direction; minRubble = rubble; }
        }

        if (bestDirection != Direction.CENTER) { rc.buildRobot(robotType, bestDirection); }
    }

    private int countLivingTeamArchonsAfter(int offset) throws GameActionException {
        int count = 0;

        int n = rc.readSharedArray(Idx.teamArchonCount);
        for (int i = offset; i < n; ++i) {
            if (rc.readSharedArray(i + Idx.teamArchonDataOffset) != 60) {
                count += 1;
            }
        }

        return count;
    }

    private int getFirstLivingTeamArchonIdx() throws GameActionException {
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
                    rc.writeSharedArray(i + Idx.enemyArchonLocationOffset, encode(61, 0));
                    break;
                }
            }
        }
    }

    private void findRepairTarget() {
        int minHealth = INF;
        repairTarget = null;

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots(20);

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() != rc.getTeam()) continue;
            if (robot.getType().isBuilding()) continue;
            if (robot.getHealth() == robot.getType().getMaxHealth(1)) continue;

            int health = robot.getHealth();
            if (robot.getType() == RobotType.SOLDIER) health -= 50;

            if(health < minHealth) { minHealth = health; repairTarget = robot.location; }
        }
    }
}
