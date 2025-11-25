package scaler.linkedlist;

public class RemoveNthNodeFromListEnd {

    /**
     * Given a linked list A, remove the B-th node from the end of the list and return its head.
     * For example, given linked list: 1->2->3->4->5, and B = 2.
     * After removing the second node from the end, the linked list becomes 1->2->3->5.
     * <p>
     * NOTE: If B is greater than the size of the list, remove the first node of the list.
     * <p>
     * Try doing it using constant additional space.
     * <p>
     * Input 1:
     * A = 1->2->3->4->5
     * B = 2
     * <p>
     * Input 2:
     * A = 1
     * B = 1
     * <p>
     * Output 1:
     * 1->2->3->5
     * <p>
     * Output 2:
     */

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode A, int B) {
        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        if (B >= size) {
            return A.next;
        }

        int index = 1;
        temp = A;
        while (temp != null && temp.next != null) {
            if ((size - B) == index) {
                temp.next = temp.next.next;
            }
            index++;
            temp = temp.next;
        }
        return A;
    }
}
