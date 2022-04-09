package com.preetham.Stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class StackUsingArray {
    private int[] stack;
    private int index;

    public StackUsingArray(int size) {
        stack = new int[size];
    }

    public void push(int item) {
        if (index == stack.length)
            throw new StackOverflowError();

        stack[index++] = item;
    }

    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();
        //10 20 30 0 0
        //         *

        int top = stack[index - 1];
        stack[--index] = 0;
        return top;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return stack[index - 1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public void printStack() {
        System.out.println(Arrays.toString(stack));
    }

    @Override
    public String toString() {
        var res = Arrays.copyOfRange(stack, 0, index);
        return Arrays.toString(res);
    }
}
