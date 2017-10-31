package misc;

public class AlphaCheck {

	public static void main(String[] args) {
		for (char alph = '0'; alph <= 'z'; alph++)
			System.out.println(alph + ": " + isAlphabet(alph));
		for (char alph = 'A'; alph <= 'Z'; alph++)
			System.out.println(alph + ": " + isAlphabet(alph));

	}

	private static boolean isAlphabet(char alph) {
		return ((alph >= 'a' && alph <= 'z') || (alph >= 'A' && alph <= 'Z'));
	}
}
