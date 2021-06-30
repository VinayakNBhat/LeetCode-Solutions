package hard;

/**
 * https://leetcode.com/problems/shortest-palindrome/
 *
 * You are given a string s. You can convert s to a palindrome by adding characters in front of it.
 *
 * Return the shortest palindrome you can find by performing this transformation.
 *
 *  * O(N) -- Time complexity
 *  * O(N) -- Space complexity
 */
public class Shortest_Palindrome {
    class Solution {
        public String shortestPalindrome(String s) {
            StringBuilder sb = new StringBuilder(s);

            sb.append("#");
            sb.reverse();

            int kmp = getKmpMap(s + sb.toString());

            return sb.substring(1, sb.length() - kmp) + s;
        }

        int getKmpMap(String str) {
            int i = 1;
            int j = 0;
            int[] kmp = new int[str.length()];

            while(i < str.length() && j < str.length()) {
                if (str.charAt(j) == str.charAt(i)) {
                    kmp[i] = j + 1;
                    i++;
                    j++;
                } else {
                    if(j-1 >= 0) {
                        j = kmp[j-1];
                    } else {
                        j = 0;
                        if(str.charAt(j) != str.charAt(i)) {
                            i++;
                        }
                    }
                }
            }

            return kmp[kmp.length - 1];
        }
    }
}
