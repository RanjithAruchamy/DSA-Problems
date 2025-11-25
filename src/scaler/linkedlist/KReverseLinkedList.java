package scaler.linkedlist;

public class KReverseLinkedList {

    /**
     * Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.
     *
     * Input 1:
     *  A = [1, 2, 3, 4, 5, 6]
     *  B = 2
     *
     *  Input 2:
     *  A = [1, 2, 3, 4, 5, 6]
     *  B = 3
     *
     *  Output 1:
     *  [2, 1, 4, 3, 6, 5]
     *
     *  Output 2:
     *  [3, 2, 1, 6, 5, 4]
     */

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode reverseListRecursion(ListNode A, int B) {
        ListNode currNode = A;
        ListNode prevNode = null, nextNode = null;
        int count = 0;
        while (currNode != null && count < B) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            count++;
        }

        if (nextNode != null) {
            A.next = reverseListRecursion(nextNode, B);
        }

        return prevNode;
    }

    public static ListNode reverseList(ListNode A, int B) {
        if (A == null) return A;
        ListNode curr = A, newHead = null, prev = null;
        int iteration = 1;

        while (curr != null) {
            ListNode from = null, to = null;
            int index = 1;

            from = curr;
            while (curr != null) {
                if (index == B) {
                    to = curr;
                    curr = curr.next;
                    to.next = null;
                    break;
                }
                index++;
                curr = curr.next;
            }

            ListNode newNode = reverseLinkedList(from, to);

            if (prev != null) {

                if (newNode == null) {
                    prev.next = from;
                } else {
                    prev.next = newNode;
                }
            }

            if (iteration == 1) {
                newHead = newNode;
            }

            iteration++;
            prev = from;
        }


        return newHead;
    }

    private static ListNode reverseLinkedList(ListNode from, ListNode to) {
        ListNode prev = null;
        ListNode curr = from;

        while (curr != null && to != null && curr != to.next) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return to;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(reverseListRecursion(head, 3));
    }
}
