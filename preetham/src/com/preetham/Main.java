package com.preetham;


public class Main {


    public static void main(String[] args) {
//        int res = add(3,4);
//        System.out.println(res);

        var res = GCD.getGCD(4,5);
        System.out.println(res);

    }

    static int add(int a, int b){
        while(a>0){
            a--;
            b++;
        }
        return b;
    }

}


