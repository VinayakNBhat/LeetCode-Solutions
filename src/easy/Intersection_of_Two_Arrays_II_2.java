package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 *
 */
public class Intersection_of_Two_Arrays_II_2 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Long> map = Arrays
                    .stream(nums1)
                    .boxed()
                    .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

            return Arrays.stream(nums2)
                    .filter(e -> {
                        if (!map.containsKey(e)) {
                            return false;
                        }
                        map.put(e, map.get(e) - 1);
                        if (map.get(e) == 0) {
                            map.remove(e);
                        }
                        return true;
                    }).toArray();
        }
    }
}
