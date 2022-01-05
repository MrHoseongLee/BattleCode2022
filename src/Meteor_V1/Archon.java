package Meteor_V1;

import battlecode.common.*;

public strictfp class Archon extends Building {

    private int minerCnt = 0; // For test
    private int builderCnt = 0; // For test

    public Archon(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        // Not a real strategy. For test
        if(minerCnt < 4) {
            Direction dir = directions[rng.nextInt(directions.length)];
            if (rc.canBuildRobot(RobotType.MINER, dir)) {
                rc.buildRobot(RobotType.MINER, dir);
                minerCnt++;
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
