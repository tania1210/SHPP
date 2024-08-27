package com.shpp.p2p.cs.tsluzhynska.assignment3;

import acm.graphics.GLine;
import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

public class Assignment3Part6 extends WindowProgram {

    //The application frame has this width and height
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 400;

    public static final int DIAMETER = 5;
    public static final double SPEED = 10;

    private static final int AMPLITUDE = 30; // Амплітуда синусоїди
    private static final int CYCLE_LENGTH = 100; // Довжина одного циклу синусоїди в пікселях
    private static final double FREQUENCY = 1;// Частота синусоїди

    private int x = 0;

    public void run() {
        long startTime = System.currentTimeMillis();
        long duration = 5000;

        GLine lineX = new GLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
        add(lineX);

        GOval point = new GOval( DIAMETER * 2, DIAMETER * 2);
        point.setFilled(true);
        point.setColor(Color.RED);
        add(point);

        while (System.currentTimeMillis() - startTime < duration) {
            double y = AMPLITUDE * Math.sin(FREQUENCY * x * 2 * Math.PI / CYCLE_LENGTH) + (getHeight() / 2 - DIAMETER / 2);
            println("x = " + x + " y = " + y);
            point.setLocation(x, y);

            GOval oval = new GOval(x, y, DIAMETER, DIAMETER);
            oval.setFilled(true);
            add(oval);

//            point.move(1, 10);
            x += 1;

            pause(SPEED);
        }

    }

}