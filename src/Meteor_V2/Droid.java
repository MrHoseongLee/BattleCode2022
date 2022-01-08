package Meteor_V2;

import battlecode.common.*;

public strictfp class Droid extends Robot {

    protected final int parentArchonIdx;
    protected final MapLocation parentArchonLocation;

    public Droid(RobotController rc) throws GameActionException {
        super(rc);

        parentArchonLocation = getParentArchonLocation();
        parentArchonIdx = getParentArchonIdx();
    }

    public void step() throws GameActionException {
        super.step();
    }

   protected void checkEnemyArchon() throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);

        for (int i = 0; i < n * 3; ++i) {
            MapLocation location = decodeLocation(rc.readSharedArray(i + Idx.enemyArchonLocationOffset));
            if (location.x >= 60) continue;
            if (!rc.canSenseLocation(location)) continue;

            if (isThereRobotTypeAt(location, RobotType.ARCHON) && rc.senseRobotAtLocation(location).getTeam() != rc.getTeam()) {
                int count = rc.readSharedArray(Idx.enemyArchonCount);
                rc.writeSharedArray(count + Idx.enemyArchonDataOffset, encode(location, 0));
                rc.writeSharedArray(Idx.enemyArchonCount, count + 1);
                rc.writeSharedArray(i + Idx.enemyArchonLocationOffset, encode(60, 0));

                System.out.println((count+1) + "th Enemy archon is at " + location);
            } else {
                rc.writeSharedArray(i + Idx.enemyArchonLocationOffset, encode(61, 0));
            }
        }
    }

    protected MapLocation getClosestUndiscoveredEnemyArchon() throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);
        int minDistance = INF;
        MapLocation closestLocation = null;

        for (int i = 0; i < n * 3; ++i) {
            MapLocation location = decodeLocation(rc.readSharedArray(i + Idx.enemyArchonLocationOffset));
            if (location.x >= 60) continue;

            int distance = currentLocation.distanceSquaredTo(location);

            if (distance < minDistance) {
                minDistance = distance;
                closestLocation = location;
            }
        }

        return closestLocation;
    }

    protected int getEnemyArchonIdx(MapLocation location) throws GameActionException {
        int code = encode(location, 0) & 4095;

        for (int i = 0; i < rc.readSharedArray(Idx.enemyArchonCount); ++i) {
            if ((rc.readSharedArray(i + Idx.enemyArchonDataOffset) & 4095) == code) { return i; }
        }

        return -1;
    }

    protected int getEnemyArchonIdx(int ID) throws GameActionException {
        int code = ID >> 12;

        for (int i = 0; i < rc.readSharedArray(Idx.enemyArchonCount); ++i) {
            if (((rc.readSharedArray(i + Idx.enemyArchonDataOffset) << 12) & 8) == code) { return i; }
        }

        return -1;
    }

    private MapLocation getParentArchonLocation() throws GameActionException {
        for(Direction direction : directions) {
            MapLocation location = rc.adjacentLocation(direction);
            if (isThereRobotTypeAt(location, RobotType.ARCHON)) { return location; }
        }

        rc.disintegrate();
        return null;
    }

    private int getParentArchonIdx() throws GameActionException {
        int code = encode(parentArchonLocation, 0) & 4095;

        for (int i = 0; i < rc.readSharedArray(Idx.teamArchonCount); ++i) {
            if ((rc.readSharedArray(i + Idx.teamArchonDataOffset) & 4095) == code) { return i; }
        }

        return -1;
    }
}
