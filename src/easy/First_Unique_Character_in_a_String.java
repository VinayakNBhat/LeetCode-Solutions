package easy;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */
public class First_Unique_Character_in_a_String {
    class Solution {
        public int firstUniqChar(String s) {
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(s.indexOf(ch) == s.lastIndexOf(ch)) return i;
            }

            return -1;
        }
    }
}
