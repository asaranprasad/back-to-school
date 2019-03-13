// https://leetcode.com/problems/fruit-into-baskets/submissions/

package leetcode;

public class FruitInBasket {

    public int totalFruit(int[] tree) {
        int first = -1, second = -1, out = 0, currCount = 0, secondCount = 0;
        for(int t : tree){
            currCount = (t == first || t == second) ? currCount + 1 : secondCount + 1;
            secondCount = (t == second) ? secondCount + 1 : 1;
            if(t != second) {
                first = second;
                second = t;
            }
            out = Math.max(out, currCount);
        }
        return out;
    }

}


// **Problem**
// "Start from any index, we can collect at most two types of fruits. What is the maximum amount"

// **Translation**
// Find out the longest length of subarrays with at most 2 different numbers?

// **Explanation:**
// Loop all fruit c in tree,
// Note that a and b are the last two different types of fruit that we met,
// c is the current fruit type,
// so it's something like "....aaabbbc..."

// **Case 1 c == b:**
// fruit c already in the basket,
// and it's same as the last type of fruit
// cur += 1
// count_b += 1

// **Case 2 c == a:**
// fruit c already in the basket,
// but it's not same as the last type of fruit
// cur += 1
// count_b = 1
// a = b, b = c

// **Case 3 c != b && c!= a:**
// fruit c not in the basket,
// cur = count_b + 1
// count_b = 1
// a = b, b = c

// Of course, in each turn we need to update res = max(res, cur)

// **Complexity:**
// O(N) time, O(1) space