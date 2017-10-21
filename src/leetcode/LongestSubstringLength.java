/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

package leetcode;


public class LongestSubstringLength {
  public static void main(String[] args) {
    LongestSubstringLength obj = new LongestSubstringLength();

    System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    System.out.println(obj.lengthOfLongestSubstring("dvdf"));

  }

  public int lengthOfLongestSubstring(String s) {
    int[] charMap = new int[256];
    initMap(charMap);
    char[] c = s.toCharArray();
    int maxLength = -1;
    int currLength = 0;

    for (int i = 0; i < c.length; i++) {
      int indexInMap = ((int) c[i]);
      if (charMap[indexInMap] != -1) {
        i = charMap[indexInMap];
        initMap(charMap);
        maxLength = (maxLength > currLength) ? maxLength : currLength;
        currLength = 0;
        continue;
      }
      charMap[indexInMap] = i;
      currLength++;
    }
    maxLength = (maxLength > currLength) ? maxLength : currLength;
    return maxLength;
  }

  private void initMap(int[] charMap) {
    for (int i = 0; i < charMap.length; i++)
      charMap[i] = -1;
  }

}
