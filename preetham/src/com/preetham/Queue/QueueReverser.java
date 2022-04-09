package com.preetham.Queue;

import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    private Stack stack = new Stack();

    public QueueReverser(Queue queue) {
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void reverse(Queue<Integer> queue, int k) {
        Stack<Integer> stackRev = new Stack<>();

        System.out.println(queue);

        for (int i = 0; i < k; i++)
            stackRev.push(queue.remove());

        while (!stackRev.isEmpty())
            queue.add(stackRev.pop());

        for (int i = 0; i < queue.size() - k; i++)
            queue.add(queue.remove());

        System.out.println(queue);

    }
}
