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

   protected void recordEnemyArchon(RobotInfo[] nearbyRobots) throws GameActionException {
        int n = rc.readSharedArray(Idx.enemyArchonCount);

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType() == RobotType.ARCHON && !isRobotOnSameTeam(robot)) {
                int robotIdx = getEnemyArchonIdx(robot.getID());

                if (robotIdx == -1) {
                    rc.writeSharedArray(n + Idx.enemyArchonDataOffset, encode(robot.getLocation(), robot.getID()));
                    n += 1;
                } else {
                    if (decodeLocation(rc.readSharedArray(robotIdx + Idx.enemyArchonDataOffset)) != robot.getLocation()) { 
                        rc.writeSharedArray(robotIdx + Idx.enemyArchonDataOffset, encode(robot.getLocation(), robot.getID()));
                    }
                }
            }
        }
        if (n != rc.readSharedArray(Idx.enemyArchonCount)) { rc.writeSharedArray(Idx.enemyArchonCount, n); }
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
