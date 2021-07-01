package medium;

/**
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 *
 * TC: O(N^3)
 * SC: O(N^2)
 */
public class Knight_Probability_in_Chessboard {
    class Solution {

        int[][] dir = {{-2, 1}, {-2, -1}, {-1, -2}, {-1, 2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};


        boolean isValid(int i, int j, int n) {
            return i >= 0 && i < n && j >= 0 && j < n;
        }

        public double knightProbability(int n, int k, int row, int column) {
            double[][] curr = new double[n][n];

            curr[row][column] = 1.0;

            for(int moves = 1; moves <= k; moves++) {
                double[][] next = new double[n][n];
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        if(curr[i][j] != 0) {
                            for(int m = 0; m < 8; m++) {
                                int ni = i + dir[m][0];
                                int nj = j + dir[m][1];

                                if (isValid(ni, nj, n)) {
                                    next[ni][nj] += curr[i][j] / 8.0;
                                }
                            }
                        }
                    }
                }
                curr = next;
            }

            double prob = 0.0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    prob += curr[i][j];
                }
            }

            return prob;
        }
    }
}
