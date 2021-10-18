package dp;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 *
 * Ex:
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 *
 *
 */
public class Longest_Palindromic_Subsequence {
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int[][] dp = new int[s.length()][s.length()];
            for(int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
            }

            for(int j = 1; j < s.length(); j++) {
                int row = 0;
                int col = j;

                while(col < s.length()) {
                    if (s.charAt(row) == s.charAt(col)) {
                        dp[row][col] = dp[row + 1][col - 1] + 2;
                    } else {
                        dp[row][col] = Math.max(dp[row][col-1], dp[row + 1][col]);
                    }
                    row++;
                    col++;
                }
            }

            return dp[0][s.length()-1];
        }
    }
}
