//8.1
package ctci;

public class TripleStep {

  public int possibleTripleStepWays(int n) {
    int[] C = new int[n + 1];

    C[0] = 0;
    C[1] = 1;
    C[2] = 2;
    C[3] = 3;

    for (int i = 4; i <= n; i++) {
      C[i] = C[i - 1] + C[i - 2] + C[i - 3];
    }
    return C[n];
  }

  public static void main(String[] args) {
    TripleStep ts = new TripleStep();
    System.out.println(ts.possibleTripleStepWays(10));
    System.out.println(ts.possibleTripleStepWays(5));
    System.out.println(ts.possibleTripleStepWays(37)); // overflow integer bounds

  }

}
