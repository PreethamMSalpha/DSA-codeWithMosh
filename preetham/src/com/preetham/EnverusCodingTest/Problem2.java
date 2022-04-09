package com.preetham.EnverusCodingTest;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static void main(String[] args) {
        // String inp = "after badly";
        String inp = "Laura sobs";
        boolean res = gapFinder(inp.toLowerCase());
        System.out.println(res);
    }

    static boolean gapFinder(String str) {
        int gapDifference = 3;

        List<Integer> alist = new ArrayList<>();
        List<Integer> blist = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                alist.add(i);
            }
            if (str.charAt(i) == 'b') {
                blist.add(i);
            }
        }

        for (int i = 0; i < alist.size(); i++) {
            for (int j = 0; j < blist.size(); j++) {

                if (Math.abs(alist.get(i) - blist.get(j)) - 1 == gapDifference) {
                    return true;
                }
            }
        }

        return false;
    }
}

//Problem statement
//check whether the gap between a and b is 3 or not in the given string
