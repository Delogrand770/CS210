
/**
 * EX2 - Takes a str and reps parameter. Returns a string with str concated reps number of times. 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 5, 2011 at 10:32:28 PM
 */
public class EX2 {

  public static void main(String[] args) {
    System.out.println(rep1("hello", 3));
  }

  public static String rep1(String str, int reps) {
    String combined = "";
    for (int i = 0; i < reps; i++) {
      combined += str;
    }
    return combined;
  }
}
