package medium;

/**
 * https://leetcode.com/problems/house-robber/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 */
public class House_Robber {
    class Solution {
        public int rob(int[] nums) {
            int inclusiveSum = nums[0];
            int exclusiveSum = 0;

            for(int i = 1; i < nums.length; i++) {
                int temp = inclusiveSum;
                inclusiveSum = Math.max(inclusiveSum, exclusiveSum + nums[i]);
                exclusiveSum = temp;
            }

            return Math.max(inclusiveSum, exclusiveSum);
        }
    }
}
