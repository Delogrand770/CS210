
/**
 * Calcs Percent stuff based on investements using params
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 22, 2011 at 10:49:52 AM
 */
public class PJ2_1 {

  public static void main(String[] args) {
    Interest(6.5, 25, 1000, 100);
  }

  public static void Interest(double percent, double years, double invest, double deposits) {
    percent /= 100;
    double calc = invest;
    for (int i = 1; i < years + 1; i++) {
      calc += (calc * percent) + deposits;
      calc = ((int) calc * 100.0) / 100;
      System.out.println("Year " + i + "    Bal $" + ((int) (calc - ((calc * percent) + deposits)) * 100.0) / 100.0 + "    IRate " + (percent * 100) + "%    EarnedI $" + (calc * percent) + "    NewBal $" + calc);
    }
    System.out.println();
  }
}
