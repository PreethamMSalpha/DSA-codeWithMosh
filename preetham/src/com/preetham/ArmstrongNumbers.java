package com.preetham;

import java.util.Scanner;

public class ArmstrongNumbers {
    public static void main(String[] args) {

        int n, c = 0, x, y, z, s = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = n;
        z = n;
        while (x > 0) {
            x = x / 10;
            c++;
        }
        if (c == 3) {
            while (n > 0) {
                y = n % 10;
                s = (int) (s + Math.pow(y, c));
                n = n / 10;
            }
            if (s == z) {
                System.out.println("ARMSTRONG");
            } else {
                System.out.println("NOT ARMSTRONG");
            }

        } else {
            System.out.println("INVALID_INPUT");
        }

    }
}
