package leetcode;

import java.util.*;

public class PourWater {

    public int[] pourWater(int[] h, int V, int K) {
        for(; V > 0; V--){            
            // first left
            int i = K;
            int eventual = K;
            while(i - 1 >= 0 && h[i - 1] <= h[i]){
                if(h[i - 1] < h[i])
                    eventual = i - 1;
                i--;
            }
            if(i >= 0 && eventual != K){
                h[eventual]++;
                continue;
            }
            
            // then right
            i = K;
            eventual = K;
            while(i + 1 < h.length && h[i + 1] <= h[i]){
                if(h[i + 1] < h[i])
                    eventual = i + 1;
                i++;
            }
            if(i < h.length && eventual != K){
                h[eventual]++;
                continue;
            }
            
            h[K]++;
        }
        return h;
    }

}
