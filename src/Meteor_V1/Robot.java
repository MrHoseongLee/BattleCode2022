package Meteor_V1;

import battlecode.common.*;

import java.util.Random;

import java.lang.Math;

public class Robot {

    protected RobotController rc;

    protected MapLocation currentLocation;
    protected MapLocation previousLocation;

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
        previousLocation = (rc.getLocation().equals(currentLocation)) ? previousLocation : currentLocation;
        currentLocation = rc.getLocation();
    }

    protected void draw() throws GameActionException {
        if (target != null) {
            rc.setIndicatorDot(target, 0, 255, 0);
            rc.setIndicatorLine(rc.getLocation(), target, 255, 0, 0);
        }
    }

    protected void setTarget(MapLocation target) {
        this.previousLocation = currentLocation;
        this.target = target;
    }

    protected Direction getNextDir() throws GameActionException {

        if (target == null) { return Direction.CENTER; }

        double bestValue = INF;

        Direction bestDirection = Direction.CENTER;
        int originalDistance = currentLocation.distanceSquaredTo(target);

        for(Direction direction : directions) {
            if (!rc.canMove(direction)) { continue; }

            MapLocation nextLocation = currentLocation.add(direction);

            if (nextLocation.equals(previousLocation)) { continue; }

            int distance = nextLocation.distanceSquaredTo(target);

            if (distance == 0) { bestDirection = direction; break; }

            double value = Math.sqrt(distance) + rc.senseRubble(nextLocation) / 10;

            if (distance > originalDistance) { value += Math.sqrt(distance - originalDistance) * 2; }

            if (value < bestValue) { bestValue = value; bestDirection = direction; }
        }

        return bestDirection;
    }
}
