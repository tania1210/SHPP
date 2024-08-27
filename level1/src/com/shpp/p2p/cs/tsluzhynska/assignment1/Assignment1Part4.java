package com.shpp.p2p.cs.tsluzhynska.assignment1;

//Ex №4 - Chessboard
public class Assignment1Part4 extends SuperKarel {

    public void run() throws Exception {
        //fill first row
        fillRow();

        //then we check: board is even or odd
        if (noBeepersPresent()) {
            fillEvenBoard();
        } else {
            fillOddBoard();
        }
    }

    /*
     * Prerequisite: for even board. Karel should stand in the right bottom corner of board
     * Result: chessboard was created
     */
    private void fillEvenBoard() throws Exception {
        moveToNextRowLeft();
        while (frontIsClear()) {
            fillSecondRowAndMoveToNext();
            fillFirstRowAndMoveToNext();
        }
    }

    /*
     * Prerequisite: for odd board. Karel should stand in the right bottom corner of board
     * Result: chessboard was created
     */
    private void fillOddBoard() throws Exception {
        moveToNextRowLeft();
        while (frontIsClear()) {
            move();
            fillSecondRowAndMoveToNext();
            fillFirstRowAndMoveToNext();
        }
    }

    /*
     * Prerequisite: we divide the board into two types of lines from which it consists: first and second
     * for filling the first - the start point should be on the left hand side from Karel and the edge of board is front of him
     * Result: Karel filled the first row, the edge of board is front of him
     */
    private void fillFirstRowAndMoveToNext() throws Exception {
        if (frontIsClear()) {
            fillRow();
            moveToNextRowLeft();
        }
    }

    /*
     * Prerequisite: also we divide the second row into two types: for even board and for odd
     * for filling the second even row - the start point should be on the right hand side from Karel and the edge of board is front of him
     * Result: Karel filled the second row, the edge of board is front of him
     */
    private void fillSecondRowAndMoveToNext() throws Exception {
        fillRow();
        moveToNextRowRight();
    }

    /*
     * Prerequisite: Karel stands on the first cell of new row (the edge of board is behind him)
     * Result: Karel filled the row with beeper after one (skip though one cell)
     * The row ALWAYS had beeper on the first cell. The last cell also had beeper if the board is odd, but was empty if board is even
     */
    private void fillRow() throws Exception {
        fillTheCellByBeeper();
        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                fillTheCellByBeeper();
            }
        }
    }

    /*
     * Prerequisite: if Karel needs to move to the next row to his left, he can use this method
     * Result: Karel stands on a new row and looks along this row
     */
    private void moveToNextRowLeft() throws Exception {
        if (leftIsClear()) {
            turnLeft();
            move();
            turnLeft();
        }
    }

    /*
     * Prerequisite: if Karel needs to move to the next row to his left, he can use this method
     * Result: Karel stands on a new row and looks along this row
     */
    private void moveToNextRowRight() throws Exception {
        if (rightIsClear()) {
            turnRight();
            move();
            turnRight();
        }
    }
}
