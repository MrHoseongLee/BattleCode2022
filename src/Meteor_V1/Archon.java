package Meteor_V1;

import battlecode.common.*;

public strictfp class Archon extends Building {

    private int minerCnt = 0;
    private int builderCnt = 0;
    private int soldierCnt = 0;
    private int previousMinerSignal = 0;
    private int commandedScout = 0;

    private final int archonIdx;

    public Archon(RobotController rc) throws GameActionException {
        super(rc);

        archonIdx = rc.readSharedArray(0);
        rc.writeSharedArray(0, archonIdx + 1); // Increment Archon count
        rc.writeSharedArray(archonIdx + 6, makeWord(currentLocation.x, currentLocation.y));
        rc.writeSharedArray(archonIdx + 10, 100);
    }

    private int getMinerCount() throws GameActionException {
        int currentMinerSignal = rc.readSharedArray(62) << 16 + rc.readSharedArray(63);
        int minerCount = Integer.bitCount(currentMinerSignal ^ previousMinerSignal);

        previousMinerSignal = currentMinerSignal;

        return minerCount;
    }

    public void step() throws GameActionException {
        super.step();

        if (archonIdx == 0) { rc.writeSharedArray(18, RobotPlayer.turnCount); }

        final int lead = rc.getTeamLeadAmount(rc.getTeam());

        if (rc.isActionReady() && lead >= 75) {
            int k = Math.min(4, RobotPlayer.turnCount / 100);
            if (lead >= 1000 || RNG.nextInt(10) < 3 + k) buildDroid(RobotType.SOLDIER);
            else buildDroid(RobotType.MINER);
        }

        // Command to soldier
        /*if (commandedScout == 1) {
            rc.writeSharedArray(archonIdx + 10, 100);
            commandedScout = -100;
        }
        if (commandedScout < 0) { commandedScout += 1; }

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();

        soldierCnt = 0;
        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType() == RobotType.SOLDIER && robot.getTeam() == rc.getTeam())
                soldierCnt += 1;
        }

        if(commandedScout == 0 && soldierCnt >= SQUAD_SOLDIER * 2) {
            rc.writeSharedArray(archonIdx + 10, 110);
            commandedScout = 1;
        }*/

        // For test
        /*if(minerCnt < 1) {
            if (buildDroid(RobotType.MINER)) {
                minerCnt += 1;
            }
        }

        if(builderCnt < 0) {
            if (buildDroid(RobotType.BUILDER)) {
                builderCnt += 1;
            }
        }

        if(soldierCnt < 1) {
            if (buildDroid(RobotType.SOLDIER)) {
                soldierCnt += 1;
            }
        }*/
    }

    private boolean buildDroid(RobotType robotType) throws GameActionException {
        for (int i = 0; i < 8; ++i) {
            Direction direction = directions[RNG.nextInt(8)];
            if (rc.canBuildRobot(robotType, direction)) {
                rc.buildRobot(robotType, direction);
                return true;
            }
        }
        return false;
    }

    private void buildDroids(RobotType robotType) throws GameActionException {
        for (Direction direction : directions) {
            if (rc.canBuildRobot(robotType, direction)) {
                rc.buildRobot(robotType, direction);
            }
        }
    }
}
