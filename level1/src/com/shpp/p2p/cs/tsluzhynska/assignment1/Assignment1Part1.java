package com.shpp.p2p.cs.tsluzhynska.assignment1;

public class Assignment1Part1 extends SuperKarel {

    public void run() throws Exception {
        goToTheNewspaper();
        pickNewspaper();
        goBackToOrigin();
    }

    /*
     * Prerequisite: Karel is at the starting point
     * (in the northwest corner and turned forward towards the exit)
     * Result: Karel stands on the newspaper (beeper), (at the same cell as the beeper)
     */
    private void goToTheNewspaper() throws Exception {
        findTheDoor();
        findNewspaper();
    }

    /*
     * Prerequisite: Karel still stands at the starting point
     * Result: Karel is before the entrance to the house
     */
    private void findTheDoor() throws Exception {
        moveUntilBlock();
        turnRight();

        while (leftIsBlocked()) {
            move();
        }
        turnLeft();
    }

    /*
     * Prerequisite: Karel is before the entrance to the house
     * Result: Karel stands on the newspaper
     */
    private void findNewspaper() throws Exception {
        while (noBeepersPresent()) {
            move();
        }
    }

    /*
     * Prerequisite: Karel stands on the newspaper (beeper)
     * Result: Karel picked the newspaper
     */
    private void pickNewspaper() throws Exception {
        pickBeeper();
    }

    /*
     * Prerequisite: Karel stands at the point the newspaper was (turned back to house)
     * Result: Karel returns back to origin (at the starting point)
     */
    private void goBackToOrigin() throws Exception {
        turnAround();
        moveUntilBlock();
        turnRight();
        moveUntilBlock();
    }

    /*
     * Prerequisite: there are any blocks front of Karel
     * Result: Karel goes in straight line and stop when there is a block front of him
     */
    private void moveUntilBlock() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }


}

