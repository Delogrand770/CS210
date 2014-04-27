
/**
 * SketchPadWindow - Main Window for a sketch pad. Also contains the client code and MyCanvas Class.
 * @author C14Gavin.Delphia
 * Documentation: I used the DrawingPanel as an example to implement the paint and buffered images. This includes the MyCancas class and methods
 * such as copyGraphicsToScreen(), paint() and setBackground(). I also copied the saveGraphics() method so I could implement a save functionality.
 * The contains() method in my shape classes are derived from the corresponding methods in the existing 2D shape classes that are built into Java.
 *
 * @version 1.0 - Nov 16, 2011 at 10:13:03 AM
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SketchPadWindow implements MouseListener, ActionListener, ItemListener, MouseMotionListener {

  private Color[] colorList = {Color.red, Color.orange, Color.yellow,
                               Color.green, Color.blue, Color.magenta,
                               Color.black, Color.pink, Color.gray};
  private String[][] menuStrings = {{"File", "Clear", "Save", "Quit"},
                                    {"Shapes", "Rectangle", "Triangle", "Circle", "Ellipse"},
                                    {"Color", "Red", "Orange", "Yellow", "Green", "Blue", "Magenta", "Black", "Pink", "Gray"},
                                    {"Mode", "Drawing", "Edit Position", "Change Color", "Delete"}};
  //Components
  private JFrame frame;
  private JPanel infoPanel;
  private Point mouseStart = null;
  private Point mouseEnd = null;
  private JMenuBar menubar;
  private JLabel infoLabel;
  private MyCanvas canvas;
  private BufferedImage image;
  private Graphics2D g;
  //Settings
  private String shape = "Rectangle";
  private String mode = "Drawing";
  private String color = "Black";
  private String currentMenu = "";
  private int winHeight;
  private int winWidth;
  private int shapeInHand = -1;
  //Shape Data
  private Object[] shapeList = new Object[100];
  private int shapeListIndex = 0;
  //Constants
  private final boolean FILL = true;
  private final boolean NOFILL = false;

  //Constructor--------------------------------------------------------
  public SketchPadWindow(int height, int width) {
    winHeight = height;
    winWidth = width;

    image = new BufferedImage(winWidth, winHeight, BufferedImage.TYPE_INT_RGB);
    g = image.createGraphics();
    g.setColor(Color.BLACK);
    
    frame = new JFrame();
    frame.setForeground(Color.WHITE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(10, 50);
    frame.setSize(width, height);
    frame.setTitle("Sketch Pad");
    frame.setLayout(new BorderLayout());
    frame.setResizable(false);

    menubar = menuSetup();
    frame.add(menubar, BorderLayout.NORTH);

    infoPanel = new JPanel();
    infoPanel.setBackground(Color.GRAY);
    infoLabel = new JLabel();
    infoLabel.setForeground(Color.white);
    updateInfoBar();
    infoPanel.add(infoLabel);
    frame.add(infoPanel, BorderLayout.SOUTH);

    canvas = new MyCanvas(this);
    canvas.setPreferredSize(new Dimension(width, height));
    canvas.setBounds(0, 0, width, height);
    canvas.setBackground(Color.WHITE);
    canvas.addMouseListener(this);
    canvas.addMouseMotionListener(this);
    frame.add(canvas, BorderLayout.CENTER);

    frame.setVisible(true);
    setBackground(Color.WHITE);
  }

  /**
  Returns a JMenuBar with all the proper JMenus and JMenuItems based off the variable menuStrings[][].
  @return 
   */
  private JMenuBar menuSetup() {
    JMenuBar newMenuBar = new JMenuBar();
    JMenu[] menus = new JMenu[menuStrings.length];
    JMenuItem[][] items = new JMenuItem[menuStrings.length][];

    for (int i = 0; i < menuStrings.length; i++) {
      menus[i] = new JMenu(menuStrings[i][0]);
      items[i] = new JMenuItem[menuStrings[i].length];

      for (int j = 1; j < items[i].length; j++) {
        items[i][j] = new JMenuItem(menuStrings[i][j]);
        menus[i].add(items[i][j]);
        items[i][j].addActionListener(this);
        menus[i].addItemListener(this);
      }

      newMenuBar.add(menus[i]);
    }
    return newMenuBar;
  }

  /**
  Updates the blue bar on the bottom of the screen based on the current program mode.
   */
  public final void updateInfoBar() {
    String message = "";
    if (mode.equalsIgnoreCase("Edit Position")) {
      message = "Click and drag to move a shape";
    } else if (mode.equalsIgnoreCase("Delete")) {
      message = "Click on a shape to delete it";
    } else if (mode.equalsIgnoreCase("Change Color")) {
      message = "Click a shape to turn it " + color;
    } else if (mode.equalsIgnoreCase("Drawing")) {
      message = "Click and drag to draw a " + color + " " + shape;
    }
    infoLabel.setText(message);
  }

  /**
  Handles all the filling and outlines of the shapes.
  @param e - Mouse Event
  @param type  - Determines if to fill (add to shapeList) or draw (show shape outline) the shape.
   */
  public void shapeAction(MouseEvent e, boolean type) {
    if (mode.equalsIgnoreCase("Drawing")) {

      if (!type) {
        drawAllShapes();
      }

      if (mouseStart != null || type) {
        mouseEnd = e.getPoint();
        int width = Math.abs(mouseStart.x - mouseEnd.x);
        int height = Math.abs(mouseStart.y - mouseEnd.y);
        if (shape.equalsIgnoreCase("Rectangle")) {
          Point pointX = (mouseStart.x <= mouseEnd.x) ? mouseStart : mouseEnd;
          Point pointY = (mouseStart.y <= mouseEnd.y) ? mouseStart : mouseEnd;
          Rectangle newRect = new Rectangle(pointX.x, pointY.y, g.getColor(), height, width, type);
          if (type && shapeListIndex < shapeList.length) {
            shapeList[shapeListIndex] = newRect;
            shapeListIndex++;
          } else {
            newRect.draw(g);
          }
        } else if (shape.equalsIgnoreCase("Circle")) {
          int size = (width >= height) ? width : height;
          int offset = (int) (size / 2);
          Ellipse newCircle = new Ellipse(mouseStart.x - offset, mouseStart.y - offset, g.getColor(), size, size, type);
          if (type && shapeListIndex < shapeList.length) {
            shapeList[shapeListIndex] = newCircle;
            shapeListIndex++;
          } else {
            newCircle.draw(g);
          }
        } else if (shape.equalsIgnoreCase("Ellipse")) {
          int offsetX = (int) (width / 2);
          int offsetY = (int) (height / 2);
          Ellipse newEllipse = new Ellipse(mouseStart.x - offsetX, mouseStart.y - offsetY, g.getColor(), height, width, type);
          if (type && shapeListIndex < shapeList.length) {
            shapeList[shapeListIndex] = newEllipse;
            shapeListIndex++;
          } else {
            newEllipse.draw(g);
          }
        } else if (shape.equalsIgnoreCase("Triangle")) {
          Triangle newTriangle = new Triangle(mouseStart.x, mouseStart.y, g.getColor(), width, height, type);
          if (type && shapeListIndex < shapeList.length) {
            shapeList[shapeListIndex] = newTriangle;
            shapeListIndex++;
          } else {
            newTriangle.draw(g);
          }
        }

        if (type) {
          mouseStart = null;
          drawAllShapes();
        } else {
          copyGraphicsToScreen();
        }
      }
    }
  }

  /**
  Copies all shape data in the shapeList into the offscreen buffer and then updates the screen.
   */
  public void drawAllShapes() {
    setBackground(Color.WHITE);
    for (int i = 0; i < shapeListIndex; i++) {
      if (shapeList[i] instanceof Rectangle) {
        Rectangle drawRect = (Rectangle) shapeList[i];
        drawRect.draw(g);
      } else if (shapeList[i] instanceof Ellipse) {
        Ellipse drawEllipse = (Ellipse) shapeList[i];
        drawEllipse.draw(g);
      } else if (shapeList[i] instanceof Triangle) {
        Triangle drawTriangle = (Triangle) shapeList[i];
        drawTriangle.draw(g);
      }
    }
    copyGraphicsToScreen();
  }

  /**
  Clears the shapeList of all shapes and calls drawAllShapes().
   */
  public void clearShapes() {
    for (int i = 0; i < shapeList.length; i++) {
      shapeList[i] = null;
      shapeListIndex = 0;
    }
    drawAllShapes();
  }

  /**
  Used to get the index of where in menuStrings[2] a test string is.
  @param test - The string to look for.
  @return the index or -1 if not found.
   */
  public int indexOfColor(String test) {
    int index = -1;
    for (int i = 1; i < menuStrings[2].length; i++) {
      if (menuStrings[2][i].equalsIgnoreCase(test)) {
        index = i;
      }
    }
    return index;
  }

//Save and load Graphics-----------------------------------------------
  /**
  Prompts the user for a valid file name to save the image.
   */
  public void saveSketch() {
    boolean invalid = true;
    while (invalid) {
      String ask = JOptionPane.showInputDialog("Enter a file name", "Sketch.bmp");
      if (ask.split(".bmp").length == 1 && ask.contains(".bmp")) {
        invalid = false;
        saveGraphics(ask);
        JOptionPane.showMessageDialog(null, "Save Successful!");
      }
    }
  }

  /**
  Saves the offscreen buffer into a .bmp image.
  @param filename - The filename to save the image as.
   */
  public void saveGraphics(String filename) {
    String extension = filename.substring(filename.lastIndexOf(".") + 1);
    try {
      ImageIO.write(image, extension, new java.io.File(filename));
    } catch (java.io.IOException e) {
      JOptionPane.showMessageDialog(null, "Unable to save image:\n" + e);
    }
  }

  @Override
  /**
  Handles the shape color changes and deletion.
   */
  public void mouseClicked(MouseEvent e) {
    boolean delete = (mode.equalsIgnoreCase("Delete")) ? true : false;
    if (mode.equalsIgnoreCase("Change Color") || mode.equalsIgnoreCase("Delete")) {
      Point currentPoint = e.getPoint();
      for (int i = 0; i < shapeList.length; i++) {
        if (shapeList[shapeList.length - 1 - i] instanceof Rectangle) {
          Rectangle newRect = (Rectangle) shapeList[shapeList.length - 1 - i];
          if (newRect.contains(currentPoint)) {
            newRect.setColor(g.getColor());
            if (delete) {
              shapeList[shapeList.length - 1 - i] = null;
            }
            drawAllShapes();
            break;
          }
        } else if (shapeList[shapeList.length - 1 - i] instanceof Ellipse) {
          Ellipse newEllipse = (Ellipse) shapeList[shapeList.length - 1 - i];
          if (newEllipse.contains(currentPoint)) {
            newEllipse.setColor(g.getColor());
            if (delete) {
              shapeList[shapeList.length - 1 - i] = null;
            }
            drawAllShapes();
            break;
          }
        } else if (shapeList[shapeList.length - 1 - i] instanceof Triangle) {
          Triangle newTriangle = (Triangle) shapeList[shapeList.length - 1 - i];
          if (newTriangle.contains(currentPoint)) {
            newTriangle.setColor(g.getColor());
            if (delete) {
              shapeList[shapeList.length - 1 - i] = null;
            }
            drawAllShapes();
            break;
          }
        }
      }
    }
  }

  //Implements---------------------------------------------------------
  @Override
  public void mouseExited(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  /**
  Handles the movement of shapes.
   */
  public void mousePressed(MouseEvent e) {
    mouseStart = e.getPoint();
    if (mode.equalsIgnoreCase("Edit Position")) {
      for (int i = 0; i < shapeList.length; i++) {
        if (shapeList[shapeList.length - 1 - i] instanceof Rectangle) {
          Rectangle newRect = (Rectangle) shapeList[shapeList.length - 1 - i];
          if (newRect.contains(mouseStart)) {
            shapeInHand = shapeList.length - 1 - i;
            break;
          }
        } else if (shapeList[shapeList.length - 1 - i] instanceof Ellipse) {
          Ellipse newEllipse = (Ellipse) shapeList[shapeList.length - 1 - i];
          if (newEllipse.contains(mouseStart)) {
            shapeInHand = shapeList.length - 1 - i;
            break;
          }
        } else if (shapeList[shapeList.length - 1 - i] instanceof Triangle) {
          Triangle newTriangle = (Triangle) shapeList[shapeList.length - 1 - i];
          if (newTriangle.contains(mouseStart)) {
            shapeInHand = shapeList.length - 1 - i;
            break;
          }
        }
      }
    }
  }

  @Override
  /**
  Handles the drawing of shapes and the releasing of moving shapes.
   */
  public void mouseReleased(MouseEvent e) {
    shapeAction(e, FILL);
    shapeInHand = -1;
  }

  @Override
  /**
  Handles the outline drawing of shapes and the moving of shapes.
   */
  public void mouseDragged(MouseEvent e) {
    shapeAction(e, NOFILL);
    if (mode.equalsIgnoreCase("Edit Position") && shapeInHand != -1) {
      if (shapeList[shapeInHand] instanceof Rectangle) {
        Rectangle newRect = (Rectangle) shapeList[shapeInHand];
        newRect.setX(e.getX() - (int) (newRect.getWidth() / 2));
        newRect.setY(e.getY() - (int) (newRect.getHeight() / 2));
        drawAllShapes();
      } else if (shapeList[shapeInHand] instanceof Ellipse) {
        Ellipse newEllipse = (Ellipse) shapeList[shapeInHand];
        newEllipse.setX(e.getX() - (int) (newEllipse.getWidth() / 2));
        newEllipse.setY(e.getY() - (int) (newEllipse.getHeight() / 2));
        drawAllShapes();
      } else if (shapeList[shapeInHand] instanceof Triangle) {
        Triangle newTriangle = (Triangle) shapeList[shapeInHand];
        newTriangle.setX(e.getX() - (int) (newTriangle.getWidth() / 64)); //64 is the magic number that gets the centerX of the triangle
        newTriangle.setY(e.getY() - (int) (newTriangle.getHeight()));
        newTriangle.setCoords();
        drawAllShapes();
      }
    }
  }

  @Override
  /**
  Determines which JMenu was last used.
   */
  public void itemStateChanged(ItemEvent e) {
    currentMenu = e.getSource().toString();
    currentMenu = currentMenu.split("text=")[1].split("]")[0];
  }

  @Override
  public void mouseMoved(MouseEvent e) {
  }

  @Override
  /**
  Determines which JMenuItem was clicked and handles the event accordingly.
   */
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    if (currentMenu.equalsIgnoreCase("File")) {
      if (command.equalsIgnoreCase("Quit")) {
        frame.dispose();
        return;
      } else if (command.equalsIgnoreCase("Clear")) {
        clearShapes();
      } else if (command.equalsIgnoreCase("Save")) {
        saveSketch();
      }
    } else if (currentMenu.equalsIgnoreCase("Shapes")) {
      shape = command;
      mode = "Drawing";
    } else if (currentMenu.equalsIgnoreCase("Mode")) {
      mode = command;
    } else if (currentMenu.equalsIgnoreCase("Color")) {
      color = command;
      int index = indexOfColor(color) - 1;
      g.setColor(colorList[index]);
    }
    updateInfoBar();
  }

//Client Code----------------------------------------------------------
  /**
  Client code to start a SketchPadWindow();
  @param args 
   */
  public static void main(String[] args) {
    SketchPadWindow mainWindow = new SketchPadWindow(600, 800);
  }

  //Extended Canvas for paint -----------------------------------------
  /**
  Class to extend canvas so that it can implement the paint method.
   */
  class MyCanvas extends Canvas {

    private SketchPadWindow panel;

    public MyCanvas(SketchPadWindow thisPanel) {
      super();
      panel = thisPanel;
    }

    @Override
    public void paint(Graphics g) {
      panel.copyGraphicsToScreen();
    }
  }

  //Graphic methods----------------------------------------------------
  /**
  Sets the background color of the canvas.
  @param c 
   */
  public final void setBackground(Color c) {
    Color currentColor = g.getColor();
    g.setColor(c);
    g.fillRect(0, 0, winWidth, winHeight);
    g.setColor(currentColor);
  }

  /**
  Copies the offscreen image buffer data to the screen.
   */
  public void copyGraphicsToScreen() {
    Graphics2D myG = (Graphics2D) canvas.getGraphics();
    myG.drawImage(image, 0, 0, winWidth, winHeight, null);
  }
}