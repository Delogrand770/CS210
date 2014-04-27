
/**
 * EX12 - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 5, 2011 at 10:32:51 PM
 */
public class EX12 {

  public static void main(String[] args) {
    System.out.println(getGrade(0.0));
    System.out.println(getGrade(0.7));
    System.out.println(getGrade(4.0));
    System.out.println(getGrade(3.9));
    System.out.println(getGrade(3.8));
    System.out.println(getGrade(3.7));
    System.out.println(getGrade(1.0));
  }

  public static String getGrade(double grade) {
    String score = "";
    double calc = 0;
    if (grade == 0.0) {
      score = "< 60";
    } else if (grade == 0.7) {
      score = "60-62";
    } else if (grade == 4.0) {
      score = ">=95";
    } else {
      calc = 95 - ((4.0 - grade) * 10);
      score = "" + (int) calc;
    }
    return score;
  }
}
