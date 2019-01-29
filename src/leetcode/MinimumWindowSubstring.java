package leetcode;

import java.util.*;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] map = new int[256];
        int rem = 0;
        
        for(char c : t.toCharArray()){
            map[c]++;
            rem++;
        }
        
        int min = Integer.MAX_VALUE;
        
        int st = 0;
        int en = 0;
        
        while(st <= en){
            if(rem == 0){
                if (map[en] > 0) map[en]--;
                
            }else{
                
            }
        }
        
    }

}
