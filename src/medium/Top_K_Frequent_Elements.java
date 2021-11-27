package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class Top_K_Frequent_Elements {
    class Node {
        int val;
        int frequency;

        public Node(int val, int frequency) {
            this.val = val;
            this.frequency = frequency;
        }
    }

    class NodeComparator implements Comparator<Node> {
        public int compare(Node node1, Node node2) {
            if (node1.frequency > node2.frequency) {
                return -1;
            } else if (node1.frequency < node2.frequency) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }

            Queue<Node> pq = new PriorityQueue<>(new NodeComparator());

            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                pq.add(new Node(entry.getKey(), entry.getValue()));
            }

            int[] ret = new int[k];
            for(int i = 0; i < k; i++) {
                ret[i] = pq.poll().val;
            }

            return ret;
        }
    }
}
