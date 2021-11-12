import java.util.Scanner;

/**
 * If given a text file, run Scrabble Precision and calculate the distributions of letters in said file
 * 
 * @author gabrieljones
 *
 */
public class ScrabbleDriver {
	public static void main(String args[]) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("enter file name");
			String filename = scanner.next();
			ScrabblePrecision scrabble = new ScrabblePrecision(filename);
			scrabble.processFile();
			scrabble.printReport();
			scanner.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}