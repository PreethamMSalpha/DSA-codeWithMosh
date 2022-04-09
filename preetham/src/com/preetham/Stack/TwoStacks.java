package com.preetham.Stack;

import java.util.Arrays;

public class TwoStacks {
    private int[] array;
    private int top1;
    private int top2;

    public TwoStacks(int size) {
        if (size <= 0)
            throw new IllegalArgumentException("capacity must be 1 or greater.");

        array = new int[size];
        top1 = -1;
        top2 = size;
    }

    public void push1(int item) {
        if (isFull1())
            throw new IllegalStateException();

        array[++top1] = item;
    }

    public void push2(int item) {
        if (isFull2())
            throw new IllegalStateException();

        array[--top2] = item;
    }

    public int pop1() {
        if (isEmpty1())
            throw new IllegalStateException();

        return array[top1--];
    }

    public int pop2() {
        if (isEmpty2())
            throw new IllegalStateException();

        return array[top2++];
    }

    public boolean isEmpty1() {
        return top1 == -1;
    }

    public boolean isEmpty2() {
        return top2 == array.length;
    }

    //10 20 30 40 50
    //   t1 t2

    public boolean isFull1() {
        return top2 == top1 + 1;
    }

    public boolean isFull2(){
        return top1 == top2 - 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
