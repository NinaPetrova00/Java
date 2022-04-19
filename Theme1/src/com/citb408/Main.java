package com.citb408;

public class Main {
    // Task 1
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    // Task 2
    public static int daysInMonth(int year, String month) {
        int days = 0;
        switch (month) {
            case "January":
            case "March":
            case "May":
            case "July":
            case "August":
            case "October":
            case "December":
                days = 31;
                break;
            case "April":
            case "June":
            case "September":
            case "November":
                days = 30;
                break;
            case "February":
                days = isLeapYear(year) ? 29 : 28;
                break;
            default:
                days = -1;
        }
        return days;
    }

    // Task 3
    public static void quadraticEquation(double a, double b, double c) {

        double d = Math.pow(b, 2) - 4 * a * c;
        if (d < 0) {
            System.out.println("There are no real roots");
        } else if (a != 0) {
            if (d == 0) {
                double root = -b / (2 * a);
                System.out.println("The root is: " + root);
            } else {
                double root1 = (-b + Math.sqrt(d)) / (2 * a);
                double root2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("The first root is: " + root1);
                System.out.println("The second root is: " + root2);
            }
        } else {
            System.out.println("Cannot divide by 0!");
        }
    }

    // Task 4
    public static void displayEvenNumbers(int bottom, int top) {
        if (bottom > top) {
            System.out.println("The interval is not entered correctly!");
        } else {
            if (bottom % 2 != 0) {
                bottom++;
            }
            System.out.println("The list of all even numbers in the interval is: ");
            for (int counter = bottom; counter <= top; counter += 2) {
                System.out.print(counter + " ");
            }
        }
    }

    // Task 5
    public static double average(int bottom, int top) {
        double sum = 0;
        int counter = 0;
        if (bottom % 5 != 0) {
            bottom += 5 - (bottom % 5);
        }
        for (int i = bottom; i <= top; i += 5) {
            if (i % 3 != 0) {
                sum += i;
                counter++;
            }
        }
        if (counter > 0) {
            return sum / counter;
        } else {
            System.out.println("There are no such numbers in the interval!!!");
            return 0;
        }
    }

    // Task 6
    public static void displayDivisors(int number) {

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // Task 7
    public static int sumOfDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // Task 8
    public static boolean isPerfect(int number) {
        return sumOfDivisors(number) == number;
    }

    // Task 9
    public static void displayPerfectNumbers(int bottom, int top) {
        if (bottom > top) {
            System.out.println("The interval is not entered correctly!");
        } else {
            System.out.println("The list of all perfect numbers in the interval between: " + bottom + " and " + top + ":");
            for (int counter = bottom; counter <= top; counter++) {
                if (isPerfect(counter)) {
                    System.out.print(counter + " ");
                }
            }
        }
    }

    // Task 10
    public static boolean isPrime(int number) {
        for (int counter = 2; counter <= Math.sqrt(number); counter++) {
            if (number % counter == 0) {
                return false;
            }
        }
        return true;
    }

    // Task 11
    public static void displayPrimeNumbers(int bottom, int top) {
        for (int counter = bottom; counter <= top; counter++) {
            if (isPrime(counter)) {
                System.out.print(counter + " ");
            }
        }
    }
    public static void main(String[] args) {
        // Task 1 Is Leap Year
        int year = 2020;
        System.out.println("Is " + year + " leap year? " + isLeapYear(year));

        // Task 2 Display number of days in a month

        String month = "February";
        if (daysInMonth(year, month) > 0) {
            System.out.println(month + " is " + daysInMonth(year, month) + " in " + year + "!");
        } else {
            System.out.println("There is no such month in the calendar!");
        }
        daysInMonth(year, month);


        // Task 3
        quadraticEquation(2, 4, 2);

        // Task 4
        displayEvenNumbers(5, 18);
        System.out.println();

        // Task 5
        System.out.println("The average value is: " + average(5, 18));

        // Task 6
        int number = 24;
        System.out.println("The divisors of the number " + number + " are: ");
        displayDivisors(number);
        System.out.println();

        // Task 7
        System.out.println("The sum of the divisors of the number " + number + " is " + sumOfDivisors(number));

        // Task 8
        System.out.println("Is the number " + number + " perfect " + isPerfect(number));

        // Task 9
        displayPerfectNumbers(1, 10_000);
        System.out.println();

        // Task 10
        System.out.println("Is the number " + number + " prime " + isPrime(number));

        // Task 11
        System.out.println("The prime numbers in the interval are: ");
        displayPrimeNumbers(2, 10_000);
    }
}
