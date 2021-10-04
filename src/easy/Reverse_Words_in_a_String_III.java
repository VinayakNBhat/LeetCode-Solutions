package easy;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 */
public class Reverse_Words_in_a_String_III {
    class Solution {
        public String reverseWords(String s) {
            StringBuilder sb = new StringBuilder();

            for(String str : s.split("\\ ")) {
                sb.append(new StringBuilder(str).reverse() + " ");
            }

            return sb.toString().trim();
        }
    }
}
