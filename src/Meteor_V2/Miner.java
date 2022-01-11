package Meteor_V2;

import battlecode.common.*;

public strictfp class Miner extends Droid {

    public Miner(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();
        updateTarget();

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType() == RobotType.SOLDIER && robot.getTeam() != rc.getTeam()) {
                updateTargetForEvasion(robot.location);
                break;
            }
        }

        minimap.reportNearbyEnemies(nearbyRobots);

        for (Direction direction : Direction.allDirections()) {
            MapLocation location = rc.adjacentLocation(direction);
            if (rc.canSenseLocation(location)) {
                int leadCount = rc.senseLead(location);
                while (rc.isActionReady() && leadCount > 1) { rc.mineLead(location); leadCount--; }
            }
        }

        move();

        super.draw();
    }

    private void updateTarget() throws GameActionException {
        if (currentLocation.equals(target)) target = null;
        if (target != null && isThereFriendlyMiner(target)) target = null;
        if (target != null && rc.canSenseLocation(target) && rc.senseRubble(target) <= 1) target = null;

        /*int maxValue = 0;
        if (target != null && currentLocation.distanceSquaredTo(target) <= 13) maxValue = getValue(target);
        MapLocation[] leadLocations = rc.senseNearbyLocationsWithLead(13);

        // Loop through all lead locations and find the closest one
        for (MapLocation location : leadLocations) {
            if (Clock.getBytecodesLeft() < 3000) break;
            int value = getValue(location);
            if (value > maxValue) { maxValue = value; target = location; }
        }*/

        int minRubble = INF;
        if (target != null && currentLocation.distanceSquaredTo(target) <= 20) minRubble = rc.senseRubble(target);
        MapLocation[] leadLocations = rc.senseNearbyLocationsWithLead(20, 2);

        for(MapLocation location : leadLocations) {
            int rubble = rc.senseRubble(location);
            if (rubble < minRubble) {
                minRubble = rubble;
                target = location;
            }
        }

        if (target == null) {
            selectRandomTarget();
        }
    }

    private boolean isThereFriendlyMiner(MapLocation location) throws GameActionException {
        for(Direction direction : Direction.allDirections()) {
            MapLocation adjacentLocation = location.add(direction);
            if(!rc.canSenseLocation(adjacentLocation) || !rc.canSenseRobotAtLocation(adjacentLocation)) continue;
            RobotInfo robot = rc.senseRobotAtLocation(adjacentLocation);
            if (robot.getID() != rc.getID() && robot.getType() == RobotType.MINER && robot.getTeam() == rc.getTeam())
                return true;
        }
        return false;
    }

    private int getValue(MapLocation location) throws GameActionException {
        int leadCount = 0;
        for (Direction direction : Direction.allDirections()) {
            MapLocation adjacentLocation = location.add(direction);
            if (rc.canSenseLocation(adjacentLocation)) {
                leadCount += rc.senseLead(adjacentLocation);

                if (rc.canSenseRobotAtLocation(adjacentLocation)) {
                    RobotInfo robot = rc.senseRobotAtLocation(adjacentLocation);
                    if (robot.getID() != rc.getID() && robot.getType() == RobotType.MINER && robot.getTeam() == rc.getTeam())
                        leadCount -= 10000;
                }
            }
        }
        if (leadCount < 4) return -INF;
        int r = 1 + rc.senseRubble(location) / 10;
        return leadCount / r;
    }
}
