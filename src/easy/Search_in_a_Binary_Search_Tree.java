package easy;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 *
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 *
 */
public class Search_in_a_Binary_Search_Tree {
    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) return null;
            if(root.val == val) return root;
            if (root.val < val) {
                return searchBST(root.right, val);
            } else {
                return searchBST(root.left, val);
            }

        }
    }
}
