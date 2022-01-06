package Meteor_V1;

import battlecode.common.*;

public strictfp class Miner extends Droid {

    private boolean isScouting = false;
    private boolean bestMiningLocationFound = false;
    private MapLocation miningTarget = null;

    public Miner(RobotController rc) throws GameActionException {
        super(rc);
        RNG.setSeed(rc.readSharedArray(18));
    }

    public void step() throws GameActionException {
        super.step();

        /*
        if (rc.senseLead(currentLocation) + rc.senseGold(currentLocation) > 0) {
            while (rc.canMineGold(currentLocation)) { rc.mineGold(currentLocation); }
            while (rc.canMineLead(currentLocation)) { rc.mineLead(currentLocation); }
            return;
        }
        */

        // If tile as no lead find another miningTarget
        if (miningTarget != null && rc.canSenseLocation(miningTarget) && rc.senseLead(miningTarget) <= 1) { 
            target = null; miningTarget = null; bestMiningLocationFound = false;
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

        // Mine only lead for now
        if (currentLocation.equals(target)) {
            int leadCount = rc.senseLead(miningTarget);
            while (rc.isActionReady() && leadCount > 1) { rc.mineLead(miningTarget); leadCount--; }
            return;
        }

        super.move();

        // Go to the tile which is adjacent to the target while having the least amount of rubble
        if (target != null && !bestMiningLocationFound && currentLocation.distanceSquaredTo(target) < 22 - 4 * Math.sqrt(10)) {
            MapLocation bestMiningLocation = bestLocationNextToLocation(target);
            if (bestMiningLocation != null) { 
                miningTarget = bestMiningLocation; 
                bestMiningLocationFound = true;
            }
        }

        super.draw();

    }

    protected void setTarget(MapLocation target) {
        super.setTarget(target);
        miningTarget = target;
    }

    private void findTarget() throws GameActionException {
        int minDistance = INF;

        MapLocation[] leadLocations = rc.senseNearbyLocationsWithLead(20);
        // MapLocation[] goldLocations = rc.senseNearbyLocationsWithGold(20);

        // Loop through all lead locations and find the closest one
        for (MapLocation location : leadLocations) {
            if (rc.senseLead(location) < 10) { continue; }
            int distance = currentLocation.distanceSquaredTo(location);
            if (distance < minDistance) { minDistance = distance; setTarget(location); }
        }

        if (target != null) {
            Direction direction = currentLocation.directionTo(target);
            MapLocation newLocation = target.add(direction);
            if (rc.canSenseLocation(newLocation)) { 
                super.setTarget(bestLocationNextToLocation(target)); 
                bestMiningLocationFound = true; 
            }
        }

        isScouting = (minDistance == INF);
    }
}
