// File: Scalene.java
// Author: Dr. Watts
// Contents: This file contains the description and implementation
// of a class called Scalene. 

import static java.lang.Math.*;
import java.awt.*;

public final class Scalene extends Triangle
{
	private int side2;
	private int side3;

	public Scalene ()
	{
		side2 = 0;
		side3 = 0;
	}

	public Scalene (Scalene S)
	{
		side = S.side;
		side2 = S.side2;
		side3 = S.side3;
		centerX = S.centerX;
		centerY = S.centerY;
		color = S.color;
		for (int i = 0; i < 3; i++)
		{
			vertexX[i] = S.vertexX[i];
			vertexY[i] = S.vertexY[i];
		}
	}

	public Scalene (int S1, int S2, int S3, int X, int Y, Color C)
	{
		side = S1;
		side2 = S2;
		side3 = S3;
		centerX = X;
		centerY = Y;
		color = C;
		setVertices ();
	}

	public void setVertices ()
	{
		double cosAngle = (side * side + side2 * side2 - side3 * side3) / (2.0 * side * side2);
		double angle = acos (cosAngle);
		int height = (int) (sin(angle) * side2);
		int offX = (int) (cos(angle) * side2);
		//System.out.println (cosAngle + "; " + angle + "; " + height + "; " + offX);
		vertexX[0] = vertexY[0] = 0;
		vertexX[1] = offX; vertexY[1] = -height;
		vertexX[2] = side; vertexY[2] = 0;
		int inX = (vertexX[0]* side3 + vertexX[1] * side + vertexX[2] * side2) / (int) perimeter();
		int inY = (vertexY[0]* side3 + vertexY[1] * side + vertexY[2] * side2) / (int) perimeter();
		for (int i = 0; i < 3; i++)
		{
			vertexX[i] += (centerX - inX);
			vertexY[i] += (centerY - inY);
		}
		polygon = new Polygon (vertexX, vertexY, 3);
	}

	public void setSide1 (int S1)
	{
		side = S1;
		setVertices ();
	}

	public int getSide1 ()
	{
		return side;
	}

	public void setSide2 (int S2)
	{
		side2 = S2;
		setVertices ();
	}

	public int getSide2 ()
	{
		return side2;
	}

	public void setSide3 (int S3)
	{
		side3 = S3;
		setVertices ();
	}

	public int getSide3 ()
	{
		return side3;
	}

	public double perimeter ()
	{
		return side + side2 + side3;
	}

	public double area ()
	{
		double h = (side + side2 + side3) / 2.0;
		return sqrt (h * (h-side) * (h-side2) * (h-side3));
	}

	public String getName ()
	{
		return "Scalene";
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
			side3 = Integer.parseInt(parts[4]);
			color = new Color(Integer.parseInt(parts[5]));
			angle = Double.parseDouble (parts[6]);
			setVertices ();
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
		string += side3 + " ";
		string += color.getRGB() + " ";
		string += angle + " ";
		return string;
	}
}	
