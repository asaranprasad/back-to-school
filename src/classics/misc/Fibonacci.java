package misc;

public class Fibonacci {
	public static void main(String args[]) {
		printFibonacciSeries(10);
		System.out.println();
		System.out.println(printFibonacciNumber(10));

	}

	private static void printFibonacciSeries(int n) {
		int x = 0, y = 1, z;
		System.out.print(x + " " + y + " ");
		for (int i = 0; i < n; i++) {
			z = x + y;
			System.out.print(z + " ");
			x = y;
			y = z;
		}
	}

	private static int printFibonacciNumber(int n) {
		double goldenRatio = (Math.sqrt(5) + 1) / 2;
		int formula = (int) ((Math.pow(goldenRatio, n) / Math.sqrt(5)) + (1 / 2));
		return (formula);
	}
}
