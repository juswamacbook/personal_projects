package newcode;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class WelcomeMenu extends JPanel {

    //JFrame frame = new JFrame();
    JButton play = new JButton();
	JButton vlb = new JButton();
	JButton vc = new JButton();
	JButton exitMenu = new JButton();
	JLabel weclome = new JLabel(); 
    JPanel mainPanel = new JPanel();JPanel leftPanel = new JPanel();JPanel rightPanel = new JPanel();
    JPanel fillerPanel = new JPanel();
    JPanel TitlePanel = new JPanel();
    JPanel ButtonHolder = new JPanel();
    JPanel PanelHolder = new JPanel();
    // Sub main panels to hold buttons
	// Play panel, View Leader Board panel, View Credits Panel
	JPanel PPanel = new JPanel();
    JPanel VLBPanel = new JPanel();
    JPanel VCPanel = new JPanel();

    WelcomeMenu(){
        

        // Main panel, everything is attached to this
		mainPanel.setPreferredSize(new Dimension(500, 500));
		mainPanel.setLayout(new BorderLayout());
		
		// These panels help center sub main panels with borderLayout
		
		leftPanel.setPreferredSize(new Dimension(65, 500));
		
		// This one needs a layout because exit button will be on this side
		
		rightPanel.setPreferredSize(new Dimension(65, 500));
		rightPanel.setLayout(new BorderLayout());
		
		fillerPanel.setPreferredSize(new Dimension(50, 75));
		fillerPanel.setLayout(new FlowLayout());
		
		// This panel is for the title
		
		TitlePanel.setPreferredSize(new Dimension(280, 150));
		TitlePanel.setLayout(new FlowLayout());
		
		// This panel is for holding the three buttons in the center
		
		ButtonHolder.setPreferredSize(new Dimension(280, 310));
		ButtonHolder.setLayout(new FlowLayout());
		
		// Holds all the panels together
		
		PanelHolder.setPreferredSize(new Dimension(400, 500));
		PanelHolder.setLayout(new BorderLayout());

		
		//PausePanel.setPreferredSize(new Dimension(300, 500/3));
		PPanel.setLayout(new FlowLayout());
		
		
		//ExitPanel.setPreferredSize(new Dimension(300, 500/3));
		VLBPanel.setLayout(new FlowLayout());
		
		
		//CompletedWordsPanel.setPreferredSize(new Dimension(300, 500/3));
		VCPanel.setLayout(new FlowLayout());
		
		// Setting components
		play.setText("(Play Game)");
		vlb.setText("(View Leader Board)"); // Click this, go back to main menu
		vc.setText("(View Credits)");
		exitMenu.setText("X");
		play.setPreferredSize(new Dimension(250, 50));
		vlb.setPreferredSize(new Dimension(250, 50));
		vc.setPreferredSize(new Dimension(250, 50));
		exitMenu.setPreferredSize(new Dimension(50, 50));
		play.setBackground(new Color(248, 249, 241));
		vlb.setBackground(new Color(248, 249, 241));
		vc.setBackground(new Color(248, 249, 241));
		exitMenu.setBackground(new Color(123, 161, 182));
		
		// Setting components for title
		// Allows title reshape: Title text settings
		JLabel label = new JLabel();
		label.setText("Welcome ");
		label.setPreferredSize(new Dimension(105, 40));
		
		JLabel label2 = new JLabel();
		label2.setText("to ");
		label2.setPreferredSize(new Dimension(40, 40));

		JLabel label3 = new JLabel();
		label3.setText("Boggle ");
		label3.setPreferredSize(new Dimension(85, 40));

		JLabel label4 = new JLabel();
		label4.setText("Deluxe ");
		label4.setPreferredSize(new Dimension(85, 40));

		JLabel label5 = new JLabel();
		label5.setText("Edition! ");
		label5.setPreferredSize(new Dimension(95, 40));
		
		// Adding the components to the title panel
		TitlePanel.add(label);
		TitlePanel.add(label2);
		TitlePanel.add(label3);
		TitlePanel.add(label4);
		TitlePanel.add(label5);
		
		// Adding all components to sub main panels
		//fillerPanel.add(exitMenu);
		rightPanel.add(fillerPanel, BorderLayout.SOUTH);
		PPanel.add(play);
		VLBPanel.add(vlb);
		VCPanel.add(vc);
		ButtonHolder.add(PPanel);
		ButtonHolder.add(VLBPanel);
		ButtonHolder.add(VCPanel);
		
		// Adds everything to panel
		PanelHolder.add(TitlePanel);
		PanelHolder.add(ButtonHolder, BorderLayout.SOUTH);
		mainPanel.add(rightPanel, BorderLayout.EAST);
		mainPanel.add(leftPanel, BorderLayout.WEST);
		mainPanel.add(PanelHolder);
		
		// Registering custom font
		Font retroPixLarge;
		try {
			retroPixLarge = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));			
			label.setFont(retroPixLarge);
			label2.setFont(retroPixLarge);
			label3.setFont(retroPixLarge);
			label4.setFont(retroPixLarge);
			label5.setFont(retroPixLarge);
			
		} catch (Exception e1) {
			System.out.println(e1);
		}
		Font retroPixMedium;
		try {
			retroPixMedium = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
			play.setFont(retroPixMedium);
			vlb.setFont(retroPixMedium);
			vc.setFont(retroPixMedium);
			exitMenu.setFont(retroPixMedium);
		
		} catch (Exception e1) {
			System.out.println(e1);
		}
        // Frame settings

				
	}
}