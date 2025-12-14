package scaler.linkedlist;

public class MiddleElementOfLinkedList {

  static class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

    /**
     * Given a linked list of integers, find and return the middle element of the linked list.
     * NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.
     *
     * Input 1:
     *  1 -> 2 -> 3 -> 4 -> 5
     *
     *  Input 2:
     *  1 -> 5 -> 6 -> 2 -> 3 -> 4
     *
     *  Output 1:
     *  3
     *
     *  Output 2:
     *  2
     */

    public static int solveOptimize(ListNode A) {
        if (A == null) return A.val;

        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }

    public static int solve(ListNode A) {
        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int mid = size / 2;

        temp = A;
        size = 1;
        while (temp != null && size <= mid) {
            temp = temp.next;
            size++;
        }

        return temp.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        assert 3 == solveOptimize(head);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(5);
        head1.next.next = new ListNode(6);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(3);
        head1.next.next.next.next.next = new ListNode(4);
        assert 2 == solveOptimize(head1);
    }
}
