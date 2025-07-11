/*
 * Author: Florian Schnoor, Robert Petker
 * Project: 3. Lab in OP
 * Version: 30/06/2025
 */
package ai_bandit.lab2;

import java.util.Random;

public class MultiBanditSolver {
    private static Random random = new Random();    // static - for the whole class
    private MultiBandit bandits;
    private int[] counts;
    private double[] wins;
    private double epsilon;

    public MultiBanditSolver(MultiBandit bandits) {
        this.bandits = bandits;
        this.counts = new int[bandits.getNumberBandits()];
        this.wins = new double[bandits.getNumberBandits()];
    }

    public void setGreedyEpsilon(double epsilon) {  // greedy - gierig
        this.epsilon = epsilon;
    }

    public void addBanditResponse(int banditIndex, double win) {
        this.wins[banditIndex] += win;
        this.counts[banditIndex] ++;
    }

    public double getAverageWin(int banditIndex) {
        if(counts[banditIndex] == 0)
            return 0;

        return wins[banditIndex]/counts[banditIndex];
    }

    public int[] getCounts() {
        return counts;
    }

    public int chooseRandom() {
        return random.nextInt(0,bandits.getNumberBandits());    // random bandit of all bandits
    }

    /*
    goal: the bandit will be chosen based on the epsilon-greedy procedure
     */
    public int chooseGreedy() {
        double randomNumber = random.nextDouble(0,1);

        if (randomNumber > epsilon) {   // the bandit wth the maximum win will be chosen
            int maxWinBanditIndex = 0;
            for(int i = 0; i < bandits.getNumberBandits(); i++) {
                if (getAverageWin(i) > getAverageWin(maxWinBanditIndex)){
                    maxWinBanditIndex = i;
                }
            }
            return maxWinBanditIndex;
        }
        else {
            return chooseRandom();          // otherwise a random bandit will be chosen
        }
    }
}
