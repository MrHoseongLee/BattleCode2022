package Meteor_V1;

import battlecode.common.*;

public strictfp class Miner extends Droid {

    private boolean isScouting = false;

    public Miner(RobotController rc) throws GameActionException {
        super(rc);
        RNG.setSeed(rc.readSharedArray(18));
    }

    public void step() throws GameActionException {
        super.step();

        if (rc.senseLead(currentLocation) + rc.senseGold(currentLocation) > 0) {
            while (rc.canMineGold(currentLocation)) { rc.mineGold(currentLocation); }
            while (rc.canMineLead(currentLocation)) { rc.mineLead(currentLocation); }
            return;
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
