
/**
 * Draw the desired pattern using static methods to simplify the process.
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 10, 2011 at 10:24:19 AM
 */
public class EX9 {

  public static void main(String[] args) {
     Circle();
     System.out.println();
     Middle();
     Circle();
     System.out.println();
     Middle();
     Bottom();
     System.out.println();
     Top();
     Middle();
     Bottom();
  }
  public static void Top(){
    System.out.println("  _______");
    System.out.println(" /       \\");
    System.out.println("/         \\");
  }
  public static void Middle(){
    System.out.println("-\"-'-\"-'-\"-");
  }
  public static void Bottom(){
    System.out.println("\\         /");
    System.out.println(" \\_______/");   
  }
  public static void Circle(){
    Top();
    Bottom();
  }
}
