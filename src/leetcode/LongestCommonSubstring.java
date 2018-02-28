
package leetcode;

public class LongestCommonSubstring {
  public static void main(String[] args) {
    LongestCommonSubstring obj = new LongestCommonSubstring();
    System.out
        .println(obj.longestCommonSubstring("d32babadazdwec", "safwefdsx2babadazdwexcs"));
  }

  private String longestCommonSubstring(String a, String b) {
    if (a.length() == 0 || b.length() == 0)
      return "";

    // Optimal Substructure Property
    // C[i][j] stores the max substring from a[0 : i-1] and b[0 : j-1]
    int[][] C = new int[a.length() + 1][b.length() + 1];
    int result = 0;
    int maxStart = 0;

    for (int i = 1; i <= a.length(); i++) {
      for (int j = 1; j <= b.length(); j++) {
        // optimal substructure property case 1:
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          printStack(C, a, b);
          C[i][j] = C[i - 1][j - 1] + 1;
          if (result < C[i][j]) {
            result = C[i][j];
            maxStart = i - C[i][j];
          }
        }
        // optimal substructure property case 2:
        else
          C[i][j] = 0;
      }
    }
    return a.substring(maxStart, maxStart + result);
  }


  private void printStack(int[][] c, String a, String b) {
    System.out.print("\n  \t\t");
    for (int i = 0; i < c[0].length; i++)
      System.out.print(i + "\t");
    System.out.print("\n  \t\t");
    for (int i = 0; i < b.length(); i++)
      System.out.print(b.charAt(i) + "\t");
    System.out.println("");

    for (int i = 0; i < c.length; i++) {
      System.out.print(i + "\t");
      if (i < a.length())
        System.out.print(a.charAt(i) + "\t");
      else
        System.out.print(" \t");
      for (int j = 0; j < c[i].length; j++) {
        System.out.print(c[i][j] + "\t");
      }
      System.out.println("");
    }

  }


}
