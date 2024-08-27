package com.shpp.p2p.cs.tsluzhynska.assignment1;

import com.shpp.karel.KarelTheRobot;

public class SuperKarel extends KarelTheRobot {

    /*
     * Prerequisite: missing. Karel can turn at any time
     * Result: Karel turned 180°
     */
    public void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /*
     * Prerequisite: missing. Karel can turn at any time
     * Result: Karel turned 90° clockwise
     */
    public void turnRight() throws Exception {
        for (byte i = 0; i < 3; i++) {
            turnLeft();
        }
    }

    /*
     * Prerequisite: missing. Karel can do it whenever he wants
     * Result: the cell on which Karel is standing is filled with one beeper
     */
    public void fillTheCellByBeeper() throws Exception {
        if (noBeepersPresent()) {
            putBeeper();
        }
    }
}
