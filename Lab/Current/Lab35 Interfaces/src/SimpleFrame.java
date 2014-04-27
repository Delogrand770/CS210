
/**
 * Description: Opens a window frame. (Example from textbook page 830.)
 *
 * @author Textbook
 *
 * @version 1.0   Fall 2008
 */
import java.awt.*;      // for Dimension, Point, and Color classes
import javax.swing.*;   // for GUI components
import java.awt.event.*; //For events

public class SimpleFrame implements MouseListener, KeyListener {

  JFrame frame;
  JPanel panel;
  Point mouseLocation;

  public SimpleFrame() {
    panel = new JPanel();
    frame = new JFrame();
    frame.setForeground(Color.WHITE);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(10, 50);
    frame.setSize(300, 300);
    frame.setTitle("A frame");
    frame.setLayout(new BorderLayout());
    frame.add(panel, BorderLayout.CENTER);
    frame.setVisible(true);
    panel.addMouseListener(this);
    //frame.addKeyListener(this);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println("The mouse was clicked");
  }

  @Override
  public void mouseExited(MouseEvent e) {
    System.out.println("The mouse exited");
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    System.out.println("The mouse entered");
  }

  @Override
  public void mousePressed(MouseEvent e) {
    System.out.println("mouse pressed");
    mouseLocation = e.getPoint();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    System.out.println("mouse released");
    Point mouseFinal = e.getPoint();
    Graphics g = panel.getGraphics();
    g.setColor(Color.red);
    g.drawLine(mouseLocation.x, mouseLocation.y, mouseFinal.x, mouseFinal.y);
    
  }

  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println("key was typed");
  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println("key was pressed");
  }

  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println("key was released");
  }

  //-------------------------------------------------------------------
  // Client code
  public static void main(String[] args) {
    new SimpleFrame();
  }
}
