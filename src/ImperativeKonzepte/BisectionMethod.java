package ImperativeKonzepte;

public class BisectionMethod {
    public static void main(String[] args) {
        //variables declaration/initialization
        double xLeft = 0;
        double xRight = 4;
        double xMiddle, xDelta = Math.abs(xLeft - xRight);

        //Calculation and printing
        while(xDelta > Math.pow(10,-6)){    //as long as delta x is smaller than 10^-6

            //Calculate the middle
            xMiddle = (xLeft + xRight) / 2;

            //print the middle
            System.out.printf("Approximated (interval size = %.15f):\n x0\t\t = \t%.15f\n f(x0)\t = \t%.15f\n",xDelta,xMiddle,function(xMiddle));

            //Make sure that xLeft and xRight have different signs
            if(function(xMiddle) < 0){
                xLeft = xMiddle;
            }
            else{
                xRight = xMiddle;
            }
            //interval calculation
            xDelta = Math.abs(xLeft - xRight);
        }
    }
    //function used for BisectionMethod
    static double function(double x) {
        return Math.pow(x, 2) - (2 * x) - 1;
    }
}
