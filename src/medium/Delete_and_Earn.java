package medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/delete-and-earn/
 *
 * You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
 *
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
 * Return the maximum number of points you can earn by applying the above operation some number of times.
 */
public class Delete_and_Earn {
    class Solution {
        public int deleteAndEarn(int[] nums) {
            int max = Arrays.stream(nums).max().getAsInt();
            int[] dp = new int[max + 1];

            for (int i = 0; i < nums.length; i++) {
                dp[nums[i]] += nums[i];
            }

            for(int i = 2; i < dp.length; i++) {
                dp[i] = Math.max(dp[i] + dp[i-2], dp[i-1]);
            }

            return dp[dp.length - 1];
        }
    }
}
