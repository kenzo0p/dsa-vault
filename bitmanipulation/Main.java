import java.util.*;

public class Main {

    public static void oddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            // even 
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
    }

    public static boolean chekIfTheBitSet(int n , int i){
        int bitMask = 1<<i;
        if((bitMask & n)!= 0){
            return true;
        }
        return false;
    }

    public static int toggleIthBit(int n , int i){
        int bitMask = 1<<i;
        return (bitMask ^ n);
    }
    public static int getIthBit(int n, int i) {
        // System.out.println(1<<i);
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        // System.out.println(1<<i);
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        // System.out.println(1<<i);
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int UpdateIthBit(int n, int i, int newBit) {
        // if(newBit == 0){
        // return clearIthBit(n, i);
        // }else {
        // return setIthBit(n, i);
        // }

        int num = clearIthBit(n, i);
        int bitMask = newBit << i;
        return num | bitMask;

    }

    public static int clearIBits(int n, int i) {
        int bitMask = (~0) << i;
        return n & bitMask;
    }

    public static int clearRangeOfBits(int n, int i, int j) {
        int a = ((~0) << (j + 2));
        int b = (1 << i) - 1;
        int bitMask = a | b;
        return n & bitMask;
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
    // ! google amazon
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int fastExpo(int a, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {// check lsb
                ans = ans * a;

            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // bit manipulation
        /*
         * bitwise and = &
         * binary or = |
         * binary xor = ^
         * Binary 1s complement = ~
         * Binary left shoft = <<
         * Binary right shift = >>
         * msb =0 number is positive otherwise negative left most bit
         * lsb = right most bit
         */

        // System.out.println(5&6);
        // System.out.println(4^6);
        // System.out.println(~5); //~0 is -1
        // System.out.println(5<<2);//shift by two placess left (a^2^b)
        // System.out.println(6>>1);//shift but two placess to right
        System.out.println(toggleIthBit(44, 4));
        // TODO: modular exponentiation

    }
}
