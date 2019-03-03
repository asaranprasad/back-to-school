package leetcode;

class LetterCombinationsOfPhone {
    public List<String> letterCombinations(String digits) {        
        List<String> out = new LinkedList<String>();
        if(digits.length() < 1) return out;
        
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        
        util(map, out, 0, "", digits);
        
        return out;
    }
    
    private void util(Map<Character, String> map, List<String> out, int i, String sofar, String digits){
        if(i == digits.length()){
            out.add(sofar);
            return;
        }
                
        for(char c : map.getOrDefault(digits.charAt(i),"").toCharArray()){
            util(map, out, i + 1, sofar + Character.toString(c), digits);
        }
    }
}
