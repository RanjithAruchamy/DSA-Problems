package scaler.queue;

import java.util.Stack;

public class QueueUsingStacks {

    /**
     *Implement a First In First Out (FIFO) queue using stacks only.
     *
     * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
     *
     * Implement the UserQueue class:
     *
     * void push(int X) : Pushes element X to the back of the queue.
     * int pop() : Removes the element from the front of the queue and returns it.
     * int peek() : Returns the element at the front of the queue.
     * boolean empty() : Returns true if the queue is empty, false otherwise.
     * NOTES:
     *
     * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
     * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
     *
     * Input 1:
     *
     *  1) UserQueue()
     *  2) push(20)
     *  3) empty()
     *  4) peek()
     *  5) pop()
     *  6) empty()
     *  7) push(30)
     *  8) peek()
     *  9) push(40)
     *  10) peek()
     * Input 2:
     *
     *  1) UserQueue()
     *  2) push(10)
     *  3) push(20)
     *  4) push(30)
     *  5) pop()
     *  6) pop()
     *
     *  Output 1:
     *
     *  false
     *  20
     *  20
     *  true
     *  30
     *  30
     * Output 2:
     *
     *  10
     *  20
     */

    static class UserQueue {
        static Stack<Integer> stack1;
        static Stack<Integer> stack2;
        static int size = 0;
        /** Initialize your data structure here. */
        UserQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /** Push element X to the back of queue. */
        static void push(int X) {
            stack1.push(X);
            size++;
        }

        /** Removes the element from in front of queue and returns that element. */
        static int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    int element = stack1.pop();
                    stack2.push(element);
                }
            }
            size--;
            return stack2.pop();
        }

        /** Get the front element of the queue. */
        static int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    int element = stack1.pop();
                    stack2.push(element);
                }
                return stack2.peek();
            } else {
                return stack2.peek();
            }
        }

        /** Returns whether the queue is empty. */
        static boolean empty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {
        new UserQueue();
        UserQueue.push(20);
        System.out.println(UserQueue.empty());
        System.out.println(UserQueue.peek());
        System.out.println(UserQueue.pop());
        System.out.println(UserQueue.empty());
        UserQueue.push(30);
        System.out.println(UserQueue.peek());
        UserQueue.push(40);
        System.out.println(UserQueue.peek());
    }
}
