package misc;

public class QuickStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TowerOfHanoiUsingConsolePrint("A", "C", "B", 5);
	}

	public static void TowerOfHanoiUsingConsolePrint(String from, String to, String via, int numberOfDiscs) {
		if (numberOfDiscs != 0) {
			TowerOfHanoiUsingConsolePrint(from, via, to, numberOfDiscs - 1);
			System.out.println("Move a Disc from: " + from + " to: " + to);
			TowerOfHanoiUsingConsolePrint(via, to, from, numberOfDiscs - 1);
		}
	}
}
