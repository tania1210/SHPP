package com.shpp.p2p.cs.tsluzhynska.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
 * Part 4 — Flag
 */
public class Assignment2Part4 extends WindowProgram {

    //The application frame has this width and height
    public static final int APPLICATION_WIDTH = 600;
    public static final int APPLICATION_HEIGHT = 600;

    //It's width and height of whole flag
    public static final double FLAG_WIDTH = 300;
    public static final double FLAG_HEIGHT = 200;

    //color numbers
    public static final int COLOR_NUMBER = 3;

    //get height for one part of flag
    public static final double PART_HEIGHT = FLAG_HEIGHT / COLOR_NUMBER;

    //text size
    public static final int LABEL_SIZE = 30;

    public static final Color ORANGE = new Color(255, 153, 0);
    public static final Color DARK_BLUE = new Color(19, 113, 255);

    private Center center;

    public void run() {
        //use record for find the center for flag
        center = findCenter();

        drawFlag();
        writeFlagName();
    }

    /**
     * the method create a label with some text, set font and size
     * set position to bottom-right corner
     * and add to frame
     */
    private void writeFlagName() {
        GLabel flagName = new GLabel("Flag of Dutch");
        flagName.setFont("Verdana-" + LABEL_SIZE);
        flagName.setLocation(getWidth() - flagName.getWidth(), getHeight() - flagName.getDescent());
        add(flagName);
    }

    /**
     * this method draw the flag in frame
     * it calls three times the method that creates part of the flag and adds them
     */
    private void drawFlag() {
        add(createPartOfFlag(ORANGE, -PART_HEIGHT));
        add(createPartOfFlag(Color.WHITE, 0));
        add(createPartOfFlag(DARK_BLUE, PART_HEIGHT));
    }

    /**
     * create a part of a flag with specific position, size and color
     *
     * @param color          The color of rectangle (part of flag)
     * @param verticalOffset The vertical offset, used to position each part
     * @return The created part (GRect)
     */
    private GRect createPartOfFlag(Color color, double verticalOffset) {
        GRect part = new GRect(center.width, center.height + verticalOffset, FLAG_WIDTH, PART_HEIGHT);
        part.setFilled(true);
        part.setColor(color);

        return part;
    }

    // create the record for search center
    private record Center(double width, double height) {
    }

    /**
     * Finds the center coordinates of a rectangle within a given area.
     *
     * @return A Center record representing the coordinates of the rectangle's center
     * so that it is positioned centrally within the form.
     */
    private Center findCenter() {
        return new Center(
                (double) getWidth() / 2 - (FLAG_WIDTH / 2),
                (double) getHeight() / 2 - (PART_HEIGHT / 2)
        );
    }
}
