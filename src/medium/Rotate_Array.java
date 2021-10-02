package medium;

/**
 * https://leetcode.com/problems/rotate-array/
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
public class Rotate_Array {
    class Solution {
        public void rotate(int[] nums, int k) {
            if(k % nums.length == 0) {
                return;
            } else {
                k = k % nums.length;
            }
            reverse(nums, 0, nums.length-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, nums.length-1);
            return;
        }

        void reverse(int[] nums, int low, int high) {
            while(low < high) {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;high--;
            }
        }
    }
}
