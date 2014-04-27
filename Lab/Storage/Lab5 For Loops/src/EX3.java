
/**
 * Prints first 12 numbers of Fibonacci sequence
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 16, 2011 at 10:40:49 AM
 */
public class EX3 {

  public static void main(String[] args) {
    int k1 = 1;
    int k2 = 1;
    int result;
    System.out.print(k1 + " " + k2 + " ");
    for (int i = 1; i <= 10; i++) {
      result = k1 + k2;
      k1 = k2;
      k2 = result;
      System.out.print(result + " ");
    }
  }
}
