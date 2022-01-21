package Meteor_V3;

import battlecode.common.*;

public strictfp class Sage extends Droid {

    private RobotInfo[] nearbyEnemies;
    private MapLocation attackTarget = null;
    private boolean movingToParentArchon = false;

    public Sage(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        nearbyEnemies = rc.senseNearbyRobots(-1, team.opponent());

        final int enemySoldierCount = getEnemySoldierCount();
        final MapLocation closest = getClosestEnemySoldier();

        // Always attack nearby enemy
        updateAttackTarget();

        // Check enemy in vision
        minimap.reportNearbyEnemies(nearbyEnemies);
        reportNearbyArchons(nearbyEnemies);

        // Reset target if adjacent to it
        if (target != null && currentLocation.isAdjacentTo(target)) { target = null; }

        if (target != null && rc.canSenseLocation(target)) {
            if (rc.senseRubble(target) > rc.senseRubble(currentLocation) + 10) target = null;
        }

        // Move to attack target
        if (attackTarget != null && !isDangerous(rc.senseRobotAtLocation(attackTarget).type)) {
            target = attackTarget;
            if (currentLocation.isAdjacentTo(attackTarget)) target = currentLocation;
        }

        MapLocation enemy = minimap.getClosestEnemy();

        //if (enemy != null && !attacking && currentLocation.distanceSquaredTo(parentArchonLocation) > 20 && isProtectedByEnemyArchon(enemy)) enemy = null;
        if (enemy != null && (target == null || minimap.getLevel(target) == 0 || currentLocation.distanceSquaredTo(target) > 40 && minimap.getLevel(target) < minimap.getLevel(enemy))) {
            target = enemy;
        }

        if (movingToParentArchon) {
            target = parentArchonLocation;
        }

        if (target == null) selectRandomTarget();

        //if (attackTarget != null && !attacking && currentLocation.distanceSquaredTo(parentArchonLocation) > 20 && isProtectedByEnemyArchon(attackTarget)) updateTargetForEvasion(attackTarget);

        if (closest != null && currentLocation.distanceSquaredTo(closest) <= 25) updateTargetForEvasion(nearbyEnemies);

        if (enemySoldierCount >= 2) {
            minimap.reportEnemy(closest, 3);
            //updateTargetForEvasion(nearbyEnemies);
        }

        attack();
        move();

        if (rc.isActionReady()) {
            updateAttackTarget();
            attack();
        }

        if (Clock.getBytecodesLeft() >= 2000) checkForEnemyArchons();

        super.draw();
    }

    private void attack() throws GameActionException {
        if (attackTarget == null || !rc.isActionReady()) return;

        RobotInfo robot = rc.senseRobotAtLocation(attackTarget);

        if (robot.type == RobotType.ARCHON) rc.envision(AnomalyType.FURY);
        else if (!robot.type.isBuilding() && robot.getHealth() <= robot.getType().health * 0.22) rc.envision(AnomalyType.CHARGE);
        else rc.attack(attackTarget);
    }

    private void updateAttackTarget() {
        int minHealth = INF;
        attackTarget = null;

        for (RobotInfo robot : rc.senseNearbyRobots(25, team.opponent())) {
            int health = robot.getHealth();
            if(robot.getType() == RobotType.SOLDIER) { health -= 50; }
            if(robot.getType() == RobotType.ARCHON) { health -= 100; }

            if(health < minHealth) {
                minHealth = health;
                attackTarget = robot.location;
            }
        }
    }

    private int getEnemySoldierCount() {
        int count = 0;

        for (RobotInfo robot : nearbyEnemies) {
            if (isDangerous(robot.type)) { count += 1; }
        }

        return count;
    }

    private MapLocation getClosestEnemySoldier() {
        int minDistance = INF;
        MapLocation closest = null;

        for(RobotInfo robot : nearbyEnemies) {
            if (!isDangerous(robot.type)) { continue; }

            int distance = currentLocation.distanceSquaredTo(robot.location);

            if(distance < minDistance) {
                minDistance = distance;
                closest = robot.location;
            }
        }

        return closest;
    }

    protected void selectRandomTarget() throws GameActionException {
        int t = 5;
        int x1 = Math.max(currentLocation.x - t, 0);
        int y1 = Math.max(currentLocation.y - t, 0);
        int x2 = Math.min(currentLocation.x + t, rc.getMapWidth() - 1);
        int y2 = Math.min(currentLocation.y + t, rc.getMapHeight() - 1);
        target = new MapLocation(RNG.nextInt(x2 - x1 + 1) + x1, RNG.nextInt(y2 - y1 + 1) + y1);
    }
}
