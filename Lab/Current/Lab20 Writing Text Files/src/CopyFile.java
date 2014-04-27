
/**
 * CopyFile - GIven a source and destination file it will perform a file copy operation.
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 28, 2011 at 10:47:38 AM
 */
import java.io.*;
import java.util.Scanner;

public class CopyFile {

  public static void main(String[] args) {
    Scanner ask = new Scanner(System.in);
    File fs = getInputFile(ask, "Enter a file to copy: "); //source file
    File fd = getOutputFile(ask, "Enter the copied files name: "); //destination file
    String fs_data = ""; //string that holds fs data
    try {
      PrintStream output = new PrintStream(fd);
      Scanner input = new Scanner(fs);
      while (input.hasNextLine()) {
        fs_data += input.nextLine() + "\r\n";
      }
      output.print(fs_data);
      System.out.println("File " + fs + " copied to file " + fd);
    } catch (IOException error) {
      System.out.println("Error in processing the file. " + error);
    }
  }

  public static File getInputFile(Scanner console, String prompt) {
    File f;
    do {
      System.out.print(prompt);
      String fileName = console.nextLine();

      f = new File(fileName);
      if (!f.isFile() || !f.canRead()) {
        System.out.println("Sorry, but that is not a valid input file name");
      }
    } while (!f.isFile() || !f.canRead());

    return f;
  }

  public static File getOutputFile(Scanner console, String prompt) {
    File f = null;
    boolean validFile = false;
    do {
      System.out.print(prompt);
      String fileName = console.nextLine();

      try {
        f = new File(fileName);
        if (f.isFile() && f.exists() && f.length() > 0) {
          System.out.print("A file by that name already exists. Do you want to overwrite the file? ");
          String overwrite = console.nextLine();
          if (overwrite.toLowerCase().equalsIgnoreCase("y")
              || overwrite.toLowerCase().equalsIgnoreCase("yes")) {
            validFile = true;
          }
        } else if (f.createNewFile()) { // test for a valid file name
          f.delete();
          f = new File(fileName);
          validFile = true;
        } else {
          System.out.println("Sorry. That is not a valid file name. ");
          System.out.println("Make sure you are not using any special characters in the name. ");
        }
      } catch (IOException error) {
        System.out.println("Sorry. That is not a valid file name. ");
        System.out.println("Make sure you are not using any special characters in the name. ");
      }
    } while (!validFile);
    return f;
  }
}