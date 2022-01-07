package Meteor_V2;

import battlecode.common.*;

public strictfp class Soldier extends Droid {

    private enum Mode {
        Wander,     // Attack nearby enemy. If not found, select random target.
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

        // Record enemy archon in vision
        recordEnemyArchon(nearbyRobots);

        switch (mode) {
            case Wander:
                if (target != null && target.equals(currentLocation)) { target = null; }

                // Move to attack target
                if (attackTarget != null) { target = attackTarget; }

                if (target == null) { selectRandomTarget(); }

                break;

            case Raid:
                if (target != null) {
                    int idx = getEnemyArchonIdx(target);

                    // Target is destroyed
                    if (idx != -1 && isThereNoEnemyArchon(target)) {
                        rc.writeSharedArray(idx + 2, 63);
                        idx = -1;
                    }

                    if (idx == -1) {
                        target = null;
                        mode = Mode.Wander;
                    }
                }
                break;
        }

        if (attackTarget != null && rc.canAttack(attackTarget)) {
            rc.attack(attackTarget);
            nextDirection = attackTarget.directionTo(currentLocation);
        }

        super.move();

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
            if(mode != Mode.Wander && distance > 13) continue;

            int health = robot.getHealth();
            if(robot.getType() == RobotType.ARCHON) { health -= 100000; }

            if(health < minHealth) {
                minHealth = health;
                attackTarget = robot.location;
            }
        }
    }

    private boolean updateTargetForRaid() throws GameActionException {
        int n = rc.readSharedArray(Idx.enemyArchonCount);
        for (int i = 0; i < n; ++i) {
            MapLocation targetCandidate = decodeLocation(rc.readSharedArray(i + 2));
            if (targetCandidate.x != 63 && rc.getRoundNum() >= 200) {
                target = targetCandidate;
                return true;
            }
        }
        return false;
    }

    protected void selectRandomTarget() throws GameActionException {
        int t = Math.max(rc.getRoundNum() / 5, 5);
        int x1 = Math.max(parentArchonLocation.x - t, 0);
        int y1 = Math.max(parentArchonLocation.y - t, 0);
        int x2 = Math.min(parentArchonLocation.x + t, rc.getMapWidth() - 1);
        int y2 = Math.min(parentArchonLocation.y + t, rc.getMapHeight() - 1);
        target = new MapLocation(RNG.nextInt(x2 - x1 + 1) + x1, RNG.nextInt(y2 - y1 + 1) + y1);
    }
}
