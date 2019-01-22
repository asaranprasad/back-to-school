class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] map = new boolean[256];        
        
        for(char j : J.toCharArray()) map[j] = true;
        
        int count = 0;        
        for(char s : S.toCharArray())
            if(map[s]) count++;
            
        return count;
    }
}