
/**
 * Exercises on arrays for lesson 23
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Oct 6, 2011 at 2:22:21 PM
 */
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Exercises_on_arrays {

  public static void main(String[] args) {

    try {
      Scanner getData = new Scanner(new File("Exercise13_data.txt"));
      while (getData.hasNextLine()) {
        int[] data = createArrayFromString(getData.nextLine());
        System.out.println(Arrays.toString(data));
        System.out.println("Longest sorted sequence: " + longestSortedSequence(data));
        System.out.println();
      }
    } catch (IOException error) {
      System.out.printf("Error reading data file: error was %s\n", error);
    }

    try {
      Scanner getData = new Scanner(new File("Exercise14_data.txt"));
      while (getData.hasNextLine()) {
        int[] data = createArrayFromString(getData.nextLine());
        int[] test = createArrayFromString(getData.nextLine());
        System.out.println("Contains: " + contains(data, test));
        System.out.println();
      }
    } catch (IOException error) {
      System.out.printf("Error reading data file: error was %s\n", error);
    }

    int[] data1 = {1, 2, 3, 4, 5};
    int[] data2 = {5, 4, 3, 2, 1};
    int[] apended = append(data1, data2);
    System.out.println(Arrays.toString(apended));
  }

  public static int[] append(int[] data1, int[] data2) {
    int[] apended = new int[data1.length + data2.length];
    System.arraycopy(data1, 0, apended, 0, data1.length);
    System.arraycopy(data2, 0, apended, data1.length, data2.length);
    return apended;
  }

  public static boolean contains(int[] data, int[] test) {
    int size = test.length;
    boolean testpass = false;
    for (int i = 0; i < data.length; i++) {
      testpass = false;
      if (i + size < data.length) {
        testpass = true;
        for (int j = 0; j < test.length; j++) {
          if (data[i + j] != test[j]) {
            testpass = false;
          }
        }
        if (testpass) {
          break;
        }
      }
    }
    return testpass;
  }

  public static int longestSortedSequence(int[] data) {
    int currCount = 0;
    int bestCount = 0;
    int lastNum = 0;
    boolean newSet = true;
    for (int index = 0; index < data.length; index++) {
      if (newSet || data[index] > lastNum) {
        currCount++;
        newSet = false;
        lastNum = data[index];
        bestCount = (currCount > bestCount) ? currCount : bestCount;
      } else {
        currCount = 1;
        bestCount = (currCount > bestCount) ? currCount : bestCount;
        newSet = true;
      }
    }
    return bestCount;
  }

  //-------------------------------------------------------------------
  /**
   * Given a string with a series of integer values, comma separated,
   * create an array of integers that contains the data.
   * 
   * @param data A string that contains a comma separated list of integers.
   * @return An array of integers.
   */
  public static int[] createArrayFromString(String data) {

    // Read the values out of the string and count how many there are.
    Scanner countValues = new Scanner(data);
    countValues.useDelimiter(",");
    int count = 0;
    while (countValues.hasNext()) {
      countValues.next();
      count++;
    }

    // Create an array of the appropriate size.
    int[] array = new int[count];

    // Replace all the commas with white space so we can read the integers
    data = data.replaceAll(",", " ");

    // Read the data out of the string and into the array.
    Scanner getValues = new Scanner(data);
    int index = 0;
    while (getValues.hasNextInt()) {
      array[index++] = getValues.nextInt();
    }

    return array;
  }
}
