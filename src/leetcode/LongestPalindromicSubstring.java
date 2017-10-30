// Incomplete

/*
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */

package leetcode;

public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    LongestPalindromicSubstring obj = new LongestPalindromicSubstring();



  }

  public String longestPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      if (isPalindrome(s.substring(i, j + 1)))
        return s.substring(i, j + 1);
      
      

    }
    return s.substring(0, 1);
  }

  public boolean isPalindrome(String s) {
    for (int i = 0, j = s.length() - 1; i < j; i++, j--)
      if (s.charAt(i) != s.charAt(j))
        return false;
    return true;
  }

}
