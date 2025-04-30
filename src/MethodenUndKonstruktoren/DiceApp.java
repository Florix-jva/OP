package MethodenUndKonstruktoren;

public class DiceApp {
    public static void main(String[] args) {
        //Declaration and initialization of variables/objects
        int lastValue = 0;
        int [] countValues = new int[6];
        final int NUMBER_THROWS = 10;
        Dice diceFunctions = new Dice();

        System.out.printf("Welcome to the dice app! The dice will be thrown %d times, as written in the program.\n",NUMBER_THROWS);
        System.out.println("Dice | #1 | #2 | #3 | #4 | #5 | #6 | Overall");
        for(int i = 0; i < NUMBER_THROWS; i++){
            lastValue = diceFunctions.throwDice();
            //Assign the thrown values to their places in the countValues array
            switch (lastValue) {
                case 1:
                    countValues[0]++;
                    break;
                case 2:
                    countValues[1]++;
                    break;
                case 3:
                    countValues[2]++;
                    break;
                case 4:
                    countValues[3]++;
                    break;
                case 5:
                    countValues[4]++;
                    break;
                case 6:
                    countValues[5]++;
                    break;
            }
            System.out.printf(" %d\t | %d  | %d  | %d  | %d  | %d  | %d  | %d\n",lastValue,countValues[0],countValues[1], countValues[2],countValues[3],countValues[4], countValues[5],(i + 1));
        }
    }
}



