
import java.util.Scanner;

/**
 * EXS - Exercises 11,12,13,14,15
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 24, 2011 at 11:30:22 AM
 */
public class EXS {

  public static void main(String[] args) {
    System.out.println(PadString("hello", 8));
    System.out.println(PadString("congratulations", 10));
    System.out.println(Vertical("hey now"));
    System.out.println(PrintReverse("hello there!"));
    System.out.println(InputBirthday());
    System.out.println(ProcessName());
  }

  public static String PadString(String toPad, int padBy) {
    String padding = "";
    for (int i = toPad.length(); i < padBy; i++) {
      padding += " ";
    }
    return toPad + padding;
  }

  public static String Vertical(String toVert) {
    String output = "";
    for (int i = 0; i < toVert.length(); i++) {
      output += toVert.charAt(i) + "\n";
    }
    return output;
  }

  public static String PrintReverse(String toReverse) {
    String output = "";
    for (int i = toReverse.length(); i > 0; i--) {
      output += toReverse.charAt(i - 1);
    }
    return output;
  }

  public static String InputBirthday() {
    Scanner console = new Scanner(System.in);
    System.out.println("On what day of the month were you born? ");
    int day = console.nextInt();
    System.out.println("What is the name of the month in which you were born? ");
    String month = console.next();
    System.out.println("During what year were you born? ");
    int year = console.nextInt();
    return "You were born on " + month + " " + day + ", " + year + ". You're mighty old!";
  }

  public static String ProcessName() {
    Scanner console = new Scanner(System.in);
    System.out.print("Please enter your full name: ");
    String name = console.nextLine();
    String first = name.substring(0, name.indexOf(' '));
    String last = name.substring(name.indexOf(' '), name.length());
    return "Your name in reverse order is" + last + ", " + first;
  }
}
