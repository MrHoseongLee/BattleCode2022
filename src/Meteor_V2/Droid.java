package Meteor_V2;

import battlecode.common.*;

public strictfp class Droid extends Robot {

    protected final int parentArchonIdx;
    protected final MapLocation parentArchonLocation;

    public Droid(RobotController rc) throws GameActionException {
        super(rc);

        parentArchonLocation = getParentArchonLocation();
        parentArchonIdx = getParentArchonIdx();

        System.out.println("" + parentArchonIdx);
        System.out.println("" + parentArchonLocation);
    }

    public void step() throws GameActionException {
        super.step();
    }

   protected void recordEnemyArchon(RobotInfo[] nearbyRobots) throws GameActionException {
        int n = rc.readSharedArray(1);

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType() == RobotType.ARCHON && !isRobotOnSameTeam(robot)) {
                int code = encode(robot.getLocation(), robot.getID());

                if (rc.readSharedArray(n + 2) == code) { continue; }

                rc.writeSharedArray(n + 2, code);
                rc.writeSharedArray(1, ++n);
            }
        }
    }

    protected int getEnemyArchonIdx(MapLocation loc) throws GameActionException {
        int n = rc.readSharedArray(1);
        for (int i = 0; i < n; ++i) {
            int w = rc.readSharedArray(i + 2);
            if (loByte(w) == loc.x && hiByte(w) == loc.y)
                return i;
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
        int code = encode(parentArchonLocation, 0) & 4096;

        for (int i = 0; i < rc.readSharedArray(0); ++i) {
            if ((rc.readSharedArray(i + 6) & 4096) == code) { return i; }
        }

        return -1;
    }
}
