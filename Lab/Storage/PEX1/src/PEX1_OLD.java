
/**
 * PEX Outputs a scalable space needle
 * Documentation: I did not get help on this assignment
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 18, 2011 at 10:51:20 AM
 */
public class PEX1_OLD {

  public static int SIZE = 4;

  public static void main(String[] args) {
    Spike();
    Top();
    Bottom();
    Spike();
    Tower();
    Top();
  }

  public static void Bottom() {
    for (int i = 0; i < SIZE; i++) {
      Draw(i * 2, " ");
      System.out.print("\\_");
      Draw((SIZE + 1) - (i * 1), "/\\");
      System.out.print("/\\");
      Draw((SIZE + 1) - (i * 1), "/\\");
      System.out.print("_/");
      Draw(i * 2, " ");
      System.out.println();
    }
  }

  public static void Top() {
    for (int i = 0; i < SIZE; i++) {
      Draw((SIZE * 3) - 3 - (3 * i), " ");
      System.out.print("__/");
      Draw(i,":::");
      System.out.print("||");
      Draw(i,":::");
      System.out.print("\\__");
      Draw((SIZE * 3) - 3 - (3 * i), " ");
      System.out.println();
    }
    System.out.print("|");
    Draw(SIZE * 6,"\"");
    System.out.print("|");
    System.out.println();
  }

  public static void Spike() {
    for (int i = 0; i < SIZE; i++) {
      Draw(3 * SIZE, " ");
      System.out.print("||");
      Draw(3 * SIZE, " ");
      System.out.println();
    }
  }

  public static void Tower() {
    for (int i = 0; i < SIZE * SIZE; i++) {
      Draw((SIZE * 3) - 3, " ");
      System.out.print("|%%||%%|");
      Draw((SIZE * 3) - 3, " ");
      System.out.println();
    }
  }

  public static void Draw(int howmany, String text) {
    for (int j = 0; j < howmany; j++) {
      System.out.print(text);
    }
  }
}
