class Solution {
    
    int ways = 0;
    public int numDecodings(String s) {
        if(Integer.parseInt(s) == 0) return 0;
        decUtil(s, 0);
        return ways;
    }
    
   
    private void decUtil(String s, int i){
        if(i < s.length()){
            char c = s.charAt(i);
            if(i + 1 < s.length()){
                char d = s.charAt(i + 1);
                int pair = Character.getNumericValue(c) * 10 + Character.getNumericValue(d);
                System.out.println(pair + " c: " + c + " d: " + d);
                if (pair > 9 && pair < 27){
                    decUtil(s, i + 2);
                }
            }
            decUtil(s, i + 1);            
        } else{
            ways++;
        }
    }
}