// File: ShapeIO.java
// Author: Dr. Watts
// Contents: This file contains a class called ShapeIO that can be used to read a file of
// shape descriptions or write a file of shape descriptions.

import java.io.*;
import java.util.*;
import java.lang.*;
import java.awt.*;

public class ShapeIO
{
	public ShapeIO ()
	{
	}

	public void readShapes (String fileName, ArrayList <Shape> shapeList)
	{
		try
		{
			BufferedReader inFile = new BufferedReader (new FileReader (fileName));
			String string = inFile.readLine();
			int count = Integer.parseInt (string);
			Shape shape = new Shape ();
			for (int i = 0; i < count; i++)
			{
				String name = inFile.readLine();
				string = inFile.readLine();
				if (name.equals("Circle"))
					shape = new Circle ();
				else if (name.equals("Square"))
					shape = new Square ();
				else if (name.equals("Rectangle"))
					shape = new Rectangle ();
				else if (name.equals("Equilateral"))
					shape = new Equilateral ();
				else if (name.equals("Right"))
					shape = new Right ();
				else if (name.equals("Scalene"))
					shape = new Scalene ();
				shape.fromString (string);
				shapeList.add (shape);
			}
			inFile.close();
		}
		catch (IOException e)
		{
			System.out.println ("Error reading file " + fileName);
		}
		catch (NumberFormatException e)
		{
			System.out.println ("Numeric input error in " + fileName);
		}
	}

	public void writeShapes (String fileName, ArrayList <Shape> shapeList)
	{
		try
		{
			BufferedWriter outFile = new BufferedWriter(new FileWriter(fileName));
			outFile.write (((Integer)shapeList.size()).toString());
			outFile.newLine ();
			for (int i = 0; i < shapeList.size(); i++)
			{
				outFile.write (shapeList.get(i).getName());
				outFile.newLine ();
				outFile.write (shapeList.get(i).toString());
				outFile.newLine ();
			}
			outFile.close();
		}
		catch (IOException e)
		{
			System.out.println ("Error writing file " + fileName);
		}
	}

	public static void main (String[] args)
	{
		ShapeIO shapeIO = new ShapeIO ();
		ArrayList <Shape> S = new ArrayList <Shape> ();
		shapeIO.readShapes (args[0], S);
		/*
		S.add (new Square (20, 100, 250, Color.BLUE));
		S.add (new Square (30, 200, 250, Color.RED));
		S.add (new Square (40, 300, 250, Color.GREEN));
		S.add (new Circle (50, 100, 100, Color.PINK));
		S.add (new Circle (70, 200, 100, Color.ORANGE));
		S.add (new Circle (47, 300, 100, new Color (82, 8,125)));
		S.add (new Right (40, 80, 100, 350, Color.MAGENTA));
		S.add (new Right (60, 60, 200, 350, Color.YELLOW));
		S.add (new Right (80, 40, 300, 350, Color.CYAN));
		S.add (new Equilateral (20, 100, 450, Color.BLUE));
		S.add (new Equilateral (30, 200, 450, Color.RED));
		S.add (new Equilateral (40, 300, 450, Color.GREEN));
		S.add (new Rectangle (40, 80, 100, 300, Color.MAGENTA));
		S.add (new Rectangle (60, 60, 200, 300, Color.YELLOW));
		S.add (new Rectangle (80, 40, 300, 300, Color.CYAN));
		S.add (new Scalene (40, 80, 70, 100, 400, Color.MAGENTA));
		S.add (new Scalene (60, 60, 70, 200, 400, Color.YELLOW));
		S.add (new Scalene (80, 40, 110, 300, 400, Color.CYAN));
		*/
		S.add (new Square (70, 300, 450, Color.YELLOW));
		S.add (new Circle (30, 100, 100, Color.GREEN));
		S.add (new Equilateral (40, 300, 450, Color.GREEN));
		S.add (new Equilateral (40, 200, 450, Color.GREEN));
		S.add (new Rectangle (40, 20, 300, 300, Color.BLUE));
		S.add (new Rectangle (40, 20, 300, 300, Color.BLUE));
		S.add (new Equilateral (40, 300, 450, Color.RED));
		shapeIO.writeShapes (args[1], S);
	}
}
