package com.preetham;

public class PrimeNumbers {
    private int n;
    private int flag;

    public PrimeNumbers(int n) {
        this.n = n;
    }

    public void printPrimeNumbers() {
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1)
                continue;

            flag = 1;

            for (int j=2; j<= i/2; j++) {
                if (i % j == 0){
                    flag = 0;
                    break;
                }
            }

            if (flag == 1)
                System.out.print(i + " ");
        }
    }
}
