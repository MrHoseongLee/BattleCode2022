package Meteor_V1;

import battlecode.common.*;

import java.util.Random;

public class Robot {

    protected RobotController rc;
    protected MapLocation currentLocation;

    protected static final Random RNG = new Random(6147);

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

    protected MapLocation target = null;

    protected static final int INF = 0x3f3f3f3f;

    public Robot(RobotController rc) throws GameActionException {
        this.rc = rc;
        this.currentLocation = rc.getLocation();
    }

    public void step() throws GameActionException {
        this.currentLocation = rc.getLocation();

        if (target != null) {
            rc.setIndicatorDot(target, 0, 255, 0);
            rc.setIndicatorLine(currentLocation, target, 255, 0, 0);
        }
    }

    protected Direction getNextDir() throws GameActionException {

        if (target == null) { return Direction.CENTER; }

        int bestValue = INF;
        int originalDistance = currentLocation.distanceSquaredTo(target);

        Direction bestDirection = Direction.CENTER;

        for(Direction direction : directions) {
            if (!rc.canMove(direction)) { continue; }

            MapLocation nextLocation = currentLocation.add(direction);

            int distance = nextLocation.distanceSquaredTo(target);
            int value = distance + valueFunction(nextLocation);

            if (distance > originalDistance) { value += 1000; }
            if (distance == 0) { value = -INF; }

            if (value < bestValue) { bestValue = value; bestDirection = direction; }
        }

        return bestDirection;
    }

    protected int valueFunction(MapLocation location) throws GameActionException {
        return -100 / (1 + rc.senseRubble(location));
    }
}
