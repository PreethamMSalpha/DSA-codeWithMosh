package com.preetham.Heaps;

public class MinPriorityQueueWithHeap {
    private MinHeap minHeap = new MinHeap();

    public void enqueue(int priority, String value) {
        minHeap.insert(priority, value);
    }

    public String dequeue() {
        return minHeap.remove();
    }

    public boolean isEmpty() {
        return minHeap.isEmpty();
    }
}
