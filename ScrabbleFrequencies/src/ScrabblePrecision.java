import java.io.IOException;
public class ScrabblePrecision extends TextFileAccessor {
	int[] scoreboard = new int[26];
	private final int[] SCRABBLE_SCORES = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	private final char[] ONES = "aeilnorstu".toCharArray();
	private final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private char[] letters = new char[10000000];
	private int count = 0;
	public ScrabblePrecision(String filename) throws IOException {
		openFile(filename);
		// TODO: initialize variables in constructor
		

	}

	/**
	 *  Adds input string with only lower case letters to letters array
	 *
	 * @param initMatch string that is converted to all lower case letter character array
	 */
	@Override
	protected void processLine(String curLine) {
		char[] fullString = curLine.toLowerCase().toCharArray();
		for(int i = 0; i < fullString.length; i++) {
			if(Character.isLetter(fullString[i])) {
				letters[count] = fullString[i];
				count++;
			}
		}
		

	}

	/**
	 * Returns integer value of ASCII code value of alphabetical letter
	 * @param ch character that is subtracted from to return the ASCII code value
	 * @return integer of the ASCII code index of the input character
	 */
	private int getLetterPos(char ch) {
		// TODO: helper method to return the position for the character
		ch = Character.toLowerCase(ch);
		int position = ch - 97;
		return position;
	}

	/**
	 * Returns double value of the average number of the 10 most common characters in the English Language
	 * @return decimal value of the average frequency of all of the letters
	 */
	private double getOnesAverage() {
		// TODO: helper method to return the average frequency value in the supplied
		// text for the letters that have Scrabble score 1
		int onesCount = 0;
		for(int i = 0; i < ONES.length; i++) {
			for(int j = 0; j < letters.length; j++) {
				if(ONES[i] == letters[j]) {
					onesCount++;
				}
			}
		}
		
		
		return ((double)onesCount)/(double)ONES.length;
	}

	/**
	 * Prints letter, the scrabble value of the letter and the calculated scrabble value for every letter in the alphabet
	 *
	 *
	 */
	@Override
	public void printReport() {
		// TODO: prints the table of relative frequencies given the text file
		letters = deleteBlanks(letters);
		for(int i = 0; i < ALPHABET.length; i++) {
			for(int j = 0; j < letters.length; j++) {
				if(ALPHABET[i] == letters[j]) {
					scoreboard[getLetterPos(ALPHABET[i])]++;
				}
			}
		}
		for(int i = 0 ; i < ALPHABET.length; i++) {
			System.out.print(ALPHABET[i]);
			System.out.printf("    %d    %.2f%n",SCRABBLE_SCORES[i], getOnesAverage()/scoreboard[i]);
		}
	}
	/**
	 * Returns character array of input array without empty spaces
	 * @param ch character array with empty values
	 * @return character array of the input without spaces
	 */
	private char[] deleteBlanks(char[] ch) {
		// creates lastLetterIndex at the index of the last letter of the input
		int lastLetterIndex = ch.length;
		// for the length of the input array, if the character is not a letter then the
		// last letter index is taken down by 1
		for (int i = 0; i < ch.length; i++) {
			if (!Character.isLetter(ch[i])) {
				lastLetterIndex--;
			}
		}
		// creates a newArray variable which is the length of the lastLetterIndex
		char[] newArray = new char[lastLetterIndex];
		// for the length of the last letter, the newArray gets set the the input
		// array's values
		for (int i = 0; i < lastLetterIndex; i++) {
			newArray[i] = ch[i];
		}
		return newArray;

	}

}
