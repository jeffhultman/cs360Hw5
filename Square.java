// File: Square.java
// Author: Dr. Watts
// Contents: This file contains the description and implementation
// of a class called Square.

import static java.lang.Math.*;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;

public final class Square extends Quadrilateral
{
	public Square ()
	{
	}

	public Square (int S, int X, int Y, Color C)
	{
		side = S;
		centerX = X;
		centerY = Y;
		color = C;
	}

	public Square (Square C)
	{
		side = C.side;
		centerX = C.centerX;
		centerY = C.centerY;
		color = C.color;
		for (int i = 0; i < 3; i++)
		{
			vertexX[i] = C.vertexX[i];
			vertexY[i] = C.vertexY[i];
		}
	}

	public void setSide (int S)
	{
		side = S;
	}

	public int getSide ()
	{
		return side;
	}

	public double area ()
	{
		return side * side;
	}

	public double perimeter ()
	{
		return 4 * side;
	}

	public String getName ()
	{
		return "Square";
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
			angle = Double.parseDouble (parts[4]);
		}
		catch (NumberFormatException e)
		{
			System.out.println ("Numeric input error");
		}
	}

	public String toString ()
	{
		String string = new String ();
		string += centerX + " ";
		string += centerY + " ";
		string += side + " ";
		string += color.getRGB() + " ";
		string += angle + " ";
		return string;
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
	public void setVertices()
  {
    //   doubleVertexX[0] = (centerX + (side / 2));
    //   doubleVertexX[1] = (centerX - (side / 2));
    //   doubleVertexX[2] = (centerX - (side / 2));
    //   doubleVertexX[3] = (centerX + (side / 2));
    //   doubleVertexY[0] = (centerY - (side / 2));
    //   doubleVertexY[1] = (centerY - (side / 2));
    //   doubleVertexY[2] = (centerY + (side / 2));
    //   doubleVertexY[3] = (centerY + (side / 2));
    // vertexX[0] = (int) (doubleVertexX[0]);
    // vertexX[1] = (int) (doubleVertexX[1]);
    // vertexX[2] = (int) (doubleVertexX[2]);
    // vertexX[3] = (int) (doubleVertexX[3]);
    // vertexY[0] = (int) (doubleVertexY[0]);
    // vertexY[1] = (int) (doubleVertexY[1]);
    // vertexY[2] = (int) (doubleVertexY[2]);
    // vertexY[3] = (int) (doubleVertexY[3]);
    vertexX[0] = (centerX + (side / 2));
	vertexX[1] = (centerX - (side / 2));
	vertexX[2] = (centerX - (side / 2));
	vertexX[3] = (centerX + (side / 2));
	vertexY[0] = (centerY - (side / 2));
	vertexY[1] = (centerY - (side / 2));
	vertexY[2] = (centerY + (side / 2));
	vertexY[3] = (centerY + (side / 2));
	polygon = new Polygon (vertexX, vertexY, 4);
	AffineTransform at = new AffineTransform();
	at.rotate(angle, centerX, centerY);
  }

	public void paintComponent (Graphics2D g2)
	{
		g2.setPaint (color);
		g2.fillRect (centerX-side/2, centerY-side/2, side, side);

		g2.drawRect (centerX-side/2, centerY-side/2, side, side);
		g2.setPaint (Color.BLACK);
		g2.fillOval (centerX-1, centerY-1, 2, 2); // Draw the center point
	}

	public boolean isIn (int X, int Y)
	{
		int deltaX = Math.abs (X - centerX);
		int deltaY = Math.abs (Y - centerY);
		if (deltaX <= side/2 && deltaY <= side/2)
			return true;
		return false;
	}
}
