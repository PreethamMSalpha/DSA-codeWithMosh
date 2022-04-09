package com.preetham.HashTables;

import java.util.HashMap;
import java.util.Map;

public class MostRepeatedElement {
    //[1, 2, 2, 3, 3, 3, 4]
    public static int mostFrequent(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();

        for (var num : numbers) {
            var count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        int maxValue = -1;
        int mostRepEle = numbers[0];
        for (var item : map.entrySet()) {
            if (item.getValue() > maxValue) {
                maxValue = item.getValue();
                mostRepEle = item.getKey();
            }
        }

        return mostRepEle;

    }
}
