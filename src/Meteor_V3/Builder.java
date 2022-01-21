package Meteor_V3;

import battlecode.common.*;

public strictfp class Builder extends Droid {

    private boolean dead = false;
    private MapLocation buildTarget = null;
    private MapLocation repairTarget = null;

    public Builder(RobotController rc) throws GameActionException {
        super(rc);
        rc.writeSharedArray(52, rc.readSharedArray(52) | (1 << parentArchonIdx));
    }

    public void step() throws GameActionException {
        super.step();

        if (!dead && rc.getHealth() <= 10) {
            dead = true;
            rc.writeSharedArray(52, rc.readSharedArray(52) & ~(1 << parentArchonIdx));
            rc.disintegrate();
        }

        // Repair if possible
        updateRepairTarget();
        if (repairTarget != null) {
            if (repairTarget.isWithinDistanceSquared(currentLocation, RobotType.BUILDER.actionRadiusSquared)) {
                if (rc.canRepair(repairTarget)) {
                    rc.repair(repairTarget); return;
                }
            } else {
                target = repairTarget;
                move();
                return;
            }
        }

        if (rc.readSharedArray(51) != 0 || rc.readSharedArray(50) != parentArchonIdx) return;

        if (buildTarget == null) updateBuildTarget();

        if (canSense3by3At(buildTarget)) {
            target = bestLocationNextTo(buildTarget);
        }

        if (currentLocation.equals(target)) {
            Direction direction = currentLocation.directionTo(buildTarget);

            if (rc.canBuildRobot(RobotType.LABORATORY, direction)) {
                rc.buildRobot(RobotType.LABORATORY, direction);
                rc.writeSharedArray(51, 1);
                rc.writeSharedArray(50, getNextAliveTeamArchonIdx(parentArchonIdx));
                target = null; buildTarget = null;
                repairTarget = rc.adjacentLocation(direction);
            }

            return;
        }

        move();
    }

    protected void updateBuildTarget() throws GameActionException {
        int minRubble = INF;
        int minDistance = INF;
        buildTarget = null; target = null;
        for (MapLocation location : rc.getAllLocationsWithinRadiusSquared(currentLocation, RobotType.BUILDER.visionRadiusSquared)) {
            if (isThereBuildingAt(location)) { continue; }

            int rubble = rc.senseRubble(location);
            int distance = currentLocation.distanceSquaredTo(location);

            if (rubble < minRubble || (rubble == minRubble && distance < minDistance)) {
                minRubble = rubble;
                minDistance = distance;
                buildTarget = location;
            }
        }
        target = buildTarget;
    }

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
        int minHealth = INF;
        repairTarget = null;

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots(RobotType.BUILDER.visionRadiusSquared, team);

        for (RobotInfo robot : nearbyRobots) {
            if (!robot.getType().isBuilding()) { continue; }
            if (robot.getHealth() == robot.getType().getMaxHealth(1)) continue;

            if (robot.getMode() == RobotMode.PROTOTYPE) { repairTarget = robot.location; return; }

            int health = robot.getHealth();

            if (health < minHealth) { minHealth = health; repairTarget = robot.location; }
        }
    }
}
