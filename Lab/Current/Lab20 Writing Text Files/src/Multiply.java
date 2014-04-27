
/**
 * An example program that writes data to a file.
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Sep 27, 2011 at 12:53:06 PM
 */
import java.io.*;

public class Multiply {

  public static void main(String[] args) {
    try {
      PrintStream output = new PrintStream(new File("MultiplicationTable.txt"));
      output.print("    ");
      for (int i = 0; i <= 10; i++) {
        output.printf("%5d:", i);
      }
      output.print("\r\n");
      for (int j = 0; j <= 10; j++) {
        output.printf("%2d:", j);
        for (int i = 0; i <= 10; i++) {
          output.printf("%6d", (i * j));
        }
        output.printf("\r\n");
      }
    } catch (IOException error) {
      System.out.println("An I/O error occurred: " + error);
    }

  }
}
