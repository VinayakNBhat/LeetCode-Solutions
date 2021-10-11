package dp;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 *
 * It is guaranteed that the answer will fit in a 32-bit integer.
 *
 * A subarray is a contiguous subsequence of the array.
 */
public class Maximum_Product_Subarray {
    class Solution {
        public int maxProduct(int[] nums) {
            int ret = nums[0];
            int max = ret;
            int min = ret;

            for(int i = 1; i < nums.length; i++) {
                if(nums[i] < 0) {
                    int temp = max;
                    max = min;
                    min = temp;
                }

                max = Math.max(nums[i], nums[i] * max);
                min = Math.min(nums[i], nums[i] * min);


                ret = Math.max(ret, max);
            }

            return ret;
        }
    }
}
