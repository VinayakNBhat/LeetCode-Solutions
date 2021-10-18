package hard;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class Regular_Expression_Matching {
    class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

            dp[0][0] = true;
            for(int i = 1; i <= p.length(); i++) {
                if (p.charAt(i-1) == '*') {
                    dp[0][i] = dp[0][i-2];
                }
            }

            for(int i = 1; i < dp.length; i++) {
                for(int j = 1; j < dp[0].length; j++) {
                    if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                        dp[i][j] = dp[i-1][j-1];
                    } else if (p.charAt(j-1) == '*') {
                        dp[i][j] = dp[i][j-2];
                        if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
                            dp[i][j] = dp[i-1][j] || dp[i][j];
                        }
                    }
                }
            }

            return dp[dp.length - 1][dp[0].length - 1];
        }
    }
}
