package com.preetham.ALGORITHMS.StringManipulation;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static int vowelCount(String string) {
        if (string == null)
            return 0;

        int count = 0;
        String vowels = "hello";
        for (var ch : string.toLowerCase().toCharArray()) {
            if (vowels.indexOf(ch) != -1)
                count++;
        }
        return count;
    }

    public static String revString(String str) {
        if (str == null)
            return "";

        StringBuilder reversed = new StringBuilder();
        for (var i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }

    public static String revWords(String sentence) {
        if (sentence == null)
            return "";

        String[] words = sentence.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words); //delimiter -> char value to be added to each element
//        StringBuilder reversed = new StringBuilder();
//        for (var i=words.length - 1; i>=0 ; i--) {
//            reversed.append(words[i] + " ");
//        }
//
//        return reversed.toString().trim();
    }

    public static boolean areRotations(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;

        return ((str1.length() == str2.length()) && (str1 + str1).contains(str2));
    }

    public static String removeDuplicates(String str) {
        if (str == null)
            return "";

        StringBuilder output = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (var ch : str.toCharArray())
            if (!seen.contains(ch)) {
                seen.add(ch);
                output.append(ch);
            }

        return output.toString();
    }

    public static char getMaxOccuringChar(String str) {
        /* using regular hashtable
        Map<Character, Integer> map = new HashMap<>();

        for (var ch: str.toCharArray()){

//            if (map.containsKey(ch))
//                map.replace(ch, map.get(ch) + 1);
//            else
//                map.put(ch, 1);
//

            var count = map.getOrDefault(ch, 0);
            map.put(ch, count+1);
        }

        int count = -1;
        char ch = 0;
        for (var kv: map.entrySet()){
            if (kv.getValue() > count){
                ch = kv.getKey();
                count = kv.getValue();
            }
        }

        return ch;
        */
        final int ASCII_SIZE = 256;
        int[] frequncies = new int[ASCII_SIZE];

        for (var ch : str.toCharArray())
            frequncies[ch]++;

        int max = -1;
        char result = ' ';

        for (var i = 0; i < frequncies.length; i++) {
            if (frequncies[i] > max) {
                max = frequncies[i];
                result = (char) i;
            }
        }

        return result;
    }

    public static String capitalize(String sentence) {
        if (sentence == null || sentence.trim().isEmpty())
            return "";

        String[] words = sentence.trim().replaceAll(" +", " ").split(" ");
        for (var i = 0; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }

        return String.join(" ", words);
    }

    public static boolean anagram(String str1, String str2) {
        if (str1 == null || str2 == null || (str1.length() != str2.length()))
            return false;

        List<Character> list = new ArrayList<>();

        for (var ch : str1.toCharArray())
            list.add(ch);

        for (var ch : str2.toCharArray()) {
            if (!list.contains(ch))
                return false;
            else {
                list.remove(list.indexOf(ch));
            }
        }

        return list.isEmpty();
    }

    //O(nlogn)
    public static boolean areAnagram(String first, String second) {
        if (first == null || second == null)
            return false;

        //O(n)
        var array1 = first.toLowerCase().toCharArray();
        //O(n logn)
        Arrays.sort(array1);

        var array2 = second.toLowerCase().toCharArray();
        Arrays.sort(array2);

        //O(n)
        return Arrays.equals(array1, array2);
    }

    //O(n)
    public static boolean areAnagram2(String first, String second) {
        if (first == null || second == null)
            return false;

        final int ENG_ALPHABET = 26;
        int[] frequencies = new int[ENG_ALPHABET];

        first = first.toLowerCase();
        //O(n)
        for (var i = 0; i < first.length(); i++)
            frequencies[first.charAt(i) - 'a']++;

        second = second.toLowerCase();
        //O(n)
        for (var i = 0; i < second.length(); i++) {
            var index = second.charAt(i) - 'a';
            if (frequencies[index] == 0)
                return false;
            frequencies[index]--;

        }
        return true;
    }

    public static boolean palindrome(String str) {
//        var input = new StringBuilder(str);
//        input.reverse();
//        return input.toString().equals(str);
        if (str == null)
            return false;

        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }


    public static void RegexMatches() {

        String REGEX = "\\bcat\\b";
        String INPUT = "cat cat cat cattie cat";


        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);   // get a matcher object
        int count = 0;

        while (m.find()) {
            count++;
            System.out.println("Match number " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());

        }
    }

    public static int noOfUniqueYearsAppearInString(String input) {
        String REGEX = "[0-9]{4}";
//        String REGEX = "[0-9]{2}-[0-9]{2}-[0-9]{4}";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(input);   // get a matcher object
        int count = 0;

        Set<Integer> uniqueYears = new HashSet<>();

        while (m.find()) {
//            var time = input.substring(m.start(), m.end());
//            var year = time.split("-");
//            int yearInt = Integer.parseInt(year[2]);
//            if (!uniqueYears.contains(yearInt)) {
//                uniqueYears.add(yearInt);
//                count++;
//                System.out.println(yearInt);
//            }
            var year = input.substring(m.start(), m.end());
            int yearInt = Integer.parseInt(year);
            if (!uniqueYears.contains(yearInt)) {
                uniqueYears.add(yearInt);
                count++;
                System.out.println(yearInt);
            }
        }

        return count;
    }

    public static boolean passwordCheck(String S) {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        Pattern P = Pattern.compile(regex);
        Matcher M = P.matcher(S);

        while (M.find()) {
            return true;
        }

        return false;
    }
}
