package com.preetham;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int N = 5;
        int[] transaction = {1, 2, 3, 4, 5};
        float[] acc = {0.3F, 0.8F, 0.6F, 0.5F, 0.5F};
        int res = result(N, transaction, acc);
        System.out.println(res);
    }

    public static int result(int N, int[] transaction, float[] accuracy) {
        float min = (float) 0.5;

        Map<Integer, Float> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(transaction[i], accuracy[i]);
        }

        int[] A = new int[1];

        float x = 1;
        for (Map.Entry<Integer, Float> unit : map.entrySet()) {
            if (unit.getValue() >= min) {
                System.out.println(unit);
                if (unit.getValue() < x) {
                    x = unit.getValue();
                    A[0] = unit.getKey();
                }
            }

        }

        return A[0];
    }
}
