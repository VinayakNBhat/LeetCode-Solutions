package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 *
 * Given the root of a binary tree, return the maximum width of the given tree.
 *
 * The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 *
 *
 */
public class Maximum_Width_of_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            if (root.left == null && root.right == null) return 1;
            Map<Integer, List<Integer>> map = new HashMap<>();
            int diam = 0;
            root.val = 0;
            map.put(0, new ArrayList<Integer>(){{add(0);}});
            levelOrder(root, map, 0);

            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                List<Integer> list = entry.getValue();
                diam = Math.max(diam, list.get(list.size() - 1) - list.get(0) + 1);
            }

            return diam;
        }

        void levelOrder(TreeNode root, Map<Integer, List<Integer>> map, int rootLevel) {
            if(root == null) return;
            int childLevel = rootLevel + 1;

            List<Integer> list = map.getOrDefault(childLevel, new ArrayList<>());

            if (root.left != null) {
                root.left.val = root.val * 2 + 1;
                list.add(root.left.val);
                map.put(childLevel, new ArrayList<>(list));
                levelOrder(root.left, map, childLevel);
            }
            if (root.right != null) {
                root.right.val = root.val * 2 + 2;
                list.add(root.right.val);
                map.put(childLevel, new ArrayList<>(list));
                levelOrder(root.right, map, childLevel);
            }
        }
    }
}
