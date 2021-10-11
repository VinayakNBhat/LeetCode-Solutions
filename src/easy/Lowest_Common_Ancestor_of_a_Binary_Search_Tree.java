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

            if (rootIsSmaller(root.val, p.val, q.val)) {
                return lowestCommonAncestor(root.right, p, q);
            } else if (rootIsLarger(root.val, p.val, q.val)) {
                return lowestCommonAncestor(root.left, p, q);
            } else {
                return root;
            }
        }

        boolean rootIsSmaller(int val, int p, int q) {
            return val < p && val < q;
        }

        boolean rootIsLarger(int val, int p, int q) {
            return val > p && val > q;
        }
    }
}
