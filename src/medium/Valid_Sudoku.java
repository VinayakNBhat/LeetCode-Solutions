package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class Valid_Sudoku {
    class Solution {
        public boolean isValidSudoku(char[][] board) {
            return validateRows(board) &&
                    validateCols(board) &&
                    validateCubes(board);
        }

        boolean validateRows(char[][] board) {
            List<Character> list;
            for(int i = 0; i < board.length; i++) {
                list = new ArrayList<>();
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == '.') continue;
                    if (list.contains(board[i][j])) {
                        return false;
                    } else {
                        list.add(board[i][j]);
                    }
                }
            }
            return true;
        }

        boolean validateCols(char[][] board) {
            List<Character> list;
            for(int i = 0; i < board[0].length; i++) {
                list = new ArrayList<>();
                for(int j = 0; j < board.length; j++) {
                    if(board[j][i] == '.') continue;
                    if (list.contains(board[j][i])) {
                        return false;
                    } else {
                        list.add(board[j][i]);
                    }
                }
            }
            return true;
        }

        boolean validateCubes(char[][] board) {
            List<Character> list;

            for(int i = 0; i <= 2; i++) {

                for(int j = 0; j <= 2; j++) {

                    list = new ArrayList<>();

                    for(int k = i * 3; k < i * 3 + 3; k++) {
                        for(int m = j * 3; m < j * 3 + 3; m++) {
                            if(board[k][m] == '.') continue;
                            if (list.contains(board[k][m])) {
                                return false;
                            } else {
                                list.add(board[k][m]);
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
