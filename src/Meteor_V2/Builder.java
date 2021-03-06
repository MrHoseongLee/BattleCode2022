package Meteor_V2;

import battlecode.common.*;

public strictfp class Builder extends Droid {

    private MapLocation buildTarget = null;
    private MapLocation repairTarget = null;

    public Builder(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        // Repair if possible
        updateRepairTarget();
        if (repairTarget != null) {
            if (repairTarget.isWithinDistanceSquared(currentLocation, RobotType.BUILDER.actionRadiusSquared)) {
                if (rc.canRepair(repairTarget)) {
                    rc.repair(repairTarget); return;
                }
            } else {
                target = repairTarget;
                super.move();
                return;
            }
        }

        updateBuildTarget();

        if (buildTarget != null && canSense3by3At(buildTarget)) {
            super.setTarget(bestLocationNextTo(buildTarget)); 
        }

        if (buildTarget == null) { selectRandomTarget(); }

        if (currentLocation.equals(target)) {
            Direction direction = currentLocation.directionTo(buildTarget);

            if (rc.canBuildRobot(RobotType.WATCHTOWER, direction)) {
                rc.buildRobot(RobotType.WATCHTOWER, direction);
                // rc.writeSharedArray(Idx.watchTowerCount, rc.readSharedArray(Idx.watchTowerCount) + 1);
                target = null; buildTarget = null;
                repairTarget = rc.adjacentLocation(direction);
            }

            return;
        }

        super.move();
    }

    protected void updateBuildTarget() throws GameActionException {
        int minDistance = INF; buildTarget = null; target = null;
        for (MapLocation location : rc.getAllLocationsWithinRadiusSquared(currentLocation, RobotType.BUILDER.visionRadiusSquared)) {
            if (isThereBuildingAt(location)) { continue; }
            if (location.x % 2 == parentArchonLocation.x % 2 && location.y % 2 == parentArchonIdx % 2) {
                int distance = currentLocation.distanceSquaredTo(location);
                if (distance < minDistance) { minDistance = distance; buildTarget = location; }
            }
        }
        target = buildTarget;
    }

    /*
    protected void selectRandomTarget() throws GameActionException {
        int t = Math.max((int)(Math.sqrt(rc.readSharedArray(Idx.watchTowerCount)) * 2), 5);
        int x1 = Math.max(parentArchonLocation.x - t, 0);
        int y1 = Math.max(parentArchonLocation.y - t, 0);
        int x2 = Math.min(parentArchonLocation.x + t, rc.getMapWidth() - 1);
        int y2 = Math.min(parentArchonLocation.y + t, rc.getMapHeight() - 1);
        int x, y;
        do {
            x = RNG.nextInt(x2 - x1 + 1) + x1;
        } while (x % 2 != parentArchonLocation.x % 2);
        do {
            y = RNG.nextInt(y2 - y1 + 1) + y1;
        } while (y % 2 != parentArchonLocation.y % 2);
        buildTarget = new MapLocation(x, y);
        target = buildTarget;
    }
    */

    protected MapLocation bestLocationNextTo(MapLocation location) throws GameActionException {
        MapLocation bestNeighbor = null;

        int minRubble = INF;
        int minDistance = INF;

        for (Direction direction : directions) {
            MapLocation neighbor = location.add(direction);
            if (!rc.onTheMap(neighbor)) { continue; }
            if (rc.canSenseRobotAtLocation(neighbor) && !currentLocation.equals(neighbor)) { continue; }

            int rubble = rc.senseRubble(neighbor);
            int distance = currentLocation.distanceSquaredTo(neighbor);

            if (rubble < minRubble) { minRubble = rubble; minDistance = INF; bestNeighbor = neighbor; }
            if (rubble == minRubble && distance < minDistance) { minRubble = rubble; minDistance = distance; bestNeighbor = neighbor; }
        }

        return bestNeighbor;
    }

    private void updateRepairTarget() {
        int minHealth = -INF;
        repairTarget = null;

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots(RobotType.MINER.visionRadiusSquared, rc.getTeam());

        for (RobotInfo robot : nearbyRobots) {
            if (!robot.getType().isBuilding()) { continue; }
            if (robot.getHealth() == robot.getType().getMaxHealth(1)) continue;

            if (robot.getMode() == RobotMode.PROTOTYPE) { repairTarget = robot.location; return; }

            int health = robot.getHealth();

            if (health < minHealth) { minHealth = health; repairTarget = robot.location; }
        }
    }
}
