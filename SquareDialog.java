// cs360 Proj
// Square.Dialog.java

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SquareDialog extends JDialog implements ActionListener
{
  private JPanel myPanel = null;
 	private JButton OKButton = null, cancelButton = null;
	private JTextField sideText;
	private JRadioButton redRButton = null, orangeRButton = null,
			yellowRButton = null, greenRButton = null,
			blueRButton = null, purpleRButton = null,
			whiteRButton = null, grayRButton = null,
			blackRButton = null;
	private ButtonGroup shapeGroup= null, colorGroup = null;
	private ColorPanel colorPanel = null;
	private JPanel buttonPanel = null;
	private Color currentColor = Color.red;
	private int oldSide = 0;
	private int side = 0;
 	private boolean answer = false;
 	public Color getColor() { return currentColor; }
 	public int getSide() { return side; }
 	public boolean getAnswer() { return answer; }

  public SquareDialog(JFrame frame, boolean modal, int x, int y, int S)
	{
 		super(frame, modal);
		oldSide = S;
 		myPanel = new JPanel();
		getContentPane().add(myPanel);
		myPanel.setLayout (new FlowLayout());
		colorPanel = new ColorPanel (Color.red);
		myPanel.add (colorPanel);
		addTextAndButtons ();
		setTitle ("Modify Square Dialog");
		setLocation (x, y);
		setSize (300,350);
 		setVisible(true);
	}

	private void addTextAndButtons ()
	{
	 	myPanel.add(new JLabel("Enter the side:"));
		sideText = new JTextField(((Integer) oldSide).toString(), 20);
		sideText.addActionListener(this);
		myPanel.add (sideText);
		buttonPanel = new JPanel();
		OKButton = new JButton("    OK    ");
		OKButton.addActionListener(this);
		buttonPanel.add(OKButton);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		buttonPanel.add(cancelButton);
		myPanel.add(buttonPanel);
	}

	public void actionPerformed(ActionEvent e)
	{
 		if (redRButton == e.getSource())
			currentColor = Color.red;
		else if (orangeRButton == e.getSource())
			currentColor = new Color (237, 155, 37);
	 	else if (yellowRButton == e.getSource())
			currentColor = Color.yellow;
	 	else if (greenRButton == e.getSource())
			currentColor = Color.green;
		else if (blueRButton == e.getSource())
			currentColor = Color.blue;
		else if (purpleRButton == e.getSource())
			currentColor = new Color(82, 8, 125);
		else if (whiteRButton == e.getSource())
			currentColor = Color.white;
		else if (grayRButton == e.getSource())
			currentColor = new Color (170, 170, 170);
		else if (blackRButton == e.getSource())
			currentColor = Color.black;
		else if(OKButton == e.getSource())
		{
			answer = true;
			setVisible(false);
			getContentPane().remove(myPanel);
			currentColor = colorPanel.getColor ();
			try
			{
				side = Integer.parseInt (sideText.getText());
			}
			catch (NumberFormatException ex)
			{
				side = oldSide;
			}
        	}
 		else if(cancelButton == e.getSource())
		{
 			answer = false;
			setVisible(false);
	//		getContentPane().remove(myPanel);
		}
       }
}
