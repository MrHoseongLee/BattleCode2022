package Meteor_V1;

import battlecode.common.*;

public strictfp class Archon extends Building {

    private int minerCnt = 0;
    private int builderCnt = 0;
    private int soldierCnt = 0;
    private int previousMinerSignal = 0;
    private int commandedScout = 0;
    private MapLocation repairTarget = null;

    private final int archonIdx;

    public Archon(RobotController rc) throws GameActionException {
        super(rc);

        archonIdx = rc.readSharedArray(0);
        rc.writeSharedArray(0, archonIdx + 1); // Increment Archon count
        rc.writeSharedArray(archonIdx + 6, makeWord(currentLocation.x, currentLocation.y));
        rc.writeSharedArray(archonIdx + 10, 100);
    }

    public void step() throws GameActionException {
        super.step();

        rc.writeSharedArray(18, RobotPlayer.turnCount);

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();
        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType() == RobotType.SOLDIER && robot.getTeam() != rc.getTeam()) {
                buildDroid(RobotType.SOLDIER);
                break;
            }
        }

        final int lead = rc.getTeamLeadAmount(rc.getTeam());

        if (rc.isActionReady()) {
            if (lead >= 200 && RNG.nextInt() < 3) buildDroid(RobotType.BUILDER);
            else if (lead >= 75) {
                int k = Math.min(4, RobotPlayer.turnCount / 100);
                if (lead >= 1000 || RNG.nextInt(10) < 3 + k) buildDroid(RobotType.SOLDIER);
                else buildDroid(RobotType.MINER);
            }
        }

        // Command to soldier
        /*if (commandedScout == 1) {
            rc.writeSharedArray(archonIdx + 10, 100);
            commandedScout = -100;
        }
        if (commandedScout < 0) { commandedScout += 1; }

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();

        soldierCnt = 0;
        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType() == RobotType.SOLDIER && robot.getTeam() == rc.getTeam())
                soldierCnt += 1;
        }

        if(commandedScout == 0 && soldierCnt >= SQUAD_SOLDIER * 2) {
            rc.writeSharedArray(archonIdx + 10, 110);
            commandedScout = 1;
        }*/

        // For test
        /*if(minerCnt < 1) {
            if (buildDroid(RobotType.MINER)) {
                minerCnt += 1;
            }
        }

        if(builderCnt < 0) {
            if (buildDroid(RobotType.BUILDER)) {
                builderCount++;
            }
        }

        if(soldierCnt < 1) {
            if (buildDroid(RobotType.SOLDIER)) {
                soldierCount++;
            }
        }*/
    }

    private boolean buildDroid(RobotType robotType) throws GameActionException {
        for (int i = 0; i < 8; ++i) {
            Direction direction = directions[RNG.nextInt(8)];
            if (rc.canBuildRobot(robotType, direction)) {
                rc.buildRobot(robotType, direction);
                return true;
            }
        }
        return false;
    }

    private void buildDroids(RobotType robotType) throws GameActionException {
        for (Direction direction : directions) {
            if (rc.canBuildRobot(robotType, direction)) {
                rc.buildRobot(robotType, direction);
            }
        }
    }

    private void findRepairTarget() {
        int minHealth = INF;
        repairTarget = null;

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();
        for (RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() != rc.getTeam() || robot.getType().isBuilding()) continue;
            if (robot.getHealth() == robot.getType().getMaxHealth(1)) continue;
            if (currentLocation.distanceSquaredTo(robot.location) > 20) continue;

            int health = robot.getHealth();

            if(health < minHealth) {
                minHealth = health;
                repairTarget = robot.location;
            }
        }
    }
}
