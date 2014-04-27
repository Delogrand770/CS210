
/**
 * Prints a phrase 1000x using static methods to shorten the code.
 * Since I'm limited to material from this lesson no loops were used.
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 10, 2011 at 10:40:26 AM
 */
public class EX13 {

  public static void main(String[] args) {
    Phrase1000();
    //LoopMethod();
  }
  public static void Phrase(){
    System.out.println("All work and no play makes Jack a dull boy.");
  }
  public static void Phrase10(){
    Phrase();
    Phrase();
    Phrase();
    Phrase();
    Phrase();
    Phrase();
    Phrase();
    Phrase();
    Phrase();
    Phrase();
  }
  public static void Phrase100(){
    Phrase10();
    Phrase10();
    Phrase10();
    Phrase10();
    Phrase10();
    Phrase10();
    Phrase10();
    Phrase10();
    Phrase10();
    Phrase10();
  }
    public static void Phrase1000(){
    Phrase100();
    Phrase100();
    Phrase100();
    Phrase100();
    Phrase100();
    Phrase100();
    Phrase100();
    Phrase100();
    Phrase100();
    Phrase100();
  }
  public static void LoopMethod(){
    for (int i=0;i<999;i++){
     Phrase(); 
    }
  }
}
