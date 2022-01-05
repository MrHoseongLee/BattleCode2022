package Meteor_V1;

import battlecode.common.*;

public strictfp class Archon extends Building {

    private int builderCnt = 0;
    private int soldierCnt = 0;
    private int previousMinerSignal = 0;

    public Archon(RobotController rc) throws GameActionException {
        super(rc);
        rc.writeSharedArray(0, rc.readSharedArray(0) + 1); // Increment Archon count
    }

    private int getMinerCount() throws GameActionException {
        int currentMinerSignal = rc.readSharedArray(62) << 16 + rc.readSharedArray(63);
        int minerCount = Integer.bitCount(currentMinerSignal ^ previousMinerSignal);

        previousMinerSignal = currentMinerSignal;

        return minerCount;
    }

    public void step() throws GameActionException {
        super.step();

        int minerCnt = getMinerCount();

        if (minerCnt < 4) { buildDroid(RobotType.MINER); }

        if(builderCnt < 1) {
            if (buildDroid(RobotType.BUILDER)) {
                builderCnt += 1;
            }
        }

        if(soldierCnt < 10) {
            if (buildDroid(RobotType.SOLDIER)) {
                soldierCnt += 1;
            }
        }
    }

    private boolean buildDroid(RobotType robotType) throws GameActionException {
        for (Direction direction : directions) {
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
