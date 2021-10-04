package easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 */
public class Valid_Anagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            char[] sT = s.toCharArray();
            char[] tT = t.toCharArray();

            Arrays.sort(sT);
            Arrays.sort(tT);

            s = String.valueOf(sT);
            t = String.valueOf(tT);

            return s.equals(t);
        }
    }

    class Solution2 {
        public boolean isAnagram(String s, String t) {
            int[] sMap = new int[26];
            int[] tMap = new int[26];

            if (s.length() != t.length()) return false;

            for(int i = 0; i< s.length(); i++) {
                sMap[s.charAt(i) - 'a']++;
                tMap[t.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (sMap[i] != tMap[i]) return false;
            }

            return true;
        }
    }
}
