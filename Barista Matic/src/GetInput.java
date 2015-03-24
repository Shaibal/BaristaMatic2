/**
 * Provides the user input logic.
 * @author Shaibal Saha
 * 3/21/2015
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetInput {

	static BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in));
	static boolean emptyInput;
	static String inputCommand;

	/**
	 * Only returns user input when it is not blank, inputs like multiple spaces
	 * or new line is ignored.
	 * 
	 * @return
	 */
	public String getUserInput() {
		do {
			try {
				inputCommand = input.readLine();
				emptyInput = false;

				if (inputCommand.trim().isEmpty()) {
					emptyInput = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (emptyInput);

		return inputCommand;
	}

}
