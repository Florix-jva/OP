package ImperativeKonzepte;

public class LeibnizSeries {
    public static void main(String[] args) {
        //variable declarations and initialisations
        final int SUM_MAX = 1000;   //Max Approximation
        int sumRunner;
        double sumResult = 0;

        //Leibniz series
        for(sumRunner = 0; sumRunner <= SUM_MAX; sumRunner++){
            sumResult += 4 * (Math.pow(-1, sumRunner)/(2 * sumRunner + 1));
            System.out.printf("n = %d: pi = %.3f\n",sumRunner, sumResult);
        }
    }
}
