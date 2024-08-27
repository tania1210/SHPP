package com.shpp.p2p.cs.tsluzhynska.assignment1;

public class Assignment1Part3 extends SuperKarel {

    public void run() throws Exception {
        if (frontIsClear()) {
            fillInnerLineWithBeeper();
            findCenter();
        }
        //put last beeper at the center
        putBeeper();
    }

    /*
     * Prerequisite: Karel stands at the edge of row
     * Result: All row filled by beeper except for the first and last cell
     */
    private void fillInnerLineWithBeeper() throws Exception {
        move();
        if (frontIsClear()) {
            fillTheCellByBeeper();
            fillInnerLineWithBeeper();
        }
    }

    /*
     * Prerequisite: a line of beepers behind Karel (the cell where Karel stands is empty)
     * Result: He put beeper at the center of row
     */
    private void findCenter() throws Exception {
        returnAtEdgeOfBeeperLine();
        if (beepersPresent()) {
            pickBeeper();

            move();
            moveToTheEndOfBeeperLine();
            findCenter();
        }
    }

    /*
     * Prerequisite: Karel stands on empty cell. Behind him is the edge of line of beepers
     * Result: Karel turned around and stood on the edge of line of beepers
     */
    private void returnAtEdgeOfBeeperLine() throws Exception {
        turnAround();
        move();
    }

    /*
     * Prerequisite: He stands on the line of beepers
     * Result: Karel moves along this line and stop on the first cell without beeper
     */
    private void moveToTheEndOfBeeperLine() throws Exception {
        while (beepersPresent()) {
            move();
        }
    }
}
