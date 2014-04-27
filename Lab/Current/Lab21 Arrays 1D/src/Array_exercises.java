
/**
 * Solve a series of problems using arrays
 * 
 * @author Wayne.Brown
 * 
 * @version 1.0 - Sep 29, 2011 at 5:15:01 PM
 */
public class Array_exercises {

  public static void main(String[] args) {

    int[] alpha;

    alpha = createRandomArray(15, 1, 5);
    printArray("alpha", alpha);

    for (int test = 1; test <= 5; test++) {
      System.out.printf("%d was found at location %d\n", test,
                        lastIndexOf(alpha, test));
    }

    int[] rangeArray = {100, 50, 25, 75, 33, 2, 1};
    System.out.println("Range is " + range(rangeArray));
    System.out.println("Data in range of 1 and 75 in the array rangeArray " + countInRange(rangeArray, 1, 75));

    int[] sorted = {1, 2, 3, 4};
    int[] unsorted = {1, 2, 3, 2};
    System.out.println("Is the array sorted? " + isSorted(sorted));
    System.out.println("Is the array sorted? " + isSorted(unsorted));

    int[] testdata = {3, 3, 27, 15, 15, 11, 27};
    System.out.println("The mode of the array testdata is " + mode(testdata));
  }

  /**
  Takes and array of integers and returns the most repeated integer in that array.
  
  @param data an array of integers
  @return the most repeated integer
   */
  public static int mode(int[] data) {
    int[] uniques = new int[data.length];
    int[] totals = new int[data.length];
    int unique_index = 0;

    for (int index = 0; index < data.length; index++) {
      int lookup_index = lastIndexOf(uniques, data[index]);
      if (lookup_index == -1) {
        uniques[unique_index] = data[index];
        totals[unique_index]++;
        unique_index++;
      } else {
        totals[lookup_index]++;
      }
    }

    int mostFrequent = -1;
    for (int index = 0; index < totals.length; index++) {
      mostFrequent = (index == 0 || totals[index] > totals[mostFrequent]
                      || (totals[index] == totals[mostFrequent] && uniques[mostFrequent] > uniques[index])) ? index : mostFrequent;
    }

    return uniques[mostFrequent];
  }

  /**
  Takes and array of integers and determines if they are in order from smallest to greatest
  
  @param data is an array of integers
  @return true or false
   */
  public static boolean isSorted(int[] data) {
    boolean sorted = true;
    for (int index = 1; index < data.length; index++) {
      if (data[index] < data[index - 1]) {
        sorted = false;
        break;
      }
    }
    return sorted;
  }

  /**
  Takes an array of integers, an upper integer and a lower integer. Then calculates the number of elements within the
  range of the upper and lower integers.
  
  @param data is an array of integers
  @param min is an integer describing the lower end of the range
  @param max is an integer describing the upper end of the range
  @return an integer of the number of elements falling withing the range
   */
  public static int countInRange(int[] data, int min, int max) {
    int count = 0;
    for (int index = 0; index < data.length; index++) {
      count += (data[index] >= min && data[index] <= max) ? 1 : 0;
    }
    return count;
  }

  /**
  Takes an array of integers and returns the range of the data
  
  @param data is an array of integers
  @return an integer that is the range of the array
   */
  public static int range(int[] data) {
    int highest = 0;
    int lowest = 0;
    for (int index = 0; index < data.length; index++) {
      highest = (data[index] > highest || index == 0) ? data[index] : highest;
      lowest = (data[index] < lowest || index == 0) ? data[index] : lowest;
    }
    return (highest - lowest + 1);
  }

  /**
  Takes an array of integers and an integer to search for. Returns the last position in the
  array where the test integer occurs.
  
  @param data is an array of integers
  @param test is an integer that will be searched for in the array
  @return 
   */
  public static int lastIndexOf(int[] data, int test) {
    int lastIndex = -1;
    for (int index = 0; index < data.length; index++) {
      lastIndex = (data[index] == test) ? index : lastIndex;
    }
    return lastIndex;
  }

  /**
   * Creates an integer array of the specified size and fills it with 
   * random values in the range [minValue, maxValue] inclusive.
   * 
   * @param size The desired size of the integer array
   * @param minValue The minimum value of any element in the array.
   * @param maxValue The maximum value of any element in the array.
   * @return The array that was created.
   */
  public static int[] createRandomArray(int size, int minValue, int maxValue) {
    int[] array = new int[size];

    for (int j = 0; j < size; j++) {
      array[j] = minValue + (int) (Math.random() * (maxValue - minValue + 1));
    }

    return array;
  }

  /**
   * Prints all the elements of an integer array on a single line. The
   * array is labeled using the specified name. A line above the array
   * elements is printed to show the index/location of each element.
   * 
   * @param name A string to display that labels the array.
   * @param a The integer array to be printed.
   */
  public static void printArray(String name, int[] a) {

    if (a.length > 0) {
      // Print the indexes so that the position of an element is easy determined.
      System.out.printf("%" + name.length() + "s   ", " ");
      for (int j = 0; j < a.length; j++) {
        System.out.printf("%6d", j);
      }
      System.out.println();

      // Print the element values
      System.out.printf("%s : ", name);
      System.out.printf("  %4d", a[0]);
      for (int j = 1; j < a.length; j++) {
        System.out.printf(", %4d", a[j]);
      }
    }
    System.out.println();
  }
}
