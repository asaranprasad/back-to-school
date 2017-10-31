package misc;

import java.util.HashMap;

public class FindLongestSubstringWithNonRepeatingCharacters {

	public static HashMap<Character, Integer> map;

	public static void main(String[] args) {
		String s = "mathematics";
		System.out.println(findLongestSubstringWithNonRepeatingCharacters(s.toCharArray()));
	}

	private static char[] findLongestSubstringWithNonRepeatingCharacters(char[] inputString) {
		int longS = 0, longE = 0, S = 0, E = 0;
		map = new HashMap<Character, Integer>();
		for (int i = 0; i < inputString.length; i++) {
			char c = inputString[i];
			int prevI;
			try {
				prevI = map.get(c);
			} catch (NullPointerException npe) {
				prevI = -1;
			}
			if (prevI == -1) {
				map.put(c, i);
				E = i;
			}
			if (i == inputString.length - 1) {
				if ((E - S) > (longE - longS)) {
					longE = E;
					longS = S;
				}
			}
			if (prevI != -1) {
				if ((E - S) > (longE - longS)) {
					longE = E;
					longS = S;
				}
				S = E = map.get(c) + 1;
				i = S - 1;
				map = new HashMap<Character, Integer>();
			}
		}

		char[] output = new char[longE - longS + 1];
		for (int i = 0; i < output.length; i++)
			output[i] = inputString[longS++];
		return output;
	}


}
