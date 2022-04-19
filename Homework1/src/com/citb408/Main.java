package com.citb408;

public class Main {
    // Nina Petrova F101863

    // Task 1
    public static int countNumbers(int bottom, int top, int difference) {
        if (bottom < 0 || top < 0) {
            return 0;
        }

        int counter = 0;
        for (int i = bottom; i <= top; i++) {
            int c = i;
            int firstDigit;
            while (c >= 10) {
                c /= 10;
            }

            firstDigit = c;
            String num = String.valueOf(i);
            String result = num.substring(1) + firstDigit;

            int dif = Integer.parseInt(result) - i;
            if (dif > difference) {
                counter++;
            }
        }
        return counter;
    }

    // Task 2
    public static int sumOfNumbers(int size) {
        if (size < 1 || size > 9) {
            return 0;
        }

        String n = "";
        String number = "";
        for (int i = 1; i <= size; i++) {
            n = String.valueOf(i);
            number += n;
        }
        int counter = 0;
        int increaseLength = 1;
        while (increaseLength <= size) {

            for (int start = increaseLength; start <= number.length(); start++) {
                counter += start;
            }
            for (int end = number.length(); end >= increaseLength; end--) {
                counter += end;
            }

            increaseLength++;
        }

        int decreaseLength = size - 1;
        while (decreaseLength > 0) {
            for (int start = decreaseLength; start <= number.length(); start++) {
                counter += start;
            }
            for (int end = number.length(); end >= decreaseLength; end--) {
                counter += end;
            }

            decreaseLength--;
        }
        return counter;
    }

    public static void main(String[] args) {
        //Task 1
        System.out.println(countNumbers(1000, 1200, 700));
        System.out.println(countNumbers(0, 100, 40));

        //Task2
        System.out.println(sumOfNumbers(4));
        System.out.println(sumOfNumbers(6));

    }
}
