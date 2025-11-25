package scaler.linkedlist;

import java.util.List;

public class InsertInLinkedList {

    /**
     * You are given A which is the head of a linked list. Also given is the value B and position C.
     * Complete the function that should insert a new node with the said value at the given position.
     *
     * Notes:
     * In case the position is more than length of linked list, simply insert the new node at the tail only.
     * In case the pos is 0, simply insert the new node at head only.
     * Follow 0-based indexing for the node numbering.
     *
     * Input 1:
     * A = 1 -> 2
     * B = 3
     * C = 0
     *
     * Input 2:
     * A = 1 -> 2
     * B = 3
     * C = 1
     *
     * Output 1:
     * 3 -> 1 -> 2
     *
     * Output 2:
     * 1 -> 3 -> 2
     */

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode solve(ListNode A, int B, int C) {
        if (C == 0 || A == null) {
            ListNode newNode = new ListNode(B);
            newNode.next = A;
            return newNode;
        }

        ListNode curr = A;
        int index = 0;
        while (C > index) {
            if (C - 1 == index) {
                ListNode newNode = new ListNode(B);
                newNode.next = curr.next;
                curr.next = newNode;
            }
            if (curr.next == null) {
                ListNode newNode = new ListNode(B);
                curr.next = newNode;
                break;
            }
            index++;
            curr = curr.next;
        }
        return A;
    }
}
