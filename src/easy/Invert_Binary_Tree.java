package easy;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class Invert_Binary_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    class Solution {
        public TreeNode invertTree(TreeNode root) {
            helper(root);
            return root;
        }

        void helper(TreeNode root) {
            if (root == null) return ;
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            helper(root.left);
            helper(root.right);
        }
    }
}
