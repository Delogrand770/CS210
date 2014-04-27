
/**
 * Draws a staircase with people on it. The # of stairs are controlled by the integer stairs.
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 16, 2011 at 11:12:56 AM
 */
public class PJ4 {

  public static void main(String[] args) {
    int stairs = 10;
    for (int i = 1; i <= stairs; i++) {
      DrawLeftSpace(stairs, i);
      DrawHead(i);
      DrawLeftSpace(stairs, i);
      DrawBody(i);
      DrawLeftSpace(stairs, i);
      DrawFeet(i);
      System.out.println();
    }
    DrawBottomFloor(stairs);
    System.out.println();
  }

  public static void DrawLeftSpace(int stairs, int index) {
    for (int i = 0; i < 5 * (stairs - index); i++) {
      System.out.print(" ");
    }
  }

  public static void DrawFeetBodySpace(int index) {
    for (int i = 0; i < 5 * index; i++) {
      System.out.print(" ");
    }
    System.out.print("*");
  }

  public static void DrawHeadSpace(int index) {
    for (int i = 0; i < 5 * (index - 1); i++) {
      System.out.print(" ");
    }
    System.out.print("*");
  }

  public static void DrawHead(int index) {
    System.out.print("  o  ******");
    DrawHeadSpace(index);
    System.out.println();
  }

  public static void DrawBody(int index) {
    System.out.print(" /|\\ *");
    DrawFeetBodySpace(index);
    System.out.println();
  }

  public static void DrawFeet(int index) {
    System.out.print(" / \\ *");
    DrawFeetBodySpace(index);
  }

  public static void DrawBottomFloor(int stairs) {
    for (int i = 0; i < (6 * (stairs + 1)) - (stairs - 1); i++) {
      System.out.print("*");
    }
  }
}
