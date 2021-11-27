package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */
public class Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(new ArrayList<>());
            findSubSets(ret, nums, 0);
            return ret;
        }

        void findSubSets(List<List<Integer>> ret, int[] nums, int index) {
            if (index >= nums.length) return;
            int n = ret.size();
            for(int i = 0; i < n; i++) {
                List<Integer> temp = new ArrayList<>(ret.get(i));
                temp.add(nums[index]);
                ret.add(temp);
            }

            findSubSets(ret, nums, index + 1);
        }
    }
}
