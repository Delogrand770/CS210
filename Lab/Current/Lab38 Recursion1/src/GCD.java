
/**
 * Description: Find the greatest common divisor of two integers.
 *
 * @author  Dr. Brown
 *
 * @version 1.0   Fall 2008
 *
 */
public class GCD {

  //-------------------------------------------------------------------
  public static void main(String[] args) {
    System.out.println("---Iterative---");
    System.out.println("gcd(10,5) = " + gcd(10, 5));
    System.out.println("gcd(4,12) = " + gcd(4, 12));
    System.out.println("gcd(1234,45634) = " + gcd(1234, 45634));
    System.out.println("gcd(15,20) " + gcd(15, 20));

    System.out.println();
    System.out.println("---Recursive---");
    System.out.println("recursiveGCD(10,5) = " + recursiveGCD(10, 5));
    System.out.println("recursiveGCD(4,12) = " + recursiveGCD(4, 12));
    System.out.println("recursiveGCD(1234,45634) = " + recursiveGCD(1234, 45634));
    System.out.println("recursiveGCD(15,20) " + recursiveGCD(15, 20));
  }

  //-------------------------------------------------------------------
  public static int gcd(int x, int y) {
    while (y > 0) {
      int save = y;
      y = x % y;
      x = save;
    }
    return x;
  }

  public static int recursiveGCD(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return recursiveGCD(b, a % b);
    }
  }
}
