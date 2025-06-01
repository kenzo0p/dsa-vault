public class Main {

    static void decreasingNumber(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        System.out.print(n + " ");
        decreasingNumber(n - 1);

    }

    static void increasingNumber(int n) {
        if (n == 1) {
            System.out.println(1);
            return;
        }
        increasingNumber(n - 1);
        System.out.println(n + "");

    }

    public static int fact(int n) {

        if (n == 0) {
            return 1;
        }

        int a = n * fact(n - 1);
        return a;

    }

    public static int sumOfNumbers(int n) {

        if (n == 1) {
            return 1;
        }

        int a = n + sumOfNumbers(n - 1);
        return a;

    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int fibnm1 = fibonacci(n - 1);
        int fibnm2 = fibonacci(n - 2);
        int fibn = fibnm1 + fibnm2;
        return fibn;
    }

    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        }
        return isSorted(arr, i + 1);
    }

    public static int firstOccurance(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == key) {
            return i;
        }
        return firstOccurance(arr, key, i + 1);
    }

    public static int lastOccurance(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurance(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }

    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int xnm1 = power(x, n - 1);
        int xn = x * xnm1;
        return xn;
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }

        if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        }
        return x * myPow(x * x, (n - 1) / 2);

    }

    public static int optimizedPower(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int halfPower = optimizedPower(a, n / 2);
        int halfPowerSq = halfPower * halfPower;
        // n is odd
        if (n % 2 != 0) {
            halfPowerSq = a * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static void numbersToString(String arr[], int n) {
        if (n == 0) {
            return;
        }
        int lastDigit = n % 10;
        numbersToString(arr, n / 10);
        System.out.print(arr[lastDigit] + " ");
    }

    public static void main(String[] args) {
        int n = 5;
        int arr[] = { 1, 2, 10, 4, 5, 2 };
        int key = 2;
        String arr1[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        numbersToString(arr1, 1400);
    }
}
