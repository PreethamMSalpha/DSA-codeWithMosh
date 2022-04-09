package com.preetham.HashTables;

//Input: [1, 7, 5, 9, 2, 12, 3] K=2
//Output: 4
//We have four pairs with difference 2: (1, 3), (3, 5), (5, 7), (7, 9).

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountUniquePairsWithDiff {
    public static int res(int[] numbers, int diff) {
        Set<Integer> set = new HashSet<>();

        for (var num : numbers)
            set.add(num); //remove all dup in given array

//        a-b=diff => b=a-diff
//        b-a=diff => b=a+diff

        int count = 0;
        for (var num : numbers) {
            if (set.contains(num - diff))
                count++;
            if (set.contains(num + diff))
                count++;
            set.remove(num);
        }
        return count;
    }
}
