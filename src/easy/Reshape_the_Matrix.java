package easy;

/**
 * https://leetcode.com/problems/reshape-the-matrix/
 *
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
 *
 * You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
 *
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
 *
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 *
 */
public class Reshape_the_Matrix {
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            if ((mat.length * mat[0].length) != (r * c)) return mat;

            int[][] ret = new int[r][c];
            int nr = 0; int nc = 0;

            for(int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat[0].length; j++) {
                    ret[nr][nc] = mat[i][j];
                    nc++;
                    if(nc >= c) {
                        nc = 0;
                        nr++;
                    }
                }
            }

            return ret;
        }
    }
}
