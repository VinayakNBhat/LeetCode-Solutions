package easy;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class Symmetric_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root.left == null && root.right == null) return true;
            return isSymmetric(root.left, root.right);
        }

        boolean isSymmetric(TreeNode root1, TreeNode root2) {
            if(root1 == null && root2 == null) return true;
            if (root1 == null || root2 == null) return false;
            if(root1.val != root2.val) return false;

            return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
        }
    }
}
