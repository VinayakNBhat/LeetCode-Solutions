package easy;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 */
public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (root == p || root == q) return root;

            if (p.val <= root.val && q.val <= root.val) {
                // On the left side of the root
                return lowestCommonAncestor(root.left, p, q);
            } else if (p.val >= root.val && q.val >= root.val) {
                // On the right side of the root
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return root;
            }

        }
    }
}
