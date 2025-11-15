package scaler.stack;

public class StackUsingLinkedList {
    int size = 0;
    LinkedListNode head;
    public static class LinkedListNode {
        int data;
        LinkedListNode next;

        public LinkedListNode(int x) {
            this.data = x;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public LinkedListNode getNext() {
            return next;
        }

        public void setNext(LinkedListNode next) {
            this.next = next;
        }
    }

    public void push(int x) {
        LinkedListNode newNode = new LinkedListNode(x);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public int peek () {
        if (head == null) return -1;
        else return head.data;
    }

    public int pop () {
        if (head == null) return -1;
        else {
            int data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

    public int size() {
        return size;
    }
}
