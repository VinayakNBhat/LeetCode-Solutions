package easy;

/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class Search_Insert_Position {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int pos = binSearch(nums, target, 0, nums.length - 1);

            if (pos == -1) {
                return findPosition(nums, target, 0, nums.length - 1);
            } else {
                return pos;
            }
        }

        int binSearch(int[] nums, int target, int low, int high) {
            if (low > high) return -1;

            if(nums[low] == target) return low;
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;
            if(nums[high] == target) return high;

            if(nums[mid] < target) {
                return binSearch(nums, target, mid + 1, high -1);
            } else {
                return binSearch(nums, target, low + 1, mid - 1);
            }
        }

        int findPosition(int[] nums, int target, int low, int high) {
            //System.out.println(low + " " + high);

            if (low > high) return low;

            if(nums[low] == target) return low;
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;
            if(nums[high] == target) return high;
            if(nums[mid] < target) {
                return findPosition(nums, target, mid + 1, high);
            } else {
                return findPosition(nums, target, low, mid - 1);
            }
        }
    }
}
