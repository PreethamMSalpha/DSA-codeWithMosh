package com.preetham.Queue;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> eq = new Stack<>();
    private Stack<Integer> dq = new Stack<>();

    public void enqueue(int item) {
        eq.push(item);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        if (dq.isEmpty())
            while (!eq.isEmpty())
                dq.push(eq.pop());

        return dq.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        if (dq.isEmpty())
            while (!eq.isEmpty())
                dq.push(eq.pop());

        return dq.peek();
    }

    public boolean isEmpty() {
        return eq.isEmpty() && dq.isEmpty();
    }

//    public void printStack() {
//        while (!dq.isEmpty())
//            eq.push(dq.pop());
//
//        System.out.println(eq);
//    }
}
