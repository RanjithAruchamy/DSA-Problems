package scaler.linkedlist;

public class SortList {

    /**
     * Sort a linked list, A in O(n log n) time.
     *
     * Input 1:
     * A = [3, 4, 2, 8]
     *
     *  Input 2:
     * A = [1]
     *
     * Output 1:
     * [2, 3, 4, 8]
     *
     *  Output 2:
     * [1]
     */

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode sortList(ListNode A) {
        if (A == null || A.next == null) return A;

        ListNode mid = findMidNode(A);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = A;

        ListNode ll1 = sortList(left);
        ListNode ll2 = sortList(right);

        return mergeTwoLinkedList(ll1, ll2);
    }

    public static ListNode findMidNode(ListNode A) {
        if (A == null) return A;

        ListNode slow = A, fast = A.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeTwoLinkedList(ListNode A, ListNode B) {
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
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(8);

        ListNode output = sortList(head);
        System.out.println(output);
    }

}
