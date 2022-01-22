package Meteor_V3;

import battlecode.common.*;

public strictfp class Droid extends Robot {

    protected final int parentArchonIdx;
    protected MapLocation parentArchonLocation;

    protected boolean moved = false;
    protected boolean evading = false;

    public Droid(RobotController rc) throws GameActionException {
        super(rc);

        parentArchonLocation = getParentArchonLocation();
        parentArchonIdx = getParentArchonIdx();
    }

    public void step() throws GameActionException {
        super.step();

        moved = false;
        evading = false;
    }

    protected void move() throws GameActionException {
        if (moved || !rc.isMovementReady() || currentLocation.equals(target)) { return; }

        int rubbleTolerance = 100;
        if (evading) {
            rubbleTolerance = 10;
        } else if (minimap.getLevel(target) >= 2) {
            rubbleTolerance = Math.max((int)Math.sqrt(currentLocation.distanceSquaredTo(target)) * 5, 10);
        }

        bfs.move(target, rubbleTolerance);
        moved = true;
    }

    protected boolean canSense3by3At(MapLocation location) {
        return currentLocation.distanceSquaredTo(location) <= 10;
    }

    protected void updateTargetForEvasion(RobotInfo[] nearbyEnemies) throws GameActionException {
        if (evading) { return; }

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

            if (!rc.onTheMap(location) || rc.canSenseRobotAtLocation(location) || rc.senseRubble(location) > rubble + 10) { continue; }

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

        evading = true;
    }

    protected MapLocation bestLocationNextTo(MapLocation location) throws GameActionException {
        MapLocation bestNeighbor = null;
        MapLocation[] neighbors = rc.getAllLocationsWithinRadiusSquared(location, 2);

        int minRubble = INF;
        int minDistance = INF;

        for (MapLocation neighbor : neighbors) {
            if (rc.canSenseRobotAtLocation(neighbor) && !currentLocation.equals(neighbor)) { continue; }

            int rubble = rc.senseRubble(neighbor);
            int distance = currentLocation.distanceSquaredTo(neighbor);

            if (rubble < minRubble) { minRubble = rubble; minDistance = INF; bestNeighbor = neighbor; }
            if (rubble == minRubble && distance < minDistance) { minRubble = rubble; minDistance = distance; bestNeighbor = neighbor; }
        }

        return bestNeighbor;
    }

    protected void checkForEnemyArchons() throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);

        for (int i = 0; i < n * 3; ++i) {
            int code = rc.readSharedArray(i + Idx.enemyArchonLocationOffset);

            int state = decodeID(code);
            MapLocation location = decodeLocation(code);

            if (!rc.canSenseLocation(location)) { continue; }
            if (state >= 2) { continue; }

            if (isThereEnemyRobotTypeAt(location, RobotType.ARCHON)) {
                if (state == 0) {
                    rc.writeSharedArray(i + Idx.enemyArchonLocationOffset, encode(location, 1));
                    System.out.println("An enemy archon is at " + location);
                }
            }

            else {
                rc.writeSharedArray(i + Idx.enemyArchonLocationOffset, encode(location, state + 2));
            }
        }
    }

    protected void reportNearbyArchons(RobotInfo[] nearbyEnemies) throws GameActionException {
        int n = rc.readSharedArray(Idx.enemyArchonCount);

        // Report if enemy archon is moved from there or destroyed
        for (int i = 0; i < n; ++i) {
            int code = rc.readSharedArray(i + Idx.enemyArchonDataOffset);

            int ID = decodeID(code);
            MapLocation location = decodeLocation(code);

            if (location.x != 60 && rc.canSenseLocation(location) && !isThereRobotTypeAt(location, RobotType.ARCHON)) {
                rc.writeSharedArray(i + Idx.enemyArchonDataOffset, encode(new MapLocation(60, 0), ID));
            }
        }

        // Report if enemy archon is moved to there or discovered
        for (RobotInfo robot : nearbyEnemies) {
            if (robot.type != RobotType.ARCHON) { continue; }

            int idx = getEnemyArchonIdx(robot.ID);

            if (idx == n) { n += 1; }
            rc.writeSharedArray(idx + Idx.enemyArchonDataOffset, encode(robot.location, robot.ID));
        }

        rc.writeSharedArray(Idx.enemyArchonCount, n);
    }

    private MapLocation getParentArchonLocation() throws GameActionException {
        for (Direction direction : directions) {
            MapLocation location = rc.adjacentLocation(direction);
            if (isThereRobotTypeAt(location, RobotType.ARCHON)) { return location; }
        }

        rc.disintegrate();
        return null;
    }

    private int getParentArchonIdx() throws GameActionException {
        int code = encode(parentArchonLocation, 0) & 0xFFF;

        for (int i = 0; i < rc.readSharedArray(Idx.teamArchonCount); ++i) {
            if ((rc.readSharedArray(i + Idx.teamArchonDataOffset) & 0xFFF) == code) { return i; }
        }

        return -1;
    }

    private int getEnemyArchonIdx(int ID) throws GameActionException {
        int n = rc.readSharedArray(Idx.enemyArchonCount);

        for (int i = 0; i < n; ++i) {
            int code = rc.readSharedArray(i + Idx.enemyArchonDataOffset);

            if (decodeID(code) == ID) { return i; }
        }

        return n;
    }

    protected MapLocation getClosestTeamArchonLocation() throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);
        int minDistance = INF;
        MapLocation closest = null;

        for (int i = 0; i < n; ++i) {
            MapLocation location = decodeLocation(rc.readSharedArray(i + Idx.teamArchonDataOffset));
            if(location.x == 60) continue;
            int distance = currentLocation.distanceSquaredTo(location);

            if (distance < minDistance) {
                minDistance = distance;
                closest = location;
            }
        }

        return closest;
    }
}
