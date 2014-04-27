
/**
 * Count the word hamlet in Hamlet.txt
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Sep 20, 2011 at 5:12:08 PM
 */
// Counts the number of words in Hamlet.
import java.io.*;
import java.util.*;

public class Hamlet {

  public static void main(String[] args) {
    try {

      Scanner input = new Scanner(new File("Romeo_and_Juliet.txt"));
      int count = 0;
      while (input.hasNext()) {
        String word = input.next();
        //System.out.println(word);
        if (word.equalsIgnoreCase("love")) {
          count++;
        }
      }
      System.out.println("love appears = " + count);

    } catch (IOException error) {
      System.out.println("Error in processing the file Romeo_and_Juliet.txt" + error);
    }
  }
}
