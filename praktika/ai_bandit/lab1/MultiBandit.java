package ai_bandit.lab1;

import java.util.Random;

public class MultiBandit {
    private final Bandit[] bandits;


    public MultiBandit(int numberBandits) {
        bandits = new Bandit[numberBandits];
        double averageWin;
        // determine the winning bandit:
        int winningBandit = (int)(numberBandits * Math.random()) + 1;
        // averageWin:  0.5-0.8
        // determine the random numbers for averageWin:

        for (int i = 0; i < numberBandits; i++){
            if (i == winningBandit) { //the winning bandit has an averageWin of 1.1 to 1.3
                averageWin = 1.1 + (0.3 * Math.random());
            }
            else {
                averageWin = 0.5 + (0.4 * Math.random());
            }
            bandits[i] = new Bandit("Bandimat" + i, 1, averageWin,1);
        }
    }

    public int getNumberBandits(){
        return this.bandits.length;
    }

    public double getPricePerRound(){
        double overallPrice = 0;

        for (Bandit bandit : bandits) {
            overallPrice += bandit.getPricePerRound();
        }
        return overallPrice/getRoundsPlayed();
    }

    public double getOverallProfit(){
        double overallProfit = 0;

        for (Bandit bandit : bandits) {
             overallProfit += bandit.getOverallProfit();
        }
        return overallProfit;
    }

    public double getMeanProfitPerRound(){
        double sumMean = 0;

        for (Bandit bandit : bandits) {
            sumMean += bandit.getMeanProfitPerRound();
        }
        return sumMean;
    }

    public int getRoundsPlayed(){
        return bandits[0].getRoundsPlayed();
    }

    public double play(int banditIndex){
        double overallProfit = 0;

        for (Bandit bandit : bandits) {
            overallProfit += bandit.play();
        }
        return overallProfit;
    }
}
