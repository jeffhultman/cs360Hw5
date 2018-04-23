// File: Rectangle.java
// Author: Dr. Watts
// Contents: This file contains the description and implementation
// of a class called Rectangle. 

import static java.lang.Math.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;

public final class Rectangle extends Quadrilateral
{
	private int side2;

	public Rectangle ()
	{
		side2 = 0;
	}

	public Rectangle (Rectangle R)
	{
		side = R.side;
		side2 = R.side2;
		centerX = R.centerX;
		centerY = R.centerY;
		color = R.color;
	}

	public Rectangle (int S1, int S2, int X, int Y, Color C)
	{
		side = S1;
		side2 = S2;
		centerX = X;
		centerY = Y;
		color = C;
	}

	public void setSide1 (int S1)
	{
		side = S1;
	}

	public int getSide1 ()
	{
		return side;
	}

	public void setSide2 (int S2)
	{
		side2 = S2;
	}

	public int getSide2 ()
	{
		return side2;
	}

	public double perimeter ()
	{
		return 2 * (side + side2);
	}

	public double area ()
	{
		return side * side2;
	}

	public String getName ()
	{
		return "Rectangle";
	}

	public void setVertices()
    {
   
      doubleVertexX[0] = (centerX + (side / 2));
      doubleVertexX[1] = (centerX - (side / 2));
      doubleVertexX[2] = (centerX - (side / 2));
      doubleVertexX[3] = (centerX + (side / 2));
      doubleVertexY[0] = (centerY - (side2 / 2));
      doubleVertexY[1] = (centerY - (side2 / 2));
      doubleVertexY[2] = (centerY + (side2 / 2));
      doubleVertexY[3] = (centerY + (side2 / 2));
  
      vertexX[0] = (int) (doubleVertexX[0]);
      vertexX[1] = (int) (doubleVertexX[1]);
      vertexX[2] = (int) (doubleVertexX[2]);
      vertexX[3] = (int) (doubleVertexX[3]);
      vertexY[0] = (int) (doubleVertexY[0]);
      vertexY[1] = (int) (doubleVertexY[1]);
      vertexY[2] = (int) (doubleVertexY[2]);
	  vertexY[3] = (int) (doubleVertexY[3]);

	  rotate(angle);
      polygon = new Polygon (vertexX, vertexY, 4);
		//System.out.println(vertexX[0] + " " + vertexY[0]);

    }

	public void fromString (String str)
	{
		String [] parts = str.split (" ");
		try
		{
			System.out.println("from Rect");
			centerX = Integer.parseInt(parts[0]);
			centerY = Integer.parseInt(parts[1]);
			side = Integer.parseInt(parts[2]);
			side2 = Integer.parseInt(parts[3]);
			color = new Color(Integer.parseInt(parts[4]));
			angle = Double.parseDouble (parts[5]);
			setVertices();
		}
		catch (NumberFormatException e)
		{
			System.out.println ("File input error - invalid integer");;
		}
	}

	public String toString ()
	{
		String string = new String ();
		string += centerX + " ";
		string += centerY + " ";
		string += side + " ";
		string += side2 + " ";
		string += color.getRGB() + " ";
		string += angle + " ";
		return string;
	}
	
	

  public void rotate(double degs)
  {
    double transX, transY = 0;

    for (int i = 0; i < 4; i++)
    {
      transX = doubleVertexX[i] - centerX;
      transY = doubleVertexY[i] - centerY;
      // System.out.println(transX);
      doubleVertexX[i] = (transX * Math.cos(Math.toRadians(degs)) - transY * Math.sin(Math.toRadians(degs)));
      doubleVertexY[i] = (transX * Math.sin(Math.toRadians(degs)) + transY * Math.cos(Math.toRadians(degs)));
      // System.out.println(doubleVertexX[i] + " " + i + " ");

      doubleVertexX[i] += centerX;
      doubleVertexY[i] += centerY;
      // System.out.println(doubleVertexX[i] + " " + i + " ");
    }

    for (int i = 0; i < 4; i++)
    {
      vertexX[i] = (int) doubleVertexX[i];
      vertexY[i] = (int) doubleVertexY[i];
      // System.out.println(vertexX[i] + " " + i + " ");

    }
    polygon = new Polygon(vertexX, vertexY, 4);
    // System.out.println("Rotate!");
  }

	public void modifyShape (JFrame frame, int x, int y)
	{
		RectangleDialog rectangledialog = new RectangleDialog (frame, true, x, y, side, side2, angle); 
		if (rectangledialog.getAnswer() == true)
		{
			side = rectangledialog.getSide ();
			side2 = rectangledialog.getSide2();
			angle = rectangledialog.getAngle ();
			color = rectangledialog.getColor ();
			setVertices ();
		}
	}

	public boolean isIn (int X, int Y)
	{
		int deltaX = Math.abs (X - centerX);
		int deltaY = Math.abs (Y - centerY);
		if (deltaX <= side/2 && deltaY <= side2/2)
			return true;
		return false;
	}
}
