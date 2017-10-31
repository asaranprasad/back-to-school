package misc;

public class CandidateCode {

	public static void main(String[] args) {
		int[] input1 = { 2, 30, 15, 10, 8, 25, 80 };
		int input2 = 6;
		System.out.println(maximumPositiveFrequency(input1, input2));
		System.out.println("\n\nremoveSubString:\n" + removeSubString("asaranprasad@gmail.com", "@gmail.com"));
		System.out.println("\n\n" + removeDelimetersAndCheckIfPalindrome("@!hell***&o&o^^l^l^_e_h))))))))))"));

	}

	private static String removeDelimetersAndCheckIfPalindrome(String string) {
		char[] s = string.toCharArray();
		char[] rev = new char[s.length];
		int counter = 0, k = 0;
		for (int i = 0; i < s.length; i++) {
			if ((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z')) {
				s[counter++] = s[i];
			} else
				System.out.println("Delimeter: " + s[i] + " found in position: " + i);
		}

		String returnString = "";
		for (int i = counter - 1; i >= 0; i--) {
			rev[k] = s[i];
			returnString += s[k];
			k++;
		}

		boolean isPalindrome = true;
		for (int i = 0; i < counter; i++)
			if (rev[i] != s[i])
				isPalindrome = false;
		if (isPalindrome)
			System.out.println("The String: " + returnString + " is a palindrome");
		else
			System.out.println("The String: " + returnString + " is not a palindrome");
		return returnString;
	}

	public static int maximumPositiveFrequency(int[] input1, int input2) {
		int[] positiveSelection = new int[2];

		int curr = input1[0];
		int diff = 0;
		int prevMinValue = input1[0];
		int prev = -1;
		for (int i = 0; i < input2; i++) {
			curr = input1[i];
			if ((curr - prevMinValue > diff)) {
				diff = curr - prevMinValue;
				checkAndReplace(positiveSelection, diff);
				continue;
			}
			if (curr < prev) {
				prevMinValue = curr;
				diff = 0;
			}

			prev = curr;
		}

		int sum = 0;
		for (int i = 0; i < positiveSelection.length; i++)
			sum += positiveSelection[i];

		return sum;

	}

	public static void checkAndReplace(int[] positiveSelection, int newValue) {
		if (positiveSelection[1] > positiveSelection[0]) {
			if (newValue > positiveSelection[0])
				positiveSelection[0] = newValue;
		} else {
			if (newValue > positiveSelection[1])
				positiveSelection[1] = newValue;
		}
	}

	public static String removeSubString(String input, String subStr) {
		String returnString = "";
		char[] inputChar = input.toCharArray();
		char[] replaceChars = subStr.toCharArray();
		if (inputChar.length == 0 || replaceChars.length == 0)
			return input;
		for (int i = 0; i < inputChar.length; i++) {
			if (inputChar[i] == replaceChars[0]) {
				boolean checked = true;
				int k = 0;
				for (int j = i; j < replaceChars.length + i; j++, k++) {
					if (inputChar[j] != replaceChars[k]) {
						checked = false;
						break;
					}
				}
				if (checked)
					i = i + k;
			}
			if (i < inputChar.length)
				returnString += inputChar[i];
		}
		return returnString;

	}
}