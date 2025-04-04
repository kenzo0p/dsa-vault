
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
        k = k % n; // Handle cases where k > n

        int temp[] = new int[k]; // Store first k elements

        // Copy first k elements to temp
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        // Shift remaining elements to the left
        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }

        // Copy temp elements back to the end
        for (int i = 0; i < k; i++) {
            arr[n - k + i] = temp[i];
        }
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {// it should be strickly less than
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotateByKPlacesOptimal(int arr[], int k) {
        int n = arr.length;
        k = k % n;// if k is greater than like if k== 7 then 7%n = this value will give same ans
                  // as but if its greater than it will give error that is indexoutofbound
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        rotateByKPlaces(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
