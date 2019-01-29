package leetcode;

import java.util.*;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int[] map = new int[256];
        int[] tmap = new int[256];
        int rem = 0;
        int n = 0;
        
        for(char c : t.toCharArray()){
            map[c]++;
            tmap[c]++;
            rem++;
            n++;
        }
        
        int min = Integer.MAX_VALUE;
        
        int st = 0;
        int en = 0;
        
        while(st <= en){
            if(rem == 0){
                if (map[st] > 0){ 
                    map[st]--;
                    min--;
                    st++;
                }
                else {
                    for(int i = 0; i < 256; i++){
                        tmap[i] = map[i];
                        rem = n;
                    }      
                    currMin = 
                }
            }else{
                
            }
        }
        
    }

}

