package easy;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * TC: O(n)
 *
 */
public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        for(int i = 0; i < nums.length; i++) {
            curSum += nums[i];

            if(curSum > maxSum) {
                maxSum = curSum;
            }

            if(curSum < 0) {
                curSum = 0;
            }
        }

        return maxSum;
    }
}
