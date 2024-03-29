package easy;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class Diameter_of_Binary_Tree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            longestPath(root);
            return max;
        }

        int longestPath(TreeNode root) {
            if (root == null ) return 0;

            int left = longestPath(root.left);
            int right = longestPath(root.right);

            max = Math.max(max, left + right);

            return Math.max(left, right) + 1;
        }
    }
}
