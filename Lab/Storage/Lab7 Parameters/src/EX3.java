
/**
 * EX3 Prints the powers of a number from n^0 to n^max
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 22, 2011 at 10:23:06 AM
 */
public class EX3 {

  public static void main(String[] args) {
    PowersN(4, 3);
    PowersN(5, 6);
    PowersN(-2, 8);
  }

  public static void PowersN(int num, int powers) {
    int result = num;
    System.out.print(1 + " ");
    for (int i = 0; i < powers; i++) {
      System.out.print(result + " ");
      result = result * num;
    }
    System.out.println();
  }
}
