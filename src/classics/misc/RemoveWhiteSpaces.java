package misc;


public class RemoveWhiteSpaces {

	public static void main(String[] args) {
		System.out.println(removeBlanks("he     l  l o   wo  r ld       "));
		System.out.println(removeBlanks("withoutBlanks"));
	}

	private static String removeBlanks(String string) {
		char[] input = string.toCharArray();
		int spaceTracker = 0;
		boolean foundBlank = false;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == ' ' && !foundBlank) {
				spaceTracker = i;
				foundBlank = true;
				continue;
			}
			if (foundBlank) {
				if (input[i] != ' ') {
					input[spaceTracker] = input[i];
					input[i] = ' ';
					spaceTracker++;
				}
			}
		}

		String returnString = "";

		for (char c : input) {
			if (c == ' ')
				break;
			else
				returnString += c;
		}
		return returnString;
	}
}
