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

  public String longestPalindrome(String s) {      
        if(s == null || s.length() == 0) return "";
        int maxLen = 0, begin = 0;
        
        for(int i = 0; i < s.length(); i++){
            int lenOdd = expandAroundCenter(s, i, i);
            int lenEven = expandAroundCenter(s, i, i + 1);
            int currLen = Math.max(lenOdd, lenEven);
            
            if(currLen > maxLen){
                maxLen = currLen;
                begin = i - (maxLen - 1) / 2;
            }
            System.out.println(maxLen);
        }
        return s.substring(begin, begin + maxLen);
    }
    
    private int expandAroundCenter(String s, int a, int b){
        while(a >= 0 && b < s.length() && s.charAt(a) == s.charAt(b)){
            a--;
            b++;
        }
        return b - a - 1;
    }

}
