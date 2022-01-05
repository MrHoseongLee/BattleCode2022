package Meteor_V1;

import battlecode.common.*;

public strictfp class Builder extends Droid {

    private enum Phase { BUILD, RETURN }

    private Phase phase = Phase.BUILD;
    private MapLocation archonLocation;

    public Builder(RobotController rc) throws GameActionException {
        super(rc);

        for (Direction direction : directions) {
            MapLocation location = currentLocation.add(direction);
            if (rc.canSenseRobotAtLocation(location) && rc.senseRobotAtLocation(location).getType() == RobotType.ARCHON) {
                archonLocation = location;
                break;
            }
        }
    }

    public void step() throws GameActionException {
        super.step();

        switch (phase) {
            case BUILD: // Move to an appropriate location and build a watchtower

                // Change target if target is already occupied
                if (target != null && rc.canSenseLocation(target) && isThereBuilding(target)) { target = null; }

                if (target == null) { FindTarget(); }

                if (currentLocation.isAdjacentTo(target)) {
                    Direction direction = currentLocation.directionTo(target);
                    if (rc.canBuildRobot(RobotType.WATCHTOWER, direction)) {
                        rc.buildRobot(RobotType.WATCHTOWER, direction);
                        target = null;
                        phase = Phase.RETURN;
                    }
                }

                break;

            case RETURN: // Return to the archon

                if(currentLocation.isAdjacentTo(archonLocation)) { phase = Phase.BUILD; }

                break;
        }

        Direction direction = getNextDir();
        if(rc.canMove(direction)) { rc.move(direction); }
    }

    private void FindTarget() throws GameActionException {
        int minRubble = INF;
        int minDistance = INF;

        MapLocation[] locations = rc.getAllLocationsWithinRadiusSquared(currentLocation, 20);

        for (MapLocation location : locations) {
            if (isThereBuilding(location)) { continue; }

            int rubble = rc.senseRubble(location);
            int distance = currentLocation.distanceSquaredTo(location);

            if (rubble < minRubble || (rubble == minRubble && distance < minDistance)) {
                minRubble = rubble;
                minDistance = distance;
                target = location;
            }
        }
    }

    private boolean isThereBuilding(MapLocation location) throws GameActionException {
        return rc.canSenseRobotAtLocation(location) && rc.senseRobotAtLocation(location).getType().isBuilding();
    }
}
