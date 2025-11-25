package scaler.linkedlist;

public class ReverseLinkedList {

    /**
     * You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.
     * NOTE: You have to do it in-place and in one-pass.
     *
     * Input 1:
     *  A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL
     *
     *  Input 2:
     *  A = 3 -> NULL
     *
     *  Output 1:
     *  5 -> 4 -> 3 -> 2 -> 1 -> NULL
     *
     *  Output 2:
     *  3 -> NULL
     */

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode curr = A;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
