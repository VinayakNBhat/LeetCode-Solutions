package hard;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 *
 * Problem Description:
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 *  * O(N) -- Time complexity
 *  * O(N) -- Space complexity
 */
public class Longest_Valid_Parentheses {
    class Solution {
        class Tuple {
            Character ch;
            int index;
            public Tuple(Character ch, int index) {
                this.ch = ch;
                this.index = index;
            }
        }

        public int longestValidParentheses(String s) {
            Stack<Tuple> st = new Stack<>();
            st.push(new Tuple('v', -1));
            int max = 0;
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if(ch == ')') {
                    if (!st.isEmpty() && st.peek().ch == '(') {
                        st.pop();
                        int prev = st.peek().index;
                        max = Math.max(max, i - prev);
                        continue;
                    }
                }
                st.push(new Tuple(s.charAt(i), i));
            }

            return max;
        }
    }
}
