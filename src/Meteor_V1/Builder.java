package Meteor_V1;

import battlecode.common.*;

public strictfp class Builder extends Droid {

    private enum Phase {BUILD, REPAIR }

    private Phase phase = Phase.BUILD;
    private MapLocation repairTarget = null;

    public Builder(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void step() throws GameActionException {
        super.step();

        switch (phase) {
            case BUILD:
                findRepairTarget();

                if (target != null && target.equals(currentLocation)) { target = null; }

                // Change target if target is already occupied
                if (target != null && rc.canSenseLocation(target) && isThereBuilding(target)) { target = null; }

                if (target == null) { selectRandomTarget(); }

                if (currentLocation.isAdjacentTo(target)) {
                    Direction direction = currentLocation.directionTo(target);
                    if (rc.canBuildRobot(RobotType.WATCHTOWER, direction)) {
                        rc.buildRobot(RobotType.WATCHTOWER, direction);
                        rc.writeSharedArray(19, rc.readSharedArray(19) + 1);
                        target = null;
                        repairTarget = currentLocation.add(direction);
                        phase = Phase.REPAIR;
                    }
                    return;
                }

                break;

            case REPAIR:
                if (isThereNoRepairTarget()) { phase = Phase.BUILD; }

                break;
        }

        if (repairTarget != null && rc.canRepair(repairTarget)) { rc.repair(repairTarget); }

        super.move();
    }

    private void findRepairTarget() {
        int minHealth = -INF;
        repairTarget = null;

        RobotInfo[] nearbyRobots = rc.senseNearbyRobots();
        for (RobotInfo robot : nearbyRobots) {
            if (robot.getTeam() != rc.getTeam() || !robot.getType().isBuilding()) continue;
            if (robot.getHealth() == robot.getType().getMaxHealth(1)) continue;
            if (currentLocation.distanceSquaredTo(robot.location) > 5) continue;

            if (robot.getMode() == RobotMode.PROTOTYPE) {
                repairTarget = robot.location;
                return;
            }

            int health = robot.getHealth();

            if(health < minHealth) {
                minHealth = health;
                repairTarget = robot.location;
            }
        }
    }

    private boolean isThereNoRepairTarget() throws GameActionException {
        if (!rc.canSenseRobotAtLocation(repairTarget)) { return true; }
        RobotInfo robot = rc.senseRobotAtLocation(repairTarget);
        return robot.getMode() != RobotMode.PROTOTYPE;
    }

    protected void selectRandomTarget() throws GameActionException {
        int t = Math.max((int)(Math.sqrt(rc.readSharedArray(19)) * 2), 5);
        int x1 = Math.max(parentArchonLocation.x - t, 0);
        int y1 = Math.max(parentArchonLocation.y - t, 0);
        int x2 = Math.min(parentArchonLocation.x + t, rc.getMapWidth() - 1);
        int y2 = Math.min(parentArchonLocation.y + t, rc.getMapHeight() - 1);
        int x, y;
        do {
            x = RNG.nextInt(x2 - x1 + 1) + x1;
        } while (x % 2 != parentArchonLocation.x % 2);
        do {
            y = RNG.nextInt(y2 - y1 + 1) + y1;
        } while (y % 2 != parentArchonLocation.y % 2);
        target = new MapLocation(x, y);
    }
}
