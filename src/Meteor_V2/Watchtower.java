package Meteor_V2;

import battlecode.common.*;

public strictfp class Watchtower extends Building {

    private MapLocation attackTarget = null;
    private MapLocation closestEnemyArchonLocation = null;

    private int distanceToEnemyArchon = INF;

    public Watchtower(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        updateClosestEnemyArchonLocation();

        target = closestEnemyArchonLocation;

        if (rc.getMode() == RobotMode.PORTABLE) {
            if (distanceToEnemyArchon - currentLocation.distanceSquaredTo(closestEnemyArchonLocation) > 5 && isOnBoundary()) {
                if (rc.canTransform()) { rc.transform(); }
            }
            super.move();
            return;
        }

        updateAttackTarget();

        if (attackTarget != null) {
            if (rc.canAttack(attackTarget)) { rc.attack(attackTarget); }
        } 

        else {
            if (!isOnBoundary() || (rc.getRoundNum() % 100 == 0 && (currentLocation.x + currentLocation.y) % 2 == 0)) {
                distanceToEnemyArchon = currentLocation.distanceSquaredTo(closestEnemyArchonLocation);
                if (rc.canTransform()) { rc.transform(); }
            }
        }

    }

    private void updateAttackTarget() {
        int minHealth = INF;
        attackTarget = null;

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots(20, team.opponent());

        for (RobotInfo robot : nearbyRobots) {
            int health = robot.getHealth();
            if(health < minHealth) { minHealth = health; attackTarget = robot.location; }
        }
    }

    private void updateClosestEnemyArchonLocation() throws GameActionException {
        int minDistance = INF;
        for (int i = 0; i < rc.readSharedArray(Idx.enemyArchonCount); ++i) {
            MapLocation location = decodeLocation(rc.readSharedArray(i + Idx.enemyArchonDataOffset));
            int distance = location.distanceSquaredTo(currentLocation);
            if (distance < minDistance) { minDistance = distance; closestEnemyArchonLocation = location; }
        }
        if (closestEnemyArchonLocation == null) {
            closestEnemyArchonLocation = new MapLocation(rc.getMapWidth() / 2, rc.getMapHeight() / 2);
        }
    }

    private boolean isOnBoundary() {
        return rc.senseNearbyRobots(34, team.opponent()).length > 0;
    }
}
