package dp;


//Prof. Curly is planning a cross-country road-trip from Boston to Seattle on Interstate 90, 
//and he needs to rent a car. His first inclination was to call up the various car rental 
//agencies to find the best price for renting a vehicle from Boston to Seattle, but he has 
//learned, much to his dismay, that this may not be an optimal strategy. Due to the plethora
//of car rental agencies and the various price wars among them, it might actually be
//cheaper to rent one car from Boston to Cleveland with Hertz, followed by a second
//car from Cleveland to Chicago with Avis, and so on, than to rent any single car from
//Boston to Seattle.
//Prof. Curly is not opposed to stopping in a major city along Interstate 90 to change
//rental cars; however, he does not wish to backtrack, due to time contraints. (In other
//words, a trip from Boston to Chicago, Chicago to Cleveland, and Cleveland to Seattle
//is out of the question.) Prof. Curly has selected n major cities along Interstate 90 and
//ordered them from East to West, where City 1 is Boston and City n is Seattle. He has
//constructed a table T[i, j] which for all i < j contains the cost of the cheapest single
//rental car from City i to City j. Prof. Curly wants to travel as cheaply as possible.


public class CheapRental {
  public static void main(String args[]) {
    CheapRental cr = new CheapRental();
    int[][] T = {{0, 4, 3, 12, 24, 34, 46, 55},
        {0, 0, 1, 3, 12, 24, 34, 46},
        {0, 0, 0, 1, 5, 12, 24, 34},
        {0, 0, 0, 0, 2, 7, 12, 24},
        {0, 0, 0, 0, 0, 6, 6, 12},
        {0, 0, 0, 0, 0, 0, 9, 10},
        {0, 0, 0, 0, 0, 0, 0, 9},
        {0, 0, 0, 0, 0, 0, 0, 0}
    };

    int n = 7;
    int[] S = new int[n];
    System.out.println(cr.cheapRental(T, 0, n, S));

    printTrace(S);
  }

  private static void printTrace(int[] s) {
    System.out.println("Trace:");
    for (int i = 1; i < s.length && s[i] < s.length; i++)
      System.out.println("City: " + s[i]);
    System.out.println("City: " + s.length);
  }

  public int cheapRental(int[][] T, int K, int n, int[] s) {
    int[] C = new int[n + 1];

    for (int k = n - 1; k >= K; k--) {
      C[k] = Integer.MAX_VALUE;
      for (int i = k + 1; i <= n; i++)
        if (C[k] > T[k][i] + C[i]) {
          C[k] = T[k][i] + C[i];
          s[k] = i;
        }
    }

    return C[K];
  }
}
