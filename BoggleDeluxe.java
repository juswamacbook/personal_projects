package newcode;

import java.util.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import newcode.LeaderBoard;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.sampled.*;

public class BoggleDeluxe {

	//Variables and objects declared/defined/instantiated at the class level

	static PlayBackgroundMusic music = new PlayBackgroundMusic();
	static JPanel currentPanel = new JPanel();

	static JFrame frame = new JFrame();

	static String nickname;
	static String nickname2;

	static int score1;
	static int score2;

	static String[] highScoreNames;
	static int[] highScores;

	static Board gameBoard = new Board();
	static Dice[][] dice = new Dice[5][5];

	static String[] wordDictionary;
	static ArrayList<String> usedWords = new ArrayList<String>();
	static String currentStr = "";

	static HumanPlayer player1 = new HumanPlayer();
	static HumanPlayer player2 = new HumanPlayer();

	static AIPlayer aiPlayer = new AIPlayer();
	static FindWordAI botAI = new FindWordAI();
	static String gameMode = "";
	static Highscore highscores = new Highscore();

	static int tournamentScore = 50;
	static boolean gameEnd;
	static boolean loaded;

	static ArrayList<Character> shownFaces = new ArrayList<Character>();
	static ArrayList<JButton> buttons = new ArrayList<JButton>();
	static ArrayList<String> usedPositions = new ArrayList<String>();
	static int minimumWordLength = 3;
	static int AIDifficulty = 100; //higher number yields greater word finding accuracy
	
	//PVP and TIMED
	static boolean playerOne = true;
	static boolean timerLoaded = false;
	static boolean firstTime = true;
	static int period = 1000;
	static int delay;

	//GUI
	static PlayOptionMenu POM = new PlayOptionMenu(0, 0, 0, 0);
	static PlayerVsComputer PVC;
	static PlayerVsPlayer PVP;
	static PlayerVsTime PVT;
	static LeaderBoard LB = new LeaderBoard(highscores.getNicknames(), highscores.getHighScores());
	static PauseMenu PM = new PauseMenu();
	static WelcomeMenu WM = new WelcomeMenu();
	static ViewCredits VC = new ViewCredits();
	static NicknameMenu NM = new NicknameMenu();	
	static CompletedWords CW = new CompletedWords(arrayListToArray(usedWords));
	static GameOver GO = new GameOver();

	public static void main(String[] args) {

		final char[] letters00 = { 'A', 'A', 'A', 'F', 'R', 'S' };
		Dice die00 = new Dice(letters00);

		final char[] letters01 = { 'A', 'E', 'E', 'G', 'M', 'U' };
		Dice die01 = new Dice(letters01);

		final char[] letters02 = { 'C', 'E', 'I', 'I', 'L', 'T' };
		Dice die02 = new Dice(letters02);

		final char[] letters03 = { 'D', 'H', 'H', 'N', 'O', 'T' };
		Dice die03 = new Dice(letters03);

		final char[] letters04 = { 'F', 'I', 'P', 'R', 'S', 'Y' };
		Dice die04 = new Dice(letters04);

		final char[] letters10 = { 'A', 'A', 'E', 'E', 'E', 'E' };
		Dice die10 = new Dice(letters10);

		final char[] letters11 = { 'A', 'E', 'G', 'M', 'N', 'N' };
		Dice die11 = new Dice(letters11);

		final char[] letters12 = { 'C', 'E', 'I', 'L', 'P', 'T' };
		Dice die12 = new Dice(letters12);

		final char[] letters13 = { 'D', 'H', 'L', 'N', 'O', 'R' };
		Dice die13 = new Dice(letters13);

		final char[] letters14 = { 'G', 'O', 'R', 'R', 'V', 'W' };
		Dice die14 = new Dice(letters14);

		final char[] letters20 = { 'A', 'A', 'F', 'I', 'R', 'S' };
		Dice die20 = new Dice(letters20);

		final char[] letters21 = { 'A', 'F', 'I', 'R', 'S', 'Y' };
		Dice die21 = new Dice(letters21);

		final char[] letters22 = { 'C', 'E', 'I', 'P', 'S', 'T' };
		Dice die22 = new Dice(letters22);

		final char[] letters23 = { 'E', 'I', 'I', 'I', 'T', 'T' };
		Dice die23 = new Dice(letters23);

		final char[] letters24 = { 'H', 'I', 'P', 'R', 'R', 'Y' };
		Dice die24 = new Dice(letters24);

		final char[] letters30 = { 'A', 'D', 'E', 'N', 'N', 'N' };
		Dice die30 = new Dice(letters30);

		final char[] letters31 = { 'B', 'J', 'K', 'Q', 'X', 'Z' };
		Dice die31 = new Dice(letters31);

		final char[] letters32 = { 'D', 'D', 'L', 'N', 'O', 'R' };
		Dice die32 = new Dice(letters32);

		final char[] letters33 = { 'E', 'M', 'O', 'T', 'T', 'T' };
		Dice die33 = new Dice(letters33);

		final char[] letters34 = { 'N', 'O', 'O', 'T', 'U', 'W' };
		Dice die34 = new Dice(letters34);

		final char[] letters40 = { 'A', 'E', 'E', 'E', 'E', 'M' };
		Dice die40 = new Dice(letters40);

		final char[] letters41 = { 'C', 'C', 'N', 'S', 'T', 'W' };
		Dice die41 = new Dice(letters41);

		final char[] letters42 = { 'D', 'H', 'H', 'L', 'O', 'R' };
		Dice die42 = new Dice(letters42);

		final char[] letters43 = { 'E', 'N', 'S', 'S', 'S', 'U' };
		Dice die43 = new Dice(letters43);

		final char[] letters44 = { 'O', 'O', 'O', 'T', 'T', 'U' };
		Dice die44 = new Dice(letters44);

		Dice[][] diceMain = { { die00, die01, die02, die03, die04 }, { die10, die11, die12, die13, die14 },
				{ die20, die21, die22, die23, die24 }, { die30, die31, die32, die33, die34 },
				{ die40, die41, die42, die43, die44 } };

		BoggleDeluxe.dice = diceMain;
		PVC = new PlayerVsComputer();
		PVP = new PlayerVsPlayer();
		PVT = new PlayerVsTime();
		// aiGame.setDice(diceMain);
		frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setResizable(true);
		frame.setMinimumSize(new Dimension(500, 550));


		currentPanel = WM.mainPanel;

		//frame.add(WM.mainPanel);

		frame.add(currentPanel);

		String[][] dicePositions = {

				{ "00", "01", "02", "03", "04" }, { "10", "11", "12", "13", "14" }, { "20", "21", "22", "23", "24" },
				{ "30", "31", "32", "33", "34" }, { "40", "41", "42", "43", "44" }

		};


		// Board gameBoard = new Board();
		gameBoard.setDice(dice);
		gameBoard.shuffleDie();

		//dicionary
		ArrayList<String> dictionaryArrayList = new ArrayList<String>();

		try {
			File file = new File("dictionary.txt"); //referencing file
			Scanner in = new Scanner(file); //creating a scanner for the file to read from it
			while (in.hasNext()) { //checks to see if the next token is available (I assume it only runs for as many tokens there are in the file)

				String nextLine = in.nextLine();
				dictionaryArrayList.add(nextLine);

			}
		}
		catch (Exception x) {
			//nothing
		}

		//wordDictionary = new String[dictionaryArrayList.size()];
		wordDictionary = arrayListToArray(dictionaryArrayList);
		System.out.println("Word dictionary loaded");

		//HumanPlayer player1 = new HumanPlayer();

		//highscore creation
		try {
			highscores.createScoreFile();
		}
		catch (Exception x) {
			//nothing
		}

		//store read names and scores into its array type attributes
		highscores.prepareHighScores();

		//storing highscore's names and scores in boggle deluxe's class defined variables
		highScoreNames = highscores.getNicknames();
		highScores = highscores.getHighScores();
		
		LB = new LeaderBoard(highScoreNames, highScores);

		//saving highscores to file
		try {
			highscores.saveScoresToFile();
		}
		catch (Exception x){
			//nothing
		}

		// music.playMusic("src\\Boggle\\No Worries.wav");

		for (int j = 0; j < 25; j++) {
			addAiActionListenerToButton(j);
			addPVPActionListenerToButton(j);
			addPVTActionListenerToButton(j);
		}

		// NICKNAME MENU
		WM.play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(WM.mainPanel);

				currentPanel = NM.NNMainPanel;

				frame.add(currentPanel);
				//frame.add(NM.NNMainPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
		});

		// NICKNAME SUBMIT
		NM.submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				nickname = NM.userInput.getText();
				player1.setNickName(nickname);
				System.out.print("Nickname: " + nickname);

				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(NM.NNMainPanel);

				currentPanel = POM.POMMainPanel;

				frame.add(currentPanel);
				//frame.add(POM.POMMainPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});

		// VIEW LEADERBOARD
		WM.vlb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				//frame.remove(currentPanel);


				frame.remove(WM.mainPanel);
				frame.getContentPane().removeAll();

				currentPanel = LB.LBMainPanel;

				//frame.add(currentPanel);
				frame.add(LB.LBMainPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});

		// LEADER BOARD EXIT
		LB.exitMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.validate();

				//frame.remove(currentPanel);
				frame.remove(LB.LBMainPanel);
				frame.getContentPane().removeAll();

				currentPanel = WM.mainPanel;

				frame.add(currentPanel);
				//frame.add(WM.mainPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});

		// VIEW CREDITS
		WM.vc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(WM.mainPanel);

				currentPanel = VC.VCMainPanel;

				frame.add(currentPanel);
				//frame.add(VC.VCMainPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}

		});

		// VIEW CREDITS EXIT
		VC.exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(VC.VCMainPanel);

				currentPanel = WM.mainPanel;

				frame.add(currentPanel);
				//frame.add(WM.mainPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}

		});

		// PLAY OPTIONS MENU: PLAYER VS COMPUTER
		POM.PVC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e3) {
				gameMode = "PVC";
				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(POM.POMMainPanel);

				currentPanel = PVC.PVCMainPanel;

				//frame.add(PVC.PVCMainPanel);
				frame.add(currentPanel);

				// changing names
				PVC.p1s.setText(player1.getNickName() + ": ");
				PVC.p1sc.setText(Integer.toString(score1));

				PVC.p2s.setText(aiPlayer.getNickName() + ": ");
				PVC.p2sc.setText(Integer.toString(score2));

				// setting buttons to dice
				ArrayList<Character> shownFaces = new ArrayList<Character>();

				gameBoard.getDice();

				// storing values of shown sides to an arraylist
				for (int r = 0; r < dice.length; r++) {
					for (int c = 0; c < dice[r].length; c++) {
						shownFaces.add(dice[r][c].getShownSide());
					}
				}
				// changing the text of the buttons to the shown sides of dice
				for (int i = 0; i < PVC.buttons.length; i++) {
					PVC.buttons[i].setText(Character.toString(shownFaces.get(i)));
				}

				currentPanel = PVC.PVCMainPanel;

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();
			}
		});

		// PLAY OPTIONS MENU: PLAYER VS PLAYER
		POM.PVP.addActionListener(new ActionListener() { // multiplayer
			public void actionPerformed(ActionEvent e4) {
				System.out.println("player is getting thing");
				gameMode = "PVP";
				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(POM.POMMainPanel);

				currentPanel = PVP.PVPMainPanel;

				//frame.add(PVP.PVPMainPanel);
				frame.add(currentPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});

		// PLAY OPTIONS MENU: PLAYER VS TIME
		POM.PVT.addActionListener(new ActionListener() { // timed
			public void actionPerformed(ActionEvent b) {
				gameMode = "PVT";
				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(POM.POMMainPanel);

				currentPanel = PVT.PVTMainPanel;

				frame.add(currentPanel);
				//frame.add(PVT.PVTMainPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});

		POM.back.addActionListener(new ActionListener() { // back button
			public void actionPerformed(ActionEvent b) {
				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(POM.POMMainPanel);

				currentPanel = WM.mainPanel;

				frame.add(currentPanel);
				//frame.add(PVT.PVTMainPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});


		// PLAYER VS PLAYER: OPTIONS MENU (THREE DOTS)
		PVP.options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {

				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(PVP.PVPMainPanel);

				currentPanel = PM.PMMainPanel;

				//frame.add(PM.PMMainPanel);
				frame.add(currentPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});

		// PLAYER VS TIME: OPTIONS MENU (THREE DOTS)
		PVT.optionsPVT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {

				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(PVP.PVPMainPanel);

				currentPanel = PM.PMMainPanel;

				//frame.add(PM.PMMainPanel);
				frame.add(currentPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});

		// PLAYER VS COMPUTER: OPTIONS MENU (THREE DOTS)
		PVC.options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {

				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(PVP.PVPMainPanel);

				currentPanel = PM.PMMainPanel;

				//frame.add(PM.PMMainPanel);
				frame.add(currentPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});

		// PLAYER VS TIME: OPTIONS MENU (THREE DOTS)
		PVT.optionsPVT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {
				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(PVT.PVTMainPanel);

				//frame.add(PM.PMMainPanel);
				currentPanel = PM.PMMainPanel;

				frame.add(currentPanel);
				//frame.add(PM.PMMainPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});

		// PAUSE MENU: RETURN TO GAME
		PM.back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {
				//Object component = x;

				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(PM.PMMainPanel);

				//frame.add(POM.POMMainPanel);
				//currentPanel = POM.POMMainPanel;

				//frame.add(currentPanel);
				//frame.add(POM.POMMainPanel);


				if (gameMode == "PVP") {
					//currentPanel.remove(currentPanel);
					//currentPanel.remove(CW.CWMainPanel);

					currentPanel = PVP.PVPMainPanel;					
					//frame.add(PVP.PVPMainPanel);
					frame.add(currentPanel);
					//frame.add(PVP.PVPMainPanel);

				} else if (gameMode == "PVC") {
					//currentPanel.remove(currentPanel);
					//currentPanel.remove(CW.CWMainPanel);

					currentPanel = PVC.PVCMainPanel;

					frame.add(currentPanel);
					//frame.add(PVC.PVCMainPanel);

				} else if (gameMode == "PVT") {
					//currentPanel.remove(currentPanel);
					//currentPanel.remove(CW.CWMainPanel);

					currentPanel = PVT.PVTMainPanel;

					frame.add(currentPanel);
					//frame.add(PVT.PVTMainPanel);
				}


				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});

		// PAUSE MENU: COMPLETED WORDS
		PM.viewWords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {
				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(PM.PMMainPanel);
				
				//CW.wordsPanel = new CompletedWords(arrayListToArray(usedWords)).wordsPanel.getComponents();
				
				//updating the completed words in display
				Component[] stuff = new CompletedWords(arrayListToArray(usedWords)).wordsPanel.getComponents();
				
				for (int i = 0; i < stuff.length; ++i) {
					   if ((stuff[i] instanceof Container)) {
					       Container subContainer = (Container)stuff[i];
					       
					       CW.wordsPanel.add(subContainer);
					       
					   }else{
					       //nothing
					   }
					}

				currentPanel = CW.CWMainPanel;

				//frame.add(CW.CWMainPanel);
				frame.add(currentPanel);

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});
		// RETURN TO PLAY OPTION MENU 
		PM.exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent x) {
				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(PM.PMMainPanel);

				currentPanel = POM.POMMainPanel;

				//frame.add(CW.CWMainPanel);
				frame.add(currentPanel);
				
				System.out.println("Developer: Reseting game variables");
				resetVariables(); //reseting variables, preping for next game
				player1.resetPoints();
				player2.resetPoints();
				

				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});

		// COMPLETED WORDS: EXIT
		CW.ReturnToGameCW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.remove(currentPanel);
				frame.getContentPane().removeAll();
				//frame.remove(CW.CWMainPanel);
				//frame.validate();
				//frame.repaint();
				if (gameMode.equals("PVP")) {
					//currentPanel.remove(currentPanel);
					//currentPanel.remove(CW.CWMainPanel);

					currentPanel = PVP.PVPMainPanel;					
					//frame.add(PVP.PVPMainPanel);
					frame.add(currentPanel);
					//frame.add(PVP.PVPMainPanel);

				} else if (gameMode.equals("PVC")) {
					//currentPanel.remove(currentPanel);
					//currentPanel.remove(CW.CWMainPanel);

					currentPanel = PVC.PVCMainPanel;

					frame.add(currentPanel);
					//frame.add(PVC.PVCMainPanel);

				} else if (gameMode.equals("PVT")) {
					//currentPanel.remove(currentPanel);
					//currentPanel.remove(CW.CWMainPanel);

					currentPanel = PVT.PVTMainPanel;

					frame.add(currentPanel);
					//frame.add(PVT.PVTMainPanel);
				}
				// Refresh
				frame.invalidate();
				frame.validate();
				frame.repaint();

			}
		});

		// GAME MODE IMPLEMENTATIONS
		POM.PVC.addActionListener(new ActionListener() { //ai
			public void actionPerformed(ActionEvent e3) {

				Object component = e3.getSource();

				if (loaded == false) { //only render panels, add action listener, and set variables once.
					loaded = true;

					frame.remove(currentPanel);
					frame.add(PVC.PVCMainPanel);
					currentPanel = PVC.PVCMainPanel;

					//setting gamemode
					gameMode = "PVC";

					//player jlabels
					PVC.p1s.setText(player1.getNickName() + ": ");
					PVC.p1sc.setText(Integer.toString(score1));

					nickname = player1.getNickName();
					score1 = player1.getPoints();

					//ai jlabels
					PVC.p2s.setText(aiPlayer.getNickName() + ": ");
					PVC.p2sc.setText(Integer.toString(score2));
					
					//header JLabels
					PVC.timer.setText("[TIMER]: INF");
					PVC.ttc.setText("");
					PVC.tournamentScore.setText("GOAL: " + Integer.toString(tournamentScore));

					//setting buttons to dice
					gameBoard.getDice();

					//storing values of shown sides to an arraylist
					for (int r = 0; r < dice.length; r++) {
						for (int c = 0; c < dice[r].length; c++) {
							shownFaces.add(dice[r][c].getShownSide());
						}
					}
					//changing the text of the buttons to the shown sides of dice
					for (int i = 0; i < PVC.buttons.length; i++) {
						PVC.buttons[i].setText(Character.toString(shownFaces.get(i)));

						buttons.add(PVC.buttons[i]); //storing the panel's buttons in boggle deluxe
						buttons.get(i).addActionListener(this);
						//System.out.print(buttons.get(i).getText());

					}

					PVC.clear.addActionListener(this);
					PVC.enter.addActionListener(this);
					PVC.shuffle.addActionListener(this);
				}

				if (component.equals(PVC.clear)) {
					System.out.println("Clear current string");
					usedPositions.clear();
					currentStr = "";

					PVC.current.setText(currentStr);
				}
				else if (component.equals(PVC.enter)) {

					currentStr = currentStr.toLowerCase(); //turning currentStr to lower case bc boggle letters are upper

					System.out.println("Entering " + currentStr);

					//int indexOfWord = binarySearchRecursive(wordDictionary, 0, wordDictionary.length - 1, currentStr);
					int indexOfWord = Arrays.binarySearch(wordDictionary, currentStr.toLowerCase());
					if (indexOfWord >= 0 && usedWords.contains(currentStr) == false && currentStr.length() >= minimumWordLength) { //checking to see if word entered exists in dictionary and was not already used
						System.out.println("Word is valid");

						player1.addPointsNormal(currentStr.length()); //updating score
						score1 = player1.getPoints();

						PVC.p1sc.setText(Integer.toString(score1));

						usedWords.add(currentStr);
						
						
						
					}
					else {
						System.out.println("Invalid word");
					}

					usedPositions.clear();
					currentStr = "";

					System.out.println("AI's Turn!");
					char[][] letters = charArrayListTo2dArray(shownFaces);
					String AIWord = "";

					for (int i = 0; i < AIDifficulty; i++) {
						//making the FindWordAI find a word given passed arguments
						botAI.attemptFindWord(letters, usedWords, wordDictionary, minimumWordLength);
						//result of attempt
						AIWord = botAI.getFoundWord();
						if (AIWord.equals("!no_word!") == false) {
							break;
						}
					}

					if (AIWord.equals("!no_word!")) {
						System.out.println("AI could not find a word during its turn!");
					}
					else {
						System.out.println("AI found: " + AIWord);

						aiPlayer.addPointsNormal(AIWord.length());
						score2 = aiPlayer.getPoints();

						PVC.p2sc.setText(Integer.toString(score2));

						//usedWords.add(currentStr); -- ai already adds its found word to used words

					}

				}

				else if (component.equals(PVC.shuffle)) {
					System.out.println("Shuffling board");

					//resetting variables
					shownFaces.clear();
					gameBoard.shuffleDie();

					System.out.println("Clear current string");
					usedPositions.clear();
					currentStr = "";
					PVC.current.setText(currentStr);

					//storing values of shown sides to an arraylist
					for (int r = 0; r < dice.length; r++) {
						for (int c = 0; c < dice[r].length; c++) {
							shownFaces.add(dice[r][c].getShownSide());
						}
					}
					//changing the text of the buttons to the shown sides of dice
					for (int i = 0; i < PVC.buttons.length; i++) {
						PVC.buttons[i].setText(Character.toString(shownFaces.get(i)));

						//buttons.add(aiGame.buttons[i]); //storing the panel's buttons in boggle deluxe
						//buttons.get(i).addActionListener(this);
						//System.out.print(buttons.get(i).getText());

					}
				}

				//resetting button colours back to normal after user presses enter or clear or shuffle
				if (component.equals(PVC.clear) || component.equals(PVC.enter) || component.equals(PVC.shuffle)) {
					for (int i = 0; i < buttons.size(); i++) {
						buttons.get(i).setBackground(new Color (248, 249, 241));
					}
				}

				//pressing buttons will add text to current
				for (int i = 0; i < buttons.size(); i++) {
					try {
						if (component.equals(buttons.get(i))) {
							//System.out.println("Button " + (i+1) + " pressed");
							buttons.get(i).setBackground(new Color(255, 255, 0));
							if (i < 5) {

								if (validSelection(("0"+Integer.toString(i, 5)), usedPositions)) {
									currentStr += (buttons.get(i)).getText();        

								}
							} else if (validSelection(Integer.toString(i, 5), usedPositions)) {
								currentStr += buttons.get(i).getText();
							}
						}


					} catch (Exception e) {
					}
				}

				//ending game if plr1 or ai reaches tournament score
				if (score1 >= tournamentScore) {
					gameEnd = true;

				}
				else if (score2 >= tournamentScore) { //ai won
					gameEnd = true;
				}

				if (gameEnd) { //add score panel

					System.out.println(nickname + " " + score1);

					//making a new entry into highscores when the game ends by either player or ai
					highscores.newEntry(nickname, score1);

					try {
						highscores.saveScoresToFile();
					} catch (FileNotFoundException e) {
						//nothing
					}
					//updating leaderboard panel
					LB = new LeaderBoard(highScoreNames, highScores);

					//displaying game over panel
					frame.remove(currentPanel);
					frame.add(GO.GOMainPanel);
					
					currentPanel = GO.GOMainPanel;
					//resetVariables(); //reseting variables, preping for next game
				}

				PVC.current.setText(currentStr);
				frame.validate();
			}

		});
		
		POM.PVP.addActionListener(new ActionListener() { //multiplayer
			public void actionPerformed(ActionEvent e) {
				PVP.tournamentScore.setText("GOAL: " + Integer.toString(tournamentScore));
				if (firstTime == true) {
					PVP.seconds = 0;
					PVP.timer1.schedule(new TimerTask() {
						int count = 16;
						public void run() {
							PVP.seconds++;
							if (PVP.seconds < count){
								PVP.ttc.setText(Integer.toString(PVP.seconds));
								PVP.ttc.repaint();
								PVP.PVPMainPanel.repaint();
								frame.validate();
								frame.repaint();
								System.out.println(PVP.seconds);
								//System.out.println("done");
							}
							
							else if (PVP.seconds >= count) {
								PVP.timer.setText("Time's Up!");
								PVP.ttc.setText("");
								PVP.seconds = 0;
								PVP.gwc.setText("");
								frame.remove(currentPanel);
								frame.add(GO.GOMainPanel);
								frame.repaint();				
								System.out.println("\ntimer is done, all good :)");	
								PVP.timer1.cancel();
							}
						}
					
					}, delay, period);
					firstTime = false;
				}
				frame.remove(currentPanel);
				frame.add(PVP.PVPMainPanel);
				currentPanel = PVP.PVPMainPanel;
				period = 1000;
				Object component = e.getSource();
				if (component.equals(PVP.enter)) {
					PVP.seconds = 0;
					PVP.timer1.cancel();
					PVP.timer1 = new Timer();
					PVP.timer1.schedule(new TimerTask() {
						int count = 16;
						public void run() {
							PVP.seconds++;
							if (PVP.seconds < count){
								PVP.ttc.setText(Integer.toString(PVP.seconds));
								PVP.ttc.repaint();
								PVP.PVPMainPanel.repaint();
								frame.validate();
								frame.repaint();
								System.out.println(PVP.seconds);
								//System.out.println("done");
							}
							
							else if (PVP.seconds >= count) {
								PVP.timer.setText("Time's Up!");
								PVP.ttc.setText("");
								PVP.seconds = 0;
								PVP.gwc.setText("");
								frame.remove(currentPanel);
								frame.add(PVP.PVPMainPanel); //change to showScore panel
								frame.repaint();				
								System.out.println("\ntimer is done, all good :)");	
								PVP.timer1.cancel();
							}
						}
					}, delay, period);
					if (firstTime == false) {
					}
					if (playerOne == true) {
						playerOne = false;
					} else {
						playerOne = true;
					}
					//System.out.println("asd;lfkjas;dlkfj");
					
					
					System.out.println("did wait");
				}
				if (loaded == false) { //only render panels, add action listener, and set variables once.
					loaded = true;
					frame.remove(currentPanel);
					frame.add(PVP.PVPMainPanel);

					//setting gamemode
					gameMode = "PVP";

					//changing names
					PVP.p1s.setText(player1.getNickName());
					PVP.p1sc.setText(Integer.toString(score1));
					//setting buttons to dice
					gameBoard.getDice();

					//storing values of shown sides to an arraylist
					for (int r = 0; r < dice.length; r++) {
						for (int c = 0; c < dice[r].length; c++) {
							shownFaces.add(dice[r][c].getShownSide());
						}
					}
					//changing the text of the buttons to the shown sides of dice
					for (int i = 0; i < PVP.buttons.length; i++) {
						PVP.buttons[i].setText(Character.toString(shownFaces.get(i)));

						buttons.add(PVP.buttons[i]); //storing the panel's buttons in boggle deluxe
						buttons.get(i).addActionListener(this);
						//System.out.print(buttons.get(i).getText());
					}

					PVP.clear.addActionListener(this);
					PVP.enter.addActionListener(this);
					PVP.shuffle.addActionListener(this);
				}
				if (component.equals(PVP.clear)) {
					System.out.println("Clear current string");
					usedPositions.clear();
					currentStr = "";

					PVP.gwc.setText(currentStr);
				}
				else if (component.equals(PVP.enter)) {
					
					currentStr = currentStr.toLowerCase(); //turning currentStr to lower case bc boggle letters are upper
					
					System.out.println("Entering " + currentStr);

					//int indexOfWord = binarySearchRecursive(wordDictionary, 0, wordDictionary.length - 1, currentStr);
					int indexOfWord = Arrays.binarySearch(wordDictionary, currentStr.toLowerCase());
					if (indexOfWord >= 0 && usedWords.contains(currentStr) == false && currentStr.length() >= minimumWordLength) { //checking to see if word entered exists in dictionary and was not already used
						System.out.println("Word is valid");

						if (playerOne) {	
							
							player1.addPointsNormal(currentStr.length()); //updating score
							score1 = player1.getPoints();

							PVP.p1sc.setText(Integer.toString(score1));
							
						} else {
							player2.addPointsNormal(currentStr.length());
							score2 = player2.getPoints();
							PVP.p2sc.setText(Integer.toString(score2));
							playerOne = true;
						}
						
						usedWords.add(currentStr);
					}
					else {
						System.out.println("Invalid word");
					}

					usedPositions.clear();
					currentStr = "";
				} else if (component.equals(PVP.shuffle)) {
					System.out.println("Shuffling board");
					
					//resetting variables
					shownFaces.clear();
					gameBoard.shuffleDie();
					
					System.out.println("Clear current string");
					usedPositions.clear();
					currentStr = "";
					PVP.gwc.setText(currentStr);
					
					//storing values of shown sides to an arraylist
					for (int r = 0; r < dice.length; r++) {
						for (int c = 0; c < dice[r].length; c++) {
							shownFaces.add(dice[r][c].getShownSide());
						}
					}
					//changing the text of the buttons to the shown sides of dice
					for (int i = 0; i < PVP.buttons.length; i++) {
						PVP.buttons[i].setText(Character.toString(shownFaces.get(i)));
					}
				}

				//resetting button colours back to normal after user presses enter or clear or shuffle
				if (component.equals(PVP.clear) || component.equals(PVP.enter) || component.equals(PVP.shuffle)) {
					for (int i = 0; i < buttons.size(); i++) {
						buttons.get(i).setBackground(new Color (248, 249, 241));
					}
				}
				
				
				//pressing buttons will add text to current
				for (int i = 0; i < buttons.size(); i++) {
					try {
						if (component.equals(buttons.get(i))) {
							//System.out.println("Button " + (i+1) + " pressed");
							if (playerOne) {
								buttons.get(i).setBackground(new Color(247, 67, 35));
							}
							else {
								buttons.get(i).setBackground(new Color(71, 123, 245));
							}
							
							if (i < 5) {

								if (validSelection(("0"+Integer.toString(i, 5)), usedPositions)) {
									currentStr += (buttons.get(i)).getText();   
									//delay+=200;  
									period += 1400;   

								}
							} else if (validSelection(Integer.toString(i, 5), usedPositions)) {
								currentStr += buttons.get(i).getText();
								//delay+=200;
								period += 1400;
							}
						}


					} catch (Exception e2) {
					}
				}
				
				//ending game if plr1 or ai reaches tournament score
				if (score1 >= tournamentScore) {
					gameEnd = true;

				}
				else if (score2 >= tournamentScore) { //ai won
					gameEnd = true;
				}

				if (gameEnd) { //add score panel

					System.out.println(nickname + " " + score1);

					//making a new entry into highscores when the game ends by either player or ai
					highscores.newEntry(nickname, score1);

					try {
						highscores.saveScoresToFile();
					} catch (FileNotFoundException x) {
						//nothing
					}
					//updating leaderboard panel
					LB = new LeaderBoard(highScoreNames, highScores);

					//displaying game over panel
					frame.remove(currentPanel);
					frame.add(GO.GOMainPanel);
					
					currentPanel = GO.GOMainPanel;
					//resetVariables(); //reseting variables, preping for next game
				}
				
				PVP.gwc.setText(currentStr);
				frame.validate();
				frame.repaint();
				
			}			
		});
		
		POM.PVT.addActionListener(new ActionListener() { //timed
			public void actionPerformed(ActionEvent e) {
				frame.remove(currentPanel);
				frame.add(PVT.PVTMainPanel);
				currentPanel = PVT.PVTMainPanel;
				
				PVT.tournamentScorePVT.setText("GOAL: " + Integer.toString(tournamentScore));
				
				Object component = e.getSource();

				if (loaded == false) { //only render panels, add action listener, and set variables once.
					loaded = true;
					frame.remove(currentPanel);
					frame.add(PVT.PVTMainPanel);

					//setting gamemode
					gameMode = "PVT";

					//changing names
					PVT.yourScorePVT.setText(Integer.toString(score1));

					//setting buttons to dice
					gameBoard.getDice();

					//storing values of shown sides to an arraylist
					for (int r = 0; r < dice.length; r++) {
						for (int c = 0; c < dice[r].length; c++) {
							shownFaces.add(dice[r][c].getShownSide());
						}
					}
					//changing the text of the buttons to the shown sides of dice
					for (int i = 0; i < PVT.buttonsPVT.length; i++) {
						PVT.buttonsPVT[i].setText(Character.toString(shownFaces.get(i)));

						buttons.add(PVT.buttonsPVT[i]); //storing the panel's buttons in boggle deluxe
						buttons.get(i).addActionListener(this);
						//System.out.print(buttons.get(i).getText());
					}

					PVT.clearPVT.addActionListener(this);
					PVT.enterPVT.addActionListener(this);
					PVT.shufflePVT.addActionListener(this);
				}

				if (component.equals(PVT.clearPVT)) {
					System.out.println("Clear current string");
					usedPositions.clear();
					currentStr = "";

					PVT.guessedPVT.setText(currentStr);
				}
				else if (component.equals(PVT.enterPVT)) {
					
					currentStr = currentStr.toLowerCase(); //turning currentStr to lower case bc boggle letters are upper
					
					System.out.println("Entering " + currentStr);

					//int indexOfWord = binarySearchRecursive(wordDictionary, 0, wordDictionary.length - 1, currentStr);
					int indexOfWord = Arrays.binarySearch(wordDictionary, currentStr.toLowerCase());
					if (indexOfWord >= 0 && usedWords.contains(currentStr) == false && currentStr.length() >= minimumWordLength) { //checking to see if word entered exists in dictionary and was not already used
						System.out.println("Word is valid");

						player1.addPointsNormal(currentStr.length()); //updating score
						score1 = player1.getPoints();

						PVT.scPVT.setText(Integer.toString(score1));
						
						usedWords.add(currentStr);
					}
					else {
						System.out.println("Invalid word");
					}

					usedPositions.clear();
					currentStr = "";
				} else if (component.equals(PVT.shufflePVT)) {
					System.out.println("Shuffling board");
					
					//resetting variables
					shownFaces.clear();
					gameBoard.shuffleDie();
					
					System.out.println("Clear current string");
					usedPositions.clear();
					currentStr = "";
					PVT.guessedPVT.setText(currentStr);
					
					//storing values of shown sides to an arraylist
					for (int r = 0; r < dice.length; r++) {
						for (int c = 0; c < dice[r].length; c++) {
							shownFaces.add(dice[r][c].getShownSide());
						}
					}
					//changing the text of the buttons to the shown sides of dice
					for (int i = 0; i < PVT.buttonsPVT.length; i++) {
						PVT.buttonsPVT[i].setText(Character.toString(shownFaces.get(i)));
					}
				}

				//resetting button colours back to normal after user presses enter or clear or shuffle
				if (component.equals(PVT.clearPVT) || component.equals(PVT.enterPVT) || component.equals(PVT.shufflePVT)) {
					for (int i = 0; i < buttons.size(); i++) {
						buttons.get(i).setBackground(new Color (248, 249, 241));
					}
				}

				//pressing buttons will add text to current
				for (int i = 0; i < buttons.size(); i++) {
					try {
						if (component.equals(buttons.get(i))) {
							//System.out.println("Button " + (i+1) + " pressed");
							buttons.get(i).setBackground(new Color(255, 255, 0));
							if (i < 5) {

								if (validSelection(("0"+Integer.toString(i, 5)), usedPositions)) {
									currentStr += (buttons.get(i)).getText();   
									//delay+=200;  
									period += 1400;   

								}
							} else if (validSelection(Integer.toString(i, 5), usedPositions)) {
								currentStr += buttons.get(i).getText();
								//delay+=200;
								period += 1400;
							}
						}


					} catch (Exception e2) {
					}
				}
				PVT.timer.schedule(new TimerTask() {
					int count = 16;
					public void run() {
						PVT.seconds++;
						if (PVT.seconds < count){
							PVT.ttcPVT.setText(Integer.toString(PVT.seconds));
							System.out.println("done");
						} else if (PVT.seconds == count) {
							PVT.timerPVT.setText("Time's Up!");
							PVT.ttcPVT.setText("");
							PVT.timer.cancel();
							frame.remove(PVT.PVTMainPanel);
							frame.add(GO.GOMainPanel);
							frame.repaint();					
						}
					}
				
				}, delay, period);
				PVT.guessedPVT.setText(currentStr);
				frame.validate();
				frame.repaint();
			}
		});
		
		GO.restart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(currentPanel);
                frame.getContentPane().removeAll();
                //frame.remove(CW.CWMainPanel);
                //frame.validate();
                //frame.repaint();
                
                
                if (gameMode.equals("PVP")) {
                    //currentPanel.remove(currentPanel);
                    //currentPanel.remove(CW.CWMainPanel);
                    GO.p2s.setText(nickname2 + ": " + score2);
                    GO.p1s.setText(nickname + ": " + score1);

                    currentPanel = WM.mainPanel;
                    //frame.add(PVP.PVPMainPanel);
                    frame.add(currentPanel);
                    //frame.add(PVP.PVPMainPanel);

                } else if (gameMode.equals("PVC")) {
                    //currentPanel.remove(currentPanel);
                    //currentPanel.remove(CW.CWMainPanel);
                    GO.p2s.setText(nickname + ": " + score1);
                    GO.p1s.setText("Computer: " + score2);

                    currentPanel = PVC.PVCMainPanel;

                    frame.add(currentPanel);
                    //frame.add(PVC.PVCMainPanel);

                } else if (gameMode.equals("PVT")) {
                    //currentPanel.remove(currentPanel);
                    //currentPanel.remove(CW.CWMainPanel);

                    GO.p1s.setText(nickname + ": " + score1);

                    currentPanel = PVT.PVTMainPanel;

                    frame.add(currentPanel);
                    //frame.add(PVT.PVTMainPanel);
                }
                // Refresh
                frame.invalidate();
                frame.validate();
                frame.repaint();
            }
              
        });

		//Game Modes Sound ON/OFF Button

		//Player VS Computer Sound ON/OFF Button
		PVC.soundOn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				music.playMusic();
			}
		});

		PVC.soundOff.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x) {
				music.stopMusic();
			}
		});

		//Player VS Player Sound ON/OFF Button
		PVP.soundOn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				music.playMusic();
			}
		});

		PVP.soundOff.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x) {
				music.stopMusic();
			}
		});

		//Player VS Time Sound ON/OFF Button
		PVT.soundOnPVT.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				music.playMusic();
			}
		});

		PVT.soundOffPVT.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent x) {
				music.stopMusic();
			}
		});

	}

	public static void timedMode() {
		PlayerVsTime game = new PlayerVsTime();

		// display board
		Timer timer = new Timer();
		int seconds = 15;
		timer.scheduleAtFixedRate(new TimerTask() {
			int counter = 0;

			public void run() {
				counter++;
				if (counter < seconds) {
					System.out.println("Time passed: " + counter + " seconds");
				} else {
					System.out.println("Timer expired! 15 seconds have passed.");
					timer.cancel();
				}
			}
		}, 0, 1000);

	}

	public static void addAiActionListenerToButton(int i) {
		PVC.buttons[i].addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent event) {
				// which object triggered the event
				Object component = event.getSource();
				for (int i = 0; i < PVC.buttons.length; i++) {
					try {
						if (component.equals(PVC.buttons[i])) {
							System.out.println("Button " + (i + 1) + " pressed");
							if (i < 5) {
								if (PVC.validSelection(("0" + Integer.toString(i, 5)), PVC.usedPositions)) {
									PVC.word += (PVC.buttons[i]).getText();

								}
							} else if (PVC.validSelection(Integer.toString(i, 5), PVC.usedPositions)) {
								PVC.word += PVC.buttons[i].getText();
							}
						}
					} catch (Exception e) {
					}
				}
				PVC.wordLabel.setText(PVC.word);
				PVC.PVCMainPanel.revalidate();
			}
		});
	}

	public static void addPVPActionListenerToButton(int i) {
		PVP.buttons[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PVP.word += PVP.buttons[i].getText();
			}
		});
	}

	public static void addPVTActionListenerToButton(int i) {
		PVT.buttonsPVT[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PVT.word += PVT.buttonsPVT[i].getText();
			}
		});
	}
	
	/**
	 * This recursive searching method repeatedly divides the array until it can
	 * return the index of the target found in the given string array. Takes in a
	 * string array, the minimum, the maximum, and the target string to search for.
	 * Returns -1 if target does not exist in the array.
	 * 
	 * @param array
	 * @param min
	 * @param max
	 * @param target
	 * @return index (int)
	 */
	public static int binarySearchRecursive(String[] array, int min, int max, String target) {

		if (min > max) { // return -1 if word does not exist
			return -1;
		}

		int middleIndex = min + (max - 1) / 2;

		String middleString = array[middleIndex]; // the value at middle index
		int result = middleString.compareToIgnoreCase(target);

		if (result == 0) {
			return middleIndex;
		} else if (result < 0) { // ignore left half
			return binarySearchRecursive(array, middleIndex + 1, max, target);
		} else { // ignore right half
			return binarySearchRecursive(array, min, middleIndex - 1, target);
		}
	}
	
	/**
	 * This searching method returns the index of the target in the passed string array
	 * by repeatedly dividing the array in half until the target is reached.
	 * 
	 * If target cannot be found, returns -1.
	 * 
	 * Pre: array, target
	 * Post: index of target in array
	 * @param array (String[])
	 * @param target (String)
	 * @return 
	 */
	public static int binarySearchIterative(String[] array, String target) {
		int min = 0, max = array.length - 1; 

		while (min <= max) {
			//finding the middle index
			int middleIndex = min + (max - 1)/2;

			//the value at middle index
			String middleString = array[middleIndex]; 

			//comparing found value with the target to see which half of the array to eliminate search
			int result = middleString.compareToIgnoreCase(target);

			if (result == 0) {
				return middleIndex;
			}
			else if (result < 0) { //ignore left half
				min = middleIndex + 1;
			}
			else { //ignore right half
				max = middleIndex - 1;
			}
		}
		//target could not be found, return -1
		return -1;

	}

	/**
	 * Pre: arraylist of strings Post: array of strings
	 * 
	 * @param arraylist
	 * @return
	 */
	public static String[] arrayListToArray(ArrayList<String> arraylist) {

		String[] stringArray = new String[arraylist.size()];

		int counter = 0;
		for (String element : arraylist) {
			stringArray[counter] = element;
			counter++;
		}

		return stringArray;

	}
	public static char[][] charArrayListTo2dArray(ArrayList<Character> arraylist) {

		char[][] array2D = new char[5][5];

		int counter = 0;
		for (int r = 0; r < array2D.length; r++) {
			for (int c = 0; c < array2D[r].length; c++) {
				array2D[r][c] = Character.toLowerCase(arraylist.get(counter));
				counter++;
			}
		}

		return array2D;
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
				//System.out.println(pos1 + " is near " + pos2);
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
	
	/**
	 * This procedure will reset the class defined vars to their initial or blank values
	 */
	public static void resetVariables() {
		score1 = 0;
        score2 = 0;
        usedWords.clear();
        
        CW.wordsPanel.removeAll();
        
        gameEnd = false;
        //loaded = false;
	}


}
