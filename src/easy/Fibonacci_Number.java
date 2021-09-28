package easy;

/**
 * https://leetcode.com/problems/fibonacci-number/
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 */
public class Fibonacci_Number {
    class Solution {
        public int fib(int n) {
            int first = 0;
            int second = 1;
            int ret = 0;

            if(n <= 1) return n;

            for(int i = 2; i <= n; i++) {
                ret = first + second;
                first = second;
                second = ret;
            }

            return ret;
        }
    }
}
