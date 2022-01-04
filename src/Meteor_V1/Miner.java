package Meteor_V1;

import battlecode.common.*;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public strictfp class Miner extends Droid {

    /**
     * Weights of resources. For dijkstra.
     */
    private static final int leadWeight = -100;
    private static final int goldWeight = -500;

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

    private Direction defaultDir = null;  // If there is no resource in the vision radius, then move in defaultDir
    private MapLocation target = null;    // Location of the target resource
    private Stack<Direction> path = null; // Sequence of moves toward the target resource

    public Miner(RobotController rc) throws GameActionException {
        super(rc);
    }

    /**
     * Mine near resources. If not found, move straight.
     */
    public void step() throws GameActionException {
        super.step();

        // Mine here if possible
        if(rc.senseLead(me) + rc.senseGold(me) > 0) {
            while (rc.canMineGold(me)) {
                rc.mineGold(me);
            }
            while (rc.canMineLead(me)) {
                rc.mineLead(me);
            }
            return;
        }

        if(target == null) { // If target resource is not chosen
            if(!resourceExists()) { // If there is no resource, then move in defaultDir
                if(defaultDir == null)
                    defaultDir = directions[rng.nextInt(directions.length)];
                for(int i=0; i<8; ++i)
                    if(!rc.canMove(defaultDir))
                        defaultDir = defaultDir.rotateRight();
                if (rc.canMove(defaultDir)) {
                    rc.move(defaultDir);
                }
                return;
            }
            defaultDir = null;

            dijkstra(); // Search using dijkstra

        } else { // Move along the path
            if(path.isEmpty()) {
                target = null;
                path = null;
            } else {
                Direction dir = path.peek();
                if (rc.canMove(dir)) {
                    rc.move(dir);
                    path.pop();
                } else if(rc.canSenseRobotAtLocation(me.add(dir))) {
                    target = null;
                    path = null;
                }
            }
        }
    }

    /**
     * Run dijkstra to find the best resource to mine in the vision radius.
     * After found, update 'target' and 'path'.
     */
    private void dijkstra() throws GameActionException {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.d));
        int[][] dist = new int[9][9];
        Direction[][] from = new Direction[9][9];
        for(int i=0; i<9; ++i)
            for(int j=0; j<9; ++j)
                dist[i][j] = INF;

        final int x = me.x-4, y = me.y-4;
        MapLocation best = me;
        int bestd = 0;
        pq.add(new Node(0, me));
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
                int d = u.d
                        + 24 * r
                        + (rc.senseLead(loc) * leadWeight + rc.senseGold(loc) * goldWeight) / r;

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
        while(!best.equals(me)) {
            Direction dir = from[best.y - y][best.x - x];
            path.add(dir);
            best = best.subtract(dir);
            //System.out.println("cur = " + best);
        }
    }
}
