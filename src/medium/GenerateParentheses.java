package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParentheses {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new ArrayList<>();
            generateParenthesis(n, 0, "", list);
            return list;
        }

        void generateParenthesis(int n, int unBalanced, String comb, List<String> list) {
            if(n==0 && unBalanced==0) list.add(comb);

            if(n > 0) generateParenthesis(n-1, unBalanced+1, comb + "(", list);

            if(unBalanced > 0) generateParenthesis(n, unBalanced-1, comb + ")", list);
        }
    }

    class Solutions2 {
        public List<String> generateParenthesis(int n) {
            StringBuilder sb = new StringBuilder();
            List<String> ret = new ArrayList<>();
            generateParenthesis(n, ret, sb, 0, 0);
            return ret;
        }

        void generateParenthesis(int n, List<String> ret, StringBuilder sb, int open , int closed) {
            if (open >= n && closed >= n) {
                ret.add(sb.toString());
                return;
            }
            if(open < n) {
                sb.append("(");
                generateParenthesis(n, ret, sb, open + 1, closed);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (closed < open) {
                sb.append(")");
                generateParenthesis(n, ret, sb, open, closed + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

