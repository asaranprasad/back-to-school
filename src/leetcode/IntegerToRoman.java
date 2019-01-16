// Very Easy Short Code:

// 1. Remember the easy descending sorted logic used for Integer to English Words.
// 2. This problem is much similar to that! (Infact, it is in the related problems list)

class Solution {
    public String intToRoman(int num) {
        String[] syms = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder out = new StringBuilder();
            
        for(int i = 0; i < vals.length; i++){
            while(num >= vals[i]){
                num -= vals[i];
                out.append(syms[i]);
            }
        }
        return out.toString();
    }
}