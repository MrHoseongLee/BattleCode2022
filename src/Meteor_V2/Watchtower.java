package Meteor_V2;

import battlecode.common.*;

public strictfp class Watchtower extends Building {

    private MapLocation attackTarget = null;
    private boolean dead = false;

    public Watchtower(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        findAttackTarget();

        if (attackTarget != null && rc.canAttack(attackTarget)) { rc.attack(attackTarget); }

        if (!dead && rc.getHealth() <= 30) {
            rc.writeSharedArray(19, rc.readSharedArray(Idx.watchTowerCount) - 1);
            dead = true;
        }
    }

    private void findAttackTarget() {
        int minHealth = INF;
        attackTarget = null;

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();
        for (RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() == rc.getTeam()) continue;
            if (currentLocation.distanceSquaredTo(robot.location) > 20) continue;

            int health = robot.getHealth();

            if(health < minHealth) {
                minHealth = health;
                attackTarget = robot.location;
            }
        }
    }
}
