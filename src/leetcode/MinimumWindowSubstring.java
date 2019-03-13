// https://leetcode.com/problems/minimum-window-substring/submissions/

package leetcode;

import java.util.*;


// O(N) run time and O(1) space solution.

// Based on the template from:
// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49708/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem

// O(1) space cauz the HashMap can have max size only equal to the total number of characters possible in ascii / unicode.

public class MinimumWindowSubstring {

     public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        int count = map.size();
        int begin = 0, end = 0, head = 0, len = Integer.MAX_VALUE;
        
        while(end < s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) count--;
            }
            
            end++;
            
            while(count == 0){
                char cbegin = s.charAt(begin);
                if(map.containsKey(cbegin)){
                    map.put(cbegin, map.get(cbegin) + 1);
                    if(map.get(cbegin) > 0) count++;
                }
                
                if(len > end - begin){
                    len = end - begin;
                    head = begin;
                }
                
                begin++;
            }            
        }
        
        if(len == Integer.MAX_VALUE) return "";
        return s.substring(head, head + len);
    }

}

