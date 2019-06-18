//CLRS Exercise

package misc;

import java.util.ArrayList;
import java.util.List;

public class ThreeJugs {

	public static void main(String[] args) {
		double[] input = { 2.65, 2.32, 6.9, 100.24, 100.12, 101.1, 5.95, 6.25, 3.2, 2.4, 9.12, 7.5, 2.6 };
		ThreeJugs uirl = new ThreeJugs();

		List<Double> out = uirl.findUnitLengthIntervals(input);
		System.out.println("output");

		for (double v : out)
			System.out.println(v + " : " + (v + 1));
	}

	private void findPattern() {
		
	}

}
