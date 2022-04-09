package com.preetham.Heaps;

//transforming arrays into heap in place - heapify

//mathematically we can prove, in a perfect BST half of the nodes are in last level
//whole purpose of heapify is that every parent >= its children. So we don't have to iterate over leaf nodes
//which happens to be half of the nodes in the tree. To optimize the algorithm we only need to heapify parent nodes
//so lastParentIndex = (no_of_nodes/2)-1;
//if we start from deepest parent nodes we will have fewer recursions. As we go up in the tree lot of nodes are in right position
//so we have fewer recursion

public class MaxHeap {
    public static void heapify(int[] array) {
        var lastParentIndex = array.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--)
            heapify(array, i);
    }

    private static void heapify(int[] array, int index) {
        var largerIndex = index;

        var leftIndex = index * 2 + 1;
        if (leftIndex < array.length && array[leftIndex] > array[largerIndex])
            largerIndex = leftIndex;

        var rightIndex = index * 2 + 2;
        if (rightIndex < array.length && array[rightIndex] > array[largerIndex])
            largerIndex = rightIndex;

        if (index == largerIndex)
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap(int[] array, int first, int second) {
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length)
            throw new IllegalArgumentException();

        var heap = new Heap(array.length);

        for (var num : array)
            heap.insert(num);

        for (int i = 0; i < k - 1; i++) {
            heap.remove();
        }

        return heap.max();
    }

    public static boolean isMaxHeap(int[] array) {
        return isMaxHeap(array, 0);
    }

    private static boolean isMaxHeap(int[] array, int index) {
//        var lastParentIndex = (array.length - 2) / 2 ;
        var lastParentIndex = array.length / 2 - 1;


        if (index > lastParentIndex) //here we are checking for leaf node > lastParentIndex
            return true; //becomes true when index comes to leaf node

        var leftChildIndex = index * 2 + 1;
        var rightChildIndex = index * 2 + 2;

        if (leftChildIndex >= array.length || rightChildIndex >= array.length) //checking for indexOutOfBounds
            return true; //checking for children exist


        var isValidParent = array[index] >= array[leftChildIndex] && array[index] >= array[rightChildIndex];

        return isValidParent && isMaxHeap(array, leftChildIndex) && isMaxHeap(array, rightChildIndex);
    }


}
