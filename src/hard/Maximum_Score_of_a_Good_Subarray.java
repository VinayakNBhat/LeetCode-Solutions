package hard;

/**
 * https://leetcode.com/problems/maximum-score-of-a-good-subarray/
 *
 * You are given an array of integers nums (0-indexed) and an integer k.
 *
 * The score of a subarray (i, j) is defined as min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1). A good subarray is a subarray where i <= k <= j.
 *
 * Return the maximum possible score of a good subarray.
 */
public class Maximum_Score_of_a_Good_Subarray {
    class Solution {
        public int maximumScore(int[] nums, int k) {
            int l = k;
            int r = k;
            int min = nums[k];
            int max = nums[k];
            int n = nums.length;

            while(true) {
                while(r+1 < n && nums[r + 1] >= min) {
                    r++;
                }

                while(l-1 >= 0 && nums[l-1] >= min) {
                    l--;
                }

                max = Math.max(max, min * (r - l + 1));

                if(l == 0 && r == n-1) break;

                if(l == 0) {
                    min = nums[r + 1];
                } else if (r == n-1) {
                    min = nums[l-1];
                } else {
                    min = Math.max(nums[l-1], nums[r+1]);
                }
            }

            return max;
        }
    }
}
