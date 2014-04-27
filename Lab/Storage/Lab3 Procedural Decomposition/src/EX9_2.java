
/**
 * Exercise 9 but added a new method to demonstrate the varying ways to accomplish the task.
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 10, 2011 at 10:24:19 AM
 */
public class EX9_2 {

  public static void main(String[] args) {
     Circle();
     System.out.println();
     Middle();
     Circle();
     System.out.println();
     Middle();
     Bottom();
     System.out.println();
     Circle2();
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
  public static void Circle2(){
    Top();
    Middle();
    Bottom();
  }
}

//There are probably infinite ways to break this problem down.