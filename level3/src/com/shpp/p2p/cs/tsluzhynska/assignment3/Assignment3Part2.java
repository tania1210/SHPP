package com.shpp.p2p.cs.tsluzhynska.assignment3;

import com.shpp.cs.a.console.TextProgram;

import java.util.InputMismatchException;

/*
 * Collatz Conjecture
 *
 * Take some positive integer and call it n
 * If n is even, then divide it by 2
 * If n is odd, multiply by 3 and add 1
 * Continue this process until n is equal to 1
 */
public class Assignment3Part2 extends TextProgram {

    // The number entered by the user
    private int number;

    public void run() {
        try {
            getNumber();
            processCollatzSequence();
        } catch (InputMismatchException e) {
            println("you should input the integer");
            readLine();
        }
    }

    /**
     * Prompts the user to enter a number and reads the input.
     */
    private void getNumber() throws InputMismatchException {
        number = readInt("Enter a number: ");
    }

    /**
     * Processes the Collatz sequence for the current number until it reaches 1.
     * It prints the result of each step depending on whether the number is even or odd.
     */
    private void processCollatzSequence() {
        do {
            if (number % 2 == 0) {
                printEvenOperationResult();
            } else {
                printOddOperationResult();
            }
        } while (number != 1);

        println("The end");
    }

    /**
     * Prints the result of the Collatz sequence step when the number is even.
     * The number is halved and the new value is printed.
     */
    private void printEvenOperationResult() {
        print(number + " is even so I take half: ");
        number /= 2;
        println(number);
    }

    /**
     * Prints the result of the Collatz sequence step when the number is odd.
     * The number is updated to 3n + 1 and the new value is printed.
     */
    private void printOddOperationResult() {
        print(number + " is odd so I make 3n + 1: ");
        number = number * 3 + 1;
        println(number);
    }


}