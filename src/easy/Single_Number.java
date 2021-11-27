package easy;

/**
 * https://leetcode.com/problems/single-number/
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class Single_Number {
    class Solution {
        public int singleNumber(int[] nums) {
            int ret = 0;
            for(int i : nums) {
                ret ^= i;
            }
            return ret;
        }
    }
}
