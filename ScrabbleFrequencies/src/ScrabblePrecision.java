import java.io.IOException;

/**
 * Represents the scrabble scores of the alphabet based on a processed file, and
 * traditional scrabble rules
 * 
 * 
 * @author gabrieljones
 *
 */
public class ScrabblePrecision extends TextFileAccessor {
	int[] scoreboard; // holds number of each letter in the alphabet
	private final int[] SCRABBLE_SCORES = { 1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 }; // constants of normal scrabble scores based on letters
	private final char[] ONES = "aeilnorstu".toCharArray();// character array of the letters that are worth one based on the normal scrabble scores
	private final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();// character array of the alphabet
	private final int ASCII_CODE_a = 97; // ASCII code value of lower case a

	public ScrabblePrecision(String filename) throws IOException {
		openFile(filename);
		scoreboard = new int[26]; // initializes score board variable with a length of 26

	}

	@Override
	protected void processLine(String curLine) {
		// creates a character array of the input to the function with all lower case letters
		char[] fullString = curLine.toLowerCase().toCharArray();
		// for every letter in the input String, one is added to their corresponding position in the score board
		for (int i = 0; i < fullString.length; i++) {
			if (Character.isLetter(fullString[i]) && getLetterPos(fullString[i]) <= scoreboard.length) {
				scoreboard[getLetterPos(fullString[i])]++;
			}
		}

	}

	/**
	 * Returns integer value of ASCII code value of alphabetical letter
	 * 
	 * @param ch character that is subtracted from to return the ASCII code value
	 * @return integer of the ASCII code index of the input character
	 */
	private int getLetterPos(char ch) {
		ch = Character.toLowerCase(ch);
		int position = ch - ASCII_CODE_a;
		return position;
	}

	/**
	 * Returns double value of the average number of the 10 most common characters
	 * in the English Language
	 * 
	 * @return decimal value of the average frequency of all of the letters
	 */
	private double getOnesAverage() {
		// holds number of characters that have a normal scrabble value of 1
		int onesCount = 0;
		// for the ones values, checks how many of the corresponding scoreboard value and adds that to the ones count variable
		for (int i = 0; i < ONES.length; i++) {
			for (int j = 0; j < scoreboard.length; j++) {
				if (ONES[i] - ASCII_CODE_a == j) {
					for (int q = 0; q < scoreboard[j]; q++) {
						onesCount++;
					}
				}
			}
		}

		return (double) onesCount / (double) ONES.length;
	}

	@Override
	public void printReport() {
		// prints every letter in the alphabet and its corresponding normal scrabble score, and calculated scrabble score
		for (int i = 0; i < ALPHABET.length; i++) {
			System.out.print(ALPHABET[i]);
			System.out.format("%6d", SCRABBLE_SCORES[i]);
			System.out.format("%8.2f%n", (getOnesAverage() / scoreboard[i]));
		}
	}
}
