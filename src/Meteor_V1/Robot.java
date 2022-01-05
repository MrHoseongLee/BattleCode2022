package Meteor_V1;

import battlecode.common.*;

import java.util.Stack;
import java.util.Random;

public class Robot {

    protected RobotController rc;
    protected MapLocation currentLocation;

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

    protected MapLocation target = null;    // Location of the target 
    protected Stack<Direction> path = null; // Sequence of moves that leads to the target

    protected static final int INF = 0x3f3f3f3f;

    public Robot(RobotController rc) throws GameActionException {
        this.rc = rc;
        this.currentLocation = rc.getLocation();
    }

    public void step() throws GameActionException {
        this.currentLocation = rc.getLocation();
    }

    protected void move() throws GameActionException {
        if (this.target == null) { return; }

        if (path.isEmpty()) {
            // Recalculate Path
            return;
        }

        Direction dir = path.peek();
        if (rc.canMove(dir)) {
            rc.move(dir);
            path.pop();
        }
    }
}

