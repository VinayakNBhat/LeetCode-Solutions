package medium;

/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 *
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 */
public class Insert_into_a_Binary_Search_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) return new TreeNode(val);
            searchAndInsert(root, val);
            return root;
        }

        void searchAndInsert(TreeNode root, int val) {
            if(root == null) return;

            if (root.left == null && root.right == null ) {
                TreeNode node = new TreeNode(val);
                if(val > root.val) {
                    root.right = node;
                } else {
                    root.left = node;
                }
                return;
            }

            if(val > root.val) {
                if(root.right != null) {
                    searchAndInsert(root.right, val);
                } else {
                    root.right = new TreeNode(val);
                }

            } else {
                if (root.left != null) {
                    searchAndInsert(root.left, val);
                } else {
                    root.left = new TreeNode(val);
                }
            }
        }
    }
}
