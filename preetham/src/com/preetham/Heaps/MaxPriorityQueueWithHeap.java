package com.preetham.Heaps;

public class MaxPriorityQueueWithHeap {
    private Heap heap = new Heap(10);

    public void enqueue(int item){
        heap.insert(item);
    }

    public int dequeue(){
        return heap.remove();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }
}

//priorityQueues using array - using heap
//inserstion            O(1) - O(logn)
//deletion              O(n) - O(logn)