package Meteor_V3;

import battlecode.common.*;

public strictfp class Miner extends Droid {

    private MapLocation closestTeamArchonLocation = null;
    private MapLocation closestEnemyArchonLocation = null;

    private boolean isScouting = false;

    public Miner(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        RobotInfo[] nearbyEnemies = rc.senseNearbyRobots(-1, team.opponent());

        minimap.reportNearbyEnemies(nearbyEnemies);
        reportNearbyArchons(nearbyEnemies);

        // Evade enemy soldier
        if (rc.isMovementReady()) {
            for (RobotInfo robot : nearbyEnemies) {
                if (isDangerous(robot.getType())) {
                    updateTargetForEvasion(nearbyEnemies);
                    move();
                    break;
                }
            }
        }

        if (rc.isActionReady()) {
            updateClosestTeamArchonLocation();
            updateClosestEnemyArchonLocation();
            mineLead();
            mineGold();
        }

        if (rc.isMovementReady()) {
            updateTarget();
            move();
        }

        if (Clock.getBytecodesLeft() >= 2000) checkForEnemyArchons();

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

    private void mineGold() throws GameActionException {
        for (Direction direction : Direction.allDirections()) {
            MapLocation location = rc.adjacentLocation(direction);
            if (rc.canSenseLocation(location)) {
                int goldCount = rc.senseGold(location);
                if (goldCount > 0) {
                    while (rc.isActionReady() && goldCount > 0) { rc.mineGold(location); goldCount--; }
                }
            }
        }
    }

    private void updateTarget() throws GameActionException {
        if (!isScouting || currentLocation.equals(target)) { target = null; }

        int minDistance = INF;
        MapLocation[] leadLocations = rc.senseNearbyLocationsWithLead(-1, 2);
        MapLocation[] goldLocations = rc.senseNearbyLocationsWithGold(-1, 2);

        // Loop through all lead locations and find the best one
        for (MapLocation location : leadLocations) {
            int distance = distanceTo(location);
            if (distance < minDistance) { minDistance = distance; target = location; }
        }

        // Loop through all gold locations and find the best one
        for (MapLocation location : goldLocations) {
            int distance = distanceTo(location);
            if (distance < minDistance) { minDistance = distance; target = location; }
        }

        isScouting = minDistance == INF;

        if (target == null && isScouting) { selectRandomTarget(); }
        else if (minDistance != INF && currentLocation.distanceSquaredTo(target) <= 5) { target = bestLocationNextTo(target); }

    }

    private void updateClosestEnemyArchonLocation() throws GameActionException {
        int minDistance = INF;
        closestEnemyArchonLocation = null;

        for (int i = 0; i < rc.readSharedArray(Idx.enemyArchonCount); ++i) {
            int code = rc.readSharedArray(i + Idx.enemyArchonDataOffset);

            MapLocation location = decodeLocation(code);

            if (location.x == 60) { continue; }

            int distance = currentLocation.distanceSquaredTo(location);
            if (distance < minDistance) { minDistance = distance; closestEnemyArchonLocation = location; }
        }
    }

    private void updateClosestTeamArchonLocation() throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);
        int minDistance = INF;
        closestTeamArchonLocation = null;

        for (int i = 0; i < n; ++i) {
            int code = rc.readSharedArray(i + Idx.teamArchonDataOffset);

            if (code == 60) { continue; }

            MapLocation location = decodeLocation(code);

            int distance = currentLocation.distanceSquaredTo(location);
            if (distance < minDistance) { minDistance = distance; closestTeamArchonLocation = location; }
        }
    }

    private boolean isScorchedEarthBeneficial(MapLocation location) {
        if (closestTeamArchonLocation == null) { return false; }
        if (closestEnemyArchonLocation == null) { return false; }
        return location.distanceSquaredTo(closestTeamArchonLocation) > location.distanceSquaredTo(closestEnemyArchonLocation);
    }

   private int distanceTo(MapLocation location) {
        return Math.max(Math.abs(location.x - currentLocation.x), Math.abs(location.y - currentLocation.y));
    }

}
