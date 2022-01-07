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
        RNG.setSeed(rc.readSharedArray(18));
    }

    public void step() throws GameActionException {
        super.step();

        if (ID == 0) { ID = getID(); if (ID > 16) { offset = 1; } }
        if (ID <  0) { ID += 1; }

        signal();

        for (Direction direction : Direction.allDirections()) {
            MapLocation loc = currentLocation.add(direction);
            if (rc.canSenseLocation(loc) && rc.senseLead(loc) > 1) {
                while (rc.canMineLead(loc) && rc.senseLead(loc) > 1) { rc.mineLead(loc); }
            }
        }

        /*if (rc.senseLead(currentLocation) > 1) {
            while (rc.canMineLead(currentLocation) && rc.senseLead(currentLocation) > 1) { rc.mineLead(currentLocation); }
            return;
        }*/

        // Another miner is already arrived
        if (target != null && rc.canSenseRobotAtLocation(target) && rc.senseRobotAtLocation(target).getType() == RobotType.MINER) {
            target = null;
        }

        if (target == null || isScouting) { findTarget(); }

        if (target != null && target.equals(currentLocation)) target = null;

        if (target == null) { selectRandomTarget(); }

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();
        Team opponent = rc.getTeam().opponent();

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() != opponent) continue;
            if (robot.getType() != RobotType.SOLDIER) continue;

            nextDirection = robot.location.directionTo(currentLocation);
            break;
        }

        recordEnemyArchon(nearbyRobots);

        super.move();

        super.draw();

    }

    private int getID() throws GameActionException {
        return 1 + Integer.numberOfLeadingZeros(~((rc.readSharedArray(signalOffset) << 16 + rc.readSharedArray(signalOffset + 1)) ^ previousMinerSignal));
    }

    private void signal() throws GameActionException {
        if (ID <= 0 || ID > 32) { return; }
        rc.writeSharedArray(signalOffset + offset, rc.readSharedArray(signalOffset + offset) ^ ((1 << (16 * (offset + 1) - ID))));
    }

    private void findTarget() throws GameActionException {
        int minDistance = INF;

        MapLocation[] locations = rc.getAllLocationsWithinRadiusSquared(currentLocation, 20);

        for (MapLocation location : locations) {
            if (!rc.canSenseRobotAtLocation(location) && rc.senseLead(location) > 1) {
                isScouting = false;
                int r = 1 + rc.senseRubble(location) / 10;
                //int distance = currentLocation.distanceSquaredTo(location) * r;
                int distance = -rc.senseLead(location) * 10 / r;
                if (distance < minDistance) {
                    minDistance = distance;
                    setTarget(location);
                }
            }
        }

        isScouting = (minDistance == INF);
    }
}
