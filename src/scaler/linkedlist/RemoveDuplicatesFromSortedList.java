package scaler.linkedlist;

public class RemoveDuplicatesFromSortedList {

    /**
     * Given a sorted linked list, delete all duplicates such that each element appears only once.
     *
     * Input 1:
     *  1->1->2
     *
     *  Input 2:
     *  1->1->2->3->3
     *
     *  Output 1:
     *  1->2
     *
     *  Output 2:
     *  1->2->3
     */

  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

    public ListNode deleteDuplicates(ListNode A) {
      ListNode temp = A;

      while(temp != null && temp.next != null) {
          if (temp.val == temp.next.val) {
              temp.next = temp.next.next;
          }
          temp = temp.next;
      }
      return A;
    }
}
