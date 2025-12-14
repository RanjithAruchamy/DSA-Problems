package scaler.linkedlist;

public class MergeTwoSortedLists {

    /**
     * Merge two sorted linked lists, A and B, and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists and should also be sorted.
     *
     * Input 1:
     *  A = 5 -> 8 -> 20
     *  B = 4 -> 11 -> 15
     *
     * Input 2:
     *  A = 1 -> 2 -> 3
     *  B = Null
     *
     *  Output 1:
     *  4 -> 5 -> 8 -> 11 -> 15 -> 20
     *
     *  Output 2:
     *  1 -> 2 -> 3
     */

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null) return B;
        if (B == null) return A;

        ListNode head = null;
        if (A.val < B.val) {
            head = A;
            A = A.next;
        } else {
            head = B;
            B = B.next;
        }

        ListNode temp = head;
        while (A != null && B != null) {
            if (A.val < B.val) {
                temp.next = A;
                A = A.next;
            } else {
                temp.next = B;
                B = B.next;
            }
            temp = temp.next;
        }

        if (A != null) temp.next = A;
        if (B != null) temp.next = B;
        return head;
    }

    public static void main(String[] args) {
        ListNode inputA = new ListNode(5);
        inputA.next = new ListNode(8);
        inputA.next.next = new ListNode(20);

        ListNode inputB = new ListNode(4);
        inputB.next = new ListNode(11);
        inputB.next.next = new ListNode(15);

        mergeTwoLists(inputA, inputB);
    }
}
