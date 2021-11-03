package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 */
public class Longest_Consecutive_Sequence {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for(int i : nums) {
                set.add(i);
            }

            int maxLen = 0;
            for(int num : set) {

                if (!set.contains(num - 1)) {
                    int inc = num + 1;
                    int lTemp = 1;
                    while(set.contains(inc)) {
                        lTemp++;
                        inc++;
                    }
                    maxLen = Math.max(maxLen, lTemp);
                }
            }

            return maxLen;
        }
    }
}
