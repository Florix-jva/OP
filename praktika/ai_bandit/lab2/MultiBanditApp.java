package ai_bandit.lab2;

import java.util.Scanner;

public class MultiBanditApp {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            int numberBandits = 7;
            int banditIndex = 0;


            MultiBandit multiBandit = new MultiBandit(numberBandits);
            MultiBanditSolver multiBanditSolver = new MultiBanditSolver(multiBandit);

            System.out.printf("Gambling: Multi-armed bandit (%d bandits) \nPrice\t: %.2f\n",multiBandit.getNumberBandits(), multiBandit.getPricePerRound());
            System.out.println("How many rounds would you like to play?");

            int numberOfRounds = scan.nextInt();

            System.out.println("Enter epsilon in [0, 100] % (typ. 15) or any other number for random strategy:");

            int strategy = scan.nextInt();


            System.out.printf("\n%5s | %6s | %10s | %10s\n", "Round", "Bandit", "Win [€]", "Net [€]");

            for (int i = 0; i < numberOfRounds; i++){
                if(strategy < 0 || strategy > 100) {
                    banditIndex = multiBanditSolver.chooseRandom();
                }
                else {
                    multiBanditSolver.setGreedyEpsilon((double)strategy/100);
                    banditIndex = multiBanditSolver.chooseGreedy();
                }

                System.out.printf("%5d | %6d | %10.2f | %10.2f\n", i + 1,banditIndex + 1, multiBandit.play(banditIndex), multiBandit.getOverallProfit());
            }
            if(banditIndex < 0 || banditIndex > 100)
                System.out.println("Applied strategy: random\n");
            else
                System.out.printf("Applied strategy: epsilon-greedy (epsilon = %.2f)\n",(double)strategy/100);

            System.out.printf("\nMulti-armed bandit's statistics: \nRounds: %d\nProfit: %.2f", multiBandit.getRoundsPlayed(), -multiBandit.getOverallProfit());
        }
}
