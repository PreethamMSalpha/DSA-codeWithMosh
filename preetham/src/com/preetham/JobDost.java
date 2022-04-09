package com.preetham;

import java.util.*;

public class JobDost {
    public static void main(String[] args) {
        int a  = 1;
        int b=2;
        swap(a,b);
        System.out.println(a+","+b);
//        evenNumbers(4, "WLLW");

//        var res = countFactors(4575); //66
//        var res = countFactors(522); //22
//        var res = countFactors(6); //1
//        System.out.println(res);
//        int A[] = {1,2,3,4,5,6};
//        eatingFood(6,A,4);
//        int[] A = {1,3,5,2,8};
//        maximumSum(5, A);
//        spaceSeparatedElements("78641");
//        int[] A = {3,1,2,4,5};
//        var res = countInd(5, A);
//        System.out.println(res);
    }

    //your curr score >= Friend's curr score -> you serve the round
    //WLLW
    //[1,0], [1,1], [1,2], [1,3]
    public static void evenNumbers(int N, String S) {
        int myScore = 0;
        int friendScore = 0;
        int swapCount = 0;
        int temp;

        for (char ch : S.toCharArray()) {
            if (myScore < friendScore){
//                swap(myScore, friendScore);
                temp = myScore;
                myScore = friendScore;
                friendScore = temp;
                swapCount ++;
            }
            if (myScore >= friendScore) {
                if (ch == 'W') {
                    myScore++;
                } else if (ch == 'L') {
                    friendScore++;
                }
            }
        }

        if (swapCount % 2 != 0){
//            swap(myScore, friendScore);
            temp = myScore;
            myScore = friendScore;
            friendScore = temp;
        }

        System.out.println(myScore+ " "+friendScore);
    }

    public static void swap(int a, int b) {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }

    //print aboveT belowT
    public static void eatingFood(int N, int[] A, int T) {
        int moreTime = 0;
        int atmostTime = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] > T) {
                moreTime += 1;
            } else {
                atmostTime += 1;
            }
        }

        System.out.println(moreTime + " " + atmostTime);
    }

    public static int countFactors(int N) {
        int result = 0;

        for (int i = 1; i < N; i++) {
            int x = countDivisors(i);

            if (x == 3) {
                result += 1;
            }
        }

        return result;
    }

    public static int countDivisors(int n) {
        int totalDivisors = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                totalDivisors += 1;
            }
        }

        return totalDivisors;
    }

    public static void maximumSum(int N, int[] A) {
        Arrays.sort(A);

        int res = A[N - 1] + A[N - 2];

        System.out.println(res);
    }

    public static void spaceSeparatedElements(String s) {
        for (char c : s.toCharArray()) {
            System.out.println(c);
        }
    }

    static int countInd(int N, int A[]) {
        int count = 0;
        int[] prefixSum = new int[N];
        int[] suffixSum = new int[N];

        for (int i = 1; i < N; ++i) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        for (int j = N - 2; j >= 0; j--) {
            suffixSum[j] = suffixSum[j + 1] + A[j];
        }

        for (int k = 0; k < N; k++) {
            if (prefixSum[k] >= suffixSum[k]) {
                count++;
            }
        }

        return count;

    }

}
