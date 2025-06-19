/*
 * Author: Florian Schnoor, Robert Petker
 * Project: 3. Lab in OP
 * Version: 18/06/2025
 */
package ai_bandit.lab2;


public class WheelOfFortune extends Gambling{
    private int numberFields;
    private double[] categoryWins, categoryChances;
    private String name;

    /*
    Standard-constructor:
    goal:       hand over the extern variables
    variables: double pricePerRound, double [] categoryWins: win of each category
               int [] categoryNumberFields: number of fields of each category
    */
    public WheelOfFortune(String name, double pricePerRound, int[] categoryNumberFields, double[] categoryWins) {
        super(name, pricePerRound);
        this.categoryWins = categoryWins;
        for (int categoryNumberField : categoryNumberFields) {
            this.numberFields += categoryNumberField;
        }
        this.categoryChances = new double[categoryNumberFields.length];
        for (int i = 0; i < categoryNumberFields.length; i++) {
            categoryChances[i] = categoryNumberFields[i] / (double) numberFields;
        }
    }

    public int getNumberFields() {
        return numberFields;
    }

    /*
    goal: determine the win based on the chance for each field
     */
    //@Override   // overrides method-declaration in subclass (but its only protype -> @O. unnecessary)
    public double determineWin() {
        double randomChance = random.nextDouble(0,1);
        double cumulativeChance = 0;

        for (int i = 0; i < categoryChances.length; i++) {
            cumulativeChance += categoryChances[i];
            if (randomChance < cumulativeChance)
                return categoryWins[i];
        }
        return 0;
    }
}
