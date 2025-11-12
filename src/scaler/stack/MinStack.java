package scaler.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class MinStack {

    /**
     *Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
     * push(x) -- Push element x onto stack.
     * pop() -- Removes the element on top of the stack.
     * top() -- Get the top element.
     * getMin() -- Retrieve the minimum element in the stack.
     * NOTE:
     * All the operations have to be constant time operations.
     * getMin() should return -1 if the stack is empty.
     * pop() should return nothing if the stack is empty.
     * top() should return -1 if the stack is empty.
     *
     * Example Input
     *
     * Input 1:
     * push(1)
     * push(2)
     * push(-2)
     * getMin()
     * pop()
     * getMin()
     * top()
     *
     * Input 2:
     * getMin()
     * pop()
     * top()
     *
     * Example Output
     *
     * Output 1:
     *  -2 1 2
     * Output 2:
     *  -1 -1
     */

    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()) {
            minStack.push(x);
        } else if (x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public static void pop() {
        if(stack.size() == 0)
            return;
        int num = stack.pop();
        if (num == minStack.peek())
            minStack.pop();
    }

    public static int top() {
        if(stack.size() == 0)
            return -1;
        return stack.peek();
    }

    public static int getMin() {
        if(minStack.size() == 0)
            return -1;
        return minStack.peek();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(-2);
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
        System.out.println(top());

        /*System.out.println(getMin());
        pop();
        System.out.println(top());*/
    }
}
