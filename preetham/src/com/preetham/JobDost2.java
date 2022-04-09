package com.preetham;

import java.util.ArrayList;
import java.util.Arrays;

public class JobDost2 {
    public static void main(String[] args) {
        int[] A = {1, 2, 0, 0, 3, 7, 3, 0, 5};
        moveZeroes(A);

//        int[] A = {1,2,3,4};
//        int[] A = {4,1,3,7,6,8,5,2,10,9};
//        var res = altTab(10,7,A);
//        var res = altTab(4,3,A);
//        System.out.println(Arrays.toString(res));
//        var res = charRotation("abq", "cba");
//        System.out.println(res);
//        int[] A = {1,3,18,20};
//        var res = minDist(4, A);
//        System.out.println(res);

//        int[] A = {1,9,3,5};
//        var res = billVal(4, 4, A);
//        System.out.println(res);
//        var res = sumOfSeries(12);
//        System.out.println(res);
//        var res = uniqueDivisors(16);
//        System.out.println(res);
//        int[] A = {1,3,18,20};
//        minDist(4, A);
    }

    public static void moveZeroes(int[] nums) {
        int lastItemIndex = nums.length - 1;

        for(int i=0, j=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));

//        for (int i = 0; i < nums.length; i++) {
//            if (i == lastItemIndex) {
//                System.out.println(i + "->" + Arrays.toString(nums));
//                break;
//            }
//
//            if (nums[i] == 0) {
//                for (int j = i; j < lastItemIndex; j++) {
//                    nums[j] = nums[j + 1];
//                }
//
//                nums[lastItemIndex--] = 0;
//                i--;
//            }
//        }

//         System.out.println(Arrays.toString(nums));
    }

    public static int[] altTab(int N, int K, int[] A) {
        int x = A[K - 1];

        for (int i = K - 1; i > 0; i--) {
            A[i] = A[i - 1];
        }

        A[0] = x;
        return A;
    }


    public static int charRotation(String ip, String op) {
        ip.toLowerCase();
        op.toLowerCase();

        int count = 0;
        int zLetterIndex = 26;

        ArrayList<Character> a1 = new ArrayList<>();
        ArrayList<Character> a2 = new ArrayList<>();

        for (char ch : ip.toCharArray()) {
            a1.add(ch);
        }

        for (char ch : op.toCharArray()) {
            a2.add(ch);
        }

        for (int i = 0; i < a1.size(); i++) {
            int srcIndex = a1.get(i) - 'a' + 1;
            int destIndex = a2.get(i) - 'a' + 1;

            int ans1 = Math.abs(destIndex - srcIndex);
            int ans2 = zLetterIndex - ans1;

            int totalMinCount = Math.min(ans1, ans2);
            count += totalMinCount;
        }

        return count;

    }

    public static int minDist(int N, int[] X) {
        int index = 0;

        Arrays.sort(X);
        int min = X[0];
        int max = X[N - 1];
        int[] arr = new int[max];

        for (int i = min; i <= max; i++) {
            int value = 0;
            for (int j = 0; j < N; j++) {
                value += Math.abs(X[j] - i);
            }
            arr[index++] = value;
        }

        Arrays.sort(arr);

        return arr[0];

    }

    public static int billVal(int N, int K, int[] A) {
        int bill = 0;
        Arrays.sort(A);

        for (int i = N - 1; i > 0; i--) {
            if (A[i] > A[i - 1]) {
                for (int j = 0; j < 2; j++) {
                    if (K > 0) {
                        int ele = A[i];
                        /*if (ele % 2 != 0){
                            A[i] = Math.round(ele / 2);
                        }else{*/
                        A[i] = ele / 2;
//                        }
                        K--;
                    }
                }
            }
        }

        for (int x : A) {
            bill += x;
        }

        return bill;
    }


    public static int sumOfSeries(int N) {
//        float expression = (13 * N) / 27;

        double num = Math.pow(3, N) - 1;
        double deno = 2 * Math.pow(3, N);
        double res = (num / deno) * 10;
        return (int) Math.ceil(res);
//        System.out.println(res);
//        return (int) Math.floor(res);
    }


    public static int uniqueDivisors(int N) {
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count += 1;
            }
        }

        return count;
    }


}
