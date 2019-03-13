// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/submissions/

package leetcode;

public class LongestSubstringWithAtmostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char first = ' ', second = ' ';
        int out = 0, currCount = 0, secondCount = 0;
        for(char t : s.toCharArray()){
            currCount = (t == first || t == second) ? currCount + 1 : secondCount + 1;
            secondCount = (t == second) ? secondCount + 1 : 1;
            if(t != second) {
                first = second;
                second = t;
            }
            out = Math.max(out, currCount);
        }
        return out;
    }

}
