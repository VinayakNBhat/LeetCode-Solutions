package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/missing-number/
 *
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 *
 */
public class Missing_Number {
    class Solution {
        public int missingNumber(int[] nums) {
            int[] arr = new int[nums.length+1];

            for(int i = 0; i < nums.length; i++ ) {
                arr[nums[i]]++;
            }

            for(int i = 0, j = nums.length; i <= j; i++,j-- ) {
                if(arr[i] == 0) {
                    return i;
                }

                if(arr[j] == 0) {
                    return j;
                }
            }

            return nums.length;
        }

        public int missingNumber(int[] nums, int dummy) {
            Set<Integer> set= new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            for(int i = 0; i < nums.length; i++) {
                if(!set.contains(i)) {
                    return i;
                }
            }

            return nums.length;
        }

    }
}
