package Meteor_V1;

import battlecode.common.*;

import java.util.Random;

import java.lang.Math;

public class Robot {

    /**
     * Utility functions for read/write shared array
     */

    int loByte(int x) { return x & 0xFF; }
    int hiByte(int x) { return (x >> 8) & 0xFF; }
    int makeWord(int lo, int hi) { return lo | (hi << 8); }

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
    protected Direction nextDirection = null;

    protected static final int INF = 0x3f3f3f3f;

    public Robot(RobotController rc) throws GameActionException {
        this.rc = rc;
        this.currentLocation = rc.getLocation();
    }

    public void step() throws GameActionException {
        previousLocation = (rc.getLocation().equals(currentLocation)) ? previousLocation : currentLocation;
        currentLocation = rc.getLocation();
    }

    protected void move() throws GameActionException {
        if (nextDirection == null) { calculateNextDirection(); }
        if (rc.canMove(nextDirection)) { rc.move(nextDirection); }
        nextDirection = null;
        // rc.setIndicatorString("target = " + target);
    }

    protected void draw() throws GameActionException {
        if (target != null) {
            rc.setIndicatorDot(target, 0, 255, 0);
            rc.setIndicatorLine(rc.getLocation(), target, 255, 0, 0);
        }
    }

    protected MapLocation getParentArchonLocation() throws GameActionException {
        RobotInfo[] nearRobots = rc.senseNearbyRobots(2);
        for (RobotInfo nearRobot : nearRobots) {
            if (nearRobot.team.isPlayer() && nearRobot.type.equals(RobotType.ARCHON)) { return nearRobot.location; }
        }
        return null;
    }

    protected void setTarget(MapLocation target) {
        this.previousLocation = currentLocation;
        this.target = target;
    }

    protected void selectRandomTarget() throws GameActionException {
        target = new MapLocation(RNG.nextInt(rc.getMapWidth()), RNG.nextInt(rc.getMapHeight()));
    }

    protected void calculateNextDirection() throws GameActionException {

        nextDirection = Direction.CENTER;
        if (target == null) { return; }

        double bestValue = INF;

        int originalDistance = currentLocation.distanceSquaredTo(target);

        for(Direction direction : directions) {
            MapLocation nextLocation = currentLocation.add(direction);

            if(!rc.onTheMap(nextLocation) || rc.canSenseRobotAtLocation(nextLocation)) { continue; }

            if (nextLocation.equals(previousLocation)) { continue; }

            int distance = nextLocation.distanceSquaredTo(target);

            if (distance == 0) { nextDirection = direction; break; }

            double value = Math.sqrt(distance) + rc.senseRubble(nextLocation) / 10.0;

            if (distance > originalDistance) { value += Math.sqrt(distance - originalDistance) * 2; }

            if (value < bestValue) { bestValue = value; nextDirection = direction; }
        }
    }

    protected boolean isThereBuilding(MapLocation location) throws GameActionException {
        return rc.canSenseRobotAtLocation(location) && rc.senseRobotAtLocation(location).getType().isBuilding();
    }

    protected MapLocation bestLocationNextTo(MapLocation location) throws GameActionException {
        MapLocation[] neighbors = rc.getAllLocationsWithinRadiusSquared(location, 2);
        int minRubble = INF;
        int minDistance = INF;
        MapLocation bestNeighbor = null;
        for (MapLocation neighbor : neighbors) {
            if (rc.canSenseRobotAtLocation(neighbor) && !currentLocation.equals(neighbor)) { continue; }
            int rubble = rc.senseRubble(neighbor);
            int distance = currentLocation.distanceSquaredTo(neighbor);
            if (rubble < minRubble) { minRubble = rubble; minDistance = INF; bestNeighbor = neighbor; }
            if (rubble == minRubble && distance < minDistance) { minRubble = rubble; minDistance = distance; bestNeighbor = neighbor; }
        }
        return bestNeighbor;
    }

}
