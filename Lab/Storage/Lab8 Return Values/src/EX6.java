
/**
 * Returns the largest of two absolute value numbers
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 24, 2011 at 10:46:17 AM
 */
public class EX6 {

  public static void main(String[] args) {
    System.out.println(LargerAbsVal(11, 2));
    System.out.println(LargerAbsVal(4, -5));
    System.out.println();
  }

  public static int LargerAbsVal(int num1, int num2) {
    return Math.max(Math.abs(num1), Math.abs(num2));
  }
}
