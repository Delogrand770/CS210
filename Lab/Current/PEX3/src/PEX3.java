
/**
 * PEX3 - A visualization tool for stars and constellation data.
 * Documentation: I did not receive help on this assignment.
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Sep 28, 2011 at 9:44:44 AM
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Scanner;
import java.io.*;

public class PEX3 {

  public static final String STARFILE = "stars.txt";
  public static final String[][] CONSTLIST = {{"BigDipper.txt", "Big Dipper"},
                                              {"Bootes.txt", "Bootes"},
                                              {"Cassiopeia.txt", "Cassiopeia"},
                                              {"Cygnet.txt", "Cygnet"},
                                              {"Gemini.txt", "Gemini"},
                                              {"Hydra.txt", "Hydra"},
                                              {"UrsaMajor.txt", "Usra Major"},
                                              {"UrsaMinor.txt", "Ursa Minor"}};
  public static final int INFOWIN_HEIGHT = 90;
  public static final int INFOWIN_WIDTH = 440;
  public static final int STARWIN_HEIGHT = 700;
  public static final int STARWIN_WIDTH = 700;
  public static final int STARSIZE = 2;
  public static final Color[] COLORS = {new Color(50, 153, 204), //blue
                                        new Color(255, 36, 0), //red
                                        new Color(255, 192, 203)}; //pink
  public static final int CONSTSTARCOLOR = 0;
  public static final int HOVERCOLOR = 1;
  public static final int CONSTCOLOR = 2;
  public static DrawingPanel starwin = new DrawingPanel(STARWIN_WIDTH, STARWIN_HEIGHT);
  public static DrawingPanel infowin = new DrawingPanel(INFOWIN_WIDTH, INFOWIN_HEIGHT);
  public static String[][] stardata; //starindex, starinfo
  public static String[][][] constdata; //constilation, line of file, stars in line
  public static String[] nostar = {"nostar"};
  public static int laststar = -1; //last star info displayed
  public static int lastX = -1; //last mouseX
  public static int lastY = -1; //last mouseY
  public static String parentConst; //current constilation name
  public static int parentConstIndex; //current constilation index
  public static double brightestValue = -1;
  public static int mouseX; //holds current mouse x position
  public static int mouseY; //holds current mouse y position

  public static void main(String[] args) {
    //initilization
    initPanels();
    loadStarData();
    loadConstData();
    drawStars();
    updateInfoPanel(nostar);
    starwin.copyGraphicsToScreen();
    infowin.copyGraphicsToScreen();
    starLookup(0, 0);

    //main loop
    loop();
  }

  public static void loop() {
    //constantly look for mouse movements
    while (true) {
      int x = 0; //array position
      int y = 1; //array position
      mouseX = starwin.getMouseX();
      mouseY = starwin.getMouseY();

      if (lastX != mouseX || lastY != mouseY) { //prevents unnecessary updates when mouse is stationary
        lastX = mouseX;
        lastY = mouseY;

        starwin.setBackground(Color.black);
        drawStars();

        starLookup(mouseX, mouseY);
        starwin.copyGraphicsToScreen();
        infowin.copyGraphicsToScreen();
      }
    }
  }

  public static void initPanels() {
    starwin.setBackground(Color.black);
    infowin.setBackground(Color.white);
    starwin.setWindowTitle("Star Map");
    infowin.setWindowTitle("Active Star Information");
  }

  public static void loadStarData() {
    try {

      File filename = new File(STARFILE);
      int lines = fileLines(filename);
      stardata = new String[lines][];
      Scanner datafile = new Scanner(filename);
      int index = 0;

      while (datafile.hasNextLine()) {
        String linedata = datafile.nextLine();
        Scanner tokens = new Scanner(linedata);
        String namedata = "";
        String numdata = "";
        boolean areNames = false;

        //sorts the linedata into name and number data
        while (tokens.hasNext()) {
          if (!tokens.hasNextDouble()) {
            areNames = true;
            namedata += tokens.next() + " ";
          } else {
            numdata += tokens.next() + " ";
          }
        }

        //split the names into an array
        String namelist[] = namedata.split(";");

        //split the numbers into and array
        String size[] = numdata.split(" ");

        //Sets the length of stardata[index] properly based on if there are names or not
        stardata[index] = (areNames) ? new String[size.length + namelist.length] : new String[size.length];

        //copies the number data into stardata[index]
        System.arraycopy(size, 0, stardata[index], 0, size.length);

        //if there are names, copy them into stardata[index]
        if (areNames) {
          System.arraycopy(namelist, 0, stardata[index], stardata[index].length - namelist.length, namelist.length);

          //trims white space of the names
          for (int nameNum = 6; nameNum < stardata[index].length; nameNum++) {
            stardata[index][nameNum] = stardata[index][nameNum].trim();
          }

        }

        //check to see if this is the brightest star
        double thisBrightness = getBrightDouble(index);
        brightestValue = (thisBrightness > brightestValue) ? thisBrightness : brightestValue;

        index++;
      }
    } catch (IOException error) {
      System.out.println("Error in processing the file " + STARFILE + "\n" + error);
    }
  }

  public static void loadConstData() {
    int filename = 0; //array position
    int index = 0;
    constdata = new String[8][][];
    try {
      File currentFile;
      for (index = 0; index < CONSTLIST.length; index++) {
        currentFile = new File(CONSTLIST[index][filename]);
        Scanner datafile = new Scanner(currentFile);
        constdata[index] = new String[fileLines(currentFile)][2]; //assign constdata proper length

        int line = 0;
        while (datafile.hasNextLine()) {
          int star1 = 0; //array position
          int star2 = 1; //array position
          String linedata = datafile.nextLine();
          constdata[index][line] = linedata.split(",");

          //leading and trailing white space cause problems. This removes that space
          constdata[index][line][0] = constdata[index][line][star1].trim();
          constdata[index][line][1] = constdata[index][line][star2].trim();
          line++;
        }

      }
    } catch (IOException error) {
      System.out.println("Error in processing the file " + CONSTLIST[index][filename] + "\n" + error);
    }
  }

  public static void drawStars() {
    for (int index = 0; index < stardata.length; index++) {
      int x = 0; //array position
      int y = 1; //array position
      if (getBrightDouble(index) > 0.0) { //is star brighter than 0
        int color = (constellationLookup(index)) ? CONSTSTARCOLOR : -1;
        drawStar(stardata[index][x], stardata[index][y], color, index);
      }
    }
  }

  public static void drawStar(String coordX, String coordY, int colorIndex, int starIndex) {
    int x = 0; //array position
    int y = 1; //array position
    int pixels[] = toPixel(coordX, coordY);

    Graphics2D g = starwin.getGraphics();
    float starBrightness = (float) (getBrightDouble(starIndex) / (float) brightestValue);
    if (colorIndex == -1) { //varies the star color based on the stars brightness
      g.setColor(new Color(starBrightness, starBrightness, starBrightness));
    } else {
      g.setColor(COLORS[colorIndex]);
    }

    g.fillRect(pixels[x], pixels[y], STARSIZE, STARSIZE);
  }

  public static void starLookup(int xPixel, int yPixel) {
    int closestStar = -1;
    int smallestDistance = STARWIN_HEIGHT * STARWIN_WIDTH;
    int x = 0; //array position
    int y = 1; //array position

    for (int index = 0; index < stardata.length; index++) {
      int pixels[] = toPixel(stardata[index][x], stardata[index][y]);
      int distance = distanceFormula(mouseX, mouseY, pixels[0], pixels[1]);
      if (getBrightDouble(index) > 0.0 && distance < smallestDistance) {
        smallestDistance = distance;
        closestStar = index;
      }
    }

    laststar = closestStar;
    updateInfoPanel(stardata[closestStar]);
    drawStar(stardata[closestStar][x], stardata[closestStar][y], HOVERCOLOR, closestStar);
  }

  public static int distanceFormula(double x1, double y1, double x2, double y2) {
    return (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
  }

  public static boolean constellationLookup(int star) {
    boolean inConst = false;
    for (int index = 0; index < constdata.length; index++) { //look through all constellations
      for (int pair = 0; pair < constdata[index].length; pair++) { //look through all data in constellation
        for (int nameNum = 6; nameNum < stardata[star].length; nameNum++) { //compare to all names of star
          parentConst = "noconst";
          parentConstIndex = -1;
          if (constdata[index][pair][0].equalsIgnoreCase(stardata[star][nameNum]) || constdata[index][pair][1].equalsIgnoreCase(stardata[star][nameNum])) {
            int constname = 1; //array position
            inConst = true;
            parentConst = CONSTLIST[index][constname];
            parentConstIndex = index;
            return inConst;
          }
        }
      }
    }
    return inConst;
  }

  public static void updateInfoPanel(String data[]) {
    int x = 0; //array position
    int y = 1; //array position
    int z = 2; //array position
    int hdn = 3; //array position
    int brightness = 4; //array position
    int hrn = 5; //array position

    infowin.setBackground(Color.white);
    Graphics2D g = infowin.getGraphics();
    g.setFont(new Font("courier new", Font.PLAIN, 12));
    g.drawString("Name(s)               : ", 5, 14);
    g.drawString("Location              : ", 5, 28);
    g.drawString("Henry Draper Number   : ", 5, 42);
    g.drawString("Star Brightness       : ", 5, 56);
    g.drawString("Harvard Revised Number: ", 5, 70);
    g.drawString("Constellation         : ", 5, 84);
    if (data.length != 1) {
      g.drawString("(" + data[x] + ", " + data[y] + ", " + data[z] + ")", 170, 28);
      g.drawString(data[hdn], 170, 42);
      g.drawString(data[brightness], 170, 56);
      g.drawString(data[hrn], 170, 70);
      if (laststar != -1 && constellationLookup(laststar) && parentConstIndex != -1) {
        g.drawString(parentConst, 170, 84); //for constellation info
        drawConstellation(parentConstIndex);
      }

      //Draw star names if any
      if (data.length > 5) {
        String names = "";
        for (int index = 6; index < data.length; index++) {
          names += data[index];
          names += (index < data.length - 1) ? ", " : "";
        }
        g.drawString(names, 170, 14);
      }

    }
  }

  public static void drawConstellation(int index) {
    Graphics2D g = starwin.getGraphics();
    g.setColor(COLORS[CONSTCOLOR]);
    for (int entry = 0; entry < constdata[index].length; entry++) {
      int x = 0; //array position
      int y = 1; //array position
      int star1 = 0; //array position
      int star2 = 1; //array position
      int star1Index = getStarIndex(constdata[index][entry][star1]);
      int star2Index = getStarIndex(constdata[index][entry][star2]);

      String star1X = stardata[star1Index][x];
      String star1Y = stardata[star1Index][y];
      String star2X = stardata[star2Index][x];
      String star2Y = stardata[star2Index][y];
      int star1Pixels[] = toPixel(star1X, star1Y);
      int star2Pixels[] = toPixel(star2X, star2Y);

      g.drawLine(star1Pixels[x], star1Pixels[y], star2Pixels[x], star2Pixels[y]);
    }
  }

  public static int getStarIndex(String name) {
    int index = 0;
    for (index = 0; index < stardata.length; index++) {
      for (int nameNum = 6; nameNum < stardata[index].length; nameNum++) { //compare to all names of star
        if (stardata[index][nameNum].equalsIgnoreCase(name)) {
          return index;
        }
      }
    }
    //only reachable if given a bad name
    //assigns an out of bound index to show this error
    index = -1;
    return index;
  }

  public static double getBrightDouble(int index) {
    int brightness = 4; //array position
    return Double.parseDouble(stardata[index][brightness]);
  }

  public static int[] toPixel(String coordX, String coordY) {
    double x = Double.parseDouble(coordX);
    double y = Double.parseDouble(coordY);
    int pixelx = STARWIN_WIDTH - (int) (((1.0 - x) / 2.0) * STARWIN_WIDTH);
    int pixely = (int) (((1.0 - y) / 2.0) * STARWIN_HEIGHT);
    int pixels[] = {pixelx, pixely};
    return pixels;
  }

  public static int fileLines(File filename) {
    int lines = 0;
    try {
      Scanner datafile = new Scanner(filename);
      while (datafile.hasNextLine()) {
        datafile.nextLine();
        lines++;
      }
    } catch (IOException error) {
      System.out.println("Error in processing the file " + filename + "\n" + error);
    }
    return lines;
  }
}