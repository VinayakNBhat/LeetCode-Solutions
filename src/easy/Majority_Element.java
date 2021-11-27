package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
public class Majority_Element {
    class Solution {
        public int majorityElement(int[] nums) {

            // The most optimized approach
            Arrays.sort(nums);
            int n = nums.length;
            return nums[n/2];

           /*
            Map<Integer, Integer> map = new HashMap<>();
            int n = nums.length / 2;

            for(int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                if (map.get(i) > n) return i;
            }

            return -1;
            */
        }
    }
}
