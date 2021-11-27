package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/contest/weekly-contest-211/problems/largest-substring-between-two-equal-characters/
 *
 * Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.
 *
 * A substring is a contiguous sequence of characters within a string.
 */
public class Largest_Substring_Between_Two_Equal_Characters {
    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int len = -1;
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    len = Math.max(len, i - map.get(ch) - 1);
                } else {
                    map.put(ch, i);
                }
            }

            return len;
        }
    }
}
