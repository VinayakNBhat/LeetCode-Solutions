package easy;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 *
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 *
 */
public class Remove_Linked_List_Elements {
    class Solution {
        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

        public ListNode removeElements(ListNode head, int val) {
            while(head != null && head.val == val) head = head.next;
            if(head == null) return head;
            ListNode first = head;

            while(first != null && first.next != null) {
                if(first.next.val == val) {
                    first.next = first.next.next;
                    continue;
                }

                first = first.next;
            }

            return head;
        }
    }
}
