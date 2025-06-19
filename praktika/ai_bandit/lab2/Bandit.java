package ai_bandit.lab2;

public class Bandit extends Gambling {
    //variables
    private double averageWin, stdDevWin;

    public Bandit(String name, double pricePerRound, double averageWin, double stdDevWin) {
        super(name, pricePerRound);
        this.averageWin = averageWin;
        this.stdDevWin = stdDevWin;
    }

    /*
    goal:   determines the win based on the random value by the gaussian algorithm
    return: the win
     */
    public double determineWin(){
        return random.nextGaussian(averageWin,stdDevWin);
    }
}
