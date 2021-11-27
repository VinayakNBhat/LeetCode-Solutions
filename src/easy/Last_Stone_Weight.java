package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  * https://leetcode.com/problems/last-stone-weight/
 *
 *  You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 *
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 *
 * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
 */
public class Last_Stone_Weight {
    class Solution {
        public int lastStoneWeight(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for(int i : nums) {
                list.add(i);
            }

            Collections.sort(list);

            while(list.size() > 1) {
                int maxIndex = list.size() - 1;
                int secondMaxIndex = maxIndex - 1;
                Integer max = list.get(maxIndex);
                Integer secondMax = list.get(secondMaxIndex);
                list.remove(maxIndex);
                list.remove(secondMaxIndex);
                if(max != secondMax) {
                    int diff = max - secondMax;
                    list.add(diff);
                    Collections.sort(list);
                }
            }

            return list.size() > 0 ? list.get(list.size() - 1) : 0;
        }
    }
}
