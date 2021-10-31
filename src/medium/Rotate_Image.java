package medium;

/**
 * https://leetcode.com/problems/rotate-image/
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */
public class Rotate_Image {
    class Solution {
        public void rotate(int[][] mat) {
            int N = mat.length;

            // get the transport of the matrix
            for(int i = 0; i < N; i++) {
                for(int j = i; j < N; j++) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }

            // swap the elements of elements of each row
            for(int i = 0; i < N; i++) {
                for(int l = 0, r = N-1; l < r; l++, r--) {
                    int temp = mat[i][l];
                    mat[i][l] = mat[i][r];
                    mat[i][r] = temp;
                }
            }
        }
    }
}
