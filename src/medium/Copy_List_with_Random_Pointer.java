package medium;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 *
 */
public class Copy_List_with_Random_Pointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node newHead = null;
            Node cur = head;
            while(cur != null) {
                Node node = new Node(cur.val);
                Node originalNext = cur.next;
                cur.next = node;
                node.next = originalNext;
                cur = originalNext;
            }

            cur = head;
            while(cur != null) {
                if (cur.random != null) {
                    cur.next.random = cur.random.next;
                }
                cur = cur.next.next;
            }

            cur = head;
            newHead = head.next;
            while(cur != null) {
                Node temp = cur.next;
                cur.next = cur.next != null ? cur.next.next : null;
                cur = temp;
            }

            return newHead;
        }
    }
}
