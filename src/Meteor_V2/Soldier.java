package Meteor_V2;

import battlecode.common.*;

public strictfp class Soldier extends Droid {

    private enum Mode {
        Wander,     // Attack nearby enemy. If not found, select random target.
        Scout,      // Move to the closest undiscovered enemy archon location.
        Raid,       // Move to and attack specific enemy archon.
    }

    private Mode mode = Mode.Scout;
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
                if (target != null && target.equals(currentLocation)) { target = null; }

                // Move to attack target
                if (attackTarget != null) { target = attackTarget; }

                if (target == null) { selectRandomTarget(); }

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
                break;
        }

        if (attackTarget != null && rc.canAttack(attackTarget)) {
            rc.attack(attackTarget);
            if (mode != Mode.Scout) {
                nextDirection = attackTarget.directionTo(currentLocation);
                if (rc.canSenseLocation(currentLocation.add(nextDirection))) {
                    int r = rc.senseRubble(currentLocation.add(nextDirection)) / 10;
                    if (r >= rc.senseRubble(currentLocation) / 10 + 2) nextDirection = Direction.CENTER;
                }
            }
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

    protected void selectRandomTarget() throws GameActionException {
        int t = Math.max(rc.getRoundNum() / 5, 5);
        int x1 = Math.max(parentArchonLocation.x - t, 0);
        int y1 = Math.max(parentArchonLocation.y - t, 0);
        int x2 = Math.min(parentArchonLocation.x + t, rc.getMapWidth() - 1);
        int y2 = Math.min(parentArchonLocation.y + t, rc.getMapHeight() - 1);
        target = new MapLocation(RNG.nextInt(x2 - x1 + 1) + x1, RNG.nextInt(y2 - y1 + 1) + y1);
    }
}
