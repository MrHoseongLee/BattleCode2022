package Meteor_V2;

import battlecode.common.*;

public strictfp class Archon extends Building {

    private int minerCnt = 0;
    private boolean dead = false;

    private final int archonIdx;

    public Archon(RobotController rc) throws GameActionException {
        super(rc);

        archonIdx = rc.readSharedArray(Idx.teamArchonCount);
        RNG.setSeed(archonIdx);

        rc.writeSharedArray(Idx.teamArchonCount, archonIdx + 1); // Increment Archon count
        rc.writeSharedArray(archonIdx + Idx.teamArchonDataOffset, encode(currentLocation, rc.getID()));
    }

    public void step() throws GameActionException {
        super.step();

        if(archonIdx == getFirstLivingTeamArchonIdx()) minimap.initTurn();

        if(!dead && rc.getHealth() <= 100) {
            dead = true;
            rc.writeSharedArray(archonIdx + Idx.teamArchonDataOffset, 60);
        }

        final int lead = rc.getTeamLeadAmount(rc.getTeam());

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();

        minimap.reportNearbyEnemies(nearbyRobots);

        if (lead <= 500) {
            for (RobotInfo robot : nearbyRobots) {
                if (robot.getType() == RobotType.SOLDIER && !isRobotOnSameTeam(robot)) {
                    buildDroid(RobotType.SOLDIER);
                    break;
                }
            }
        }

        if (rc.isActionReady()) {
            int n = rc.readSharedArray(Idx.teamArchonCount);
            if (minerCnt < rc.getMapWidth() * rc.getMapHeight() / (180 * n)) {
                if (lead >= 50 * countLivingTeamArchon(archonIdx) || (lead >= 50 && rc.readSharedArray(Idx.nextArchonToBuild) == archonIdx)) {
                    buildDroid(RobotType.MINER);
                    minerCnt += 1;
                    rc.writeSharedArray(Idx.nextArchonToBuild, (archonIdx + 1) % n);
                }
            }
            else if (lead >= 200 && RNG.nextInt(10) < 2) buildDroid(RobotType.BUILDER);
            else if (lead >= 75) {
                if (lead >= 75 * countLivingTeamArchon(archonIdx) || rc.readSharedArray(Idx.nextArchonToBuild) == archonIdx) {
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

    private int countLivingTeamArchon(int offset) throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);
        int cnt = 0;
        for (int i = offset; i < n; ++i)
            if (rc.readSharedArray(i + Idx.teamArchonDataOffset) != 60)
                cnt += 1;
        return cnt;
    }

    private int getFirstLivingTeamArchonIdx() throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);
        for (int i = 0; i < n; ++i)
            if (rc.readSharedArray(i + Idx.teamArchonDataOffset) != 60)
                return i;
        return archonIdx;
    }
}
