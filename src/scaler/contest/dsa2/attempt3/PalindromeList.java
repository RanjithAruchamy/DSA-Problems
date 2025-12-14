package scaler.contest.dsa2.attempt3;

public class PalindromeList {

    /**
     * Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
     *
     * Input 1:
     * A = [1, 2, 2, 1]
     *
     * Input 2:
     * A = [1, 3, 2]
     *
     * Output 1:
     *  1
     *
     * Output 2:
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
        if (A == null || A.next == null) return 1;

        ListNode middle = findMiddleNode(A);
        ListNode left = A;
        ListNode right = middle.next;
        middle.next = null;

        ListNode prev = null;
        while (right != null) {
            ListNode next = right.next;
            right.next = prev;
            prev = right;
            right = next;
        }
        right = prev;

        while (right != null) {
            if (left.val != right.val) return 0;

            right = right.next;
            left = left.next;
        }
        return 1;
    }

    private static ListNode findMiddleNode(ListNode A) {
        ListNode slow = A, fast = A.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        assert 1 == lPalin(head);
    }
}
