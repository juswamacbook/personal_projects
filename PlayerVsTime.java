package newcode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.File;
import java.util.Timer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerVsTime {

	JPanel PVTMainPanel = new JPanel(); // Player vs Time
	
	Timer timer = new Timer();
    int seconds = 0;
	
	JLabel timerPVT = new JLabel("[Timer]:  "); // set method for this... display numbers for it
	JLabel ttcPVT = new JLabel("42"); // total time count
	JLabel yourScorePVT = new JLabel("(Score): " + "54");
	JLabel tournamentScorePVT = new JLabel("(Tournament Score):  " + "45");
	JButton[] buttonsPVT = new JButton[25];
	JButton soundOnPVT = new JButton();
	JButton soundOffPVT = new JButton();
	JButton enterPVT = new JButton();
	JButton clearPVT = new JButton();
	JButton shufflePVT = new JButton();
	JButton optionsPVT = new JButton("...");
	JLabel guessedPVT = new JLabel("[:");
	JLabel gwcPVT = new JLabel(); // guessed words count, set the method for this... display numbers for it
	JLabel scorePVT = new JLabel("[Score]:  ");
	JLabel scPVT = new JLabel("69"); // score count
	String word = "";
	
	PlayerVsTime(){
		// This panel is the main panel that groups everything
		//JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(PVTMainPanel, BoxLayout.Y_AXIS);
		PVTMainPanel.setLayout(boxlayout);
		PVTMainPanel.setSize(500, 500);

		// Title settings, might change to a JLabel
		JLabel title = new JLabel("BOGGLE DELUXE");

		// Sets all the words displayed to this font, if you need to add more just add it in the try section
		Font retroPix;
		try {
			retroPix = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
			title.setFont(retroPix);
			optionsPVT.setFont(retroPix);

		} catch (Exception e) {
			System.out.println(e);
		}
		
		// this is just a smaller font
		Font retroPixSmall;
		try {
			retroPixSmall = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
			guessedPVT.setFont(retroPixSmall);
			gwcPVT.setFont(retroPixSmall);
			scorePVT.setFont(retroPixSmall);
			scPVT.setFont(retroPixSmall);
			//soundOnPVT.setFont(retroPixSmall);
			//soundOffPVT.setFont(retroPixSmall);
			timerPVT.setFont(retroPixSmall);
			ttcPVT.setFont(retroPixSmall);
			
			retroPixSmall = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(18f);
			tournamentScorePVT.setFont(retroPixSmall);
			yourScorePVT.setFont(retroPixSmall);

		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Extra small font so the words actually show
		Font retroPixExtraSmall;
		try {
			retroPixExtraSmall = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(11f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
			soundOnPVT.setFont(retroPixExtraSmall);
			soundOffPVT.setFont(retroPixExtraSmall);
			clearPVT.setFont(retroPixExtraSmall);
			enterPVT.setFont(retroPixExtraSmall);
			retroPixExtraSmall = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(10f);
			shufflePVT.setFont(retroPixExtraSmall);
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		JPanel scorePanel = new JPanel();
		scorePanel.setPreferredSize(new Dimension(150, 25));
		scorePanel.setLayout(new FlowLayout());
		scorePanel.add(scorePVT);
		scorePanel.add(scPVT);
		JPanel timerPanel = new JPanel();
		timerPanel.setPreferredSize(new Dimension(150, 25));
		timerPanel.setLayout(new FlowLayout());
		timerPanel.add(timerPVT);
		timerPanel.add(ttcPVT);
		
		// This panel staples the score and timer in a specific vicinity
		JPanel staple = new JPanel();
		staple.setPreferredSize(new Dimension(500, 35));
		staple.setLayout(new FlowLayout());
		
		staple.add(title);
		
		// 
		JPanel ts = new JPanel();
		ts.setPreferredSize(new Dimension(500, 35));
		ts.setLayout(new FlowLayout());
		ts.add(tournamentScorePVT);
		//tournamentScore.setText("YOUR SCORE: ");
		//ts.setBackground(Color.black);
		
		JLabel space = new JLabel();
		space.setPreferredSize(new Dimension(30, 10));
		
		ts.add(yourScorePVT);
		ts.add(space);
		ts.add(tournamentScorePVT);
		
		// This panel uppermost panel that has the title and score
		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(500, 200));
		p3.setLayout(new FlowLayout());
		p3.add(staple);
		p3.add(scorePanel);
		p3.add(timerPanel);
		p3.add(ts);
		PVTMainPanel.add(p3);
		
		
		
		// This panel is the grid
		// Put grid in another panel thats set to borderLayout
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(5, 5, 5, 5));
		gwcPVT.setText(word);
		for (int i = 0; i < 25; i++) {
			buttonsPVT[i] = new JButton();
			p2.add(buttonsPVT[i]);
	        buttonsPVT[i].setOpaque(true);
	        //buttons[i].setContentAreaFilled(false);
	        buttonsPVT[i].setBorderPainted(true);
	        buttonsPVT[i].setBackground(new Color(248, 249, 241));
		}
		
		// Heres the button settings & other attributes
		soundOnPVT.setPreferredSize(new Dimension(75, 75));
		soundOffPVT.setPreferredSize(new Dimension(75, 75));
		optionsPVT.setPreferredSize(new Dimension(50, 50));
		guessedPVT.setPreferredSize(new Dimension(50, 50));
		gwcPVT.setPreferredSize(new Dimension(50, 50));
		enterPVT.setPreferredSize(new Dimension(75, 25));
		clearPVT.setPreferredSize(new Dimension(75, 25));

		soundOnPVT.setText("SFX \n ON");
		soundOffPVT.setText("SFX \n OFF");
		enterPVT.setText("ENTER");
		clearPVT.setText("CLEAR");

		// This is the panel on the left
		JPanel p4 = new JPanel();
		p4.setPreferredSize(new Dimension(75, 500));

		// Change from borderLayout to box
		// p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
		p4.setLayout(new FlowLayout());
		//p4.setBackground(Color.red);

		// This is the panel on the right
		JPanel p5 = new JPanel();
		p5.setPreferredSize(new Dimension(100, 400));
		p5.setLayout(new FlowLayout());
		//p5.setBackground(Color.green);
		
		// Setting button view settings
        soundOnPVT.setOpaque(true);
        //soundOnPVT.setContentAreaFilled(false);
        soundOnPVT.setBorderPainted(true);
        soundOnPVT.setBackground(new Color(123, 161, 182));
		
        soundOffPVT.setOpaque(true);
        //soundOffPVT.setContentAreaFilled(false);
        soundOffPVT.setBorderPainted(true);
        soundOffPVT.setBackground(new Color(123, 161, 182));
		
        //submit.setOpaque(true);
        //submit.setContentAreaFilled(false);
        //submit.setBorderPainted(true);
        //submit.setBackground(new Color(123, 161, 182));
        
        //JButton enter = new JButton();
        enterPVT.setOpaque(true);
        //enter.setContentAreaFilled(false);
        enterPVT.setBorderPainted(true);
        enterPVT.setBackground(new Color(123, 161, 182));
        
        //JButton clear = new JButton();
        clearPVT.setOpaque(true);
        //clear.setContentAreaFilled(false);
        clearPVT.setBorderPainted(true);
        clearPVT.setBackground(new Color(123, 161, 182));
        
        optionsPVT.setOpaque(true);
        //optionsPVT.setContentAreaFilled(false);
        optionsPVT.setBorderPainted(true);
        optionsPVT.setBackground(new Color(123, 161, 182));
		
        shufflePVT.setOpaque(true);
        shufflePVT.setBorderPainted(true);
        shufflePVT.setBackground(new Color(128,128,128));
        shufflePVT.setPreferredSize(new Dimension(75, 40));
        shufflePVT.setText("SHUFFLE");
        
        tournamentScorePVT.setOpaque(true);
        //tournamentScore.setBorderPainted(true);
        //tournamentScore.setBackground(new Color(123, 161, 182));
        
        // Shuffle separator
        JPanel ss = new JPanel();
        ss.setPreferredSize(new Dimension(50, 10));
        
		p5.add(soundOnPVT);
		p5.add(soundOffPVT);
		p5.add(ss);
		p5.add(shufflePVT);
		
		//p5.add(submit);

		// This is the panel on the bottom
		JPanel p6 = new JPanel();
		p6.setPreferredSize(new Dimension(500, 75));
		p6.setLayout(new BorderLayout());
		//p6.setBackground(Color.blue);

		// This is a placeholder to fix the issue with grouping 2 components with
		// borderLayout
		JPanel placeHolder = new JPanel();
		placeHolder.setLayout(new BoxLayout(placeHolder, BoxLayout.X_AXIS));
		placeHolder.setPreferredSize(new Dimension(200, 75));
		placeHolder.add(guessedPVT);
		placeHolder.add(gwcPVT);
		
		// Panel to place options button on
		JPanel optionsHolder = new JPanel();
		optionsHolder.setLayout(new FlowLayout());
		optionsHolder.setPreferredSize(new Dimension(75, 75));
		optionsHolder.add(optionsPVT);

		JPanel ClearSubmit = new JPanel();
		ClearSubmit.setLayout(new FlowLayout());
		ClearSubmit.setPreferredSize(new Dimension(150, 75));
		
		JPanel obstructor = new JPanel();
		obstructor.setLayout(new FlowLayout());
		obstructor.setPreferredSize(new Dimension(140, 5));
		
		JPanel obstructor2 = new JPanel();
		obstructor2.setLayout(new FlowLayout());
		obstructor2.setPreferredSize(new Dimension(70, 20));
		optionsHolder.add(obstructor2);
		
		//ClearSubmit.add(Box.createVerticalStrut(20));
		ClearSubmit.add(obstructor);
		ClearSubmit.add(clearPVT);
		ClearSubmit.add(enterPVT);
		
		clearPVT.setBackground(new Color(250, 67, 35));
		enterPVT.setBackground(new Color(161, 245, 100));
		
		// Adding them on panel 6 (bottom panel)
		p6.add(ClearSubmit, BorderLayout.CENTER);
		p6.add(placeHolder, BorderLayout.EAST);
		p6.add(optionsHolder, BorderLayout.WEST);
		

		// bottom half of the frame
		JPanel bh = new JPanel();
		bh.setLayout(new BorderLayout());
		bh.add(p6, BorderLayout.SOUTH);
		bh.add(p5, BorderLayout.EAST);
		bh.add(p4, BorderLayout.WEST);
		bh.add(p2, BorderLayout.CENTER);

		PVTMainPanel.add(bh);
	}
}
