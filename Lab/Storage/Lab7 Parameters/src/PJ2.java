
/**
 * Calcs Percent stuff based on investements no params
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 22, 2011 at 10:49:52 AM
 */
public class PJ2 {

  public static void main(String[] args) {
    Interest();
  }

  public static void Interest() {
    double percent = 6.5;
    percent /= 100;
    double years = 25;
    double invest = 1000;
    double deposits = 100;
    double calc = 1000;
    for (int i = 1; i < years + 1; i++) {
      calc += (calc * percent) + deposits;
      System.out.println("Year " + i + "    Bal $" + (calc - ((calc * percent) + deposits)) + "    IRate " + (percent * 100) + "%    EarnedI $" + (calc * percent) + "    NewBal $" + calc);
    }
    System.out.println();
  }
}
