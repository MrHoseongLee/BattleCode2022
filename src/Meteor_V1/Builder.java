package Meteor_V1;

import battlecode.common.*;

public strictfp class Builder extends Droid {

    private enum Phase {
        BUILD, RETURN
    }

    private Phase phase = Phase.BUILD;
    private MapLocation archonLocation;
    private int minR = INF;

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

        switch (phase) {
            case BUILD: // Move to an appropriate location and build a watchtower

                // Change target if target is already occupied
                if(target != null && isThereBuilding(target))
                    resetPath();

                if(target == null) {
                    // Calculate target and path
                    updateMinR();
                    dijkstra((loc, r) -> r == minR ? -10000 : r);
                } else {
                    if(path.size() == 1) {
                        Direction dir = path.peek();
                        //if (rc.getTeamLeadAmount(rc.getTeam()) < 180) return;
                        if (rc.canBuildRobot(RobotType.WATCHTOWER, dir)) {
                            rc.buildRobot(RobotType.WATCHTOWER, dir);
                            resetPath();
                            phase = Phase.RETURN;
                        }
                    } else super.move();
                }
                break;

            case RETURN: // Return to the archon
                if(target == null) {
                    // Calculate target and path
                    dijkstra((loc, r) -> loc.isAdjacentTo(archonLocation) ? -10000 : r);
                } else {
                    super.move();
                    if(path.isEmpty()) {
                        resetPath();
                        phase = Phase.BUILD;
                    }
                }
                break;
        }


    }

    private void updateMinR() throws GameActionException {
        minR = INF;
        for (int dx = -4; dx <= 4; dx++) {
            for (int dy = -4; dy <= 4; dy++) {
                MapLocation loc = new MapLocation(currentLocation.x + dx, currentLocation.y + dy);
                if(!rc.canSenseLocation(loc) || isThereBuilding(loc)) continue;
                int r = (1 + rc.senseRubble(loc) / 10);
                minR = Math.min(minR, r);
            }
        }
    }

    private boolean isThereBuilding(MapLocation loc) throws GameActionException {
        return rc.canSenseRobotAtLocation(loc) && rc.senseRobotAtLocation(loc).getType().isBuilding();
    }
}
