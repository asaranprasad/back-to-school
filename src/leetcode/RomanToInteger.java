// Simple:
// 1. The only case where current symbol is smaller than previous symbol are cases like IX, IV etc.
// 2. This implies, we iterate the string from reverse, check in pairs, if the element on the left is smaller than the element on the right, implies we have to subtract the element on the left from the existing sum.
// 3. Otherwise, we keep adding values of the symbol.

// **Important Note:** Init the sum with last symbol's value for simplicity of the code.

class Solution {
    public int romanToInt(String s) {
        if(s.length() == 0) return 0;
        
        int[] val = new int[26];        
        val['I' - 'A'] = 1;
        val['V' - 'A'] = 5;
        val['X' - 'A'] = 10;
        val['L' - 'A'] = 50;
        val['C' - 'A'] = 100;
        val['D' - 'A'] = 500;
        val['M' - 'A'] = 1000;
                
        int sum = val[s.charAt(s.length() - 1) - 'A']; // Init with last character
        
        for(int i = s.length() - 2; i >= 0; i--){
            // just getting the prev and next characters
            int curr = s.charAt(i) - 'A';
            int prev = s.charAt(i + 1) - 'A';
           
            if(val[curr] < val[prev]) 
                sum -= val[curr];
            else sum += val[curr];
        }
        return sum;
    }
}