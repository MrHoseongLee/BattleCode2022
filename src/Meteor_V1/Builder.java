package Meteor_V1;

import battlecode.common.*;

public strictfp class Builder extends Droid {

    private enum Phase {
        BUILD, RETURN
    }

    private Phase phase = Phase.BUILD;
    private MapLocation archonLocation;

    public Builder(RobotController rc) throws GameActionException {
        super(rc);

        for(Direction dir : directions) {
            MapLocation loc = currentLocation.add(dir);
            if(rc.canSenseRobotAtLocation(loc) && rc.senseRobotAtLocation(loc).getType() == RobotType.ARCHON) {
                archonLocation = loc;
                break;
            }
        }
    }

    public void step() throws GameActionException {
        super.step();

        Direction dir;
        switch (phase) {
            case BUILD: // Move to an appropriate location and build a watchtower

                // Change target if target is already occupied
                if(target != null && isThereBuilding(target))
                    target = null;

                if(target == null)
                    FindTarget();

                dir = getNextDir(target);
                if(currentLocation.add(dir).equals(target) && rc.canBuildRobot(RobotType.WATCHTOWER, dir)) {
                    rc.buildRobot(RobotType.WATCHTOWER, dir);
                    target = null;
                    phase = Phase.RETURN;
                    break;
                }
                if(rc.canMove(dir))
                    rc.move(dir);

                break;

            case RETURN: // Return to the archon
                if(currentLocation.isAdjacentTo(archonLocation)) {
                    phase = Phase.BUILD;
                    break;
                }

                dir = getNextDir(archonLocation);
                if(rc.canMove(dir))
                    rc.move(dir);

                break;
        }
    }

    private void FindTarget() throws GameActionException {
        int minR = INF;
        int targetDist = INF;
        for (int dx = -4; dx <= 4; dx++) {
            for (int dy = -4; dy <= 4; dy++) {
                MapLocation loc = new MapLocation(currentLocation.x + dx, currentLocation.y + dy);
                if(!rc.canSenseLocation(loc) || isThereBuilding(loc)) continue;
                int r = (1 + rc.senseRubble(loc) / 10);
                int dist = currentLocation.distanceSquaredTo(loc);
                if(r < minR || (r == minR && dist < targetDist)) {
                    minR = r;
                    target = loc;
                    targetDist = dist;
                }
            }
        }
    }

    private boolean isThereBuilding(MapLocation loc) throws GameActionException {
        return rc.canSenseRobotAtLocation(loc) && rc.senseRobotAtLocation(loc).getType().isBuilding();
    }
}
