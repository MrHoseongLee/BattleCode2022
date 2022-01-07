package Meteor_V1;

import battlecode.common.*;

public strictfp class Watchtower extends Building {

    private MapLocation attackTarget = null;

    public Watchtower(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        findAttackTarget();

        if (attackTarget != null && rc.canAttack(attackTarget)) { rc.attack(attackTarget); }
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
