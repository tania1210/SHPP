package com.shpp.p2p.cs.tsluzhynska.assignment3;

import com.shpp.cs.a.console.TextProgram;

import java.util.InputMismatchException;

/*
 * Part 1 - Aerobics
 * write a program that asks the user for the number of minutes spent on exercise in the last seven days,
 * and accordingly reports the following:
 *
 * 1. get exercise time for the last 7 days
 * 2. whether enough time was devoted to exercises for cardiovascular health: 30 minutes for at least 5 days;
 * or display how many days are not enough to reach the norm.
 * 3. was there enough exercise to reduce blood pressure and cholesterol: 40 minutes for at least 3 days;
 * or how many days are not enough to the norm.
 */

public class Assignment3Part1 extends TextProgram {

    /**
     * The number of days we calculate
     */
    private static final byte NUM_DAYS = 7;

    /**
     * Counter for days at least 30m
     */
    private byte cardioHealthDays = 0;

    /**
     * Counter for days at least 40m
     */
    private byte bpReductionDays = 0;

    public void run() {
        getDataForAWeek();
        printResult();
    }

    /**
     * Get the duration of exercises for a given number of days
     */
    private void getDataForAWeek() {
        int time = -1;
        for (byte i = 1; i <= NUM_DAYS; i++) {
            try {
                time = readInt(String.format("How many minutes did you do on day %s? ", i));
                if (time > (24 * 60) || time < 0) {
                    throw new InputMismatchException("you input too much time");
                }
            } catch (InputMismatchException e) {
                println("incorrect type of data");
                readLine();
                i--;
            }
            countRightTime(time);
        }
    }

    /**
     * Calculate the amount that corresponds to the norm
     *
     * @param time Time in minutes that was spent on exercises per day
     */
    private void countRightTime(int time) {
        if (time >= 30) {
            cardioHealthDays++;
        }
        if (time >= 40) {
            bpReductionDays++;
        }
    }

    /**
     * This method checks the condition and print the result to the console
     */
    private void printResult() {
        println("Cardiovascular health:\n" +
                (cardioHealthDays >= 5 ?
                        "\tGreat job! You've done enough exercise for cardiovascular health." :
                        String.format("\tYou needed to train hard for at least %s more day(s) a week!", (5 - cardioHealthDays))
                ));
        println("Blood pressure:\n\t" +
                (bpReductionDays >= 3 ?
                        "Great job! You've done enough exercise to keep a low blood pressure." :
                        String.format("You needed to train hard for at least %s more day(s) a week!", (3 - bpReductionDays))
                ));
    }
}
