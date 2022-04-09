package com.preetham.ALGORITHMS.SortingAlgorithms;

public class CountingSort {
    public void sort(int[] array, int max) {
        int[] counts = new int[max + 1]; //coz we are counting from zero
        for (var item : array)
            counts[item]++;

        int k = 0;
        for (int i = 0; i < counts.length; i++) { //O(n+k) => O(n) Linear
            for (int j = 0; j< counts[i]; j++) {
                array[k++] = i;
            }
        }
    }
}
