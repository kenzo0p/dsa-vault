public class Main {

    public static void mergeSort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // kaam
        int mid = si + (ei - si) / 2;// (si+ei)/2 bhi chalega
        mergeSort(arr, si, mid);// for left part
        mergeSort(arr, mid + 1, ei);// for right part

        // left and right both the array is sorted
        merge(arr, si, mid, ei);

    }

    public static void merge(int arr[], int si, int mid, int ei) {
        // assume left(0,3) = 4 , right(4,6) = 3 -> 6-0+1 = 7 here ei is 6 , si will
        // change everytime
        int temp[] = new int[ei - si + 1];
        int i = si;// iterator for left part
        int j = mid + 1; // iterator for left part
        int k = 0;// iterator for temp array
        // compare the elem and merge into temp array
        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // left part mein agar kuch bacha hain too
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        // copy temporary to my original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];

        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8, -2 };
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
