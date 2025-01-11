package newcode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NicknameMenu implements ActionListener {

	JPanel NNMainPanel = new JPanel();
	 JTextField userInput;
	JButton submitButton;
    String userName;
	
	NicknameMenu(){	
			// Main panel, everything is attached to this
			//JPanel panel = new JPanel();
		NNMainPanel.setPreferredSize(new Dimension(500, 500));
			NNMainPanel.setLayout(new BorderLayout());
			
			// These two panels are on the side to push the title text inwards
			JPanel sidePanel1 = new JPanel();
			sidePanel1.setPreferredSize(new Dimension (100, 500));
			sidePanel1.setLayout(new FlowLayout());
			
			JPanel sidePanel2 = new JPanel();
			sidePanel2.setPreferredSize(new Dimension (100, 500));
			sidePanel2.setLayout(new FlowLayout());
			
			// This panel staples the text box within its vicinity
			JPanel staple = new JPanel();
			staple.setPreferredSize(new Dimension (300, 175));
			staple.setLayout(new FlowLayout());
			
			// Grafts two 100 pixels space on both left & right, allowing components to center
			NNMainPanel.add(sidePanel1, BorderLayout.WEST);
			NNMainPanel.add(sidePanel2, BorderLayout.EAST);

			// Sub main panel, adds all visible components together
			JPanel panel2 = new JPanel();
			panel2.setPreferredSize(new Dimension(300, 500));
			panel2.setLayout(new FlowLayout());
		
			// Allows title reshape: Title text settings
			JLabel label = new JLabel();
			label.setText("Welcome ");
			label.setPreferredSize(new Dimension(200, 70));
			
			JLabel label2 = new JLabel();
			label2.setText("to ");
			label2.setPreferredSize(new Dimension(70, 70));

			JLabel label3 = new JLabel();
			label3.setText("Boggle ");
			label3.setPreferredSize(new Dimension(160, 70));

			JLabel label4 = new JLabel();
			label4.setText("Deluxe ");
			label4.setPreferredSize(new Dimension(160, 70));

			JLabel label5 = new JLabel();
			label5.setText("Edition! ");
			label5.setPreferredSize(new Dimension(170, 60));

			// Enter nickname text field, is editable
			userInput = new JTextField();
			userInput.setText("Enter Nickname");
			userInput.setPreferredSize(new Dimension(300, 100));
			
			//Submit button
			submitButton = new JButton("Submit");
			submitButton.setOpaque(true);
			submitButton.setBorderPainted(true);
			submitButton.setPreferredSize(new Dimension(100, 100));
			submitButton.setBackground(new Color(248, 249, 241));
			
			// This panel is in between title text & userInput to space them apart
			JPanel obstructionPanel = new JPanel();
			obstructionPanel.setPreferredSize(new Dimension (500, 20));
			
			// Adding all components to sub main panel
			panel2.add(label);
			panel2.add(label2);
			panel2.add(label3);
			panel2.add(label4);
			panel2.add(label5);
			panel2.add(obstructionPanel);
			
			staple.add(userInput);
			staple.add(submitButton);
			
			submitButton.addActionListener(this);
			
			// Adds everything to panel
			NNMainPanel.add(staple, BorderLayout.SOUTH);
			NNMainPanel.add(panel2, BorderLayout.NORTH);
			
			// Registering custom font
			Font retroPixXL;
			try {
				retroPixXL = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(40f);
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
				userInput.setFont(retroPixXL);
				
				retroPixXL = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(20f);
				submitButton.setFont(retroPixXL);
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
			Font retroPixLarge;
			try {
				retroPixLarge = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 50f);
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
				label.setFont(retroPixLarge);
				label2.setFont(retroPixLarge);
				label3.setFont(retroPixLarge);
				label4.setFont(retroPixLarge);
				label5.setFont(retroPixLarge);
				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
	
public void actionPerformed(ActionEvent event) { //action listener
		
		Object component = event.getSource(); //making component thingy (action listener)
		
		if (component.equals(submitButton)) { //if the user presses
			
			System.out.println("username button was used"); //visualizing code
			
			userName = userInput.getText();
			
			//System.out.println("Nickname: " + userName);
		}
}
		
	}

