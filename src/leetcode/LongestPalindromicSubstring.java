// Incomplete

/*
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */

package leetcode;

public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        System.out.println("abcddcba: " + obj.longestPalindrome("abcddcba"));
        System.out.println("abcdcba: " + obj.longestPalindrome("abcdcba"));
        System.out.println(": " + obj.longestPalindrome(""));
        System.out.println("a: " + obj.longestPalindrome("a"));
    System.out.println("aaaa: " + obj.longestPalindrome("aaaa"));
        System.out.println(
            "sadf09werrew90984oijrewf: " + obj.longestPalindrome("sadf09werrew90984oijrewf"));
        System.out.println(
            "sadf09werxrew90984oijrewf: "
                + obj.longestPalindrome("sadf09werxrew90984oijrewf"));
  }

  public String longestPalindrome(String a) {
    if (a.length() == 0)
      return "";

    String maxString = "";
    int count;

    for (int i = 0; i < a.length(); i++) {
      count = 1;
      int j = i - 1, k = i + 1;
      while (j >= 0 && k < a.length() && a.charAt(j) == a.charAt(k)) {
        count += 2;
        j--;
        k++;
      }
      if (count > maxString.length()) {
        int start = j + 1;
        int end = k;
        if (j < 0)
          start = 0;
        if (k > a.length())
          end = a.length();
        maxString = a.substring(start, end);
//        System.out.println("1. i: " + i + " j: " + j + " k: " + k + " start: " + start
//            + " end: " + end + " str: " + maxString);
      }
    }

    for (int i = 0; i < a.length() - 1; i++) {
      count = 0;
      int j = i, k = i + 1;
      while (j >= 0 && k < a.length() && a.charAt(j) == a.charAt(k)) {
        count += 2;
        j--;
        k++;
      }
      if (count > maxString.length()) {
        int start = j + 1;
        int end = k;
        if (j < 0)
          start = 0;
        if (k > a.length())
          end = a.length();
        maxString = a.substring(start, end);
        //        System.out.println("2. i: " + i + " j: " + j + " k: " + k + " start: " + start
        //            + " end: " + end + " str: " + maxString);
      }
    }

    if (maxString.length() == 0)
      maxString = maxString + a.charAt(0);

    return maxString;
  }

}
