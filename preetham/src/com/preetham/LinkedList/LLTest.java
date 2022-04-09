package com.preetham.LinkedList;

import java.util.NoSuchElementException;

public class LLTest {
    //node -> next, value
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addLast(int value) {
        var node = new Node(value);

        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public void addFirst(int value) {
        var node = new Node(value);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }

        size++;
    }

    public int indexOf(int value) {
        var current = first;
        int index = 0;

        while (current != null) {
            if (current.value == value)
                return index;

            current = current.next;
            index++;

        }

        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) > 1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            var temp = getPreviousNode(last);
            last = temp;
            last.next = null;
        }

        size--;
    }

    private Node getPreviousNode(Node node) {
        var current = first;

        while (current != null) {
            if (current.next == node)
                return current;
            current = current.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        int index = 0;

        var current = first;

        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse() {
        //f            l
        //10 -> 20 -> 30
        //p     c      n
        //l            f
        var prev = first;
        var current = first.next;

        while (current != null) {
            var next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = prev;

    }

    public int getKthNodeFromEnd(int k) {
        //10 20 30 40 50
        //
        //k-1 50
        //k-2 40
        //k-3 30 => k-1
        var a = first;
        var b = first;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;
        }

        while (b != last) {
//            if (b.next == null) return a.value;
            a = a.next;
            b = b.next;
        }

        return a.value;
    }

    public void printMiddle() {
        //1 2 3 4 5 6 7 8
        //4,5
        var a = first;
        var b = first;

        while (b != last && b.next != last) {
            b = b.next.next;
            a = a.next;
        }

        if (b == last) {
            System.out.println("mid element is : " + a.value);
        } else {
            System.out.println("mid elements are: " + a.value + "," + a.next.value);
        }
    }

    public boolean hasCycle() {
        var a = first;
        var b = first;

        while (b != null && b.next != null) {
            a = a.next;
            b = b.next.next;
            if (a == b) return true;
        }

        return false;
    }

    public void createCycle(){
        last.next = first.next.next;
    }

    public static LLTest createWithLoop() {
        var list = new LLTest();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        // Get a reference to 30
        var node = list.last;

        list.addLast(40);
        list.addLast(50);

        // Create the loop
        list.last.next = node;

        return list;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
