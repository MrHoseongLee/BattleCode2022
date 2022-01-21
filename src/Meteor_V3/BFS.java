package Meteor_V3;

import battlecode.common.*;

public abstract class BFS {

    protected final RobotController rc;
    protected MapLocation currentLocation;

    public BFS (RobotController rc) {
        this.rc = rc;
    }

    public void move(MapLocation target) throws GameActionException { move(target, 100); }

    public void move(MapLocation target, int rubbleTolerance) throws GameActionException {
        currentLocation = rc.getLocation();

        if (!rc.isMovementReady()) { return; }
        if (currentLocation.equals(target)) { return; }

        Direction direction = getBestDirection(target);

        if (direction == Direction.CENTER) { return; }

        if (direction != null && rc.canMove(direction)) {
            if (rc.senseRubble(rc.adjacentLocation(direction)) <= rc.senseRubble(currentLocation) + rubbleTolerance) {
                rc.move(direction);
            }
        }
    }

    protected abstract Direction getBestDirection(MapLocation target) throws GameActionException;
}
