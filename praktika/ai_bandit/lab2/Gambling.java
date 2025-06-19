/*
 * Author: Florian Schnoor, Robert Petker
 * Project: 3. Lab in OP
 * Version: 18/06/2025
 */

package ai_bandit.lab2;

import java.util.Random;

public abstract class Gambling {
    // variables declarations
    protected static Random random = new Random(); //only in this class and the ones extending of it
    private String name;
    private double pricePerRound, overallProfit;
    private int roundsPlayed;

    // constructor
    public Gambling(String name, double pricePerRound) {
        this.name = name;
        this.pricePerRound = pricePerRound;
    }

    // methods
    public String getName() {
        return name;
    }

    public double getPricePerRound() {
        return pricePerRound;
    }

    public double getOverallProfit() {
        return overallProfit;
    }

    /*
    goal:   calculate the mean profit of a round
    return: 0 if no round is played yet
       else the mean profit
    */
    public double getMeanProfitPerRound() {
        if(roundsPlayed == 0)                   //If no round is played yet => no profit
            return 0;
        return overallProfit / roundsPlayed;    //Calculation of the profit per round
    }


    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    /*
    goal:   play a round and refreshing the statistics
    return: profit of the round
    */
    public double play() {
        double profit = (double) Math.round(determineWin() * 10) / 10;

        if (profit < 0){
            profit = 0;
        }
        overallProfit += profit - pricePerRound;
        roundsPlayed ++;

        return profit;
    }

    public abstract double determineWin();  //abstract, undefined method "prototype"
}
