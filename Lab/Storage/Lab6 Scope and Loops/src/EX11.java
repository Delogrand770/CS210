
/**
 * EX11
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 16, 2011 at 8:07:25 PM
 */
public class EX11 {

  public static void main(String[] args) {
    final int PATTLENGTH = 5;
    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j < PATTLENGTH; j++) {
        System.out.print(" ");
      }
      System.out.print("|");
    }
    System.out.println();
    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j < PATTLENGTH; j++) {
        System.out.print(j);
      }
      System.out.print("0");
    }
    System.out.println();
  }
}
