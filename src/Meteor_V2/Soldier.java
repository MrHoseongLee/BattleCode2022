package Meteor_V2;

import battlecode.common.*;

import java.util.Collections;

public strictfp class Soldier extends Droid {

    private enum Mode {
        Wander, Raid,
        //Wait, Guard, Scout   // not used for current version
    }

    private Mode mode = Mode.Wander;
    private RobotInfo[] nearbyRobots;
    private MapLocation attackTarget = null;
    //private RobotInfo guardInfo = null;
    //private int enemyArchonLocationIdx = 0;

    private final Team opponent;
    //private final MapLocation[] enemyArchonLocations;

    public Soldier(RobotController rc) throws GameActionException {
        super(rc);
        RNG.setSeed(rc.readSharedArray(18));

        opponent = rc.getTeam().opponent();
        //enemyArchonLocations = getEnemyArchonLocations();
    }

    public void step() throws GameActionException {
        super.step();

        nearbyRobots = rc.senseNearbyRobots();

        //receiveCommand();

        findEnemyArchonTarget();

        //if (rc.readSharedArray(30) > 1000 && rc.readSharedArray(0) == rc.readSharedArray(1)) mode = Mode.Raid;

        findAttackTarget();

        switch (mode) {

            case Wander:
                if (attackTarget != null) { setTarget(attackTarget); }
                if (target != null && target.equals(currentLocation)) { target = null; }
                if (target == null) { selectRandomTarget(); }
                break;

            case Raid:
                if (target != null) {
                    int idx = -1;
                    int n = rc.readSharedArray(1);
                    for (int i = 0; i < n; ++i) {
                        int w = rc.readSharedArray(i + 2);
                        if (loByte(w) == target.x && hiByte(w) == target.y)
                            idx = i;
                    }
                    if (idx != -1 && isThereNoEnemyArchon(target))
                        rc.writeSharedArray(idx + 2, 100);

                    if (idx == -1) {
                        target = null;
                        mode = Mode.Wander;
                    }
                }
                /*if (target == null || isThereNoEnemyArchon(target)) {
                    int i = RNG.nextInt(rc.readSharedArray(1));
                    int w = rc.readSharedArray(i + 2);
                    int x = loByte(w), y = hiByte(w);
                    target = new MapLocation(x, y);
                }*/
                break;

            /*case Wait:
                if (target == null) {
                    Direction direction = parentArchonLocation.directionTo(currentLocation);
                    double theta = RNG.nextDouble() * Math.PI * 2 + Math.atan2(direction.dy, direction.dx);
                    int x = Math.min(Math.max(parentArchonLocation.x + (int)(Math.cos(theta) * 4), 0), rc.getMapWidth() - 1);
                    int y = Math.min(Math.max(parentArchonLocation.y + (int)(Math.sin(theta) * 4), 0), rc.getMapHeight() - 1);
                    super.setTarget(new MapLocation(x, y));
                }
                break;

            case Guard:
                findGuardInfo();
                if (guardInfo == null) { selectRandomTarget(); }
                else setTarget(guardInfo.location);

                if (attackTarget != null) setTarget(attackTarget);
                break;

            case Scout:
                if (enemyArchonLocationIdx >= 3) {
                    target = null;
                    mode = Mode.Wander;
                    break;
                }

                // Target an enemy archon that is not found
                do {
                    target = enemyArchonLocations[enemyArchonLocationIdx];
                    if(isIdentifiedEnemyArchon(target)) {
                        target = null;
                        enemyArchonLocationIdx++;
                    }
                } while (target == null && enemyArchonLocationIdx < 3);

                if (target != null) { super.setTarget(target); }
                else { mode = Mode.Wander; }

                break;*/
        }

        rc.setIndicatorString("mode = " + mode + ", target = " + target);

        recordEnemyArchon(nearbyRobots);
        //if (mode == Mode.Scout && rc.canSenseLocation(target)) { enemyArchonLocationIdx++; }

        if (attackTarget != null && rc.canAttack(attackTarget)) {
            rc.attack(attackTarget);
            nextDirection = attackTarget.directionTo(currentLocation);
        }

        super.move();
    }

    private boolean isThereNoEnemyArchon(MapLocation loc) throws GameActionException {
        if (!rc.canSenseRobotAtLocation(loc)) return false;
        RobotInfo robot = rc.senseRobotAtLocation(loc);
        return robot.getTeam() != opponent || robot.getType() != RobotType.ARCHON;
    }

    private void findAttackTarget() {
        int minHealth = INF;
        attackTarget = null;

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() != opponent) continue;

            int distance = currentLocation.distanceSquaredTo(robot.location);
            if(mode != Mode.Wander && distance > 13) continue;

            int health = robot.getHealth();
            //if(robot.getType() == RobotType.SOLDIER) { health -= 1000; }
            if(robot.getType() == RobotType.ARCHON) { health -= 100000; }

            if(health < minHealth) {
                minHealth = health;
                attackTarget = robot.location;
            }
        }
    }

    private void findEnemyArchonTarget() throws GameActionException {
        int n = rc.readSharedArray(1);
        for (int i = 0; i < n; ++i) {
            int w = rc.readSharedArray(i + 2);
            int x = loByte(w), y = hiByte(w);
            if (x != 100 && rc.readSharedArray(18) >= 200) {
                target = new MapLocation(x, y);
                mode = Mode.Raid;
                return;
            }
        }
        //mode = Mode.Wander;
    }

    protected void selectRandomTarget() throws GameActionException {
        int t = Math.max(rc.readSharedArray(18) / 5, 5);
        int x1 = Math.max(parentArchonLocation.x - t, 0);
        int y1 = Math.max(parentArchonLocation.y - t, 0);
        int x2 = Math.min(parentArchonLocation.x + t, rc.getMapWidth() - 1);
        int y2 = Math.min(parentArchonLocation.y + t, rc.getMapHeight() - 1);
        target = new MapLocation(RNG.nextInt(x2 - x1 + 1) + x1, RNG.nextInt(y2 - y1 + 1) + y1);
        //target = new MapLocation(RNG.nextInt(rc.getMapWidth()), RNG.nextInt(rc.getMapHeight()));
    }

    /*private void findGuardInfo() {
        int minDistance = INF;
        RobotInfo nearestInfo = null;
        boolean lost = true;

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() == opponent) continue;
            if (robot.getType() != RobotType.MINER) continue;
            if (guardInfo != null && guardInfo.getID() == robot.getID()) {
                guardInfo = robot;
                lost = false;
                break;
            }

            int distance = currentLocation.distanceSquaredTo(robot.location);

            if(distance < minDistance) {
                minDistance = distance;
                nearestInfo = robot;
            }
        }

        if (lost) { guardInfo = nearestInfo; }
    }

    private void receiveCommand() throws GameActionException {
        int w = rc.readSharedArray(parentArchonIdx + 10);
        int x = loByte(w), y = hiByte(w);

        if (x == 100) { }
        else if(x == 110) {
            if(parentArchonLocation.distanceSquaredTo(currentLocation) <= 34) {
                mode = Mode.Wander;
                target = null;
            }
        }
        else { target = new MapLocation(x, y); }
    }

    private MapLocation[] getEnemyArchonLocations() {
        // Find all candidates of enemy archon location
        MapLocation[] locations = new MapLocation[3];
        int x = parentArchonLocation.x, y = parentArchonLocation.y;
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                if (i != 0 || j != 0) {
                    locations[i * 2 + j - 1] = new MapLocation(x, y);
                }
                x = rc.getMapWidth() - 1 - x;
            }
            y = rc.getMapHeight() - 1 - y;
        }

        // Shuffle
        for (int i = 2; i > 0; --i) {
            int j = RNG.nextInt(i + 1);
            MapLocation temp = locations[j];
            locations[j] = locations[i];
            locations[i] = temp;
        }

        return locations;
    }*/
}
