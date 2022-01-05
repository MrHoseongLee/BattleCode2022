package Meteor_V1;

import battlecode.common.*;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public strictfp class Miner extends Droid {

    private int ID = -1;
    private int previousMinerSignal = 0;

    /**
     * Weights of resources. For dijkstra.
     */
    private static final int leadWeight = -100;
    private static final int goldWeight = -500;


    public Miner(RobotController rc) throws GameActionException {
        super(rc);
        previousMinerSignal = rc.readSharedArray(62) << 16 + rc.readSharedArray(63);
    }

    /**
     * Mine near resources. If not found, move straight.
     */
    public void step() throws GameActionException {
        super.step();

        if (ID == 0) { ID = getID(); }
        if (ID <  0) { ID += 1; }

        signal();

        // Mine if possible
        if (rc.senseLead(currentLocation) + rc.senseGold(currentLocation) > 0) {
            while (rc.canMineGold(currentLocation)) { rc.mineGold(currentLocation); }
            while (rc.canMineLead(currentLocation)) { rc.mineLead(currentLocation); }
            return;
        }

        // Change target if another miner is already mining
        if(target != null && rc.canSenseRobotAtLocation(target))
            resetPath();

        if(target == null) {
            // Calculate target and path
            dijkstra((loc, r)
                    -> 20 * r
                    + (rc.senseLead(loc) * leadWeight + rc.senseGold(loc) * goldWeight) / r);
        } else {
            super.move();
        }
    }

    private int getID() throws GameActionException {
        return 1 + Integer.numberOfLeadingZeros(~((rc.readSharedArray(62) << 16 + rc.readSharedArray(63)) ^ previousMinerSignal));
    }

    private void signal() throws GameActionException {
        if (ID <= 0 || ID > 32) { return; }
        if (ID <= 16) {
            rc.writeSharedArray(62, rc.readSharedArray(62) ^ ((1 << 16) >> (ID)));
        } else {
            rc.writeSharedArray(63, rc.readSharedArray(63) ^ ((1 << 32) >> (ID)));
        }
    }

    /**
     * Check whether there is any resource in the vision radius(20) of this miner
     * @return true / false
     */
    private boolean resourceExists() throws GameActionException {
        for (int dx = -4; dx <= 4; dx++) {
            for (int dy = -4; dy <= 4; dy++) {
                MapLocation loc = new MapLocation(currentLocation.x + dx, currentLocation.y + dy);
                if(rc.canSenseLocation(loc) && !rc.canSenseRobotAtLocation(loc) && rc.senseLead(loc) + rc.senseLead(loc) > 0)
                    return true;
            }
        }
        return false;
    }
}
