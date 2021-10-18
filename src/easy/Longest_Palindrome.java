package easy;

/**
 * https://leetcode.com/problems/longest-palindrome/
 *
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 */
public class Longest_Palindrome {
    class Solution {
        public int longestPalindrome(String s) {
            int[] mapForLowerCase = new int[26];
            int[] mapForUpperCase = new int[26];
            int len = 0;

            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch >= 97) {
                    mapForLowerCase[ch - 'a']++;
                    if (mapForLowerCase[ch - 'a'] > 0 && mapForLowerCase[ch - 'a'] % 2 == 0) {
                        len += 2;
                    }
                } else {
                    mapForUpperCase[ch - 'A']++;
                    if (mapForUpperCase[ch - 'A'] > 0 && mapForUpperCase[ch - 'A'] % 2 == 0) {
                        len += 2;
                    }
                }
            }

            return len + 1 <= s.length() ? len + 1 : len;
        }
    }
}
