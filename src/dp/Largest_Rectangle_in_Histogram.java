package dp;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 *
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 */
public class Largest_Rectangle_in_Histogram {
    class Solution {
        public int largestRectangleArea(int[] h) {
            int n = h.length;
            Stack<Integer> stack = new Stack<>();
            int area = 0;
            int i = 0;
            while(i < n) {
                if (stack.empty() || h[i] >= h[stack.peek()]) {
                    stack.push(i++);
                } else {
                    int top = stack.pop();
                    if (stack.empty()) {
                        area = Math.max(area, h[top] * i);
                    } else {
                        area = Math.max(area, h[top] * (i - 1 - stack.peek()));
                    }
                }
            }

            while(!stack.empty()) {
                int top = stack.pop();
                if (stack.empty()) {
                    area = Math.max(area, h[top] * i);
                } else {
                    area = Math.max(area, h[top] * (i - stack.peek() - 1));
                }
            }

            return area;
        }
    }
}
