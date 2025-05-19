package ai_bandit.lab1;

import java.util.Scanner;

public class MultiBanditApp {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            int numberBandits = 7;
            int randomBanditIndex;


            MultiBandit multiBandit = new MultiBandit(numberBandits);

            System.out.printf("Gambling: Multi-armed bandit (%d bandits) \nPrice\t: %.2f\n",multiBandit.getNumberBandits(), multiBandit.getPricePerRound());
            System.out.println("How many rounds would you like to play?");

            int numberOfRounds = scan.nextInt();

            System.out.printf("\n%-5s | %-6s | %-10s | %-10s\n", "Round", "Bandit", "Win [€]", "Net [€]");

            for (int i = 0; i < numberOfRounds; i++){
                randomBanditIndex = (int)(numberBandits * Math.random());

                System.out.printf("%-5d | %-6d | %-10.2f | %-10.2f\n", i + 1,randomBanditIndex + 1, multiBandit.play(randomBanditIndex), multiBandit.getOverallProfit());
            }

            System.out.printf("\nstatistics: \nRounds: %d\nProfit: %.2f", multiBandit.getRoundsPlayed(), -multiBandit.getOverallProfit());
        }
}
