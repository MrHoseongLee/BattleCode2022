package Meteor_V1;

import battlecode.common.*;

import java.util.Collections;

public strictfp class Soldier extends Droid {

    private enum Mode {
        Scout, Wander, Raid
    }

    private Mode mode = Mode.Scout;
    private RobotInfo[] nearbyRobots;
    private MapLocation attackTarget = null;
    private MapLocation[] enemyArchonLocations;
    private int enemyArchonLocationIdx = 0;

    private final Team opponent;

    public Soldier(RobotController rc) throws GameActionException {
        super(rc);

        opponent = rc.getTeam().opponent();

        if (rc.readSharedArray(0) == rc.readSharedArray(1))
            mode = Mode.Wander;
        else {
            // Find all candidates of enemy archon location
            enemyArchonLocations = new MapLocation[3];
            MapLocation archonLocation = getParentArchonLocation();
            int x = archonLocation.x, y = archonLocation.y;
            for (int i = 0; i < 2; ++i) {
                for (int j = 0; j < 2; ++j) {
                    if (i != 0 || j != 0) {
                        enemyArchonLocations[i * 2 + j - 1] = new MapLocation(x, y);
                    }
                    x = rc.getMapWidth() - 1 - x;
                }
                y = rc.getMapHeight() - 1 - y;
            }

            // Shuffle
            for (int i = 2; i > 0; --i) {
                int j = RNG.nextInt(i + 1);
                MapLocation temp = enemyArchonLocations[j];
                enemyArchonLocations[j] = enemyArchonLocations[i];
                enemyArchonLocations[i] = temp;
            }
        }
    }

    public void step() throws GameActionException {
        super.step();

        nearbyRobots = rc.senseNearbyRobots();

        FindAttackTarget();

        switch (mode) {
            case Scout:
                if (enemyArchonLocationIdx >= 3) {
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

                break;

            case Wander:
                target = attackTarget;
                break;

            case Raid:
                break;
        }

        ScoutEnemyArchon();
        if (target != null && rc.canSenseLocation(target)) { enemyArchonLocationIdx++; }

        if (attackTarget != null && rc.canAttack(attackTarget)) { rc.attack(attackTarget); }

        super.move();
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

    private void ScoutEnemyArchon() throws GameActionException {
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

    private void FindAttackTarget() {
        int minHealth = INF;

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
