
/**
 * Find the maximum root of a quadratic equation.
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Aug 19, 2011 at 12:58:01 PM
 */
public class Quadratic {

  public static void main(String[] args) {
    System.out.println("The largest root of x^2 - 7x + 12 = " + quadratic(1, -7, 12));
    System.out.println("The largest root of x^2 + 3x + 2  = " + quadratic(1, 3, 2));
    //System.out.println("The largest root of x^2 + 3x + 2  = " + quadratic(-1, 0, -2)); // negative sqrt error
    //System.out.println("The largest root of x^2 + 3x + 2  = " + quadratic(0, 0, 0)); //  divide by zero error
  }

  //-------------------------------------------------------------------
  // Preconditions: Inputs 3 integers a,b,c. a!=0 and (b * b - 4 * a * c) >= 0
  // Postconditions: Returns a real root of the equation.
  public static double quadratic(double a, double b, double c) {
    if (b * b - 4 * a * c < 0) {
      throw new ArithmeticException("No real roots. Square root of a negative number");
    }
    if (a == 0) {
      throw new ArithmeticException("Coeff A = 0. Can't divide by 0");
    }
    double determinate = Math.sqrt(b * b - 4 * a * c);
    double x1 = (-b + determinate) / (2.0 * a);
    double x2 = (-b - determinate) / (2.0 * a);

    return Math.max(x1, x2);
  }
}
