
/**
 * EX3 - Returns the season based on the day and month provided
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 5, 2011 at 10:32:37 PM
 */
public class EX3 {

  public static void main(String[] args) {
    System.out.println(season(31, 1));
  }

  public static String season(int day, int month) {
    String season = "";

    //winter test
    if (month <= 3 || month == 12) {
      if (month == 12 && day >= 16) {
        season = "winter";
      } else if (month == 3 && day <= 15) {
        season = "winter";
      } else if (month != 3 && month != 12) {
        season = "winter";
      }
    }

    //spring test
    if (month >= 3 && month <= 6) {
      if (month == 3 && day >= 16) {
        season = "spring";
      } else if (month == 6 && day <= 15) {
        season = "spring";
      } else if (month != 6 && month != 3) {
        season = "spring";
      }
    }

    //summer test
    if (month >= 6 && month <= 9) {
      if (month == 6 && day >= 16) {
        season = "summer";
      } else if (month == 9 && day <= 15) {
        season = "summer";
      } else if (month != 6 && month != 9) {
        season = "summer";
      }
    }

    //fall test
    if (month >= 9 && month <= 12) {
      if (month == 9 && day >= 16) {
        season = "fall";
      } else if (month == 12 && day <= 15) {
        season = "fall";
      } else if (month != 9 && month != 12) {
        season = "fall";
      }
    }

    return season;
  }
}
