package Meteor_V3;

import battlecode.common.*;

public strictfp class Building extends Robot {
    public Building(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();
    }

    protected void move() throws GameActionException {
        if (!rc.isMovementReady() || currentLocation.equals(target)) { return; }
        bfs.move(target);
    }

    protected void updateTargetForEvasion(RobotInfo[] nearbyEnemies) throws GameActionException {
        int maxDistance = 0;
        int rubble = rc.senseRubble(currentLocation);
        for (RobotInfo robot : nearbyEnemies) {
            if (isDangerous(robot.type)) {
                maxDistance += currentLocation.distanceSquaredTo(robot.location);
            }
        }
        target = currentLocation;

        for (Direction direction : directions) {
            MapLocation location = rc.adjacentLocation(direction);

            if (!rc.onTheMap(location) || rc.canSenseRobotAtLocation(location) || rc.senseRubble(location) > rubble + 10) continue;

            int distance = 0;
            for (RobotInfo robot : nearbyEnemies) {
                if (isDangerous(robot.type)) {
                    distance += location.distanceSquaredTo(robot.location);
                }
            }

            if (distance > maxDistance) {
                maxDistance = distance;
                target = location;
            }
        }
    }

}
