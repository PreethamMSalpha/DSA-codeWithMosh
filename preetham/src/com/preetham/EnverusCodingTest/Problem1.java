package com.preetham.EnverusCodingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem1 {
    public static void main(String[] args) {
        String str = "letters=A B Z T numbers=1 2 26 20 combine=true";
//        String str = "a=3 b=4 a=23 b=a 4 23 c=";
        CommandLine(str + " ");

    }

    static void CommandLine(String str) {

        String regex = "\\w+=";
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(str);
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        while (m1.find()) {
            l1.add((m1.end() - m1.start() - 1));
        }


        String regex2 = "=[\\d|\\w]*[\\s[\\d|\\w]]*\\s";
        Pattern p2 = Pattern.compile(regex2);
        Matcher m2 = p2.matcher(str);

        while (m2.find()) {
            l2.add((m2.end() - m2.start() - 2));
        }

        int a=0;
        while(a < l1.size()){
            System.out.print(l1.get(a)+"="+l2.get(a));
            if(a != l1.size() - 1){
                System.out.print(" ");
            }
            a++;
        }

    }
}


//problem statement
/*
Command Line
Have the function CommandLine(str) take the str parameter being passed which represents the parameters given to a command in an old PDP system.
The parameters are alphanumeric tokens (without spaces) followed by an equal sign and by their corresponding value.
Multiple parameters/value pairs can be placed on the command line with a single space between each pair.
Parameter tokens and values cannot contain equal signs but values can contain spaces.
The purpose of the function is to isolate the parameters and values to return a list of parameter and value lengths.
It must provide its result in the same format and in the same order by replacing each entry (tokens and values) by its corresponding length.

For example, if str is: "SampleNumber=3234 provider=Dr. M. Welby patient=John Smith priority=High"
then your function should return the string "12=4 8=12 7=10 8=4"
because "SampleNumber" is a 12 character token with a 4 character value ("3234")
followed by "provider" which is an 8 character token followed by a 12 character value ("Dr. M. Welby"), etc.

Examples
Input: "letters=A B Z T numbers=1 2 26 20 combine=true"
Output: 7=7 7=9 7=4
Input: "a=3 b=4 a=23 b=a 4 23 c="
Output: 1=1 1=1 1=2 1=6 1=0
 */