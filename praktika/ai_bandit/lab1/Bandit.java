package ai_bandit.lab1;

import java.util.Random;

public class Bandit {
    //variables
    private static Random random = new Random();
    private String name;
    private double averageWin, stdDevWin, overallProfit, pricePerRound;
    private  int roundsPlayed;

    public Bandit(String name, double pricePerRound, double averageWin, double stdDevWin) {
        this.name = name;
        this.pricePerRound = pricePerRound;
        this.averageWin = averageWin;
        this.stdDevWin = stdDevWin;
    }

    public Bandit(double pricePerRound, double averageWin, double stdDevWin) {
        this.pricePerRound = pricePerRound;
        this.averageWin = averageWin;
        this.stdDevWin = stdDevWin;
    }

    public String getName() {
        return name;
    }

    public double getPricePerRound() {
        return pricePerRound;
    }

    public double getOverallProfit() {
        return overallProfit;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    /*
    goal:   calculate the mean profit of a round
    return: 0 if no round is played yet
            else the mean profit
     */
    public double getMeanProfitPerRound(){
        if(roundsPlayed == 0)                   //If no round is played yet => no profit
            return 0;
        return overallProfit / roundsPlayed;    //Calculation of the profit per round
    }

    /*
   goal:   play a round and refreshing the statistics
   return: profit of the round
    */
    public double play(){
        double profit = (double) Math.round(determineWin() * 10) / 10;

        if (profit < 0){
            profit = 0;
        }
        overallProfit += pricePerRound - profit;
        roundsPlayed ++;

        return profit;
    }

    /*
    goal:   determines the win based on the random value by the gaussian algorithm
    return: the win
     */
    private double determineWin(){
        return random.nextGaussian(averageWin,stdDevWin);
    }
}
