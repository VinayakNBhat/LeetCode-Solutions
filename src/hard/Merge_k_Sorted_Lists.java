package hard;

import medium.Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * SC: O(1)
 * TC: O(N)
 */
public class Merge_k_Sorted_Lists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length == 0) return null;
            ListNode dummy = new ListNode();
            dummy.next = lists[0];
            ListNode tmp = dummy;
            for(int i = 1; i < lists.length; i++) {
                ListNode l1 = dummy.next;
                ListNode l2 = lists[i];
                tmp = dummy;
                while(l1 != null && l2 != null) {
                    if(l1.val <= l2.val) {
                        tmp.next = l1;
                        l1 = l1.next;
                    } else {
                        tmp.next = l2;
                        l2 = l2.next;
                    }
                    tmp = tmp.next;
                }

                if(l1 != null) {
                    tmp.next = l1;
                } else if (l2 != null) {
                    tmp.next = l2;
                }
            }

            return dummy.next;
        }
    }
}
