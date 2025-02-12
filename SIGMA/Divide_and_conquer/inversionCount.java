public class inversionCount {
 
    // merge function remains the same as MergeSort
    // only change is that you calculate the inversions and return it.
    public static int merge(int arr[], int start, int end) {
        int sz = (end - start + 1), mid = (start + end) / 2;
        int sortedArr[] = new int[sz];
        int i = start, j = mid + 1, index = 0, ans = 0;
        // left -> [start .... mid] ==> start = start, end = mid;
        // right -> [mid+1 .... end] ==> start = mid+1, end = end;
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                // left element > right element
                // we have inversions
                // # of inversions = (lastIndex of left array - currentIndex of left array + 1)
                // lastIndex of left = mid
                // currentIndex of left = i
                // # of inversions = (mid - i + 1)
                ans += (mid - i + 1);
                sortedArr[index++] = arr[j++];
            } else {
                sortedArr[index++] = arr[i++];
            }
        }
        while (i <= mid) {
            sortedArr[index++] = arr[i++];
        }
        while (j <= end) {
            sortedArr[index++] = arr[j++];
        }
 
        for (i = 0; i < sz; i++) {
            arr[i + start] = sortedArr[i];
        }
        return ans;
    }
 
    // exactly same as MergeSort
    public static int countInversion(int arr[], int start, int end) {
        if (start >= end)
            return 0;
        int mid = (start + end) / 2;
        int leftInversions = countInversion(arr, start, mid);
        int rightInversions = countInversion(arr, mid + 1, end);
        int crossInversions = merge(arr, start, end);
        return leftInversions + rightInversions + crossInversions;
    }
 
    public static void main(String[] args) {
        int arr[] = { 2, 4, 1, 3, 5 };
        // int arr[] = { 2, 3, 4, 5, 6 };
        int ans = countInversion(arr, 0, arr.length - 1);
        System.out.println("Inversion count of the array is: " + ans);
    }
}
 