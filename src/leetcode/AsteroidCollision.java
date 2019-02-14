package leetcode;

import java.util.*;

public class PourWater {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        
        for(int a : asteroids){
            if(a > 0){
                s.push(a);
            }else {
                while(!s.isEmpty() && s.peek() > 0 && s.peek() < 0 - a){
                    s.pop();
                }
                if(!s.isEmpty() && s.peek() == 0 - a){
                    s.pop();
                } else if (s.isEmpty() || s.peek() < 0){
                    s.push(a);                    
                }
            }
        }
        
        int[] out = new int[s.size()];
        
        int i = s.size() - 1;
        while(!s.isEmpty()){
            out[i--] = s.pop();
        }
        return out;
    }

}
