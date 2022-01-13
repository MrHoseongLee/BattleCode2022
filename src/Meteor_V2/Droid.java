package Meteor_V2;

import battlecode.common.*;

public strictfp class Droid extends Robot {

    protected final int parentArchonIdx;
    protected final MapLocation parentArchonLocation;

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
        if (moved || !rc.isMovementReady()) return;

        int rubbleTolerance = 100;
        if (evading) rubbleTolerance = 10;
        else if (minimap.getLevel(target) >= 3) rubbleTolerance = Math.max((int)Math.sqrt(currentLocation.distanceSquaredTo(target)) * 5, 20);

        bfs.move(target, rubbleTolerance);
        moved = true;
    }

    protected boolean canSense3by3At(MapLocation location) {
        return currentLocation.distanceSquaredTo(location) <= 10;
    }

    protected void updateTargetForEvasion(MapLocation location) throws GameActionException {
        int minRubble = INF;
        int currentDistance = currentLocation.distanceSquaredTo(location);
        for(Direction direction : directions) {
            MapLocation evadingLocation = currentLocation.add(direction);
            if(evadingLocation.x < 0 || evadingLocation.x >= rc.getMapWidth() || evadingLocation.y < 0 || evadingLocation.y >= rc.getMapHeight()) continue;
            if(rc.canSenseLocation(evadingLocation) && rc.canSenseRobotAtLocation(evadingLocation)) continue;
            if(evadingLocation.distanceSquaredTo(location) <= currentDistance) continue;
            int rubble = rc.senseRubble(evadingLocation);
            if(rubble < minRubble) {
                minRubble = rubble;
                target = evadingLocation;
                evading = true;
            }
        }
    }

    protected void checkEnemyArchon() throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);

        for (int i = 0; i < n * 3; ++i) {
            int code = rc.readSharedArray(i + Idx.enemyArchonLocationOffset);

            int state = decodeID(code);
            MapLocation location = decodeLocation(code);

            if (!rc.canSenseLocation(location)) { continue; }
            if (state >= 2) { continue; }

            if (isThereRobotTypeAt(location, RobotType.ARCHON) && !isRobotOnSameTeam(rc.senseRobotAtLocation(location))) {
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
}
