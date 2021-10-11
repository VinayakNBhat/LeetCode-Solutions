package medium;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class Validate_Binary_Search_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    class Solution {
        TreeNode prev;
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            boolean left = isValidBST(root.left);
            if(!left) return false;

            if (prev != null && root.val <= prev.val) return false;

            prev = root;

            return isValidBST(root.right);
        }
    }

    // Another solution without using list.
    class Solution2 {
        List<Integer> list = new LinkedList<>();

        void setInorder(TreeNode root) {
            if(root == null)
                return;

            setInorder(root.left);
            list.add(root.val);
            setInorder(root.right);
        }

        public boolean isValidBST(TreeNode root) {
            boolean check = false;
            setInorder(root);
            for(int i = 0 ; i < list.size() - 1; i++) {
                if(list.get(i) >= list.get(i+1))
                    return false;
            }

            return true;
        }
    }
}
