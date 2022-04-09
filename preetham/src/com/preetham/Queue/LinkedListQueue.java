package com.preetham.Queue;

import java.util.ArrayList;
import java.util.List;

public class LinkedListQueue {
    private class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public void enqueue(int item) {
        var node = new Node(item);
        if (isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException();

        int value;
        if (head == tail) {
            value = head.value;
            head = tail = null;
        } else {
            value = head.value;
            var second = head.next;
            head.next = null;
            head = second;
        }
        count--;
        return value;
    }

    public int peek(){
        return head.value;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString(){
        ArrayList<Integer> list = new ArrayList<>();

        var current = head;
        while(current != null){
            list.add(current.value);
            current = current.next;
        }

        return list.toString();
    }
}
