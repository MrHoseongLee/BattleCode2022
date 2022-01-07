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

    protected MapLocation getParentArchonLocation() throws GameActionException {
        for(Direction dir : directions) {
            MapLocation loc = currentLocation.add(dir);
            if(rc.canSenseRobotAtLocation(loc) && rc.senseRobotAtLocation(loc).getType() == RobotType.ARCHON)
                return loc;
        }
        return null;
    }

    protected int getParentArchonIdx() throws GameActionException {
        int n = rc.readSharedArray(0);
        for (int i = 0; i < n; ++i) {
            int w = rc.readSharedArray(i + 6);
            if (loByte(w) == parentArchonLocation.x && hiByte(w) == parentArchonLocation.y)
                return i;
        }
        return -1;
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

    protected void recordEnemyArchon(RobotInfo[] nearbyRobots) throws GameActionException {
        int n = rc.readSharedArray(1);
        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType() == RobotType.ARCHON && robot.getTeam() != rc.getTeam()) {
                MapLocation loc = robot.location;
                if(getEnemyArchonIdx(loc) != -1) continue;

                rc.writeSharedArray(n + 2, makeWord(loc.x, loc.y));
                rc.writeSharedArray(1, ++n);
                System.out.println(n + "th Enemy archon is at (" + loc.x + ", " + loc.y + ")");
            }
        }
    }
}
