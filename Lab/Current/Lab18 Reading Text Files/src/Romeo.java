
/**
 * Count the word love in romeo.txt
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Sep 20, 2011 at 5:12:08 PM
 */
// Counts the number of words in Hamlet.
import java.io.*;
import java.util.*;

public class Romeo {

  public static void main(String[] args) {
    try {

      Scanner input = new Scanner(new File("hamlet.txt"));
      int count = 0;
      while (input.hasNext()) {
        String word = input.next();
        //System.out.println(word);
        if (word.equalsIgnoreCase("hamlet")) {
          count++;
        }
      }
      System.out.println("hamlet's name in text = " + count);

    } catch (IOException error) {
      System.out.println("Error in processing the file hamlet.txt" + error);
    }
  }
}
