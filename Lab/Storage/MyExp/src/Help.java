
import java.util.Scanner;


/**
 * Help - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 29, 2011 at 4:25:00 PM
 */
public class Help {

  public static void main(String[] args) {
    System.out.println(processName());
  }
  
  public static String processName (){
   Scanner console = new Scanner(System.in);
    System.out.println("Please enter your full name:");
    String name = console.nextLine();
    return "Your name in reverse order is" + name.substring(name.indexOf(" "), name.length()) + ", " + name.substring(0, name.indexOf(" "));
  }
}
