package com.preetham;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter first number ");
//        int n1 = scanner.nextInt();
//        System.out.println("enter second number ");
//        int n2 = scanner.nextInt();
//
//        int res = findMax(n1, n2);
//        // int res = findMax(30,12);
//        System.out.println(res);
        int[] weights = {1,2,3,6,7,7};
//        int[] weights = {2,4,5};
        int res = lastStoneWeight(6, weights);
        System.out.println(res);
    }

    public static int lastStoneWeight(int count, int[] weights){
        Arrays.sort((weights));

        int last = count-1;
        int prev = last - 1;

        while(prev >= 0){
            if(weights[last] == weights[prev]){
                last = last - 2;
                prev = prev - 2;
            }else if(weights[last] > weights[prev]){
                weights[prev] = weights[last] - weights[prev];

                last = last - 1;
                prev = prev - 1;

            }else if(weights[last] < weights[prev]){
                Arrays.sort((weights));
                last = last - 1;
                prev = prev - 1;
            }
            else{

            }
        }

        return weights[0];
    }

    public static int findMax(int x, int y) {

        int maxValue = Integer.max(x, y);

        while (true) {
            if ((x % maxValue) == 0 && (GCD(maxValue, y) == 1)) {
                return maxValue;
            }
            maxValue -= 1;
        }
    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
}
