
/**
 * EX9 - Prints the factors of a number
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 15, 2011 at 4:28:45 PM
 */
public class EX9 {

  public static void main(String[] args) {
    printFactors(24);
    printFactors(100);
    printFactors(75);
  }

  private static void printFactors(int x) {
    int factor = 1;
    do {
      if (x % factor == 0) {
        System.out.print(factor);
        if (factor < x) {
          System.out.print(" and ");
        }
      }
      factor++;
    } while (factor <= x);
    System.out.println();
  }
}
