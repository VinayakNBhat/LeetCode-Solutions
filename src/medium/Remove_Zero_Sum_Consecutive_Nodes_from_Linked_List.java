package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 *
 * Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
 *
 * After doing so, return the head of the final linked list.  You may return any such answer.
 *
 *
 *
 * (Note that in the examples below, all sequences are serializations of ListNode objects.)
 *
 * TC: O(N)
 * SC: O(N)
 */
public class Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List {
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            int pSum = 0;
            Map<Integer, ListNode> map = new HashMap<>();
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            map.put(0, dummy);
            while(head != null) {
                pSum += head.val;
                if(map.containsKey(pSum)) {
                    ListNode temp = map.get(pSum).next;
                    map.get(pSum).next = head.next;
                    int tempSum = pSum;
                    while(temp != head) {
                        tempSum += temp.val;
                        map.remove(tempSum);
                        temp = temp.next;
                    }
                } else {
                    map.put(pSum, head);
                }
                head = head.next;
            }

            return dummy.next;
        }
    }
}
