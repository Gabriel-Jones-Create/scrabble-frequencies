import java.io.IOException;
public class ScrabblePrecision extends TextFileAccessor {
	int[] scoreboard;
	private final int[] SCRABBLE_SCORES = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
	private final char[] ONES = "aeilnorstu".toCharArray();
	private final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private final int ASCII_CODE_a = 97;
	public ScrabblePrecision(String filename) throws IOException {
		openFile(filename);
		// TODO: initialize variables in constructor
		scoreboard = new int[26];

	}

	@Override
	protected void processLine(String curLine) {
		char[] fullString = curLine.toLowerCase().toCharArray();
		for(int i = 0; i < fullString.length; i++) {
			if(Character.isLetter(fullString[i])) {
				scoreboard[getLetterPos(fullString[i])]++;
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
		int position = ch - ASCII_CODE_a;
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
			for(int j = 0; j < scoreboard.length; j++) {
				if(ONES[i]-ASCII_CODE_a == j) {
					for(int q = 0; q < scoreboard[j]; q++) {
					onesCount++;
					}
				}
			}
		}
		
		
		return (double)onesCount/(double)ONES.length;
	}

	/**
	 * Prints letter, the scrabble value of the letter and the calculated scrabble value based on the text inputed in the getLetterPos function for every letter in the alphabet
	 *
	 *
	 */
	@Override
	public void printReport() {
		// TODO: prints the table of relative frequencies given the text file
		/*letters = deleteBlanks(letters);
		for(int i = 0; i < ALPHABET.length; i++) {
			for(int j = 0; j < letters.length; j++) {
				if(ALPHABET[i] == letters[j]) {
					scoreboard[getLetterPos(ALPHABET[i])]++;
				}
			}
		}*/
		for(int i = 0 ; i < ALPHABET.length; i++) {
			System.out.print(ALPHABET[i]);
			//System.out.printf("%6d    %4.2f%n",SCRABBLE_SCORES[i], (getOnesAverage()/scoreboard[i]));
			System.out.format("%6d", SCRABBLE_SCORES[i]);
			System.out.format("%8.2f%n",(getOnesAverage()/scoreboard[i]));
		}
	}
}
