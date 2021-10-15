package dp;

/**
 * https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/
 *
 * Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.
 *
 * A subarray of an array is a consecutive sequence of zero or more values taken out of that array.
 *
 * Return the maximum length of a subarray with positive product.
 */
public class Maximum_Length_of_Subarray_With_Positive_Product {
    /**
     * Algorithm explanation:
     *
     * First, we need to skip all the 0's. We start from the next index of 0.
     * Then we traverse till the element != 0 and keep counting the # of -'ve ints.
     * While doing this we fis the position of first and the last -'ve ints.
     * This will help us finding the length of the sub-array where products are > 0.
     *
     * A good YouTube reference: https://www.youtube.com/watch?v=vmY9ctncXQI
     */
    class Solution {
        public int getMaxLen(int[] nums) {
            int n = nums.length;
            int len = 0;

            for(int i = 0; i < n;) {
                int start = i;
                int end = start;
                while(end < n && nums[end] == 0) {
                    end++;
                }
                start = end;

                int firstNeg = -1;
                int lastNeg = -1;
                int negCount = 0;
                while(end < n && nums[end] != 0) {
                    if (nums[end] < 0) {
                        negCount++;
                        if (firstNeg == -1) firstNeg = end;
                        lastNeg = end;
                    }
                    end++;
                }
                if (negCount % 2 == 0) {
                    len = Math.max(len, end - start);
                } else {
                    if (firstNeg != -1) {
                        len = Math.max(len, end - firstNeg - 1);
                    }
                    if (lastNeg != -1) {
                        len = Math.max(len, lastNeg - start);
                    }
                }
                i = end + 1;
            }
            return len;
        }
    }
}
