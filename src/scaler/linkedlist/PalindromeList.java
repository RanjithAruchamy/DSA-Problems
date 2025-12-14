package scaler.linkedlist;

public class PalindromeList {

    /**
     * Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
     *
     * Input 1:
     * A = [1, 2, 2, 1]
     *
     *  Input 2:
     * A = [1, 3, 2]
     *
     * Output 1:
     *  1
     *
     *  Output 2:
     *  0
     */

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static int lPalin(ListNode A) {
        if (A.next == null) return 1;

        ListNode mid = findMidNode(A);
        ListNode h1 = A, h2 = mid.next;
        mid.next = null;

        ListNode prev = null;
        while (h2 != null) {
            ListNode next = h2.next;
            h2.next = prev;
            prev = h2;
            h2 = next;
        }

        h2 = prev;
        while (h2 != null) {
            if (h1.val != h2.val) {
                return 0;
            }
            h2 = h2.next;
            h1 = h1.next;
        }
        return 1;
    }

    private static ListNode findMidNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        head.next = new ListNode(3);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(6);

        assert 1 == lPalin(head);
    }

}
