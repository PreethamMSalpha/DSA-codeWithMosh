package com.preetham;

import java.util.Scanner;

public class SumOfDigits {
    private static int number, digit, sum;

    public static int sum(){
        System.out.print("Enter number here: ");
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();

        while (number > 0){
            digit = number % 10;
            sum = sum + digit;
            number = number / 10;
        }

        System.out.println("the sum of digits : "+sum);
        return sum;
    }
}

/*
        var res = SumOfDigits.sum();
        Map<Integer, Character> map = new HashMap<>();
        int count = 1;
        var alphabets = "abcdefghijklmnopqrstuvwxyz";
        for (var ch: alphabets.toCharArray())
            map.put(count++, ch);
        System.out.println(map.get(res));
*/