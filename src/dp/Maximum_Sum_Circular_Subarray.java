package dp;

/**
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 *
 * Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
 *
 * A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
 *
 * A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 *
 */
public class Maximum_Sum_Circular_Subarray {
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int n = nums.length;
            int max = Integer.MIN_VALUE;
            int maxTillHere = 0;

            int min = Integer.MAX_VALUE;
            int minTillHere = 0;

            int total = 0;
            for(int i = 0; i < n; i++) {
                maxTillHere += nums[i];
                minTillHere += nums[i];

                max = Math.max(max, maxTillHere);
                min = Math.min(min, minTillHere);

                if(maxTillHere < 0) maxTillHere = 0;
                if(minTillHere > 0) minTillHere = 0;
                total += nums[i];
            }

            return max > 0 ? Math.max(total - min, max) : max;
        }
    }
}
