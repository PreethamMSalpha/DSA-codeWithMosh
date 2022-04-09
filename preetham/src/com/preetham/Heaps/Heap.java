package com.preetham.Heaps;

//max heap
public class Heap {
    private int[] items;
    private int size;

    public Heap(int size) {
        this.items = new int[size];
    }

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException();

        items[size++] = value;

        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var root = items[0];
        items[0] = items[--size];

        bubbleDown();

        return root;
    }

    /*
    * bubbleDown
    * check -> index <= size and isValidParent
    * if not -> swap(index, largerChildIndex) and set index to largerChildIndex
    */

    private void bubbleDown() {
        var index = 0;
        while (index <= size && !isValidParent(index)) {
            //bubble down
            var largerChildIndex = getLargerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    /*
    * bubbleUp()
    * loop -> index > 0 and item[index] > items[parentIndex(index)]
    *           swap(index, parentIndex)
    *           index = parentIndex

    */
    private void bubbleUp() {
        var index = size - 1; //coz we incremented in prev step
        while (index > 0 && items[index] > items[parentIndex(index)]) { //index > 0 coz if we use >=0 in parent(index) it goes negative
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private int getLargerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;

        if (!hasRightChild(index))
            return items[index] >= leftChild(index);

        return items[index] >= leftChild(index) && items[index] >= rightChild(index);
    }


    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int max() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[0];
    }
}
