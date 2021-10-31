package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 *
 * Given the root of a binary tree, return all root-to-leaf paths in any order.
 *
 * A leaf is a node with no children.
 */
public class Binary_Tree_Paths {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();
            getPaths(root, "", list);
            return list;
        }

        void getPaths(TreeNode root, String str, List<String> list) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                str = str + root.val;
                list.add(str);
                return;
            }

            String s = str + root.val + "->";
            getPaths(root.left, s, list);
            getPaths(root.right, s, list);
        }
    }
}
