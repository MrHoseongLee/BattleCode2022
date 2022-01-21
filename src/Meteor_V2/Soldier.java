package Meteor_V2;

import battlecode.common.*;

public strictfp class Soldier extends Droid {

    private RobotInfo[] nearbyEnemies;
    private MapLocation attackTarget = null;
    private boolean movingToParentArchon = false;

    public Soldier(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        //parentArchonLocation = getClosestTeamArchonLocation();

        nearbyEnemies = rc.senseNearbyRobots(-1, team.opponent());

        final int enemySoldierCount = getEnemySoldierCount();
        final boolean attacking = rc.getRoundNum() >= rc.readSharedArray(Idx.teamArchonCount) * 100 + 100;
        final MapLocation closest = getClosestEnemySoldier();

        // Always attack nearby enemy
        updateAttackTarget();

        // Check enemy in vision
        minimap.reportNearbyEnemies(nearbyEnemies);
        reportNearbyArchons(nearbyEnemies);

        // If low on health, move to parent archon and get healed
        if (rc.getHealth() <= 10 && !attacking) movingToParentArchon = true;
        if (currentLocation.distanceSquaredTo(parentArchonLocation) <= 20) movingToParentArchon = rc.getHealth() <= 45;
        if (currentLocation.distanceSquaredTo(parentArchonLocation) < 13) movingToParentArchon = false;

        // Reset target if adjacent to it
        if (target != null && currentLocation.isAdjacentTo(target)) { target = null; }

        if (target != null && rc.canSenseLocation(target)) {
            if (rc.senseRubble(target) > rc.senseRubble(currentLocation) + 10) target = null;
        }

        // Move to attack target
        if (attackTarget != null && !isThereRobotTypeAt(attackTarget, RobotType.SOLDIER)) {
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

        if (closest != null && currentLocation.distanceSquaredTo(closest) <= 13) updateTargetForEvasion(nearbyEnemies);

        if (enemySoldierCount >= 2) {
            minimap.reportEnemy(closest, 3);
            updateTargetForEvasion(nearbyEnemies);
        }

        /*if (closest != null && !closest.equals(attackTarget) && currentLocation.distanceSquaredTo(closest) < 13) {
            updateTargetForEvasion(nearbyEnemies);
            if (rc.canAttack(closest)) rc.attack(closest);
            move();
        }*/

        if (attackTarget != null && rc.isActionReady()) {
            if (!isThereRobotTypeAt(attackTarget, RobotType.MINER)) { updateTargetForEvasion(nearbyEnemies); }
            rc.attack(attackTarget);
        }

        move();

        if (rc.isActionReady()) {
            updateAttackTarget();
            if (attackTarget != null && rc.canAttack(attackTarget)) rc.attack(attackTarget);
        }

        if (Clock.getBytecodesLeft() >= 2000) checkForEnemyArchons();

        super.draw();
        //rc.setIndicatorString("enemy = " + enemy);
    }

    private void updateAttackTarget() {
        int minHealth = INF;
        attackTarget = null;

        for (RobotInfo robot : rc.senseNearbyRobots(13, team.opponent())) {
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
            if (robot.getType() == RobotType.SOLDIER || robot.getType() == RobotType.ARCHON) { count += 1; }
        }

        return count;
    }

    private MapLocation getClosestEnemySoldier() {
        int minDistance = INF;
        MapLocation closest = null;

        for(RobotInfo robot : nearbyEnemies) {
            if (robot.getType() != RobotType.SOLDIER && robot.getType() != RobotType.ARCHON) { continue; }

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

    private boolean isProtectedByEnemyArchon(MapLocation location) throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);

        for (int i = 0; i < n * 3; ++i) {
            int code = rc.readSharedArray(i + Idx.enemyArchonLocationOffset);

            int state = decodeID(code);
            MapLocation archon = decodeLocation(code);

            if (state == 1 && archon.distanceSquaredTo(location) <= 80) { return true; }
        }

        return false;
    }

    private MapLocation getClosestTeamArchonLocation() throws GameActionException {
        int n = rc.readSharedArray(Idx.teamArchonCount);
        int minDistance = INF;
        MapLocation closest = null;

        for (int i = 0; i < n; ++i) {
            MapLocation location = decodeLocation(rc.readSharedArray(i + Idx.teamArchonDataOffset));
            if(location.x == 60) continue;
            int distance = currentLocation.distanceSquaredTo(location);

            if (distance < minDistance) {
                minDistance = distance;
                closest = location;
            }
        }

        return closest;
    }
}
