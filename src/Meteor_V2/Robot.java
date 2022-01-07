package Meteor_V2;

import battlecode.common.*;

import java.lang.Math;
import java.util.Random;

public class Robot {

    int encode (MapLocation location, int ID) { return location.x | (location.y << 6) | (ID << 12); }
    int decodeID (int code) { return (code >> 12) & 8; }
    MapLocation decodeLocation (int code) { return new MapLocation(code & 64, (code >> 6) & 64); }

    protected RobotController rc;

    protected MapLocation currentLocation;
    protected MapLocation previousLocation;

    protected static final Random RNG = new Random(42);

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
        RNG.setSeed(rc.getRoundNum() + rc.getID());
    }

    public void step() throws GameActionException {
        previousLocation = (rc.getLocation().equals(currentLocation)) ? previousLocation : currentLocation;
        currentLocation = rc.getLocation();
    }

    protected void move() throws GameActionException {
        if (nextDirection == null) { calculateNextDirection(); }
        if (rc.canMove(nextDirection)) { rc.move(nextDirection); }
        nextDirection = null;
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

    protected void selectRandomTarget() throws GameActionException {
        target = new MapLocation(RNG.nextInt(rc.getMapWidth()), RNG.nextInt(rc.getMapHeight()));
    }

    protected boolean isThereBuildingAt(MapLocation location) throws GameActionException {
        return rc.canSenseRobotAtLocation(location) && rc.senseRobotAtLocation(location).getType().isBuilding();
    }

    protected boolean isThereRobotTypeAt(MapLocation location, RobotType type) throws GameActionException {
        return rc.canSenseRobotAtLocation(location) && rc.senseRobotAtLocation(location).getType().equals(type);
    }

    protected boolean isRobotOnSameTeam(RobotInfo robot) {
        return robot.getTeam().equals(rc.getTeam());
    }

    protected MapLocation bestLocationNextTo(MapLocation location) throws GameActionException {
        MapLocation bestNeighbor = null;
        MapLocation[] neighbors = rc.getAllLocationsWithinRadiusSquared(location, 2);

        int minRubble = INF;
        int minDistance = INF;

        for (MapLocation neighbor : neighbors) {
            if (rc.canSenseRobotAtLocation(neighbor) && !currentLocation.equals(neighbor)) { continue; }

            int rubble = rc.senseRubble(neighbor);
            int distance = currentLocation.distanceSquaredTo(neighbor);

            if (rubble < minRubble) { minRubble = rubble; minDistance = INF; bestNeighbor = neighbor; }
            if (rubble == minRubble && distance < minDistance) { minRubble = rubble; minDistance = distance; bestNeighbor = neighbor; }
        }

        return bestNeighbor;
    }

    private void calculateNextDirection() throws GameActionException {
        nextDirection = Direction.CENTER;
        if (target == null) { return; }

        double bestValue = INF;

        int originalDistance = currentLocation.distanceSquaredTo(target);

        for(Direction direction : directions) {
            MapLocation nextLocation = rc.adjacentLocation(direction);

            // Check if moving in this direction is possible
            if(!rc.onTheMap(nextLocation) || rc.canSenseRobotAtLocation(nextLocation)) { continue; }

            // Don't backtrack
            if (nextLocation.equals(previousLocation)) { continue; }

            int distance = nextLocation.distanceSquaredTo(target);

            if (distance == 0) { nextDirection = direction; break; }

            double value = Math.sqrt(distance) + (double)rc.senseRubble(nextLocation) / 10.0;

            // If moving in this diection increases distance, add aditional penatly
            if (distance > originalDistance) { value += Math.sqrt(distance - originalDistance) * 2; }

            if (value < bestValue) { bestValue = value; nextDirection = direction; }
        }
    }
}
