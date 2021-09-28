package easy;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/
 *
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 */
public class N_th_Tribonacci_Number {
    class Solution {
        public int tribonacci(int n) {
            int first = 0;
            int sec = 1;
            int third = 1;
            int ret = 0;

            if(n <= 1) return n;

            if (n == 2) return 1;

            for(int i = 3; i <= n; i++) {
                ret = first + sec + third;
                first = sec;
                sec = third;
                third = ret;
            }

            return ret;
        }
    }
}
