package misc;

public class Permutation {

	public static void main(String[] args) {
		String str = "abc";
		char[] s = str.toCharArray();
		permute(s, 0, s.length - 1);

	}

	private static void permute(char[] a, int fixedIndex, int lastIndex) {
		{
			int i;
			if (fixedIndex == lastIndex)//makes sure we do not print anything but the leaf nodes
				System.out.println(a);
			else {
				for (i = fixedIndex; i <= lastIndex; i++) {
					swap(a, fixedIndex, i);
					permute(a, fixedIndex + 1, lastIndex);
					swap(a, fixedIndex, i); // backtrack
				}
			}
		}
	}

	private static void swap(char[] s, int index1, int index2) {
		char temp = s[index1];
		s[index1] = s[index2];
		s[index2] = temp;
	}
}