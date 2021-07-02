package medium;

/**
 * https://leetcode.com/problems/sort-list/
 *
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 * TC: O(NlogN)
 * SC: O(1)
 */
public class Sort_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode sortList(ListNode head) {
            if(head == null || head.next == null) return head;

            ListNode mid = getMid(head);
            ListNode left = sortList(head);
            ListNode right = sortList(mid);

            return merge(left, right);
        }

        ListNode getMid(ListNode head) {
            ListNode midPrev = null;
            while(head != null && head.next != null) {
                midPrev = (midPrev == null ? head : midPrev.next);
                head = head.next.next;
            }
            ListNode mid = midPrev.next;
            midPrev.next = null;
            return mid;
        }

        ListNode merge(ListNode first, ListNode second) {
            ListNode tmp = new ListNode(-1);
            ListNode res = tmp;
            while(first != null && second != null) {
                if(first.val <= second.val) {
                    tmp.next = first;
                    first = first.next;
                } else {
                    tmp.next = second;
                    second = second.next;
                }
                tmp = tmp.next;
            }

            if(first == null && second != null) {
                if(res.next == null) res.next = second;
                tmp.next = second;
            }

            if(first != null && second == null) {
                if(res.next == null) res.next = first;
                tmp.next = first;
            }

            return res.next;
        }
    }
}
