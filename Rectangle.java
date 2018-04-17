// File: Rectangle.java
// Author: Dr. Watts
// Contents: This file contains the description and implementation
// of a class called Rectangle. 

import static java.lang.Math.*;
import java.awt.*;

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

	public void fromString (String str)
	{
		String [] parts = str.split (" ");
		try
		{
			centerX = Integer.parseInt(parts[0]);
			centerY = Integer.parseInt(parts[1]);
			side = Integer.parseInt(parts[2]);
			side2 = Integer.parseInt(parts[3]);
			color = new Color(Integer.parseInt(parts[4]));
			angle = Double.parseDouble (parts[5]);
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
	
	public void paintComponent (Graphics2D g2)
	{
		g2.setPaint (color);
		g2.fillRect (centerX-side/2, centerY-side2/2, side, side2);
		g2.drawRect (centerX-side/2, centerY-side2/2, side, side2);
		g2.setPaint (Color.BLACK);
		g2.fillOval (centerX-1, centerY-1, 2, 2); // Draw the center point
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
