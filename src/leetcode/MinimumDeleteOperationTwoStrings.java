/*
https://leetcode.com/problems/delete-operation-for-two-strings/submissions/

The Idea is to 
1. Find the longest common subsequence between the two strings
2. Subtracting this from the original strings gives the minimum number of characters to be deleted.
*/

package leetcode;

public class MinimumDeleteOperationTwoStrings {

  public int minDistance(String a, String b) {
        int[][] memo = new int[a.length() + 1][b.length() + 1];
        
        for(int i = 1; i <= a.length(); i++){
            for(int j = 1; j <= b.length(); j++){
                memo[i][j] = a.charAt(i - 1) == b.charAt(j - 1) ? 
                    memo[i - 1][j - 1] + 1
                    : Math.max(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        
        int longestCommonSubseqLen = memo[a.length()][b.length()];
        
        return a.length() + b.length() - 2 * longestCommonSubseqLen;
    }

}
