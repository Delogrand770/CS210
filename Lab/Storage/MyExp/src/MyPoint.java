
/**
 * Point - 
 *
 * @author C14Gavin.Delphia
 *
 * @version 1.0 - Aug 24, 2011 at 2:13:40 PM
 */
public class MyPoint {

  int x = 0;
  int y = 0;
  int height = 10;
  int width = 10;
  private int count = 0;

  public MyPoint(int ix, int iy) {
    x = ix;
    y = iy;
  }

  public MyPoint(int ix, int iy, int ih, int iw) {
    x = ix;
    y = iy;
    height = ih;
    width = iw;
  }
  
  public int Area(){
    return width*height;
  }
  
  public void Move(int newx, int newy){
    this.x = newx;
    this.y = newy;
  }
  
  public void Count(){
    count++;
  }
  
  public int GetCount(){
    return count;
  }
}
