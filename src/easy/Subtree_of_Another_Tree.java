package easy;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 *
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 *
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
 */
public class Subtree_of_Another_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode sub) {
            if (root == null) return false;
            if (isSame(root, sub)) return true;
            return isSubtree(root.left, sub) || isSubtree(root.right, sub);
        }

        boolean isSame(TreeNode root, TreeNode sub) {
            if (root == null && sub == null) return true;
            if (root == null || sub == null)  return false;
            if (root.val != sub.val) return false;
            return isSame(root.left, sub.left) && isSame(root.right, sub.right);
        }

    }
}
