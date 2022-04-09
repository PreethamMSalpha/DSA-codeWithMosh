package com.preetham.HashTables;

//Input: [2, 7, 11, 15] => target = 9
//Output: [0, 1] (because 2 + 7 = 9)
//return indices of the two numbers such
//that they add up to a specific target.

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] res(int[] numbers, int target) {
        //a+b=target => a=target-b
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            var compliment = target - numbers[i];
            if (map.containsKey(compliment))
                return new int[]{map.get(compliment), i};
            map.put(numbers[i], i);
        }

        System.out.println(map);
        return null;
    }
}
