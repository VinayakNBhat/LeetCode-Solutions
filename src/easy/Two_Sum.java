package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */
public class Two_Sum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ret = new int[2];
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    ret[0] = map.get(target - nums[i]);
                    ret[1] = i;
                    break;
                } else {
                    map.put(nums[i], i);
                }
            }

            return ret;
        }
    }
}
