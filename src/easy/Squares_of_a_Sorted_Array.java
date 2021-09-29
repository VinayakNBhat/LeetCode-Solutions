package easy;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 *
 */
public class Squares_of_a_Sorted_Array {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] ret = new int[nums.length];

            int l = 0;
            int r = nums.length - 1;
            int index = r;

            while (index >= 0) {
                if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                    ret[index--] = nums[l] * nums[l];
                    l++;
                } else {
                    ret[index--] = nums[r] * nums[r];
                    r--;
                }
            }

            return ret;
        }
    }
}
