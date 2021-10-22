package hard;

import java.util.Stack;

/**
 * https://leetcode.com/problems/maximal-rectangle/
 *
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 */
public class Maximal_Rectangle {
    class Solution {
        public int maximalRectangle(char[][] mat) {
            if (mat.length == 0) return 0;
            int[] arr = new int[mat[0].length];
            int max = 0;
            for(int i = 0; i < mat.length; i++) {
                alterArray(mat, arr, i);
                max = Math.max(max, maxAreaInHistogram(arr));
            }
            return max;
        }

        void alterArray(char[][] mat, int[] arr, int row) {
            for(int j = 0; j < arr.length; j++) {
                if (mat[row][j] == '1') {
                    arr[j]++;
                } else {
                    arr[j] = 0;
                }
            }
        }

        int maxAreaInHistogram(int[] arr) {
            int n = arr.length;
            Stack<Integer> st = new Stack<>();
            int area = 0;
            int i = 0;
            while(i < n) {
                if (st.empty() || arr[i] >= arr[st.peek()]) {
                    st.push(i++);
                } else {
                    area = maxArea(arr, st, area, i);
                }
            }
            while(!st.empty()) {
                area = maxArea(arr, st, area, i);
            }

            return area;
        }

        int maxArea(int[] arr, Stack<Integer> st, int area, int i) {
            int top = st.pop();
            if (st.empty()) {
                area = Math.max(area, arr[top] * i);
            } else {
                area = Math.max(area, arr[top] * (i - st.peek() - 1));
            }

            return area;
        }
    }
}
