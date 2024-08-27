package com.shpp.p2p.cs.tsluzhynska.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/**
 * Part 4 — Pyramid
 * Make a pyramid. It should be centered horizontally and lie on the "bottom" of the window.
 * Constants — BRICK_HEIGHT, BRICK_WIDTH, BRICKS_IN_BASE (how many brick in the base)
 */
public class Assignment3Part4 extends WindowProgram {

    /**Application width*/
    public static final int APPLICATION_WIDTH = 500;

    /**Application height*/
    public static final int APPLICATION_HEIGHT = 500;

    /**A brick height*/
    private static final int BRICK_HEIGHT = 10;

    /**A brick width*/
    private static final int BRICK_WIDTH = 50;

    /**Number of bricks in the base*/
    private static final int BRICKS_IN_BASE = 10;

    /**Width of the pyramid base*/
    private static final double WIDTH_OF_PYRAMID = BRICKS_IN_BASE * BRICK_WIDTH;

    /**Keeps track of the current level of the pyramid*/
    private int numLevel = 1;

    /**Determines the offset factor used to shift each level of the pyramid toward the center*/
    private int offsetFactor = 0;

    public void run() {
        drawPyramidLevels();
    }

    /**
     * Draws all the levels of the pyramid, starting from the base and moving upward.
     * Each new level is centered relative to the previous one by adjusting the offset.
     */
    private void drawPyramidLevels() {
        for (int j = BRICKS_IN_BASE; j > 0; j--) {
            addBricksInLevel(j);
            numLevel++;
            offsetFactor++;
        }
    }

    /**
     * Adds the specified number of bricks to the current level of the pyramid.
     * The number of bricks decreases as the levels go upward.
     *
     * @param j The number of bricks to add to the current level
     */
    private void addBricksInLevel(int j) {
        for (int i = 0; i < j; i++) {
            add(createBrick(i));
        }
    }

    /**
     * Creates object of brick with width and height from constants.
     * Counts the location for the current brick. Changes color.
     *
     * @param i The index of the brick within the current level, used to determine its horizontal position.
     *
     * @return The brick object.
     */
    private GRect createBrick(int i) {
        GRect rect = new GRect(
                i * BRICK_WIDTH + ((getWidth() - WIDTH_OF_PYRAMID) / 2) + (offsetFactor * BRICK_WIDTH / 2.0),
                getHeight() - (BRICK_HEIGHT * numLevel),
                BRICK_WIDTH, BRICK_HEIGHT);
        rect.setFilled(true);
        rect.setFillColor(Color.ORANGE);

        return rect;
    }
//    }
}
