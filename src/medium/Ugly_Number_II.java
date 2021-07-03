package medium;

/**
 * https://leetcode.com/problems/ugly-number-ii/
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 * TC: O(N)
 * SC: O(N)
 */
public class Ugly_Number_II {
    class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];

            if(n <= 5) return n;
            dp[1] = 1;
            int p5 = 1;
            int p2 = 1;
            int p3 = 1;

            for(int i = 2; i <= n; i++) {
                int f2 = dp[p2] * 2;
                int f3 = dp[p3] * 3;
                int f5 = dp[p5] * 5;

                int min = Math.min(f2, Math.min(f3, f5));
                dp[i] = min;

                if(min == f2) {
                    p2++;
                }
                if (min == f3) {
                    p3++;
                }
                if (min == f5){
                    p5++;
                }
            }

            return dp[n];
        }
    }
}
