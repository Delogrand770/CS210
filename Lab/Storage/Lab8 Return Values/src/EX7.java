
/**
 * Returns the largest of 3 absolute value numbers
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 24, 2011 at 10:50:06 AM
 */
public class EX7 {

  public static void main(String[] args) {
    System.out.println(LargerAbsVal(7, -2, -11));
    System.out.println(LargerAbsVal(-4, 5, 2));
    System.out.println();
  }

  public static int LargerAbsVal(int num1, int num2, int num3) {
    return Math.max(
            Math.max(
            Math.abs(num1), Math.abs(num2)), Math.abs(num3));
  }
}
