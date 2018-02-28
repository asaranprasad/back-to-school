
package leetcode;

public class LongestPalindromicSubsequence {
  public static void main(String[] args) {
    LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();

    System.out.println(obj.longestPalindromicSubsequence(
        "afdvasdfisfdksdaddfakaavfdivaadkafdakdivadfddsvadc"));
    System.out.println(obj.longestPalindromicSubsequence("character"));

  }

  public String longestPalindromicSubsequence(String a) {
    LongestCommonSubsequence lcs = new LongestCommonSubsequence();
    char[][] trace = new char[a.length() + 1][a.length() + 1];
    System.out.println(lcs.longestCommonSubsequence(a, strrev(a), trace));

    return printTrace(trace, a);
  }

  private String strrev(String a) {
    return new StringBuilder(a).reverse().toString();
  }

  private String printTrace(char[][] s, String a) {
    int i = a.length();
    int j = i;
    StringBuilder str = new StringBuilder();
    while (j > 0 && i > 0) {
      if (s[i][j] == '/') {
        str.append(a.charAt(i - 1));
        i = i - 1;
        j = j - 1;
      } else if (s[i][j] == 'v') {
        j = j - 1;
      } else if (s[i][j] == '<') {
        i = i - 1;
      } else
        break;
    }
    return str.toString();
  }
}
