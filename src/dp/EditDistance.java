package dp;

import java.util.HashMap;

public class EditDistance {
  public static void main(String args[]) {
    EditDistance ed = new EditDistance();
    String x = "algorithm";
    String y = "altruistic";

    HashMap<Character, Integer> cost = new HashMap<Character, Integer>();
    cost.put('c', 1);
    cost.put('r', 1);
    cost.put('d', 1);
    cost.put('i', 1);
    cost.put('t', 1);
    cost.put('k', 0);


    String[][] S = new String[x.length() + 1][y.length() + 1];
    System.out.println(ed.editDistance(x.toCharArray(), y.toCharArray(), cost, S));

    printTrace(S);
  }

  private static void printTrace(String[][] s) {
    System.out.println("Trace:");

    for (int i = 1; i < s.length; i++) {
      for (int j = 1; j < s[0].length; j++) {
        char opr = s[i][j].charAt(0);
        System.out.print(opr + " ");
      }
      System.out.println();
    }

    int i = s.length - 1, j = s[0].length - 1;
    while (i > 0 && j > 0) {
      String op = s[i][j];
      System.out.println(op);//+ " i: " + i + " j: " + j);
      char opr = op.charAt(0);
      switch (opr) {
        case 'c':
          i--;
          j--;
          break;
        case 'r':
          i--;
          j--;
          break;
        case 'd':
          j--;
          break;
        case 'i':
          i--;
          break;
        case 't':
          j -= 2;
          i -= 2;
          break;
        case 'k':
          j--;
          break;
      }
    }
  }


  private int editDistance(char[] x, char[] y, HashMap<Character, Integer> cost,
      String[][] S) {
    int[][] C = new int[x.length + 1][y.length + 1];

    for (int i = 1; i <= x.length; i++) {
      for (int j = 1; j <= y.length; j++) {
        C[i][j] = Integer.MAX_VALUE;

        char xi = x[i - 1];
        char yj = y[j - 1];

        if (j == y.length) {
          if (C[i][j] > C[0][y.length] + cost.get('k')) {
            C[i][j] = C[0][y.length] + cost.get('k');
            S[i][j] = "kill";
            break;
          }
        }

        if (xi == yj) {
          if (C[i][j] > C[i - 1][j - 1] + cost.get('c')) {
            C[i][j] = C[i - 1][j - 1] + cost.get('c');
            S[i][j] = "copy " + xi;
          }
        }

        if (C[i][j] > C[i - 1][j - 1] + cost.get('r')) {
          C[i][j] = C[i - 1][j - 1] + cost.get('r');
          S[i][j] = "replace by " + yj;
        }

        if (C[i][j] > C[i - 1][j] + cost.get('d')) {
          C[i][j] = C[i - 1][j] + cost.get('d');
          S[i][j] = "delete " + xi;
        }

        if (C[i][j] > C[i][j - 1] + cost.get('i')) {
          C[i][j] = C[i][j - 1] + cost.get('i');
          S[i][j] = "insert " + yj;
        }

        if ((i > 1) && (j > 1) && xi == y[j - 2] && x[i - 2] == yj) {
          if (C[i][j] > C[i - 2][j - 2] + cost.get('t')) {
            C[i][j] = C[i - 2][j - 2] + cost.get('t');
            S[i][j] = "twiddle " + xi + " " + yj;
          }
        }
      }
    }
    return C[x.length][y.length];
  }
}
