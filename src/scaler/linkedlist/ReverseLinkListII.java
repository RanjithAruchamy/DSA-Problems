package scaler.linkedlist;

public class ReverseLinkListII {

    /**
     * Reverse a linked list A from position B to C.
     * NOTE: Do it in-place and in one-pass.
     *
     * Input 1:
     *  A = 1 -> 2 -> 3 -> 4 -> 5
     *  B = 2
     *  C = 4
     *
     * Input 2:
     *  A = 1 -> 2 -> 3 -> 4 -> 5
     *  B = 1
     *  C = 5
     *
     *  Output 1:
     *  1 -> 4 -> 3 -> 2 -> 5
     *
     *  Output 2:
     *  5 -> 4 -> 3 -> 2 -> 1
     */

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (A == null) return A;

        int index = 1;
        ListNode temp = A;

        ListNode elemBeforeB = A;
        ListNode elemAtB = A;
        while (temp != null) {
            if (index == B) {
                elemAtB = temp;
                break;
            }
            elemBeforeB = temp;
            index++;
            temp = temp.next;
        }

        index = 1;
        ListNode elemAfterC = null;
        ListNode elemAtC = null;
        while (temp != null) {
            if (index == C) {
                elemAtC = temp;
                elemAfterC = temp.next;
                break;
            }
            index++;
            temp = temp.next;
        }

        ListNode prev = null;
        index = 1;
        while (temp != null) {
            if (index >= B && index <= C) {
                ListNode next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
                continue;
            }
            prev = temp;
            temp = temp.next;
        }
        elemAtB.next = elemAfterC;
        elemBeforeB.next = elemAtC;
        return A;
    }
}
