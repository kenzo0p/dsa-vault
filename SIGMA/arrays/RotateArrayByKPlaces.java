import java.util.Collections;

public class RotateArrayByKPlaces {
    public static void rotateByOne(int arr[]) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }

    public static void rotateByKPlaces(int arr[], int k) {
        int n = arr.length;
        k = k % n;

        int temp[] = new int[k];
        // storing the elem in temp till k
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        // put the after k elem to the first shifting
        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }
        // then last first elem to the left
        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - (n - k)];
        }

    }
    public static void rotateByKPlacesOptimal(int arr[], int k) {
        int n = arr.length;


    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        rotateByKPlacesOptimal(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
