package com.preetham.Queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count;

    public PriorityQueue(int size) {
        items = new int[size];
    }

    //[1,3,4,5] [2]
    //
    public void add(int item) {
        if (isFull())
            throw new IllegalStateException();

        int i;
        for (i = count - 1; i >= 0; i--) {
            if (item < items[i])
                items[i + 1] = items[i];
            else
                break;
        }
        items[i + 1] = item;
        count++;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull(){
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
