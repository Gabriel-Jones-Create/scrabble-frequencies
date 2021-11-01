import java.io.IOException;

public class ScrabblePrecision extends TextFileAccessor {
	// TODO: declare variables
	public ScrabblePrecision(String filename) throws IOException {
		openFile(filename);
		// TODO: initialize variables in constructor

	}

	@Override
	protected void processLine(String curLine) {
		// TODO: process each character from the current line

	}

	private int getLetterPos(char ch) {
		// TODO: helper method to return the position for the character
		return 0;
	}

	private double getOnesAverage() {
		// TODO: helper method to return the average frequency value in the supplied
		// text for the letters that have Scrabble score 1
		return 0.0;
	}

	@Override
	public void printReport() {
		// TODO: prints the table of relative frequencies given the text file
	}

}
