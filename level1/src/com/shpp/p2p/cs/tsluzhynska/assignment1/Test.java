package com.shpp.p2p.cs.tsluzhynska.assignment1;

public class Test extends SuperKarel {

    public void run() throws Exception {
        fillFirstColumn();
        fillOtherColumnsIfExists();
    }

    /*
     * Prerequisite: Karel should stand at starting cell and look at the east
     * Result: Karel filled the first column
     */
    private void fillFirstColumn() throws Exception {
        turnLeft();
        fillColumn();
        turnAround();
        checkIfNextColumnExists();
    }

    /*
     * Prerequisite: for using this method, Karel should stand at the last column he filled and turn to the south
     * Result: Karel will check if the next column exists, bypass the walls, switch to next column, and fill it.
     * Final position: He is standing on a filled column with a block in front of him.
     */
    private void fillOtherColumnsIfExists() throws Exception {
        while (leftIsClear()) {
            goToNext();
            standOnFirstCell();
            fillColumn();

            turnAround();
            checkIfNextColumnExists();
        }
    }

    /*
     * Prerequisite: Karel stands in the first cell(floor) of the column and look along this column
     * Result: Karel filled the column with one beeper in each cell
     */
    private void fillColumn() throws Exception {
        fillTheCellByBeeper();
        while (frontIsClear()) {
            move();
            fillTheCellByBeeper();
        }
    }

    /*
     * Prerequisite: Karel stands in the last cell(ceiling) of the column and look along this column
     * Result: Karel have found new column, or he just stands in the southeast corner
     */
    private void checkIfNextColumnExists() throws Exception {
        if (leftIsBlocked()) {
            if (frontIsClear()) {
                move();
                checkIfNextColumnExists();
            }
        }
    }

    /*
     * Prerequisite: if Karel found new column (he must stand on the current column and on the left hand side is clear)
     * if necessary, he will bypass the walls on the way
     * Result: Karel stands on the new column
     */
    private void goToNext() throws Exception {
        turnLeft();
        for (byte i = 0; i < 4; i++) {
            if (frontIsBlocked()) {
                turnRight();
                goAroundWall();
                turnLeft();
            }
            move();
        }
    }

    /*
     * Prerequisite: While Karel move to next column, he found a wall. This method helps him bypass it.
     * Result: Karel bypass walls and continue on his way
     */
    private void goAroundWall() throws Exception {
        if (leftIsBlocked()) {
            if (frontIsClear()) {
                move();
                goAroundWall();
            }
        }
    }

    /*
     * Prerequisite: Karel stands on the one of the cells of the current column
     * Result: He stands on the first cell of this column
     */
    private void standOnFirstCell() throws Exception {
        if (rightIsClear()) {
            turnRight();
            moveToBlock();
            turnAround();
        } else {
            turnLeft();
        }
    }

    /*
     * Prerequisite: missing. Karel can do it whenever he wants
     * Result: Karel walked in a straight line until block
     */
    private void moveToBlock() throws Exception {
        while (frontIsClear()) {
            move();
        }
    }
}
