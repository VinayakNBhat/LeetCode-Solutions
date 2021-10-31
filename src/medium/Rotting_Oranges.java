package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/rotting-oranges/
 *
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class Rotting_Oranges {
    class Solution {

        class Node {
            int time;
            int i, j;

            public Node(int i, int j, int time) {
                this.i = i;
                this.j = j;
                this.time = time;
            }
        }
        int numberOf1And2s;
        int processed;
        Queue<Node> queue = new LinkedList<>();

        public int orangesRotting(int[][] mat) {

            for(int i = 0; i < mat.length; i++) {
                for(int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] == 2) {
                        queue.add(new Node( i, j, 0));
                        numberOf1And2s++;
                        processed++;
                    } else if (mat[i][j] == 1) {
                        numberOf1And2s++;
                    }
                }
            }

            int time = 0;
            while(!queue.isEmpty()) {
                Node node = queue.poll();
                time = node.time;
                process(mat, node);
            }

            if (numberOf1And2s == processed) {
                return time;
            } else {
                return -1;
            }
        }

        void process(int[][] mat, Node node) {
            int i = node.i;
            int j = node.j;
            int time = node.time;

            if (i - 1 >= 0 && mat[i-1][j] == 1) {
                mat[i-1][j] = 2;
                processed++;
                queue.add(new Node(i-1, j, time+1));
            }

            if (i + 1 < mat.length && mat[i+1][j] == 1) {
                mat[i+1][j] = 2;
                processed++;
                queue.add(new Node(i+1, j, time+1));
            }

            if (j-1 >= 0 && mat[i][j-1] == 1) {
                mat[i][j-1] = 2;
                processed++;
                queue.add(new Node(i, j - 1, time+1));
            }

            if (j + 1 < mat[0].length && mat[i][j+1] == 1) {
                mat[i][j+1] = 2;
                processed++;
                queue.add(new Node(i, j + 1, time+1));
            }
        }

    }
}
