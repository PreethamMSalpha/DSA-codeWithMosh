package com.preetham.HashTables;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedChar {

    public static char FirstRepeatedChar(String string) {
        //ababcd
        //set - abcd
        Set<Character> set = new HashSet<>();
        for (char ch : string.toCharArray()) {
            if (set.contains(ch))
                return ch;

            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
