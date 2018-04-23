// File: Triangle.java
// Author: Dr. Watts
// Contents: This file contains the description and implementation
// of a class called Triangle. 

import java.awt.*;

public class Triangle extends Shape
{
	protected int [] vertexX = new int [3];
	protected int [] vertexY = new int [3];
	
    protected double [] dist = new double [3];
	protected Polygon polygon = new Polygon (vertexX, vertexY, 3);
	protected double angle = 0.0;

	Triangle ()
	{
	}

	public void setCenterX (int X)
	{
		centerX = X;
		setVertices ();
	}

	public void setCenterY (int Y)
	{
		centerY = Y;
		setVertices ();
	}

	public String getName ()
	{
		return "Triangle";
	}

	public void paintComponent (Graphics2D g2)
	{
		g2.setPaint (color);
		g2.fillPolygon (vertexX, vertexY, 3);
		g2.drawPolygon (vertexX, vertexY, 3);
		g2.setPaint (Color.BLACK);
		g2.fillOval (centerX-1, centerY-1, 2, 2); // Draw the center point
	}

	protected void setVertices ()
	{
	}

	public void rotate(double degs)
    {
        double transX, transY = 0;
        for (int i = 0; i < 3; i++)
        {
            transX = vertexX[i] - centerX;
            transY = vertexY[i] - centerY;
            vertexX[i] = (int) (transX * Math.cos(Math.toRadians(degs)) - transY * Math.sin(Math.toRadians(degs)));
            vertexY[i] = (int) (transX * Math.sin(Math.toRadians(degs)) + transY * Math.cos(Math.toRadians(degs)));
            vertexX[i] += centerX;
            vertexY[i] += centerY;
        }

       
        polygon = new Polygon(vertexX, vertexY, 3);

    }

	public boolean isIn (int X, int Y)
	{
		return polygon.contains (X, Y);
	}

	public void move (int deltaX, int deltaY)
	{
		centerX += deltaX;
		centerY += deltaY;
		setVertices ();
	}
}
