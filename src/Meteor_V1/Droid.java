package Meteor_V1;

import battlecode.common.*;

public strictfp class Droid extends Robot {
    public Droid(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();
    }

    /**
     * Check whether there is any resource in the vision radius(20) of this droid.
     * @return true / false
     */
    public boolean resourceExists() throws GameActionException {
        for (int dx = -4; dx <= 4; dx++) {
            for (int dy = -4; dy <= 4; dy++) {
                MapLocation loc = new MapLocation(me.x + dx, me.y + dy);
                if(rc.canSenseLocation(loc) && rc.senseLead(loc) + rc.senseLead(loc) > 0)
                    return true;
            }
        }
        return false;
    }
}
