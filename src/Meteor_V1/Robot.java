package Meteor_V1;

import battlecode.common.*;

import java.util.Random;

public class Robot {

    protected RobotController rc;
    protected MapLocation me;

    protected static final Random rng = new Random(6147);

    /** Array containing all the possible movement directions. */
    protected static final Direction[] directions = {
            Direction.NORTH,
            Direction.NORTHEAST,
            Direction.EAST,
            Direction.SOUTHEAST,
            Direction.SOUTH,
            Direction.SOUTHWEST,
            Direction.WEST,
            Direction.NORTHWEST,
    };

    protected static final int INF = 0x3f3f3f3f;

    public Robot(RobotController rc) throws GameActionException {
        this.rc = rc;
        this.me = rc.getLocation();
    }

    public void step() throws GameActionException {
        me = rc.getLocation();
    }

}
