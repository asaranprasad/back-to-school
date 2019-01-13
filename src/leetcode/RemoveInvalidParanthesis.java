class Solution {
    public List<String> removeInvalidParentheses(String s) {
        // Find the count of mismatching left and right paranthesis
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') left++;
            else if(c == ')'){
                right = left == 0 ? right + 1 : right;
                left = left > 0 ? left - 1 : left;
            }
        }
        
        Set<String> out = new HashSet<String>();
        recur(s, 0, 0, 0, left, right, out, new StringBuilder());        
        return new LinkedList<String>(out);
    }
    
    private void recur(String s, int ind, int left, int right, int leftRem, int rightRem, Set<String> out, StringBuilder intrimString){
        if(ind == s.length()){
            if(leftRem == 0 && rightRem == 0)
                out.add(intrimString.toString());            
        }
        else{
            char c = s.charAt(ind);
            
            // Branch 1 : Skip this paranthesis. (i.e.) remove one.
            // leftRem and rightRem checks to make sure that we don't do
            // unwanted recursions (i.e) after finding all invalid paranthesis
            if((c == '(' && leftRem > 0) || (c == ')' && rightRem > 0)){
                recur(s, ind + 1, left, right,
                      c == '(' ? leftRem - 1 : leftRem,
                      c == ')' ? rightRem - 1 : rightRem,
                      out, intrimString);
            }
            
            // Branch 2 : Don't Skip this paranthesis. (i.e.) include it.
            // Including the character
            intrimString.append(c);
            
            // If non paranthesis character, simply continue to the next character.
            if(c != ')' && c != '(')
                recur(s, ind + 1, left, right, leftRem, rightRem, out, intrimString);
            // If open paranthesis, increase the open paranthesis count and continue.
            else if(c == '(')
                recur(s, ind + 1, left + 1, right, leftRem, rightRem, out, intrimString);
            // If close paranthesis, increase the close paranthesis count and continue.
            // Also have a additional check left > right to make sure we are continuing with
            // a valid string. (i.e.) prune(avoid) invalid(useless) recursions.
            // We maintain these two arguments throughout the program just for the sake of this.
            else if(left > right)
                recur(s, ind + 1, left, right + 1, leftRem, rightRem, out, intrimString);
                        
            // Remove this recently added char for backtracking
            intrimString.deleteCharAt(intrimString.length() - 1);
        }
    }
}
