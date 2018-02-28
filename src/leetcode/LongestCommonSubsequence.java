
package leetcode;

public class LongestCommonSubsequence {
  public static void main(String[] args) {
    LongestCommonSubsequence obj = new LongestCommonSubsequence();
    String a = "abcdefghijklmnop";
    String b = "asfdalsafdjbasdfcafddsadfmasdfoasdfp";
    char[][] trace = new char[a.length() + 1][b.length() + 1];
    System.out
        .println(
            obj.longestCommonSubsequence(a, b, trace));
    obj.printStack(trace, a, b);
  }

  public int longestCommonSubsequence(String a, String b, char[][] s) {
    if (a.length() == 0 || b.length() == 0)
      return 0;

    // Optimal Substructure Property
    // C[i][j] stores the max substring from a[0 : i-1] and b[0 : j-1]
    int[][] C = new int[a.length() + 1][b.length() + 1];

    for (int i = 1; i <= a.length(); i++) {
      for (int j = 1; j <= b.length(); j++) {
        // case 1:
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          if (C[i][j] < C[i - 1][j - 1] + 1) {
            C[i][j] = C[i - 1][j - 1] + 1;
            s[i][j] = '/';
          }
        }
        // case 2:
        else {
          if (C[i][j] < C[i][j - 1]) {
            C[i][j] = C[i][j - 1];
            s[i][j] = 'v';
          }
          if (C[i][j] < C[i - 1][j]) {
            C[i][j] = C[i - 1][j];
            s[i][j] = '<';
          }
        }
      }
    }
    return C[a.length()][b.length()];
  }


  private void printStack(char[][] s, String a, String b) {
    System.out.println();
    int i = a.length();
    int j = b.length();
    while (j > 0 && i > 0) {
      if (s[i][j] == '/') {
        System.out.print(a.charAt(i - 1));
        i = i - 1;
        j = j - 1;
      } else if (s[i][j] == 'v') {
        j = j - 1;
      } else if (s[i][j] == '<') {
        i = i - 1;
      }
    }
  }


}
