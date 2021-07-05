package medium;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *TC: O(log N)
 */
public class Search_in_Rotated_Sorted_Array {
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            int pI = findPivotIndex(nums, 0, n-1);
            //System.out.println(pI);
            if(pI == -1) {
                // array is not rotated. Go for binary search
                return binarySearch(nums, 0, n-1, target);
            } else {
                // Search in sorted-rotated array
                if(target >= nums[0] && target <= nums[pI]) {
                    return binarySearch(nums, 0, pI, target);
                } else {
                    return binarySearch(nums, pI + 1, n-1, target);
                }
            }
        }

        int binarySearch(int[] nums, int low, int high, int target) {
            if (low == high) {
                if(nums[low] == target) return low;
                return -1;
            }

            if(nums[low] == target) return low;

            if(nums[high] == target) return high;

            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                return binarySearch(nums, low, mid, target);
            } else {
                return binarySearch(nums, mid + 1, high, target);
            }
        }

        int findPivotIndex(int[] nums, int low, int high) {

            if(low == high)
                return -1;

            int mid = (low + high) / 2;

            if(mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if(mid > 0 && nums[mid] < nums[mid - 1]) {
                return mid-1;
            }

            int index = findPivotIndex(nums, low, mid);
            if(index == -1) {
                return findPivotIndex(nums, mid + 1, high);
            }

            return index;
        }


    }
}
