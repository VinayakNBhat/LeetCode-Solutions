package medium;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root == p || root == q) return root;

            TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
            TreeNode rightResult = lowestCommonAncestor(root.right, p, q);

            if (leftResult != null && rightResult != null) return root;

            if (leftResult != null) {
                return leftResult;
            } else {
                return rightResult;
            }
        }
    }
}
