
/**
 * Count the number of lines in Hamlet
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Sep 20, 2011 at 5:12:08 PM
 */
// Counts the number of lines in Hamlet.
import java.io.*;
import java.util.*;

public class Hamlet_by_lines {

  public static void main(String[] args) {
    try {

      Scanner input = new Scanner(new File("hamlet.txt"));
      int numberLines = 0;
      int countTokens = 0;
      while (input.hasNextLine()) {
        String line = input.nextLine();
        numberLines++;

        Scanner parseLine = new Scanner(line);
        while (parseLine.hasNext()) {
          String token = parseLine.next();
          countTokens++;
        }
      }
      double avg = (double) countTokens;
      avg /= (double) numberLines;
      System.out.printf("average tokens per line = %.2f\n",avg);

    } catch (IOException error) {
      System.out.println("Error in processing the file hamlet.txt" + error);
    }
  }
}
