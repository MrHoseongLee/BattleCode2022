package Meteor_V2;

import battlecode.common.*;

public abstract class BFS {

    RobotController rc;

    BFS(RobotController rc) {
        this.rc = rc;
    }

    void move(MapLocation target) throws GameActionException {
        move(target, false);
    }

    void move(MapLocation target, boolean avoidRubble) throws GameActionException {
        if(!rc.isMovementReady()) return;
        if(rc.getLocation().equals(target)) return;

        Direction dir = getBestDir(target);
        if(dir != null && rc.canMove(dir) && (!avoidRubble || rc.senseRubble(rc.getLocation().add(dir)) < rc.senseRubble(rc.getLocation()) + 5)) rc.move(dir);
    }
    abstract Direction getBestDir(MapLocation target) throws GameActionException;
}
