package com.preetham.ALGORITHMS.SortingAlgorithms;

public class MergeSort {
    //divide the array into half
    //sort each half
    //merge the result
    public void sort(int[] array) {
        //base condition for recursion
        if (array.length < 2) //indicates 1 item or zero item -> coz array with single item is already sorted
            return;

        var middle = array.length / 2;

        int[] left = new int[middle];
        for (int i = 0; i < middle; i++)
            left[i] = array[i];

        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length; i++)
            right[i - middle] = array[i];

        sort(left);
        sort(right);

        merge(left, right, array);
    }

    public void merge(int[] left, int[] right, int[] result){
        int i=0, j=0, k=0;

        while (i < left.length && j<right.length){ //comparing two arrays
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length) //copying remaining left items to result -> happens when left array is larger than right
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }
}
