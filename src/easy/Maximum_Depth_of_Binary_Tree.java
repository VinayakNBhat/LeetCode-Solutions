package easy;


/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 */
public class Maximum_Depth_of_Binary_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        int max = 0;
        public int maxDepth(TreeNode root) {
            return maxDepth(root, 0);
        }
        int maxDepth(TreeNode root, int level) {
            if (root == null) return level;

            return Math.max(maxDepth(root.left, level + 1), maxDepth(root.right, level + 1));
        }
    }
}
