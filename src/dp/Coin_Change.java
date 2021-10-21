package dp;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Coin_Change {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];

            for(int j = 1; j <= amount; j++) {
                dp[0][j] = Integer.MAX_VALUE - 1;
                dp[1][j] = (j % coins[0] == 0 ? (j / coins[0]) : Integer.MAX_VALUE - 1);
            }

            for(int i = 2; i <= n; i++) {
                for(int j = 1; j <= amount; j++) {
                    if (coins[i-1] > j) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coins[i-1]] + 1);
                    }
                }
            }

            return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
        }
    }
}
