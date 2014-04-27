
/**
 * Writes the 12 Days of Christmas song out. Uses Arrays, For Loops, Strings, and variables
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 10, 2011 at 10:49:40 AM
 */
public class PJ4 {

  public static void main(String[] args) {
    String[] days  = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninenth", "tenth", "eleventh", "twelveth"};
    String[] gifts = {"a partridge in a pear tree.", "two turtle doves, and", "three French hens,", "four calling birds,", "five golden rings,", "six geese a-laying,", "seven swans a-swimming,", "eight maids a-milking,", "nine ladies dancing,", "ten lords a-leaping,", "eleven pipers piping,", "Twelve drummers drumming,"};
    String intro   = "";
    int day = 0;
    for (int i = 0; i < 12; i++) {
      intro = "On the " + days[i] + " of Christmas,\nmy true love sent to me\n";
      for (int a = day; a >= 0; a--) {
        intro += gifts[a] + "\n";
      }
      day++;
      System.out.println(intro + "\n");
    }
  }
}