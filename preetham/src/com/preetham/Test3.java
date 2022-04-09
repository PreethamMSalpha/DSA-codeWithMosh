package com.preetham;

import java.util.HashMap;

public class Test3 {
    public static void main(String[] args) {
        var res = equation(4);
        System.out.println(res);
//        int[] A = {7,5,8,7,1,8,7,8};
//        var res = absoluteFrequency(8, 2, A);
//        System.out.println(res);
//        int[] A = {4,3,1,2,1};
//        int[] B = {0,2,4};
//        var res = purify(5,3,A, B);
//        System.out.println(res);
    }

    public static int getMinCost(int N, int X, int[] A, int[] B){

        return 0;
    }

    public static int equation(int N){
        int count = 0;
        int maxLimit = 10000;
        for(float i=1; i<maxLimit; i++){
            for (float j=1; j<maxLimit; j++){
                float res = (i*j)/(i+j);
                if (N == res){
                    System.out.println(i+","+j);
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static int absoluteFrequency(int N, int K, int[] A){
        int minCount = 0;
        int maxCount = 0;
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        for(int i=0; i<A.length; i++){
            if(h.containsKey(A[i])){
                h.put(A[i], h.get(A[i]) + 1);
            } else {
                h.put(A[i], 1);
            }
        }
        System.out.println(h);

        for (int res: h.values()){
            if (res > K){
                maxCount += 1;
            }else{
                minCount += 1;
            }
        }

        int result = Math.abs(maxCount - minCount);

        return result;
    }

    public static int purify(int N, int M, int[] A, int[] B){

        int sum = 0;
        int bCount = 0;

        for(int i=0; i<N; i++){
            if(bCount < M){
                int Bindex = B[bCount];
                A[Bindex] = 0;
                bCount++;
            }
        }

        for(int x: A){
            sum = sum+x;
        }

        return sum;
    }
}
