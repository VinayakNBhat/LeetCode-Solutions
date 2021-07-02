package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/interval-list-intersections/
 *
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * A closed interval [a, b] (with a < b) denotes the set of real numbers x with a <= x <= b.
 *
 * The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 *
 * TC: O(N)
 */
public class Interval_List_Intersections {
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            int m = firstList.length;
            int n = secondList.length;
            List<List<Integer>> list = new ArrayList<>();

            int a1,b1,a2,b2;
            int i = 0, j = 0;

            while(i < m && j < n) {
                a1 = firstList[i][0];
                a2 = firstList[i][1];
                b1 = secondList[j][0];
                b2 = secondList[j][1];

                // no intersection
                if(a1 > b2) {
                    j++;
                } else if(b1 > a2) {
                    i++;
                } else {
                    // intersection
                    List<Integer> l = new LinkedList<>();
                    l.add(Math.max(firstList[i][0], secondList[j][0]));
                    l.add(Math.min(firstList[i][1], secondList[j][1]));
                    list.add(l);

                    if(a2 > b2) {
                        j++;
                    } else if(b2 > a2) {
                        i++;
                    } else {
                        i++; j++;
                    }
                }
            }


            int[][] ret = new int[list.size()][2];

            for(int iter = 0; iter < list.size(); iter++) {
                ret[iter][0] = list.get(iter).get(0);
                ret[iter][1] = list.get(iter).get(1);
            }
            return ret;
        }

    }
}
