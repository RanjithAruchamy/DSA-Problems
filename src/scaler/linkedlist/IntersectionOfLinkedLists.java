package scaler.linkedlist;

public class IntersectionOfLinkedLists {

    /**
     * Write a program to find the node at which the intersection of two singly linked lists, A and B, begins. For example, the following two linked lists:
     *
     * A:          a1 → a2
     *                    ↘
     *                      c1 → c2 → c3
     *                    ↗
     * B:     b1 → b2 → b3
     * NOTE:
     *
     * If the two linked lists have no intersection at all, return null.
     * The linked lists must retain their original structure after the function returns.
     * You may assume there are no cycles anywhere in the entire linked structure.
     * Your code should preferably run in O(n) time and use only O(1) memory.
     * The custom input to be given is different than the one explained in the examples. Please be careful.
     *
     * Input 1:
     *  A = [1, 2, 3, 4, 5]
     *  B = [6, 3, 4, 5]
     *
     *  Input 2:
     *  A = [1, 2, 3]
     *  B = [4, 5]
     *
     *  Output 1:
     *  [3, 4, 5]
     * Output 2:
     *  []
     */

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        if (A == null || B == null) return null;

        int aSize = 0, bSize = 0;
        ListNode tempA = A;
        while (tempA != null) {
            aSize++;
            tempA = tempA.next;
        }

        ListNode tempB = B;
        while (tempB != null) {
            bSize++;
            tempB = tempB.next;
        }

        ListNode result = null;
        if (aSize > bSize) {
            int diff = aSize - bSize;
            tempA = A;
            int index = 1;

            while (tempA != null && index <= diff) {
                tempA = tempA.next;
                index++;
            }

            tempB = B;
            while (tempA != null && tempB != null) {
                if (tempA == tempB) {
                    result = tempA;
                    break;
                }
                tempA = tempA.next;
                tempB = tempB.next;
            }
        } else {
            int diff = bSize - aSize;
            tempB = B;
            int index = 1;

            while (tempB != null && index <= diff) {
                tempB = tempB.next;
                index++;
            }

            tempA = A;
            while (tempA != null && tempB != null) {
                if (tempA == tempB) {
                    result = tempA;
                    break;
                }
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }

        return result;
    }

}
