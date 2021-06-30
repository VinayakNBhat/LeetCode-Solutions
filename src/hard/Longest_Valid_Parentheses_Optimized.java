package hard;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Problem Description:
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * O(N) -- Time complexity
 * O(1) -- Space complexity
 */
public class Longest_Valid_Parentheses_Optimized {
    class Solution {
        public int longestValidParentheses(String s) {
            int open = 0, close = 0;
            int maxLen = 0;
            // Run from 0 - n
            for(int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    open++;
                } else {
                    close++;
                }

                if(open == close) {
                    maxLen = Math.max(maxLen, open + close);
                }

                if(close > open) {
                    open = close = 0;
                }
            }

            open = close = 0;

            // Run from n - 0
            for(int i = s.length()-1; i >= 0; i--) {
                if(s.charAt(i) == '(') {
                    open++;
                } else {
                    close++;
                }

                if(open == close) {
                    maxLen = Math.max(maxLen, open + close);
                }

                if(open > close) {
                    open = close = 0;
                }
            }
            return maxLen;
        }
    }
}
