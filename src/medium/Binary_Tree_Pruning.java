package medium;

/**
 * https://leetcode.com/problems/binary-tree-pruning/
 *
 * Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 *
 * A subtree of a node node is node plus every node that is a descendant of node.
 */
public class Binary_Tree_Pruning {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        public TreeNode pruneTree(TreeNode root) {
            return containsOne(root) ? root : null;
        }

        boolean containsOne(TreeNode root) {
            if (root == null) return false;

            boolean leftTreeContainsOne = containsOne(root.left);

            boolean rightTreeContainsOne = containsOne(root.right);

            if (!leftTreeContainsOne) {
                root.left = null;
            }

            if (!rightTreeContainsOne) {
                root.right = null;
            }

            return root.val == 1 || leftTreeContainsOne || rightTreeContainsOne;
        }
    }
}
