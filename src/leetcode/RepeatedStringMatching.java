class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder a = new StringBuilder(A);
        
        int i = 1;
        while(a.length() < B.length()){
            a.append(A);
            i++;
        }
        
        if(a.indexOf(B) >= 0) return i;
        if(a.append(A).indexOf(B) >= 0) return i + 1;
        
        return -1;
    }
}