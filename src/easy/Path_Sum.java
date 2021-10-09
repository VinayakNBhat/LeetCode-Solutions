package easy;

/**
 * https://leetcode.com/problems/path-sum/
 *
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 */
public class Path_Sum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return hasPathSum(root, targetSum, 0);
        }

        boolean hasPathSum(TreeNode root, int targetSum, int curSum) {
            if(root == null) {
                return false;
            }
            if(root.left == null && root.right == null) {
                return (curSum + root.val) == targetSum;
            }

            curSum += root.val;

            //if (curSum > targetSum) return false;

            return hasPathSum(root.left, targetSum, curSum) ||
                    hasPathSum(root.right, targetSum, curSum);
        }
    }
}
