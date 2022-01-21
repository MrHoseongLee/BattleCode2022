package Meteor_V3;

import battlecode.common.*;

import java.util.Random;

public class Robot {

    int encode (MapLocation location, int ID) { return location.x | (location.y << 6) | (ID << 12); }
    int encode (int x, int y) { return x | (y << 6); }

    int decodeID (int code) { return (code >> 12) & 0xF; }
    MapLocation decodeLocation (int code) { return new MapLocation(code & 0x3F, (code >> 6) & 0x3F); }

    protected final RobotController rc;

    protected final BFS bfs;
    protected final Minimap minimap;

    protected final Team team;

    protected MapLocation currentLocation;
    protected MapLocation previousLocation;

    protected MapLocation target = null;
    protected Direction nextDirection = null;

    protected static final Random RNG = new Random(42);

    /** Array containing all the possible movement directions. */
    protected static final Direction[] directions = {
            Direction.NORTH,
            Direction.NORTHEAST,
            Direction.EAST,
            Direction.SOUTHEAST,
            Direction.SOUTH,
            Direction.SOUTHWEST,
            Direction.WEST,
            Direction.NORTHWEST,
    };

    protected static final int INF = 0x3F3F3F3F;

    public Robot(RobotController rc) throws GameActionException {
        this.rc = rc;
        this.currentLocation = rc.getLocation();

        RNG.setSeed(rc.getRoundNum());
        team = rc.getTeam();

        if (rc.getType() == RobotType.ARCHON) { bfs = new BFSBuilding(rc); }
        else { bfs = new BFSDroid(rc); }
        minimap = new Minimap(rc);
    }

    public void step() throws GameActionException {
        previousLocation = (rc.getLocation().equals(currentLocation)) ? previousLocation : currentLocation;
        currentLocation = rc.getLocation();
        minimap.updateInfo();
    }

    protected void move() throws GameActionException {
        if (nextDirection == null) { calculateNextDirection(); }
        if (rc.canMove(nextDirection)) { rc.move(nextDirection); }
        nextDirection = null;
    }

    protected void draw() throws GameActionException {
        if (target != null) {
            rc.setIndicatorDot(target, 0, 255, 0);
            rc.setIndicatorLine(rc.getLocation(), target, 255, 0, 0);
        }
    }

    protected void setTarget(MapLocation target) {
        this.previousLocation = currentLocation;
        this.target = target;
    }

    protected void selectRandomTarget() throws GameActionException {
        target = new MapLocation(RNG.nextInt(rc.getMapWidth()), RNG.nextInt(rc.getMapHeight()));
    }

    protected boolean isThereBuildingAt(MapLocation location) throws GameActionException {
        return rc.canSenseRobotAtLocation(location) && rc.senseRobotAtLocation(location).getType().isBuilding();
    }

    protected boolean isThereRobotTypeAt(MapLocation location, RobotType type) throws GameActionException {
        return rc.canSenseRobotAtLocation(location) && rc.senseRobotAtLocation(location).getType().equals(type);
    }

    protected boolean isThereTeamRobotTypeAt(MapLocation location, RobotType type) throws GameActionException {
        if (rc.canSenseRobotAtLocation(location)) {
            RobotInfo robot = rc.senseRobotAtLocation(location);
            return robot.getType().equals(type) && robot.getTeam().equals(team);
        }
        return false;
    }

    protected boolean isRobotOnSameTeam(RobotInfo robot) {
        return robot.getTeam().equals(team);
    }

    protected boolean isDangerous(RobotType type) {
        return type == RobotType.ARCHON || type == RobotType.SOLDIER || type == RobotType.SAGE || type == RobotType.WATCHTOWER;
    }

    protected int countAliveTeamArchonsAfter(int offset) throws GameActionException {
        int count = 0;

        int n = rc.readSharedArray(Idx.teamArchonCount);
        for (int i = offset; i < n; ++i) {
            if (rc.readSharedArray(i + Idx.teamArchonDataOffset) != 60) {
                count += 1;
            }
        }

        return count;
    }

    protected int getFirstAliveTeamArchonIdx() throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);

        for (int i = 0; i < n; ++i) {
            if (rc.readSharedArray(i + Idx.teamArchonDataOffset) != 60) {
                return i;
            }
        }

        return 0;
    }

    protected int getNextAliveTeamArchonIdx(int offset) throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);

        for (int j = 1; j < n; ++j) {
            int i = (offset + j) % n;
            if (rc.readSharedArray(i + Idx.teamArchonDataOffset) != 60) {
                return i;
            }
        }

        return offset;
    }

    protected void calculateNextDirection() throws GameActionException {
        nextDirection = Direction.CENTER;
        if (target == null || currentLocation.equals(target)) { return; }

        double bestValue = INF;

        int originalDistance = currentLocation.distanceSquaredTo(target);

        for(Direction direction : directions) {
            MapLocation nextLocation = rc.adjacentLocation(direction);

            // Check if moving in this direction is possible
            if(!rc.onTheMap(nextLocation) || rc.canSenseRobotAtLocation(nextLocation)) { continue; }

            // Don't backtrack
            //if (nextLocation.equals(previousLocation)) { continue; }

            int distance = nextLocation.distanceSquaredTo(target);

            if (distance == 0) { nextDirection = direction; break; }

            //double value = Math.sqrt(distance) + (double)rc.senseRubble(nextLocation) / 10.0;
            double value = distance * (1 + rc.senseRubble(nextLocation) / 10.0);

            // If moving in this direction increases distance, add additional penalty
            if (distance > originalDistance) { value += 100000; }//Math.sqrt(distance - originalDistance) * 2; }

            if (value < bestValue) { bestValue = value; nextDirection = direction; }
        }

        if (rc.adjacentLocation(nextDirection).equals(previousLocation)) {
            nextDirection = currentLocation.directionTo(target);
        }
    }
}
