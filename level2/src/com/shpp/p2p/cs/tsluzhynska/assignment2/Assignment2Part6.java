package com.shpp.p2p.cs.tsluzhynska.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
 * part 6 - caterpillar
 */
public class Assignment2Part6 extends WindowProgram {

    //The application frame has this width and height
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 400;

    //Diameter is both width and height of circle
    public static final int DIAMETER = 50;

    //The horizontal spacing between the circles
    private static final int CIRCLE_SPACING = 5;

    //The number of circles
    private static final int NUM_CIRCLES = 8;

    //Constant for vertical displacement of circles
    private static final int VERTICAL_OFFSET = 3;

    public void run() {
        createCaterpillar();
    }

    /**
     * Creates a caterpillar shape by adding a series of circles to the frame
     */
    public void createCaterpillar() {
        for (int i = 0; i < NUM_CIRCLES; i++) {
            GOval oval = createCircle();
            setPosition(oval, i);
            add(oval);
        }
    }

    /**
     * Creates a circle with a specific diameter, filled with green color, and   outlined in red
     *
     * @return The created GOval object
     */
    private GOval createCircle() {
        GOval oval = new GOval(DIAMETER, DIAMETER);
        oval.setFilled(true);
        oval.setColor(Color.RED);
        oval.setFillColor(Color.GREEN);
        return oval;
    }

    /**
     * Sets the position of the specified circle on the canvas based on its index.
     * The position alternates vertically for an offset effect
     *
     * @param oval The GOval object whose position is being set
     * @param i    The index of the circle, used to determine its horizontal and vertical position
     */
    private void setPosition(GOval oval, int i) {
        oval.setLocation(i * ((double) DIAMETER / 2 + CIRCLE_SPACING),
                i % 2 != 0 ? 0 : (double) DIAMETER / VERTICAL_OFFSET);
    }

}
