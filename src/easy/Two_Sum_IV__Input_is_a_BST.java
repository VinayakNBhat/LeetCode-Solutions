package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 *
 * Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 */
public class Two_Sum_IV__Input_is_a_BST {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        void inorderTraversal(TreeNode root, List<Integer> list) {
            if (root == null) return;
            inorderTraversal(root.left, list);
            list.add(root.val);
            inorderTraversal(root.right, list);
        }
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            inorderTraversal(root, list);
            int l = 0;
            int r = list.size() - 1;
            while(l < r) {
                int sum = list.get(l) + list.get(r);
                if (sum == k) {
                    return true;
                } else if (sum < k) {
                    l++;
                } else {
                    r--;
                }
            }

            return false;
        }
    }
}
