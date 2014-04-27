
/**
 * EX1 Passes a parameter to print the numbers from [1] to [param]
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 22, 2011 at 10:19:38 AM
 */
public class EX1 {

  public static void main(String[] args) {
    Numbers(5);
  }

  public static void Numbers(int max) {
    for (int i = 1; i <= max; i++) {
      System.out.print("[" + i + "] ");
    }
    System.out.println();
  }
}
