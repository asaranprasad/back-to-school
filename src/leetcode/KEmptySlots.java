class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        
        boolean[] pots = new boolean[n];
        
        for(int i = 0; i < n; i++){
            int day = i + 1;
            int pot = flowers[i] - 1;
            pots[pot] = true;
                        
            /* Scan Left */
            boolean isUnbloomed = true;
            for(int j = 1; j <= k; j++){
                if(pot - j >= 0){
                    if(pots[pot - j]){ isUnbloomed = false; break; }
                }
            }
            if(isUnbloomed){
                if((pot - (k + 1) >= 0) && pots[pot - (k + 1)]) return day;
            }   
            
            /* Scan Right */
            isUnbloomed = true;
            for(int j = 1; j <= k; j++){
                if(pot + j < n){
                    if(pots[pot + j]){ isUnbloomed = false; break; }
                }
            }
            if(isUnbloomed){
                if((pot + (k + 1) < n) && pots[pot + (k + 1)]) return day;
            }    
        }
        
        return -1;
    }
}