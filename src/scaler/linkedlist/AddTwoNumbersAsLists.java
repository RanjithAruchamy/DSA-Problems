package scaler.linkedlist;

public class AddTwoNumbersAsLists {

    /**
     * You are given two linked lists, A and B, representing two non-negative numbers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return it as a linked list.
     *
     * Input 1:
     *  A = [2, 4, 3]
     *  B = [5, 6, 4]
     * Input 2:
     *  A = [9, 9]
     *  B = [1]
     *
     *  Output 1:
     *  [7, 0, 8]
     * Output 2:
     *  [0, 0, 1]
     */

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        if (A == null) return B;
        if (B == null) return A;

        ListNode head = new ListNode(0);
        ListNode temp = head;
        int carry = 0;
        while (A != null && B != null) {
            int sum = A.val + B.val + carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;

            A = A.next;
            B = B.next;
        }

        while (A != null) {
            int sum = A.val + carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;

            A = A.next;
        }

        while (B != null) {
            int sum = B.val + carry;
            carry = sum / 10;

            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;

            B = B.next;
        }

        while (carry != 0) {
            ListNode node = new ListNode(carry % 10);
            temp.next = node;
            carry = carry / 10;
        }

        return head.next;
    }
}
