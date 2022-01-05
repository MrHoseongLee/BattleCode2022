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

    public Miner(RobotController rc) throws GameActionException {
        super(rc);
    }

    /**
     * Mine near resources. If not found, move straight.
     */
    public void step() throws GameActionException {
        super.step();

        // Mine if possible
        if(rc.senseLead(currentLocation) + rc.senseGold(currentLocation) > 0) {
            while (rc.canMineGold(currentLocation)) { rc.mineGold(currentLocation); }
            while (rc.canMineLead(currentLocation)) { rc.mineLead(currentLocation); }
        }

        super.move();
    }

    /**
     * Check whether there is any resource in the vision radius(20) of this miner
     * @return true / false
     */
    private boolean resourceExists() throws GameActionException {
        for (int dx = -4; dx <= 4; dx++) {
            for (int dy = -4; dy <= 4; dy++) {
                MapLocation loc = new MapLocation(currentLocation.x + dx, currentLocation.y + dy);
                if(rc.canSenseLocation(loc) && rc.senseLead(loc) + rc.senseLead(loc) > 0)
                    return true;
            }
        }
        return false;
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
        while(!best.equals(currentLocation)) {
            Direction dir = from[best.y - y][best.x - x];
            path.add(dir);
            best = best.subtract(dir);
            //System.out.println("cur = " + best);
        }
    }
}
