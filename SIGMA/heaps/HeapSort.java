import java.util.*;

public class HeapSort {
    public static void heapify(int arr[], int i, int size) {//o(logn)
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }
        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
            heapify(arr, maxIdx, size);
            ;
        }

    }

    public static void heapSort(int arr[]) {//2*(nlogn) => o(nlogn)
        int n = arr.length;
        // step -1 build a maxHeap
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // step -> 2 push largest at end
        for (int i = n - 1; i >= 0; i--) {
            // swap (largest- first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 3 };
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
