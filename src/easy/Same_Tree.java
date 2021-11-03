package easy;

/**\
 * Same Tree
 *
 * https://leetcode.com/problems/same-tree/
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class Same_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null && q != null) return false;
            if (p != null && q == null) return false;
            if (p.val != q.val) return false;

            if (isLeafNode(p) && isLeafNode(q)) return true;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        boolean isLeafNode(TreeNode node) {
            if (node == null) return false;
            return (node.left == null && node.right == null);
        }
    }
}
