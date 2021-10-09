package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Binary_Tree_Level_Order_Traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ret = new ArrayList<>();
            levelOrder(root, 0);
            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                ret.add(entry.getValue());
            }
            return ret;
        }

        void levelOrder(TreeNode root, int level) {
            if (root == null) return;

            List<Integer> list = map.getOrDefault(level, new ArrayList<>());
            list.add(root.val);
            map.put(level, list);
            levelOrder(root.left, level + 1);
            levelOrder(root.right, level + 1);
        }
    }
}
