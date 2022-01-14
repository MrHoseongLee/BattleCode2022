package Meteor_V2;

import battlecode.common.*;

public strictfp class RobotPlayer {

    private static Robot robot = null;

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
