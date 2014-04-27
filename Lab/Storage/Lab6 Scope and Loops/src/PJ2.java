
/**
 * PJ2
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 16, 2011 at 8:07:49 PM
 */
public class PJ2 {

  public static void main(String[] args) {
    HorizBar();
    Down();
    Down();
    HorizBar();
    Up();
    Up();
    HorizBar();
    System.out.println();
  }

  public static void HorizBar() {
    System.out.println("+------+");
  }

  public static void Down() {
    for (int i = 0; i < 3; i++) {
      System.out.print("|");
      for (int j = 0; j < 3 - i - 1; j++) {
        System.out.print(" ");
      }
      System.out.print("^");
      for (int j = 0; j < i * 2; j++) {
        System.out.print(" ");
      }
      System.out.print("^");
      for (int j = 0; j < 3 - i - 1; j++) {
        System.out.print(" ");
      }
      System.out.print("|");
      System.out.println();
    }
  }

  public static void Up() {
    for (int i = 0; i < 3; i++) {
      System.out.print("|");
      for (int j = 0; j < i; j++) {
        System.out.print(" ");
      }
      System.out.print("v");
      for (int j = 0; j < (3 - i - 1) * 2; j++) {
        System.out.print(" ");
      }
      System.out.print("v");
      for (int j = 0; j < i; j++) {
        System.out.print(" ");
      }
      System.out.print("|");
      System.out.println();
    }
  }
}
