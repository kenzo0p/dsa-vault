import java.util.Scanner;

public class Question {

    static boolean isEvevn(int n) {
        if (n % 2 == 1) {
            return false;
        }
        return true;
    }

    static void sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;// for last digit
            sum = sum + lastDigit;
            n /= 10;
        }
        System.out.println("Sum = " + sum);
    }

    static int reverseNumber(int n) {
        int rev = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            rev = rev * 10 + lastDigit;
            n /= 10;
        }
        return rev;
    }

    static void palindrome(int n) {
        int m =n;
        int rev = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            rev = rev * 10 + lastDigit;
            n /= 10;
        }
        if (m == rev) {
            System.out.println("it's a palindrome number");
        } else {
            System.out.println("Not palindrome");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean even = isEvevn(4);
        System.out.println(even);
        sumOfDigits(51389);
        System.out.println(reverseNumber(51389));
        palindrome(124);
    }
}