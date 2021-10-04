package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 */
public class Longest_Substring_Without_Repeating_Characters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int N = s.length();
            List<Character> list = new ArrayList<>();
            if(s.length() < 2) return s.length();
            int left = 0;
            int right = 0;
            int max = 0;

            while(right < s.length()) {
                if (list.contains(s.charAt(right))) {
                    list.remove(new Character(s.charAt(left)));
                    left++;
                } else {
                    list.add(new Character(s.charAt(right)));
                    right++;
                }
                max = Math.max(max, right - left);
            }

            return max;
        }
    }
}
