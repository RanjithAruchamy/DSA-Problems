package scaler.linkedlist;

public class ReorderList {

    /**
     * Given a singly linked list A
     *  A: A0 → A1 → … → An-1 → An
     * reorder it to:
     *  A0 → An → A1 → An-1 → A2 → An-2 → …
     * You must do this in-place without altering the nodes' values
     *
     * Input 1:
     *  A = [1, 2, 3, 4, 5]
     * Input 2:
     *  A = [1, 2, 3, 4]
     *
     * Output 1:
     * [1, 5, 2, 4, 3]
     * Output 2:
     * [1, 4, 2, 3]
     */

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reorderList(ListNode A) {

        if (A == null) return A;

        // Find Mid node
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse 2nd part of list
        ListNode prev = null, curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr = prev;

        // Link 2nd part with 1st part
        ListNode temp = A;
        while (curr != null) {
            ListNode tempNext = temp.next;
            ListNode currNext = curr.next;

            temp.next = curr;
            curr.next = tempNext;

            curr = currNext;
            temp = tempNext;
        }

        return A;
    }

}
