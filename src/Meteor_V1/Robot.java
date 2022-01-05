package Meteor_V1;

import battlecode.common.*;

import java.util.Random;

public class Robot {

    /**
     * Utility functions for read/write shared array
     */

    int loByte(int x) { return x & 0xFF; }
    int hiByte(int x) { return (x >> 8) & 0xFF; }
    int makeWord(int lo, int hi) { return lo | (hi << 8); }


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
    protected Direction nextDirection = null;
    protected int stuckTurnCount = 0;

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

    protected void move() throws GameActionException {
        if (!rc.isMovementReady()) { return; }
        if (target == null) { selectRandomTarget(); }
        if (nextDirection == null) { calculateNextDirection(); }

        if (nextDirection == Direction.CENTER || !rc.canMove(nextDirection)) {
            stuckTurnCount++;
            if (stuckTurnCount >= 3) { target = null; }
        } else {
            stuckTurnCount = 0;
            rc.move(nextDirection);
        }

        if (currentLocation.equals(target)) { target = null; }
        nextDirection = null;
    }

    protected MapLocation getParentArchonLocation() throws GameActionException {
        for(Direction dir : directions) {
            MapLocation loc = currentLocation.add(dir);
            if(rc.canSenseRobotAtLocation(loc) && rc.senseRobotAtLocation(loc).getType() == RobotType.ARCHON)
                return loc;
        }
        return null;
    }

    protected void selectRandomTarget() {
        target = new MapLocation(RNG.nextInt(rc.getMapWidth()), RNG.nextInt(rc.getMapHeight()));
    }

    protected void calculateNextDirection() throws GameActionException {

        nextDirection = Direction.CENTER;
        if (target == null) { return; }

        int bestValue = INF;
        int originalDistance = currentLocation.distanceSquaredTo(target);

        for(Direction direction : directions) {
            MapLocation nextLocation = currentLocation.add(direction);

            if(!rc.onTheMap(nextLocation) || rc.canSenseRobotAtLocation(nextLocation)) { continue; }

            int distance = nextLocation.distanceSquaredTo(target);
            int value = distance + valueFunction(nextLocation);

            if (distance > originalDistance) { value += 1000; }
            if (distance == 0) { value = -INF; }

            if (value < bestValue) { bestValue = value; nextDirection = direction; }
        }
    }

    protected int valueFunction(MapLocation location) throws GameActionException {
        return -100 / (1 + rc.senseRubble(location));
    }

    protected boolean isThereBuilding(MapLocation location) throws GameActionException {
        return rc.canSenseRobotAtLocation(location) && rc.senseRobotAtLocation(location).getType().isBuilding();
    }
}

