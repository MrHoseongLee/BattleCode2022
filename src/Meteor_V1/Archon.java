package Meteor_V1;

import battlecode.common.*;

public strictfp class Archon extends Building {

    private int builderCnt = 0; // For test
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

        if (minerCnt < 4) {
            Direction dir = directions[rng.nextInt(directions.length)];
            if (rc.canBuildRobot(RobotType.MINER, dir)) {
                rc.buildRobot(RobotType.MINER, dir);
            }
        }

        if(builderCnt < 1) {
            Direction dir = directions[rng.nextInt(directions.length)];
            if (rc.canBuildRobot(RobotType.BUILDER, dir)) {
                rc.buildRobot(RobotType.BUILDER, dir);
                builderCnt++;
            }
        }
    }
}
