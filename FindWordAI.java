package newcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Alex C 
 * This class is responsible AI's ability to find words in the boggle board.
 * Start date: 2024.01.15
 * Version date: 2024-01-22
 * 
 * Attributes: 
 * foundWord
 * 
 * Actions: 
 * attemptFindWord
 * getFoundWord
 * 
 */
public class FindWordAI {
	
	private String foundWord;
	//private ArrayList<String> usedWords;
	
	/**
	 * Default constructor
	 */
	FindWordAI() {
		
	}
	
	/**
	 * This method utilizes recursion to find a valid word.
	 * Calls the findWord method located in the FindWordAI class. Please see in file for more details.
	 * Attribute foundWord is set to the word found.
	 * If no word could be found, found word attribute is set to "!no_word!".
	 * @param letters (char[][])
	 * @param usedWords (ArrayList of strings)
	 * @param wordDictionary (String[])
	 * @param minimumLength (int)
	 */
	public void attemptFindWord(char[][] letters, ArrayList<String> usedWords, String[] wordDictionary, int minimumLength) {
		this.foundWord = findWord(letters, usedWords, wordDictionary, minimumLength);
	}
	
	/**
	 * Returns the word found
	 * @return string
	 */
	public String getFoundWord() {
		return foundWord;
	}
	

	/**
	 * This method attempts to find a valid word given the passed 2d char array, starting from a random
	 * position. findWordRecursive is used. See 
	 * 
	 * @param letters (char[])
	 * @param usedWords (ArrayList of Strings)
	 * @param wordDictionary (String[])
	 * @param minimumLength (int)
	 * @return found word (string), if no word could be found this method returns "!no_word!"
	 */
	public static String findWord(char[][] letters, ArrayList<String> usedWords, String[] wordDictionary, int minimumLength) {

		ArrayList<String> usedPositions = new ArrayList<>();
		String currentStr = "";

		// Choose a random letter on the board
		int rowNum = randomNum(0, letters.length);
		int colNum = randomNum(0, letters[rowNum].length);

		// Getting letter from random coordinate
		String foundLetter = String.valueOf(letters[rowNum][colNum]);
		currentStr += foundLetter; // concatenating found letter to the current string, our starting letter
		String charPos = toIntPair(rowNum, colNum);

		//System.out.println("Word First Letter Pos: " + charPos);
		//System.out.println("Starting letter: " + foundLetter);

		usedPositions.add(charPos);

		String wordFound = findWordRecursive(letters, charPos, currentStr, usedPositions, usedWords, wordDictionary, minimumLength);

		// adding found word to used word dic so it can't be guessed again
				if (!usedWords.contains(wordFound)) {
					if (wordFound.equals("!no_word!") == false) {
						usedWords.add(wordFound);
					}
				}

		return wordFound;
	}

	/**
	 * Recursive word finding method. Searches for letters in a 1 tile
	 * radius. Uses found, valid letters to create prefixes. Checks if dictionary
	 * contains words that start with the prefix.
	 * 
	 * Base case: Return current string when current string meets criteria (exists
	 * in dictionary, above or equal to minimum length) 
	 * 
	 * Recursive case: Call recursive method with new starting 
	 * position, new current string, and current used positions,
	 * 
	 * @param letters
	 * @param startingCoordinatePoint
	 * @param currentStr
	 * @param usedPositions
	 * @param usedWords
	 * @param wordDictionary
	 * @param minimumLength
	 * @return
	 */
	public static String findWordRecursive(char[][] letters, String startingCoordinatePoint, String currentStr, ArrayList<String> usedPositions, ArrayList<String> usedWords, String[] wordDictionary, int minimumLength) {
		//System.out.println("RUNNING RECURSIVE METHOD CALL " + currentStr);
		/*
		 * base case
		 * Check to see if the current string meets the criteria for a valid word:
		 * In dictionary, has not been used already, and meets minimum specified length, 
		 */
		//binarySearchRecursive(wordDictionary, 0, wordDictionary.length - 1, currentStr) - see monitor and control doc
		if (Arrays.binarySearch(wordDictionary, currentStr) != -1  && usedWords.contains(currentStr) == false && currentStr.length() >= minimumLength) {
			//System.out.println(currentStr + " is valid!");
			return currentStr;
		}

		// unpacking coordinate string into vars
		int rowNum = getKey(startingCoordinatePoint);
		int colNum = getValue(startingCoordinatePoint);

		//System.out.println("Starting at: " + startingCoordinatePoint);

		// initializing variables
		ArrayList<Integer> searchNumbers = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 6, 7, 8));
		int randomIndex;
		String nextLetter;
		int tempRowNum = rowNum;
		int tempColNum = colNum;
		String tempCharPos = "";

		do { 
			randomIndex = randomNum(0, searchNumbers.size()); //generate a random search number to determine which tile to look at
			switch (searchNumbers.get(randomIndex)) {
			case 1: // mid right
				tempRowNum = rowNum;
				tempColNum = colNum + 1;
				break;
			case 2: // bottom right
				tempRowNum = rowNum + 1;
				tempColNum = colNum + 1;
				break;
			case 3: // bottom
				tempRowNum = rowNum + 1;
				tempColNum = colNum;
				break;
			case 4: // bottom left
				tempRowNum = rowNum + 1;
				tempColNum = colNum - 1;
				break;
			case 5: // mid left
				tempRowNum = rowNum;
				tempColNum = colNum - 1;
				break;
			case 6: // top left
				tempRowNum = rowNum - 1;
				tempColNum = colNum - 1;
				break;
			case 7: // top
				tempRowNum = rowNum - 1;
				tempColNum = colNum;
				break;
			case 8: // top right
				tempRowNum = rowNum - 1;
				tempColNum = colNum + 1;
				break;
			}
			searchNumbers.remove(randomIndex); //remove the number at the index after use

			tempCharPos = toIntPair(tempRowNum, tempColNum);

			try { // try catch for validating in bounds
				nextLetter = String.valueOf(letters[tempRowNum][tempColNum]);

				// validating for if letterpos already used
				if (usedPositions.contains(tempCharPos)) {
					//System.out.println("Already used " + tempCharPos);
				} else { // letter is valid (not already used, in bounds) - 2024.01.15
					//System.out.println("letter found: " + nextLetter);
					String[] cutDictionary = shortenDictionary(currentStr + nextLetter, wordDictionary, usedWords);

					// if the shortened dictionary has words where they have the string prefix
					if (cutDictionary.length > 0) {
						usedPositions.add(tempCharPos);
						
						//Recursive call, restart search from a new starting position
						currentStr = findWordRecursive(letters, tempCharPos, (currentStr + nextLetter), usedPositions, usedWords, cutDictionary, minimumLength);
					}
					// prefix has 0 leads, the current string is a dead end
					else {
						//System.out.println("Dead end reached");
					}

				}

			} catch (Exception ArrayIndexOutOfBoundsException) {
				//no recursive call if unaccessible letter
			}

		} while (searchNumbers.size() > 0);	//end of do while, all tiles around the starting tile have been checked

		/*
		 * base case
		 * Check to see if the current string meets the criteria for a valid word:
		 * In dictionary, Meet minimum specified length, Has not been used already
		 */
		//binarySearchRecursive(wordDictionary, 0, wordDictionary.length - 1, currentStr) - see monitor and control doc
		if (Arrays.binarySearch(wordDictionary, currentStr) != -1 && usedWords.contains(currentStr) == false && currentStr.length() >= minimumLength) {
			return currentStr;
		}

		return "!no_word!";
	}

	/**
	 * This method returns a random number given the range (inclusive - exclusive)
	 * 
	 * @param min integer
	 * @param max integer
	 * @return
	 */
	public static int randomNum(int min, int max) {
		Random randomGen = new Random();

		int num = randomGen.nextInt((max - min)) + min;
		return num;
	}

	/**
	 * This method takes in a character and returns true/false depending if passed
	 * char is a vowel
	 * 
	 * @param target (char)
	 * @return returns true if passed char is a vowel, otherwise returns false
	 */
	public static boolean isVowel(char target) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'y' };

		for (int i = 0; i < vowels.length; i++) {
			if (target == vowels[i]) {
				return true;
			}
		}
		return false; // otherwise, not a vowel

	}

	/**
	 * This method takes in a character and returns true/false depending if passed
	 * char is a vowel
	 * 
	 * @param target (String)
	 * @return returns false if passed String is a vowel, otherwise returns false
	 */
	public static boolean isVowel(String target) {
		String[] vowels = { "a", "e", "i", "o", "u", "y" };

		for (int i = 0; i < vowels.length; i++) {
			if (target.equals(vowels[i])) {
				return true;
			}
		}
		return false; // otherwise, not a vowel

	}

	/**
	 * Takes in 2 integers, concatenates them into one "pair" (string)
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static String toIntPair(int x, int y) {
		return (String.valueOf(x) + String.valueOf(y));
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
	 * This method returns a shortened arraylist of words given a prefix string and
	 * a string dictionary to sort through It is assumed the passed dictionary is in
	 * alphabetical order.
	 * 
	 * @param prefix         String
	 * @param wordDictionary String[]
	 * @param usedWords      ArrayList of Strings
	 * @return
	 */
	public static String[] shortenDictionary(String prefix, String[] wordDictionary, ArrayList<String> usedWords) {
		// assuming the dictionary is sorted in alphabetical order..
		int indexOfFirstOccurrence = -1;
		//getting the index of the first occurrence

		for (int i = 0; i < (wordDictionary.length); i++) {
			if (wordDictionary[i].startsWith(prefix)) {
				indexOfFirstOccurrence = i;
				break;
			}
		}

		//if occurrence could not be found at all, return an empty array
		if (indexOfFirstOccurrence  == -1) {
			String[] empty = {};
			return empty;
		}

		//System.out.println("Index of first occ: " + indexOfFirstOccurrence);
		//System.out.println("Prefix: " + prefix);

		//getting all words that match the prefix, excluding those already found during the game
		ArrayList<String> words = new ArrayList<String>();
		String wordFound = "";
		boolean occurrenceEnd = false;
		int counter = 0;
		//repeat until the word found no longer starts with the prefix
		do {
			//search starts from the index of the first occurrence
			try {
				wordFound = wordDictionary[indexOfFirstOccurrence + counter];
			}
			catch (Exception ArrayIndexOutOfBounds) {
				occurrenceEnd = true;
			}

			//nested conditionals because if word found already exists, that does not necessarily mean the end of occurrences
			if (wordFound.startsWith(prefix)) {
				//System.out.println(wordFound + " starts with " + prefix);
				if (usedWords.contains(wordFound) == false) {

					//end early if word found is the prefix!
					if(wordFound.equals(prefix)) {
						String[] soloWord = {wordFound};
						return soloWord;
					}

					words.add(wordFound);
				}

				counter++;
			}
			else {
				occurrenceEnd = true;
			}

		} while(occurrenceEnd == false);
		
		return arrayListToArray(words); //return the shortened dictionary
	}

	/**
	 * This recursive searching method repeatedly divides the
	 * array until it can return the index of the target found in the given string array.
	 * Takes in a string array, the minimum, the maximum, and the target string to search for.
	 * Returns -1 if target does not exist in the array.
	 * @param array
	 * @param min
	 * @param max
	 * @param target
	 * @return index (int)
	 */
	public static int binarySearchRecursive(String[] array, int min, int max, String target) {
		
		if (min > max) { //return -1 if word does not exist
			return -1;
		}
		
		int middleIndex = min + (max - 1)/2;

		String middleString = array[middleIndex]; //the value at middle index
		int result = middleString.compareToIgnoreCase(target);

		if (result == 0) {
			return middleIndex;
		}
		else if (result < 0) { //ignore left half
			return binarySearchRecursive(array, middleIndex + 1, max, target);
		}
		else { //ignore right half
			return binarySearchRecursive(array, min, middleIndex - 1, target);
		}
	}

	/**
	 * Linear searching method, returns index of target if found in passed string array
	 * Otherwise return -1
	 * @param array
	 * @param target
	 * @return
	 */
	public static int linearSearchMethod(String[] array, String target) {
		int index = 0;
		for (String element: array) {
			if (element.equalsIgnoreCase(target)) {
				return index;
			}
			index++;
		}

		return -1; //return -1 if word not found
	}

	/**
	 * Pre: arraylist of strings
	 * Post: array of strings
	 * @param arraylist
	 * @return
	 */
	public static String[] arrayListToArray(ArrayList<String> arraylist) {

		String[] stringArray = new String[arraylist.size()];

		int counter = 0;
		for (String element: arraylist) {
			stringArray[counter] = element;
			counter++;
		}

		return stringArray;

	}

}