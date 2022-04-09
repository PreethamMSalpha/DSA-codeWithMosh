package com.preetham.ALGORITHMS.SortingAlgorithms;

public class InsertionSort {
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) { //when we read the 1st item we assume it is in correct order
            var current = array[i];
            var j = i - 1; //we start from prev item
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j]; //shifting item to the right with same value
                j--;
            }//after this loop all the items will be shifted to the right
            array[j+1] = current; //
        }
    }
}
