/*
 * Author: Florian Schnoor, Robert Petker
 * Project: 3. Lab in OP
 * Version: 18/06/2025
 */
package ai_bandit.lab2;

import java.util.Scanner;

public class WheelApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        WheelOfFortune wheelOfFortune = new WheelOfFortune("SuperWheel, SuperDeal!",2.0,new int[]{20,5,1,1},new double[]{0.5,2.0,0,100});

        String name = wheelOfFortune.getName();
        System.out.printf("Gambling: %s \nPrice\t: %.2f\n",wheelOfFortune.getName(), wheelOfFortune.getPricePerRound());
        System.out.println("How many rounds would you like to play?");


        int numberOfRounds = scan.nextInt();

        System.out.printf("\n%5s | %10s | %10s\n", "Round", "Win [€]", "Net [€]");

        for (int i = 0; i < numberOfRounds; i++){
            System.out.printf("%5d | %10.2f | %10.2f\n", i + 1, wheelOfFortune.play(), wheelOfFortune.getOverallProfit());
        }

        System.out.printf("\nWheel of fortune's statistics: \nRounds: %d\nProfit: %.2f", wheelOfFortune.getRoundsPlayed(), -wheelOfFortune.getOverallProfit());
    }
}
