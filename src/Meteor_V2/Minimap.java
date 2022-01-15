package Meteor_V2;

import battlecode.common.*;

public class Minimap {

    private final int GRID_SIZE, GRID_ROW, GRID_COLUMN, GRID_MAX_IDX;

    private final RobotController rc;

    private final int width;
    private final int height;

    private int currentX;
    private int currentY;
    private int roundNumber;

    public Minimap(RobotController rc) {
        this.rc = rc;

        width = rc.getMapWidth();
        height = rc.getMapHeight();

        GRID_SIZE = (int) Math.ceil(Math.sqrt(width * height / 128.0)) + 3;
        GRID_ROW = (rc.getMapHeight() - 1) / GRID_SIZE + 1;
        GRID_COLUMN = (rc.getMapWidth() - 1) / GRID_SIZE + 1;
        GRID_MAX_IDX = (GRID_ROW * GRID_COLUMN - 1) / 8 + 1; // max 13
    }

    public void reset() throws GameActionException {
        for (int i = 0; i < GRID_MAX_IDX; ++i) {
            for (int j = 0; j < 8; ++j) {

                int level = (rc.readSharedArray(i + Idx.minimapOffset + parity(false)) >> (j*2)) & 0b11;

                if (level == 0) { continue; }

                int r = (i*8 + j) / GRID_COLUMN, c = (i*8 + j) % GRID_COLUMN;
                int x = c * GRID_SIZE + GRID_SIZE / 2, y = r * GRID_SIZE + GRID_SIZE / 2;

                if (level == 1) { rc.setIndicatorDot(new MapLocation(x, y), 255, 255, 0);  }
                if (level == 2) { rc.setIndicatorDot(new MapLocation(x, y), 255, 153, 51); }
                if (level == 3) { rc.setIndicatorDot(new MapLocation(x, y), 255, 80, 80);  }
            }

            rc.writeSharedArray(Idx.minimapOffset + i + parity(true), 0);
        }
    }

    public void updateInfo() {
        roundNumber = rc.getRoundNum();
        currentX = rc.getLocation().x;
        currentY = rc.getLocation().y;
    }

    public void reportEnemy(MapLocation location, int level) throws GameActionException {
        int k = (location.y / GRID_SIZE) * GRID_COLUMN + (location.x / GRID_SIZE);
        int x = rc.readSharedArray(Idx.minimapOffset + k/8 + parity(true));

        if (((x >> ((k%8)*2)) & 0b11) >= level) { return; }
        x &= ~(0b11 << ((k%8)*2));

        rc.writeSharedArray(Idx.minimapOffset + k/8 + parity(true), x | (level << ((k%8)*2)));
    }

    public void reportNearbyEnemies(RobotInfo[] nearbyRobots) throws GameActionException {
        boolean attacking = roundNumber >= rc.readSharedArray(Idx.teamArchonCount) * 150;

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType() == RobotType.MINER) { reportEnemy(robot.location, attacking ? 2 : 3); }
            if (robot.getType() == RobotType.SOLDIER || robot.getType() == RobotType.ARCHON || robot.getType() == RobotType.WATCHTOWER) { reportEnemy(robot.location, attacking ? 3 : 2); }
        }
    }

    MapLocation getClosestEnemy() throws GameActionException {
        int minDistance = 0x3F3F3F3F;
        int maxLevel = 0;
        MapLocation closestEnemy = null;

        for (int i=0; i < GRID_MAX_IDX; ++i) {
            for (int j=0; j < 8; ++j) {
                int level = (rc.readSharedArray(i + Idx.minimapOffset + parity(false)) >> (j*2)) & 0b11;

                if(level == 0) { continue; }

                int r = (i*8 + j) / GRID_COLUMN, c = (i*8 + j) % GRID_COLUMN;
                int x = Math.min(c * GRID_SIZE + GRID_SIZE / 2, width - 1), y = Math.min(r * GRID_SIZE + GRID_SIZE / 2, height - 1);
                int distance = distanceTo(x, y);

                if(level > maxLevel || (level == maxLevel && distance < minDistance)) {
                    maxLevel = level;
                    minDistance = distance;
                    closestEnemy = new MapLocation(x, y);
                }
            }
        }

        return closestEnemy;
    }

    public int getLevel(MapLocation location) throws GameActionException {
        int r = location.y / GRID_SIZE, c = location.x / GRID_SIZE;
        int k = r * GRID_COLUMN + c;
        int x = rc.readSharedArray(Idx.minimapOffset + k/8 + parity(false));
        return (x >> ((k%8)*2)) & 0b11;
    }

    private int distanceTo(int x, int y) {
        return Math.max(Math.abs(x - currentX), Math.abs(y - currentY));
    }

    private int parity(boolean inverse) {
        return ((roundNumber % 2 == 0) ^ inverse) ? 0 : GRID_MAX_IDX;
    }

}
