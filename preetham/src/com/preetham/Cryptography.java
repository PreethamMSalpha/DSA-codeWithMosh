package com.preetham;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cryptography {
    public static int decoding(String s) {
        if (s.length() == 0 || s.charAt(0) == 0)
            return 0;

        if (s.length() == 1)
            return 1;

        int count1 = 1, count2 = 1;
        for (int i = 1; i < s.length(); i++) {
            int singleDigit = s.charAt(i) - '0';
            int twoDigit = (s.charAt(i - 1) - '0') * 10 + singleDigit;
            int count = 0;
            if (singleDigit > 0) count += count2; //single count has high priority
            if (twoDigit >= 10 && twoDigit <= 26) count += count1;
            //right shift everything by 1
            count1 = count2; //count1 -> prev to prev
            count2 = count; //count2 -> prev soln
        }
        return count2;
    }

}

/*
Cryptography

The use of codes and ciphers to protect secrets, began thousands of years ago
and today we will create a algorithm to decrypt some encrypted messages.

You have a mapping of alphabets with a number

a-1
b-2
c-3
..
Z-26

You will have a encrypted message, your task is to find the total number of ways that message can be decrypted

Input:
You will have an string S

Output
You have to return the total number of ways that string can be decrypted.

Example

Input: 111
Output: 3

Explanation

111 can be decoded into 'aaa', 'ka', 'ak'

//12-l,13-m
 */