package Meteor_V2;

import battlecode.common.*;

public strictfp class Miner extends Droid {

    private MapLocation miningTarget = null;

    public Miner(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();
        updateTarget();

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() == rc.getTeam()) continue;
            if (robot.getType() != RobotType.SOLDIER) continue;

            nextDirection = robot.location.directionTo(currentLocation);
            break;
        }

        checkEnemyArchon();

        // Mine only lead for now
        if (currentLocation.equals(target) && miningTarget != null) {
            int leadCount = rc.senseLead(miningTarget);
            while (rc.isActionReady() && leadCount > 1) { rc.mineLead(miningTarget); leadCount--; }

            for (Direction direction : Direction.allDirections()) {
                MapLocation location = rc.adjacentLocation(direction);
                if (rc.canSenseLocation(location)) {
                    leadCount = rc.senseLead(location);
                    while (rc.isActionReady() && leadCount > 1) { rc.mineLead(location); leadCount--; }
                }
            }

            return;
        }

        super.move();
        super.draw();
    }

    protected void setTarget(MapLocation target) {
        this.target = target;
        miningTarget = target;
    }

    private void updateTarget() throws GameActionException {
        // If tile as no lead find another miningTarget
        if (miningTarget != null && rc.canSenseLocation(miningTarget) && rc.senseLead(miningTarget) <= 1) { 
            setTarget(null);
        }

        if (currentLocation.equals(target) && miningTarget == null) {
            target = null;
        }

        int maxValue = (miningTarget == null) ? -INF : -currentLocation.distanceSquaredTo(miningTarget);
        MapLocation[] leadLocations = rc.senseNearbyLocationsWithLead(20);

        // Loop through all lead locations and find the closest one
        for (MapLocation location : leadLocations) {
            int leadCount = rc.senseLead(location);
            if (leadCount < 5) { continue; }
            // int value = leadCount - (int)(Math.sqrt(currentLocation.distanceSquaredTo(location)) * 10);
            int value = -currentLocation.distanceSquaredTo(location);
            if (value > maxValue) { maxValue = value; setTarget(location); }
        }

        if (miningTarget != null && currentLocation.distanceSquaredTo(miningTarget) < 22 - 4 * Math.sqrt(10)) {
            target = bestLocationNextTo(miningTarget);
        }

        if (target == null) {
            miningTarget = null;
            selectRandomTarget();
        }
    }
}
