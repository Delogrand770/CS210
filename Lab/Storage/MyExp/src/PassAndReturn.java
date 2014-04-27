
/**
 * <put a program description here>
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 8, 2011 at 4:58:18 PM
 */
public class PassAndReturn {

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(Combined('*', i));
    }

    Pass('A', 7);

    System.out.println(PassBack(10)); //Should return number squared

    System.out.println(Combined('G', 5));
  }

  public static void Pass(char let, int num) {
    for (int i = 0; i < num; i++) {
      System.out.print(let);
    }
    System.out.println("");
  }

  public static int PassBack(int num) {
    return num * num;
  }

  public static String Combined(char let, int num) {
    String text = "";
    for (int i = 0; i < num; i++) {
      text += let;
    }
    return text;
  }
}
