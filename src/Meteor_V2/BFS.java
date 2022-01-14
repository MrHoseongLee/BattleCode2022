package Meteor_V2;

import battlecode.common.*;

public abstract class BFS {

    protected final RobotController rc;

    public BFS (RobotController rc) {
        this.rc = rc;
    }

    void move(MapLocation target) throws GameActionException { move(target, 100); }

    void move(MapLocation target, int rubbleTolerance) throws GameActionException {
        MapLocation currentLocation = rc.getLocation();

        if (!rc.isMovementReady()) { return; }
        if (currentLocation.equals(target)) { return; }

        Direction direction = getBestDir(target);
        if (direction != null && rc.canMove(direction) && rc.senseRubble(rc.adjacentLocation(direction)) <= rc.senseRubble(currentLocation) + rubbleTolerance) {
            rc.move(direction);
        }
    }

    protected abstract Direction getBestDir(MapLocation target) throws GameActionException;
}
