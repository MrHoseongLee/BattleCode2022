package Meteor_V1;

import battlecode.common.*;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Random;

public class Robot {

    /**
     * Node for the priority queue. For dijkstra.
     */
    static class Node {
        public int d;
        public MapLocation loc;

        public Node(int d, MapLocation loc) {
            this.d = d;
            this.loc = loc;
        }
    }

    /**
     * Weight Function for dijkstra
     */
    interface WeightFunction {
        int getWeight(MapLocation loc, int r) throws GameActionException;
    }


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

    protected Direction getNextDir(MapLocation target) throws GameActionException {
        int bestValue = INF;
        Direction bestDir = Direction.CENTER;
        int origDist = currentLocation.distanceSquaredTo(target);

        for(Direction dir : directions) {
            MapLocation loc = currentLocation.add(dir);
            if(!rc.canMove(dir)) continue;

            int dist = loc.distanceSquaredTo(target);
            int value = dist + valueFunction(loc);

            if(dist > origDist) value += 1000;
            if(dist == 0) value = -INF;

            if(value < bestValue) {
                bestValue = value;
                bestDir = dir;
            }
        }

        return bestDir;
    }

    protected int valueFunction(MapLocation loc) throws GameActionException {
        return -100 / (1 + rc.senseRubble(loc));
    }
}

