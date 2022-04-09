package com.preetham.Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubString {

    static void substr(String p, String up){
        if (up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        substr(p+ch, up.substring(1));
        substr(p, up.substring(1));
    }

    static ArrayList<String> substrRet(String p, String up){
        if (up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        ArrayList<String> left = substrRet(p+ch, up.substring(1));
        ArrayList<String> right = substrRet(p, up.substring(1));

        left.addAll(right);

        return left;
    }

    public static void main(String[] args) {
//        substr("","abc");
        var res = substrRet("", "abcd");
        Collections.sort(res);
        System.out.println(res.toString());
    }
}
