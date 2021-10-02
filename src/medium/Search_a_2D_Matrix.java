package medium;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class Search_a_2D_Matrix {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = locateRow(matrix, target, 0, matrix.length - 1);
            return row == -1 ? false :
                    binarySearch(matrix, target, row, 0, matrix[0].length - 1);
        }

        int locateRow(int[][] matrix, int target, int low, int high) {
            if (low > high) {
                return -1;
            }
            if (target >= matrix[low][0] &&
                    target <= matrix[low][matrix[0].length - 1]) {
                return low;
            }

            if (target >= matrix[high][0] &&
                    target <= matrix[high][matrix[0].length - 1]) {
                return high;
            }

            int mid = (low + high) / 2;

            if(target >= matrix[mid][0] &&
                    target <= matrix[mid][matrix[0].length - 1]) return mid;

            if (target < matrix[mid][0]) {
                return locateRow(matrix, target, 0, mid - 1);
            } else {
                return locateRow(matrix, target, mid + 1, high);
            }
        }

        boolean binarySearch(int[][] matrix, int target,
                             int row, int low, int high) {
            if (low > high) return false;

            if (target == matrix[row][low] ||
                    target == matrix[row][high]) return true;

            int mid = (low + high) / 2;

            if (target == matrix[row][mid]) return true;

            if (target < matrix[row][mid]) {
                return binarySearch(matrix, target, row, low, mid - 1);
            } else {
                return binarySearch(matrix, target, row, mid + 1, high);
            }
        }
    }
}
