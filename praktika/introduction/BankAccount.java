package introduction;

public class BankAccount {
    public static void main(String[] args) {
        final int BALANCE = 1000;
        double balance = (double)BALANCE;
        int years;

        for (years = 0; balance < (2 * BALANCE); years++) {
            balance += balance * 0.0035;
        }
        System.out.printf("Der Kontostand hat sich nach %d Jahren verdoppelt und liegt bei: %.2f €.", years, balance);
    }
}
