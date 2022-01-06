package Meteor_V1;

import battlecode.common.*;

public strictfp class Builder extends Droid {

    private enum Phase { BUILD, RETURN }

    private Phase phase = Phase.BUILD;
    private final MapLocation archonLocation;

    public Builder(RobotController rc) throws GameActionException {
        super(rc);

        archonLocation = getParentArchonLocation();
    }

    public void step() throws GameActionException {
        super.step();

        Direction direction;
        switch (phase) {
            case BUILD: // Move to an appropriate location and build a watchtower
                // Change target if target is already occupied
                if (target != null && rc.canSenseLocation(target) && isThereBuilding(target)) { target = null; }

                if (target == null) { FindTarget(); }

                if (currentLocation.isAdjacentTo(target)) {
                    direction = currentLocation.directionTo(target);
                    if (rc.canBuildRobot(RobotType.WATCHTOWER, direction)) {
                        rc.buildRobot(RobotType.WATCHTOWER, direction);
                        target = archonLocation;
                        phase = Phase.RETURN;
                    }
                    return;
                }

                break;

            case RETURN: // Return to the archon

                if(currentLocation.isAdjacentTo(archonLocation)) { target = null; phase = Phase.BUILD; return; }

                break;
        }

        super.move();
    }

    private void FindTarget() throws GameActionException {
        int minRubble = INF;
        int minDistance = INF;

        MapLocation[] locations = rc.getAllLocationsWithinRadiusSquared(currentLocation, 20);

        for (MapLocation location : locations) {
            if (isThereBuilding(location)) { continue; }

            int rubble = rc.senseRubble(location) / 10;
            int distance = currentLocation.distanceSquaredTo(location);

            if (rubble < minRubble || (rubble == minRubble && distance < minDistance)) {
                minRubble = rubble;
                minDistance = distance;
                super.setTarget(location);
            }
        }
    }
}
