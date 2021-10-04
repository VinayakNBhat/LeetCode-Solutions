package easy;

/**
 * https://leetcode.com/problems/reverse-string/
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 */
public class Reverse_String {
    class Solution {
        public void reverseString(char[] s) {
            int l = 0; int r = s.length - 1;
            while(l < r) {
                char temp = s[l];
                s[l] = s[r];
                s[r] = temp;
                l++;r--;
            }
        }
    }
}
