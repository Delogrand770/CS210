
/**
 * PJ2 - Converts decimal to Roman numerals
 * Documentation: Looked up in Wikipedia the other Roman numeral symbols
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 5, 2011 at 10:33:04 PM
 */
public class PJ2 {

  public static void main(String[] args) {
    System.out.println(toRoman(4375)); //cascading if statement version
    System.out.println(toRoman2(2356)); //array version
  }

  public static String toRoman(int num) {
    String roman = "";
    int calc = num;
    if (num == 0){
      roman = "N";
    }
    while (calc != 0) {
      if (calc >= 1000) {
        calc -= 1000;
        roman += "M";
      } else if (calc >= 900) {
        calc -= 900;
        roman += "CM";
      } else if (calc >= 500) {
        calc -= 500;
        roman += "D";
      } else if (calc >= 400) {
        calc -= 400;
        roman += "CD";
      } else if (calc >= 100) {
        calc -= 100;
        roman += "C";
      } else if (calc >= 90) {
        calc -= 90;
        roman += "XC";
      } else if (calc >= 50) {
        calc -= 50;
        roman += "L";
      } else if (calc >= 40) {
        calc -= 40;
        roman += "XL";
      } else if (calc >= 10) {
        calc -= 10;
        roman += "X";
      } else if (calc >= 9) {
        calc -= 9;
        roman += "IX";
      } else if (calc >= 5) {
        calc -= 5;
        roman += "V";
      } else if (calc >= 4) {
        calc -= 4;
        roman += "IV";
      } else if (calc >= 1) {
        calc -= 1;
        roman += "I";
      }
    }
    return roman;
  }

  public static String toRoman2(int num) {
    String roman = (num==0)?"N":"";
    int calc = num;
    int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    if (num == 0){
      roman = "N";
    }
    while (calc != 0) {
      for (int i = 0; i < vals.length; i++) {
        if (calc >= vals[i]) {
          calc -= vals[i];
          roman += chars[i];
          break; // without this, it doesn't use the fewest numerals
        }
      }
    }
    return roman;
  }
}
