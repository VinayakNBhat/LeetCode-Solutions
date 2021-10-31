package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 */
public class Binary_Tree_Right_Side_View {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            Map<Integer, List<Integer>> map = new TreeMap<>();

            levelOrder(root, map, 0);

            List<Integer> list = new ArrayList<>();

            for(List<Integer> l : map.values()) {
                list.add(l.get(l.size()-1));
            }

            return list;
        }

        void levelOrder(TreeNode root, Map<Integer, List<Integer>> map, int level) {
            if (root == null) return;

            List<Integer> list = map.getOrDefault(level, new ArrayList<>());

            list.add(root.val);

            map.put(level, list);

            levelOrder(root.left, map, level + 1);
            levelOrder(root.right, map, level + 1);
        }
    }
}
