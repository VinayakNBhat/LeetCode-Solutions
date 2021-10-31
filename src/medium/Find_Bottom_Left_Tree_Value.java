package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 *
 * Given the root of a binary tree, return the leftmost value in the last row of the tree.
 */
public class Find_Bottom_Left_Tree_Value {
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
        int highestLevel;
        public int findBottomLeftValue(TreeNode root) {
            Map<Integer, List<Integer>> map = new HashMap<>();

            levelOrder(root, map, 0);
            return map.get(highestLevel).get(0);
        }

        void levelOrder(TreeNode root, Map<Integer, List<Integer>> map, int level) {
            if (root == null) return;
            List<Integer> l = map.getOrDefault(level, new ArrayList<>());
            l.add(root.val);
            map.put(level, l);
            highestLevel = Math.max(level, highestLevel);
            //System.out.println("level = " + level);
            levelOrder(root.left, map, level + 1);
            levelOrder(root.right, map, level + 1);
        }
    }
}
