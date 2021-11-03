package easy;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 */
public class Minimum_Depth_of_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        int minLength = Integer.MAX_VALUE;
        public int minDepth(TreeNode root) {
            minDepth(root, 1);
            return minLength == Integer.MAX_VALUE ? 0 : minLength;
        }

        void minDepth(TreeNode root, int pathLength) {
            if (root == null) {
                //minLength = Math.min(minLength, pathLength);
                return;
            }

            if(root.left == null && root.right == null) {
                minLength = Math.min(minLength, pathLength);
                return;
            }

            minDepth(root.left, pathLength+1);
            minDepth(root.right, pathLength+1);
        }
    }
}
