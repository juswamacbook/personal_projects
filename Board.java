package newcode;

import java.util.*;

/**
 * @authors Alex C, Barsam R
 *
 */
public class Board {

	//attributes
	private Dice[][] dice = new Dice[5][5];
	
	//board should be instantiated with dice already in it!!!!!!
	
	/**
	 * Default constructor
	 */
	public Board() {
	}
	public Board(Dice[][] dice) {
		this.dice = dice;
	}
	//this helper method rearranges the position of dice
	public void shuffleDie() {
		
		ArrayList<Dice> tempArrayList = new ArrayList<Dice>();
		
		//adding contents of board into an arraylist for shuffling and rerolling the dice during this process
				for (int r = 0; r < dice.length; r++) {
					for (int c = 0; c < dice[r].length; c++) {
						dice[r][c].reroll();
						tempArrayList.add(dice[r][c]); 
					}
				}
		
		//shuffling the contents of the arraylist
		Collections.shuffle(tempArrayList);
		
		//adding contents of arraylist back into the 2d array
		for (int r = 0; r < dice.length; r++) {
			for (int c = 0; c < dice[r].length; c++) {
				dice[r][c] = tempArrayList.get(5*r + c);
			}
		}
	}
	public Dice getDie(int r, int c) {
		return dice[r][c];
	}
	public Dice[][] getDice() {
		return dice;
	}
	public void setDice(Dice[][] dice) {
		this.dice = dice;
	}
	public void setDie(int r, int c, Dice die) {
		this.dice[r][c] = die;
	}
}
