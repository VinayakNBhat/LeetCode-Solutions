package dp;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 * TC: O(N^2)
 * SC: O(N)
 */
public class Longest_Increasing_Subsequence {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dp = new int[n];
            int max = 0;
            for(int i = 1; i < n; i++) {
                int j = 0;
                while(j < i) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                        max = Math.max(max, dp[i]);
                    }
                    j++;
                }
            }
            return max + 1;
        }
    }
}
