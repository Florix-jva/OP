package ai_bandit.lab2;

public class MultiBandit {
    private Bandit[] bandits;
    private double overallProfit = 0;
    private int initialCredit = 10;

    public MultiBandit(int numberBandits) {
        bandits = new Bandit[numberBandits];
        double averageWin;
        // determine the winning bandit:
        int winningBandit = (int) (numberBandits * Math.random());
        // averageWin:  0.5-0.8
        // determine the random numbers for averageWin:

        for (int i = 0; i < numberBandits; i++) {
            if (i == winningBandit) { //the winning bandit has an averageWin of 1.1 to 1.3
                averageWin = 1.1 + (0.3 * Math.random());
            } else {  //the standard average win value is 0.5 to 0.9
                averageWin = 0.5 + (0.4 * Math.random());
            }
            bandits[i] = new Bandit("Bandimat" + i, 1, averageWin, 1);
        }
    }

    public int getInitialCredit(){
        return initialCredit;
    }

    public int getNumberBandits(){
        return this.bandits.length;
    }

    public double getOverallProfit(){
        double overallProfit = 0;

        for (Bandit bandit : bandits) {
             overallProfit += bandit.getOverallProfit();
        }
        return overallProfit;
    }

    public double getMeanProfitPerRound(){
        if(getRoundsPlayed() == 0)                   //If no round is played yet => no profit
            return 0;

        return getOverallProfit() / getRoundsPlayed();
        //        return 1 - overallProfit / getRoundsPlayed();
    }

    public int getRoundsPlayed(){
        int overallRoundsPlayed = 0;

        for (Bandit bandit : bandits) {
            overallRoundsPlayed += bandit.getRoundsPlayed();
        }
        return overallRoundsPlayed;
    }



    public double play(int banditIndex) {
        return bandits[banditIndex].play();
    }


    public double getPricePerRound(){

        return bandits[0].getPricePerRound();
    }
}
