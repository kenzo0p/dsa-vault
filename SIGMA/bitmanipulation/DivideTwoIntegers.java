public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // Special case: if result is too big to fit in int
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        // Find the sign of the result:
        // XOR gives true if only one is negative
        // So if signs are different → result is negative (-1)
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        // Convert both numbers to positive (and use long to avoid overflow)
        long dvd = Math.abs((long) dividend); // dividend
        long dvs = Math.abs((long) divisor); // divisor

        int result = 0;

        // Subtract the divisor from dividend using bit shifting
        while (dvd >= dvs) {
            long temp = dvs;
            int multiple = 1;

            // Double the divisor until it's just smaller than dividend
            // temp <<= 1 means temp = temp * 2
            while (dvd >= (temp << 1)) {
                temp <<= 1; // double the temp
                multiple <<= 1; // double the multiple
            }

            // Subtract the largest doubled divisor from dividend
            dvd -= temp;

            // Add how many times we subtracted (multiple)
            result += multiple;
        }

        // Apply the sign to the result
        return sign * result;
    }
}
