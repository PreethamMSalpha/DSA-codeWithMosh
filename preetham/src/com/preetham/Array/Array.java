package com.preetham.Array;

public class Array {
    private int[] array;
    private int count = 0;

    public Array(int n) {
        array = new int[n];
    }

    public void insert(int num) {
        if (count == array.length) {
            int[] newArray = new int[array.length * 2];

            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }

            array = newArray;

        }
        array[count++] = num;

    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    public int indexOf(int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
//                System.out.print("element found in pos: ");
                return i;
            }
        }
//        System.out.print("element not found ");
        return -1;
    }

    public void print() {
        System.out.println("array size is : " + array.length);
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public int max() {
        int max = array[0];
        for (int i = 0; i < count; i++) {
            if (array[i] > max)
                max = array[i];
        }
        return max;
    }

    public void reverse() {
        for (int i = count - 1; i >= 0; i--)
            System.out.print(array[i] + " ");
    }

    public void insertAt(int item, int index) {

        if (count == array.length) {
            int[] newArray = new int[array.length * 2];

            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }

            array = newArray;

        }

        if (index < 0 || index > array.length)
            throw new IllegalArgumentException();

        for (int i = count - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = item;
        count++;

    }

    public Array intersect(Array otherArray) {
        var intersection = new Array(count);

        for (int item : array) {
            if (otherArray.indexOf(item) >= 0){
                intersection.insert(item);
            }
        }

        return intersection;
    }
}
