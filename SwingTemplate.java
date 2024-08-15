import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/* 0. TRY to use a UserInterface Manager
 * 1. DECLARE a frame, then a panel, then components
 *       a. components are buttons, textfield, labels, menus, etc.
 * 2. CONSTRUCT a frame, then a panel, then components
 *       a. create the components by adding pictures (Icons) if desired
 *       b. have buttons and textfields "listen" for actions
 * 3. CONSTRUCT a layout then ADD to panel
 * 4. ADD components to panel
 * 5. ADD panel to frame
 * 6. Set the Frame to be visible
 */

public class SwingTemplate extends JFrame implements ActionListener
{
	// frame which is the window with borders, title bar, min/max/exit buttons
	private static JFrame f;

	// panel that will hold the contents (i.e. all the components)
	private JPanel p;

	/*****************************  These are all components */
	// buttons
	private JButton fancyButton;

	// text field
	private JTextField text1;

	// labels
	private JLabel  fancyLabel;
	/*****************************  Ending the components */


	/** this is where we all start
	*/
	public static void main(String arg[])
	{
		try
		{
			UIManager.setLookAndFeel(
		                UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception e)
		{
			// do nothing if a problem...just quit
		}

		// this will really do all the work!
		// it declares and creates a new application
		SwingTemplate app = new SwingTemplate();

		// needed at bottom to of main() to be able to close the application
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// automatically resize window (use instead of setSize)
		f.pack();		
		f.setVisible(true);
	} // main()

	/** constructor that creates or instantiates the frame, panel, layout, etc.
	*/
	public SwingTemplate()
	{
		// Create the overall window for the application
		f = new JFrame("Swing Template");

		// create the content panel to be put in the frame
		p = new JPanel();

		// set the layout which will be in a grid measuring 3 rows x 2 culumns
		GridLayout layout = new GridLayout(3,2);
		
		// set whichever layout is chosen above
		p.setLayout( layout);

		// call the following methods so that they will
		// create & add each of the labels, buttons, & textfields
		// to the content panel
		addLabelsToContentPanel();
		addButtonsToContentPanel();
		addFieldToContentPanel();

		// finally add the content to the window
		f.setContentPane(p);
	}

	/** create and add for the labels to the content panel
	*/
	public void addLabelsToContentPanel()
	{
		Icon myPicture = new ImageIcon("butterfly.gif");
		fancyLabel = new JLabel("Fancy Label", myPicture, SwingConstants.LEFT);
		fancyLabel.setToolTipText("toultip for fancy label");
		p.add(fancyLabel);
	}


	/** create,add, and attach events for the text fields to the content panel
	*/
	public void addFieldToContentPanel()
	{
		text1 = new JTextField(10);     // create the textfield & set size to 10
		text1.setEditable(true);        // the user can change it
		p.add(text1);                   // add it to the content
		text1.addActionListener(this);  // listen for an mouse click
	}


	/** create, add, and attach events for the buttons
	*  to the content panel
	*/
	public void addButtonsToContentPanel()
	{

		// create a fancy button with pictures and a rullover
		Icon frog    = new ImageIcon("frog.gif");
		Icon buffalo = new ImageIcon("buffalo.gif");
		fancyButton  = new JButton("Fancy Button", frog);
		fancyButton.setRolloverIcon(buffalo);

		// add the button to the content pane then listen for clicks
		p.add(fancyButton);
		fancyButton.addActionListener(this);
	}

	/** handle the actions were taken in the application window
	*/
	public void actionPerformed(ActionEvent e)
	{
		// if button was pressed change the text field
		if (e.getSource() == fancyButton)
		{
			// swap the text from fancy to plain and back again
			if (text1.getText().equals("fancy"))
			{
				text1.setText("plain");
			}
			else
			{
				text1.setText("fancy");
			}
		}

		// if the textfield was typed in then change the label
		if (e.getSource() == text1)
		{
			fancyLabel.setText(text1.getText());
		}

		repaint();
	}

}