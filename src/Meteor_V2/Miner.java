package Meteor_V2;

import battlecode.common.*;

public strictfp class Miner extends Droid {

    private enum Mode { 
        Scout, // Scout for more resources
        Drill, // Mine every block around and don't move
        Evade, // Try to evade enemy soldier/watch tower
    };

    private Mode previousMode = Mode.Scout;
    private Mode currentMode = Mode.Scout;

    public Miner(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();

        currentMode = previousMode;

        for (RobotInfo robot : nearbyRobots) {
            if (isRobotOnSameTeam(robot)) continue;
            if (robot.getType() == RobotType.SOLDIER || robot.getType() == RobotType.WATCHTOWER) { 
                previousMode = currentMode;
                currentMode = Mode.Evade; 
                break; 
            }
        }

        checkEnemyArchon();

        switch (currentMode) {
            case Scout:
                updateScoutTarget();
                break;

            case Drill:
                updateDrillTarget();
                break;

            case Evade:
                int maxValue = -INF; nextDirection = Direction.CENTER;

                for (Direction direction : directions) {

                    if (!rc.canMove(direction)) { continue; }

                    MapLocation location = rc.adjacentLocation(direction); int value = -rc.senseRubble(location);

                    for (RobotInfo robot : nearbyRobots) {
                        if (isRobotOnSameTeam(robot)) continue;
                        if (robot.getType() == RobotType.SOLDIER || robot.getType() == RobotType.WATCHTOWER) { 
                            value += 10 * Math.sqrt(robot.getLocation().distanceSquaredTo(location));
                        }
                    }

                    if (value > maxValue) { maxValue = value; nextDirection = direction; }

                }

                break;
        }

        super.move();
        mineLead();
        super.draw();
    }

    private void mineLead() throws GameActionException {
        for (Direction direction : Direction.allDirections()) {
            MapLocation location = rc.adjacentLocation(direction);
            if (rc.canSenseLocation(location)) {
                int leadCount = rc.senseLead(location);
                while (rc.isActionReady() && leadCount > 1) { rc.mineLead(location); leadCount--; }
            }
        }
    }

    private void updateScoutTarget() throws GameActionException {
        int maxValue = -INF; target = null;
        MapLocation[] leadLocations = rc.senseNearbyLocationsWithLead(20);

        // Loop through all lead locations and find the closest one
        for (MapLocation location : leadLocations) {
            if (rc.senseLead(location) <= 1) { continue; }
            int value = -currentLocation.distanceSquaredTo(location);
            if (value > maxValue) { maxValue = value; setTarget(location); }
        }

        if (target != null && canSense3by3At(target)) { target = bestLocationNextTo(target); }

        if (target == null) { selectRandomTarget(); }
    }

    private void updateDrillTarget() throws GameActionException {
        int x = currentLocation.x; int y = currentLocation.y;

        if (x % 3 == 1 && y % 3 == 1 && accessibleLeadCountAt(currentLocation) > 3) { setTarget(currentLocation); return; }

        int minDistance = INF; target = null;

        for (MapLocation location : rc.getAllLocationsWithinRadiusSquared(currentLocation, 10)) {
            if (rc.canSenseRobotAtLocation(location)) { continue; }
            if (location.x % 3 != 1 || location.y % 3 != 1) { continue; }
            if (accessibleLeadCountAt(location) > 3) {
                int distance = currentLocation.distanceSquaredTo(location);
                if (minDistance > distance) { minDistance = distance; setTarget(location); }
            }
        }

        if (target == null) { selectRandomTarget(); }
    }

    private int accessibleLeadCountAt(MapLocation location) throws GameActionException {
        int count = 0;
        for (Direction direction : Direction.allDirections()) {
            MapLocation newLocation = location.add(direction);
            if (rc.onTheMap(newLocation) && rc.senseLead(newLocation) > 0) { count += 1; }
        }
        return count;
    }
}
