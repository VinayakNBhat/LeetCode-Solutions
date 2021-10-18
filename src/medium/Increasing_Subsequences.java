package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/increasing-subsequences/
 *
 * Given an integer array nums, return all the different possible increasing subsequences of the given array with at least two elements. You may return the answer in any order.
 *
 * The given array may contain duplicates, and two equal integers should also be considered a special case of increasing sequence.
 *
 */
public class Increasing_Subsequences {
    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List<List<Integer>> ret = new ArrayList<>();

            for(int i = 1; i < nums.length; i++) {
                int j = 0;
                List<List<Integer>> temp = new ArrayList<>();
                boolean increasingSequencePresent = false;
                while (j < i) {
                    if (nums[j] <= nums[i]) {
                        final int i_ = i;
                        final int j_ = j;
                        temp.add(new ArrayList<Integer>() {{add(nums[j_]);add(nums[i_]);}});
                        increasingSequencePresent = true;
                    }
                    j++;
                }
                for(int x = 0; x < ret.size() && increasingSequencePresent; x++) {
                    List<Integer> list = new ArrayList<>(ret.get(x));
                    if ( list.get(list.size() - 1) <= nums[i]) {
                        list.add(nums[i]);
                        temp.add(list);
                    }
                }
                ret.addAll(temp);
            }

            return new ArrayList<>(new HashSet<>(ret));
        }
    }
}
