
/**
 * Outputs the scientific notation
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 24, 2011 at 11:00:05 AM
 */
public class EX10 {

  public static void main(String[] args) {
    System.out.println(Scientific(6.23, 5));
    System.out.println(Scientific(1.9, -2));
    System.out.println();
  }

  public static double Scientific(double num, double power) {
    return num * Math.pow(10, power);
  }
}
