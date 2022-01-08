package Meteor_V2;

import battlecode.common.*;

import java.util.HashSet;

public strictfp class Archon extends Building {

    private int soldierCnt = 0;
    private int commandedScout = 0;

    private MapLocation repairTarget = null;
    private MapLocation[] possibleEnemyArchonLocations = null;

    private final int archonIdx;

    public Archon(RobotController rc) throws GameActionException {
        super(rc);

        archonIdx = rc.readSharedArray(Idx.teamArchonCount);

        rc.writeSharedArray(Idx.teamArchonCount, archonIdx + 1); // Increment Archon count
        rc.writeSharedArray(archonIdx + Idx.teamArchonDataOffset, encode(currentLocation, rc.getID()));
        rc.writeSharedArray(archonIdx + Idx.enemyArchonDataOffset, 0xFFFF);
        rc.writeSharedArray(archonIdx + Idx.teamSoldierTargetOffset, 63);
    }

    public void step() throws GameActionException {
        super.step();

        if (rc.getRoundNum() == 2 && archonIdx == 0) { calculatePossibleEnemyArchonLocations(); }

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();
        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType() == RobotType.SOLDIER && !isRobotOnSameTeam(robot)) {
                buildDroid(RobotType.SOLDIER);
                break;
            }
        }

        final int lead = rc.getTeamLeadAmount(rc.getTeam());

        /*if (rc.isActionReady() && buildType == null) {
            if (lead >= 200 && RNG.nextInt() < 3) buildType = RobotType.BUILDER;
            else {
                int k = Math.min(4, RobotPlayer.turnCount / 100);
                if (lead >= 1000 || RNG.nextInt(10) < 3 + k) buildType = RobotType.SOLDIER;
                else buildType = RobotType.MINER;
            }
        }

        if (buildType != null && lead >= buildType.buildCostLead) {
            if (lead >= buildType.buildCostLead * 2 || rc.readSharedArray(20) == archonIdx) {
                buildDroid(buildType);
                buildType = null;
                int n = rc.readSharedArray(0);
                rc.writeSharedArray(20, (archonIdx + 1) % n);
            }
        }*/
        if (rc.isActionReady()) {
            if (lead >= 200 && RNG.nextInt(10) < 2) buildDroid(RobotType.BUILDER);
            else if (lead >= 75) {
                if (lead >= 100 || rc.readSharedArray(Idx.nextArchonToBuild) == archonIdx) {
                    int k = Math.min(4, RobotPlayer.turnCount / 100);
                    if (lead >= 1000 || RNG.nextInt(10) < 4 + k) buildDroid(RobotType.SOLDIER);
                    else buildDroid(RobotType.MINER);
                    int n = rc.readSharedArray(Idx.teamArchonCount);
                    rc.writeSharedArray(Idx.nextArchonToBuild, (archonIdx + 1) % n);
                }
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

    }

    private void buildDroid(RobotType robotType) throws GameActionException {
        Direction bestDirection = Direction.CENTER; int minRubble = INF;

        for (int i = 0; i < 8; ++i) {
            Direction direction = directions[i];
            int rubble = rc.senseRubble(rc.adjacentLocation(direction));
            if (rc.canBuildRobot(robotType, direction) && minRubble > rubble) {
                bestDirection = direction; minRubble = rubble;
            }
        }

        if (bestDirection != Direction.CENTER) { rc.buildRobot(robotType, bestDirection); }
    }

    private void calculatePossibleEnemyArchonLocations() throws GameActionException {
        int width = rc.getMapWidth()- 1; int height = rc.getMapHeight() - 1;
        HashSet<MapLocation> possibleLocations = new HashSet<MapLocation>();
        MapLocation[] teamArchonLocations = new MapLocation[rc.readSharedArray(Idx.teamArchonCount)];

        for (int i = 0; i < rc.readSharedArray(Idx.teamArchonCount); ++i) {
            MapLocation teamArchonLocation = decodeLocation(rc.readSharedArray(i + 6));
            teamArchonLocations[i] = teamArchonLocation;
            int x = teamArchonLocation.x; int y = teamArchonLocation.y;

            possibleLocations.add(new MapLocation(width - x, y));
            possibleLocations.add(new MapLocation(x, height - y));
            possibleLocations.add(new MapLocation(width - x, height - y));
        }

        for (MapLocation teamArchonLocation : teamArchonLocations) {
            possibleLocations.remove(teamArchonLocation);
        }

        possibleEnemyArchonLocations = possibleLocations.toArray(new MapLocation[0]);
    }

    private void findRepairTarget() {
        if (rc.getHealth() < RobotType.ARCHON.getMaxHealth(1)) { repairTarget = currentLocation; return; }

        int minHealth = INF;
        repairTarget = null;

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots(20, rc.getTeam());

        for (RobotInfo robot : nearbyRobots) {
            if (robot.getType().isBuilding()) continue;
            if (robot.getHealth() == robot.getType().getMaxHealth(1)) continue;

            int health = robot.getHealth();

            if(health < minHealth) { minHealth = health; repairTarget = robot.location; }
        }
    }
}
