package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/insert-interval/submissions/
 *
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 */
public class Insert_Interval {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> list = new ArrayList<>();
            boolean inserted = false;
            for(int[] interval: intervals) {
                if (!inserted && interval[0] >= newInterval[0]) {
                    list.add(newInterval);
                    inserted = true;
                }
                list.add(interval);
            }

            if (!inserted) {
                list.add(newInterval);
            }

            List<int[]> ret = new ArrayList<>();
            ret.add(list.get(0));
            for(int[] interval : list) {
                int[] current = ret.get(ret.size() - 1);
                int cur_beg = current[0];
                int cur_end = current[1];
                int next_beg = interval[0];
                int next_end = interval[1];

                if (cur_end >= next_beg) {
                    current[0] = Math.min(next_beg, cur_beg);
                    current[1] = Math.max(next_end, cur_end);
                } else {
                    ret.add(interval);
                }
            }

            return ret.toArray(new int[ret.size()][2]);
        }
    }
}
