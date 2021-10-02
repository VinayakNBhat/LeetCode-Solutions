package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class Pascals_Triangle {
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<>();
            List<Integer> list = new ArrayList<>();

            for(int i = 1; i <= numRows; i++) {
                list.add(0, 1);

                for(int j = 1; j < list.size() -1; j++) {
                    list.set(j, list.get(j) + list.get(j+1));
                }

                ret.add(new ArrayList<>(list));
            }

            return ret;
        }
    }


}
