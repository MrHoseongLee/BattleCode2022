package Meteor_V2;

import battlecode.common.*;

public strictfp class Miner extends Droid {

    private MapLocation closestEnemyArchonLocation = null;

    public Miner(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        RobotInfo[] nearbyEnemies = rc.senseNearbyRobots(-1, team.opponent());

        minimap.reportNearbyEnemies(nearbyEnemies);

        if (rc.isMovementReady()) {
            int minDistance = INF; MapLocation closestEnemySolierLocation = null;
            for (RobotInfo robot : nearbyEnemies) {
                if (robot.getType() == RobotType.SOLDIER) {
                    int distance = currentLocation.distanceSquaredTo(robot.getLocation());
                    if (distance < minDistance) { minDistance = distance; closestEnemySolierLocation = robot.location; }
                }
            }
            if (closestEnemySolierLocation != null) { updateTargetForEvasion(closestEnemySolierLocation); move(); }
        }

        if (rc.isActionReady()) {
            updateClosestEnemyArchonLocation();
            mineLead();
        }

        if (rc.isMovementReady()) {
            updateTarget();
            move();
        }

        checkForEnemyArchons();

        super.draw();
    }

    protected MapLocation bestLocationNextTo(MapLocation location) throws GameActionException {
        MapLocation bestNeighbor = location;

        int maxLead = -INF;
        int minRubble = INF;

        for (MapLocation neighbor: rc.getAllLocationsWithinRadiusSquared(location, 2)) {
            if (rc.canSenseRobotAtLocation(neighbor) && !currentLocation.equals(neighbor)) { continue; }

            int lead = 0;
            for (MapLocation leadLocations : rc.senseNearbyLocationsWithLead(2, 2)) { 
                lead += rc.senseLead(leadLocations); 
            }

            int rubble = rc.senseRubble(neighbor);

            if (rubble < minRubble || (rubble == minRubble && lead > maxLead)) {
                maxLead = lead;
                minRubble = rubble;
                bestNeighbor = neighbor;
            }
        }

        return bestNeighbor;
    }

    private void mineLead() throws GameActionException {
        for (Direction direction : Direction.allDirections()) {
            MapLocation location = rc.adjacentLocation(direction);
            if (rc.canSenseLocation(location)) {
                int leadCount = rc.senseLead(location);
                if (leadCount > 0) {
                    if (isScorchedEarthBeneficial(location)) {
                        while (rc.isActionReady() && leadCount > 0) { rc.mineLead(location); leadCount--; }
                    } else {
                        while (rc.isActionReady() && leadCount > 1) { rc.mineLead(location); leadCount--; }
                    }
                }
            }
        }
    }

    private void updateTarget() throws GameActionException {
        if (currentLocation.equals(target)) { target = null; }

        int minDistance = INF;
        MapLocation[] leadLocations = rc.senseNearbyLocationsWithLead(-1, 2);

        // Loop through all lead locations and find the best one
        for (MapLocation location : leadLocations) {
            int distance = distanceTo(location);
            if (distance < minDistance) { minDistance = distance; target = location; }
        }

        if (target == null) { selectRandomTarget(); } 
        else if (minDistance != INF && currentLocation.distanceSquaredTo(target) <= 5) { target = bestLocationNextTo(target); }

    }

    private void updateClosestEnemyArchonLocation() throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);
        int minDistance = INF;

        for (int i = 0; i < n * 3; ++i) {
            int code = rc.readSharedArray(i + Idx.enemyArchonLocationOffset);

            int state = decodeID(code);
            MapLocation location = decodeLocation(code);

            if (state == 1) { 
                int distance = currentLocation.distanceSquaredTo(location);
                if (distance < minDistance) { minDistance = distance; closestEnemyArchonLocation = location; }
            }
        }
    }

    private boolean isScorchedEarthBeneficial(MapLocation location) {
        if (closestEnemyArchonLocation == null) { return false; }
        return location.distanceSquaredTo(parentArchonLocation) > location.distanceSquaredTo(closestEnemyArchonLocation);
    }

   private int distanceTo(MapLocation location) {
        return Math.max(Math.abs(location.x - currentLocation.x), Math.abs(location.y - currentLocation.y));
    }

}
