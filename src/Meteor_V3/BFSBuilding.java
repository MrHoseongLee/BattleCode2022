package Meteor_V3;

import battlecode.common.*;

public class BFSBuilding extends BFS {

    BFSBuilding(RobotController rc) {
        super(rc);
    }
    
    private static MapLocation l0;
    private static double v0;
    private static Direction d0;
    private static double p0;
    
    private static MapLocation l1;
    private static double v1;
    private static Direction d1;
    private static double p1;
    
    private static MapLocation l2;
    private static double v2;
    private static Direction d2;
    private static double p2;
    
    private static MapLocation l3;
    private static double v3;
    private static Direction d3;
    private static double p3;
    
    private static MapLocation l4;
    private static double v4;
    private static Direction d4;
    private static double p4;
    
    private static MapLocation l5;
    private static double v5;
    private static Direction d5;
    private static double p5;
    
    private static MapLocation l6;
    private static double v6;
    private static Direction d6;
    private static double p6;
    
    private static MapLocation l7;
    private static double v7;
    private static Direction d7;
    private static double p7;
    
    private static MapLocation l8;
    private static double v8;
    private static Direction d8;
    private static double p8;
    
    private static MapLocation l9;
    private static double v9;
    private static Direction d9;
    private static double p9;
    
    private static MapLocation l10;
    private static double v10;
    private static Direction d10;
    private static double p10;
    
    private static MapLocation l11;
    private static double v11;
    private static Direction d11;
    private static double p11;
    
    private static MapLocation l12;
    private static double v12;
    private static Direction d12;
    private static double p12;
    
    private static MapLocation l13;
    private static double v13;
    private static Direction d13;
    private static double p13;
    
    private static MapLocation l14;
    private static double v14;
    private static Direction d14;
    private static double p14;
    
    private static MapLocation l15;
    private static double v15;
    private static Direction d15;
    private static double p15;
    
    private static MapLocation l16;
    private static double v16;
    private static Direction d16;
    private static double p16;
    
    private static MapLocation l17;
    private static double v17;
    private static Direction d17;
    private static double p17;
    
    private static MapLocation l18;
    private static double v18;
    private static Direction d18;
    private static double p18;
    
    private static MapLocation l19;
    private static double v19;
    private static Direction d19;
    private static double p19;
    
    private static MapLocation l20;
    private static double v20;
    private static Direction d20;
    private static double p20;
    
    private static MapLocation l21;
    private static double v21;
    private static Direction d21;
    private static double p21;
    
    private static MapLocation l22;
    private static double v22;
    private static Direction d22;
    private static double p22;
    
    private static MapLocation l23;
    private static double v23;
    private static Direction d23;
    private static double p23;
    
    private static MapLocation l24;
    private static double v24;
    private static Direction d24;
    private static double p24;
    
    private static MapLocation l25;
    private static double v25;
    private static Direction d25;
    private static double p25;
    
    private static MapLocation l26;
    private static double v26;
    private static Direction d26;
    private static double p26;
    
    private static MapLocation l27;
    private static double v27;
    private static Direction d27;
    private static double p27;
    
    private static MapLocation l28;
    private static double v28;
    private static Direction d28;
    private static double p28;
    
    private static MapLocation l29;
    private static double v29;
    private static Direction d29;
    private static double p29;
    
    private static MapLocation l30;
    private static double v30;
    private static Direction d30;
    private static double p30;
    
    private static MapLocation l31;
    private static double v31;
    private static Direction d31;
    private static double p31;
    
    private static MapLocation l32;
    private static double v32;
    private static Direction d32;
    private static double p32;
    
    private static MapLocation l33;
    private static double v33;
    private static Direction d33;
    private static double p33;
    
    private static MapLocation l34;
    private static double v34;
    private static Direction d34;
    private static double p34;
    
    private static MapLocation l35;
    private static double v35;
    private static Direction d35;
    private static double p35;
    
    private static MapLocation l36;
    private static double v36;
    private static Direction d36;
    private static double p36;
    
    private static MapLocation l37;
    private static double v37;
    private static Direction d37;
    private static double p37;
    
    private static MapLocation l38;
    private static double v38;
    private static Direction d38;
    private static double p38;
    
    private static MapLocation l39;
    private static double v39;
    private static Direction d39;
    private static double p39;
    
    private static MapLocation l40;
    private static double v40;
    private static Direction d40;
    private static double p40;
    
    private static MapLocation l41;
    private static double v41;
    private static Direction d41;
    private static double p41;
    
    private static MapLocation l42;
    private static double v42;
    private static Direction d42;
    private static double p42;
    
    private static MapLocation l43;
    private static double v43;
    private static Direction d43;
    private static double p43;
    
    private static MapLocation l44;
    private static double v44;
    private static Direction d44;
    private static double p44;
    
    private static MapLocation l45;
    private static double v45;
    private static Direction d45;
    private static double p45;
    
    private static MapLocation l46;
    private static double v46;
    private static Direction d46;
    private static double p46;
    
    private static MapLocation l47;
    private static double v47;
    private static Direction d47;
    private static double p47;
    
    private static MapLocation l48;
    private static double v48;
    private static Direction d48;
    private static double p48;
    
    private static MapLocation l49;
    private static double v49;
    private static Direction d49;
    private static double p49;
    
    private static MapLocation l50;
    private static double v50;
    private static Direction d50;
    private static double p50;
    
    private static MapLocation l51;
    private static double v51;
    private static Direction d51;
    private static double p51;
    
    private static MapLocation l52;
    private static double v52;
    private static Direction d52;
    private static double p52;
    
    private static MapLocation l53;
    private static double v53;
    private static Direction d53;
    private static double p53;
    
    private static MapLocation l54;
    private static double v54;
    private static Direction d54;
    
    private static MapLocation l55;
    private static double v55;
    private static Direction d55;
    private static double p55;
    
    private static MapLocation l56;
    private static double v56;
    private static Direction d56;
    private static double p56;
    
    private static MapLocation l57;
    private static double v57;
    private static Direction d57;
    private static double p57;
    
    private static MapLocation l58;
    private static double v58;
    private static Direction d58;
    private static double p58;
    
    private static MapLocation l59;
    private static double v59;
    private static Direction d59;
    private static double p59;
    
    private static MapLocation l60;
    private static double v60;
    private static Direction d60;
    private static double p60;
    
    private static MapLocation l61;
    private static double v61;
    private static Direction d61;
    private static double p61;
    
    private static MapLocation l62;
    private static double v62;
    private static Direction d62;
    private static double p62;
    
    private static MapLocation l63;
    private static double v63;
    private static Direction d63;
    private static double p63;
    
    private static MapLocation l64;
    private static double v64;
    private static Direction d64;
    private static double p64;
    
    private static MapLocation l65;
    private static double v65;
    private static Direction d65;
    private static double p65;
    
    private static MapLocation l66;
    private static double v66;
    private static Direction d66;
    private static double p66;
    
    private static MapLocation l67;
    private static double v67;
    private static Direction d67;
    private static double p67;
    
    private static MapLocation l68;
    private static double v68;
    private static Direction d68;
    private static double p68;
    
    private static MapLocation l69;
    private static double v69;
    private static Direction d69;
    private static double p69;
    
    private static MapLocation l70;
    private static double v70;
    private static Direction d70;
    private static double p70;
    
    private static MapLocation l71;
    private static double v71;
    private static Direction d71;
    private static double p71;
    
    private static MapLocation l72;
    private static double v72;
    private static Direction d72;
    private static double p72;
    
    private static MapLocation l73;
    private static double v73;
    private static Direction d73;
    private static double p73;
    
    private static MapLocation l74;
    private static double v74;
    private static Direction d74;
    private static double p74;
    
    private static MapLocation l75;
    private static double v75;
    private static Direction d75;
    private static double p75;
    
    private static MapLocation l76;
    private static double v76;
    private static Direction d76;
    private static double p76;
    
    private static MapLocation l77;
    private static double v77;
    private static Direction d77;
    private static double p77;
    
    private static MapLocation l78;
    private static double v78;
    private static Direction d78;
    private static double p78;
    
    private static MapLocation l79;
    private static double v79;
    private static Direction d79;
    private static double p79;
    
    private static MapLocation l80;
    private static double v80;
    private static Direction d80;
    private static double p80;
    
    private static MapLocation l81;
    private static double v81;
    private static Direction d81;
    private static double p81;
    
    private static MapLocation l82;
    private static double v82;
    private static Direction d82;
    private static double p82;
    
    private static MapLocation l83;
    private static double v83;
    private static Direction d83;
    private static double p83;
    
    private static MapLocation l84;
    private static double v84;
    private static Direction d84;
    private static double p84;
    
    private static MapLocation l85;
    private static double v85;
    private static Direction d85;
    private static double p85;
    
    private static MapLocation l86;
    private static double v86;
    private static Direction d86;
    private static double p86;
    
    private static MapLocation l87;
    private static double v87;
    private static Direction d87;
    private static double p87;
    
    private static MapLocation l88;
    private static double v88;
    private static Direction d88;
    private static double p88;
    
    private static MapLocation l89;
    private static double v89;
    private static Direction d89;
    private static double p89;
    
    private static MapLocation l90;
    private static double v90;
    private static Direction d90;
    private static double p90;
    
    private static MapLocation l91;
    private static double v91;
    private static Direction d91;
    private static double p91;
    
    private static MapLocation l92;
    private static double v92;
    private static Direction d92;
    private static double p92;
    
    private static MapLocation l93;
    private static double v93;
    private static Direction d93;
    private static double p93;
    
    private static MapLocation l94;
    private static double v94;
    private static Direction d94;
    private static double p94;
    
    private static MapLocation l95;
    private static double v95;
    private static Direction d95;
    private static double p95;
    
    private static MapLocation l96;
    private static double v96;
    private static Direction d96;
    private static double p96;
    
    private static MapLocation l97;
    private static double v97;
    private static Direction d97;
    private static double p97;
    
    private static MapLocation l98;
    private static double v98;
    private static Direction d98;
    private static double p98;
    
    private static MapLocation l99;
    private static double v99;
    private static Direction d99;
    private static double p99;
    
    private static MapLocation l100;
    private static double v100;
    private static Direction d100;
    private static double p100;
    
    private static MapLocation l101;
    private static double v101;
    private static Direction d101;
    private static double p101;
    
    private static MapLocation l102;
    private static double v102;
    private static Direction d102;
    private static double p102;
    
    private static MapLocation l103;
    private static double v103;
    private static Direction d103;
    private static double p103;
    
    private static MapLocation l104;
    private static double v104;
    private static Direction d104;
    private static double p104;
    
    private static MapLocation l105;
    private static double v105;
    private static Direction d105;
    private static double p105;
    
    private static MapLocation l106;
    private static double v106;
    private static Direction d106;
    private static double p106;
    
    private static MapLocation l107;
    private static double v107;
    private static Direction d107;
    private static double p107;
    
    private static MapLocation l108;
    private static double v108;
    private static Direction d108;
    private static double p108;
    
    protected Direction getBestDirection(MapLocation target) throws GameActionException {
        int dx = target.x - currentLocation.x;
        int dy = target.y - currentLocation.y;

        if (dx > 0 && dx >= dy && dx >= -dy ) { return getBestDirection0(target); }
        if (dx < 0 && dx <= dy && dx <= -dy ) { return getBestDirection1(target); }
        if (dy > 0 && dx <= dy && -dx <= dy ) { return getBestDirection2(target); }
        if (dy < 0 && dx >= dy && -dx >= dy ) { return getBestDirection3(target); }

        return Direction.CENTER;
    }
    
    private Direction getBestDirection0(MapLocation target) throws GameActionException {
        l54 = currentLocation;
        v54 = 0; 
        l65 = l54.add(Direction.EAST);
        v65 = 1000000;
        d65 = null;
        l66 = l54.add(Direction.NORTHEAST);
        v66 = 1000000;
        d66 = null;
        l55 = l54.add(Direction.NORTH);
        v55 = 1000000;
        d55 = null;
        l53 = l54.add(Direction.SOUTH);
        v53 = 1000000;
        d53 = null;
        l64 = l54.add(Direction.SOUTHEAST);
        v64 = 1000000;
        d64 = null;
        l52 = l53.add(Direction.SOUTH);
        v52 = 1000000;
        d52 = null;
        l63 = l53.add(Direction.SOUTHEAST);
        v63 = 1000000;
        d63 = null;
        l67 = l55.add(Direction.NORTHEAST);
        v67 = 1000000;
        d67 = null;
        l56 = l55.add(Direction.NORTH);
        v56 = 1000000;
        d56 = null;
        l76 = l65.add(Direction.EAST);
        v76 = 1000000;
        d76 = null;
        l77 = l65.add(Direction.NORTHEAST);
        v77 = 1000000;
        d77 = null;
        l75 = l65.add(Direction.SOUTHEAST);
        v75 = 1000000;
        d75 = null;
        l74 = l64.add(Direction.SOUTHEAST);
        v74 = 1000000;
        d74 = null;
        l78 = l66.add(Direction.NORTHEAST);
        v78 = 1000000;
        d78 = null;
        l51 = l52.add(Direction.SOUTH);
        v51 = 1000000;
        d51 = null;
        l62 = l52.add(Direction.SOUTHEAST);
        v62 = 1000000;
        d62 = null;
        l87 = l76.add(Direction.EAST);
        v87 = 1000000;
        d87 = null;
        l88 = l76.add(Direction.NORTHEAST);
        v88 = 1000000;
        d88 = null;
        l86 = l76.add(Direction.SOUTHEAST);
        v86 = 1000000;
        d86 = null;
        l68 = l56.add(Direction.NORTHEAST);
        v68 = 1000000;
        d68 = null;
        l57 = l56.add(Direction.NORTH);
        v57 = 1000000;
        d57 = null;
        l85 = l75.add(Direction.SOUTHEAST);
        v85 = 1000000;
        d85 = null;
        l79 = l67.add(Direction.NORTHEAST);
        v79 = 1000000;
        d79 = null;
        l89 = l77.add(Direction.NORTHEAST);
        v89 = 1000000;
        d89 = null;
        l73 = l63.add(Direction.SOUTHEAST);
        v73 = 1000000;
        d73 = null;
        l84 = l74.add(Direction.SOUTHEAST);
        v84 = 1000000;
        d84 = null;
        l90 = l78.add(Direction.NORTHEAST);
        v90 = 1000000;
        d90 = null;
        l50 = l51.add(Direction.SOUTH);
        v50 = 1000000;
        d50 = null;
        l61 = l51.add(Direction.SOUTHEAST);
        v61 = 1000000;
        d61 = null;
        l97 = l87.add(Direction.EAST);
        v97 = 1000000;
        d97 = null;
        l98 = l87.add(Direction.NORTHEAST);
        v98 = 1000000;
        d98 = null;
        l96 = l87.add(Direction.SOUTHEAST);
        v96 = 1000000;
        d96 = null;
        l69 = l57.add(Direction.NORTHEAST);
        v69 = 1000000;
        d69 = null;
        l58 = l57.add(Direction.NORTH);
        v58 = 1000000;
        d58 = null;
        l72 = l62.add(Direction.SOUTHEAST);
        v72 = 1000000;
        d72 = null;
        l80 = l68.add(Direction.NORTHEAST);
        v80 = 1000000;
        d80 = null;
        l99 = l88.add(Direction.NORTHEAST);
        v99 = 1000000;
        d99 = null;
        l95 = l86.add(Direction.SOUTHEAST);
        v95 = 1000000;
        d95 = null;
        l100 = l89.add(Direction.NORTHEAST);
        v100 = 1000000;
        d100 = null;
        l94 = l85.add(Direction.SOUTHEAST);
        v94 = 1000000;
        d94 = null;
        l83 = l73.add(Direction.SOUTHEAST);
        v83 = 1000000;
        d83 = null;
        l91 = l79.add(Direction.NORTHEAST);
        v91 = 1000000;
        d91 = null;
        l101 = l90.add(Direction.NORTHEAST);
        v101 = 1000000;
        d101 = null;
        l93 = l84.add(Direction.SOUTHEAST);
        v93 = 1000000;
        d93 = null;
        l70 = l58.add(Direction.NORTHEAST);
        v70 = 1000000;
        d70 = null;
        l59 = l58.add(Direction.NORTH);
        v59 = 1000000;
        d59 = null;
        l49 = l50.add(Direction.SOUTH);
        v49 = 1000000;
        d49 = null;
        l60 = l50.add(Direction.SOUTHEAST);
        v60 = 1000000;
        d60 = null;
        l105 = l97.add(Direction.EAST);
        v105 = 1000000;
        d105 = null;
        l106 = l97.add(Direction.NORTHEAST);
        v106 = 1000000;
        d106 = null;
        l104 = l97.add(Direction.SOUTHEAST);
        v104 = 1000000;
        d104 = null;
        l81 = l69.add(Direction.NORTHEAST);
        v81 = 1000000;
        d81 = null;
        l103 = l96.add(Direction.SOUTHEAST);
        v103 = 1000000;
        d103 = null;
        l71 = l61.add(Direction.SOUTHEAST);
        v71 = 1000000;
        d71 = null;
        l107 = l98.add(Direction.NORTHEAST);
        v107 = 1000000;
        d107 = null;
        l102 = l95.add(Direction.SOUTHEAST);
        v102 = 1000000;
        d102 = null;
        l108 = l99.add(Direction.NORTHEAST);
        v108 = 1000000;
        d108 = null;
        l82 = l72.add(Direction.SOUTHEAST);
        v82 = 1000000;
        d82 = null;
        l92 = l80.add(Direction.NORTHEAST);
        v92 = 1000000;
        d92 = null;
    
        if (rc.onTheMap(l53) && (target.equals(l53) || !rc.canSenseRobotAtLocation(l53))) {
            p53 = 1 + rc.senseRubble(l53) / 10.0;
            if (v53 > v54 + p53) {
                v53 = v54 + p53;
                d53 = Direction.SOUTH;
            }
        }
        if (rc.onTheMap(l55) && (target.equals(l55) || !rc.canSenseRobotAtLocation(l55))) {
            p55 = 1 + rc.senseRubble(l55) / 10.0;
            if (v55 > v54 + p55) {
                v55 = v54 + p55;
                d55 = Direction.NORTH;
            }
        }
        if (rc.onTheMap(l65) && (target.equals(l65) || !rc.canSenseRobotAtLocation(l65))) {
            p65 = 1 + rc.senseRubble(l65) / 10.0;
            if (v65 > v54 + p65) {
                v65 = v54 + p65;
                d65 = Direction.EAST;
            }
        }
        if (rc.onTheMap(l64) && (target.equals(l64) || !rc.canSenseRobotAtLocation(l64))) {
            p64 = 1 + rc.senseRubble(l64) / 10.0;
            if (v64 > v54 + p64) {
                v64 = v54 + p64;
                d64 = Direction.SOUTHEAST;
            }
        }
        if (rc.onTheMap(l66) && (target.equals(l66) || !rc.canSenseRobotAtLocation(l66))) {
            p66 = 1 + rc.senseRubble(l66) / 10.0;
            if (v66 > v54 + p66) {
                v66 = v54 + p66;
                d66 = Direction.NORTHEAST;
            }
        }
        if (rc.onTheMap(l52) && (target.equals(l52) || !rc.canSenseRobotAtLocation(l52))) {
            p52 = 1 + rc.senseRubble(l52) / 10.0;
            if (v52 > v64 + p52) {
                v52 = v64 + p52;
                d52 = d64;
            }
            if (v52 > v53 + p52) {
                v52 = v53 + p52;
                d52 = d53;
            }
        }
        if (rc.onTheMap(l76) && (target.equals(l76) || !rc.canSenseRobotAtLocation(l76))) {
            p76 = 1 + rc.senseRubble(l76) / 10.0;
            if (v76 > v66 + p76) {
                v76 = v66 + p76;
                d76 = d66;
            }
            if (v76 > v65 + p76) {
                v76 = v65 + p76;
                d76 = d65;
            }
            if (v76 > v64 + p76) {
                v76 = v64 + p76;
                d76 = d64;
            }
        }
        if (rc.onTheMap(l56) && (target.equals(l56) || !rc.canSenseRobotAtLocation(l56))) {
            p56 = 1 + rc.senseRubble(l56) / 10.0;
            if (v56 > v55 + p56) {
                v56 = v55 + p56;
                d56 = d55;
            }
            if (v56 > v66 + p56) {
                v56 = v66 + p56;
                d56 = d66;
            }
        }
        if (rc.onTheMap(l75) && (target.equals(l75) || !rc.canSenseRobotAtLocation(l75))) {
            p75 = 1 + rc.senseRubble(l75) / 10.0;
            if (v75 > v76 + p75) {
                v75 = v76 + p75;
                d75 = d76;
            }
            if (v75 > v65 + p75) {
                v75 = v65 + p75;
                d75 = d65;
            }
            if (v75 > v64 + p75) {
                v75 = v64 + p75;
                d75 = d64;
            }
            if (v75 > v63 + p75) {
                v75 = v63 + p75;
                d75 = d63;
            }
        }
        if (rc.onTheMap(l67) && (target.equals(l67) || !rc.canSenseRobotAtLocation(l67))) {
            p67 = 1 + rc.senseRubble(l67) / 10.0;
            if (v67 > v56 + p67) {
                v67 = v56 + p67;
                d67 = d56;
            }
            if (v67 > v55 + p67) {
                v67 = v55 + p67;
                d67 = d55;
            }
            if (v67 > v66 + p67) {
                v67 = v66 + p67;
                d67 = d66;
            }
            if (v67 > v77 + p67) {
                v67 = v77 + p67;
                d67 = d77;
            }
        }
        if (rc.onTheMap(l77) && (target.equals(l77) || !rc.canSenseRobotAtLocation(l77))) {
            p77 = 1 + rc.senseRubble(l77) / 10.0;
            if (v77 > v67 + p77) {
                v77 = v67 + p77;
                d77 = d67;
            }
            if (v77 > v66 + p77) {
                v77 = v66 + p77;
                d77 = d66;
            }
            if (v77 > v65 + p77) {
                v77 = v65 + p77;
                d77 = d65;
            }
            if (v77 > v76 + p77) {
                v77 = v76 + p77;
                d77 = d76;
            }
        }
        if (rc.onTheMap(l63) && (target.equals(l63) || !rc.canSenseRobotAtLocation(l63))) {
            p63 = 1 + rc.senseRubble(l63) / 10.0;
            if (v63 > v75 + p63) {
                v63 = v75 + p63;
                d63 = d75;
            }
            if (v63 > v64 + p63) {
                v63 = v64 + p63;
                d63 = d64;
            }
            if (v63 > v53 + p63) {
                v63 = v53 + p63;
                d63 = d53;
            }
            if (v63 > v52 + p63) {
                v63 = v52 + p63;
                d63 = d52;
            }
        }
        if (rc.onTheMap(l74) && (target.equals(l74) || !rc.canSenseRobotAtLocation(l74))) {
            p74 = 1 + rc.senseRubble(l74) / 10.0;
            if (v74 > v75 + p74) {
                v74 = v75 + p74;
                d74 = d75;
            }
            if (v74 > v64 + p74) {
                v74 = v64 + p74;
                d74 = d64;
            }
            if (v74 > v63 + p74) {
                v74 = v63 + p74;
                d74 = d63;
            }
        }
        if (rc.onTheMap(l78) && (target.equals(l78) || !rc.canSenseRobotAtLocation(l78))) {
            p78 = 1 + rc.senseRubble(l78) / 10.0;
            if (v78 > v67 + p78) {
                v78 = v67 + p78;
                d78 = d67;
            }
            if (v78 > v66 + p78) {
                v78 = v66 + p78;
                d78 = d66;
            }
            if (v78 > v77 + p78) {
                v78 = v77 + p78;
                d78 = d77;
            }
        }
        if (rc.onTheMap(l51) && (target.equals(l51) || !rc.canSenseRobotAtLocation(l51))) {
            p51 = 1 + rc.senseRubble(l51) / 10.0;
            if (v51 > v63 + p51) {
                v51 = v63 + p51;
                d51 = d63;
            }
            if (v51 > v52 + p51) {
                v51 = v52 + p51;
                d51 = d52;
            }
        }
        if (rc.onTheMap(l87) && (target.equals(l87) || !rc.canSenseRobotAtLocation(l87))) {
            p87 = 1 + rc.senseRubble(l87) / 10.0;
            if (v87 > v77 + p87) {
                v87 = v77 + p87;
                d87 = d77;
            }
            if (v87 > v76 + p87) {
                v87 = v76 + p87;
                d87 = d76;
            }
            if (v87 > v75 + p87) {
                v87 = v75 + p87;
                d87 = d75;
            }
        }
        if (rc.onTheMap(l57) && (target.equals(l57) || !rc.canSenseRobotAtLocation(l57))) {
            p57 = 1 + rc.senseRubble(l57) / 10.0;
            if (v57 > v56 + p57) {
                v57 = v56 + p57;
                d57 = d56;
            }
            if (v57 > v67 + p57) {
                v57 = v67 + p57;
                d57 = d67;
            }
        }
        if (rc.onTheMap(l62) && (target.equals(l62) || !rc.canSenseRobotAtLocation(l62))) {
            p62 = 1 + rc.senseRubble(l62) / 10.0;
            if (v62 > v74 + p62) {
                v62 = v74 + p62;
                d62 = d74;
            }
            if (v62 > v63 + p62) {
                v62 = v63 + p62;
                d62 = d63;
            }
            if (v62 > v52 + p62) {
                v62 = v52 + p62;
                d62 = d52;
            }
            if (v62 > v51 + p62) {
                v62 = v51 + p62;
                d62 = d51;
            }
        }
        if (rc.onTheMap(l68) && (target.equals(l68) || !rc.canSenseRobotAtLocation(l68))) {
            p68 = 1 + rc.senseRubble(l68) / 10.0;
            if (v68 > v57 + p68) {
                v68 = v57 + p68;
                d68 = d57;
            }
            if (v68 > v56 + p68) {
                v68 = v56 + p68;
                d68 = d56;
            }
            if (v68 > v67 + p68) {
                v68 = v67 + p68;
                d68 = d67;
            }
            if (v68 > v78 + p68) {
                v68 = v78 + p68;
                d68 = d78;
            }
        }
        if (rc.onTheMap(l88) && (target.equals(l88) || !rc.canSenseRobotAtLocation(l88))) {
            p88 = 1 + rc.senseRubble(l88) / 10.0;
            if (v88 > v78 + p88) {
                v88 = v78 + p88;
                d88 = d78;
            }
            if (v88 > v77 + p88) {
                v88 = v77 + p88;
                d88 = d77;
            }
            if (v88 > v76 + p88) {
                v88 = v76 + p88;
                d88 = d76;
            }
            if (v88 > v87 + p88) {
                v88 = v87 + p88;
                d88 = d87;
            }
        }
        if (rc.onTheMap(l86) && (target.equals(l86) || !rc.canSenseRobotAtLocation(l86))) {
            p86 = 1 + rc.senseRubble(l86) / 10.0;
            if (v86 > v87 + p86) {
                v86 = v87 + p86;
                d86 = d87;
            }
            if (v86 > v76 + p86) {
                v86 = v76 + p86;
                d86 = d76;
            }
            if (v86 > v75 + p86) {
                v86 = v75 + p86;
                d86 = d75;
            }
            if (v86 > v74 + p86) {
                v86 = v74 + p86;
                d86 = d74;
            }
        }
        if (rc.onTheMap(l89) && (target.equals(l89) || !rc.canSenseRobotAtLocation(l89))) {
            p89 = 1 + rc.senseRubble(l89) / 10.0;
            if (v89 > v79 + p89) {
                v89 = v79 + p89;
                d89 = d79;
            }
            if (v89 > v78 + p89) {
                v89 = v78 + p89;
                d89 = d78;
            }
            if (v89 > v77 + p89) {
                v89 = v77 + p89;
                d89 = d77;
            }
            if (v89 > v88 + p89) {
                v89 = v88 + p89;
                d89 = d88;
            }
        }
        if (rc.onTheMap(l85) && (target.equals(l85) || !rc.canSenseRobotAtLocation(l85))) {
            p85 = 1 + rc.senseRubble(l85) / 10.0;
            if (v85 > v86 + p85) {
                v85 = v86 + p85;
                d85 = d86;
            }
            if (v85 > v75 + p85) {
                v85 = v75 + p85;
                d85 = d75;
            }
            if (v85 > v74 + p85) {
                v85 = v74 + p85;
                d85 = d74;
            }
            if (v85 > v73 + p85) {
                v85 = v73 + p85;
                d85 = d73;
            }
        }
        if (rc.onTheMap(l73) && (target.equals(l73) || !rc.canSenseRobotAtLocation(l73))) {
            p73 = 1 + rc.senseRubble(l73) / 10.0;
            if (v73 > v85 + p73) {
                v73 = v85 + p73;
                d73 = d85;
            }
            if (v73 > v74 + p73) {
                v73 = v74 + p73;
                d73 = d74;
            }
            if (v73 > v63 + p73) {
                v73 = v63 + p73;
                d73 = d63;
            }
            if (v73 > v62 + p73) {
                v73 = v62 + p73;
                d73 = d62;
            }
        }
        if (rc.onTheMap(l79) && (target.equals(l79) || !rc.canSenseRobotAtLocation(l79))) {
            p79 = 1 + rc.senseRubble(l79) / 10.0;
            if (v79 > v68 + p79) {
                v79 = v68 + p79;
                d79 = d68;
            }
            if (v79 > v67 + p79) {
                v79 = v67 + p79;
                d79 = d67;
            }
            if (v79 > v78 + p79) {
                v79 = v78 + p79;
                d79 = d78;
            }
            if (v79 > v89 + p79) {
                v79 = v89 + p79;
                d79 = d89;
            }
        }
        if (rc.onTheMap(l90) && (target.equals(l90) || !rc.canSenseRobotAtLocation(l90))) {
            p90 = 1 + rc.senseRubble(l90) / 10.0;
            if (v90 > v79 + p90) {
                v90 = v79 + p90;
                d90 = d79;
            }
            if (v90 > v78 + p90) {
                v90 = v78 + p90;
                d90 = d78;
            }
            if (v90 > v89 + p90) {
                v90 = v89 + p90;
                d90 = d89;
            }
        }
        if (rc.onTheMap(l84) && (target.equals(l84) || !rc.canSenseRobotAtLocation(l84))) {
            p84 = 1 + rc.senseRubble(l84) / 10.0;
            if (v84 > v85 + p84) {
                v84 = v85 + p84;
                d84 = d85;
            }
            if (v84 > v74 + p84) {
                v84 = v74 + p84;
                d84 = d74;
            }
            if (v84 > v73 + p84) {
                v84 = v73 + p84;
                d84 = d73;
            }
        }
        if (rc.onTheMap(l58) && (target.equals(l58) || !rc.canSenseRobotAtLocation(l58))) {
            p58 = 1 + rc.senseRubble(l58) / 10.0;
            if (v58 > v57 + p58) {
                v58 = v57 + p58;
                d58 = d57;
            }
            if (v58 > v68 + p58) {
                v58 = v68 + p58;
                d58 = d68;
            }
        }
        if (rc.onTheMap(l50) && (target.equals(l50) || !rc.canSenseRobotAtLocation(l50))) {
            p50 = 1 + rc.senseRubble(l50) / 10.0;
            if (v50 > v62 + p50) {
                v50 = v62 + p50;
                d50 = d62;
            }
            if (v50 > v51 + p50) {
                v50 = v51 + p50;
                d50 = d51;
            }
        }
        if (rc.onTheMap(l97) && (target.equals(l97) || !rc.canSenseRobotAtLocation(l97))) {
            p97 = 1 + rc.senseRubble(l97) / 10.0;
            if (v97 > v88 + p97) {
                v97 = v88 + p97;
                d97 = d88;
            }
            if (v97 > v87 + p97) {
                v97 = v87 + p97;
                d97 = d87;
            }
            if (v97 > v86 + p97) {
                v97 = v86 + p97;
                d97 = d86;
            }
        }
        if (rc.onTheMap(l69) && (target.equals(l69) || !rc.canSenseRobotAtLocation(l69))) {
            p69 = 1 + rc.senseRubble(l69) / 10.0;
            if (v69 > v58 + p69) {
                v69 = v58 + p69;
                d69 = d58;
            }
            if (v69 > v57 + p69) {
                v69 = v57 + p69;
                d69 = d57;
            }
            if (v69 > v68 + p69) {
                v69 = v68 + p69;
                d69 = d68;
            }
            if (v69 > v79 + p69) {
                v69 = v79 + p69;
                d69 = d79;
            }
        }
        if (rc.onTheMap(l96) && (target.equals(l96) || !rc.canSenseRobotAtLocation(l96))) {
            p96 = 1 + rc.senseRubble(l96) / 10.0;
            if (v96 > v97 + p96) {
                v96 = v97 + p96;
                d96 = d97;
            }
            if (v96 > v87 + p96) {
                v96 = v87 + p96;
                d96 = d87;
            }
            if (v96 > v86 + p96) {
                v96 = v86 + p96;
                d96 = d86;
            }
            if (v96 > v85 + p96) {
                v96 = v85 + p96;
                d96 = d85;
            }
        }
        if (rc.onTheMap(l61) && (target.equals(l61) || !rc.canSenseRobotAtLocation(l61))) {
            p61 = 1 + rc.senseRubble(l61) / 10.0;
            if (v61 > v73 + p61) {
                v61 = v73 + p61;
                d61 = d73;
            }
            if (v61 > v62 + p61) {
                v61 = v62 + p61;
                d61 = d62;
            }
            if (v61 > v51 + p61) {
                v61 = v51 + p61;
                d61 = d51;
            }
            if (v61 > v50 + p61) {
                v61 = v50 + p61;
                d61 = d50;
            }
        }
        if (rc.onTheMap(l98) && (target.equals(l98) || !rc.canSenseRobotAtLocation(l98))) {
            p98 = 1 + rc.senseRubble(l98) / 10.0;
            if (v98 > v89 + p98) {
                v98 = v89 + p98;
                d98 = d89;
            }
            if (v98 > v88 + p98) {
                v98 = v88 + p98;
                d98 = d88;
            }
            if (v98 > v87 + p98) {
                v98 = v87 + p98;
                d98 = d87;
            }
            if (v98 > v97 + p98) {
                v98 = v97 + p98;
                d98 = d97;
            }
        }
        if (rc.onTheMap(l95) && (target.equals(l95) || !rc.canSenseRobotAtLocation(l95))) {
            p95 = 1 + rc.senseRubble(l95) / 10.0;
            if (v95 > v96 + p95) {
                v95 = v96 + p95;
                d95 = d96;
            }
            if (v95 > v86 + p95) {
                v95 = v86 + p95;
                d95 = d86;
            }
            if (v95 > v85 + p95) {
                v95 = v85 + p95;
                d95 = d85;
            }
            if (v95 > v84 + p95) {
                v95 = v84 + p95;
                d95 = d84;
            }
        }
        if (rc.onTheMap(l99) && (target.equals(l99) || !rc.canSenseRobotAtLocation(l99))) {
            p99 = 1 + rc.senseRubble(l99) / 10.0;
            if (v99 > v90 + p99) {
                v99 = v90 + p99;
                d99 = d90;
            }
            if (v99 > v89 + p99) {
                v99 = v89 + p99;
                d99 = d89;
            }
            if (v99 > v88 + p99) {
                v99 = v88 + p99;
                d99 = d88;
            }
            if (v99 > v98 + p99) {
                v99 = v98 + p99;
                d99 = d98;
            }
        }
        if (rc.onTheMap(l72) && (target.equals(l72) || !rc.canSenseRobotAtLocation(l72))) {
            p72 = 1 + rc.senseRubble(l72) / 10.0;
            if (v72 > v84 + p72) {
                v72 = v84 + p72;
                d72 = d84;
            }
            if (v72 > v73 + p72) {
                v72 = v73 + p72;
                d72 = d73;
            }
            if (v72 > v62 + p72) {
                v72 = v62 + p72;
                d72 = d62;
            }
            if (v72 > v61 + p72) {
                v72 = v61 + p72;
                d72 = d61;
            }
        }
        if (rc.onTheMap(l80) && (target.equals(l80) || !rc.canSenseRobotAtLocation(l80))) {
            p80 = 1 + rc.senseRubble(l80) / 10.0;
            if (v80 > v69 + p80) {
                v80 = v69 + p80;
                d80 = d69;
            }
            if (v80 > v68 + p80) {
                v80 = v68 + p80;
                d80 = d68;
            }
            if (v80 > v79 + p80) {
                v80 = v79 + p80;
                d80 = d79;
            }
            if (v80 > v90 + p80) {
                v80 = v90 + p80;
                d80 = d90;
            }
        }
        if (rc.onTheMap(l83) && (target.equals(l83) || !rc.canSenseRobotAtLocation(l83))) {
            p83 = 1 + rc.senseRubble(l83) / 10.0;
            if (v83 > v94 + p83) {
                v83 = v94 + p83;
                d83 = d94;
            }
            if (v83 > v84 + p83) {
                v83 = v84 + p83;
                d83 = d84;
            }
            if (v83 > v73 + p83) {
                v83 = v73 + p83;
                d83 = d73;
            }
            if (v83 > v72 + p83) {
                v83 = v72 + p83;
                d83 = d72;
            }
        }
        if (rc.onTheMap(l91) && (target.equals(l91) || !rc.canSenseRobotAtLocation(l91))) {
            p91 = 1 + rc.senseRubble(l91) / 10.0;
            if (v91 > v80 + p91) {
                v91 = v80 + p91;
                d91 = d80;
            }
            if (v91 > v79 + p91) {
                v91 = v79 + p91;
                d91 = d79;
            }
            if (v91 > v90 + p91) {
                v91 = v90 + p91;
                d91 = d90;
            }
            if (v91 > v100 + p91) {
                v91 = v100 + p91;
                d91 = d100;
            }
        }
        if (rc.onTheMap(l94) && (target.equals(l94) || !rc.canSenseRobotAtLocation(l94))) {
            p94 = 1 + rc.senseRubble(l94) / 10.0;
            if (v94 > v95 + p94) {
                v94 = v95 + p94;
                d94 = d95;
            }
            if (v94 > v85 + p94) {
                v94 = v85 + p94;
                d94 = d85;
            }
            if (v94 > v84 + p94) {
                v94 = v84 + p94;
                d94 = d84;
            }
            if (v94 > v83 + p94) {
                v94 = v83 + p94;
                d94 = d83;
            }
        }
        if (rc.onTheMap(l100) && (target.equals(l100) || !rc.canSenseRobotAtLocation(l100))) {
            p100 = 1 + rc.senseRubble(l100) / 10.0;
            if (v100 > v91 + p100) {
                v100 = v91 + p100;
                d100 = d91;
            }
            if (v100 > v90 + p100) {
                v100 = v90 + p100;
                d100 = d90;
            }
            if (v100 > v89 + p100) {
                v100 = v89 + p100;
                d100 = d89;
            }
            if (v100 > v99 + p100) {
                v100 = v99 + p100;
                d100 = d99;
            }
        }
        if (rc.onTheMap(l101) && (target.equals(l101) || !rc.canSenseRobotAtLocation(l101))) {
            p101 = 1 + rc.senseRubble(l101) / 10.0;
            if (v101 > v91 + p101) {
                v101 = v91 + p101;
                d101 = d91;
            }
            if (v101 > v90 + p101) {
                v101 = v90 + p101;
                d101 = d90;
            }
            if (v101 > v100 + p101) {
                v101 = v100 + p101;
                d101 = d100;
            }
        }
        if (rc.onTheMap(l93) && (target.equals(l93) || !rc.canSenseRobotAtLocation(l93))) {
            p93 = 1 + rc.senseRubble(l93) / 10.0;
            if (v93 > v94 + p93) {
                v93 = v94 + p93;
                d93 = d94;
            }
            if (v93 > v84 + p93) {
                v93 = v84 + p93;
                d93 = d84;
            }
            if (v93 > v83 + p93) {
                v93 = v83 + p93;
                d93 = d83;
            }
        }
        if (rc.onTheMap(l49) && (target.equals(l49) || !rc.canSenseRobotAtLocation(l49))) {
            p49 = 1 + rc.senseRubble(l49) / 10.0;
            if (v49 > v61 + p49) {
                v49 = v61 + p49;
                d49 = d61;
            }
            if (v49 > v50 + p49) {
                v49 = v50 + p49;
                d49 = d50;
            }
        }
        if (rc.onTheMap(l105) && (target.equals(l105) || !rc.canSenseRobotAtLocation(l105))) {
            p105 = 1 + rc.senseRubble(l105) / 10.0;
            if (v105 > v98 + p105) {
                v105 = v98 + p105;
                d105 = d98;
            }
            if (v105 > v97 + p105) {
                v105 = v97 + p105;
                d105 = d97;
            }
            if (v105 > v96 + p105) {
                v105 = v96 + p105;
                d105 = d96;
            }
        }
        if (rc.onTheMap(l59) && (target.equals(l59) || !rc.canSenseRobotAtLocation(l59))) {
            p59 = 1 + rc.senseRubble(l59) / 10.0;
            if (v59 > v58 + p59) {
                v59 = v58 + p59;
                d59 = d58;
            }
            if (v59 > v69 + p59) {
                v59 = v69 + p59;
                d59 = d69;
            }
        }
        if (rc.onTheMap(l106) && (target.equals(l106) || !rc.canSenseRobotAtLocation(l106))) {
            p106 = 1 + rc.senseRubble(l106) / 10.0;
            if (v106 > v99 + p106) {
                v106 = v99 + p106;
                d106 = d99;
            }
            if (v106 > v98 + p106) {
                v106 = v98 + p106;
                d106 = d98;
            }
            if (v106 > v97 + p106) {
                v106 = v97 + p106;
                d106 = d97;
            }
            if (v106 > v105 + p106) {
                v106 = v105 + p106;
                d106 = d105;
            }
        }
        if (rc.onTheMap(l104) && (target.equals(l104) || !rc.canSenseRobotAtLocation(l104))) {
            p104 = 1 + rc.senseRubble(l104) / 10.0;
            if (v104 > v105 + p104) {
                v104 = v105 + p104;
                d104 = d105;
            }
            if (v104 > v97 + p104) {
                v104 = v97 + p104;
                d104 = d97;
            }
            if (v104 > v96 + p104) {
                v104 = v96 + p104;
                d104 = d96;
            }
            if (v104 > v95 + p104) {
                v104 = v95 + p104;
                d104 = d95;
            }
        }
        if (rc.onTheMap(l60) && (target.equals(l60) || !rc.canSenseRobotAtLocation(l60))) {
            p60 = 1 + rc.senseRubble(l60) / 10.0;
            if (v60 > v72 + p60) {
                v60 = v72 + p60;
                d60 = d72;
            }
            if (v60 > v61 + p60) {
                v60 = v61 + p60;
                d60 = d61;
            }
            if (v60 > v50 + p60) {
                v60 = v50 + p60;
                d60 = d50;
            }
            if (v60 > v49 + p60) {
                v60 = v49 + p60;
                d60 = d49;
            }
        }
        if (rc.onTheMap(l70) && (target.equals(l70) || !rc.canSenseRobotAtLocation(l70))) {
            p70 = 1 + rc.senseRubble(l70) / 10.0;
            if (v70 > v59 + p70) {
                v70 = v59 + p70;
                d70 = d59;
            }
            if (v70 > v58 + p70) {
                v70 = v58 + p70;
                d70 = d58;
            }
            if (v70 > v69 + p70) {
                v70 = v69 + p70;
                d70 = d69;
            }
            if (v70 > v80 + p70) {
                v70 = v80 + p70;
                d70 = d80;
            }
        }
        if (rc.onTheMap(l107) && (target.equals(l107) || !rc.canSenseRobotAtLocation(l107))) {
            p107 = 1 + rc.senseRubble(l107) / 10.0;
            if (v107 > v100 + p107) {
                v107 = v100 + p107;
                d107 = d100;
            }
            if (v107 > v99 + p107) {
                v107 = v99 + p107;
                d107 = d99;
            }
            if (v107 > v98 + p107) {
                v107 = v98 + p107;
                d107 = d98;
            }
            if (v107 > v106 + p107) {
                v107 = v106 + p107;
                d107 = d106;
            }
        }
        if (rc.onTheMap(l71) && (target.equals(l71) || !rc.canSenseRobotAtLocation(l71))) {
            p71 = 1 + rc.senseRubble(l71) / 10.0;
            if (v71 > v83 + p71) {
                v71 = v83 + p71;
                d71 = d83;
            }
            if (v71 > v72 + p71) {
                v71 = v72 + p71;
                d71 = d72;
            }
            if (v71 > v61 + p71) {
                v71 = v61 + p71;
                d71 = d61;
            }
            if (v71 > v60 + p71) {
                v71 = v60 + p71;
                d71 = d60;
            }
        }
        if (rc.onTheMap(l81) && (target.equals(l81) || !rc.canSenseRobotAtLocation(l81))) {
            p81 = 1 + rc.senseRubble(l81) / 10.0;
            if (v81 > v70 + p81) {
                v81 = v70 + p81;
                d81 = d70;
            }
            if (v81 > v69 + p81) {
                v81 = v69 + p81;
                d81 = d69;
            }
            if (v81 > v80 + p81) {
                v81 = v80 + p81;
                d81 = d80;
            }
            if (v81 > v91 + p81) {
                v81 = v91 + p81;
                d81 = d91;
            }
        }
        if (rc.onTheMap(l103) && (target.equals(l103) || !rc.canSenseRobotAtLocation(l103))) {
            p103 = 1 + rc.senseRubble(l103) / 10.0;
            if (v103 > v104 + p103) {
                v103 = v104 + p103;
                d103 = d104;
            }
            if (v103 > v96 + p103) {
                v103 = v96 + p103;
                d103 = d96;
            }
            if (v103 > v95 + p103) {
                v103 = v95 + p103;
                d103 = d95;
            }
            if (v103 > v94 + p103) {
                v103 = v94 + p103;
                d103 = d94;
            }
        }
        if (rc.onTheMap(l92) && (target.equals(l92) || !rc.canSenseRobotAtLocation(l92))) {
            p92 = 1 + rc.senseRubble(l92) / 10.0;
            if (v92 > v81 + p92) {
                v92 = v81 + p92;
                d92 = d81;
            }
            if (v92 > v80 + p92) {
                v92 = v80 + p92;
                d92 = d80;
            }
            if (v92 > v91 + p92) {
                v92 = v91 + p92;
                d92 = d91;
            }
            if (v92 > v101 + p92) {
                v92 = v101 + p92;
                d92 = d101;
            }
        }
        if (rc.onTheMap(l102) && (target.equals(l102) || !rc.canSenseRobotAtLocation(l102))) {
            p102 = 1 + rc.senseRubble(l102) / 10.0;
            if (v102 > v103 + p102) {
                v102 = v103 + p102;
                d102 = d103;
            }
            if (v102 > v95 + p102) {
                v102 = v95 + p102;
                d102 = d95;
            }
            if (v102 > v94 + p102) {
                v102 = v94 + p102;
                d102 = d94;
            }
            if (v102 > v93 + p102) {
                v102 = v93 + p102;
                d102 = d93;
            }
        }
        if (rc.onTheMap(l108) && (target.equals(l108) || !rc.canSenseRobotAtLocation(l108))) {
            p108 = 1 + rc.senseRubble(l108) / 10.0;
            if (v108 > v101 + p108) {
                v108 = v101 + p108;
                d108 = d101;
            }
            if (v108 > v100 + p108) {
                v108 = v100 + p108;
                d108 = d100;
            }
            if (v108 > v99 + p108) {
                v108 = v99 + p108;
                d108 = d99;
            }
            if (v108 > v107 + p108) {
                v108 = v107 + p108;
                d108 = d107;
            }
        }
        if (rc.onTheMap(l82) && (target.equals(l82) || !rc.canSenseRobotAtLocation(l82))) {
            p82 = 1 + rc.senseRubble(l82) / 10.0;
            if (v82 > v93 + p82) {
                v82 = v93 + p82;
                d82 = d93;
            }
            if (v82 > v83 + p82) {
                v82 = v83 + p82;
                d82 = d83;
            }
            if (v82 > v72 + p82) {
                v82 = v72 + p82;
                d82 = d72;
            }
            if (v82 > v71 + p82) {
                v82 = v71 + p82;
                d82 = d71;
            }
        }
    
        int dx = target.x - l54.x;
        int dy = target.y - l54.y;

        switch(dx) {
        case -5:
            switch(dy) {
            }
            break;
        case -4:
            switch(dy) {
            }
            break;
        case -3:
            switch(dy) {
            }
            break;
        case -2:
            switch(dy) {
            }
            break;
        case -1:
            switch(dy) {
            }
            break;
        case 0:
            switch(dy) {
                case -5:
                    return d49;
                case -4:
                    return d50;
                case -3:
                    return d51;
                case -2:
                    return d52;
                case -1:
                    return d53;
                case 0:
                    return d54;
                case 1:
                    return d55;
                case 2:
                    return d56;
                case 3:
                    return d57;
                case 4:
                    return d58;
                case 5:
                    return d59;
            }
            break;
        case 1:
            switch(dy) {
                case -5:
                    return d60;
                case -4:
                    return d61;
                case -3:
                    return d62;
                case -2:
                    return d63;
                case -1:
                    return d64;
                case 0:
                    return d65;
                case 1:
                    return d66;
                case 2:
                    return d67;
                case 3:
                    return d68;
                case 4:
                    return d69;
                case 5:
                    return d70;
            }
            break;
        case 2:
            switch(dy) {
                case -5:
                    return d71;
                case -4:
                    return d72;
                case -3:
                    return d73;
                case -2:
                    return d74;
                case -1:
                    return d75;
                case 0:
                    return d76;
                case 1:
                    return d77;
                case 2:
                    return d78;
                case 3:
                    return d79;
                case 4:
                    return d80;
                case 5:
                    return d81;
            }
            break;
        case 3:
            switch(dy) {
                case -5:
                    return d82;
                case -4:
                    return d83;
                case -3:
                    return d84;
                case -2:
                    return d85;
                case -1:
                    return d86;
                case 0:
                    return d87;
                case 1:
                    return d88;
                case 2:
                    return d89;
                case 3:
                    return d90;
                case 4:
                    return d91;
                case 5:
                    return d92;
            }
            break;
        case 4:
            switch(dy) {
                case -4:
                    return d93;
                case -3:
                    return d94;
                case -2:
                    return d95;
                case -1:
                    return d96;
                case 0:
                    return d97;
                case 1:
                    return d98;
                case 2:
                    return d99;
                case 3:
                    return d100;
                case 4:
                    return d101;
            }
            break;
        case 5:
            switch(dy) {
                case -3:
                    return d102;
                case -2:
                    return d103;
                case -1:
                    return d104;
                case 0:
                    return d105;
                case 1:
                    return d106;
                case 2:
                    return d107;
                case 3:
                    return d108;
            }
            break;
        }
    
        Direction ans = null;
        double bestEstimation = 0;
        double initialDist = Math.sqrt(l54.distanceSquaredTo(target));
        
        double dist49 = (initialDist - Math.sqrt(l49.distanceSquaredTo(target))) / v49;
        if (dist49 > bestEstimation) {
            bestEstimation = dist49;
            ans = d49;
        }
        double dist50 = (initialDist - Math.sqrt(l50.distanceSquaredTo(target))) / v50;
        if (dist50 > bestEstimation) {
            bestEstimation = dist50;
            ans = d50;
        }
        double dist51 = (initialDist - Math.sqrt(l51.distanceSquaredTo(target))) / v51;
        if (dist51 > bestEstimation) {
            bestEstimation = dist51;
            ans = d51;
        }
        double dist52 = (initialDist - Math.sqrt(l52.distanceSquaredTo(target))) / v52;
        if (dist52 > bestEstimation) {
            bestEstimation = dist52;
            ans = d52;
        }
        double dist53 = (initialDist - Math.sqrt(l53.distanceSquaredTo(target))) / v53;
        if (dist53 > bestEstimation) {
            bestEstimation = dist53;
            ans = d53;
        }
        double dist54 = (initialDist - Math.sqrt(l54.distanceSquaredTo(target))) / v54;
        if (dist54 > bestEstimation) {
            bestEstimation = dist54;
            ans = d54;
        }
        double dist55 = (initialDist - Math.sqrt(l55.distanceSquaredTo(target))) / v55;
        if (dist55 > bestEstimation) {
            bestEstimation = dist55;
            ans = d55;
        }
        double dist56 = (initialDist - Math.sqrt(l56.distanceSquaredTo(target))) / v56;
        if (dist56 > bestEstimation) {
            bestEstimation = dist56;
            ans = d56;
        }
        double dist57 = (initialDist - Math.sqrt(l57.distanceSquaredTo(target))) / v57;
        if (dist57 > bestEstimation) {
            bestEstimation = dist57;
            ans = d57;
        }
        double dist58 = (initialDist - Math.sqrt(l58.distanceSquaredTo(target))) / v58;
        if (dist58 > bestEstimation) {
            bestEstimation = dist58;
            ans = d58;
        }
        double dist59 = (initialDist - Math.sqrt(l59.distanceSquaredTo(target))) / v59;
        if (dist59 > bestEstimation) {
            bestEstimation = dist59;
            ans = d59;
        }
        double dist60 = (initialDist - Math.sqrt(l60.distanceSquaredTo(target))) / v60;
        if (dist60 > bestEstimation) {
            bestEstimation = dist60;
            ans = d60;
        }
        double dist61 = (initialDist - Math.sqrt(l61.distanceSquaredTo(target))) / v61;
        if (dist61 > bestEstimation) {
            bestEstimation = dist61;
            ans = d61;
        }
        double dist62 = (initialDist - Math.sqrt(l62.distanceSquaredTo(target))) / v62;
        if (dist62 > bestEstimation) {
            bestEstimation = dist62;
            ans = d62;
        }
        double dist63 = (initialDist - Math.sqrt(l63.distanceSquaredTo(target))) / v63;
        if (dist63 > bestEstimation) {
            bestEstimation = dist63;
            ans = d63;
        }
        double dist64 = (initialDist - Math.sqrt(l64.distanceSquaredTo(target))) / v64;
        if (dist64 > bestEstimation) {
            bestEstimation = dist64;
            ans = d64;
        }
        double dist65 = (initialDist - Math.sqrt(l65.distanceSquaredTo(target))) / v65;
        if (dist65 > bestEstimation) {
            bestEstimation = dist65;
            ans = d65;
        }
        double dist66 = (initialDist - Math.sqrt(l66.distanceSquaredTo(target))) / v66;
        if (dist66 > bestEstimation) {
            bestEstimation = dist66;
            ans = d66;
        }
        double dist67 = (initialDist - Math.sqrt(l67.distanceSquaredTo(target))) / v67;
        if (dist67 > bestEstimation) {
            bestEstimation = dist67;
            ans = d67;
        }
        double dist68 = (initialDist - Math.sqrt(l68.distanceSquaredTo(target))) / v68;
        if (dist68 > bestEstimation) {
            bestEstimation = dist68;
            ans = d68;
        }
        double dist69 = (initialDist - Math.sqrt(l69.distanceSquaredTo(target))) / v69;
        if (dist69 > bestEstimation) {
            bestEstimation = dist69;
            ans = d69;
        }
        double dist70 = (initialDist - Math.sqrt(l70.distanceSquaredTo(target))) / v70;
        if (dist70 > bestEstimation) {
            bestEstimation = dist70;
            ans = d70;
        }
        double dist71 = (initialDist - Math.sqrt(l71.distanceSquaredTo(target))) / v71;
        if (dist71 > bestEstimation) {
            bestEstimation = dist71;
            ans = d71;
        }
        double dist72 = (initialDist - Math.sqrt(l72.distanceSquaredTo(target))) / v72;
        if (dist72 > bestEstimation) {
            bestEstimation = dist72;
            ans = d72;
        }
        double dist73 = (initialDist - Math.sqrt(l73.distanceSquaredTo(target))) / v73;
        if (dist73 > bestEstimation) {
            bestEstimation = dist73;
            ans = d73;
        }
        double dist74 = (initialDist - Math.sqrt(l74.distanceSquaredTo(target))) / v74;
        if (dist74 > bestEstimation) {
            bestEstimation = dist74;
            ans = d74;
        }
        double dist75 = (initialDist - Math.sqrt(l75.distanceSquaredTo(target))) / v75;
        if (dist75 > bestEstimation) {
            bestEstimation = dist75;
            ans = d75;
        }
        double dist76 = (initialDist - Math.sqrt(l76.distanceSquaredTo(target))) / v76;
        if (dist76 > bestEstimation) {
            bestEstimation = dist76;
            ans = d76;
        }
        double dist77 = (initialDist - Math.sqrt(l77.distanceSquaredTo(target))) / v77;
        if (dist77 > bestEstimation) {
            bestEstimation = dist77;
            ans = d77;
        }
        double dist78 = (initialDist - Math.sqrt(l78.distanceSquaredTo(target))) / v78;
        if (dist78 > bestEstimation) {
            bestEstimation = dist78;
            ans = d78;
        }
        double dist79 = (initialDist - Math.sqrt(l79.distanceSquaredTo(target))) / v79;
        if (dist79 > bestEstimation) {
            bestEstimation = dist79;
            ans = d79;
        }
        double dist80 = (initialDist - Math.sqrt(l80.distanceSquaredTo(target))) / v80;
        if (dist80 > bestEstimation) {
            bestEstimation = dist80;
            ans = d80;
        }
        double dist81 = (initialDist - Math.sqrt(l81.distanceSquaredTo(target))) / v81;
        if (dist81 > bestEstimation) {
            bestEstimation = dist81;
            ans = d81;
        }
        double dist82 = (initialDist - Math.sqrt(l82.distanceSquaredTo(target))) / v82;
        if (dist82 > bestEstimation) {
            bestEstimation = dist82;
            ans = d82;
        }
        double dist83 = (initialDist - Math.sqrt(l83.distanceSquaredTo(target))) / v83;
        if (dist83 > bestEstimation) {
            bestEstimation = dist83;
            ans = d83;
        }
        double dist84 = (initialDist - Math.sqrt(l84.distanceSquaredTo(target))) / v84;
        if (dist84 > bestEstimation) {
            bestEstimation = dist84;
            ans = d84;
        }
        double dist85 = (initialDist - Math.sqrt(l85.distanceSquaredTo(target))) / v85;
        if (dist85 > bestEstimation) {
            bestEstimation = dist85;
            ans = d85;
        }
        double dist86 = (initialDist - Math.sqrt(l86.distanceSquaredTo(target))) / v86;
        if (dist86 > bestEstimation) {
            bestEstimation = dist86;
            ans = d86;
        }
        double dist87 = (initialDist - Math.sqrt(l87.distanceSquaredTo(target))) / v87;
        if (dist87 > bestEstimation) {
            bestEstimation = dist87;
            ans = d87;
        }
        double dist88 = (initialDist - Math.sqrt(l88.distanceSquaredTo(target))) / v88;
        if (dist88 > bestEstimation) {
            bestEstimation = dist88;
            ans = d88;
        }
        double dist89 = (initialDist - Math.sqrt(l89.distanceSquaredTo(target))) / v89;
        if (dist89 > bestEstimation) {
            bestEstimation = dist89;
            ans = d89;
        }
        double dist90 = (initialDist - Math.sqrt(l90.distanceSquaredTo(target))) / v90;
        if (dist90 > bestEstimation) {
            bestEstimation = dist90;
            ans = d90;
        }
        double dist91 = (initialDist - Math.sqrt(l91.distanceSquaredTo(target))) / v91;
        if (dist91 > bestEstimation) {
            bestEstimation = dist91;
            ans = d91;
        }
        double dist92 = (initialDist - Math.sqrt(l92.distanceSquaredTo(target))) / v92;
        if (dist92 > bestEstimation) {
            bestEstimation = dist92;
            ans = d92;
        }
        double dist93 = (initialDist - Math.sqrt(l93.distanceSquaredTo(target))) / v93;
        if (dist93 > bestEstimation) {
            bestEstimation = dist93;
            ans = d93;
        }
        double dist94 = (initialDist - Math.sqrt(l94.distanceSquaredTo(target))) / v94;
        if (dist94 > bestEstimation) {
            bestEstimation = dist94;
            ans = d94;
        }
        double dist95 = (initialDist - Math.sqrt(l95.distanceSquaredTo(target))) / v95;
        if (dist95 > bestEstimation) {
            bestEstimation = dist95;
            ans = d95;
        }
        double dist96 = (initialDist - Math.sqrt(l96.distanceSquaredTo(target))) / v96;
        if (dist96 > bestEstimation) {
            bestEstimation = dist96;
            ans = d96;
        }
        double dist97 = (initialDist - Math.sqrt(l97.distanceSquaredTo(target))) / v97;
        if (dist97 > bestEstimation) {
            bestEstimation = dist97;
            ans = d97;
        }
        double dist98 = (initialDist - Math.sqrt(l98.distanceSquaredTo(target))) / v98;
        if (dist98 > bestEstimation) {
            bestEstimation = dist98;
            ans = d98;
        }
        double dist99 = (initialDist - Math.sqrt(l99.distanceSquaredTo(target))) / v99;
        if (dist99 > bestEstimation) {
            bestEstimation = dist99;
            ans = d99;
        }
        double dist100 = (initialDist - Math.sqrt(l100.distanceSquaredTo(target))) / v100;
        if (dist100 > bestEstimation) {
            bestEstimation = dist100;
            ans = d100;
        }
        double dist101 = (initialDist - Math.sqrt(l101.distanceSquaredTo(target))) / v101;
        if (dist101 > bestEstimation) {
            bestEstimation = dist101;
            ans = d101;
        }
        double dist102 = (initialDist - Math.sqrt(l102.distanceSquaredTo(target))) / v102;
        if (dist102 > bestEstimation) {
            bestEstimation = dist102;
            ans = d102;
        }
        double dist103 = (initialDist - Math.sqrt(l103.distanceSquaredTo(target))) / v103;
        if (dist103 > bestEstimation) {
            bestEstimation = dist103;
            ans = d103;
        }
        double dist104 = (initialDist - Math.sqrt(l104.distanceSquaredTo(target))) / v104;
        if (dist104 > bestEstimation) {
            bestEstimation = dist104;
            ans = d104;
        }
        double dist105 = (initialDist - Math.sqrt(l105.distanceSquaredTo(target))) / v105;
        if (dist105 > bestEstimation) {
            bestEstimation = dist105;
            ans = d105;
        }
        double dist106 = (initialDist - Math.sqrt(l106.distanceSquaredTo(target))) / v106;
        if (dist106 > bestEstimation) {
            bestEstimation = dist106;
            ans = d106;
        }
        double dist107 = (initialDist - Math.sqrt(l107.distanceSquaredTo(target))) / v107;
        if (dist107 > bestEstimation) {
            bestEstimation = dist107;
            ans = d107;
        }
        double dist108 = (initialDist - Math.sqrt(l108.distanceSquaredTo(target))) / v108;
        if (dist108 > bestEstimation) {
            bestEstimation = dist108;
            ans = d108;
        }
        return ans;
    }

    private Direction getBestDirection1(MapLocation target) throws GameActionException {
        l54 = currentLocation;
        v54 = 0; 
        l55 = l54.add(Direction.NORTH);
        v55 = 1000000;
        d55 = null;
        l44 = l54.add(Direction.NORTHWEST);
        v44 = 1000000;
        d44 = null;
        l43 = l54.add(Direction.WEST);
        v43 = 1000000;
        d43 = null;
        l42 = l54.add(Direction.SOUTHWEST);
        v42 = 1000000;
        d42 = null;
        l53 = l54.add(Direction.SOUTH);
        v53 = 1000000;
        d53 = null;
        l41 = l53.add(Direction.SOUTHWEST);
        v41 = 1000000;
        d41 = null;
        l52 = l53.add(Direction.SOUTH);
        v52 = 1000000;
        d52 = null;
        l33 = l43.add(Direction.NORTHWEST);
        v33 = 1000000;
        d33 = null;
        l32 = l43.add(Direction.WEST);
        v32 = 1000000;
        d32 = null;
        l31 = l43.add(Direction.SOUTHWEST);
        v31 = 1000000;
        d31 = null;
        l56 = l55.add(Direction.NORTH);
        v56 = 1000000;
        d56 = null;
        l45 = l55.add(Direction.NORTHWEST);
        v45 = 1000000;
        d45 = null;
        l30 = l42.add(Direction.SOUTHWEST);
        v30 = 1000000;
        d30 = null;
        l34 = l44.add(Direction.NORTHWEST);
        v34 = 1000000;
        d34 = null;
        l57 = l56.add(Direction.NORTH);
        v57 = 1000000;
        d57 = null;
        l46 = l56.add(Direction.NORTHWEST);
        v46 = 1000000;
        d46 = null;
        l22 = l32.add(Direction.NORTHWEST);
        v22 = 1000000;
        d22 = null;
        l21 = l32.add(Direction.WEST);
        v21 = 1000000;
        d21 = null;
        l20 = l32.add(Direction.SOUTHWEST);
        v20 = 1000000;
        d20 = null;
        l40 = l52.add(Direction.SOUTHWEST);
        v40 = 1000000;
        d40 = null;
        l51 = l52.add(Direction.SOUTH);
        v51 = 1000000;
        d51 = null;
        l35 = l45.add(Direction.NORTHWEST);
        v35 = 1000000;
        d35 = null;
        l19 = l31.add(Direction.SOUTHWEST);
        v19 = 1000000;
        d19 = null;
        l29 = l41.add(Direction.SOUTHWEST);
        v29 = 1000000;
        d29 = null;
        l23 = l33.add(Direction.NORTHWEST);
        v23 = 1000000;
        d23 = null;
        l18 = l30.add(Direction.SOUTHWEST);
        v18 = 1000000;
        d18 = null;
        l24 = l34.add(Direction.NORTHWEST);
        v24 = 1000000;
        d24 = null;
        l58 = l57.add(Direction.NORTH);
        v58 = 1000000;
        d58 = null;
        l47 = l57.add(Direction.NORTHWEST);
        v47 = 1000000;
        d47 = null;
        l12 = l21.add(Direction.NORTHWEST);
        v12 = 1000000;
        d12 = null;
        l11 = l21.add(Direction.WEST);
        v11 = 1000000;
        d11 = null;
        l10 = l21.add(Direction.SOUTHWEST);
        v10 = 1000000;
        d10 = null;
        l39 = l51.add(Direction.SOUTHWEST);
        v39 = 1000000;
        d39 = null;
        l50 = l51.add(Direction.SOUTH);
        v50 = 1000000;
        d50 = null;
        l36 = l46.add(Direction.NORTHWEST);
        v36 = 1000000;
        d36 = null;
        l13 = l22.add(Direction.NORTHWEST);
        v13 = 1000000;
        d13 = null;
        l28 = l40.add(Direction.SOUTHWEST);
        v28 = 1000000;
        d28 = null;
        l9 = l20.add(Direction.SOUTHWEST);
        v9 = 1000000;
        d9 = null;
        l17 = l29.add(Direction.SOUTHWEST);
        v17 = 1000000;
        d17 = null;
        l25 = l35.add(Direction.NORTHWEST);
        v25 = 1000000;
        d25 = null;
        l14 = l23.add(Direction.NORTHWEST);
        v14 = 1000000;
        d14 = null;
        l8 = l19.add(Direction.SOUTHWEST);
        v8 = 1000000;
        d8 = null;
        l15 = l24.add(Direction.NORTHWEST);
        v15 = 1000000;
        d15 = null;
        l7 = l18.add(Direction.SOUTHWEST);
        v7 = 1000000;
        d7 = null;
        l38 = l50.add(Direction.SOUTHWEST);
        v38 = 1000000;
        d38 = null;
        l49 = l50.add(Direction.SOUTH);
        v49 = 1000000;
        d49 = null;
        l59 = l58.add(Direction.NORTH);
        v59 = 1000000;
        d59 = null;
        l48 = l58.add(Direction.NORTHWEST);
        v48 = 1000000;
        d48 = null;
        l4 = l11.add(Direction.NORTHWEST);
        v4 = 1000000;
        d4 = null;
        l3 = l11.add(Direction.WEST);
        v3 = 1000000;
        d3 = null;
        l2 = l11.add(Direction.SOUTHWEST);
        v2 = 1000000;
        d2 = null;
        l27 = l39.add(Direction.SOUTHWEST);
        v27 = 1000000;
        d27 = null;
        l1 = l10.add(Direction.SOUTHWEST);
        v1 = 1000000;
        d1 = null;
        l37 = l47.add(Direction.NORTHWEST);
        v37 = 1000000;
        d37 = null;
        l5 = l12.add(Direction.NORTHWEST);
        v5 = 1000000;
        d5 = null;
        l0 = l9.add(Direction.SOUTHWEST);
        v0 = 1000000;
        d0 = null;
        l16 = l28.add(Direction.SOUTHWEST);
        v16 = 1000000;
        d16 = null;
        l26 = l36.add(Direction.NORTHWEST);
        v26 = 1000000;
        d26 = null;
        l6 = l13.add(Direction.NORTHWEST);
        v6 = 1000000;
        d6 = null;
    
        if (rc.onTheMap(l53) && (target.equals(l53) || !rc.canSenseRobotAtLocation(l53))) {
            p53 = 1 + rc.senseRubble(l53) / 10.0;
            if (v53 > v54 + p53) {
                v53 = v54 + p53;
                d53 = Direction.SOUTH;
            }
        }
        if (rc.onTheMap(l43) && (target.equals(l43) || !rc.canSenseRobotAtLocation(l43))) {
            p43 = 1 + rc.senseRubble(l43) / 10.0;
            if (v43 > v54 + p43) {
                v43 = v54 + p43;
                d43 = Direction.WEST;
            }
        }
        if (rc.onTheMap(l55) && (target.equals(l55) || !rc.canSenseRobotAtLocation(l55))) {
            p55 = 1 + rc.senseRubble(l55) / 10.0;
            if (v55 > v54 + p55) {
                v55 = v54 + p55;
                d55 = Direction.NORTH;
            }
        }
        if (rc.onTheMap(l42) && (target.equals(l42) || !rc.canSenseRobotAtLocation(l42))) {
            p42 = 1 + rc.senseRubble(l42) / 10.0;
            if (v42 > v54 + p42) {
                v42 = v54 + p42;
                d42 = Direction.SOUTHWEST;
            }
        }
        if (rc.onTheMap(l44) && (target.equals(l44) || !rc.canSenseRobotAtLocation(l44))) {
            p44 = 1 + rc.senseRubble(l44) / 10.0;
            if (v44 > v54 + p44) {
                v44 = v54 + p44;
                d44 = Direction.NORTHWEST;
            }
        }
        if (rc.onTheMap(l56) && (target.equals(l56) || !rc.canSenseRobotAtLocation(l56))) {
            p56 = 1 + rc.senseRubble(l56) / 10.0;
            if (v56 > v44 + p56) {
                v56 = v44 + p56;
                d56 = d44;
            }
            if (v56 > v55 + p56) {
                v56 = v55 + p56;
                d56 = d55;
            }
        }
        if (rc.onTheMap(l32) && (target.equals(l32) || !rc.canSenseRobotAtLocation(l32))) {
            p32 = 1 + rc.senseRubble(l32) / 10.0;
            if (v32 > v43 + p32) {
                v32 = v43 + p32;
                d32 = d43;
            }
            if (v32 > v44 + p32) {
                v32 = v44 + p32;
                d32 = d44;
            }
            if (v32 > v42 + p32) {
                v32 = v42 + p32;
                d32 = d42;
            }
        }
        if (rc.onTheMap(l52) && (target.equals(l52) || !rc.canSenseRobotAtLocation(l52))) {
            p52 = 1 + rc.senseRubble(l52) / 10.0;
            if (v52 > v53 + p52) {
                v52 = v53 + p52;
                d52 = d53;
            }
            if (v52 > v42 + p52) {
                v52 = v42 + p52;
                d52 = d42;
            }
        }
        if (rc.onTheMap(l45) && (target.equals(l45) || !rc.canSenseRobotAtLocation(l45))) {
            p45 = 1 + rc.senseRubble(l45) / 10.0;
            if (v45 > v56 + p45) {
                v45 = v56 + p45;
                d45 = d56;
            }
            if (v45 > v33 + p45) {
                v45 = v33 + p45;
                d45 = d33;
            }
            if (v45 > v44 + p45) {
                v45 = v44 + p45;
                d45 = d44;
            }
            if (v45 > v55 + p45) {
                v45 = v55 + p45;
                d45 = d55;
            }
        }
        if (rc.onTheMap(l31) && (target.equals(l31) || !rc.canSenseRobotAtLocation(l31))) {
            p31 = 1 + rc.senseRubble(l31) / 10.0;
            if (v31 > v42 + p31) {
                v31 = v42 + p31;
                d31 = d42;
            }
            if (v31 > v43 + p31) {
                v31 = v43 + p31;
                d31 = d43;
            }
            if (v31 > v32 + p31) {
                v31 = v32 + p31;
                d31 = d32;
            }
            if (v31 > v41 + p31) {
                v31 = v41 + p31;
                d31 = d41;
            }
        }
        if (rc.onTheMap(l41) && (target.equals(l41) || !rc.canSenseRobotAtLocation(l41))) {
            p41 = 1 + rc.senseRubble(l41) / 10.0;
            if (v41 > v52 + p41) {
                v41 = v52 + p41;
                d41 = d52;
            }
            if (v41 > v53 + p41) {
                v41 = v53 + p41;
                d41 = d53;
            }
            if (v41 > v42 + p41) {
                v41 = v42 + p41;
                d41 = d42;
            }
            if (v41 > v31 + p41) {
                v41 = v31 + p41;
                d41 = d31;
            }
        }
        if (rc.onTheMap(l33) && (target.equals(l33) || !rc.canSenseRobotAtLocation(l33))) {
            p33 = 1 + rc.senseRubble(l33) / 10.0;
            if (v33 > v44 + p33) {
                v33 = v44 + p33;
                d33 = d44;
            }
            if (v33 > v45 + p33) {
                v33 = v45 + p33;
                d33 = d45;
            }
            if (v33 > v32 + p33) {
                v33 = v32 + p33;
                d33 = d32;
            }
            if (v33 > v43 + p33) {
                v33 = v43 + p33;
                d33 = d43;
            }
        }
        if (rc.onTheMap(l30) && (target.equals(l30) || !rc.canSenseRobotAtLocation(l30))) {
            p30 = 1 + rc.senseRubble(l30) / 10.0;
            if (v30 > v41 + p30) {
                v30 = v41 + p30;
                d30 = d41;
            }
            if (v30 > v42 + p30) {
                v30 = v42 + p30;
                d30 = d42;
            }
            if (v30 > v31 + p30) {
                v30 = v31 + p30;
                d30 = d31;
            }
        }
        if (rc.onTheMap(l34) && (target.equals(l34) || !rc.canSenseRobotAtLocation(l34))) {
            p34 = 1 + rc.senseRubble(l34) / 10.0;
            if (v34 > v45 + p34) {
                v34 = v45 + p34;
                d34 = d45;
            }
            if (v34 > v33 + p34) {
                v34 = v33 + p34;
                d34 = d33;
            }
            if (v34 > v44 + p34) {
                v34 = v44 + p34;
                d34 = d44;
            }
        }
        if (rc.onTheMap(l57) && (target.equals(l57) || !rc.canSenseRobotAtLocation(l57))) {
            p57 = 1 + rc.senseRubble(l57) / 10.0;
            if (v57 > v45 + p57) {
                v57 = v45 + p57;
                d57 = d45;
            }
            if (v57 > v56 + p57) {
                v57 = v56 + p57;
                d57 = d56;
            }
        }
        if (rc.onTheMap(l21) && (target.equals(l21) || !rc.canSenseRobotAtLocation(l21))) {
            p21 = 1 + rc.senseRubble(l21) / 10.0;
            if (v21 > v32 + p21) {
                v21 = v32 + p21;
                d21 = d32;
            }
            if (v21 > v33 + p21) {
                v21 = v33 + p21;
                d21 = d33;
            }
            if (v21 > v31 + p21) {
                v21 = v31 + p21;
                d21 = d31;
            }
        }
        if (rc.onTheMap(l51) && (target.equals(l51) || !rc.canSenseRobotAtLocation(l51))) {
            p51 = 1 + rc.senseRubble(l51) / 10.0;
            if (v51 > v52 + p51) {
                v51 = v52 + p51;
                d51 = d52;
            }
            if (v51 > v41 + p51) {
                v51 = v41 + p51;
                d51 = d41;
            }
        }
        if (rc.onTheMap(l46) && (target.equals(l46) || !rc.canSenseRobotAtLocation(l46))) {
            p46 = 1 + rc.senseRubble(l46) / 10.0;
            if (v46 > v57 + p46) {
                v46 = v57 + p46;
                d46 = d57;
            }
            if (v46 > v34 + p46) {
                v46 = v34 + p46;
                d46 = d34;
            }
            if (v46 > v45 + p46) {
                v46 = v45 + p46;
                d46 = d45;
            }
            if (v46 > v56 + p46) {
                v46 = v56 + p46;
                d46 = d56;
            }
        }
        if (rc.onTheMap(l22) && (target.equals(l22) || !rc.canSenseRobotAtLocation(l22))) {
            p22 = 1 + rc.senseRubble(l22) / 10.0;
            if (v22 > v33 + p22) {
                v22 = v33 + p22;
                d22 = d33;
            }
            if (v22 > v34 + p22) {
                v22 = v34 + p22;
                d22 = d34;
            }
            if (v22 > v21 + p22) {
                v22 = v21 + p22;
                d22 = d21;
            }
            if (v22 > v32 + p22) {
                v22 = v32 + p22;
                d22 = d32;
            }
        }
        if (rc.onTheMap(l40) && (target.equals(l40) || !rc.canSenseRobotAtLocation(l40))) {
            p40 = 1 + rc.senseRubble(l40) / 10.0;
            if (v40 > v51 + p40) {
                v40 = v51 + p40;
                d40 = d51;
            }
            if (v40 > v52 + p40) {
                v40 = v52 + p40;
                d40 = d52;
            }
            if (v40 > v41 + p40) {
                v40 = v41 + p40;
                d40 = d41;
            }
            if (v40 > v30 + p40) {
                v40 = v30 + p40;
                d40 = d30;
            }
        }
        if (rc.onTheMap(l20) && (target.equals(l20) || !rc.canSenseRobotAtLocation(l20))) {
            p20 = 1 + rc.senseRubble(l20) / 10.0;
            if (v20 > v31 + p20) {
                v20 = v31 + p20;
                d20 = d31;
            }
            if (v20 > v32 + p20) {
                v20 = v32 + p20;
                d20 = d32;
            }
            if (v20 > v21 + p20) {
                v20 = v21 + p20;
                d20 = d21;
            }
            if (v20 > v30 + p20) {
                v20 = v30 + p20;
                d20 = d30;
            }
        }
        if (rc.onTheMap(l29) && (target.equals(l29) || !rc.canSenseRobotAtLocation(l29))) {
            p29 = 1 + rc.senseRubble(l29) / 10.0;
            if (v29 > v40 + p29) {
                v29 = v40 + p29;
                d29 = d40;
            }
            if (v29 > v41 + p29) {
                v29 = v41 + p29;
                d29 = d41;
            }
            if (v29 > v30 + p29) {
                v29 = v30 + p29;
                d29 = d30;
            }
            if (v29 > v19 + p29) {
                v29 = v19 + p29;
                d29 = d19;
            }
        }
        if (rc.onTheMap(l35) && (target.equals(l35) || !rc.canSenseRobotAtLocation(l35))) {
            p35 = 1 + rc.senseRubble(l35) / 10.0;
            if (v35 > v46 + p35) {
                v35 = v46 + p35;
                d35 = d46;
            }
            if (v35 > v23 + p35) {
                v35 = v23 + p35;
                d35 = d23;
            }
            if (v35 > v34 + p35) {
                v35 = v34 + p35;
                d35 = d34;
            }
            if (v35 > v45 + p35) {
                v35 = v45 + p35;
                d35 = d45;
            }
        }
        if (rc.onTheMap(l23) && (target.equals(l23) || !rc.canSenseRobotAtLocation(l23))) {
            p23 = 1 + rc.senseRubble(l23) / 10.0;
            if (v23 > v34 + p23) {
                v23 = v34 + p23;
                d23 = d34;
            }
            if (v23 > v35 + p23) {
                v23 = v35 + p23;
                d23 = d35;
            }
            if (v23 > v22 + p23) {
                v23 = v22 + p23;
                d23 = d22;
            }
            if (v23 > v33 + p23) {
                v23 = v33 + p23;
                d23 = d33;
            }
        }
        if (rc.onTheMap(l19) && (target.equals(l19) || !rc.canSenseRobotAtLocation(l19))) {
            p19 = 1 + rc.senseRubble(l19) / 10.0;
            if (v19 > v30 + p19) {
                v19 = v30 + p19;
                d19 = d30;
            }
            if (v19 > v31 + p19) {
                v19 = v31 + p19;
                d19 = d31;
            }
            if (v19 > v20 + p19) {
                v19 = v20 + p19;
                d19 = d20;
            }
            if (v19 > v29 + p19) {
                v19 = v29 + p19;
                d19 = d29;
            }
        }
        if (rc.onTheMap(l24) && (target.equals(l24) || !rc.canSenseRobotAtLocation(l24))) {
            p24 = 1 + rc.senseRubble(l24) / 10.0;
            if (v24 > v35 + p24) {
                v24 = v35 + p24;
                d24 = d35;
            }
            if (v24 > v23 + p24) {
                v24 = v23 + p24;
                d24 = d23;
            }
            if (v24 > v34 + p24) {
                v24 = v34 + p24;
                d24 = d34;
            }
        }
        if (rc.onTheMap(l18) && (target.equals(l18) || !rc.canSenseRobotAtLocation(l18))) {
            p18 = 1 + rc.senseRubble(l18) / 10.0;
            if (v18 > v29 + p18) {
                v18 = v29 + p18;
                d18 = d29;
            }
            if (v18 > v30 + p18) {
                v18 = v30 + p18;
                d18 = d30;
            }
            if (v18 > v19 + p18) {
                v18 = v19 + p18;
                d18 = d19;
            }
        }
        if (rc.onTheMap(l50) && (target.equals(l50) || !rc.canSenseRobotAtLocation(l50))) {
            p50 = 1 + rc.senseRubble(l50) / 10.0;
            if (v50 > v51 + p50) {
                v50 = v51 + p50;
                d50 = d51;
            }
            if (v50 > v40 + p50) {
                v50 = v40 + p50;
                d50 = d40;
            }
        }
        if (rc.onTheMap(l58) && (target.equals(l58) || !rc.canSenseRobotAtLocation(l58))) {
            p58 = 1 + rc.senseRubble(l58) / 10.0;
            if (v58 > v46 + p58) {
                v58 = v46 + p58;
                d58 = d46;
            }
            if (v58 > v57 + p58) {
                v58 = v57 + p58;
                d58 = d57;
            }
        }
        if (rc.onTheMap(l11) && (target.equals(l11) || !rc.canSenseRobotAtLocation(l11))) {
            p11 = 1 + rc.senseRubble(l11) / 10.0;
            if (v11 > v21 + p11) {
                v11 = v21 + p11;
                d11 = d21;
            }
            if (v11 > v22 + p11) {
                v11 = v22 + p11;
                d11 = d22;
            }
            if (v11 > v20 + p11) {
                v11 = v20 + p11;
                d11 = d20;
            }
        }
        if (rc.onTheMap(l39) && (target.equals(l39) || !rc.canSenseRobotAtLocation(l39))) {
            p39 = 1 + rc.senseRubble(l39) / 10.0;
            if (v39 > v50 + p39) {
                v39 = v50 + p39;
                d39 = d50;
            }
            if (v39 > v51 + p39) {
                v39 = v51 + p39;
                d39 = d51;
            }
            if (v39 > v40 + p39) {
                v39 = v40 + p39;
                d39 = d40;
            }
            if (v39 > v29 + p39) {
                v39 = v29 + p39;
                d39 = d29;
            }
        }
        if (rc.onTheMap(l10) && (target.equals(l10) || !rc.canSenseRobotAtLocation(l10))) {
            p10 = 1 + rc.senseRubble(l10) / 10.0;
            if (v10 > v20 + p10) {
                v10 = v20 + p10;
                d10 = d20;
            }
            if (v10 > v21 + p10) {
                v10 = v21 + p10;
                d10 = d21;
            }
            if (v10 > v11 + p10) {
                v10 = v11 + p10;
                d10 = d11;
            }
            if (v10 > v19 + p10) {
                v10 = v19 + p10;
                d10 = d19;
            }
        }
        if (rc.onTheMap(l47) && (target.equals(l47) || !rc.canSenseRobotAtLocation(l47))) {
            p47 = 1 + rc.senseRubble(l47) / 10.0;
            if (v47 > v58 + p47) {
                v47 = v58 + p47;
                d47 = d58;
            }
            if (v47 > v35 + p47) {
                v47 = v35 + p47;
                d47 = d35;
            }
            if (v47 > v46 + p47) {
                v47 = v46 + p47;
                d47 = d46;
            }
            if (v47 > v57 + p47) {
                v47 = v57 + p47;
                d47 = d57;
            }
        }
        if (rc.onTheMap(l12) && (target.equals(l12) || !rc.canSenseRobotAtLocation(l12))) {
            p12 = 1 + rc.senseRubble(l12) / 10.0;
            if (v12 > v22 + p12) {
                v12 = v22 + p12;
                d12 = d22;
            }
            if (v12 > v23 + p12) {
                v12 = v23 + p12;
                d12 = d23;
            }
            if (v12 > v11 + p12) {
                v12 = v11 + p12;
                d12 = d11;
            }
            if (v12 > v21 + p12) {
                v12 = v21 + p12;
                d12 = d21;
            }
        }
        if (rc.onTheMap(l9) && (target.equals(l9) || !rc.canSenseRobotAtLocation(l9))) {
            p9 = 1 + rc.senseRubble(l9) / 10.0;
            if (v9 > v19 + p9) {
                v9 = v19 + p9;
                d9 = d19;
            }
            if (v9 > v20 + p9) {
                v9 = v20 + p9;
                d9 = d20;
            }
            if (v9 > v10 + p9) {
                v9 = v10 + p9;
                d9 = d10;
            }
            if (v9 > v18 + p9) {
                v9 = v18 + p9;
                d9 = d18;
            }
        }
        if (rc.onTheMap(l28) && (target.equals(l28) || !rc.canSenseRobotAtLocation(l28))) {
            p28 = 1 + rc.senseRubble(l28) / 10.0;
            if (v28 > v39 + p28) {
                v28 = v39 + p28;
                d28 = d39;
            }
            if (v28 > v40 + p28) {
                v28 = v40 + p28;
                d28 = d40;
            }
            if (v28 > v29 + p28) {
                v28 = v29 + p28;
                d28 = d29;
            }
            if (v28 > v18 + p28) {
                v28 = v18 + p28;
                d28 = d18;
            }
        }
        if (rc.onTheMap(l36) && (target.equals(l36) || !rc.canSenseRobotAtLocation(l36))) {
            p36 = 1 + rc.senseRubble(l36) / 10.0;
            if (v36 > v47 + p36) {
                v36 = v47 + p36;
                d36 = d47;
            }
            if (v36 > v24 + p36) {
                v36 = v24 + p36;
                d36 = d24;
            }
            if (v36 > v35 + p36) {
                v36 = v35 + p36;
                d36 = d35;
            }
            if (v36 > v46 + p36) {
                v36 = v46 + p36;
                d36 = d46;
            }
        }
        if (rc.onTheMap(l13) && (target.equals(l13) || !rc.canSenseRobotAtLocation(l13))) {
            p13 = 1 + rc.senseRubble(l13) / 10.0;
            if (v13 > v23 + p13) {
                v13 = v23 + p13;
                d13 = d23;
            }
            if (v13 > v24 + p13) {
                v13 = v24 + p13;
                d13 = d24;
            }
            if (v13 > v12 + p13) {
                v13 = v12 + p13;
                d13 = d12;
            }
            if (v13 > v22 + p13) {
                v13 = v22 + p13;
                d13 = d22;
            }
        }
        if (rc.onTheMap(l14) && (target.equals(l14) || !rc.canSenseRobotAtLocation(l14))) {
            p14 = 1 + rc.senseRubble(l14) / 10.0;
            if (v14 > v24 + p14) {
                v14 = v24 + p14;
                d14 = d24;
            }
            if (v14 > v25 + p14) {
                v14 = v25 + p14;
                d14 = d25;
            }
            if (v14 > v13 + p14) {
                v14 = v13 + p14;
                d14 = d13;
            }
            if (v14 > v23 + p14) {
                v14 = v23 + p14;
                d14 = d23;
            }
        }
        if (rc.onTheMap(l8) && (target.equals(l8) || !rc.canSenseRobotAtLocation(l8))) {
            p8 = 1 + rc.senseRubble(l8) / 10.0;
            if (v8 > v18 + p8) {
                v8 = v18 + p8;
                d8 = d18;
            }
            if (v8 > v19 + p8) {
                v8 = v19 + p8;
                d8 = d19;
            }
            if (v8 > v9 + p8) {
                v8 = v9 + p8;
                d8 = d9;
            }
            if (v8 > v17 + p8) {
                v8 = v17 + p8;
                d8 = d17;
            }
        }
        if (rc.onTheMap(l25) && (target.equals(l25) || !rc.canSenseRobotAtLocation(l25))) {
            p25 = 1 + rc.senseRubble(l25) / 10.0;
            if (v25 > v36 + p25) {
                v25 = v36 + p25;
                d25 = d36;
            }
            if (v25 > v14 + p25) {
                v25 = v14 + p25;
                d25 = d14;
            }
            if (v25 > v24 + p25) {
                v25 = v24 + p25;
                d25 = d24;
            }
            if (v25 > v35 + p25) {
                v25 = v35 + p25;
                d25 = d35;
            }
        }
        if (rc.onTheMap(l17) && (target.equals(l17) || !rc.canSenseRobotAtLocation(l17))) {
            p17 = 1 + rc.senseRubble(l17) / 10.0;
            if (v17 > v28 + p17) {
                v17 = v28 + p17;
                d17 = d28;
            }
            if (v17 > v29 + p17) {
                v17 = v29 + p17;
                d17 = d29;
            }
            if (v17 > v18 + p17) {
                v17 = v18 + p17;
                d17 = d18;
            }
            if (v17 > v8 + p17) {
                v17 = v8 + p17;
                d17 = d8;
            }
        }
        if (rc.onTheMap(l15) && (target.equals(l15) || !rc.canSenseRobotAtLocation(l15))) {
            p15 = 1 + rc.senseRubble(l15) / 10.0;
            if (v15 > v25 + p15) {
                v15 = v25 + p15;
                d15 = d25;
            }
            if (v15 > v14 + p15) {
                v15 = v14 + p15;
                d15 = d14;
            }
            if (v15 > v24 + p15) {
                v15 = v24 + p15;
                d15 = d24;
            }
        }
        if (rc.onTheMap(l7) && (target.equals(l7) || !rc.canSenseRobotAtLocation(l7))) {
            p7 = 1 + rc.senseRubble(l7) / 10.0;
            if (v7 > v17 + p7) {
                v7 = v17 + p7;
                d7 = d17;
            }
            if (v7 > v18 + p7) {
                v7 = v18 + p7;
                d7 = d18;
            }
            if (v7 > v8 + p7) {
                v7 = v8 + p7;
                d7 = d8;
            }
        }
        if (rc.onTheMap(l59) && (target.equals(l59) || !rc.canSenseRobotAtLocation(l59))) {
            p59 = 1 + rc.senseRubble(l59) / 10.0;
            if (v59 > v47 + p59) {
                v59 = v47 + p59;
                d59 = d47;
            }
            if (v59 > v58 + p59) {
                v59 = v58 + p59;
                d59 = d58;
            }
        }
        if (rc.onTheMap(l3) && (target.equals(l3) || !rc.canSenseRobotAtLocation(l3))) {
            p3 = 1 + rc.senseRubble(l3) / 10.0;
            if (v3 > v11 + p3) {
                v3 = v11 + p3;
                d3 = d11;
            }
            if (v3 > v12 + p3) {
                v3 = v12 + p3;
                d3 = d12;
            }
            if (v3 > v10 + p3) {
                v3 = v10 + p3;
                d3 = d10;
            }
        }
        if (rc.onTheMap(l49) && (target.equals(l49) || !rc.canSenseRobotAtLocation(l49))) {
            p49 = 1 + rc.senseRubble(l49) / 10.0;
            if (v49 > v50 + p49) {
                v49 = v50 + p49;
                d49 = d50;
            }
            if (v49 > v39 + p49) {
                v49 = v39 + p49;
                d49 = d39;
            }
        }
        if (rc.onTheMap(l2) && (target.equals(l2) || !rc.canSenseRobotAtLocation(l2))) {
            p2 = 1 + rc.senseRubble(l2) / 10.0;
            if (v2 > v10 + p2) {
                v2 = v10 + p2;
                d2 = d10;
            }
            if (v2 > v11 + p2) {
                v2 = v11 + p2;
                d2 = d11;
            }
            if (v2 > v3 + p2) {
                v2 = v3 + p2;
                d2 = d3;
            }
            if (v2 > v9 + p2) {
                v2 = v9 + p2;
                d2 = d9;
            }
        }
        if (rc.onTheMap(l38) && (target.equals(l38) || !rc.canSenseRobotAtLocation(l38))) {
            p38 = 1 + rc.senseRubble(l38) / 10.0;
            if (v38 > v49 + p38) {
                v38 = v49 + p38;
                d38 = d49;
            }
            if (v38 > v50 + p38) {
                v38 = v50 + p38;
                d38 = d50;
            }
            if (v38 > v39 + p38) {
                v38 = v39 + p38;
                d38 = d39;
            }
            if (v38 > v28 + p38) {
                v38 = v28 + p38;
                d38 = d28;
            }
        }
        if (rc.onTheMap(l4) && (target.equals(l4) || !rc.canSenseRobotAtLocation(l4))) {
            p4 = 1 + rc.senseRubble(l4) / 10.0;
            if (v4 > v12 + p4) {
                v4 = v12 + p4;
                d4 = d12;
            }
            if (v4 > v13 + p4) {
                v4 = v13 + p4;
                d4 = d13;
            }
            if (v4 > v3 + p4) {
                v4 = v3 + p4;
                d4 = d3;
            }
            if (v4 > v11 + p4) {
                v4 = v11 + p4;
                d4 = d11;
            }
        }
        if (rc.onTheMap(l48) && (target.equals(l48) || !rc.canSenseRobotAtLocation(l48))) {
            p48 = 1 + rc.senseRubble(l48) / 10.0;
            if (v48 > v59 + p48) {
                v48 = v59 + p48;
                d48 = d59;
            }
            if (v48 > v36 + p48) {
                v48 = v36 + p48;
                d48 = d36;
            }
            if (v48 > v47 + p48) {
                v48 = v47 + p48;
                d48 = d47;
            }
            if (v48 > v58 + p48) {
                v48 = v58 + p48;
                d48 = d58;
            }
        }
        if (rc.onTheMap(l5) && (target.equals(l5) || !rc.canSenseRobotAtLocation(l5))) {
            p5 = 1 + rc.senseRubble(l5) / 10.0;
            if (v5 > v13 + p5) {
                v5 = v13 + p5;
                d5 = d13;
            }
            if (v5 > v14 + p5) {
                v5 = v14 + p5;
                d5 = d14;
            }
            if (v5 > v4 + p5) {
                v5 = v4 + p5;
                d5 = d4;
            }
            if (v5 > v12 + p5) {
                v5 = v12 + p5;
                d5 = d12;
            }
        }
        if (rc.onTheMap(l37) && (target.equals(l37) || !rc.canSenseRobotAtLocation(l37))) {
            p37 = 1 + rc.senseRubble(l37) / 10.0;
            if (v37 > v48 + p37) {
                v37 = v48 + p37;
                d37 = d48;
            }
            if (v37 > v25 + p37) {
                v37 = v25 + p37;
                d37 = d25;
            }
            if (v37 > v36 + p37) {
                v37 = v36 + p37;
                d37 = d36;
            }
            if (v37 > v47 + p37) {
                v37 = v47 + p37;
                d37 = d47;
            }
        }
        if (rc.onTheMap(l27) && (target.equals(l27) || !rc.canSenseRobotAtLocation(l27))) {
            p27 = 1 + rc.senseRubble(l27) / 10.0;
            if (v27 > v38 + p27) {
                v27 = v38 + p27;
                d27 = d38;
            }
            if (v27 > v39 + p27) {
                v27 = v39 + p27;
                d27 = d39;
            }
            if (v27 > v28 + p27) {
                v27 = v28 + p27;
                d27 = d28;
            }
            if (v27 > v17 + p27) {
                v27 = v17 + p27;
                d27 = d17;
            }
        }
        if (rc.onTheMap(l1) && (target.equals(l1) || !rc.canSenseRobotAtLocation(l1))) {
            p1 = 1 + rc.senseRubble(l1) / 10.0;
            if (v1 > v9 + p1) {
                v1 = v9 + p1;
                d1 = d9;
            }
            if (v1 > v10 + p1) {
                v1 = v10 + p1;
                d1 = d10;
            }
            if (v1 > v2 + p1) {
                v1 = v2 + p1;
                d1 = d2;
            }
            if (v1 > v8 + p1) {
                v1 = v8 + p1;
                d1 = d8;
            }
        }
        if (rc.onTheMap(l0) && (target.equals(l0) || !rc.canSenseRobotAtLocation(l0))) {
            p0 = 1 + rc.senseRubble(l0) / 10.0;
            if (v0 > v8 + p0) {
                v0 = v8 + p0;
                d0 = d8;
            }
            if (v0 > v9 + p0) {
                v0 = v9 + p0;
                d0 = d9;
            }
            if (v0 > v1 + p0) {
                v0 = v1 + p0;
                d0 = d1;
            }
            if (v0 > v7 + p0) {
                v0 = v7 + p0;
                d0 = d7;
            }
        }
        if (rc.onTheMap(l26) && (target.equals(l26) || !rc.canSenseRobotAtLocation(l26))) {
            p26 = 1 + rc.senseRubble(l26) / 10.0;
            if (v26 > v37 + p26) {
                v26 = v37 + p26;
                d26 = d37;
            }
            if (v26 > v15 + p26) {
                v26 = v15 + p26;
                d26 = d15;
            }
            if (v26 > v25 + p26) {
                v26 = v25 + p26;
                d26 = d25;
            }
            if (v26 > v36 + p26) {
                v26 = v36 + p26;
                d26 = d36;
            }
        }
        if (rc.onTheMap(l6) && (target.equals(l6) || !rc.canSenseRobotAtLocation(l6))) {
            p6 = 1 + rc.senseRubble(l6) / 10.0;
            if (v6 > v14 + p6) {
                v6 = v14 + p6;
                d6 = d14;
            }
            if (v6 > v15 + p6) {
                v6 = v15 + p6;
                d6 = d15;
            }
            if (v6 > v5 + p6) {
                v6 = v5 + p6;
                d6 = d5;
            }
            if (v6 > v13 + p6) {
                v6 = v13 + p6;
                d6 = d13;
            }
        }
        if (rc.onTheMap(l16) && (target.equals(l16) || !rc.canSenseRobotAtLocation(l16))) {
            p16 = 1 + rc.senseRubble(l16) / 10.0;
            if (v16 > v27 + p16) {
                v16 = v27 + p16;
                d16 = d27;
            }
            if (v16 > v28 + p16) {
                v16 = v28 + p16;
                d16 = d28;
            }
            if (v16 > v17 + p16) {
                v16 = v17 + p16;
                d16 = d17;
            }
            if (v16 > v7 + p16) {
                v16 = v7 + p16;
                d16 = d7;
            }
        }
    
        int dx = target.x - l54.x;
        int dy = target.y - l54.y;

        switch(dx) {
        case -5:
            switch(dy) {
                case -3:
                    return d0;
                case -2:
                    return d1;
                case -1:
                    return d2;
                case 0:
                    return d3;
                case 1:
                    return d4;
                case 2:
                    return d5;
                case 3:
                    return d6;
            }
            break;
        case -4:
            switch(dy) {
                case -4:
                    return d7;
                case -3:
                    return d8;
                case -2:
                    return d9;
                case -1:
                    return d10;
                case 0:
                    return d11;
                case 1:
                    return d12;
                case 2:
                    return d13;
                case 3:
                    return d14;
                case 4:
                    return d15;
            }
            break;
        case -3:
            switch(dy) {
                case -5:
                    return d16;
                case -4:
                    return d17;
                case -3:
                    return d18;
                case -2:
                    return d19;
                case -1:
                    return d20;
                case 0:
                    return d21;
                case 1:
                    return d22;
                case 2:
                    return d23;
                case 3:
                    return d24;
                case 4:
                    return d25;
                case 5:
                    return d26;
            }
            break;
        case -2:
            switch(dy) {
                case -5:
                    return d27;
                case -4:
                    return d28;
                case -3:
                    return d29;
                case -2:
                    return d30;
                case -1:
                    return d31;
                case 0:
                    return d32;
                case 1:
                    return d33;
                case 2:
                    return d34;
                case 3:
                    return d35;
                case 4:
                    return d36;
                case 5:
                    return d37;
            }
            break;
        case -1:
            switch(dy) {
                case -5:
                    return d38;
                case -4:
                    return d39;
                case -3:
                    return d40;
                case -2:
                    return d41;
                case -1:
                    return d42;
                case 0:
                    return d43;
                case 1:
                    return d44;
                case 2:
                    return d45;
                case 3:
                    return d46;
                case 4:
                    return d47;
                case 5:
                    return d48;
            }
            break;
        case 0:
            switch(dy) {
                case -5:
                    return d49;
                case -4:
                    return d50;
                case -3:
                    return d51;
                case -2:
                    return d52;
                case -1:
                    return d53;
                case 0:
                    return d54;
                case 1:
                    return d55;
                case 2:
                    return d56;
                case 3:
                    return d57;
                case 4:
                    return d58;
                case 5:
                    return d59;
            }
            break;
        case 1:
            switch(dy) {
            }
            break;
        case 2:
            switch(dy) {
            }
            break;
        case 3:
            switch(dy) {
            }
            break;
        case 4:
            switch(dy) {
            }
            break;
        case 5:
            switch(dy) {
            }
            break;
        }
    
        Direction ans = null;
        double bestEstimation = 0;
        double initialDist = Math.sqrt(l54.distanceSquaredTo(target));
        
        double dist0 = (initialDist - Math.sqrt(l0.distanceSquaredTo(target))) / v0;
        if (dist0 > bestEstimation) {
            bestEstimation = dist0;
            ans = d0;
        }
        double dist1 = (initialDist - Math.sqrt(l1.distanceSquaredTo(target))) / v1;
        if (dist1 > bestEstimation) {
            bestEstimation = dist1;
            ans = d1;
        }
        double dist2 = (initialDist - Math.sqrt(l2.distanceSquaredTo(target))) / v2;
        if (dist2 > bestEstimation) {
            bestEstimation = dist2;
            ans = d2;
        }
        double dist3 = (initialDist - Math.sqrt(l3.distanceSquaredTo(target))) / v3;
        if (dist3 > bestEstimation) {
            bestEstimation = dist3;
            ans = d3;
        }
        double dist4 = (initialDist - Math.sqrt(l4.distanceSquaredTo(target))) / v4;
        if (dist4 > bestEstimation) {
            bestEstimation = dist4;
            ans = d4;
        }
        double dist5 = (initialDist - Math.sqrt(l5.distanceSquaredTo(target))) / v5;
        if (dist5 > bestEstimation) {
            bestEstimation = dist5;
            ans = d5;
        }
        double dist6 = (initialDist - Math.sqrt(l6.distanceSquaredTo(target))) / v6;
        if (dist6 > bestEstimation) {
            bestEstimation = dist6;
            ans = d6;
        }
        double dist7 = (initialDist - Math.sqrt(l7.distanceSquaredTo(target))) / v7;
        if (dist7 > bestEstimation) {
            bestEstimation = dist7;
            ans = d7;
        }
        double dist8 = (initialDist - Math.sqrt(l8.distanceSquaredTo(target))) / v8;
        if (dist8 > bestEstimation) {
            bestEstimation = dist8;
            ans = d8;
        }
        double dist9 = (initialDist - Math.sqrt(l9.distanceSquaredTo(target))) / v9;
        if (dist9 > bestEstimation) {
            bestEstimation = dist9;
            ans = d9;
        }
        double dist10 = (initialDist - Math.sqrt(l10.distanceSquaredTo(target))) / v10;
        if (dist10 > bestEstimation) {
            bestEstimation = dist10;
            ans = d10;
        }
        double dist11 = (initialDist - Math.sqrt(l11.distanceSquaredTo(target))) / v11;
        if (dist11 > bestEstimation) {
            bestEstimation = dist11;
            ans = d11;
        }
        double dist12 = (initialDist - Math.sqrt(l12.distanceSquaredTo(target))) / v12;
        if (dist12 > bestEstimation) {
            bestEstimation = dist12;
            ans = d12;
        }
        double dist13 = (initialDist - Math.sqrt(l13.distanceSquaredTo(target))) / v13;
        if (dist13 > bestEstimation) {
            bestEstimation = dist13;
            ans = d13;
        }
        double dist14 = (initialDist - Math.sqrt(l14.distanceSquaredTo(target))) / v14;
        if (dist14 > bestEstimation) {
            bestEstimation = dist14;
            ans = d14;
        }
        double dist15 = (initialDist - Math.sqrt(l15.distanceSquaredTo(target))) / v15;
        if (dist15 > bestEstimation) {
            bestEstimation = dist15;
            ans = d15;
        }
        double dist16 = (initialDist - Math.sqrt(l16.distanceSquaredTo(target))) / v16;
        if (dist16 > bestEstimation) {
            bestEstimation = dist16;
            ans = d16;
        }
        double dist17 = (initialDist - Math.sqrt(l17.distanceSquaredTo(target))) / v17;
        if (dist17 > bestEstimation) {
            bestEstimation = dist17;
            ans = d17;
        }
        double dist18 = (initialDist - Math.sqrt(l18.distanceSquaredTo(target))) / v18;
        if (dist18 > bestEstimation) {
            bestEstimation = dist18;
            ans = d18;
        }
        double dist19 = (initialDist - Math.sqrt(l19.distanceSquaredTo(target))) / v19;
        if (dist19 > bestEstimation) {
            bestEstimation = dist19;
            ans = d19;
        }
        double dist20 = (initialDist - Math.sqrt(l20.distanceSquaredTo(target))) / v20;
        if (dist20 > bestEstimation) {
            bestEstimation = dist20;
            ans = d20;
        }
        double dist21 = (initialDist - Math.sqrt(l21.distanceSquaredTo(target))) / v21;
        if (dist21 > bestEstimation) {
            bestEstimation = dist21;
            ans = d21;
        }
        double dist22 = (initialDist - Math.sqrt(l22.distanceSquaredTo(target))) / v22;
        if (dist22 > bestEstimation) {
            bestEstimation = dist22;
            ans = d22;
        }
        double dist23 = (initialDist - Math.sqrt(l23.distanceSquaredTo(target))) / v23;
        if (dist23 > bestEstimation) {
            bestEstimation = dist23;
            ans = d23;
        }
        double dist24 = (initialDist - Math.sqrt(l24.distanceSquaredTo(target))) / v24;
        if (dist24 > bestEstimation) {
            bestEstimation = dist24;
            ans = d24;
        }
        double dist25 = (initialDist - Math.sqrt(l25.distanceSquaredTo(target))) / v25;
        if (dist25 > bestEstimation) {
            bestEstimation = dist25;
            ans = d25;
        }
        double dist26 = (initialDist - Math.sqrt(l26.distanceSquaredTo(target))) / v26;
        if (dist26 > bestEstimation) {
            bestEstimation = dist26;
            ans = d26;
        }
        double dist27 = (initialDist - Math.sqrt(l27.distanceSquaredTo(target))) / v27;
        if (dist27 > bestEstimation) {
            bestEstimation = dist27;
            ans = d27;
        }
        double dist28 = (initialDist - Math.sqrt(l28.distanceSquaredTo(target))) / v28;
        if (dist28 > bestEstimation) {
            bestEstimation = dist28;
            ans = d28;
        }
        double dist29 = (initialDist - Math.sqrt(l29.distanceSquaredTo(target))) / v29;
        if (dist29 > bestEstimation) {
            bestEstimation = dist29;
            ans = d29;
        }
        double dist30 = (initialDist - Math.sqrt(l30.distanceSquaredTo(target))) / v30;
        if (dist30 > bestEstimation) {
            bestEstimation = dist30;
            ans = d30;
        }
        double dist31 = (initialDist - Math.sqrt(l31.distanceSquaredTo(target))) / v31;
        if (dist31 > bestEstimation) {
            bestEstimation = dist31;
            ans = d31;
        }
        double dist32 = (initialDist - Math.sqrt(l32.distanceSquaredTo(target))) / v32;
        if (dist32 > bestEstimation) {
            bestEstimation = dist32;
            ans = d32;
        }
        double dist33 = (initialDist - Math.sqrt(l33.distanceSquaredTo(target))) / v33;
        if (dist33 > bestEstimation) {
            bestEstimation = dist33;
            ans = d33;
        }
        double dist34 = (initialDist - Math.sqrt(l34.distanceSquaredTo(target))) / v34;
        if (dist34 > bestEstimation) {
            bestEstimation = dist34;
            ans = d34;
        }
        double dist35 = (initialDist - Math.sqrt(l35.distanceSquaredTo(target))) / v35;
        if (dist35 > bestEstimation) {
            bestEstimation = dist35;
            ans = d35;
        }
        double dist36 = (initialDist - Math.sqrt(l36.distanceSquaredTo(target))) / v36;
        if (dist36 > bestEstimation) {
            bestEstimation = dist36;
            ans = d36;
        }
        double dist37 = (initialDist - Math.sqrt(l37.distanceSquaredTo(target))) / v37;
        if (dist37 > bestEstimation) {
            bestEstimation = dist37;
            ans = d37;
        }
        double dist38 = (initialDist - Math.sqrt(l38.distanceSquaredTo(target))) / v38;
        if (dist38 > bestEstimation) {
            bestEstimation = dist38;
            ans = d38;
        }
        double dist39 = (initialDist - Math.sqrt(l39.distanceSquaredTo(target))) / v39;
        if (dist39 > bestEstimation) {
            bestEstimation = dist39;
            ans = d39;
        }
        double dist40 = (initialDist - Math.sqrt(l40.distanceSquaredTo(target))) / v40;
        if (dist40 > bestEstimation) {
            bestEstimation = dist40;
            ans = d40;
        }
        double dist41 = (initialDist - Math.sqrt(l41.distanceSquaredTo(target))) / v41;
        if (dist41 > bestEstimation) {
            bestEstimation = dist41;
            ans = d41;
        }
        double dist42 = (initialDist - Math.sqrt(l42.distanceSquaredTo(target))) / v42;
        if (dist42 > bestEstimation) {
            bestEstimation = dist42;
            ans = d42;
        }
        double dist43 = (initialDist - Math.sqrt(l43.distanceSquaredTo(target))) / v43;
        if (dist43 > bestEstimation) {
            bestEstimation = dist43;
            ans = d43;
        }
        double dist44 = (initialDist - Math.sqrt(l44.distanceSquaredTo(target))) / v44;
        if (dist44 > bestEstimation) {
            bestEstimation = dist44;
            ans = d44;
        }
        double dist45 = (initialDist - Math.sqrt(l45.distanceSquaredTo(target))) / v45;
        if (dist45 > bestEstimation) {
            bestEstimation = dist45;
            ans = d45;
        }
        double dist46 = (initialDist - Math.sqrt(l46.distanceSquaredTo(target))) / v46;
        if (dist46 > bestEstimation) {
            bestEstimation = dist46;
            ans = d46;
        }
        double dist47 = (initialDist - Math.sqrt(l47.distanceSquaredTo(target))) / v47;
        if (dist47 > bestEstimation) {
            bestEstimation = dist47;
            ans = d47;
        }
        double dist48 = (initialDist - Math.sqrt(l48.distanceSquaredTo(target))) / v48;
        if (dist48 > bestEstimation) {
            bestEstimation = dist48;
            ans = d48;
        }
        double dist49 = (initialDist - Math.sqrt(l49.distanceSquaredTo(target))) / v49;
        if (dist49 > bestEstimation) {
            bestEstimation = dist49;
            ans = d49;
        }
        double dist50 = (initialDist - Math.sqrt(l50.distanceSquaredTo(target))) / v50;
        if (dist50 > bestEstimation) {
            bestEstimation = dist50;
            ans = d50;
        }
        double dist51 = (initialDist - Math.sqrt(l51.distanceSquaredTo(target))) / v51;
        if (dist51 > bestEstimation) {
            bestEstimation = dist51;
            ans = d51;
        }
        double dist52 = (initialDist - Math.sqrt(l52.distanceSquaredTo(target))) / v52;
        if (dist52 > bestEstimation) {
            bestEstimation = dist52;
            ans = d52;
        }
        double dist53 = (initialDist - Math.sqrt(l53.distanceSquaredTo(target))) / v53;
        if (dist53 > bestEstimation) {
            bestEstimation = dist53;
            ans = d53;
        }
        double dist54 = (initialDist - Math.sqrt(l54.distanceSquaredTo(target))) / v54;
        if (dist54 > bestEstimation) {
            bestEstimation = dist54;
            ans = d54;
        }
        double dist55 = (initialDist - Math.sqrt(l55.distanceSquaredTo(target))) / v55;
        if (dist55 > bestEstimation) {
            bestEstimation = dist55;
            ans = d55;
        }
        double dist56 = (initialDist - Math.sqrt(l56.distanceSquaredTo(target))) / v56;
        if (dist56 > bestEstimation) {
            bestEstimation = dist56;
            ans = d56;
        }
        double dist57 = (initialDist - Math.sqrt(l57.distanceSquaredTo(target))) / v57;
        if (dist57 > bestEstimation) {
            bestEstimation = dist57;
            ans = d57;
        }
        double dist58 = (initialDist - Math.sqrt(l58.distanceSquaredTo(target))) / v58;
        if (dist58 > bestEstimation) {
            bestEstimation = dist58;
            ans = d58;
        }
        double dist59 = (initialDist - Math.sqrt(l59.distanceSquaredTo(target))) / v59;
        if (dist59 > bestEstimation) {
            bestEstimation = dist59;
            ans = d59;
        }
        return ans;
    }

    private Direction getBestDirection2(MapLocation target) throws GameActionException {
        l54 = currentLocation;
        v54 = 0; 
        l65 = l54.add(Direction.EAST);
        v65 = 1000000;
        d65 = null;
        l66 = l54.add(Direction.NORTHEAST);
        v66 = 1000000;
        d66 = null;
        l55 = l54.add(Direction.NORTH);
        v55 = 1000000;
        d55 = null;
        l44 = l54.add(Direction.NORTHWEST);
        v44 = 1000000;
        d44 = null;
        l43 = l54.add(Direction.WEST);
        v43 = 1000000;
        d43 = null;
        l33 = l43.add(Direction.NORTHWEST);
        v33 = 1000000;
        d33 = null;
        l32 = l43.add(Direction.WEST);
        v32 = 1000000;
        d32 = null;
        l67 = l55.add(Direction.NORTHEAST);
        v67 = 1000000;
        d67 = null;
        l56 = l55.add(Direction.NORTH);
        v56 = 1000000;
        d56 = null;
        l45 = l55.add(Direction.NORTHWEST);
        v45 = 1000000;
        d45 = null;
        l76 = l65.add(Direction.EAST);
        v76 = 1000000;
        d76 = null;
        l77 = l65.add(Direction.NORTHEAST);
        v77 = 1000000;
        d77 = null;
        l34 = l44.add(Direction.NORTHWEST);
        v34 = 1000000;
        d34 = null;
        l78 = l66.add(Direction.NORTHEAST);
        v78 = 1000000;
        d78 = null;
        l87 = l76.add(Direction.EAST);
        v87 = 1000000;
        d87 = null;
        l88 = l76.add(Direction.NORTHEAST);
        v88 = 1000000;
        d88 = null;
        l68 = l56.add(Direction.NORTHEAST);
        v68 = 1000000;
        d68 = null;
        l57 = l56.add(Direction.NORTH);
        v57 = 1000000;
        d57 = null;
        l46 = l56.add(Direction.NORTHWEST);
        v46 = 1000000;
        d46 = null;
        l22 = l32.add(Direction.NORTHWEST);
        v22 = 1000000;
        d22 = null;
        l21 = l32.add(Direction.WEST);
        v21 = 1000000;
        d21 = null;
        l89 = l77.add(Direction.NORTHEAST);
        v89 = 1000000;
        d89 = null;
        l35 = l45.add(Direction.NORTHWEST);
        v35 = 1000000;
        d35 = null;
        l23 = l33.add(Direction.NORTHWEST);
        v23 = 1000000;
        d23 = null;
        l79 = l67.add(Direction.NORTHEAST);
        v79 = 1000000;
        d79 = null;
        l24 = l34.add(Direction.NORTHWEST);
        v24 = 1000000;
        d24 = null;
        l90 = l78.add(Direction.NORTHEAST);
        v90 = 1000000;
        d90 = null;
        l97 = l87.add(Direction.EAST);
        v97 = 1000000;
        d97 = null;
        l98 = l87.add(Direction.NORTHEAST);
        v98 = 1000000;
        d98 = null;
        l69 = l57.add(Direction.NORTHEAST);
        v69 = 1000000;
        d69 = null;
        l58 = l57.add(Direction.NORTH);
        v58 = 1000000;
        d58 = null;
        l47 = l57.add(Direction.NORTHWEST);
        v47 = 1000000;
        d47 = null;
        l12 = l21.add(Direction.NORTHWEST);
        v12 = 1000000;
        d12 = null;
        l11 = l21.add(Direction.WEST);
        v11 = 1000000;
        d11 = null;
        l99 = l88.add(Direction.NORTHEAST);
        v99 = 1000000;
        d99 = null;
        l80 = l68.add(Direction.NORTHEAST);
        v80 = 1000000;
        d80 = null;
        l13 = l22.add(Direction.NORTHWEST);
        v13 = 1000000;
        d13 = null;
        l36 = l46.add(Direction.NORTHWEST);
        v36 = 1000000;
        d36 = null;
        l14 = l23.add(Direction.NORTHWEST);
        v14 = 1000000;
        d14 = null;
        l100 = l89.add(Direction.NORTHEAST);
        v100 = 1000000;
        d100 = null;
        l91 = l79.add(Direction.NORTHEAST);
        v91 = 1000000;
        d91 = null;
        l25 = l35.add(Direction.NORTHWEST);
        v25 = 1000000;
        d25 = null;
        l101 = l90.add(Direction.NORTHEAST);
        v101 = 1000000;
        d101 = null;
        l15 = l24.add(Direction.NORTHWEST);
        v15 = 1000000;
        d15 = null;
        l4 = l11.add(Direction.NORTHWEST);
        v4 = 1000000;
        d4 = null;
        l3 = l11.add(Direction.WEST);
        v3 = 1000000;
        d3 = null;
        l105 = l97.add(Direction.EAST);
        v105 = 1000000;
        d105 = null;
        l106 = l97.add(Direction.NORTHEAST);
        v106 = 1000000;
        d106 = null;
        l70 = l58.add(Direction.NORTHEAST);
        v70 = 1000000;
        d70 = null;
        l59 = l58.add(Direction.NORTH);
        v59 = 1000000;
        d59 = null;
        l48 = l58.add(Direction.NORTHWEST);
        v48 = 1000000;
        d48 = null;
        l5 = l12.add(Direction.NORTHWEST);
        v5 = 1000000;
        d5 = null;
        l37 = l47.add(Direction.NORTHWEST);
        v37 = 1000000;
        d37 = null;
        l107 = l98.add(Direction.NORTHEAST);
        v107 = 1000000;
        d107 = null;
        l81 = l69.add(Direction.NORTHEAST);
        v81 = 1000000;
        d81 = null;
        l26 = l36.add(Direction.NORTHWEST);
        v26 = 1000000;
        d26 = null;
        l6 = l13.add(Direction.NORTHWEST);
        v6 = 1000000;
        d6 = null;
        l108 = l99.add(Direction.NORTHEAST);
        v108 = 1000000;
        d108 = null;
        l92 = l80.add(Direction.NORTHEAST);
        v92 = 1000000;
        d92 = null;
    
        if (rc.onTheMap(l43) && (target.equals(l43) || !rc.canSenseRobotAtLocation(l43))) {
            p43 = 1 + rc.senseRubble(l43) / 10.0;
            if (v43 > v54 + p43) {
                v43 = v54 + p43;
                d43 = Direction.WEST;
            }
        }
        if (rc.onTheMap(l55) && (target.equals(l55) || !rc.canSenseRobotAtLocation(l55))) {
            p55 = 1 + rc.senseRubble(l55) / 10.0;
            if (v55 > v54 + p55) {
                v55 = v54 + p55;
                d55 = Direction.NORTH;
            }
        }
        if (rc.onTheMap(l65) && (target.equals(l65) || !rc.canSenseRobotAtLocation(l65))) {
            p65 = 1 + rc.senseRubble(l65) / 10.0;
            if (v65 > v54 + p65) {
                v65 = v54 + p65;
                d65 = Direction.EAST;
            }
        }
        if (rc.onTheMap(l44) && (target.equals(l44) || !rc.canSenseRobotAtLocation(l44))) {
            p44 = 1 + rc.senseRubble(l44) / 10.0;
            if (v44 > v54 + p44) {
                v44 = v54 + p44;
                d44 = Direction.NORTHWEST;
            }
        }
        if (rc.onTheMap(l66) && (target.equals(l66) || !rc.canSenseRobotAtLocation(l66))) {
            p66 = 1 + rc.senseRubble(l66) / 10.0;
            if (v66 > v54 + p66) {
                v66 = v54 + p66;
                d66 = Direction.NORTHEAST;
            }
        }
        if (rc.onTheMap(l76) && (target.equals(l76) || !rc.canSenseRobotAtLocation(l76))) {
            p76 = 1 + rc.senseRubble(l76) / 10.0;
            if (v76 > v66 + p76) {
                v76 = v66 + p76;
                d76 = d66;
            }
            if (v76 > v65 + p76) {
                v76 = v65 + p76;
                d76 = d65;
            }
        }
        if (rc.onTheMap(l56) && (target.equals(l56) || !rc.canSenseRobotAtLocation(l56))) {
            p56 = 1 + rc.senseRubble(l56) / 10.0;
            if (v56 > v44 + p56) {
                v56 = v44 + p56;
                d56 = d44;
            }
            if (v56 > v55 + p56) {
                v56 = v55 + p56;
                d56 = d55;
            }
            if (v56 > v66 + p56) {
                v56 = v66 + p56;
                d56 = d66;
            }
        }
        if (rc.onTheMap(l32) && (target.equals(l32) || !rc.canSenseRobotAtLocation(l32))) {
            p32 = 1 + rc.senseRubble(l32) / 10.0;
            if (v32 > v43 + p32) {
                v32 = v43 + p32;
                d32 = d43;
            }
            if (v32 > v44 + p32) {
                v32 = v44 + p32;
                d32 = d44;
            }
        }
        if (rc.onTheMap(l77) && (target.equals(l77) || !rc.canSenseRobotAtLocation(l77))) {
            p77 = 1 + rc.senseRubble(l77) / 10.0;
            if (v77 > v67 + p77) {
                v77 = v67 + p77;
                d77 = d67;
            }
            if (v77 > v66 + p77) {
                v77 = v66 + p77;
                d77 = d66;
            }
            if (v77 > v65 + p77) {
                v77 = v65 + p77;
                d77 = d65;
            }
            if (v77 > v76 + p77) {
                v77 = v76 + p77;
                d77 = d76;
            }
        }
        if (rc.onTheMap(l45) && (target.equals(l45) || !rc.canSenseRobotAtLocation(l45))) {
            p45 = 1 + rc.senseRubble(l45) / 10.0;
            if (v45 > v56 + p45) {
                v45 = v56 + p45;
                d45 = d56;
            }
            if (v45 > v33 + p45) {
                v45 = v33 + p45;
                d45 = d33;
            }
            if (v45 > v44 + p45) {
                v45 = v44 + p45;
                d45 = d44;
            }
            if (v45 > v55 + p45) {
                v45 = v55 + p45;
                d45 = d55;
            }
        }
        if (rc.onTheMap(l33) && (target.equals(l33) || !rc.canSenseRobotAtLocation(l33))) {
            p33 = 1 + rc.senseRubble(l33) / 10.0;
            if (v33 > v44 + p33) {
                v33 = v44 + p33;
                d33 = d44;
            }
            if (v33 > v45 + p33) {
                v33 = v45 + p33;
                d33 = d45;
            }
            if (v33 > v32 + p33) {
                v33 = v32 + p33;
                d33 = d32;
            }
            if (v33 > v43 + p33) {
                v33 = v43 + p33;
                d33 = d43;
            }
        }
        if (rc.onTheMap(l67) && (target.equals(l67) || !rc.canSenseRobotAtLocation(l67))) {
            p67 = 1 + rc.senseRubble(l67) / 10.0;
            if (v67 > v56 + p67) {
                v67 = v56 + p67;
                d67 = d56;
            }
            if (v67 > v55 + p67) {
                v67 = v55 + p67;
                d67 = d55;
            }
            if (v67 > v66 + p67) {
                v67 = v66 + p67;
                d67 = d66;
            }
            if (v67 > v77 + p67) {
                v67 = v77 + p67;
                d67 = d77;
            }
        }
        if (rc.onTheMap(l34) && (target.equals(l34) || !rc.canSenseRobotAtLocation(l34))) {
            p34 = 1 + rc.senseRubble(l34) / 10.0;
            if (v34 > v45 + p34) {
                v34 = v45 + p34;
                d34 = d45;
            }
            if (v34 > v33 + p34) {
                v34 = v33 + p34;
                d34 = d33;
            }
            if (v34 > v44 + p34) {
                v34 = v44 + p34;
                d34 = d44;
            }
        }
        if (rc.onTheMap(l78) && (target.equals(l78) || !rc.canSenseRobotAtLocation(l78))) {
            p78 = 1 + rc.senseRubble(l78) / 10.0;
            if (v78 > v67 + p78) {
                v78 = v67 + p78;
                d78 = d67;
            }
            if (v78 > v66 + p78) {
                v78 = v66 + p78;
                d78 = d66;
            }
            if (v78 > v77 + p78) {
                v78 = v77 + p78;
                d78 = d77;
            }
        }
        if (rc.onTheMap(l87) && (target.equals(l87) || !rc.canSenseRobotAtLocation(l87))) {
            p87 = 1 + rc.senseRubble(l87) / 10.0;
            if (v87 > v77 + p87) {
                v87 = v77 + p87;
                d87 = d77;
            }
            if (v87 > v76 + p87) {
                v87 = v76 + p87;
                d87 = d76;
            }
        }
        if (rc.onTheMap(l57) && (target.equals(l57) || !rc.canSenseRobotAtLocation(l57))) {
            p57 = 1 + rc.senseRubble(l57) / 10.0;
            if (v57 > v45 + p57) {
                v57 = v45 + p57;
                d57 = d45;
            }
            if (v57 > v56 + p57) {
                v57 = v56 + p57;
                d57 = d56;
            }
            if (v57 > v67 + p57) {
                v57 = v67 + p57;
                d57 = d67;
            }
        }
        if (rc.onTheMap(l21) && (target.equals(l21) || !rc.canSenseRobotAtLocation(l21))) {
            p21 = 1 + rc.senseRubble(l21) / 10.0;
            if (v21 > v32 + p21) {
                v21 = v32 + p21;
                d21 = d32;
            }
            if (v21 > v33 + p21) {
                v21 = v33 + p21;
                d21 = d33;
            }
        }
        if (rc.onTheMap(l88) && (target.equals(l88) || !rc.canSenseRobotAtLocation(l88))) {
            p88 = 1 + rc.senseRubble(l88) / 10.0;
            if (v88 > v78 + p88) {
                v88 = v78 + p88;
                d88 = d78;
            }
            if (v88 > v77 + p88) {
                v88 = v77 + p88;
                d88 = d77;
            }
            if (v88 > v76 + p88) {
                v88 = v76 + p88;
                d88 = d76;
            }
            if (v88 > v87 + p88) {
                v88 = v87 + p88;
                d88 = d87;
            }
        }
        if (rc.onTheMap(l68) && (target.equals(l68) || !rc.canSenseRobotAtLocation(l68))) {
            p68 = 1 + rc.senseRubble(l68) / 10.0;
            if (v68 > v57 + p68) {
                v68 = v57 + p68;
                d68 = d57;
            }
            if (v68 > v56 + p68) {
                v68 = v56 + p68;
                d68 = d56;
            }
            if (v68 > v67 + p68) {
                v68 = v67 + p68;
                d68 = d67;
            }
            if (v68 > v78 + p68) {
                v68 = v78 + p68;
                d68 = d78;
            }
        }
        if (rc.onTheMap(l22) && (target.equals(l22) || !rc.canSenseRobotAtLocation(l22))) {
            p22 = 1 + rc.senseRubble(l22) / 10.0;
            if (v22 > v33 + p22) {
                v22 = v33 + p22;
                d22 = d33;
            }
            if (v22 > v34 + p22) {
                v22 = v34 + p22;
                d22 = d34;
            }
            if (v22 > v21 + p22) {
                v22 = v21 + p22;
                d22 = d21;
            }
            if (v22 > v32 + p22) {
                v22 = v32 + p22;
                d22 = d32;
            }
        }
        if (rc.onTheMap(l46) && (target.equals(l46) || !rc.canSenseRobotAtLocation(l46))) {
            p46 = 1 + rc.senseRubble(l46) / 10.0;
            if (v46 > v57 + p46) {
                v46 = v57 + p46;
                d46 = d57;
            }
            if (v46 > v34 + p46) {
                v46 = v34 + p46;
                d46 = d34;
            }
            if (v46 > v45 + p46) {
                v46 = v45 + p46;
                d46 = d45;
            }
            if (v46 > v56 + p46) {
                v46 = v56 + p46;
                d46 = d56;
            }
        }
        if (rc.onTheMap(l23) && (target.equals(l23) || !rc.canSenseRobotAtLocation(l23))) {
            p23 = 1 + rc.senseRubble(l23) / 10.0;
            if (v23 > v34 + p23) {
                v23 = v34 + p23;
                d23 = d34;
            }
            if (v23 > v35 + p23) {
                v23 = v35 + p23;
                d23 = d35;
            }
            if (v23 > v22 + p23) {
                v23 = v22 + p23;
                d23 = d22;
            }
            if (v23 > v33 + p23) {
                v23 = v33 + p23;
                d23 = d33;
            }
        }
        if (rc.onTheMap(l89) && (target.equals(l89) || !rc.canSenseRobotAtLocation(l89))) {
            p89 = 1 + rc.senseRubble(l89) / 10.0;
            if (v89 > v79 + p89) {
                v89 = v79 + p89;
                d89 = d79;
            }
            if (v89 > v78 + p89) {
                v89 = v78 + p89;
                d89 = d78;
            }
            if (v89 > v77 + p89) {
                v89 = v77 + p89;
                d89 = d77;
            }
            if (v89 > v88 + p89) {
                v89 = v88 + p89;
                d89 = d88;
            }
        }
        if (rc.onTheMap(l79) && (target.equals(l79) || !rc.canSenseRobotAtLocation(l79))) {
            p79 = 1 + rc.senseRubble(l79) / 10.0;
            if (v79 > v68 + p79) {
                v79 = v68 + p79;
                d79 = d68;
            }
            if (v79 > v67 + p79) {
                v79 = v67 + p79;
                d79 = d67;
            }
            if (v79 > v78 + p79) {
                v79 = v78 + p79;
                d79 = d78;
            }
            if (v79 > v89 + p79) {
                v79 = v89 + p79;
                d79 = d89;
            }
        }
        if (rc.onTheMap(l35) && (target.equals(l35) || !rc.canSenseRobotAtLocation(l35))) {
            p35 = 1 + rc.senseRubble(l35) / 10.0;
            if (v35 > v46 + p35) {
                v35 = v46 + p35;
                d35 = d46;
            }
            if (v35 > v23 + p35) {
                v35 = v23 + p35;
                d35 = d23;
            }
            if (v35 > v34 + p35) {
                v35 = v34 + p35;
                d35 = d34;
            }
            if (v35 > v45 + p35) {
                v35 = v45 + p35;
                d35 = d45;
            }
        }
        if (rc.onTheMap(l90) && (target.equals(l90) || !rc.canSenseRobotAtLocation(l90))) {
            p90 = 1 + rc.senseRubble(l90) / 10.0;
            if (v90 > v79 + p90) {
                v90 = v79 + p90;
                d90 = d79;
            }
            if (v90 > v78 + p90) {
                v90 = v78 + p90;
                d90 = d78;
            }
            if (v90 > v89 + p90) {
                v90 = v89 + p90;
                d90 = d89;
            }
        }
        if (rc.onTheMap(l24) && (target.equals(l24) || !rc.canSenseRobotAtLocation(l24))) {
            p24 = 1 + rc.senseRubble(l24) / 10.0;
            if (v24 > v35 + p24) {
                v24 = v35 + p24;
                d24 = d35;
            }
            if (v24 > v23 + p24) {
                v24 = v23 + p24;
                d24 = d23;
            }
            if (v24 > v34 + p24) {
                v24 = v34 + p24;
                d24 = d34;
            }
        }
        if (rc.onTheMap(l11) && (target.equals(l11) || !rc.canSenseRobotAtLocation(l11))) {
            p11 = 1 + rc.senseRubble(l11) / 10.0;
            if (v11 > v21 + p11) {
                v11 = v21 + p11;
                d11 = d21;
            }
            if (v11 > v22 + p11) {
                v11 = v22 + p11;
                d11 = d22;
            }
        }
        if (rc.onTheMap(l97) && (target.equals(l97) || !rc.canSenseRobotAtLocation(l97))) {
            p97 = 1 + rc.senseRubble(l97) / 10.0;
            if (v97 > v88 + p97) {
                v97 = v88 + p97;
                d97 = d88;
            }
            if (v97 > v87 + p97) {
                v97 = v87 + p97;
                d97 = d87;
            }
        }
        if (rc.onTheMap(l58) && (target.equals(l58) || !rc.canSenseRobotAtLocation(l58))) {
            p58 = 1 + rc.senseRubble(l58) / 10.0;
            if (v58 > v46 + p58) {
                v58 = v46 + p58;
                d58 = d46;
            }
            if (v58 > v57 + p58) {
                v58 = v57 + p58;
                d58 = d57;
            }
            if (v58 > v68 + p58) {
                v58 = v68 + p58;
                d58 = d68;
            }
        }
        if (rc.onTheMap(l12) && (target.equals(l12) || !rc.canSenseRobotAtLocation(l12))) {
            p12 = 1 + rc.senseRubble(l12) / 10.0;
            if (v12 > v22 + p12) {
                v12 = v22 + p12;
                d12 = d22;
            }
            if (v12 > v23 + p12) {
                v12 = v23 + p12;
                d12 = d23;
            }
            if (v12 > v11 + p12) {
                v12 = v11 + p12;
                d12 = d11;
            }
            if (v12 > v21 + p12) {
                v12 = v21 + p12;
                d12 = d21;
            }
        }
        if (rc.onTheMap(l47) && (target.equals(l47) || !rc.canSenseRobotAtLocation(l47))) {
            p47 = 1 + rc.senseRubble(l47) / 10.0;
            if (v47 > v58 + p47) {
                v47 = v58 + p47;
                d47 = d58;
            }
            if (v47 > v35 + p47) {
                v47 = v35 + p47;
                d47 = d35;
            }
            if (v47 > v46 + p47) {
                v47 = v46 + p47;
                d47 = d46;
            }
            if (v47 > v57 + p47) {
                v47 = v57 + p47;
                d47 = d57;
            }
        }
        if (rc.onTheMap(l98) && (target.equals(l98) || !rc.canSenseRobotAtLocation(l98))) {
            p98 = 1 + rc.senseRubble(l98) / 10.0;
            if (v98 > v89 + p98) {
                v98 = v89 + p98;
                d98 = d89;
            }
            if (v98 > v88 + p98) {
                v98 = v88 + p98;
                d98 = d88;
            }
            if (v98 > v87 + p98) {
                v98 = v87 + p98;
                d98 = d87;
            }
            if (v98 > v97 + p98) {
                v98 = v97 + p98;
                d98 = d97;
            }
        }
        if (rc.onTheMap(l69) && (target.equals(l69) || !rc.canSenseRobotAtLocation(l69))) {
            p69 = 1 + rc.senseRubble(l69) / 10.0;
            if (v69 > v58 + p69) {
                v69 = v58 + p69;
                d69 = d58;
            }
            if (v69 > v57 + p69) {
                v69 = v57 + p69;
                d69 = d57;
            }
            if (v69 > v68 + p69) {
                v69 = v68 + p69;
                d69 = d68;
            }
            if (v69 > v79 + p69) {
                v69 = v79 + p69;
                d69 = d79;
            }
        }
        if (rc.onTheMap(l36) && (target.equals(l36) || !rc.canSenseRobotAtLocation(l36))) {
            p36 = 1 + rc.senseRubble(l36) / 10.0;
            if (v36 > v47 + p36) {
                v36 = v47 + p36;
                d36 = d47;
            }
            if (v36 > v24 + p36) {
                v36 = v24 + p36;
                d36 = d24;
            }
            if (v36 > v35 + p36) {
                v36 = v35 + p36;
                d36 = d35;
            }
            if (v36 > v46 + p36) {
                v36 = v46 + p36;
                d36 = d46;
            }
        }
        if (rc.onTheMap(l13) && (target.equals(l13) || !rc.canSenseRobotAtLocation(l13))) {
            p13 = 1 + rc.senseRubble(l13) / 10.0;
            if (v13 > v23 + p13) {
                v13 = v23 + p13;
                d13 = d23;
            }
            if (v13 > v24 + p13) {
                v13 = v24 + p13;
                d13 = d24;
            }
            if (v13 > v12 + p13) {
                v13 = v12 + p13;
                d13 = d12;
            }
            if (v13 > v22 + p13) {
                v13 = v22 + p13;
                d13 = d22;
            }
        }
        if (rc.onTheMap(l99) && (target.equals(l99) || !rc.canSenseRobotAtLocation(l99))) {
            p99 = 1 + rc.senseRubble(l99) / 10.0;
            if (v99 > v90 + p99) {
                v99 = v90 + p99;
                d99 = d90;
            }
            if (v99 > v89 + p99) {
                v99 = v89 + p99;
                d99 = d89;
            }
            if (v99 > v88 + p99) {
                v99 = v88 + p99;
                d99 = d88;
            }
            if (v99 > v98 + p99) {
                v99 = v98 + p99;
                d99 = d98;
            }
        }
        if (rc.onTheMap(l80) && (target.equals(l80) || !rc.canSenseRobotAtLocation(l80))) {
            p80 = 1 + rc.senseRubble(l80) / 10.0;
            if (v80 > v69 + p80) {
                v80 = v69 + p80;
                d80 = d69;
            }
            if (v80 > v68 + p80) {
                v80 = v68 + p80;
                d80 = d68;
            }
            if (v80 > v79 + p80) {
                v80 = v79 + p80;
                d80 = d79;
            }
            if (v80 > v90 + p80) {
                v80 = v90 + p80;
                d80 = d90;
            }
        }
        if (rc.onTheMap(l91) && (target.equals(l91) || !rc.canSenseRobotAtLocation(l91))) {
            p91 = 1 + rc.senseRubble(l91) / 10.0;
            if (v91 > v80 + p91) {
                v91 = v80 + p91;
                d91 = d80;
            }
            if (v91 > v79 + p91) {
                v91 = v79 + p91;
                d91 = d79;
            }
            if (v91 > v90 + p91) {
                v91 = v90 + p91;
                d91 = d90;
            }
            if (v91 > v100 + p91) {
                v91 = v100 + p91;
                d91 = d100;
            }
        }
        if (rc.onTheMap(l25) && (target.equals(l25) || !rc.canSenseRobotAtLocation(l25))) {
            p25 = 1 + rc.senseRubble(l25) / 10.0;
            if (v25 > v36 + p25) {
                v25 = v36 + p25;
                d25 = d36;
            }
            if (v25 > v14 + p25) {
                v25 = v14 + p25;
                d25 = d14;
            }
            if (v25 > v24 + p25) {
                v25 = v24 + p25;
                d25 = d24;
            }
            if (v25 > v35 + p25) {
                v25 = v35 + p25;
                d25 = d35;
            }
        }
        if (rc.onTheMap(l100) && (target.equals(l100) || !rc.canSenseRobotAtLocation(l100))) {
            p100 = 1 + rc.senseRubble(l100) / 10.0;
            if (v100 > v91 + p100) {
                v100 = v91 + p100;
                d100 = d91;
            }
            if (v100 > v90 + p100) {
                v100 = v90 + p100;
                d100 = d90;
            }
            if (v100 > v89 + p100) {
                v100 = v89 + p100;
                d100 = d89;
            }
            if (v100 > v99 + p100) {
                v100 = v99 + p100;
                d100 = d99;
            }
        }
        if (rc.onTheMap(l14) && (target.equals(l14) || !rc.canSenseRobotAtLocation(l14))) {
            p14 = 1 + rc.senseRubble(l14) / 10.0;
            if (v14 > v24 + p14) {
                v14 = v24 + p14;
                d14 = d24;
            }
            if (v14 > v25 + p14) {
                v14 = v25 + p14;
                d14 = d25;
            }
            if (v14 > v13 + p14) {
                v14 = v13 + p14;
                d14 = d13;
            }
            if (v14 > v23 + p14) {
                v14 = v23 + p14;
                d14 = d23;
            }
        }
        if (rc.onTheMap(l101) && (target.equals(l101) || !rc.canSenseRobotAtLocation(l101))) {
            p101 = 1 + rc.senseRubble(l101) / 10.0;
            if (v101 > v91 + p101) {
                v101 = v91 + p101;
                d101 = d91;
            }
            if (v101 > v90 + p101) {
                v101 = v90 + p101;
                d101 = d90;
            }
            if (v101 > v100 + p101) {
                v101 = v100 + p101;
                d101 = d100;
            }
        }
        if (rc.onTheMap(l15) && (target.equals(l15) || !rc.canSenseRobotAtLocation(l15))) {
            p15 = 1 + rc.senseRubble(l15) / 10.0;
            if (v15 > v25 + p15) {
                v15 = v25 + p15;
                d15 = d25;
            }
            if (v15 > v14 + p15) {
                v15 = v14 + p15;
                d15 = d14;
            }
            if (v15 > v24 + p15) {
                v15 = v24 + p15;
                d15 = d24;
            }
        }
        if (rc.onTheMap(l105) && (target.equals(l105) || !rc.canSenseRobotAtLocation(l105))) {
            p105 = 1 + rc.senseRubble(l105) / 10.0;
            if (v105 > v98 + p105) {
                v105 = v98 + p105;
                d105 = d98;
            }
            if (v105 > v97 + p105) {
                v105 = v97 + p105;
                d105 = d97;
            }
        }
        if (rc.onTheMap(l59) && (target.equals(l59) || !rc.canSenseRobotAtLocation(l59))) {
            p59 = 1 + rc.senseRubble(l59) / 10.0;
            if (v59 > v47 + p59) {
                v59 = v47 + p59;
                d59 = d47;
            }
            if (v59 > v58 + p59) {
                v59 = v58 + p59;
                d59 = d58;
            }
            if (v59 > v69 + p59) {
                v59 = v69 + p59;
                d59 = d69;
            }
        }
        if (rc.onTheMap(l3) && (target.equals(l3) || !rc.canSenseRobotAtLocation(l3))) {
            p3 = 1 + rc.senseRubble(l3) / 10.0;
            if (v3 > v11 + p3) {
                v3 = v11 + p3;
                d3 = d11;
            }
            if (v3 > v12 + p3) {
                v3 = v12 + p3;
                d3 = d12;
            }
        }
        if (rc.onTheMap(l48) && (target.equals(l48) || !rc.canSenseRobotAtLocation(l48))) {
            p48 = 1 + rc.senseRubble(l48) / 10.0;
            if (v48 > v59 + p48) {
                v48 = v59 + p48;
                d48 = d59;
            }
            if (v48 > v36 + p48) {
                v48 = v36 + p48;
                d48 = d36;
            }
            if (v48 > v47 + p48) {
                v48 = v47 + p48;
                d48 = d47;
            }
            if (v48 > v58 + p48) {
                v48 = v58 + p48;
                d48 = d58;
            }
        }
        if (rc.onTheMap(l4) && (target.equals(l4) || !rc.canSenseRobotAtLocation(l4))) {
            p4 = 1 + rc.senseRubble(l4) / 10.0;
            if (v4 > v12 + p4) {
                v4 = v12 + p4;
                d4 = d12;
            }
            if (v4 > v13 + p4) {
                v4 = v13 + p4;
                d4 = d13;
            }
            if (v4 > v3 + p4) {
                v4 = v3 + p4;
                d4 = d3;
            }
            if (v4 > v11 + p4) {
                v4 = v11 + p4;
                d4 = d11;
            }
        }
        if (rc.onTheMap(l70) && (target.equals(l70) || !rc.canSenseRobotAtLocation(l70))) {
            p70 = 1 + rc.senseRubble(l70) / 10.0;
            if (v70 > v59 + p70) {
                v70 = v59 + p70;
                d70 = d59;
            }
            if (v70 > v58 + p70) {
                v70 = v58 + p70;
                d70 = d58;
            }
            if (v70 > v69 + p70) {
                v70 = v69 + p70;
                d70 = d69;
            }
            if (v70 > v80 + p70) {
                v70 = v80 + p70;
                d70 = d80;
            }
        }
        if (rc.onTheMap(l106) && (target.equals(l106) || !rc.canSenseRobotAtLocation(l106))) {
            p106 = 1 + rc.senseRubble(l106) / 10.0;
            if (v106 > v99 + p106) {
                v106 = v99 + p106;
                d106 = d99;
            }
            if (v106 > v98 + p106) {
                v106 = v98 + p106;
                d106 = d98;
            }
            if (v106 > v97 + p106) {
                v106 = v97 + p106;
                d106 = d97;
            }
            if (v106 > v105 + p106) {
                v106 = v105 + p106;
                d106 = d105;
            }
        }
        if (rc.onTheMap(l81) && (target.equals(l81) || !rc.canSenseRobotAtLocation(l81))) {
            p81 = 1 + rc.senseRubble(l81) / 10.0;
            if (v81 > v70 + p81) {
                v81 = v70 + p81;
                d81 = d70;
            }
            if (v81 > v69 + p81) {
                v81 = v69 + p81;
                d81 = d69;
            }
            if (v81 > v80 + p81) {
                v81 = v80 + p81;
                d81 = d80;
            }
            if (v81 > v91 + p81) {
                v81 = v91 + p81;
                d81 = d91;
            }
        }
        if (rc.onTheMap(l107) && (target.equals(l107) || !rc.canSenseRobotAtLocation(l107))) {
            p107 = 1 + rc.senseRubble(l107) / 10.0;
            if (v107 > v100 + p107) {
                v107 = v100 + p107;
                d107 = d100;
            }
            if (v107 > v99 + p107) {
                v107 = v99 + p107;
                d107 = d99;
            }
            if (v107 > v98 + p107) {
                v107 = v98 + p107;
                d107 = d98;
            }
            if (v107 > v106 + p107) {
                v107 = v106 + p107;
                d107 = d106;
            }
        }
        if (rc.onTheMap(l5) && (target.equals(l5) || !rc.canSenseRobotAtLocation(l5))) {
            p5 = 1 + rc.senseRubble(l5) / 10.0;
            if (v5 > v13 + p5) {
                v5 = v13 + p5;
                d5 = d13;
            }
            if (v5 > v14 + p5) {
                v5 = v14 + p5;
                d5 = d14;
            }
            if (v5 > v4 + p5) {
                v5 = v4 + p5;
                d5 = d4;
            }
            if (v5 > v12 + p5) {
                v5 = v12 + p5;
                d5 = d12;
            }
        }
        if (rc.onTheMap(l37) && (target.equals(l37) || !rc.canSenseRobotAtLocation(l37))) {
            p37 = 1 + rc.senseRubble(l37) / 10.0;
            if (v37 > v48 + p37) {
                v37 = v48 + p37;
                d37 = d48;
            }
            if (v37 > v25 + p37) {
                v37 = v25 + p37;
                d37 = d25;
            }
            if (v37 > v36 + p37) {
                v37 = v36 + p37;
                d37 = d36;
            }
            if (v37 > v47 + p37) {
                v37 = v47 + p37;
                d37 = d47;
            }
        }
        if (rc.onTheMap(l26) && (target.equals(l26) || !rc.canSenseRobotAtLocation(l26))) {
            p26 = 1 + rc.senseRubble(l26) / 10.0;
            if (v26 > v37 + p26) {
                v26 = v37 + p26;
                d26 = d37;
            }
            if (v26 > v15 + p26) {
                v26 = v15 + p26;
                d26 = d15;
            }
            if (v26 > v25 + p26) {
                v26 = v25 + p26;
                d26 = d25;
            }
            if (v26 > v36 + p26) {
                v26 = v36 + p26;
                d26 = d36;
            }
        }
        if (rc.onTheMap(l108) && (target.equals(l108) || !rc.canSenseRobotAtLocation(l108))) {
            p108 = 1 + rc.senseRubble(l108) / 10.0;
            if (v108 > v101 + p108) {
                v108 = v101 + p108;
                d108 = d101;
            }
            if (v108 > v100 + p108) {
                v108 = v100 + p108;
                d108 = d100;
            }
            if (v108 > v99 + p108) {
                v108 = v99 + p108;
                d108 = d99;
            }
            if (v108 > v107 + p108) {
                v108 = v107 + p108;
                d108 = d107;
            }
        }
        if (rc.onTheMap(l92) && (target.equals(l92) || !rc.canSenseRobotAtLocation(l92))) {
            p92 = 1 + rc.senseRubble(l92) / 10.0;
            if (v92 > v81 + p92) {
                v92 = v81 + p92;
                d92 = d81;
            }
            if (v92 > v80 + p92) {
                v92 = v80 + p92;
                d92 = d80;
            }
            if (v92 > v91 + p92) {
                v92 = v91 + p92;
                d92 = d91;
            }
            if (v92 > v101 + p92) {
                v92 = v101 + p92;
                d92 = d101;
            }
        }
        if (rc.onTheMap(l6) && (target.equals(l6) || !rc.canSenseRobotAtLocation(l6))) {
            p6 = 1 + rc.senseRubble(l6) / 10.0;
            if (v6 > v14 + p6) {
                v6 = v14 + p6;
                d6 = d14;
            }
            if (v6 > v15 + p6) {
                v6 = v15 + p6;
                d6 = d15;
            }
            if (v6 > v5 + p6) {
                v6 = v5 + p6;
                d6 = d5;
            }
            if (v6 > v13 + p6) {
                v6 = v13 + p6;
                d6 = d13;
            }
        }
    
        int dx = target.x - l54.x;
        int dy = target.y - l54.y;

        switch(dx) {
        case -5:
            switch(dy) {
                case 0:
                    return d3;
                case 1:
                    return d4;
                case 2:
                    return d5;
                case 3:
                    return d6;
            }
            break;
        case -4:
            switch(dy) {
                case 0:
                    return d11;
                case 1:
                    return d12;
                case 2:
                    return d13;
                case 3:
                    return d14;
                case 4:
                    return d15;
            }
            break;
        case -3:
            switch(dy) {
                case 0:
                    return d21;
                case 1:
                    return d22;
                case 2:
                    return d23;
                case 3:
                    return d24;
                case 4:
                    return d25;
                case 5:
                    return d26;
            }
            break;
        case -2:
            switch(dy) {
                case 0:
                    return d32;
                case 1:
                    return d33;
                case 2:
                    return d34;
                case 3:
                    return d35;
                case 4:
                    return d36;
                case 5:
                    return d37;
            }
            break;
        case -1:
            switch(dy) {
                case 0:
                    return d43;
                case 1:
                    return d44;
                case 2:
                    return d45;
                case 3:
                    return d46;
                case 4:
                    return d47;
                case 5:
                    return d48;
            }
            break;
        case 0:
            switch(dy) {
                case 0:
                    return d54;
                case 1:
                    return d55;
                case 2:
                    return d56;
                case 3:
                    return d57;
                case 4:
                    return d58;
                case 5:
                    return d59;
            }
            break;
        case 1:
            switch(dy) {
                case 0:
                    return d65;
                case 1:
                    return d66;
                case 2:
                    return d67;
                case 3:
                    return d68;
                case 4:
                    return d69;
                case 5:
                    return d70;
            }
            break;
        case 2:
            switch(dy) {
                case 0:
                    return d76;
                case 1:
                    return d77;
                case 2:
                    return d78;
                case 3:
                    return d79;
                case 4:
                    return d80;
                case 5:
                    return d81;
            }
            break;
        case 3:
            switch(dy) {
                case 0:
                    return d87;
                case 1:
                    return d88;
                case 2:
                    return d89;
                case 3:
                    return d90;
                case 4:
                    return d91;
                case 5:
                    return d92;
            }
            break;
        case 4:
            switch(dy) {
                case 0:
                    return d97;
                case 1:
                    return d98;
                case 2:
                    return d99;
                case 3:
                    return d100;
                case 4:
                    return d101;
            }
            break;
        case 5:
            switch(dy) {
                case 0:
                    return d105;
                case 1:
                    return d106;
                case 2:
                    return d107;
                case 3:
                    return d108;
            }
            break;
        }
    
        Direction ans = null;
        double bestEstimation = 0;
        double initialDist = Math.sqrt(l54.distanceSquaredTo(target));
        
        double dist3 = (initialDist - Math.sqrt(l3.distanceSquaredTo(target))) / v3;
        if (dist3 > bestEstimation) {
            bestEstimation = dist3;
            ans = d3;
        }
        double dist4 = (initialDist - Math.sqrt(l4.distanceSquaredTo(target))) / v4;
        if (dist4 > bestEstimation) {
            bestEstimation = dist4;
            ans = d4;
        }
        double dist5 = (initialDist - Math.sqrt(l5.distanceSquaredTo(target))) / v5;
        if (dist5 > bestEstimation) {
            bestEstimation = dist5;
            ans = d5;
        }
        double dist6 = (initialDist - Math.sqrt(l6.distanceSquaredTo(target))) / v6;
        if (dist6 > bestEstimation) {
            bestEstimation = dist6;
            ans = d6;
        }
        double dist11 = (initialDist - Math.sqrt(l11.distanceSquaredTo(target))) / v11;
        if (dist11 > bestEstimation) {
            bestEstimation = dist11;
            ans = d11;
        }
        double dist12 = (initialDist - Math.sqrt(l12.distanceSquaredTo(target))) / v12;
        if (dist12 > bestEstimation) {
            bestEstimation = dist12;
            ans = d12;
        }
        double dist13 = (initialDist - Math.sqrt(l13.distanceSquaredTo(target))) / v13;
        if (dist13 > bestEstimation) {
            bestEstimation = dist13;
            ans = d13;
        }
        double dist14 = (initialDist - Math.sqrt(l14.distanceSquaredTo(target))) / v14;
        if (dist14 > bestEstimation) {
            bestEstimation = dist14;
            ans = d14;
        }
        double dist15 = (initialDist - Math.sqrt(l15.distanceSquaredTo(target))) / v15;
        if (dist15 > bestEstimation) {
            bestEstimation = dist15;
            ans = d15;
        }
        double dist21 = (initialDist - Math.sqrt(l21.distanceSquaredTo(target))) / v21;
        if (dist21 > bestEstimation) {
            bestEstimation = dist21;
            ans = d21;
        }
        double dist22 = (initialDist - Math.sqrt(l22.distanceSquaredTo(target))) / v22;
        if (dist22 > bestEstimation) {
            bestEstimation = dist22;
            ans = d22;
        }
        double dist23 = (initialDist - Math.sqrt(l23.distanceSquaredTo(target))) / v23;
        if (dist23 > bestEstimation) {
            bestEstimation = dist23;
            ans = d23;
        }
        double dist24 = (initialDist - Math.sqrt(l24.distanceSquaredTo(target))) / v24;
        if (dist24 > bestEstimation) {
            bestEstimation = dist24;
            ans = d24;
        }
        double dist25 = (initialDist - Math.sqrt(l25.distanceSquaredTo(target))) / v25;
        if (dist25 > bestEstimation) {
            bestEstimation = dist25;
            ans = d25;
        }
        double dist26 = (initialDist - Math.sqrt(l26.distanceSquaredTo(target))) / v26;
        if (dist26 > bestEstimation) {
            bestEstimation = dist26;
            ans = d26;
        }
        double dist32 = (initialDist - Math.sqrt(l32.distanceSquaredTo(target))) / v32;
        if (dist32 > bestEstimation) {
            bestEstimation = dist32;
            ans = d32;
        }
        double dist33 = (initialDist - Math.sqrt(l33.distanceSquaredTo(target))) / v33;
        if (dist33 > bestEstimation) {
            bestEstimation = dist33;
            ans = d33;
        }
        double dist34 = (initialDist - Math.sqrt(l34.distanceSquaredTo(target))) / v34;
        if (dist34 > bestEstimation) {
            bestEstimation = dist34;
            ans = d34;
        }
        double dist35 = (initialDist - Math.sqrt(l35.distanceSquaredTo(target))) / v35;
        if (dist35 > bestEstimation) {
            bestEstimation = dist35;
            ans = d35;
        }
        double dist36 = (initialDist - Math.sqrt(l36.distanceSquaredTo(target))) / v36;
        if (dist36 > bestEstimation) {
            bestEstimation = dist36;
            ans = d36;
        }
        double dist37 = (initialDist - Math.sqrt(l37.distanceSquaredTo(target))) / v37;
        if (dist37 > bestEstimation) {
            bestEstimation = dist37;
            ans = d37;
        }
        double dist43 = (initialDist - Math.sqrt(l43.distanceSquaredTo(target))) / v43;
        if (dist43 > bestEstimation) {
            bestEstimation = dist43;
            ans = d43;
        }
        double dist44 = (initialDist - Math.sqrt(l44.distanceSquaredTo(target))) / v44;
        if (dist44 > bestEstimation) {
            bestEstimation = dist44;
            ans = d44;
        }
        double dist45 = (initialDist - Math.sqrt(l45.distanceSquaredTo(target))) / v45;
        if (dist45 > bestEstimation) {
            bestEstimation = dist45;
            ans = d45;
        }
        double dist46 = (initialDist - Math.sqrt(l46.distanceSquaredTo(target))) / v46;
        if (dist46 > bestEstimation) {
            bestEstimation = dist46;
            ans = d46;
        }
        double dist47 = (initialDist - Math.sqrt(l47.distanceSquaredTo(target))) / v47;
        if (dist47 > bestEstimation) {
            bestEstimation = dist47;
            ans = d47;
        }
        double dist48 = (initialDist - Math.sqrt(l48.distanceSquaredTo(target))) / v48;
        if (dist48 > bestEstimation) {
            bestEstimation = dist48;
            ans = d48;
        }
        double dist54 = (initialDist - Math.sqrt(l54.distanceSquaredTo(target))) / v54;
        if (dist54 > bestEstimation) {
            bestEstimation = dist54;
            ans = d54;
        }
        double dist55 = (initialDist - Math.sqrt(l55.distanceSquaredTo(target))) / v55;
        if (dist55 > bestEstimation) {
            bestEstimation = dist55;
            ans = d55;
        }
        double dist56 = (initialDist - Math.sqrt(l56.distanceSquaredTo(target))) / v56;
        if (dist56 > bestEstimation) {
            bestEstimation = dist56;
            ans = d56;
        }
        double dist57 = (initialDist - Math.sqrt(l57.distanceSquaredTo(target))) / v57;
        if (dist57 > bestEstimation) {
            bestEstimation = dist57;
            ans = d57;
        }
        double dist58 = (initialDist - Math.sqrt(l58.distanceSquaredTo(target))) / v58;
        if (dist58 > bestEstimation) {
            bestEstimation = dist58;
            ans = d58;
        }
        double dist59 = (initialDist - Math.sqrt(l59.distanceSquaredTo(target))) / v59;
        if (dist59 > bestEstimation) {
            bestEstimation = dist59;
            ans = d59;
        }
        double dist65 = (initialDist - Math.sqrt(l65.distanceSquaredTo(target))) / v65;
        if (dist65 > bestEstimation) {
            bestEstimation = dist65;
            ans = d65;
        }
        double dist66 = (initialDist - Math.sqrt(l66.distanceSquaredTo(target))) / v66;
        if (dist66 > bestEstimation) {
            bestEstimation = dist66;
            ans = d66;
        }
        double dist67 = (initialDist - Math.sqrt(l67.distanceSquaredTo(target))) / v67;
        if (dist67 > bestEstimation) {
            bestEstimation = dist67;
            ans = d67;
        }
        double dist68 = (initialDist - Math.sqrt(l68.distanceSquaredTo(target))) / v68;
        if (dist68 > bestEstimation) {
            bestEstimation = dist68;
            ans = d68;
        }
        double dist69 = (initialDist - Math.sqrt(l69.distanceSquaredTo(target))) / v69;
        if (dist69 > bestEstimation) {
            bestEstimation = dist69;
            ans = d69;
        }
        double dist70 = (initialDist - Math.sqrt(l70.distanceSquaredTo(target))) / v70;
        if (dist70 > bestEstimation) {
            bestEstimation = dist70;
            ans = d70;
        }
        double dist76 = (initialDist - Math.sqrt(l76.distanceSquaredTo(target))) / v76;
        if (dist76 > bestEstimation) {
            bestEstimation = dist76;
            ans = d76;
        }
        double dist77 = (initialDist - Math.sqrt(l77.distanceSquaredTo(target))) / v77;
        if (dist77 > bestEstimation) {
            bestEstimation = dist77;
            ans = d77;
        }
        double dist78 = (initialDist - Math.sqrt(l78.distanceSquaredTo(target))) / v78;
        if (dist78 > bestEstimation) {
            bestEstimation = dist78;
            ans = d78;
        }
        double dist79 = (initialDist - Math.sqrt(l79.distanceSquaredTo(target))) / v79;
        if (dist79 > bestEstimation) {
            bestEstimation = dist79;
            ans = d79;
        }
        double dist80 = (initialDist - Math.sqrt(l80.distanceSquaredTo(target))) / v80;
        if (dist80 > bestEstimation) {
            bestEstimation = dist80;
            ans = d80;
        }
        double dist81 = (initialDist - Math.sqrt(l81.distanceSquaredTo(target))) / v81;
        if (dist81 > bestEstimation) {
            bestEstimation = dist81;
            ans = d81;
        }
        double dist87 = (initialDist - Math.sqrt(l87.distanceSquaredTo(target))) / v87;
        if (dist87 > bestEstimation) {
            bestEstimation = dist87;
            ans = d87;
        }
        double dist88 = (initialDist - Math.sqrt(l88.distanceSquaredTo(target))) / v88;
        if (dist88 > bestEstimation) {
            bestEstimation = dist88;
            ans = d88;
        }
        double dist89 = (initialDist - Math.sqrt(l89.distanceSquaredTo(target))) / v89;
        if (dist89 > bestEstimation) {
            bestEstimation = dist89;
            ans = d89;
        }
        double dist90 = (initialDist - Math.sqrt(l90.distanceSquaredTo(target))) / v90;
        if (dist90 > bestEstimation) {
            bestEstimation = dist90;
            ans = d90;
        }
        double dist91 = (initialDist - Math.sqrt(l91.distanceSquaredTo(target))) / v91;
        if (dist91 > bestEstimation) {
            bestEstimation = dist91;
            ans = d91;
        }
        double dist92 = (initialDist - Math.sqrt(l92.distanceSquaredTo(target))) / v92;
        if (dist92 > bestEstimation) {
            bestEstimation = dist92;
            ans = d92;
        }
        double dist97 = (initialDist - Math.sqrt(l97.distanceSquaredTo(target))) / v97;
        if (dist97 > bestEstimation) {
            bestEstimation = dist97;
            ans = d97;
        }
        double dist98 = (initialDist - Math.sqrt(l98.distanceSquaredTo(target))) / v98;
        if (dist98 > bestEstimation) {
            bestEstimation = dist98;
            ans = d98;
        }
        double dist99 = (initialDist - Math.sqrt(l99.distanceSquaredTo(target))) / v99;
        if (dist99 > bestEstimation) {
            bestEstimation = dist99;
            ans = d99;
        }
        double dist100 = (initialDist - Math.sqrt(l100.distanceSquaredTo(target))) / v100;
        if (dist100 > bestEstimation) {
            bestEstimation = dist100;
            ans = d100;
        }
        double dist101 = (initialDist - Math.sqrt(l101.distanceSquaredTo(target))) / v101;
        if (dist101 > bestEstimation) {
            bestEstimation = dist101;
            ans = d101;
        }
        double dist105 = (initialDist - Math.sqrt(l105.distanceSquaredTo(target))) / v105;
        if (dist105 > bestEstimation) {
            bestEstimation = dist105;
            ans = d105;
        }
        double dist106 = (initialDist - Math.sqrt(l106.distanceSquaredTo(target))) / v106;
        if (dist106 > bestEstimation) {
            bestEstimation = dist106;
            ans = d106;
        }
        double dist107 = (initialDist - Math.sqrt(l107.distanceSquaredTo(target))) / v107;
        if (dist107 > bestEstimation) {
            bestEstimation = dist107;
            ans = d107;
        }
        double dist108 = (initialDist - Math.sqrt(l108.distanceSquaredTo(target))) / v108;
        if (dist108 > bestEstimation) {
            bestEstimation = dist108;
            ans = d108;
        }
        return ans;
    }

    private Direction getBestDirection3(MapLocation target) throws GameActionException {
        l54 = currentLocation;
        v54 = 0; 
        l65 = l54.add(Direction.EAST);
        v65 = 1000000;
        d65 = null;
        l43 = l54.add(Direction.WEST);
        v43 = 1000000;
        d43 = null;
        l42 = l54.add(Direction.SOUTHWEST);
        v42 = 1000000;
        d42 = null;
        l53 = l54.add(Direction.SOUTH);
        v53 = 1000000;
        d53 = null;
        l64 = l54.add(Direction.SOUTHEAST);
        v64 = 1000000;
        d64 = null;
        l41 = l53.add(Direction.SOUTHWEST);
        v41 = 1000000;
        d41 = null;
        l52 = l53.add(Direction.SOUTH);
        v52 = 1000000;
        d52 = null;
        l63 = l53.add(Direction.SOUTHEAST);
        v63 = 1000000;
        d63 = null;
        l32 = l43.add(Direction.WEST);
        v32 = 1000000;
        d32 = null;
        l31 = l43.add(Direction.SOUTHWEST);
        v31 = 1000000;
        d31 = null;
        l76 = l65.add(Direction.EAST);
        v76 = 1000000;
        d76 = null;
        l75 = l65.add(Direction.SOUTHEAST);
        v75 = 1000000;
        d75 = null;
        l74 = l64.add(Direction.SOUTHEAST);
        v74 = 1000000;
        d74 = null;
        l30 = l42.add(Direction.SOUTHWEST);
        v30 = 1000000;
        d30 = null;
        l87 = l76.add(Direction.EAST);
        v87 = 1000000;
        d87 = null;
        l86 = l76.add(Direction.SOUTHEAST);
        v86 = 1000000;
        d86 = null;
        l40 = l52.add(Direction.SOUTHWEST);
        v40 = 1000000;
        d40 = null;
        l51 = l52.add(Direction.SOUTH);
        v51 = 1000000;
        d51 = null;
        l62 = l52.add(Direction.SOUTHEAST);
        v62 = 1000000;
        d62 = null;
        l21 = l32.add(Direction.WEST);
        v21 = 1000000;
        d21 = null;
        l20 = l32.add(Direction.SOUTHWEST);
        v20 = 1000000;
        d20 = null;
        l85 = l75.add(Direction.SOUTHEAST);
        v85 = 1000000;
        d85 = null;
        l19 = l31.add(Direction.SOUTHWEST);
        v19 = 1000000;
        d19 = null;
        l29 = l41.add(Direction.SOUTHWEST);
        v29 = 1000000;
        d29 = null;
        l73 = l63.add(Direction.SOUTHEAST);
        v73 = 1000000;
        d73 = null;
        l84 = l74.add(Direction.SOUTHEAST);
        v84 = 1000000;
        d84 = null;
        l18 = l30.add(Direction.SOUTHWEST);
        v18 = 1000000;
        d18 = null;
        l97 = l87.add(Direction.EAST);
        v97 = 1000000;
        d97 = null;
        l96 = l87.add(Direction.SOUTHEAST);
        v96 = 1000000;
        d96 = null;
        l39 = l51.add(Direction.SOUTHWEST);
        v39 = 1000000;
        d39 = null;
        l50 = l51.add(Direction.SOUTH);
        v50 = 1000000;
        d50 = null;
        l61 = l51.add(Direction.SOUTHEAST);
        v61 = 1000000;
        d61 = null;
        l11 = l21.add(Direction.WEST);
        v11 = 1000000;
        d11 = null;
        l10 = l21.add(Direction.SOUTHWEST);
        v10 = 1000000;
        d10 = null;
        l95 = l86.add(Direction.SOUTHEAST);
        v95 = 1000000;
        d95 = null;
        l28 = l40.add(Direction.SOUTHWEST);
        v28 = 1000000;
        d28 = null;
        l9 = l20.add(Direction.SOUTHWEST);
        v9 = 1000000;
        d9 = null;
        l72 = l62.add(Direction.SOUTHEAST);
        v72 = 1000000;
        d72 = null;
        l17 = l29.add(Direction.SOUTHWEST);
        v17 = 1000000;
        d17 = null;
        l94 = l85.add(Direction.SOUTHEAST);
        v94 = 1000000;
        d94 = null;
        l83 = l73.add(Direction.SOUTHEAST);
        v83 = 1000000;
        d83 = null;
        l8 = l19.add(Direction.SOUTHWEST);
        v8 = 1000000;
        d8 = null;
        l7 = l18.add(Direction.SOUTHWEST);
        v7 = 1000000;
        d7 = null;
        l93 = l84.add(Direction.SOUTHEAST);
        v93 = 1000000;
        d93 = null;
        l3 = l11.add(Direction.WEST);
        v3 = 1000000;
        d3 = null;
        l2 = l11.add(Direction.SOUTHWEST);
        v2 = 1000000;
        d2 = null;
        l105 = l97.add(Direction.EAST);
        v105 = 1000000;
        d105 = null;
        l104 = l97.add(Direction.SOUTHEAST);
        v104 = 1000000;
        d104 = null;
        l38 = l50.add(Direction.SOUTHWEST);
        v38 = 1000000;
        d38 = null;
        l49 = l50.add(Direction.SOUTH);
        v49 = 1000000;
        d49 = null;
        l60 = l50.add(Direction.SOUTHEAST);
        v60 = 1000000;
        d60 = null;
        l1 = l10.add(Direction.SOUTHWEST);
        v1 = 1000000;
        d1 = null;
        l71 = l61.add(Direction.SOUTHEAST);
        v71 = 1000000;
        d71 = null;
        l103 = l96.add(Direction.SOUTHEAST);
        v103 = 1000000;
        d103 = null;
        l27 = l39.add(Direction.SOUTHWEST);
        v27 = 1000000;
        d27 = null;
        l82 = l72.add(Direction.SOUTHEAST);
        v82 = 1000000;
        d82 = null;
        l0 = l9.add(Direction.SOUTHWEST);
        v0 = 1000000;
        d0 = null;
        l102 = l95.add(Direction.SOUTHEAST);
        v102 = 1000000;
        d102 = null;
        l16 = l28.add(Direction.SOUTHWEST);
        v16 = 1000000;
        d16 = null;
    
        if (rc.onTheMap(l53) && (target.equals(l53) || !rc.canSenseRobotAtLocation(l53))) {
            p53 = 1 + rc.senseRubble(l53) / 10.0;
            if (v53 > v54 + p53) {
                v53 = v54 + p53;
                d53 = Direction.SOUTH;
            }
        }
        if (rc.onTheMap(l43) && (target.equals(l43) || !rc.canSenseRobotAtLocation(l43))) {
            p43 = 1 + rc.senseRubble(l43) / 10.0;
            if (v43 > v54 + p43) {
                v43 = v54 + p43;
                d43 = Direction.WEST;
            }
        }
        if (rc.onTheMap(l65) && (target.equals(l65) || !rc.canSenseRobotAtLocation(l65))) {
            p65 = 1 + rc.senseRubble(l65) / 10.0;
            if (v65 > v54 + p65) {
                v65 = v54 + p65;
                d65 = Direction.EAST;
            }
        }
        if (rc.onTheMap(l64) && (target.equals(l64) || !rc.canSenseRobotAtLocation(l64))) {
            p64 = 1 + rc.senseRubble(l64) / 10.0;
            if (v64 > v54 + p64) {
                v64 = v54 + p64;
                d64 = Direction.SOUTHEAST;
            }
        }
        if (rc.onTheMap(l42) && (target.equals(l42) || !rc.canSenseRobotAtLocation(l42))) {
            p42 = 1 + rc.senseRubble(l42) / 10.0;
            if (v42 > v54 + p42) {
                v42 = v54 + p42;
                d42 = Direction.SOUTHWEST;
            }
        }
        if (rc.onTheMap(l76) && (target.equals(l76) || !rc.canSenseRobotAtLocation(l76))) {
            p76 = 1 + rc.senseRubble(l76) / 10.0;
            if (v76 > v65 + p76) {
                v76 = v65 + p76;
                d76 = d65;
            }
            if (v76 > v64 + p76) {
                v76 = v64 + p76;
                d76 = d64;
            }
        }
        if (rc.onTheMap(l52) && (target.equals(l52) || !rc.canSenseRobotAtLocation(l52))) {
            p52 = 1 + rc.senseRubble(l52) / 10.0;
            if (v52 > v64 + p52) {
                v52 = v64 + p52;
                d52 = d64;
            }
            if (v52 > v53 + p52) {
                v52 = v53 + p52;
                d52 = d53;
            }
            if (v52 > v42 + p52) {
                v52 = v42 + p52;
                d52 = d42;
            }
        }
        if (rc.onTheMap(l32) && (target.equals(l32) || !rc.canSenseRobotAtLocation(l32))) {
            p32 = 1 + rc.senseRubble(l32) / 10.0;
            if (v32 > v43 + p32) {
                v32 = v43 + p32;
                d32 = d43;
            }
            if (v32 > v42 + p32) {
                v32 = v42 + p32;
                d32 = d42;
            }
        }
        if (rc.onTheMap(l75) && (target.equals(l75) || !rc.canSenseRobotAtLocation(l75))) {
            p75 = 1 + rc.senseRubble(l75) / 10.0;
            if (v75 > v76 + p75) {
                v75 = v76 + p75;
                d75 = d76;
            }
            if (v75 > v65 + p75) {
                v75 = v65 + p75;
                d75 = d65;
            }
            if (v75 > v64 + p75) {
                v75 = v64 + p75;
                d75 = d64;
            }
            if (v75 > v63 + p75) {
                v75 = v63 + p75;
                d75 = d63;
            }
        }
        if (rc.onTheMap(l31) && (target.equals(l31) || !rc.canSenseRobotAtLocation(l31))) {
            p31 = 1 + rc.senseRubble(l31) / 10.0;
            if (v31 > v42 + p31) {
                v31 = v42 + p31;
                d31 = d42;
            }
            if (v31 > v43 + p31) {
                v31 = v43 + p31;
                d31 = d43;
            }
            if (v31 > v32 + p31) {
                v31 = v32 + p31;
                d31 = d32;
            }
            if (v31 > v41 + p31) {
                v31 = v41 + p31;
                d31 = d41;
            }
        }
        if (rc.onTheMap(l41) && (target.equals(l41) || !rc.canSenseRobotAtLocation(l41))) {
            p41 = 1 + rc.senseRubble(l41) / 10.0;
            if (v41 > v52 + p41) {
                v41 = v52 + p41;
                d41 = d52;
            }
            if (v41 > v53 + p41) {
                v41 = v53 + p41;
                d41 = d53;
            }
            if (v41 > v42 + p41) {
                v41 = v42 + p41;
                d41 = d42;
            }
            if (v41 > v31 + p41) {
                v41 = v31 + p41;
                d41 = d31;
            }
        }
        if (rc.onTheMap(l63) && (target.equals(l63) || !rc.canSenseRobotAtLocation(l63))) {
            p63 = 1 + rc.senseRubble(l63) / 10.0;
            if (v63 > v75 + p63) {
                v63 = v75 + p63;
                d63 = d75;
            }
            if (v63 > v64 + p63) {
                v63 = v64 + p63;
                d63 = d64;
            }
            if (v63 > v53 + p63) {
                v63 = v53 + p63;
                d63 = d53;
            }
            if (v63 > v52 + p63) {
                v63 = v52 + p63;
                d63 = d52;
            }
        }
        if (rc.onTheMap(l74) && (target.equals(l74) || !rc.canSenseRobotAtLocation(l74))) {
            p74 = 1 + rc.senseRubble(l74) / 10.0;
            if (v74 > v75 + p74) {
                v74 = v75 + p74;
                d74 = d75;
            }
            if (v74 > v64 + p74) {
                v74 = v64 + p74;
                d74 = d64;
            }
            if (v74 > v63 + p74) {
                v74 = v63 + p74;
                d74 = d63;
            }
        }
        if (rc.onTheMap(l30) && (target.equals(l30) || !rc.canSenseRobotAtLocation(l30))) {
            p30 = 1 + rc.senseRubble(l30) / 10.0;
            if (v30 > v41 + p30) {
                v30 = v41 + p30;
                d30 = d41;
            }
            if (v30 > v42 + p30) {
                v30 = v42 + p30;
                d30 = d42;
            }
            if (v30 > v31 + p30) {
                v30 = v31 + p30;
                d30 = d31;
            }
        }
        if (rc.onTheMap(l87) && (target.equals(l87) || !rc.canSenseRobotAtLocation(l87))) {
            p87 = 1 + rc.senseRubble(l87) / 10.0;
            if (v87 > v76 + p87) {
                v87 = v76 + p87;
                d87 = d76;
            }
            if (v87 > v75 + p87) {
                v87 = v75 + p87;
                d87 = d75;
            }
        }
        if (rc.onTheMap(l51) && (target.equals(l51) || !rc.canSenseRobotAtLocation(l51))) {
            p51 = 1 + rc.senseRubble(l51) / 10.0;
            if (v51 > v63 + p51) {
                v51 = v63 + p51;
                d51 = d63;
            }
            if (v51 > v52 + p51) {
                v51 = v52 + p51;
                d51 = d52;
            }
            if (v51 > v41 + p51) {
                v51 = v41 + p51;
                d51 = d41;
            }
        }
        if (rc.onTheMap(l21) && (target.equals(l21) || !rc.canSenseRobotAtLocation(l21))) {
            p21 = 1 + rc.senseRubble(l21) / 10.0;
            if (v21 > v32 + p21) {
                v21 = v32 + p21;
                d21 = d32;
            }
            if (v21 > v31 + p21) {
                v21 = v31 + p21;
                d21 = d31;
            }
        }
        if (rc.onTheMap(l86) && (target.equals(l86) || !rc.canSenseRobotAtLocation(l86))) {
            p86 = 1 + rc.senseRubble(l86) / 10.0;
            if (v86 > v87 + p86) {
                v86 = v87 + p86;
                d86 = d87;
            }
            if (v86 > v76 + p86) {
                v86 = v76 + p86;
                d86 = d76;
            }
            if (v86 > v75 + p86) {
                v86 = v75 + p86;
                d86 = d75;
            }
            if (v86 > v74 + p86) {
                v86 = v74 + p86;
                d86 = d74;
            }
        }
        if (rc.onTheMap(l40) && (target.equals(l40) || !rc.canSenseRobotAtLocation(l40))) {
            p40 = 1 + rc.senseRubble(l40) / 10.0;
            if (v40 > v51 + p40) {
                v40 = v51 + p40;
                d40 = d51;
            }
            if (v40 > v52 + p40) {
                v40 = v52 + p40;
                d40 = d52;
            }
            if (v40 > v41 + p40) {
                v40 = v41 + p40;
                d40 = d41;
            }
            if (v40 > v30 + p40) {
                v40 = v30 + p40;
                d40 = d30;
            }
        }
        if (rc.onTheMap(l20) && (target.equals(l20) || !rc.canSenseRobotAtLocation(l20))) {
            p20 = 1 + rc.senseRubble(l20) / 10.0;
            if (v20 > v31 + p20) {
                v20 = v31 + p20;
                d20 = d31;
            }
            if (v20 > v32 + p20) {
                v20 = v32 + p20;
                d20 = d32;
            }
            if (v20 > v21 + p20) {
                v20 = v21 + p20;
                d20 = d21;
            }
            if (v20 > v30 + p20) {
                v20 = v30 + p20;
                d20 = d30;
            }
        }
        if (rc.onTheMap(l62) && (target.equals(l62) || !rc.canSenseRobotAtLocation(l62))) {
            p62 = 1 + rc.senseRubble(l62) / 10.0;
            if (v62 > v74 + p62) {
                v62 = v74 + p62;
                d62 = d74;
            }
            if (v62 > v63 + p62) {
                v62 = v63 + p62;
                d62 = d63;
            }
            if (v62 > v52 + p62) {
                v62 = v52 + p62;
                d62 = d52;
            }
            if (v62 > v51 + p62) {
                v62 = v51 + p62;
                d62 = d51;
            }
        }
        if (rc.onTheMap(l29) && (target.equals(l29) || !rc.canSenseRobotAtLocation(l29))) {
            p29 = 1 + rc.senseRubble(l29) / 10.0;
            if (v29 > v40 + p29) {
                v29 = v40 + p29;
                d29 = d40;
            }
            if (v29 > v41 + p29) {
                v29 = v41 + p29;
                d29 = d41;
            }
            if (v29 > v30 + p29) {
                v29 = v30 + p29;
                d29 = d30;
            }
            if (v29 > v19 + p29) {
                v29 = v19 + p29;
                d29 = d19;
            }
        }
        if (rc.onTheMap(l85) && (target.equals(l85) || !rc.canSenseRobotAtLocation(l85))) {
            p85 = 1 + rc.senseRubble(l85) / 10.0;
            if (v85 > v86 + p85) {
                v85 = v86 + p85;
                d85 = d86;
            }
            if (v85 > v75 + p85) {
                v85 = v75 + p85;
                d85 = d75;
            }
            if (v85 > v74 + p85) {
                v85 = v74 + p85;
                d85 = d74;
            }
            if (v85 > v73 + p85) {
                v85 = v73 + p85;
                d85 = d73;
            }
        }
        if (rc.onTheMap(l73) && (target.equals(l73) || !rc.canSenseRobotAtLocation(l73))) {
            p73 = 1 + rc.senseRubble(l73) / 10.0;
            if (v73 > v85 + p73) {
                v73 = v85 + p73;
                d73 = d85;
            }
            if (v73 > v74 + p73) {
                v73 = v74 + p73;
                d73 = d74;
            }
            if (v73 > v63 + p73) {
                v73 = v63 + p73;
                d73 = d63;
            }
            if (v73 > v62 + p73) {
                v73 = v62 + p73;
                d73 = d62;
            }
        }
        if (rc.onTheMap(l19) && (target.equals(l19) || !rc.canSenseRobotAtLocation(l19))) {
            p19 = 1 + rc.senseRubble(l19) / 10.0;
            if (v19 > v30 + p19) {
                v19 = v30 + p19;
                d19 = d30;
            }
            if (v19 > v31 + p19) {
                v19 = v31 + p19;
                d19 = d31;
            }
            if (v19 > v20 + p19) {
                v19 = v20 + p19;
                d19 = d20;
            }
            if (v19 > v29 + p19) {
                v19 = v29 + p19;
                d19 = d29;
            }
        }
        if (rc.onTheMap(l18) && (target.equals(l18) || !rc.canSenseRobotAtLocation(l18))) {
            p18 = 1 + rc.senseRubble(l18) / 10.0;
            if (v18 > v29 + p18) {
                v18 = v29 + p18;
                d18 = d29;
            }
            if (v18 > v30 + p18) {
                v18 = v30 + p18;
                d18 = d30;
            }
            if (v18 > v19 + p18) {
                v18 = v19 + p18;
                d18 = d19;
            }
        }
        if (rc.onTheMap(l84) && (target.equals(l84) || !rc.canSenseRobotAtLocation(l84))) {
            p84 = 1 + rc.senseRubble(l84) / 10.0;
            if (v84 > v85 + p84) {
                v84 = v85 + p84;
                d84 = d85;
            }
            if (v84 > v74 + p84) {
                v84 = v74 + p84;
                d84 = d74;
            }
            if (v84 > v73 + p84) {
                v84 = v73 + p84;
                d84 = d73;
            }
        }
        if (rc.onTheMap(l11) && (target.equals(l11) || !rc.canSenseRobotAtLocation(l11))) {
            p11 = 1 + rc.senseRubble(l11) / 10.0;
            if (v11 > v21 + p11) {
                v11 = v21 + p11;
                d11 = d21;
            }
            if (v11 > v20 + p11) {
                v11 = v20 + p11;
                d11 = d20;
            }
        }
        if (rc.onTheMap(l97) && (target.equals(l97) || !rc.canSenseRobotAtLocation(l97))) {
            p97 = 1 + rc.senseRubble(l97) / 10.0;
            if (v97 > v87 + p97) {
                v97 = v87 + p97;
                d97 = d87;
            }
            if (v97 > v86 + p97) {
                v97 = v86 + p97;
                d97 = d86;
            }
        }
        if (rc.onTheMap(l50) && (target.equals(l50) || !rc.canSenseRobotAtLocation(l50))) {
            p50 = 1 + rc.senseRubble(l50) / 10.0;
            if (v50 > v62 + p50) {
                v50 = v62 + p50;
                d50 = d62;
            }
            if (v50 > v51 + p50) {
                v50 = v51 + p50;
                d50 = d51;
            }
            if (v50 > v40 + p50) {
                v50 = v40 + p50;
                d50 = d40;
            }
        }
        if (rc.onTheMap(l10) && (target.equals(l10) || !rc.canSenseRobotAtLocation(l10))) {
            p10 = 1 + rc.senseRubble(l10) / 10.0;
            if (v10 > v20 + p10) {
                v10 = v20 + p10;
                d10 = d20;
            }
            if (v10 > v21 + p10) {
                v10 = v21 + p10;
                d10 = d21;
            }
            if (v10 > v11 + p10) {
                v10 = v11 + p10;
                d10 = d11;
            }
            if (v10 > v19 + p10) {
                v10 = v19 + p10;
                d10 = d19;
            }
        }
        if (rc.onTheMap(l61) && (target.equals(l61) || !rc.canSenseRobotAtLocation(l61))) {
            p61 = 1 + rc.senseRubble(l61) / 10.0;
            if (v61 > v73 + p61) {
                v61 = v73 + p61;
                d61 = d73;
            }
            if (v61 > v62 + p61) {
                v61 = v62 + p61;
                d61 = d62;
            }
            if (v61 > v51 + p61) {
                v61 = v51 + p61;
                d61 = d51;
            }
            if (v61 > v50 + p61) {
                v61 = v50 + p61;
                d61 = d50;
            }
        }
        if (rc.onTheMap(l96) && (target.equals(l96) || !rc.canSenseRobotAtLocation(l96))) {
            p96 = 1 + rc.senseRubble(l96) / 10.0;
            if (v96 > v97 + p96) {
                v96 = v97 + p96;
                d96 = d97;
            }
            if (v96 > v87 + p96) {
                v96 = v87 + p96;
                d96 = d87;
            }
            if (v96 > v86 + p96) {
                v96 = v86 + p96;
                d96 = d86;
            }
            if (v96 > v85 + p96) {
                v96 = v85 + p96;
                d96 = d85;
            }
        }
        if (rc.onTheMap(l39) && (target.equals(l39) || !rc.canSenseRobotAtLocation(l39))) {
            p39 = 1 + rc.senseRubble(l39) / 10.0;
            if (v39 > v50 + p39) {
                v39 = v50 + p39;
                d39 = d50;
            }
            if (v39 > v51 + p39) {
                v39 = v51 + p39;
                d39 = d51;
            }
            if (v39 > v40 + p39) {
                v39 = v40 + p39;
                d39 = d40;
            }
            if (v39 > v29 + p39) {
                v39 = v29 + p39;
                d39 = d29;
            }
        }
        if (rc.onTheMap(l72) && (target.equals(l72) || !rc.canSenseRobotAtLocation(l72))) {
            p72 = 1 + rc.senseRubble(l72) / 10.0;
            if (v72 > v84 + p72) {
                v72 = v84 + p72;
                d72 = d84;
            }
            if (v72 > v73 + p72) {
                v72 = v73 + p72;
                d72 = d73;
            }
            if (v72 > v62 + p72) {
                v72 = v62 + p72;
                d72 = d62;
            }
            if (v72 > v61 + p72) {
                v72 = v61 + p72;
                d72 = d61;
            }
        }
        if (rc.onTheMap(l9) && (target.equals(l9) || !rc.canSenseRobotAtLocation(l9))) {
            p9 = 1 + rc.senseRubble(l9) / 10.0;
            if (v9 > v19 + p9) {
                v9 = v19 + p9;
                d9 = d19;
            }
            if (v9 > v20 + p9) {
                v9 = v20 + p9;
                d9 = d20;
            }
            if (v9 > v10 + p9) {
                v9 = v10 + p9;
                d9 = d10;
            }
            if (v9 > v18 + p9) {
                v9 = v18 + p9;
                d9 = d18;
            }
        }
        if (rc.onTheMap(l95) && (target.equals(l95) || !rc.canSenseRobotAtLocation(l95))) {
            p95 = 1 + rc.senseRubble(l95) / 10.0;
            if (v95 > v96 + p95) {
                v95 = v96 + p95;
                d95 = d96;
            }
            if (v95 > v86 + p95) {
                v95 = v86 + p95;
                d95 = d86;
            }
            if (v95 > v85 + p95) {
                v95 = v85 + p95;
                d95 = d85;
            }
            if (v95 > v84 + p95) {
                v95 = v84 + p95;
                d95 = d84;
            }
        }
        if (rc.onTheMap(l28) && (target.equals(l28) || !rc.canSenseRobotAtLocation(l28))) {
            p28 = 1 + rc.senseRubble(l28) / 10.0;
            if (v28 > v39 + p28) {
                v28 = v39 + p28;
                d28 = d39;
            }
            if (v28 > v40 + p28) {
                v28 = v40 + p28;
                d28 = d40;
            }
            if (v28 > v29 + p28) {
                v28 = v29 + p28;
                d28 = d29;
            }
            if (v28 > v18 + p28) {
                v28 = v18 + p28;
                d28 = d18;
            }
        }
        if (rc.onTheMap(l8) && (target.equals(l8) || !rc.canSenseRobotAtLocation(l8))) {
            p8 = 1 + rc.senseRubble(l8) / 10.0;
            if (v8 > v18 + p8) {
                v8 = v18 + p8;
                d8 = d18;
            }
            if (v8 > v19 + p8) {
                v8 = v19 + p8;
                d8 = d19;
            }
            if (v8 > v9 + p8) {
                v8 = v9 + p8;
                d8 = d9;
            }
            if (v8 > v17 + p8) {
                v8 = v17 + p8;
                d8 = d17;
            }
        }
        if (rc.onTheMap(l83) && (target.equals(l83) || !rc.canSenseRobotAtLocation(l83))) {
            p83 = 1 + rc.senseRubble(l83) / 10.0;
            if (v83 > v94 + p83) {
                v83 = v94 + p83;
                d83 = d94;
            }
            if (v83 > v84 + p83) {
                v83 = v84 + p83;
                d83 = d84;
            }
            if (v83 > v73 + p83) {
                v83 = v73 + p83;
                d83 = d73;
            }
            if (v83 > v72 + p83) {
                v83 = v72 + p83;
                d83 = d72;
            }
        }
        if (rc.onTheMap(l94) && (target.equals(l94) || !rc.canSenseRobotAtLocation(l94))) {
            p94 = 1 + rc.senseRubble(l94) / 10.0;
            if (v94 > v95 + p94) {
                v94 = v95 + p94;
                d94 = d95;
            }
            if (v94 > v85 + p94) {
                v94 = v85 + p94;
                d94 = d85;
            }
            if (v94 > v84 + p94) {
                v94 = v84 + p94;
                d94 = d84;
            }
            if (v94 > v83 + p94) {
                v94 = v83 + p94;
                d94 = d83;
            }
        }
        if (rc.onTheMap(l17) && (target.equals(l17) || !rc.canSenseRobotAtLocation(l17))) {
            p17 = 1 + rc.senseRubble(l17) / 10.0;
            if (v17 > v28 + p17) {
                v17 = v28 + p17;
                d17 = d28;
            }
            if (v17 > v29 + p17) {
                v17 = v29 + p17;
                d17 = d29;
            }
            if (v17 > v18 + p17) {
                v17 = v18 + p17;
                d17 = d18;
            }
            if (v17 > v8 + p17) {
                v17 = v8 + p17;
                d17 = d8;
            }
        }
        if (rc.onTheMap(l7) && (target.equals(l7) || !rc.canSenseRobotAtLocation(l7))) {
            p7 = 1 + rc.senseRubble(l7) / 10.0;
            if (v7 > v17 + p7) {
                v7 = v17 + p7;
                d7 = d17;
            }
            if (v7 > v18 + p7) {
                v7 = v18 + p7;
                d7 = d18;
            }
            if (v7 > v8 + p7) {
                v7 = v8 + p7;
                d7 = d8;
            }
        }
        if (rc.onTheMap(l93) && (target.equals(l93) || !rc.canSenseRobotAtLocation(l93))) {
            p93 = 1 + rc.senseRubble(l93) / 10.0;
            if (v93 > v94 + p93) {
                v93 = v94 + p93;
                d93 = d94;
            }
            if (v93 > v84 + p93) {
                v93 = v84 + p93;
                d93 = d84;
            }
            if (v93 > v83 + p93) {
                v93 = v83 + p93;
                d93 = d83;
            }
        }
        if (rc.onTheMap(l3) && (target.equals(l3) || !rc.canSenseRobotAtLocation(l3))) {
            p3 = 1 + rc.senseRubble(l3) / 10.0;
            if (v3 > v11 + p3) {
                v3 = v11 + p3;
                d3 = d11;
            }
            if (v3 > v10 + p3) {
                v3 = v10 + p3;
                d3 = d10;
            }
        }
        if (rc.onTheMap(l105) && (target.equals(l105) || !rc.canSenseRobotAtLocation(l105))) {
            p105 = 1 + rc.senseRubble(l105) / 10.0;
            if (v105 > v97 + p105) {
                v105 = v97 + p105;
                d105 = d97;
            }
            if (v105 > v96 + p105) {
                v105 = v96 + p105;
                d105 = d96;
            }
        }
        if (rc.onTheMap(l49) && (target.equals(l49) || !rc.canSenseRobotAtLocation(l49))) {
            p49 = 1 + rc.senseRubble(l49) / 10.0;
            if (v49 > v61 + p49) {
                v49 = v61 + p49;
                d49 = d61;
            }
            if (v49 > v50 + p49) {
                v49 = v50 + p49;
                d49 = d50;
            }
            if (v49 > v39 + p49) {
                v49 = v39 + p49;
                d49 = d39;
            }
        }
        if (rc.onTheMap(l60) && (target.equals(l60) || !rc.canSenseRobotAtLocation(l60))) {
            p60 = 1 + rc.senseRubble(l60) / 10.0;
            if (v60 > v72 + p60) {
                v60 = v72 + p60;
                d60 = d72;
            }
            if (v60 > v61 + p60) {
                v60 = v61 + p60;
                d60 = d61;
            }
            if (v60 > v50 + p60) {
                v60 = v50 + p60;
                d60 = d50;
            }
            if (v60 > v49 + p60) {
                v60 = v49 + p60;
                d60 = d49;
            }
        }
        if (rc.onTheMap(l104) && (target.equals(l104) || !rc.canSenseRobotAtLocation(l104))) {
            p104 = 1 + rc.senseRubble(l104) / 10.0;
            if (v104 > v105 + p104) {
                v104 = v105 + p104;
                d104 = d105;
            }
            if (v104 > v97 + p104) {
                v104 = v97 + p104;
                d104 = d97;
            }
            if (v104 > v96 + p104) {
                v104 = v96 + p104;
                d104 = d96;
            }
            if (v104 > v95 + p104) {
                v104 = v95 + p104;
                d104 = d95;
            }
        }
        if (rc.onTheMap(l2) && (target.equals(l2) || !rc.canSenseRobotAtLocation(l2))) {
            p2 = 1 + rc.senseRubble(l2) / 10.0;
            if (v2 > v10 + p2) {
                v2 = v10 + p2;
                d2 = d10;
            }
            if (v2 > v11 + p2) {
                v2 = v11 + p2;
                d2 = d11;
            }
            if (v2 > v3 + p2) {
                v2 = v3 + p2;
                d2 = d3;
            }
            if (v2 > v9 + p2) {
                v2 = v9 + p2;
                d2 = d9;
            }
        }
        if (rc.onTheMap(l38) && (target.equals(l38) || !rc.canSenseRobotAtLocation(l38))) {
            p38 = 1 + rc.senseRubble(l38) / 10.0;
            if (v38 > v49 + p38) {
                v38 = v49 + p38;
                d38 = d49;
            }
            if (v38 > v50 + p38) {
                v38 = v50 + p38;
                d38 = d50;
            }
            if (v38 > v39 + p38) {
                v38 = v39 + p38;
                d38 = d39;
            }
            if (v38 > v28 + p38) {
                v38 = v28 + p38;
                d38 = d28;
            }
        }
        if (rc.onTheMap(l71) && (target.equals(l71) || !rc.canSenseRobotAtLocation(l71))) {
            p71 = 1 + rc.senseRubble(l71) / 10.0;
            if (v71 > v83 + p71) {
                v71 = v83 + p71;
                d71 = d83;
            }
            if (v71 > v72 + p71) {
                v71 = v72 + p71;
                d71 = d72;
            }
            if (v71 > v61 + p71) {
                v71 = v61 + p71;
                d71 = d61;
            }
            if (v71 > v60 + p71) {
                v71 = v60 + p71;
                d71 = d60;
            }
        }
        if (rc.onTheMap(l103) && (target.equals(l103) || !rc.canSenseRobotAtLocation(l103))) {
            p103 = 1 + rc.senseRubble(l103) / 10.0;
            if (v103 > v104 + p103) {
                v103 = v104 + p103;
                d103 = d104;
            }
            if (v103 > v96 + p103) {
                v103 = v96 + p103;
                d103 = d96;
            }
            if (v103 > v95 + p103) {
                v103 = v95 + p103;
                d103 = d95;
            }
            if (v103 > v94 + p103) {
                v103 = v94 + p103;
                d103 = d94;
            }
        }
        if (rc.onTheMap(l1) && (target.equals(l1) || !rc.canSenseRobotAtLocation(l1))) {
            p1 = 1 + rc.senseRubble(l1) / 10.0;
            if (v1 > v9 + p1) {
                v1 = v9 + p1;
                d1 = d9;
            }
            if (v1 > v10 + p1) {
                v1 = v10 + p1;
                d1 = d10;
            }
            if (v1 > v2 + p1) {
                v1 = v2 + p1;
                d1 = d2;
            }
            if (v1 > v8 + p1) {
                v1 = v8 + p1;
                d1 = d8;
            }
        }
        if (rc.onTheMap(l27) && (target.equals(l27) || !rc.canSenseRobotAtLocation(l27))) {
            p27 = 1 + rc.senseRubble(l27) / 10.0;
            if (v27 > v38 + p27) {
                v27 = v38 + p27;
                d27 = d38;
            }
            if (v27 > v39 + p27) {
                v27 = v39 + p27;
                d27 = d39;
            }
            if (v27 > v28 + p27) {
                v27 = v28 + p27;
                d27 = d28;
            }
            if (v27 > v17 + p27) {
                v27 = v17 + p27;
                d27 = d17;
            }
        }
        if (rc.onTheMap(l82) && (target.equals(l82) || !rc.canSenseRobotAtLocation(l82))) {
            p82 = 1 + rc.senseRubble(l82) / 10.0;
            if (v82 > v93 + p82) {
                v82 = v93 + p82;
                d82 = d93;
            }
            if (v82 > v83 + p82) {
                v82 = v83 + p82;
                d82 = d83;
            }
            if (v82 > v72 + p82) {
                v82 = v72 + p82;
                d82 = d72;
            }
            if (v82 > v71 + p82) {
                v82 = v71 + p82;
                d82 = d71;
            }
        }
        if (rc.onTheMap(l16) && (target.equals(l16) || !rc.canSenseRobotAtLocation(l16))) {
            p16 = 1 + rc.senseRubble(l16) / 10.0;
            if (v16 > v27 + p16) {
                v16 = v27 + p16;
                d16 = d27;
            }
            if (v16 > v28 + p16) {
                v16 = v28 + p16;
                d16 = d28;
            }
            if (v16 > v17 + p16) {
                v16 = v17 + p16;
                d16 = d17;
            }
            if (v16 > v7 + p16) {
                v16 = v7 + p16;
                d16 = d7;
            }
        }
        if (rc.onTheMap(l0) && (target.equals(l0) || !rc.canSenseRobotAtLocation(l0))) {
            p0 = 1 + rc.senseRubble(l0) / 10.0;
            if (v0 > v8 + p0) {
                v0 = v8 + p0;
                d0 = d8;
            }
            if (v0 > v9 + p0) {
                v0 = v9 + p0;
                d0 = d9;
            }
            if (v0 > v1 + p0) {
                v0 = v1 + p0;
                d0 = d1;
            }
            if (v0 > v7 + p0) {
                v0 = v7 + p0;
                d0 = d7;
            }
        }
        if (rc.onTheMap(l102) && (target.equals(l102) || !rc.canSenseRobotAtLocation(l102))) {
            p102 = 1 + rc.senseRubble(l102) / 10.0;
            if (v102 > v103 + p102) {
                v102 = v103 + p102;
                d102 = d103;
            }
            if (v102 > v95 + p102) {
                v102 = v95 + p102;
                d102 = d95;
            }
            if (v102 > v94 + p102) {
                v102 = v94 + p102;
                d102 = d94;
            }
            if (v102 > v93 + p102) {
                v102 = v93 + p102;
                d102 = d93;
            }
        }
    
        int dx = target.x - l54.x;
        int dy = target.y - l54.y;

        switch(dx) {
        case -5:
            switch(dy) {
                case -3:
                    return d0;
                case -2:
                    return d1;
                case -1:
                    return d2;
                case 0:
                    return d3;
            }
            break;
        case -4:
            switch(dy) {
                case -4:
                    return d7;
                case -3:
                    return d8;
                case -2:
                    return d9;
                case -1:
                    return d10;
                case 0:
                    return d11;
            }
            break;
        case -3:
            switch(dy) {
                case -5:
                    return d16;
                case -4:
                    return d17;
                case -3:
                    return d18;
                case -2:
                    return d19;
                case -1:
                    return d20;
                case 0:
                    return d21;
            }
            break;
        case -2:
            switch(dy) {
                case -5:
                    return d27;
                case -4:
                    return d28;
                case -3:
                    return d29;
                case -2:
                    return d30;
                case -1:
                    return d31;
                case 0:
                    return d32;
            }
            break;
        case -1:
            switch(dy) {
                case -5:
                    return d38;
                case -4:
                    return d39;
                case -3:
                    return d40;
                case -2:
                    return d41;
                case -1:
                    return d42;
                case 0:
                    return d43;
            }
            break;
        case 0:
            switch(dy) {
                case -5:
                    return d49;
                case -4:
                    return d50;
                case -3:
                    return d51;
                case -2:
                    return d52;
                case -1:
                    return d53;
                case 0:
                    return d54;
            }
            break;
        case 1:
            switch(dy) {
                case -5:
                    return d60;
                case -4:
                    return d61;
                case -3:
                    return d62;
                case -2:
                    return d63;
                case -1:
                    return d64;
                case 0:
                    return d65;
            }
            break;
        case 2:
            switch(dy) {
                case -5:
                    return d71;
                case -4:
                    return d72;
                case -3:
                    return d73;
                case -2:
                    return d74;
                case -1:
                    return d75;
                case 0:
                    return d76;
            }
            break;
        case 3:
            switch(dy) {
                case -5:
                    return d82;
                case -4:
                    return d83;
                case -3:
                    return d84;
                case -2:
                    return d85;
                case -1:
                    return d86;
                case 0:
                    return d87;
            }
            break;
        case 4:
            switch(dy) {
                case -4:
                    return d93;
                case -3:
                    return d94;
                case -2:
                    return d95;
                case -1:
                    return d96;
                case 0:
                    return d97;
            }
            break;
        case 5:
            switch(dy) {
                case -3:
                    return d102;
                case -2:
                    return d103;
                case -1:
                    return d104;
                case 0:
                    return d105;
            }
            break;
        }
    
        Direction ans = null;
        double bestEstimation = 0;
        double initialDist = Math.sqrt(l54.distanceSquaredTo(target));
        
        double dist0 = (initialDist - Math.sqrt(l0.distanceSquaredTo(target))) / v0;
        if (dist0 > bestEstimation) {
            bestEstimation = dist0;
            ans = d0;
        }
        double dist1 = (initialDist - Math.sqrt(l1.distanceSquaredTo(target))) / v1;
        if (dist1 > bestEstimation) {
            bestEstimation = dist1;
            ans = d1;
        }
        double dist2 = (initialDist - Math.sqrt(l2.distanceSquaredTo(target))) / v2;
        if (dist2 > bestEstimation) {
            bestEstimation = dist2;
            ans = d2;
        }
        double dist3 = (initialDist - Math.sqrt(l3.distanceSquaredTo(target))) / v3;
        if (dist3 > bestEstimation) {
            bestEstimation = dist3;
            ans = d3;
        }
        double dist7 = (initialDist - Math.sqrt(l7.distanceSquaredTo(target))) / v7;
        if (dist7 > bestEstimation) {
            bestEstimation = dist7;
            ans = d7;
        }
        double dist8 = (initialDist - Math.sqrt(l8.distanceSquaredTo(target))) / v8;
        if (dist8 > bestEstimation) {
            bestEstimation = dist8;
            ans = d8;
        }
        double dist9 = (initialDist - Math.sqrt(l9.distanceSquaredTo(target))) / v9;
        if (dist9 > bestEstimation) {
            bestEstimation = dist9;
            ans = d9;
        }
        double dist10 = (initialDist - Math.sqrt(l10.distanceSquaredTo(target))) / v10;
        if (dist10 > bestEstimation) {
            bestEstimation = dist10;
            ans = d10;
        }
        double dist11 = (initialDist - Math.sqrt(l11.distanceSquaredTo(target))) / v11;
        if (dist11 > bestEstimation) {
            bestEstimation = dist11;
            ans = d11;
        }
        double dist16 = (initialDist - Math.sqrt(l16.distanceSquaredTo(target))) / v16;
        if (dist16 > bestEstimation) {
            bestEstimation = dist16;
            ans = d16;
        }
        double dist17 = (initialDist - Math.sqrt(l17.distanceSquaredTo(target))) / v17;
        if (dist17 > bestEstimation) {
            bestEstimation = dist17;
            ans = d17;
        }
        double dist18 = (initialDist - Math.sqrt(l18.distanceSquaredTo(target))) / v18;
        if (dist18 > bestEstimation) {
            bestEstimation = dist18;
            ans = d18;
        }
        double dist19 = (initialDist - Math.sqrt(l19.distanceSquaredTo(target))) / v19;
        if (dist19 > bestEstimation) {
            bestEstimation = dist19;
            ans = d19;
        }
        double dist20 = (initialDist - Math.sqrt(l20.distanceSquaredTo(target))) / v20;
        if (dist20 > bestEstimation) {
            bestEstimation = dist20;
            ans = d20;
        }
        double dist21 = (initialDist - Math.sqrt(l21.distanceSquaredTo(target))) / v21;
        if (dist21 > bestEstimation) {
            bestEstimation = dist21;
            ans = d21;
        }
        double dist27 = (initialDist - Math.sqrt(l27.distanceSquaredTo(target))) / v27;
        if (dist27 > bestEstimation) {
            bestEstimation = dist27;
            ans = d27;
        }
        double dist28 = (initialDist - Math.sqrt(l28.distanceSquaredTo(target))) / v28;
        if (dist28 > bestEstimation) {
            bestEstimation = dist28;
            ans = d28;
        }
        double dist29 = (initialDist - Math.sqrt(l29.distanceSquaredTo(target))) / v29;
        if (dist29 > bestEstimation) {
            bestEstimation = dist29;
            ans = d29;
        }
        double dist30 = (initialDist - Math.sqrt(l30.distanceSquaredTo(target))) / v30;
        if (dist30 > bestEstimation) {
            bestEstimation = dist30;
            ans = d30;
        }
        double dist31 = (initialDist - Math.sqrt(l31.distanceSquaredTo(target))) / v31;
        if (dist31 > bestEstimation) {
            bestEstimation = dist31;
            ans = d31;
        }
        double dist32 = (initialDist - Math.sqrt(l32.distanceSquaredTo(target))) / v32;
        if (dist32 > bestEstimation) {
            bestEstimation = dist32;
            ans = d32;
        }
        double dist38 = (initialDist - Math.sqrt(l38.distanceSquaredTo(target))) / v38;
        if (dist38 > bestEstimation) {
            bestEstimation = dist38;
            ans = d38;
        }
        double dist39 = (initialDist - Math.sqrt(l39.distanceSquaredTo(target))) / v39;
        if (dist39 > bestEstimation) {
            bestEstimation = dist39;
            ans = d39;
        }
        double dist40 = (initialDist - Math.sqrt(l40.distanceSquaredTo(target))) / v40;
        if (dist40 > bestEstimation) {
            bestEstimation = dist40;
            ans = d40;
        }
        double dist41 = (initialDist - Math.sqrt(l41.distanceSquaredTo(target))) / v41;
        if (dist41 > bestEstimation) {
            bestEstimation = dist41;
            ans = d41;
        }
        double dist42 = (initialDist - Math.sqrt(l42.distanceSquaredTo(target))) / v42;
        if (dist42 > bestEstimation) {
            bestEstimation = dist42;
            ans = d42;
        }
        double dist43 = (initialDist - Math.sqrt(l43.distanceSquaredTo(target))) / v43;
        if (dist43 > bestEstimation) {
            bestEstimation = dist43;
            ans = d43;
        }
        double dist49 = (initialDist - Math.sqrt(l49.distanceSquaredTo(target))) / v49;
        if (dist49 > bestEstimation) {
            bestEstimation = dist49;
            ans = d49;
        }
        double dist50 = (initialDist - Math.sqrt(l50.distanceSquaredTo(target))) / v50;
        if (dist50 > bestEstimation) {
            bestEstimation = dist50;
            ans = d50;
        }
        double dist51 = (initialDist - Math.sqrt(l51.distanceSquaredTo(target))) / v51;
        if (dist51 > bestEstimation) {
            bestEstimation = dist51;
            ans = d51;
        }
        double dist52 = (initialDist - Math.sqrt(l52.distanceSquaredTo(target))) / v52;
        if (dist52 > bestEstimation) {
            bestEstimation = dist52;
            ans = d52;
        }
        double dist53 = (initialDist - Math.sqrt(l53.distanceSquaredTo(target))) / v53;
        if (dist53 > bestEstimation) {
            bestEstimation = dist53;
            ans = d53;
        }
        double dist54 = (initialDist - Math.sqrt(l54.distanceSquaredTo(target))) / v54;
        if (dist54 > bestEstimation) {
            bestEstimation = dist54;
            ans = d54;
        }
        double dist60 = (initialDist - Math.sqrt(l60.distanceSquaredTo(target))) / v60;
        if (dist60 > bestEstimation) {
            bestEstimation = dist60;
            ans = d60;
        }
        double dist61 = (initialDist - Math.sqrt(l61.distanceSquaredTo(target))) / v61;
        if (dist61 > bestEstimation) {
            bestEstimation = dist61;
            ans = d61;
        }
        double dist62 = (initialDist - Math.sqrt(l62.distanceSquaredTo(target))) / v62;
        if (dist62 > bestEstimation) {
            bestEstimation = dist62;
            ans = d62;
        }
        double dist63 = (initialDist - Math.sqrt(l63.distanceSquaredTo(target))) / v63;
        if (dist63 > bestEstimation) {
            bestEstimation = dist63;
            ans = d63;
        }
        double dist64 = (initialDist - Math.sqrt(l64.distanceSquaredTo(target))) / v64;
        if (dist64 > bestEstimation) {
            bestEstimation = dist64;
            ans = d64;
        }
        double dist65 = (initialDist - Math.sqrt(l65.distanceSquaredTo(target))) / v65;
        if (dist65 > bestEstimation) {
            bestEstimation = dist65;
            ans = d65;
        }
        double dist71 = (initialDist - Math.sqrt(l71.distanceSquaredTo(target))) / v71;
        if (dist71 > bestEstimation) {
            bestEstimation = dist71;
            ans = d71;
        }
        double dist72 = (initialDist - Math.sqrt(l72.distanceSquaredTo(target))) / v72;
        if (dist72 > bestEstimation) {
            bestEstimation = dist72;
            ans = d72;
        }
        double dist73 = (initialDist - Math.sqrt(l73.distanceSquaredTo(target))) / v73;
        if (dist73 > bestEstimation) {
            bestEstimation = dist73;
            ans = d73;
        }
        double dist74 = (initialDist - Math.sqrt(l74.distanceSquaredTo(target))) / v74;
        if (dist74 > bestEstimation) {
            bestEstimation = dist74;
            ans = d74;
        }
        double dist75 = (initialDist - Math.sqrt(l75.distanceSquaredTo(target))) / v75;
        if (dist75 > bestEstimation) {
            bestEstimation = dist75;
            ans = d75;
        }
        double dist76 = (initialDist - Math.sqrt(l76.distanceSquaredTo(target))) / v76;
        if (dist76 > bestEstimation) {
            bestEstimation = dist76;
            ans = d76;
        }
        double dist82 = (initialDist - Math.sqrt(l82.distanceSquaredTo(target))) / v82;
        if (dist82 > bestEstimation) {
            bestEstimation = dist82;
            ans = d82;
        }
        double dist83 = (initialDist - Math.sqrt(l83.distanceSquaredTo(target))) / v83;
        if (dist83 > bestEstimation) {
            bestEstimation = dist83;
            ans = d83;
        }
        double dist84 = (initialDist - Math.sqrt(l84.distanceSquaredTo(target))) / v84;
        if (dist84 > bestEstimation) {
            bestEstimation = dist84;
            ans = d84;
        }
        double dist85 = (initialDist - Math.sqrt(l85.distanceSquaredTo(target))) / v85;
        if (dist85 > bestEstimation) {
            bestEstimation = dist85;
            ans = d85;
        }
        double dist86 = (initialDist - Math.sqrt(l86.distanceSquaredTo(target))) / v86;
        if (dist86 > bestEstimation) {
            bestEstimation = dist86;
            ans = d86;
        }
        double dist87 = (initialDist - Math.sqrt(l87.distanceSquaredTo(target))) / v87;
        if (dist87 > bestEstimation) {
            bestEstimation = dist87;
            ans = d87;
        }
        double dist93 = (initialDist - Math.sqrt(l93.distanceSquaredTo(target))) / v93;
        if (dist93 > bestEstimation) {
            bestEstimation = dist93;
            ans = d93;
        }
        double dist94 = (initialDist - Math.sqrt(l94.distanceSquaredTo(target))) / v94;
        if (dist94 > bestEstimation) {
            bestEstimation = dist94;
            ans = d94;
        }
        double dist95 = (initialDist - Math.sqrt(l95.distanceSquaredTo(target))) / v95;
        if (dist95 > bestEstimation) {
            bestEstimation = dist95;
            ans = d95;
        }
        double dist96 = (initialDist - Math.sqrt(l96.distanceSquaredTo(target))) / v96;
        if (dist96 > bestEstimation) {
            bestEstimation = dist96;
            ans = d96;
        }
        double dist97 = (initialDist - Math.sqrt(l97.distanceSquaredTo(target))) / v97;
        if (dist97 > bestEstimation) {
            bestEstimation = dist97;
            ans = d97;
        }
        double dist102 = (initialDist - Math.sqrt(l102.distanceSquaredTo(target))) / v102;
        if (dist102 > bestEstimation) {
            bestEstimation = dist102;
            ans = d102;
        }
        double dist103 = (initialDist - Math.sqrt(l103.distanceSquaredTo(target))) / v103;
        if (dist103 > bestEstimation) {
            bestEstimation = dist103;
            ans = d103;
        }
        double dist104 = (initialDist - Math.sqrt(l104.distanceSquaredTo(target))) / v104;
        if (dist104 > bestEstimation) {
            bestEstimation = dist104;
            ans = d104;
        }
        double dist105 = (initialDist - Math.sqrt(l105.distanceSquaredTo(target))) / v105;
        if (dist105 > bestEstimation) {
            bestEstimation = dist105;
            ans = d105;
        }
        return ans;
    }
}