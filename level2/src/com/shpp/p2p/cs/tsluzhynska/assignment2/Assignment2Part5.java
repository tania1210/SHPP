package com.shpp.p2p.cs.tsluzhynska.assignment2;

import acm.graphics.GObject;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

/*
 * part 5 - matrix of squares
 */
public class Assignment2Part5 extends WindowProgram {

    //The application frame has this width and height
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 400;

    // The number of rows and columns in the grid, respectively.
    private static final int NUM_ROWS = 3;
    private static final int NUM_COLS = 7;

    // The width and height of each box.
    private static final double BOX_SIZE = 40;

    // The horizontal and vertical spacing between the boxes.
    private static final double BOX_SPACING = 10;

    private static final double WIDTH_OF_ILLUSION = (NUM_COLS * BOX_SIZE) + ((NUM_COLS - 1) * BOX_SPACING);
    private static final double HEIGHT_OF_ILLUSION = (NUM_ROWS * BOX_SIZE) + ((NUM_ROWS - 1) * BOX_SPACING);

    public void run() {
        // loop draws the columns
        for (int i = 0; i < NUM_COLS; i++) {
            drawRows(i);
        }
    }

    /**
     * Draws a row of squares at the specified column index.
     *
     * @param i The index of the column where the row of squares will be drawn.
     */

    private void drawRows(int i) {
        for (int j = 0; j < NUM_ROWS; j++) {
            add(createRectangle(i, j));
        }
    }

    /**
     * Create a square with specific position and size, filled it with black color
     *
     * @param i The index of the column where the square will be positioned.
     * @param j The index of the row where the square will be positioned.
     *
     * @return The created GRect object
     */
    private GRect createRectangle(int i, int j) {
        GRect rect = new GRect(
                i * (BOX_SIZE + BOX_SPACING) + ((getWidth() - WIDTH_OF_ILLUSION) / 2),
                j * (BOX_SIZE + BOX_SPACING) + ((getHeight() - HEIGHT_OF_ILLUSION) / 2),
                BOX_SIZE, BOX_SIZE);
        rect.setFilled(true);
        return rect;
    }

}
