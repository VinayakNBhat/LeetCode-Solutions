package easy;

import medium.Binary_Tree_Right_Side_View;

/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * Given the root of a binary tree, return the sum of all left leaves.
 */
public class Sum_of_Left_Leaves {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
        }
        int sum;
        public int sumOfLeftLeaves(TreeNode root) {
            sum(root, false);
            return sum;
        }

        void sum(TreeNode root, boolean isLeft) {
            if (root == null) return;
            if(root.left == null && root.right == null && isLeft) {
                sum += root.val;
            }

            sum(root.left, true);
            sum(root.right, false);
        }
    }

}
