package com.citb408;

import java.util.Locale;

public class Main {

    // Task 1 - first solution:
    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Task 1 - second solution:
    public static boolean isPalindrome2(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        return str.equals(stringBuilder.toString());
    }

    // Task 2 - first solution:
    public static String firstLetters(String str) {
        String result = "";

        if (Character.isLetter(str.charAt(0))) {
            result += str.charAt(0);
        }

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == ' ') {
                if (Character.isLetter(str.charAt(0))) {
                    result += str.charAt(i + 1);
                }
            }
        }
        return result.toUpperCase();
    }

    // Task 2 - second solution:
    public static String firstLetters2(String str) {
        String[] words = str.split(" ");
        String result = "";

        for (String word: words){
            result+=word.charAt(0);
        }
        return result.toUpperCase();
    }

    public static void main(String[] args) {
        // Task 1
        String str = "qwertytrewq";
        String str2 = "qwerty";

        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(str2));

        System.out.println(isPalindrome2(str));
        System.out.println(isPalindrome2(str2));

        // Task 2
        str = "This is a simple example!";
        System.out.println(firstLetters(str));

        System.out.println(firstLetters2(str));



    }
}
