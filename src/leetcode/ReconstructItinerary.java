package leetcode;

import java.util.*;

public class ReconstructItinerary {

	public static void main(String[] args) {
		String[][] tickets =

				{ { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
		new ReconstructItinerary().findItinerary(tickets);

	}

	public List<String> findItinerary(String[][] tickets) {
		Map<String, Map<String, Integer>> g = new HashMap<>();

		for (String[] t : tickets) {
			Map<String, Integer> neigh = g.putIfAbsent(t[0], new HashMap<String, Integer>());
			int c = neigh.putIfAbsent(t[1], 0);
			neigh.put(t[1], c + 1);
			g.put(t[0], neigh);
		}
		System.out.println(Arrays.asList(g));

		return null;
	}

}
