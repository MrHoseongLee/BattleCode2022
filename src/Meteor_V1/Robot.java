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

    protected void move() throws GameActionException {
        if (target == null) { return; }

        if (path.isEmpty()) {
            resetPath();
            return;
        }

        Direction dir = path.peek();
        if (rc.canMove(dir)) {
            rc.move(dir);
            path.pop();
        }
    }

    protected void resetPath() {
        target = null;
        path = null;
    }

    /**
     * Run dijkstra to find the best resource to mine in the vision radius.
     * After found, update 'target' and 'path'.
     */
    protected void dijkstra(WeightFunction W) throws GameActionException {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.d));
        int[][] dist = new int[9][9];
        Direction[][] from = new Direction[9][9];
        for(int i=0; i<9; ++i)
            for(int j=0; j<9; ++j)
                dist[i][j] = INF;

        final int x = currentLocation.x-4, y = currentLocation.y-4;
        MapLocation best = currentLocation;
        int bestd = 0;
        pq.add(new Node(0, currentLocation));
        dist[4][4] = 0;

        for (int t = 0; t < 100; ++t) {
            if(pq.isEmpty()) break;
            if(bestd < 0) break;
            Node u = pq.poll();

            if (dist[u.loc.y-y][u.loc.x-x] < u.d) continue;

            for (Direction dir : directions) {
                MapLocation loc = u.loc.add(dir);
                //if(dist.get(loc) != null) continue;
                if (!rc.canSenseLocation(loc)) continue;
                if (rc.canSenseRobotAtLocation(loc)) continue;

                int i = loc.y-y, j = loc.x-x;
                if(dist[i][j] != INF) continue; // not optimal, but needed since there are negative cycles

                int r = (1 + rc.senseRubble(loc) / 10);
                int d = u.d + W.getWeight(loc, r);

                if (d < dist[i][j]) {
                    pq.add(new Node(d, loc));
                    dist[i][j] = d;
                    from[i][j] = dir;
                    if(d < bestd) {
                        best = loc;
                        bestd = d;
                    }
                }
            }
        }

        target = best;
        //System.out.println("target = " + target);
        path = new Stack<>();
        while(!best.equals(currentLocation)) {
            Direction dir = from[best.y - y][best.x - x];
            path.add(dir);
            best = best.subtract(dir);
            //System.out.println("cur = " + best);
        }
    }
}

