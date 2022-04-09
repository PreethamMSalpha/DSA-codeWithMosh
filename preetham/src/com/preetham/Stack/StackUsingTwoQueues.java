package com.preetham.Stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackUsingTwoQueues {
    // S -> [1,2,3,4,5] 5-top
    //Q1 -> [1,2,3,4,5] [5]
    //Q2 -> []          [1,2,3,4]
    //swap
    //Q1 -> [1,2,3,4] [4]
    //Q2 -> []        [1,2,3]
    Queue<Integer> q1 = new ArrayDeque<>(); //used for adding items
    Queue<Integer> q2 = new ArrayDeque<>();
    private int top;

    public void push(int item) {
        q1.add(item);
        top = item;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        var temp = q1.remove();

        swapQueues();

        return temp;
    }

    private void swapQueues() {
        var temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }


    public int size() {
        return q1.size();
    }

    @Override
    public String toString(){
        return q1.toString();
    }
}
