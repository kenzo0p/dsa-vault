package You.easy;

public class Productarraypuzzle {
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int res[] = new int[n];

        int leftProd = 1;
        for (int i = 0; i < n; i++) {
            res[i] = leftProd;
            leftProd *= arr[i];
        }

        int rightProd = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= rightProd;
            rightProd *= arr[i];
        }

        return res;
    }
}
