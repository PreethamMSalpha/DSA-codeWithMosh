package com.preetham.Heaps;

import java.util.Arrays;

public  class HeapSort {
    public static void Sort(int[] numbers) {
        var heap = new Heap(numbers.length);

        for (var num : numbers)
            heap.insert(num);
        for (int i = numbers.length - 1; i >= 0; i--) {
            numbers[i] = heap.remove();
        }
        System.out.println(Arrays.toString(numbers));
    }


}
