//=====================================================================
// File       : Drawing_fun.java
// By         : Dr. Brown      Date: Fall 2011
// Description: Draw a series of enclosing rectangles rotated about the
//              center of the window.
//=====================================================================

import java.awt.*;
import java.util.Scanner;

public class Drawing_fun
{
  public static void main(String[] args)
  {
    // Create a window to draw graphics into
    int panelWidth = 300;
    int panelHeight = 300;

    DrawingPanel panel = new DrawingPanel(panelWidth, panelHeight);
    panel.setBackground(Color.WHITE);
    Graphics2D g = panel.getGraphics();
    panel.copyGraphicsToScreen();
    
    // Initialize the size and position of a rectangle
    int xCenter = panelWidth / 2;
    int yCenter = panelHeight / 2;
    
    int rectangleWidth  = (int) (panelWidth * 0.6);
    int rectangleHeight = (int) (panelHeight * 0.6);
    
    int rectangleCornerX = xCenter - rectangleWidth/2;
    int rectangleCornerY = yCenter - rectangleHeight/2;
    
    // Draw a series of rectangles at different rotations
    g.setColor(Color.RED);
    double angle = 0.0;
    while (angle < Math.PI/2)
    {
      // Draw a single rectangle
      g.drawRect(rectangleCornerX, rectangleCornerY, rectangleWidth, rectangleHeight);
      // Increase the angle of the rectangle
      angle += Math.PI / 100;
      g.rotate(angle, xCenter, yCenter);
      
      // Update the screen and then pause for 300 milliseconds (0.2 seconds)
      panel.copyGraphicsToScreen();
      panel.sleep(50);
    }     
  }
}