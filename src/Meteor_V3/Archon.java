package Meteor_V3;

import battlecode.common.*;

public strictfp class Archon extends Building {

    private final int MINER_GROUP_SIZE = 10;

    private MapLocation repairTarget = null;

    private int portableArchonCount;
    private int previousArchonSignal;

    private final int archonIdx;

    public Archon(RobotController rc) throws GameActionException {
        super(rc);

        archonIdx = rc.readSharedArray(Idx.teamArchonCount);
        RNG.setSeed(archonIdx);

        previousArchonSignal = ~rc.readSharedArray(Idx.teamArchonStatus);

        rc.writeSharedArray(Idx.teamArchonCount, archonIdx + 1);
        rc.writeSharedArray(archonIdx + Idx.teamArchonDataOffset, encode(currentLocation, rc.getID()));

        if (archonIdx == rc.getArchonCount() - 1) { calculatePossibleEnemyArchonLocations(); }

        buildDroid(RobotType.MINER);
    }

    public void step() throws GameActionException {
        super.step();

        final int n = rc.readSharedArray(Idx.teamArchonCount);
        final int lead = rc.getTeamLeadAmount(rc.getTeam());
        final int gold = rc.getTeamGoldAmount(rc.getTeam());
        final int buildOrder = rc.readSharedArray(51);
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

        updateTeamArchonStatus();

        RobotInfo[] nearbyEnemies = rc.senseNearbyRobots(-1, team.opponent());

        minimap.reportNearbyEnemies(nearbyEnemies);

        updateRepairTarget();

        boolean underAttack = false;

        if (lead <= 500) {
            for (RobotInfo robot : nearbyEnemies) {
                underAttack = true;
                if (isDangerous(robot.type)) minimap.reportEnemy(robot.location, 3);
            }
        }

        if (rc.getMode() == RobotMode.PORTABLE) {
            if (currentLocation.equals(target)) { 
                if (transform()) {
                    return;
                }
            }

            target = minimap.getClosestEnemy();

            if (rc.isMovementReady()) {
                for (RobotInfo robot : nearbyEnemies) {
                    if (isDangerous(robot.getType())) {
                        updateTargetForEvasion(nearbyEnemies);
                        move();
                        rc.writeSharedArray(archonIdx + Idx.teamArchonDataOffset, encode(rc.getLocation(), rc.getID()));
                        return;
                    }
                }
            }

            RobotInfo[] nearbyRobots = rc.senseNearbyRobots(-1, team);
            for (RobotInfo robot : nearbyRobots) {
                RobotType type = robot.getType();
                if (type == RobotType.SOLDIER || type == RobotType.SAGE) {
                    if (robot.getHealth() < type.getMaxHealth(1)) {
                        target = findBestLocationToHeal();
                        break;
                    }
                }
            }

            move();
            rc.writeSharedArray(archonIdx + Idx.teamArchonDataOffset, encode(rc.getLocation(), rc.getID()));
            return;
        }

        if (!underAttack && repairTarget == null) {
            if (rc.getRoundNum() >= 60 && portableArchonCount + 1 < rc.getArchonCount()) { 
                if (transform()) { return; }
            }
        }

        if (rc.isActionReady()) {
            if (underAttack) { buildDroid(RobotType.SAGE); buildDroid(RobotType.SOLDIER); }
            else if ((rc.readSharedArray(52) & (1 << archonIdx)) == 0) {
                buildDroid(RobotType.BUILDER);
            } else if (gold >= 20 * countAliveTeamArchonsAfter(archonIdx) || (gold >= 20 && rc.readSharedArray(Idx.nextArchonToBuild) == archonIdx)) {
                buildDroid(RobotType.SAGE);
                rc.writeSharedArray(Idx.nextArchonToBuild, getNextAliveTeamArchonIdx(archonIdx));
            } else if (buildOrder > 0) {
                if (lead >= 50 * countAliveTeamArchonsAfter(archonIdx) || (lead >= 50 && rc.readSharedArray(Idx.nextArchonToBuild) == archonIdx)) {
                    buildDroid(RobotType.MINER);
                    rc.writeSharedArray(51, (rc.readSharedArray(51) + 1) % MINER_GROUP_SIZE);
                    rc.writeSharedArray(Idx.nextArchonToBuild, getNextAliveTeamArchonIdx(archonIdx));
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

    private void updateTeamArchonStatus() throws GameActionException {
        int signal = rc.readSharedArray(Idx.teamArchonStatus);

        int n = rc.readSharedArray(Idx.teamArchonCount);
        int diff = signal ^ previousArchonSignal;

        for (int i = 0; i < n; ++i) {
            if ((diff & (1 << i)) == 0) {
                if (rc.readSharedArray(i + Idx.teamArchonDataOffset) == 60) { continue; }
                rc.writeSharedArray(i + Idx.teamArchonDataOffset, 60);
            }
        }

        portableArchonCount = 0;
        for (int i = n; i < 2 * n; ++i) {
            if ((signal & (1 << i)) > 0) {
                portableArchonCount += 1;
            }
        }

        previousArchonSignal = signal;
        rc.writeSharedArray(Idx.teamArchonStatus, signal ^ (1 << archonIdx));
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
            if (robot.getType() == RobotType.SAGE) { health -= 500; }

            if(health < minHealth) { minHealth = health; repairTarget = robot.location; }
        }
    }

    private boolean transform() throws GameActionException {
        if (rc.canTransform()) { 
            rc.transform(); 
            target = minimap.getClosestEnemy(); 
            int n = rc.readSharedArray(Idx.teamArchonCount);
            int signal = rc.readSharedArray(Idx.teamArchonStatus);
            rc.writeSharedArray(Idx.teamArchonStatus, signal ^ (1 << (archonIdx + n)));
            return true;
        }
        return false;
    }

    private MapLocation findBestLocationToHeal() throws GameActionException {
        MapLocation bestLocation = currentLocation; int minRubble = INF; int minDistance = INF;
        MapLocation[] nearbyLocations = rc.getAllLocationsWithinRadiusSquared(currentLocation, 34);
        for (MapLocation location : nearbyLocations) {
            int rubble = rc.senseRubble(location);
            int distance = currentLocation.distanceSquaredTo(location);
            if (rubble < minRubble || (rubble == minRubble && distance < minDistance)) {
                minRubble = rubble;
                minDistance = distance;
                bestLocation = location;
            }
        }
        return bestLocation;
    }

}
