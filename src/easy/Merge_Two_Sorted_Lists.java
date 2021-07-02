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
            ListNode tmp = null;
            ListNode ret = null;
            while(l1 != null && l2 != null) {
                if(tmp == null) {
                    if(l1.val <= l2.val) {
                        tmp = l1;
                        l1 = l1.next;
                    } else {
                        tmp = l2;
                        l2 = l2.next;
                    }
                    ret = tmp;
                    continue;
                }

                if(l1.val <= l2.val) {
                    tmp.next = l1;
                    l1 = l1.next;
                } else {
                    tmp.next = l2;
                    l2 = l2.next;
                }

                tmp = tmp.next;
            }

            if(l1 == null && l2 != null) {
                if(tmp == null) return l2;
                tmp.next = l2;
            }

            if(l1 != null && l2 == null) {
                if(tmp == null) return l1;
                tmp.next = l1;
            }

            return ret;
        }
    }
}
