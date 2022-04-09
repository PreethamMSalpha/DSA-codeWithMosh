package com.preetham.ALGORITHMS.SortingAlgorithms;

public class BubbleSort {
    public void sort(int[] numbers) {
        boolean isSorted;
        for (int i = 0; i < numbers.length; i++) {
            isSorted = true;
            for (int j = 1; j < numbers.length - i; j++) {
                if (numbers[j] < numbers[j - 1]) {
                    swap(numbers, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
    }

    public void swap(int[] array, int index1, int index2) {
        var temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}

/*
        int[] numbers = {8,1,4,2,7,9};
        System.out.println(Arrays.toString(numbers));
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
 */