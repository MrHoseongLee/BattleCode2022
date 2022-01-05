package Meteor_V1;

import battlecode.common.*;

public strictfp class Miner extends Droid {

    private int ID = -1;
    private int offset = 0;

    private final int signalOffset = 62;

    private int previousMinerSignal = 0;

    private boolean isScouting = false;

    public Miner(RobotController rc) throws GameActionException {
        super(rc);
        previousMinerSignal = rc.readSharedArray(signalOffset) << 16 + rc.readSharedArray(signalOffset + 1);
    }

    public void step() throws GameActionException {
        super.step();

        if (ID == 0) { ID = getID(); if (ID > 16) { offset = 1; } }
        if (ID <  0) { ID += 1; }

        signal();

        if (rc.senseLead(currentLocation) + rc.senseGold(currentLocation) > 0) {
            while (rc.canMineGold(currentLocation)) { rc.mineGold(currentLocation); }
            while (rc.canMineLead(currentLocation)) { rc.mineLead(currentLocation); }
            return;
        }

        // Another miner is already arrived
        if (target != null && rc.canSenseRobotAtLocation(target) && rc.senseRobotAtLocation(target).getType() == RobotType.MINER) {
            target = null;
        }

        if (target == null || isScouting) { FindTarget(); }

        super.move();
    }

    private int getID() throws GameActionException {
        return 1 + Integer.numberOfLeadingZeros(~((rc.readSharedArray(signalOffset) << 16 + rc.readSharedArray(signalOffset + 1)) ^ previousMinerSignal));
    }

    private void signal() throws GameActionException {
        if (ID <= 0 || ID > 32) { return; }
        rc.writeSharedArray(signalOffset + offset, rc.readSharedArray(signalOffset + offset) ^ ((1 << (16 * (offset + 1) - ID))));
    }

    private void FindTarget() throws GameActionException {
        int minDistance = INF;

        MapLocation[] locations = rc.getAllLocationsWithinRadiusSquared(currentLocation, 20);

        for (MapLocation location : locations) {
            if (!rc.canSenseRobotAtLocation(location) && rc.senseGold(location) + rc.senseLead(location) > 0) {
                isScouting = false;
                int distance = currentLocation.distanceSquaredTo(location);
                if (distance < minDistance) {
                    minDistance = distance;
                    target = location;
                }
            }
        }

        isScouting = (minDistance == INF);
    }
}
