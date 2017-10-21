/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

package leetcode;


public class LongestSubstringLength {
  public static void main(String[] args) {
    LongestSubstringLength obj = new LongestSubstringLength();

    System.out.println(obj.lengthOfLongestSubstring("pwwkew"));

  }

  public int lengthOfLongestSubstring(String s) {
    boolean[] charMap = new boolean[256];
    char[] c = s.toCharArray();
    int maxLength = -1;
    int currLength = 0;

    for (int i = 0; i < c.length; i++) {
      int indexInMap = ((int) c[i]);
      if (charMap[indexInMap]) {
        charMap = new boolean[256];
        maxLength = (maxLength > currLength) ? maxLength : currLength;
        currLength = 1;
        charMap[indexInMap] = true;
        continue;
      }
      charMap[indexInMap] = true;
      currLength++;
    }
    maxLength = (maxLength > currLength) ? maxLength : currLength;
    return maxLength;
  }

}
