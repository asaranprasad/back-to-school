package misc;

import java.util.Arrays;

public class Sort2DPoints {

	public static void main(String[] args) {
		int[][] input = { { 1, 2 }, { -4, -4 }, { -1, -8 }, { 3, -5 }, { -6, 7 }, { 9, 1 }, { 4, 7 }, { -3, 5 },
				{ 5, 6 }, { -2, -1 }, { 9, -4 }, { -2, 5 }, { -9, -8 }, { 5, 5 }, { -9, 2 }, { 2, 4 }, { -4, 4 },
				{ 0, -4 }, { 2, 10 }, { 7, -6 } };

		for (int[] i : input)
			System.out.print("(" + i[0] + "," + i[1] + "),");
		System.out.println();

		Arrays.sort(input, (a, b) -> {
			if (a[0] != b[0])
				return a[0] - b[0];
			else
				return a[1] - b[1];
		});

		for (int[] i : input)
			System.out.print("(" + i[0] + "," + i[1] + "),");

	}
}