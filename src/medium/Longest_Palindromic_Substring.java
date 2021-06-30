package medium;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 * Given a string s, return the longest palindromic substring in s.
 *
 *  * O(N^2) -- Time complexity
 *  * O(1) -- Space complexity
 */
public class Longest_Palindromic_Substring {
    class Solution {
        String ret = "";
        public String longestPalindrome(String s) {
            ret = s.charAt(0) + "";
            for(int i = 0; i < s.length(); i++) {
                findPal(s, i, i-1, i+1);
                findPal(s, i, i-1, i);
            }

            return ret;
        }

        void findPal(String s, int index, int left, int right) {
            while(left >= 0 && right < s.length()) {
                if(s.charAt(left) != s.charAt(right)) {
                    break;
                } else {
                    if(right - left + 1 > ret.length()) {
                        ret = s.substring(left, right + 1);
                    }
                }
                left--;
                right++;
            }
        }

    }
}
