package scaler.contest.dsa2.attempt4;

public class SortList {

    /**
     * Sort a linked list, A in O(n log n) time.
     *
     * Input 1:
     * A = [3, 4, 2, 8]
     *
     * Input 2:
     * A = [1]
     *
     * Output 1:
     * [2, 3, 4, 8]
     *
     *  Output 2:
     * [1]
     */

     class ListNode {
         public int val;
         public ListNode next;
         ListNode(int x) { val = x; next = null; }
     }

    public ListNode sortList(ListNode A) {
        if (A == null) return A;

        ListNode mid = findMid(A);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = A;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
         if (left == null) return right;
         if (right == null) return left;

         ListNode head;
         if (left.val > right.val) {
             head = right;
             right = right.next;
         } else {
             head = left;
             left = left.next;
         }

         ListNode temp = head;
         while (left != null && right != null) {
             if (left.val > right.val) {
                 temp.next = right;
                 right = right.next;
             } else {
                 temp.next = left;
                 left = left.next;
             }
             temp = temp.next;
         }

         if (left != null) temp.next = left;
         if (right != null) temp.next = right;

         return head;
    }

    private ListNode findMid(ListNode A) {
         if (A == null && A.next == null) return A;

         ListNode slow = A, fast = A.next;

         while (fast != null & fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
    }


}
