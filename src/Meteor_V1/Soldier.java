package Meteor_V1;

import battlecode.common.*;

import java.util.Collections;

public strictfp class Soldier extends Droid {

    private enum Mode {
        Wait, Wander, Scout, Raid
    }

    private Mode mode = Mode.Wait;
    private RobotInfo[] nearbyRobots;
    private MapLocation attackTarget = null;
    private int enemyArchonLocationIdx = 0;

    private final Team opponent;
    private final MapLocation parentArchonLocation;
    private final MapLocation[] enemyArchonLocations;
    private int parentArchonIdx;

    public Soldier(RobotController rc) throws GameActionException {
        super(rc);

        opponent = rc.getTeam().opponent();
        parentArchonLocation = getParentArchonLocation();
        enemyArchonLocations = getEnemyArchonLocations();

        int n = rc.readSharedArray(0);
        for (int i = 0; i < n; ++i) {
            int w = rc.readSharedArray(i + 6);
            if (loByte(w) == parentArchonLocation.x && hiByte(w) == parentArchonLocation.y) {
                parentArchonIdx = i;
                break;
            }
        }
    }

    public void step() throws GameActionException {
        super.step();

        nearbyRobots = rc.senseNearbyRobots();

        receiveCommand();

        findAttackTarget();

        switch (mode) {
            case Wait:
                if (target == null) {
                    Direction direction = parentArchonLocation.directionTo(currentLocation);
                    double theta = RNG.nextDouble() * Math.PI * 2 + Math.atan2(direction.dy, direction.dx);
                    int x = Math.min(Math.max(parentArchonLocation.x + (int)(Math.cos(theta) * 4), 0), rc.getMapWidth() - 1);
                    int y = Math.min(Math.max(parentArchonLocation.y + (int)(Math.sin(theta) * 4), 0), rc.getMapHeight() - 1);
                    super.setTarget(new MapLocation(x, y));
                }
                break;

            case Wander:
                if (attackTarget != null) { super.setTarget(attackTarget); }
                if (target == null) { selectRandomTarget(); }
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

                break;

            case Raid:
                break;
        }

        scoutEnemyArchon();
        if (mode == Mode.Scout && rc.canSenseLocation(target)) { enemyArchonLocationIdx++; }

        if (attackTarget != null && rc.canAttack(attackTarget)) { rc.attack(attackTarget); }

        super.move();
    }

    private void receiveCommand() throws GameActionException {
        int w = rc.readSharedArray(parentArchonIdx + 10);
        int x = loByte(w), y = hiByte(w);

        if (x == 100) { }
        else if(x == 110) {
            if(parentArchonLocation.distanceSquaredTo(currentLocation) <= 34) {
                mode = Mode.Wander;
                target = null;
                RNG.setSeed(1234);
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
    }

    private boolean isIdentifiedEnemyArchon(MapLocation loc) throws GameActionException {
        int n = rc.readSharedArray(1);
        for (int i = 0; i < n; ++i) {
            int w = rc.readSharedArray(i + 2);
            if (loByte(w) == loc.x && hiByte(w) == loc.y)
                return true;
        }
        return false;
    }

    private void scoutEnemyArchon() throws GameActionException {
        int n = rc.readSharedArray(1);
        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType() == RobotType.ARCHON && robot.getTeam() == opponent) {
                MapLocation loc = robot.location;
                if(isIdentifiedEnemyArchon(loc)) continue;

                rc.writeSharedArray(n + 2, makeWord(loc.x, loc.y));
                rc.writeSharedArray(1, ++n);
                System.out.println(n + "th Enemy archon is at (" + loc.x + ", " + loc.y + ")");
            }
        }
    }

    private void findAttackTarget() {
        int minHealth = INF;
        attackTarget = null;

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() != opponent) continue;

            int distance = currentLocation.distanceSquaredTo(robot.location);
            if(mode != Mode.Wander && distance > 13) continue;

            int health = robot.getHealth();
            if(robot.getType() == RobotType.SOLDIER) { health -= 1000; }

            if(health < minHealth) {
                minHealth = health;
                attackTarget = robot.location;
            }
        }
    }
}
