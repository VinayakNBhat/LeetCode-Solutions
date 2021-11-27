package medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 *
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 */
public class Non_overlapping_Intervals {
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
            int l = 0;
            int r = 1;
            int count = 0;

            while(r < intervals.length) {
                int[] rArr = intervals[r];
                int[] lArr = intervals[l];

                if (lArr[1] <= rArr[0]) {
                    // Non-overlapping
                    l = r;
                    r++;
                } else if (lArr[1] <= rArr[1]) {
                    // Partly overlapping, remove R
                    r++;
                    count++;
                } else if (rArr[1] < lArr[1]) {
                    // Complete overlap
                    l = r;
                    r++;
                    count++;
                }
            }

            return count;
        }
    }
}
