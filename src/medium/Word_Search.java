package medium;

/**
 * https://leetcode.com/problems/word-search/
 *
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class Word_Search {
    class Solution {
        public boolean exist(char[][] board, String word) {
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if (exist(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean exist(char[][] board, String word,
                      int index,
                      int row, int col) {
            if (index >= word.length()) return true;

            if (row < 0 ||
                    row >= board.length ||
                    col < 0 ||
                    col >= board[0].length ||
                    board[row][col] != word.charAt(index)) {
                return false;
            }

            board[row][col] ^= 256;

            boolean exist =  exist(board, word, index + 1, row + 1, col) ||
                    exist(board, word, index + 1, row - 1, col) ||
                    exist(board, word, index + 1, row, col + 1) ||
                    exist(board, word, index + 1, row, col - 1);

            board[row][col] ^= 256;
            return exist;
        }
    }
}
