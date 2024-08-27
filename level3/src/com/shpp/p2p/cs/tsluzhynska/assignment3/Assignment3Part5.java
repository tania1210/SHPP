package com.shpp.p2p.cs.tsluzhynska.assignment3;

import com.shpp.cs.a.console.TextProgram;

import java.util.Random;

/**
 * Part 5 - Casino Bernoulli game
 */
public class Assignment3Part5 extends TextProgram {

    /**The initialization of Random for tossing a coin*/
    Random random = new Random();

    /**The total earnings of the lucky player*/
    int totalEarnings = 0;

    /**The number of games played*/
    int gamesPlayed = 0;

    public void run() {
        // Starts the casino game until the lucky player earns at least $20.
        while (totalEarnings < 20) {
            start();
        }
        printGameResult();
    }

    /**
     * Starts a single game of the casino and updates the total earnings and game count.
     */
    private void start() {
        int gameEarnings = playGame();
        totalEarnings += gameEarnings;
        gamesPlayed++;
        printMessage(gameEarnings);
    }

    /**
     * Simulates a single game of the casino.
     *
     * @return the earnings from this game.
     */
    private int playGame() {
        int amountOnTable = 1;

        while (true) {
            if (tossACoin()) {
                println("Heads");
                amountOnTable *= 2;
            } else {
                println("Tails");
                return amountOnTable;
            }
        }
    }

    /**
     * Simulates tossing a coin.
     *
     * @return true if the coin lands on heads, false if it lands on tails.
     */
    private boolean tossACoin() {
        return random.nextBoolean();
    }

    /**
     * Prints the result of the current game.
     *
     * @param gameEarnings the amount earned in the current game.
     */
    private void printMessage(int gameEarnings) {
        println("This game, you earned $" + gameEarnings);
        println("Your total is $" + totalEarnings);
    }

    /**
     * Prints the final result of the game session, including the number of games played.
     */
    private void printGameResult() {
        println("It took " + gamesPlayed + " games to earn $20 or more.");
    }

}