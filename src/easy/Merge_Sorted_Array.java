package easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.\
 *
 * TC: O((m+n)log(m+n))
 * SC: O(1)
 *
 */
public class Merge_Sorted_Array {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int index = 0;
            for(int i = m; i < nums1.length; i++) {
                nums1[i] = nums2[index++];
            }

            Arrays.sort(nums1);
        }

        public void merge2(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int wp = m + n - 1;

            while(wp >= 0 && p1 >= 0 && p2 >= 0) {
                if(nums1[p1] > nums2[p2]) {
                    nums1[wp--] = nums1[p1--];
                } else {
                    nums1[wp--] = nums2[p2--];
                }
            }

            while(p1 >= 0) {
                nums1[wp--] = nums1[p1--];
            }

            while(p2 >= 0) {
                nums1[wp--] = nums2[p2--];
            }
        }
    }
}
