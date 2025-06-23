package ai_bandit.lab2;

import java.util.Scanner;

public class BanditApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Bandit bandit = new Bandit("Bandimat",1.0,0.8,0.5);

        System.out.printf("Gambling: %s \nPrice\t: %.2f\n",bandit.getName(), bandit.getPricePerRound());
        System.out.println("How many rounds would you like to play?");

        int numberOfRounds = scan.nextInt();

        System.out.printf("\n%5s | %10s | %10s\n", "Round", "Win [€]", "Net [€]");

        for (int i = 0; i < numberOfRounds; i++){
            System.out.printf("%5d | %10.2f | %10.2f\n", i + 1, bandit.play(), bandit.getOverallProfit());
        }

        System.out.printf("\nstatistics: \nRounds: %d\nProfit: %.2f", bandit.getRoundsPlayed(), -bandit.getOverallProfit());
    }

}
