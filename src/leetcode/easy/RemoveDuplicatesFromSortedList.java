package leetcode.easy;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode node4 = new ListNode(3);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode head = new ListNode(1, node1);
        deleteDuplicates(head);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;
        ListNode nextNode = currentNode.next;

        while (nextNode != null) {
            if (currentNode.val == nextNode.val) {
                nextNode = nextNode.next;
                continue;
            }
            currentNode.next = nextNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
        }
        currentNode.next = null;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
