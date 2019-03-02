package leetcode;

class GenerateParanthesis {
    public List<String> generateParenthesis(int n) {
        List<String> out = new LinkedList<>();
        
        util(out, n, 1, 0, "(");
        return out;
    }
    
    private void util(List<String> out, int n, int open, int close, String sofar){
        if(open == close && open == n)
            out.add(sofar);        
        if(open < n)
            util(out, n, open + 1, close, sofar+"(");
        if(close < open)
            util(out, n, open, close + 1, sofar+")");
    }
}
