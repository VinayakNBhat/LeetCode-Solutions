package medium;

/**
 * https://leetcode.com/problems/house-robber-ii/
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class House_Robber_II {
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) return nums[0];
            return Math.max(rob(nums, 0, nums.length - 2),
                    rob(nums, 1, nums.length - 1));
        }

        int rob(int[] nums, int low, int high) {
            int inclusiveSum = nums[low];
            int exclusiveSum = 0;

            for(int i = low + 1; i <= high; i++) {
                int temp = inclusiveSum;
                inclusiveSum = Math.max(inclusiveSum, exclusiveSum + nums[i]);
                exclusiveSum = temp;
            }

            return Math.max(inclusiveSum, exclusiveSum);
        }
    }
}
