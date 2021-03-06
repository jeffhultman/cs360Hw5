import static java.lang.Math.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;

public final class Square extends Quadrilateral
{
  

  public Square(int S, int X, int Y, Color C)
  {
    side = S;
    centerX = X;
    centerY = Y;
    color = C;
  }
  public void setVertices()
  {
    
    doubleVertexX[0] = (centerX + (side / 2));
    doubleVertexX[1] = (centerX - (side / 2));
    doubleVertexX[2] = (centerX - (side / 2));
    doubleVertexX[3] = (centerX + (side / 2));
    doubleVertexY[0] = (centerY - (side / 2));
    doubleVertexY[1] = (centerY - (side / 2));
    doubleVertexY[2] = (centerY + (side / 2));
    doubleVertexY[3] = (centerY + (side / 2));
    
    vertexX[0] = (int) (doubleVertexX[0]);
    vertexX[1] = (int) (doubleVertexX[1]);
    vertexX[2] = (int) (doubleVertexX[2]);
    vertexX[3] = (int) (doubleVertexX[3]);
    vertexY[0] = (int) (doubleVertexY[0]);
    vertexY[1] = (int) (doubleVertexY[1]);
    vertexY[2] = (int) (doubleVertexY[2]);
    vertexY[3] = (int) (doubleVertexY[3]);
    //tempSide = Math.sqrt(Math.pow(vertexX[1] - vertexX[0], 2) + Math.pow(vertexY[1] - vertexY[0], 2));
    rotate(angle);
    polygon = new Polygon (vertexX, vertexY, 4);

  }
  public Square()
  {

  }
  public Square(Square S)
  {
    side = S.side;
    color = S.color;
    centerX = S.centerX;
    centerY = S.centerY;
  }
  public Square(int S)
  {
    side = S;
  }
  public void setSide(int S)
  {
    side = S;
  }
  public double getSide()
  {
    return side;
  }
  public double perimeter()
  {
    return side * 4;
  }
  public double area()
  {
    return side * side;
  }
  public String getName()
  {
    return "Square";
  }
  public void modifyShape (JFrame frame, int x, int y)
	{
		SquareDialog squaredialog = new SquareDialog (frame, true, x, y, side, angle); 
		if (squaredialog.getAnswer() == true)
		{
			side = squaredialog.getSide ();
			angle = squaredialog.getAngle ();
			color = squaredialog.getColor ();
			setVertices ();
		}
	}
  public void fromString (String str)
  {
    String [] parts = str.split (" ");
    try
    {
      centerX = Integer.parseInt(parts[0]);
      centerY = Integer.parseInt(parts[1]);
      side = Integer.parseInt(parts[2]);
      color = new Color(Integer.parseInt(parts[3]));
      setVertices();
     
    }
    catch (NumberFormatException e)
    {
      //System.out.println ("Numeric input error");
    }
  }
  public String toString ()
  {
    String string = new String ();
    string += centerX + " ";
    string += centerY + " ";
    string += side + " ";
    string += color.getRGB() + " ";
    
    return string;
  }


}
