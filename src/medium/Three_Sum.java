package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class Three_Sum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            List<String> hashCode = new ArrayList<>();
            Arrays.sort(nums);
            int n = nums.length;
            for(int i = 0; i < n-2; i++) {
                int j = i + 1;
                int k = n-1;
                if(i > 0 && nums[i] == nums[i-1]) continue;
                while(j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0 && !hashCode.contains("" + nums[i] + nums[j] + nums[k])) {
                        ret.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]}));
                        hashCode.add("" + nums[i] + nums[j] + nums[k]);
                        j++;k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            return ret;
        }
    }
}
