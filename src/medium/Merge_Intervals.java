package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class Merge_Intervals {
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length <= 1) return intervals;

            Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

            List<int[]> list = new ArrayList<>();
            list.add(intervals[0]);

            for(int[] interval : intervals) {
                int[] prev = list.get(list.size()-1);
                int cur_beg = interval[0];
                int cur_end = interval[1];
                int prev_end = prev[1];
                int prev_beg = prev[0];

                if(prev_end >= cur_beg) {
                    prev[1] = Math.max(cur_end, prev[1]);
                    prev[0] = Math.min(prev[0], cur_beg);
                } else {
                    list.add(interval);
                }
            }

            return list.toArray(new int[list.size()][2]);
        }
    }
}
