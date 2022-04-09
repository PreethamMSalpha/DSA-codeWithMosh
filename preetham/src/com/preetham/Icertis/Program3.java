package com.preetham.Icertis;

import java.util.ArrayList;

public class Program3 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int res = maximum_xor_sum(A);
//        System.out.println(res);

        ArrayList<Integer> path = new ArrayList<>();
        getSubsequences(A, 0, path);
    }

    private static int maximum_xor_sum(int[] nums) {
        int len = nums.length - 1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (len - i < len)
                    max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        return max;
    }

    public static void getSubsequences(int[] arr, int index, ArrayList<Integer> path) {

        if (index == arr.length) {
            if (path.size() > 0) {
//                System.out.println(path);

                int[] array = path.stream().mapToInt(i -> i).toArray();
                int result = maximum_xor_sum(array);
                System.out.println(path + "->" +result);
            }
        } else {
            getSubsequences(arr, index + 1, path);
            path.add(arr[index]);
            getSubsequences(arr, index + 1, path);
            path.remove(path.size() - 1);
        }
        return;
    }
}
