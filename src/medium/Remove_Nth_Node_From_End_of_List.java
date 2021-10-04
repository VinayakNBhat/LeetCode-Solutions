package medium;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class Remove_Nth_Node_From_End_of_List {
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
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode nH = new ListNode(0);
            nH.next = head;

            ListNode slow = nH;
            ListNode fast = nH;
            while(n > 0) {
                fast = fast.next;
                n--;
            }

            while(fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;

            return nH.next;
        }
    }
}
