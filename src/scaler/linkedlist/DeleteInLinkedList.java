package scaler.linkedlist;

public class DeleteInLinkedList {

    /**
     * You are given the head of a linked list A and an integer B. Delete the B-th node from the linked list.
     * Note : Follow 0-based indexing for the node numbering.
     *
     * Input 1:
     * A = 1 -> 2 -> 3
     * B = 1
     *
     * Input 2:
     * A = 4 -> 3 -> 2 -> 1
     * B = 0
     *
     * Output 1:
     * 1 -> 3
     *
     * Output 2:
     * 3 -> 2 -> 1
     */

  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

    public ListNode solve(ListNode A, int B) {
      if (B == 0) {
          return A.next;
      }

      int index = 0;
      ListNode temp = A;
      while (temp != null && temp.next != null) {
        if (index == B - 1) {
            temp.next = temp.next.next;
        }
        index++;
        temp = temp.next;
      }
      return A;
    }
}
