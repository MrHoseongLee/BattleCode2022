package Meteor_V2;

import battlecode.common.*;

public abstract class BFS {

    protected final RobotController rc;

    public BFS (RobotController rc) {
        this.rc = rc;
    }

    public void move(MapLocation target) throws GameActionException { move(target, false); }

    public void move(MapLocation target, boolean avoidRubble) throws GameActionException {
        MapLocation currentLocation = rc.getLocation();

        if (!rc.isMovementReady()) { return; }
        if (rc.getLocation().equals(target)) { return; }

        Direction direction = getBestDir(target);
        System.out.println("HELLO");

        if (direction != null && rc.canMove(direction)) {
            if (!avoidRubble || rc.senseRubble(rc.adjacentLocation(direction)) < rc.senseRubble(currentLocation) + 5) {
                rc.move(direction);
            }
        }
    }

    protected abstract Direction getBestDir(MapLocation target) throws GameActionException;
}
