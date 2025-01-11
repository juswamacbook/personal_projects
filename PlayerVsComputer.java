package newcode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerVsComputer {

	JPanel PVCMainPanel = new JPanel(); // Player vs Computer

	JLabel timer = new JLabel("[TIMER]:  "); // set method for this... display numbers for it
	JLabel ttc = new JLabel("42"); // total time count
	JButton[] buttons = new JButton[25];
	JButton soundOn = new JButton();
	JButton soundOff = new JButton();
	JButton options = new JButton("...");
	JLabel current = new JLabel(""); // add a variable in the middle
	//JLabel gwc = new JLabel(); // guessed words count, set the method for this... display numbers for it
	// name them userName + ": " + score (sorry, swing layouts gets bugged out if I
	// put name above score)
	// to elaborate further, panels too small; gets out of order, too big; gets
	// bugged out
	String word = "";
	JLabel p1s = new JLabel();
	JLabel p1sc = new JLabel("69"); // player 1 score count
	JLabel p2s = new JLabel();
	JLabel p2sc = new JLabel("96"); // player 2 score count
	JButton clear = new JButton();
	JButton enter = new JButton();
	JButton shuffle = new JButton();
	JLabel tournamentScore = new JLabel("GOAL:");
	JLabel yourScore = new JLabel("B");
	JLabel tsd = new JLabel(); // tournament score display
	JLabel ysd = new JLabel(); // your score display
	// JLabel tournamentScore = new JLabel();
	// JLabel yourScore = new JLabel();
	JLabel wordLabel;
	
	String[][] dicePositions = {
			
		{"00", "01", "02", "03", "04"},
		{"10", "11", "12", "13", "14"},
		{"20", "21", "22", "23", "24"},
		{"30", "31", "32", "33", "34"},
		{"40", "41", "42", "43", "44"}
			
	};
	
	ArrayList<String> usedPositions = new ArrayList<String>();

	PlayerVsComputer() {
		String nickname = BoggleDeluxe.player1.getNickName();
		if (nickname != null) {
			p1s.setText(BoggleDeluxe.player1.getNickName() + ": ");
		} else {
			p1s.setText("null: ");
		}
		p2s.setText("AI: ");
		wordLabel = new JLabel("{____}");
		// This panel is the main panel that groups everything
		// JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(PVCMainPanel, BoxLayout.Y_AXIS);
		PVCMainPanel.setLayout(boxlayout);
		PVCMainPanel.setSize(500, 500);

		// Title settings, might change to a JLabel
		JLabel title = new JLabel("BOGGLE DELUXE");

		// Sets all the words displayed to this font, if you need to add more just add
		// it in the try section
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
			//current.setFont(retroPixSmall);
			//gwc.setFont(retroPixSmall);
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
			// timer.setFont(retroPixMidSmall);
			// ttc.setFont(retroPixMidSmall);
			// tournamentScore.setFont(retroPixMidSmall);
			// tsd.setFont(retroPixMidSmall);

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
			shuffle.setFont(retroPixExtraSmall);
	
			retroPixExtraSmall = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(13f);
			timer.setFont(retroPixExtraSmall);
			ttc.setFont(retroPixExtraSmall);
			tournamentScore.setFont(retroPixExtraSmall);
			tsd.setFont(retroPixExtraSmall);
			clear.setFont(retroPixExtraSmall);
			enter.setFont(retroPixExtraSmall);
			current.setFont(retroPixExtraSmall);


		} catch (Exception e) {
			System.out.println(e);
		}
		JPanel spacer = new JPanel();
		spacer.setPreferredSize(new Dimension(30, 20));
		// spacer.setBackground(Color.black);

		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.setPreferredSize(new Dimension(500, 40));
		titlePanel.add(title);
		// titlePanel.setBackground(Color.black);

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

		// Displays time & tournamentScore
		JPanel timePanel = new JPanel();
		timePanel.setPreferredSize(new Dimension(500, 25));
		timePanel.setLayout(new FlowLayout());
		timePanel.add(timer);
		timePanel.add(ttc);
		timePanel.add(spacer);
		timePanel.add(tournamentScore);
		timePanel.add(tsd);

		// This panel uppermost panel that has the title and score
		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(150, 220));
		p3.setLayout(new FlowLayout());
		p3.add(titlePanel);
		p3.add(scorePanel);
		p3.add(scorePanel2);
		p3.add(timePanel);

		PVCMainPanel.add(p3);

		
		// This panel is the grid
		// Put grid in another panel thats set to borderLayout
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(5, 5, 5, 5));
	 	for (int i = 0; i < 25; i++) {
			buttons[i] = new JButton();
			buttons[i].setOpaque(true);
			// buttons[i].setContentAreaFilled(false);
			buttons[i].setBorderPainted(true);
			buttons[i].setBackground(new Color(248, 249, 241));
			buttons[i].setText(String.valueOf(BoggleDeluxe.dice[i/5][i%5].getShownSide()));
			p2.add(buttons[i]);
		}
		//gwc.setText(word);
		// Heres the button settings & other attributes
		soundOn.setPreferredSize(new Dimension(75, 65));
		soundOff.setPreferredSize(new Dimension(75, 65));
		options.setPreferredSize(new Dimension(50, 50));
		current.setPreferredSize(new Dimension(150, 50));
		//gwc.setPreferredSize(new Dimension(50, 50));

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
		// p4.setBackground(Color.red);

		// This is the panel on the right
		JPanel p5 = new JPanel();
		p5.setPreferredSize(new Dimension(120, 400));
		p5.setLayout(new FlowLayout());
		// p5.setBackground(Color.green);

		// Setting button view settings
		soundOn.setOpaque(true);
		// soundOn.setContentAreaFilled(false);
		soundOn.setBorderPainted(true);
		soundOn.setBackground(new Color(123, 161, 182));

		soundOff.setOpaque(true);
		// soundOff.setContentAreaFilled(false);
		soundOff.setBorderPainted(true);
		soundOff.setBackground(new Color(123, 161, 182));

		options.setOpaque(true);
		// options.setContentAreaFilled(false);
		options.setBorderPainted(true);
		options.setBackground(new Color(123, 161, 182));

		clear.setOpaque(true);
		// options.setContentAreaFilled(false);
		clear.setBorderPainted(true);
		clear.setBackground(new Color(250, 67, 35));

		enter.setOpaque(true);
		// options.setContentAreaFilled(false);
		enter.setBorderPainted(true);
		enter.setBackground(new Color(161, 245, 100));

		shuffle.setOpaque(true);
		// options.setContentAreaFilled(false);
		shuffle.setBorderPainted(true);
		shuffle.setBackground(new Color(128, 128, 128));

		p5.add(soundOn);
		p5.add(soundOff);
		p5.add(shuffle);

		// This is the panel on the bottom
		JPanel p6 = new JPanel();
		p6.setPreferredSize(new Dimension(500, 75));
		p6.setLayout(new BorderLayout());
		// p6.setBackground(Color.blue);

		// This is a placeholder to fix the issue with grouping 2 components with
		// borderLayout
		JPanel placeHolder = new JPanel();
		placeHolder.setLayout(new FlowLayout());
		placeHolder.setPreferredSize(new Dimension(200, 75));
		placeHolder.add(current);
		//placeHolder.add(gwc);
		// placeHolder.setBackground(Color.green);

		// Panel to place options button on
		JPanel optionsHolder = new JPanel();
		optionsHolder.setLayout(new FlowLayout());
		optionsHolder.setPreferredSize(new Dimension(75, 75));
		optionsHolder.add(options);

		JPanel obstructor = new JPanel();
		obstructor.setPreferredSize(new Dimension(200, 5));

		JPanel clearEnter = new JPanel();
		clearEnter.setLayout(new FlowLayout());
		// clearEnter.setPreferredSize(new Dimension(75, 75));
		// clearEnter.add(obstructor);
		clearEnter.add(clear);
		clearEnter.add(enter);
		// clearEnter.setBackground(Color.black);

		// Adding them on panel 6 (bottom panel)
		p6.add(placeHolder, BorderLayout.EAST);
		p6.add(optionsHolder, BorderLayout.WEST);
		p6.add(clearEnter, BorderLayout.CENTER);

		// bottom half of the frame
		JPanel bh = new JPanel();
		bh.setLayout(new BorderLayout());
		bh.add(p6, BorderLayout.SOUTH);
		bh.add(p5, BorderLayout.EAST);
		bh.add(p4, BorderLayout.WEST);
		bh.add(p2, BorderLayout.CENTER);

		

		PVCMainPanel.add(bh);
	}
	
	/**
	 * This method returns true / false based on whether the passed position (String)
	 * is in close proximity to the previous position AND not already chosen
	 * @param positionToCheck (String)
	 * @param usedPositions (ArrayList of Strings)
	 * @return
	 */
	public static boolean validSelection(String positionToCheck, ArrayList<String> usedPositions) {
		
		//last position accessed
		String previousPos;
		try {
			previousPos = usedPositions.get(usedPositions.size() - 1);
		}
		catch (Exception IndexOutOfBoundsException) { //if no positions have been used already, previous pos is the current pos
			previousPos = positionToCheck;
		}
		
		//checking to see if button was pressed already
		if (usedPositions.contains(positionToCheck) == false) {
			
			//checking to see if button is near pos of previouss button
			if (nearPosition(positionToCheck, previousPos)) {
				
				usedPositions.add(positionToCheck);
				return true;
				
			}
		
		}
		return false;
	}
	
	public static boolean nearPosition(String pos1, String pos2) {
		
		//row in range
		if (getKey(pos1) <= getKey(pos2) + 1 && getKey(pos1) >= getKey(pos2) - 1) {
			
			//column in range
			if (getValue(pos1) <= getValue(pos2) + 1 && getValue(pos1) >= getValue(pos2) - 1) {
				System.out.println(pos1 + " is near " + pos2);
				return true;
			}
			
		}
		
		return false;
	}
	
	/**
	 * Takes in a "pair" (string), returns the "key" (first char)
	 * 
	 * @param pair
	 * @return
	 */
	public static int getKey(String pair) {
		return Character.getNumericValue(pair.charAt(0));
	}

	/**
	 * Takes in a "pair" (string), returns the "value" (second char)
	 * 
	 * @param pair
	 * @return
	 */
	public static int getValue(String pair) {
		return Character.getNumericValue(pair.charAt(1));
	}
}
