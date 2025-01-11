package newcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Alex C
 */

public class Highscore {
	
	private File file = new File("BoggleHighScores.txt"); //referencing file
	private Scanner in; //initializing scanner for file
	private PrintWriter output; //initializing printwriter
	
	private int[] highScoresArray = {0, 0, 0};
	private int HSACounter = 0;
	private String[] highScoreNames = {"null", "null", "null"};

	/**
	 * Default constructor
	 */
	Highscore() {
		
	}
	
	/**
	 * This method creates a txt file "BoggleHighScores.txt" to store highscores, generates placeholder values.
	 * If the file already exist, no new file is created.
	 * 
	 * @throws FileNotFoundException
	 */
	public void createScoreFile() throws FileNotFoundException {
		/*
		 * creating scanner for file if file exists, otherwise creates a new file with scores already on it
		 */
		try { //try catch to catch error returned if scanner cannot be made on file (does not exist)
			in = new Scanner(file); //creating a scanner for the file to read from it
			System.out.println("Developer: Score file does exist"); //visualizing code

		} catch (Exception x) { //the file does not exist, need to create one and write scores onto it
			System.out.println("Developer: Score file does not exist, creating file"); //visualizing code, returns that file does not exist

			output = new PrintWriter(file); //finishing initializing of PrintWriter
			for (int i = 0; i < 3; i++) { //for loop to write empty scores for the new file
				output.println("null: " + "0"); //writing to file
			}
			output.close(); //closing file after finish writing
			in = new Scanner(file); //now, creating scanner for the file
		}
	}
	
	/**
	 * This method reads highscores from file and stores it in its
	 * int[] highScoresArray and its String[] highScoreNames attributes.
	 */
	public void prepareHighScores() {
		/*
		 * display high scores and store values in array
		 */
		System.out.println("Displaying high scores");
		while (in.hasNext()) { //checks to see if the next token is available (I assume it only runs for as many tokens there are in the file)
			
			String nextLine = in.nextLine();
			//System.out.println(nextLine);
			
			highScoreNames[HSACounter] = nextLine.substring(0, nextLine.indexOf(":"));
			
			highScoresArray[HSACounter] = Integer.valueOf(nextLine.substring(nextLine.indexOf(":") + 1, nextLine.length()).trim());
			
			//System.out.println(highScoreNames[HSACounter] + ": " + highScoresArray[HSACounter]); //prints the scores stored in array
			HSACounter++; //increment the counter when done reading score
			
		}
	}
	
	/**
	 * Writing stored names and scores to the text file.
	 * @throws FileNotFoundException
	 */
	public void saveScoresToFile() throws FileNotFoundException {
		/*
		 * Writing high scores to file
		 */
		output = new PrintWriter(file);
		System.out.println("Saved highscores:"); //showing updated highscores
		for (int i = 0; i < highScoresArray.length; i++) { //writing the updated high scores to file, saving + printing high scores after game end
			System.out.println(highScoreNames[i] + ": " + highScoresArray[i]); //showing updated highscores, final results :)
			this.output.println(highScoreNames[i] + ": " + highScoresArray[i]); //writing scores onto file with print writer
		}
		output.close(); //closing printwriter, saving changes
	}
	
	/**
	 * Attempt to enter a new entry (nickname, score) into the object's highscore arrays.
	 * Entries are automatically sorted from greatest to least score (up to 3).
	 * @param nickname (String)
	 * @param score (int)
	 */
	public void newEntry(String nickname, int score) {
		//updating highscores
		highScoreUpdater(highScoresArray, highScoreNames, score, nickname);
	}
	
	/**
	 * Returns a String array of nicknames from the hs file
	 * @return
	 */
	public String[] getNicknames() {
		return highScoreNames;
	}
	
	/**
	 * Returns an int array of scores from the hs file
	 * @return
	 */
	public int[] getHighScores() {
		return highScoresArray;
	}
	
	/**
	 * This procedure updates the high score array from descending order (greatest to least).
	 * Bumps the lowest score out of the array (if any).
	 * @param highScoresArray
	 * @param highScoreNames
	 * @param finalBalance
	 */
	public static void highScoreUpdater(int highScoresArray[], String highScoreNames[], int highscore, String name) {
		if (highscore > highScoresArray[0]) { // if the final balance was higher than the previous high score
			highScoresArray[2] = highScoresArray[1]; //shift score two to score three
			highScoreNames[2] = highScoreNames[1];
			
			highScoresArray[1] = highScoresArray[0]; //shift previous score one to score two
			highScoreNames[1] = highScoreNames[0];
			
			highScoresArray[0] = highscore; //new highscore is the final balance
			highScoreNames[0] = name;
		}
		else if (highscore > highScoresArray[1]) { //otherwise, if the total roll was not higher than HS1 but higher than HS2:
			highScoresArray[2] = highScoresArray[1]; //shift score two to score three
			highScoreNames[2] = highScoreNames[1];
			
			highScoresArray[1] = highscore; //highscore two is the final balance
			highScoreNames[1] = name;
		}
		else if (highscore > highScoresArray[2]) { //otherwise, if the total roll from that round was only higher than the third highest score
			highScoresArray[2] = highscore; //high score three is the final balance
			highScoreNames[2] = name;
		}
	}

}
