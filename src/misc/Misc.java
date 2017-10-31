package misc;


public class Misc {

	public static void main(String[] args) {
		int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 11, 1024, 1, 2, 3, 4, 5 };
		int[] Q = { 1024, 1, 2 };
		int[] indices = getIndicesForSubset(A, Q);
		System.out.println("beginIndex: " + indices[0] + " endIndex: " + indices[1]);
		System.out.println("\n\n");
		System.out.println(swapAdjacentChars("helloWorld"));

	}

	private static char[] swapAdjacentChars(String string) {
		char[] input = string.toCharArray();
		for (int i = 0; i < input.length - 1; i += 2) {
			char temp = input[i];
			input[i] = input[i + 1];
			input[i + 1] = temp;
		}
		return input;
	}

	private static int[] getIndicesForSubset(int[] a, int[] q) {
		int[] indices = { -1, -1 };
		int limit = a.length;
		int qCounter = 0;

		for (int i = 0; i < limit; i++) {
			if (a[i] == q[qCounter])
				qCounter++;
			else
				qCounter = 0;

			if (qCounter == q.length) {
				indices[0] = i - qCounter + 1;
				indices[1] = i;
				break;
			}
		}
		return indices;
	}
}
