package easy;

import medium.Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 *Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * TC: O(N)
 * SC: O(1)
 */
public class Merge_Two_Sorted_Lists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode prev = null;
            ListNode p1 = l1;
            ListNode p2 = l2;
            ListNode newHead = null;

            if (l1 == null) return l2;
            if (l2 == null) return l1;

            if(l1.val <= l2.val) {
                prev = l1;
                p1 = p1.next;
                newHead = l1;
            } else {
                prev = l2;
                p2 = p2.next;
                newHead = l2;
            }

            while(p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    prev.next = p1;
                    prev = prev.next;
                    p1 = p1.next;
                } else {
                    prev.next = p2;
                    prev = prev.next;
                    p2 = p2.next;
                }
            }

            if (p1 == null) {
                prev.next = p2;
            }

            if (p2 == null) {
                prev.next = p1;
            }

            return newHead;
        }
    }
}
