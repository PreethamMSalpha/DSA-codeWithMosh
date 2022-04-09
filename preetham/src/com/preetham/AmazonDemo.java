package com.preetham;

import java.util.ArrayList;
import java.util.List;

public class AmazonDemo {
    public static void main(String[] args) {
        var res = generateParenthesis(3);
        System.out.println(res.toString());
    }

    public static List<String> generateParenthesis(int n){
        List<String> outputArray = new ArrayList<>();
        backtracking(outputArray, "", 0, 0, n);
        return outputArray;
    }

    public static void backtracking(List<String> outputArray, String currentString, int open, int close, int max){
        if(currentString.length() == max*2){
            outputArray.add(currentString);
            return;
        }

        if(open < max) backtracking(outputArray, currentString+'(', open+1, close, max);
        if(close < open) backtracking(outputArray, currentString+')', open, close+1, max);
    }
}
