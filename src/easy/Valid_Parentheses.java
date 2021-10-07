package easy;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 */
public class Valid_Parentheses {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);

                if (ch == '{' || ch == '[' || ch == '(') {
                    stack.push(ch);
                } else {
                    if(stack.empty()) return false;
                    char poppedChar = stack.pop();
                    if (!isCorrespondingClose(ch, poppedChar)) {
                        return false;
                    }
                }
            }
            return stack.empty();
        }

        boolean isCorrespondingClose(char ch, char poppedChar) {
            if (ch == '}') {
                return poppedChar == '{';
            } else if (ch == ']') {
                return poppedChar == '[';
            } else if (ch == ')') {
                return poppedChar == '(';
            }
            return false;
        }
    }
}
