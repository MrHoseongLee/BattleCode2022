package Meteor_V3;

import battlecode.common.*;

public strictfp class Laboratory extends Building {

    private boolean dead = false;

    public Laboratory(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        if (!dead && rc.getHealth() <= 20) {
            dead = true;
            //rc.writeSharedArray(63, rc.readSharedArray(63) - 1);
        }

        for (RobotInfo robot : rc.senseNearbyRobots(34, team.opponent())) {
            if (isDangerous(robot.type)) minimap.reportEnemy(robot.location, 3);
        }

        if (minimap.getLevel(currentLocation) < 3 && rc.canTransmute()) rc.transmute();
    }
}
