
/**
 * SimpleIfElse - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 1, 2011 at 8:53:50 AM
 */
public class SimpleIfElse {

  public static void main(String[] args) {
    int a = 1;
    int b = 1;
    int c = (a == 0) ? 1 : (b == 1) ? 1 : 0;
    if (a == 0) {
      c = 1;
    } else {
      if (b == 1) {
        c = 1;
      } else {
        c = 0;
      }
    }
    
    System.out.println(c);
  }
}
