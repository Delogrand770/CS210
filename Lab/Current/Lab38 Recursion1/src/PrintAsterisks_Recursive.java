
/**
 * Description: Prints zero of more stars on an output line.
 *
 * @author  Textbook, page 644
 *
 * @version 1.0   Fall 2008
 *
 */
public class PrintAsterisks_Recursive {
  //-------------------------------------------------------------------

  public static void main(String[] args) {
    // test cases to verify the correctness of the printAsterisks() method
    for (int j = 0; j < 10; j++) {
      System.out.printf("printAsterisks(%d): ", j);
      printAsterisks(j);
    }
  }

  //-------------------------------------------------------------------
  public static void printAsterisks(int howMany) {
    System.out.print("*");
    if (howMany >= 2) {
      System.out.print("+");
      printAsterisks(howMany - 2);
    } else {
      System.out.println();
    }
  }
}
