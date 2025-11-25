package scaler.linkedlist;

public class CopyList {

    /**
     * You are given a linked list A
     * Each node in the linked list contains two pointers: a next pointer and a random pointer
     * The next pointer points to the next node in the list
     * The random pointer can point to any node in the list, or it can be NULL
     * Your task is to create a deep copy of the linked list A
     * The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
     * You should create a new linked list B, where each node in B has the same value as the corresponding node in A
     * The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)
     *
     * Example Input
     * Given list
     *    1 -> 2 -> 3
     * with random pointers going from
     *   1 -> 3
     *   2 -> 1
     *   3 -> 1
     *
     * Example Output
     *    1 -> 2 -> 3
     * with random pointers going from
     *   1 -> 3
     *   2 -> 1
     *   3 -> 1
     */


    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;

        RandomListNode temp = head;
        // Link the current LL with new LL
        while (temp != null) {
            RandomListNode newNode = new RandomListNode(temp.label);
            newNode.next = temp.next;
            temp.next = newNode;

            temp = temp.next.next;
        }

        // Update the random value to the new LL
        temp = head;
        while (temp.next != null) {
            RandomListNode newNode = temp.next;
            if (temp.random != null) {
                newNode.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        // Delink the new LL from old LL
        temp = head;
        RandomListNode newTemp = temp.next;
        RandomListNode newHead = temp.next;
        while (temp != null && newTemp != null) {
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
            if (newTemp.next != null) {
                newTemp.next = newTemp.next.next;
            }
            temp = temp.next;
            newTemp = newTemp.next;
        }
        return newHead;
    }
}
