package Meteor_V2;

import battlecode.common.*;

public class Minimap {

    final int GRID_SIZE, GRID_ROW, GRID_COLUMN, GRID_MAX_IDX;

    RobotController rc;

    Minimap(RobotController rc) {
        this.rc = rc;

        GRID_SIZE = (int) Math.ceil(Math.sqrt(rc.getMapHeight() * rc.getMapWidth() / 128.0)) + 3;
        GRID_ROW = (rc.getMapHeight() - 1) / GRID_SIZE + 1;
        GRID_COLUMN = (rc.getMapWidth() - 1) / GRID_SIZE + 1;
        GRID_MAX_IDX = (GRID_ROW * GRID_COLUMN - 1) / 8 + 1; // max 13
    }

    void initTurn() throws GameActionException {
        for (int i = 0; i < GRID_MAX_IDX; ++i) {
            for(int j=0; j<8; ++j) {
                int level = (rc.readSharedArray(i + 32 + (rc.getRoundNum() % 2 == 0 ? 0 : GRID_MAX_IDX)) >> (j*2)) & 0b11;
                if(level == 0) continue;

                int r = (i*8 + j) / GRID_COLUMN, c = (i*8 + j) % GRID_COLUMN;
                int x = c * GRID_SIZE + GRID_SIZE / 2, y = r * GRID_SIZE + GRID_SIZE / 2;
                if(level == 1) rc.setIndicatorDot(new MapLocation(x, y), 255, 255, 0);
                if(level == 2) rc.setIndicatorDot(new MapLocation(x, y), 255, 153, 51);
                if(level == 3) rc.setIndicatorDot(new MapLocation(x, y), 255, 80, 80);
            }
            if (rc.getRoundNum() % 2 == 1) rc.writeSharedArray(32 + i, 0);
            else rc.writeSharedArray(32 + i + GRID_MAX_IDX, 0);
        }
    }

    void reportEnemy(MapLocation loc, int level) throws GameActionException {
        int r = loc.y / GRID_SIZE, c = loc.x / GRID_SIZE;
        int k = r * GRID_COLUMN + c;
        int x = rc.readSharedArray(32 + k/8);
        rc.writeSharedArray(32 + k/8 + (rc.getRoundNum() % 2 == 1 ? 0 : GRID_MAX_IDX), x | (level << ((k%8)*2)));
    }

    void reportNearbyEnemies(RobotInfo[] nearbyRobots) throws GameActionException {
        for(RobotInfo robot : nearbyRobots) {
            if(robot.getTeam() == rc.getTeam()) continue;
            if(robot.getType() == RobotType.MINER) reportEnemy(robot.location, 2);
            if(robot.getType() == RobotType.SOLDIER || robot.getType() == RobotType.ARCHON || robot.getType() == RobotType.WATCHTOWER) reportEnemy(robot.location, 3);
        }
    }

    MapLocation getClosestEnemy() throws GameActionException {
        int minDistance = 0x3f3f3f3f;
        int maxLevel = 0;
        MapLocation enemy = null;

        for(int i=0; i<GRID_MAX_IDX; ++i) {
            for(int j=0; j<8; ++j) {
                int level = (rc.readSharedArray(i + 32 + (rc.getRoundNum() % 2 == 0 ? 0 : GRID_MAX_IDX)) >> (j*2)) & 0b11;
                if(level == 0) continue;

                int r = (i*8 + j) / GRID_COLUMN, c = (i*8 + j) % GRID_COLUMN;
                int x = Math.min(c * GRID_SIZE + GRID_SIZE / 2, rc.getMapWidth() - 1), y = Math.min(r * GRID_SIZE + GRID_SIZE / 2, rc.getMapHeight() - 1);
                int distance = Math.max(Math.abs(x - rc.getLocation().x), Math.abs(y - rc.getLocation().y));
                if(level > maxLevel || (level == maxLevel && distance < minDistance)) {
                    maxLevel = level;
                    minDistance = distance;
                    enemy = new MapLocation(x, y);
                }
            }
        }
        return enemy;
    }
}
