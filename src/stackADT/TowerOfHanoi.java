package stackADT;

public class TowerOfHanoi {
	static int disksCount = 3;
	static int stackCount = 3;
	static Stack A = new Stack("A");
	static Stack B = new Stack("B");
	static Stack C = new Stack("C");

	public static void main(String args[]) {
		A.push('3');
		A.push('2');
		A.push('1');
		// print();
		TOH(disksCount, A, B, C);
		// print();
	}

	private static void TOH(int disksCount, Stack a, Stack b, Stack c) {
		if (disksCount != 0) {
			TOH(disksCount - 1, a, c, b);// moving n-1 disks from A To B using C
			// c.push(a.pop());// move the nth disk in A to C
			// print();
			System.out.println("Move a disk from: " + a + " to: " + c);
			TOH(disksCount - 1, b, a, c);// moving n-1 disks from B to C using A
		}

	}

}
