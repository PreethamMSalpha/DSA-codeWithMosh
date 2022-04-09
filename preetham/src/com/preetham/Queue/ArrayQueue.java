package com.preetham.Queue;

import java.util.Arrays;

public class ArrayQueue {
    private int front;
    private int rear;
    private int count;
    private int[] items;

    public ArrayQueue(int size) {
        items = new int[size];
    }


    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException("Queue is full");

        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException("No elements to remove");

        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("No elements to remove");

        return items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public void printPointer() {
        System.out.println("front -> " + front);
        System.out.println("rear -> " + rear);
        System.out.println("count -> " + count);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
