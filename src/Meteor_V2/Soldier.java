package Meteor_V2;

import battlecode.common.*;

public strictfp class Soldier extends Droid {

    private enum Mode {
        Wander,     // Attack nearby enemy. If not found, select random target.
        Scout,      // Move to the closest undiscovered enemy archon location.
        Raid,       // Move to and attack specific enemy archon.
    }

    private Mode mode = Mode.Wander;
    private RobotInfo[] nearbyRobots;
    private MapLocation attackTarget = null;

    public Soldier(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        nearbyRobots = rc.senseNearbyRobots();

        // An enemy archon found
        if (updateTargetForRaid()) { mode = Mode.Raid; }

        // Always attack nearby enemy
        updateAttackTarget();

        // Check enemy archon in vision
        checkEnemyArchon();

        switch (mode) {
            case Wander:
                if (target != null && currentLocation.distanceSquaredTo(target) <= 2) { target = null; }

                if (target != null && rc.canSenseLocation(target)) {
                    int r = rc.senseRubble(target) / 10;
                    if (r >= rc.senseRubble(currentLocation) / 10 + 2) target = null;
                }

                // Move to attack target
                if (attackTarget != null) { target = attackTarget; }
                //else if (updateTargetForDefend()) mode = Mode.Defend;

                if (target == null) {
                    target = getWeakestFriendlySoldier(nearbyRobots);
                    if (target.equals(currentLocation)) selectRandomTarget();
                }

                break;

            case Scout:
                if (target != null && rc.canSenseLocation(target)) { target = null; }
                if (target == null) { target = getClosestUndiscoveredEnemyArchon(); }
                if (target == null) { mode = Mode.Wander; return; }
                break;

            case Raid:
                if (target != null) {
                    int idx = getEnemyArchonIdx(target);

                    // Target is destroyed
                    if (idx != -1 && isThereNoEnemyArchon(target)) {
                        rc.writeSharedArray(idx + Idx.enemyArchonDataOffset, 63);
                        idx = -1;
                    }

                    if (idx == -1) {
                        target = null;
                        mode = Mode.Scout;
                    }
                }
                if (attackTarget != null) { target = attackTarget; }
                break;
        }

        MapLocation closest = getClosestEnemySoldier(nearbyRobots);
        if (closest != null && !closest.equals(attackTarget) && currentLocation.distanceSquaredTo(closest) < 13) {
            if (rc.canAttack(closest)) rc.attack(closest);
            nextDirection = closest.directionTo(currentLocation);
            super.move();
        }

        if (attackTarget != null && rc.isActionReady() && currentLocation.distanceSquaredTo(attackTarget) > 13) {
            if(count(nearbyRobots) <= 1) nextDirection = currentLocation.directionTo(attackTarget);
            else nextDirection = attackTarget.directionTo(currentLocation);
            super.move();
            if (rc.canAttack(attackTarget)) rc.attack(attackTarget);
        }

        if (attackTarget != null && rc.canAttack(attackTarget)) {
            if (mode != Mode.Raid || !attackTarget.equals(target)) {
                nextDirection = attackTarget.directionTo(currentLocation);
                if (rc.canSenseLocation(currentLocation.add(nextDirection))) {
                    int r = rc.senseRubble(currentLocation.add(nextDirection)) / 10;
                    if (r >= rc.senseRubble(currentLocation) / 10 + 2) nextDirection = Direction.CENTER;
                }
            }
            rc.attack(attackTarget);
        }

        super.move();
        super.draw();

        rc.setIndicatorString("mode = " + mode + ", target = " + target);
    }

    private boolean isThereNoEnemyArchon(MapLocation loc) throws GameActionException {
        if (!rc.canSenseRobotAtLocation(loc)) return false;
        RobotInfo robot = rc.senseRobotAtLocation(loc);
        return robot.getTeam() == rc.getTeam() || robot.getType() != RobotType.ARCHON;
    }

    private void updateAttackTarget() {
        int minHealth = INF;
        attackTarget = null;

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() == rc.getTeam()) continue;

            int distance = currentLocation.distanceSquaredTo(robot.location);
            //if(mode != Mode.Wander && distance > 13) continue;

            int health = robot.getHealth();
            if(robot.getType() == RobotType.ARCHON) { health -= 500; }

            if(health < minHealth) {
                minHealth = health;
                attackTarget = robot.location;
            }
        }
    }

    private int count(RobotInfo[] nearbyRobots) {
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

    private MapLocation getWeakestFriendlySoldier(RobotInfo[] nearbyRobots) {
        int minHealth = rc.getHealth();
        MapLocation weakest = currentLocation;

        for(RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() != rc.getTeam()) continue;
            if (robot.getType() != RobotType.SOLDIER) continue;

            if(robot.getHealth() < minHealth) {
                minHealth = robot.getHealth();
                weakest = robot.location;
            }
        }

        return weakest;
    }
}
