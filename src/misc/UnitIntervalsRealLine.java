//CLRS Exercise

package misc;

import java.util.ArrayList;
import java.util.List;

public class UnitIntervalsRealLine {

	public static void main(String[] args) {
		double[] input = { 0.65, 0.32, 6.9, 5.95, 6.25, 3.2, 0.4, 9.12, 7.5, 2.6 };
		UnitIntervalsRealLine uirl = new UnitIntervalsRealLine();

		List<Double> out = uirl.findUnitLengthIntervals(input);
		System.out.println("output");

		for (double v : out)
			System.out.println(v + " : " + (v + 1));
	}

	// Greedy choice
	private List<Double> findUnitLengthIntervals(double[] inp) {
		List<Double> out = new ArrayList<>();

		// find minmax range to create buckets
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (double i : inp) {
			int x = (int) i;
			if (x < min)
				min = x;
			if (x > max)
				max = x;
		}
		int delta = min;

		List<Double>[] buckets = new ArrayList[max - min + 1];

		for (int i = 0; i < buckets.length; i++)
			buckets[i] = new ArrayList<>();

		// insert into buckets
		for (double i : inp) {
			int x = (int) i;
			buckets[x - delta].add(i);
		}

		printBucket(buckets);

		// Greedy Strategy
		double bar = Double.MIN_VALUE;
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i].size() == 0) {
				bar = Double.MIN_VALUE;
				continue;
			}

			if (bar == Double.MIN_VALUE) {
				double minInBucket = Double.MAX_VALUE;
				for (double v : buckets[i]) {
					if (v < minInBucket)
						minInBucket = v;
				}
				out.add(minInBucket);
				bar = minInBucket + 1;
			} else {
				double justBiggerThanOrEqualToBar = Double.MAX_VALUE;
				for (double v : buckets[i]) {
					if (v >= bar)
						if (v < justBiggerThanOrEqualToBar)
							justBiggerThanOrEqualToBar = v;
				}
				if (justBiggerThanOrEqualToBar == Double.MAX_VALUE) {
					bar = Double.MIN_VALUE;
				} else {
					out.add(justBiggerThanOrEqualToBar);
					bar = justBiggerThanOrEqualToBar + 1;
				}
			}
		}
		return out;
	}

	private void printBucket(List<Double>[] buckets) {
		System.out.println("----PrintBuckets----");
		for (int i = 0; i < buckets.length; i++) {
			System.out.print(i + " : ");
			for (double v : buckets[i]) {
				System.out.print(v + " -> ");
			}
			System.out.println();
		}
		System.out.println("----PrintBuckets----\n");

	}

}
