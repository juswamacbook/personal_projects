package newcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PauseMenu {
	JPanel PMMainPanel = new JPanel(); // Pause Menu 

	JButton back = new JButton();
	JButton viewWords = new JButton();
	JButton exit = new JButton();
	
	PauseMenu(){
		// Main panel, everything is attached to this
		//JPanel panel = new JPanel();
		PMMainPanel.setPreferredSize(new Dimension(500, 500));
		PMMainPanel.setLayout(new FlowLayout());
		
		// This panel is placed on the top of the flow layout to center the visible components
		JPanel ObstructorPanel = new JPanel();
		ObstructorPanel.setPreferredSize(new Dimension (400, 75));
		ObstructorPanel.setLayout(new FlowLayout());
		
		// Holds all the panels together
		JPanel PanelHolder = new JPanel();
		PanelHolder.setPreferredSize(new Dimension(400, 500));
		PanelHolder.setLayout(new FlowLayout());

		// Sub main panels to hold buttons
		JPanel PausePanel = new JPanel();
		//PausePanel.setPreferredSize(new Dimension(300, 500/3));
		PausePanel.setLayout(new FlowLayout());
		
		JPanel ExitPanel = new JPanel();
		//ExitPanel.setPreferredSize(new Dimension(300, 500/3));
		ExitPanel.setLayout(new FlowLayout());
		
		JPanel CompletedWordsPanel = new JPanel();
		//CompletedWordsPanel.setPreferredSize(new Dimension(300, 500/3));
		CompletedWordsPanel.setLayout(new FlowLayout());
		
		// Setting components
		back.setText("(BACK)");
		exit.setText("(Play Options Menu)"); // Click this, go back to main menu
		viewWords.setText("(Completed Words)");
		back.setPreferredSize(new Dimension(300, 75));
		exit.setPreferredSize(new Dimension(300, 75));
		viewWords.setPreferredSize(new Dimension(300, 75));
		back.setBackground(new Color(248, 249, 241));
		exit.setBackground(new Color(248, 249, 241));
		viewWords.setBackground(new Color(248, 249, 241));
		
		// Adding all components to sub main panels
		PausePanel.add(back);
		CompletedWordsPanel.add(viewWords);
		ExitPanel.add(exit);
		
		// Adds everything to panel
		PanelHolder.add(ObstructorPanel);
		PanelHolder.add(CompletedWordsPanel);
		PanelHolder.add(ExitPanel);
		PanelHolder.add(PausePanel);
		
		PMMainPanel.add(PanelHolder);
		
		// Registering custom font
		Font retroPixLarge;
		try {
			retroPixLarge = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
			back.setFont(retroPixLarge);
			viewWords.setFont(retroPixLarge);
			exit.setFont(retroPixLarge);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
}
