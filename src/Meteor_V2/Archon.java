package Meteor_V2;

import battlecode.common.*;

public strictfp class Archon extends Building {

    private int minerCnt = 0;
    private int soldierCnt = 0;
    private int commandedScout = 0;
    private MapLocation repairTarget = null;
    private MapLocation[] possibleEnemyArchonLocations = null;

    private final int archonIdx;

    public Archon(RobotController rc) throws GameActionException {
        super(rc);

        archonIdx = rc.readSharedArray(Idx.teamArchonCount);
        RNG.setSeed(archonIdx);

        rc.writeSharedArray(Idx.teamArchonCount, archonIdx + 1); // Increment Archon count
        rc.writeSharedArray(archonIdx + Idx.teamArchonDataOffset, encode(currentLocation, rc.getID()));
        //rc.writeSharedArray(archonIdx + Idx.enemyArchonDataOffset, 0xFFFF);
        rc.writeSharedArray(archonIdx + Idx.teamSoldierTargetOffset, 60);
    }

    public void step() throws GameActionException {
        super.step();

        if (rc.getRoundNum() == 2 && archonIdx == 0) { calculatePossibleEnemyArchonLocations(); }

        final int lead = rc.getTeamLeadAmount(rc.getTeam());

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();
        if (lead <= 500) {
            for (RobotInfo robot : nearbyRobots) {
                if (robot.getType() == RobotType.SOLDIER && !isRobotOnSameTeam(robot)) {
                    buildDroid(RobotType.SOLDIER);
                    break;
                }
            }
        }

        if (rc.isActionReady()) {
            int n = rc.readSharedArray(0);
            if (minerCnt < rc.getMapWidth() * rc.getMapHeight() / (180 * n)) {
                if (lead >= 200 || (lead >= 50 && rc.readSharedArray(Idx.nextArchonToBuild) == archonIdx)) {
                    buildDroid(RobotType.MINER);
                    minerCnt += 1;
                    rc.writeSharedArray(Idx.nextArchonToBuild, (archonIdx + 1) % n);
                }
            }
            else if (lead >= 200 && RNG.nextInt(10) < 2) buildDroid(RobotType.BUILDER);
            else if (lead >= 75) {
                if (lead >= 75 * (n - archonIdx) || rc.readSharedArray(Idx.nextArchonToBuild) == archonIdx) {
                    int k = Math.min(4, RobotPlayer.turnCount / 50);
                    if (lead >= 1000 || RNG.nextInt(10) < 5 + k) buildDroid(RobotType.SOLDIER);
                    else buildDroid(RobotType.MINER);
                    rc.writeSharedArray(Idx.nextArchonToBuild, (archonIdx + 1) % n);
                }
            }
        }
    }

    private void buildDroid(RobotType robotType) throws GameActionException {
        Direction bestDirection = Direction.CENTER; int minRubble = INF;

        for (int i = 0; i < 8; ++i) {
            Direction direction = directions[i];
            int rubble = rc.senseRubble(rc.adjacentLocation(direction));
            if (rc.canBuildRobot(robotType, direction) && minRubble > rubble) {
                bestDirection = direction; minRubble = rubble;
            }
        }

        if (bestDirection != Direction.CENTER) { rc.buildRobot(robotType, bestDirection); }
    }

    private void calculatePossibleEnemyArchonLocations() throws GameActionException {
        int width = rc.getMapWidth() - 1; int height = rc.getMapHeight() - 1;
        int n = rc.readSharedArray(Idx.teamArchonCount);

        for (int i = 0; i < n; ++i) {
            MapLocation teamArchonLocation = decodeLocation(rc.readSharedArray(i + Idx.teamArchonDataOffset));
            int x = teamArchonLocation.x, y = teamArchonLocation.y;

            rc.writeSharedArray(i * 3 + Idx.enemyArchonLocationOffset, encode(width - x, y));
            rc.writeSharedArray(i * 3 + 1 + Idx.enemyArchonLocationOffset, encode(x, height - y));
            rc.writeSharedArray(i * 3 + 2 + Idx.enemyArchonLocationOffset, encode(width - x, height - y));
        }

        for (int i = 0; i < n * 3; ++i) {
            for(int j = 0; j < i; ++j) {
                if (decodeLocation(rc.readSharedArray(i + Idx.enemyArchonLocationOffset)).equals(decodeLocation(rc.readSharedArray(j + Idx.enemyArchonLocationOffset)))) {
                    rc.writeSharedArray(i + Idx.enemyArchonLocationOffset, encode(61, 0));
                    break;
                }
            }
        }
    }

    private void findRepairTarget() {
        if (rc.getHealth() < RobotType.ARCHON.getMaxHealth(1)) { repairTarget = currentLocation; return; }

        int minHealth = INF;
        repairTarget = null;

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots(20, rc.getTeam());

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType().isBuilding()) continue;
            if (robot.getHealth() == robot.getType().getMaxHealth(1)) continue;

            int health = robot.getHealth();

            if(health < minHealth) { minHealth = health; repairTarget = robot.location; }
        }
    }
}
