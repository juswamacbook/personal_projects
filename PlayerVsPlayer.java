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

public class PlayerVsPlayer {

	JPanel PVPMainPanel = new JPanel(); // Player vs Player
	
	Timer timer1 = new Timer();
	int seconds = 0;

	JLabel timer = new JLabel("[TIMER]:  "); // set method for this... display numbers for it
	JLabel ttc = new JLabel("42"); // total time count
	JButton[] buttons = new JButton[25];
	JButton soundOn = new JButton();
	JButton soundOff = new JButton();
	JButton options = new JButton("...");
	JLabel current = new JLabel(""); // add a variable in the middle
	JLabel gwc = new JLabel(); // guessed words count, set the method for this... display numbers for it
	// name them userName + ": " + score (sorry, swing layouts gets bugged out if I put name above score)
	// to elaborate further, panels too small; gets out of order, too big; gets bugged out
	JLabel p1s = new JLabel();
	JLabel p1sc = new JLabel("69"); // player 1 score count
	JLabel p2s = new JLabel("Player2");
	JLabel p2sc = new JLabel("0"); // player 2 score count
	JButton clear = new JButton();
	JButton enter = new JButton();
	JButton shuffle = new JButton();
	JLabel tournamentScore = new JLabel("GOAL:");
	JLabel yourScore = new JLabel("B");
	JLabel tsd = new JLabel(); // tournament score display
	JLabel ysd = new JLabel(); // your score display
	String word = "";
	//JLabel tournamentScore = new JLabel();
	//JLabel yourScore = new JLabel();
	
	PlayerVsPlayer(){
		p1s.setText("Player1:  ");
		p2s.setText("Player2:  ");

		// This panel is the main panel that groups everything
		//JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(PVPMainPanel, BoxLayout.Y_AXIS);
		PVPMainPanel.setLayout(boxlayout);
		PVPMainPanel.setSize(500, 500);

		// Title settings, might change to a JLabel
		JLabel title = new JLabel("BOGGLE DELUXE");

		// Sets all the words displayed to this font, if you need to add more just add it in the try section
		Font retroPix;
		try {
			retroPix = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
			title.setFont(retroPix);
			options.setFont(retroPix);

		} catch (Exception e) {
			System.out.println(e);
		}
		
		// this is just a smaller font
		Font retroPixSmall;
		try {
			retroPixSmall = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
			current.setFont(retroPixSmall);
			gwc.setFont(retroPixSmall);
			options.setFont(retroPixSmall);
			soundOn.setFont(retroPixSmall);
			soundOff.setFont(retroPixSmall);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Font retroPixMidSmall;
		try {
			retroPixMidSmall = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(15f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
			p1s.setFont(retroPixMidSmall);
			p1sc.setFont(retroPixMidSmall);
			p2s.setFont(retroPixMidSmall);
			p2sc.setFont(retroPixMidSmall);
			timer.setFont(retroPixMidSmall);
			ttc.setFont(retroPixMidSmall);
			ttc.setPreferredSize(new Dimension(100,20));
			

		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Extra small font so the words actually show
		Font retroPixExtraSmall;
		try {
			retroPixExtraSmall = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(11f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
			soundOn.setFont(retroPixExtraSmall);
			soundOff.setFont(retroPixExtraSmall);
			//timer.setFont(retroPixExtraSmall);
			//ttc.setFont(retroPixExtraSmall);
			
			retroPixExtraSmall = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(13f);
			timer.setFont(retroPixExtraSmall);
			ttc.setFont(retroPixExtraSmall);
			tournamentScore.setFont(retroPixExtraSmall);
			tsd.setFont(retroPixExtraSmall);
			clear.setFont(retroPixExtraSmall);
			enter.setFont(retroPixExtraSmall);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		JPanel spacer = new JPanel();
		spacer.setPreferredSize(new Dimension(30, 20));
		//spacer.setBackground(Color.black);
		
		// Panel for the title
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.setPreferredSize(new Dimension(500, 40));
		titlePanel.add(title);
		
		// These are all in flowLayout because it auto centers everything
		// Two score panels because we have two players
		JPanel scorePanel = new JPanel();
		scorePanel.setPreferredSize(new Dimension(100, 20));
		scorePanel.setLayout(new FlowLayout());
		scorePanel.add(p1s);
		scorePanel.add(p1sc);

		JPanel scorePanel2 = new JPanel();
		scorePanel2.setPreferredSize(new Dimension(100, 20));
		scorePanel2.setLayout(new FlowLayout());
		scorePanel2.add(p2s);
		scorePanel2.add(p2sc);
		
		// Displays time
		JPanel timePanel = new JPanel();
		timePanel.setPreferredSize(new Dimension(500, 20));
		timePanel.setLayout(new FlowLayout());
		timePanel.add(timer);
		timePanel.add(ttc);
		timePanel.add(spacer);
		timePanel.add(tournamentScore);
		timePanel.add(tsd);
		
		
		
		//scorePanel.add(scorePanel2);

		// This panel uppermost panel that has the title and score
		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(150, 180));
		p3.setLayout(new FlowLayout());
		p3.add(titlePanel);
		p3.add(scorePanel);
		p3.add(scorePanel2);
		p3.add(timePanel, BorderLayout.EAST);
		
		PVPMainPanel.add(p3);
		// This panel is the grid
		// Put grid in another panel thats set to borderLayout
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(5, 5, 5, 5));
		gwc.setText(word);
		for (int i = 0; i < 25; i++) {
			buttons[i] = new JButton();
			p2.add(buttons[i]);
	        buttons[i].setOpaque(true);
	        //buttons[i].setContentAreaFilled(false);
	        buttons[i].setBorderPainted(true);
	        buttons[i].setBackground(new Color(248, 249, 241));
	      
		}
		
		// Heres the button settings & other attributes
		soundOn.setPreferredSize(new Dimension(75, 75));
		soundOff.setPreferredSize(new Dimension(75, 75));
		options.setPreferredSize(new Dimension(50, 50));
		current.setPreferredSize(new Dimension(150, 50));
		gwc.setPreferredSize(new Dimension(50, 50));
		
		clear.setPreferredSize(new Dimension(80, 25));
		enter.setPreferredSize(new Dimension(80, 25));
		shuffle.setPreferredSize(new Dimension(75, 40));

		soundOn.setText("SFX \n ON");
		soundOff.setText("SFX \n OFF");
		
		clear.setText("CLEAR");
		enter.setText("ENTER");
		
		shuffle.setText("SHUFFLE");

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
        soundOn.setOpaque(true);
        //soundOn.setContentAreaFilled(false);
        soundOn.setBorderPainted(true);
        soundOn.setBackground(new Color(123, 161, 182));
        
        soundOff.setOpaque(true);
        //soundOff.setContentAreaFilled(false);
        soundOff.setBorderPainted(true);
        soundOff.setBackground(new Color(123, 161, 182));
        
        options.setOpaque(true);
        //options.setContentAreaFilled(false);
        options.setBorderPainted(true);
        options.setBackground(new Color(123, 161, 182));
		
        clear.setOpaque(true);
        //options.setContentAreaFilled(false);
        clear.setBorderPainted(true);
        clear.setBackground(new Color(250, 67, 35));
        
        enter.setOpaque(true);
        //options.setContentAreaFilled(false);
        enter.setBorderPainted(true);
        enter.setBackground(new Color(161, 245, 100));
        
        shuffle.setOpaque(true);
        //options.setContentAreaFilled(false);
        shuffle.setBorderPainted(true);
        shuffle.setBackground(new Color(128,128,128));
        
		p5.add(soundOn);
		p5.add(soundOff);

		// This is the panel on the bottom
		JPanel p6 = new JPanel();
		p6.setPreferredSize(new Dimension(500, 75));
		p6.setLayout(new BorderLayout());
		//p6.setBackground(Color.blue);

		// This is a placeholder to fix the issue with grouping 2 components with
		// borderLayout
		JPanel placeHolder = new JPanel();
		placeHolder.setLayout(new BoxLayout(placeHolder, BoxLayout.X_AXIS));
		placeHolder.setPreferredSize(new Dimension(150, 75));
		placeHolder.add(current);
		placeHolder.add(gwc);
		
		// Panel to place options button on
		JPanel optionsHolder = new JPanel();
		optionsHolder.setLayout(new FlowLayout());
		optionsHolder.setPreferredSize(new Dimension(75, 75));
		optionsHolder.add(options);
		
		// This holds the clear and enter buttons
		JPanel clearEnter = new JPanel();
		clearEnter.setLayout(new FlowLayout());
		clearEnter.add(clear);
		clearEnter.add(enter);
		//clearEnter.setBackground(Color.black);

		// Adding them on panel 6 (bottom panel)
		p6.add(clearEnter, BorderLayout.CENTER);
		p6.add(placeHolder, BorderLayout.EAST);
		p6.add(optionsHolder, BorderLayout.WEST);

		// bottom half of the frame
		JPanel bh = new JPanel();
		bh.setLayout(new BorderLayout());
		bh.add(p6, BorderLayout.SOUTH);
		bh.add(p5, BorderLayout.EAST);
		bh.add(p4, BorderLayout.WEST);
		bh.add(p2, BorderLayout.CENTER);

		PVPMainPanel.add(bh);
		
	}
}

