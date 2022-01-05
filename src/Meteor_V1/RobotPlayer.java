package Meteor_V1;

import battlecode.common.*;

public strictfp class RobotPlayer {

    private static Robot robot = null;
    private static int turnCount = 0;

    public static void run(RobotController rc) throws GameActionException {
        switch (rc.getType()) {
            case ARCHON:        robot = new Archon(rc);      break;
            case LABORATORY:    robot = new Laboratory(rc);  break;
            case WATCHTOWER:    robot = new Watchtower(rc);  break;
            case MINER:         robot = new Miner(rc);       break;
            case BUILDER:       robot = new Builder(rc);     break;
            case SOLDIER:       robot = new Soldier(rc);     break;
            case SAGE:          robot = new Sage(rc);        break;
            default:                                         break;
        }

        while (true) {
            turnCount += 1;
            if(turnCount >= 200) return; // For test

            try {
                robot.step();
                Clock.yield();
            } catch (Exception e) {
                System.out.println(rc.getType() + " Exception");
                e.printStackTrace();
            } 
        }
    }
}
