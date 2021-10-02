package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 */
public class Intersection_of_Two_Arrays_II_3 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int l = 0;
            int r = 0;

            List<Integer> ret = new ArrayList<>();

            while(l < nums1.length && r < nums2.length) {
                if (nums1[l] < nums2[r]) {
                    l++;
                } else if (nums1[l] == nums2[r]) {
                    ret.add(nums1[l]);
                    l++;
                    r++;
                } else {
                    r++;
                }
            }

            int[] result = new int[ret.size()];
            for(int i = 0; i < result.length; i++) {
                result[i] = ret.get(i);
            }

            return result;
        }
    }
}
