package com.shpp.p2p.cs.tsluzhynska.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * Part 3 - Elevation to a degree
 * write a method raiseToPower(double base, int exponent)
 * also if exponent = 0, the result should be 1.
 */
public class Assignment3Part3 extends TextProgram {

    public void run() {
        print(raiseToPower(3, 2));
        print(raiseToPower(7, 1));
    }

    /**
     * Raises the number to an exponent.
     * The method checks all edge-cases and returns the corresponding result
     *
     * @param base     it's a base number we work with
     * @param exponent it's a number to which we raise the base
     */
    private double raiseToPower(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (base == 0) {
            return 1;
        }

        if (exponent > 0) {
            return positiveExponent(base, exponent);
        } else {
            return negativeExponent(base, exponent);
        }

    }

    /**
     * Raises the base to a positive exponent.
     *
     * @param base     the base number
     * @param exponent the positive exponent
     * @return the result of raising the base to the positive exponent
     */
    private double positiveExponent(double base, int exponent) {
        double result = base;
        for (int i = 1; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    /**
     * Raises the base to a negative exponent by inverting the base.
     *
     * @param base     the base number
     * @param exponent the negative exponent (must be negative)
     * @return the result of raising the base to the negative exponent
     */
    private double negativeExponent(double base, int exponent) {
        base = 1 / base;
        exponent = -exponent;
        return positiveExponent(base, exponent);
    }
}
