package Meteor_V2;

import battlecode.common.*;

public strictfp class Soldier extends Droid {

    private RobotInfo[] nearbyRobots;
    private MapLocation attackTarget = null;
    private boolean movingToRandomTarget = false;

    public Soldier(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        nearbyRobots = rc.senseNearbyRobots();

        // Always attack nearby enemy
        updateAttackTarget();

        // Check enemy archon in vision
        minimap.reportNearbyEnemies(nearbyRobots);

        if (target != null && currentLocation.distanceSquaredTo(target) <= 2) { target = null; }

        if (target != null && rc.canSenseLocation(target)) {
            if (rc.senseRubble(target) >= rc.senseRubble(currentLocation) + 5) target = null;
        }

        // Move to attack target
        if (attackTarget != null) {
            target = attackTarget;
            movingToRandomTarget = false;
        }

        MapLocation enemy = minimap.getClosestEnemy();
        if (enemy != null && (target == null || currentLocation.distanceSquaredTo(target) >= 40)) {
            target = enemy;
            movingToRandomTarget = false;
        }
        if (target == null || (enemy == null && !movingToRandomTarget)) {
            selectRandomTarget();
            movingToRandomTarget = true;
        }

        MapLocation closest = getClosestEnemySoldier(nearbyRobots);
        if (closest != null && !closest.equals(attackTarget) && currentLocation.distanceSquaredTo(closest) < 13) {
            if (rc.canAttack(closest)) rc.attack(closest);
            updateTargetForEvasion(closest);
            move();
        }

        if (attackTarget != null && rc.isActionReady()) {
            if (currentLocation.distanceSquaredTo(attackTarget) > 13) {
                if(countEnemySoldier(nearbyRobots) > 1) updateTargetForEvasion(attackTarget);
                move();
                if (rc.canAttack(attackTarget)) rc.attack(attackTarget);
            } else {
                updateTargetForEvasion(attackTarget);
                rc.attack(attackTarget);
            }
        }

        move();

        super.draw();
    }

    private void updateAttackTarget() {
        int minHealth = INF;
        attackTarget = null;

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() == rc.getTeam()) continue;

            int health = robot.getHealth();
            if(robot.getType() == RobotType.SOLDIER) { health -= 50; }
            if(robot.getType() == RobotType.ARCHON) { health -= 500; }

            if(health < minHealth) {
                minHealth = health;
                attackTarget = robot.location;
            }
        }
    }

    private int countEnemySoldier(RobotInfo[] nearbyRobots) {
        int cnt = 0;
        for(RobotInfo robot : nearbyRobots) {
            if (robot.getType() != RobotType.SOLDIER) continue;
            if (robot.getTeam() != rc.getTeam()) cnt++;
        }
        return cnt;
    }

    private MapLocation getClosestEnemySoldier(RobotInfo[] nearbyRobots) {
        int minDistance = INF;
        MapLocation closest = null;

        for(RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() == rc.getTeam()) continue;
            if (robot.getType() != RobotType.SOLDIER) continue;

            int distance = currentLocation.distanceSquaredTo(robot.location);

            if(distance < minDistance) {
                minDistance = distance;
                closest = robot.location;
            }
        }

        return closest;
    }
}
