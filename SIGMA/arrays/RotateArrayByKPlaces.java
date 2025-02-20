
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

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {//it should be strickly less than
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateByKPlacesOptimal(int arr[], int k) {
        int n = arr.length;
        k = k%n;//if k is greater than like if k== 7  then 7%n = this value will give same ans as but if its greater than it will give error that is indexoutofbound
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        rotateByKPlacesOptimal(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
