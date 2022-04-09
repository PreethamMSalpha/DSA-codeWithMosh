package com.preetham.Stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack();
    private Stack<Integer> minStack = new Stack();

    public void push(int item){
        stack.push(item);

        if (minStack.isEmpty())
            minStack.push(item);
        else if (item < minStack.peek())
            minStack.push(item);
    }

    public int pop(){
        if (stack.isEmpty())
            throw new IllegalStateException();

        var top = stack.pop();

        if (top == minStack.peek())
            return minStack.pop();

        return top;
    }

    public int min(){
        return minStack.peek();
    }
}
