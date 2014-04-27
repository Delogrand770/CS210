
/**
 * Formats Hamlet so it is only 30 chars per line w/o breaking words
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Sep 20, 2011 at 5:12:08 PM
 */
// Counts the number of lines in Hamlet.
import java.io.*;
import java.util.*;

public class LineWrap {

  public static void main(String[] args) {
    try {
      Scanner input = new Scanner(new File("hamlet.txt"));
      String alltext = "";
      
      while (input.hasNextLine()) {
        alltext += input.nextLine() + " ";
      }
      
      Scanner parseLine = new Scanner(alltext);
      String test = "";
      String nextWord = "";
      
      while (parseLine.hasNext()) {
        nextWord = parseLine.next() + " ";
        if (test.length() + nextWord.length() > 30) {
          System.out.println(test);
          test = nextWord;
        } else {
          test += nextWord;
        }
      }
      
      System.out.println(test); //Output any remaining text
      
    } catch (IOException error) {
      System.out.println("Error in processing the file hamlet.txt" + error);
    }
  }
}
