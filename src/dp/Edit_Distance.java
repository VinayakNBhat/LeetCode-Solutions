package dp;

/**
 * https://leetcode.com/problems/edit-distance/
 *
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * YouTube Ref: https://www.youtube.com/watch?v=We3YDTzNXEk&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=6
 *
 * TC: O(MN)
 * SC: O(MN)
 */
public class Edit_Distance {
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();

            int[][] dp = new int[m+1][n+1];

            for(int i = 1; i <= n; i++) {
                dp[0][i] = i;
            }

            for(int j = 1; j <= m; j++) {
                dp[j][0] = j;
            }

            for(int i = 1; i <= m; i++) {
                for(int j = 1; j <= n; j++) {
                    if (word1.charAt(i-1) == word2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    }
                }
            }

            return dp[m][n];
        }
    }
}
