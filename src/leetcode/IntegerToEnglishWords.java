1. Store Significant numbers and words in separate array in desc order. The desc order is important cauz we are gonna employ reduction by division in the iteration.
2. If number is same as current iteration value, return it.
3. Otherwise, compute prefix and suffix. (i.e.) via division and modulo. (i.e.), for 123, prefix will be 1 and Suffix will be 3 when divided over 100.
3. Two important conditions to check: 
4. First, If the number is > than 100. Cauz only for these numbers prefix is valid. (i.e.) 1500 is *Fifteen* Hundred, 500 is *Five* Hundred etc.
5. Second, to make sure the numbers sent inside numberToWords() recursive call are not equal to zero. So that we wont get the string "Zero" printed unnecessarily.
6. We do a .trim() for thw whole of the numberToWords() call to remove unwanted spaces.


    public String numberToWords(int n) {
        if(n == 0) return "Zero";
        
        int[] nums = {1000000000,1000000, 1000, 100, 90, 80, 70, 60, 50, 40, 30, 20, 19, 18, 17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        String[] words = {"Billion", "Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty", "Fifty", "Forty", "Thirty", "Twenty", "Nineteen", "Eighteen", "Seventeen", "Sixteen", "Fifteen", "Fourteen", "Thirteen", "Twelve", "Eleven", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Two", "One"};
        
        for(int i = 0; i < nums.length; i++){        	
            int p = n / nums[i]; // Prefix            
            int q = n % nums[i]; // Suffix               
            if(p > 0)
                return ((n >= 100 ? numberToWords(p) : "") 
                + " " + words[i] + " " + 
                (q > 0 ? numberToWords(q) : "")).trim();            
        }        
        return "";
    }   