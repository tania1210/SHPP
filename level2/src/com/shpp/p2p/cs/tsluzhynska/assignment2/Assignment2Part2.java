package com.shpp.p2p.cs.tsluzhynska.assignment2;

import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
 * Part 2 — prints 4 black circles in the corners and a rectangle on top of them
 */
public class Assignment2Part2 extends WindowProgram {

    //Diameter is both width and height of circle
    static final double DIAMETER = 100;

    //The application frame has this width and height
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 400;

    public void run() {
        double appWidth = getWidth() - DIAMETER;
        double appHeight = getHeight() - DIAMETER;

        //set location for circles
        for (double i = 0; i <= appWidth; i += appWidth) {
            for (double j = 0; j <= appHeight; j += appHeight) {
                add(createCircle(i, j));
                System.out.println();
            }
        }
        add(createRectangle());
    }

    /**
     * This method creates a rectangle (GRect) with specific position and size, filled it with white color.
     *
     * @return the created GRect object
     */
    private GRect createRectangle() {
        GRect rect = new GRect(DIAMETER / 2, DIAMETER / 2, getWidth() - DIAMETER, getHeight() - DIAMETER);
        rect.setFilled(true);
        rect.setColor(Color.WHITE);
        return rect;
    }

    /**
     * This method creates a circle (GOval) with a specified position and size and filled it with black color.
     *
     * @param x the x-coordinate of the circle's upper-left corner
     * @param y the y-coordinate of the circle's upper-left corner
     * @return the created GOval object
     */
    private GOval createCircle(double x, double y) {
        GOval circle = new GOval(x, y, DIAMETER, DIAMETER);
        circle.setFilled(true);
        circle.setColor(Color.BLACK);
        return circle;
    }
}
