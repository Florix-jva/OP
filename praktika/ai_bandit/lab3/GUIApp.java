package ai_bandit.lab3;


import ai_bandit.lab2.MultiBandit;
import ai_bandit.lab2.MultiBanditSolver;

import java.util.Scanner;

public class GUIApp {

    private MultiBandit multiBandit;
    private MultiBanditSolver multiBanditSolver;
    private final GUI gui;
    private GUIApp guiApp;
    private int numberBandits;

    double win;
    double initialCredit = 10;
    private double[] overallProfit;



    public void runRounds () {

        System.out.printf("Gambling: Multi-armed bandit (%d bandits) \nPrice\t: %.2f\n",multiBandit.getNumberBandits(), multiBandit.getPricePerRound());

        int strategy = gui.getStrategy();

        System.out.printf("\n%5s | %6s | %10s | %10s\n", "Round", "Bandit", "Win [€]", "Net [€]");

        int numberOfRounds = gui.getNumberOfRounds();
        if (overallProfit == null || overallProfit.length < numberOfRounds)
            overallProfit = new double[numberOfRounds];

        for (int i = 0; i < numberOfRounds; i++){
            int banditIndex;
            if(strategy < 0 || strategy > 100) {
                banditIndex = multiBanditSolver.chooseRandom();
            }
            else {
                multiBanditSolver.setGreedyEpsilon((double) strategy /100);
                banditIndex = multiBanditSolver.chooseGreedy();
            }
            win = multiBandit.play(banditIndex);

            multiBanditSolver.addBanditResponse(banditIndex,win - multiBandit.getPricePerRound());

            System.out.printf("%5d | %6d | %10.2f | %10.2f\n", i + 1, banditIndex + 1, win, multiBandit.getOverallProfit());

            overallProfit[i] = initialCredit + multiBandit.getOverallProfit();
        }
        gui.repaint();
        gui.revalidate();
        gui.getBanditPanel().repaint();
        gui.getCreditPanel().repaint();
    }

    public void reset (){
        numberBandits = 7;

        this.multiBandit = new MultiBandit(numberBandits);
        this.multiBanditSolver = new MultiBanditSolver(multiBandit);
        this.overallProfit = null;

        gui.repaint();
        gui.revalidate();
        gui.getBanditPanel().repaint();
        gui.getCreditPanel().repaint();
    }

    public GUIApp() {
        numberBandits = 7;

        this.multiBandit = new MultiBandit(numberBandits);
        this.multiBanditSolver = new MultiBanditSolver(multiBandit);
        this.gui = new GUI(multiBanditSolver, this);
    }

    public static void main(String[] args) {
        new GUIApp();
    }

    public double[] getOverallProfit() {
        return overallProfit;
    }

    public int getRoundsPlayed() {
        return multiBandit.getRoundsPlayed();
    }

    public MultiBanditSolver getMultiBanditSolver(){
        return multiBanditSolver;
    }

}
