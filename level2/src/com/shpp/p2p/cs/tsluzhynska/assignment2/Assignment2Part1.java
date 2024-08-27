package com.shpp.p2p.cs.tsluzhynska.assignment2;

import com.shpp.cs.a.console.TextProgram;

import java.util.InputMismatchException;

/*
 * Part 1 — solve a quadratic equation
 */
public class Assignment2Part1 extends TextProgram {

    // equation coefficients
    private double a;
    private double b;
    private double c;

    public void run() {
        getQuadraticCoefficients();
        solveQuadraticEquation();
    }

    /**
     * This method is responsible for obtaining coefficients for an equation from the console.
     * It also handles cases of incorrect data input.
     */
    private void getQuadraticCoefficients() {
        boolean shouldRepeat = true;
        while (shouldRepeat) {
            try {
                a = readDouble("Please enter a: ");
                b = readDouble("Please enter b: ");
                c = readDouble("Please enter c: ");

                shouldRepeat = false;
            } catch (InputMismatchException e) {
                println("the type was wrong. Input the integer or double");
                readLine();
            }
        }
    }

    /**
     * This method solves the quadratic equation.
     * It calculates the discriminant (D) and calls the findRoots(D) method
     * to determine and display the roots based on the discriminant.
     */
    private void solveQuadraticEquation() {
        double D = Math.sqrt(Math.pow(b, 2) - (4 * a * c));
        findRoots(D);
    }

    /**
     * This method determines and prints the roots of the quadratic equation based on the discriminant (D).
     * If D > 0, there are two real roots.
     * If D == 0, there is one real root.
     * If D < 0, there are no real roots.
     *
     * @param D the discriminant of the quadratic equation
     */
    private void findRoots(double D) {
        if (D > 0) {
            println(String.format("There are two roots: x1 = %s, x2 = %s", calculateRoots(D), calculateRoots(-D)));
        } else if (D == 0) {
            println("There is only one root: x = " + calculateRoots(D));
        } else {
            println("There are no real roots");
        }
    }

    /**
     * This method calculates a root of the quadratic equation based on the discriminant (D).
     *
     * @param D the discriminant or its negative value for calculating the root
     * @return the calculated root of the quadratic equation
     */
    private double calculateRoots(double D) {
        return (-b + D) / (2 * a);
    }

}
