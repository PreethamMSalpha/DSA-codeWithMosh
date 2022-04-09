package com.preetham.HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatedChar {

    public static char FirstNonRepeatedChar(String string) {
        //a green apple
        Map<Character, Integer> map = new HashMap<>();

        int count;
        for (var ch : string.toCharArray()) {
            if (map.containsKey(ch)) {
                count = map.get(ch);
                map.put(ch, count + 1);
            } else {
                map.put(ch, 1);
            }
        }
        System.out.println(map);

        for (var ch : string.toCharArray())
            if (map.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE;
    }
}
