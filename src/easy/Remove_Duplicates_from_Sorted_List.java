package easy;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 */
public class Remove_Duplicates_from_Sorted_List {
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
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return head;
            ListNode first = head;
            ListNode second = head.next;

            while(second != null) {
                while(second != null && second.val == first.val) {
                    second = second.next;
                }
                first.next = second;
                first = first.next;
                if (second != null) {
                    second = second.next;
                }
            }

            return head;
        }
    }
}
