// File: Background.java
// Author: Dr. Watts
// Contents: This file contains the implementation of a small
// GUI application that uses the Shape class hierarchy.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.*;

public class Background extends JPanel implements ActionListener, MouseMotionListener, MouseListener
{
	private JButton saveButton, loadButton;
	private JFrame outside;
	private boolean inFrame = true;
	private int currentX, currentY;
	private ArrayList <Shape> S = new ArrayList <Shape> ();
	private Shape selected = null;

	public Background ()
	{
		repaint();
	}
	public Background (JFrame frame, String [] files)
	{
		outside = frame;
		saveButton = new JButton ("Save Shapes");
		add (saveButton);
		saveButton.addActionListener (this);
		loadButton = new JButton ("Load Shapes");
		add (loadButton);
		loadButton.addActionListener (this);
		setBackground (Color.BLACK);
		addMouseMotionListener(this);
		addMouseListener(this);
		ShapeIO shapeIO = new ShapeIO ();
		for (int i = 0; i < files.length; i++)
		{
			shapeIO.readShapes (files[i], S);
		}
		repaint();
	}
	public void mouseDragged(MouseEvent e)
	{
		//System.out.println ("Mouse dragged to " + e.getX() + ", " + e.getY());
		if (inFrame && selected != null)
		{
			//System.out.println ("Moving " + selected);
			selected.move (e.getX() - currentX, e.getY() - currentY);
			repaint();
		}
		currentX = e.getX();
		currentY = e.getY();
	}
	public void mouseMoved(MouseEvent e) {}
	public void paintComponent (Graphics g)
	{
		super.paintComponent (g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < S.size(); i++)
		{
			S.get(i).paintComponent (g2);
		}
	}
	public void actionPerformed (ActionEvent e)
	{
		if (e.getSource() == saveButton)
		{
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Shape files", "sio");
			chooser.setFileFilter(filter);
			if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
			{
				// Gets the path to the where the file will be saved at
				String filename = chooser.getSelectedFile().getAbsolutePath();
				int period = filename.lastIndexOf ('.');
				String extension = new String();
				// Returns the file extension
				if (period > 0)
					extension = filename.substring (period);
				// Sets the file extension to .sio if not already set
				if (!extension.equalsIgnoreCase (".sio"))
					filename += ".sio";
				ShapeIO shapeIO = new ShapeIO ();
				shapeIO.writeShapes (filename, S);
			}
			// ShapeIO shapeIO = new ShapeIO ();
			// shapeIO.writeShapes ("SavedShapes.io", S);
		}
		if (e.getSource() == loadButton)
     	{
         JFileChooser chooser = new JFileChooser();
         FileNameExtensionFilter filter = new FileNameExtensionFilter("Shape files", "sio");
         chooser.setFileFilter(filter);
		 if (chooser.showOpenDialog(outside) == JFileChooser.APPROVE_OPTION)
		 {
			String filename = chooser.getSelectedFile().getAbsolutePath();
			ShapeIO shapeIO = new ShapeIO ();
			shapeIO.readShapes (filename, S);
			}
			repaint();
		 }
		 
		}
	
		
	public void mousePressed (MouseEvent e)
	{
		//System.out.println ("Mouse pressed at " + e.getX() + ", " + e.getY());
		inFrame = true;
		currentX = e.getX();
		currentY = e.getY();
		selected = null;
		if (e.getButton() == e.BUTTON1) // Left mouse button
		{
			//System.out.println ("BUTTON1 pressed at " + e.getX() + ", " + e.getY());
			for (int i = S.size()-1; selected == null && i >= 0; i--)
				if (S.get(i).isIn(currentX, currentY))
				{
					selected = S.get(i);
						//System.out.println ("Selected " + selected.getName() + "; " + selected);
				}
		}
		else if (e.getButton() == e.BUTTON3) // Right mouse button
		{
			//System.out.println ("BUTTON3 pressed at " + e.getX() + ", " + e.getY());
			for (int i = S.size()-1; selected == null && i >= 0; i--)
				if (S.get(i).isIn(currentX, currentY))
				{
					selected = S.get(i);
						//System.out.println ("Selected " + selected.getName() + "; " + selected);
				}
			if (selected != null)
					selected.modifyShape (outside, e.getX(), e.getY());
			else
			{	
				ShapeDialog shapedialog = new ShapeDialog(outside, true, e.getX(), e.getY());
				//ShapeDialog shapedialog = new ShapeDialog(this, true, e.getX(), e.getY());
				if (shapedialog.getAnswer() == true)
				{
					Shape newshape = shapedialog.getNewShape();
					S.add(newshape);
					newshape.setCenterX(e.getX());
					newshape.setCenterY(e.getY());
					newshape.modifyShape (outside, e.getX(), e.getY());
				}
			}
			repaint();
		}
	}
	public void mouseReleased (MouseEvent e) {}
	public void mouseEntered (MouseEvent e) 
	{
		inFrame = true;
	}
	public void mouseExited (MouseEvent e)
	{
		inFrame = false;
		selected = null;
	}
	public void mouseClicked (MouseEvent e) {}
}
