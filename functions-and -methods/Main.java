import java.util.*;

public class Main {

    public static void printHelloWorld() {
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");

    }

    public static int calculateSum(int num1, int num2) {
        int sum = num1 + num2;
        return sum;
    }

    public static void swap(int a, int b) {
        // swap
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);
    }

    public static void changeA(int a) {
        a = 10;
    }

    public static int Multiply(int a, int b) {
        int mul = a * b;
        return mul;
    }

    public static int factorial(int a) {
        int fact = 1;
        for (int i = 1; i <= a; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static int binCoeff(int n, int r) {
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n - r);
        int binCo = fact_n / (fact_r * fact_nmr);
        return binCo;

    }

    // function to calculate sum of 2 nums
    public static int sum(int a, int b) {
        return a + b;
    }

    // function to calculate the sum of 3 numbers
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

    // function to calculate float sum
    public static float sum(float a, float b) {
        // System.out.println("this called");
        return a + b;
    }

    public static boolean prime(int a) {
        boolean isPrime = true;
        if (a == 2) {
            return true;
        }
        if (a == 1) {
            System.out.println("Nor Composite Nor Prime");
            return false;
        }
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    public static boolean primeO(int a) {
        boolean isPrime = true;
        if (a == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    public static void primesInRange(int n) {
        for (int i = 2; i <= n; i++) {
            if (prime(i)) {
                System.out.println(i);
            }
        }
    }

    public static void binToDec(int binNum) {
        int myNum = binNum;
        int pow = 0;
        int decNum = 0;
        while (binNum > 0) {
            int lastDigit = binNum % 10;
            decNum = decNum + (lastDigit * (int) Math.pow(2, pow));
            pow++;
            binNum /= 10;
        }
        System.out.println("Decimal of " + myNum + " = " + decNum);
    }

    public static void decToBin(int decNum) {
        int myNum = decNum;
        int pow = 0;
        int binNum = 0;
        while (decNum > 0) {
            int rem = decNum % 2;
            binNum = binNum + (rem * (int) Math.pow(10, pow));
            pow++;
            decNum = decNum / 2;
        }
        System.out.println("The binary form of " + myNum + " = " + binNum);
    }

    public static void main(String[] args) {
        // printHelloWorld();// function call
        Scanner sc = new Scanner(System.in);
        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // int sum = calculateSum(a, b);
        // System.out.println(sum);
        // swap(10, 20);
        // int a =6;
        // changeA(a);
        // System.out.println(a);
        // System.out.println(Multiply(10, 20));
        // System.out.println(factorial(0));
        // System.out.println(binCoeff(5, 2));
        // System.out.println(sum(2,3));
        // System.out.println(sum(5,4,3));
        // System.out.println(sum(5.5f,4.5f));
        // System.out.println(prime(2));
        // System.out.println(primeO(1));
        // primesInRange(100);
        // binToDec(111);
        decToBin(15);
    }
}