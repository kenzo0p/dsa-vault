public class Questions {
    public static int lineaSearch(String arr[], String key) {

        for (int i = 0; i < arr.length; i++) {
            if (key == arr[i]) {
                return i;
            }
        }
        return -1;

    }

    public static int largestArray(int arr[]) {
        int largest = Integer.MIN_VALUE;// -infinity
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];
            }
            if (smallest > arr[i]) {
                smallest = arr[i];
            }
        }
        System.out.print(smallest + " ");
        return largest;
    }

    public static int binarySearch(int arr[], int key) {
        // this algorithm is only for sorted arrays
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            // comparison
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) { // right
                start = mid + 1;
            } else {// left
                end = mid - 1;
            }

        }

        return -1;
    }

    public static void reverseArray(int numbers[]) {
        int first = 0;
        int last = numbers.length - 1;
        while (first < last) {
            // swap
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;

            first++;
            last--;
        }
    }

    public static void pairsArray(int numbers[]) { // 0(n^2)
        int total = 0;// (n*(n-1))/2 for directly getting the pairs
        for (int i = 0; i < numbers.length; i++) {
            int current = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                System.out.print("(" + current + "," + numbers[j] + ") ");
                total++;
            }
            System.out.println();
        }
        System.out.println("Total: " + total);
    }

    // public static void subArrays(int numbers[]) {
    //     int ts = 0; // (n(n+1))/2
    //     int sum = 0;
    //     int startSum = 0;
    //     int maxSum = 0;
    //     for (int i = 0; i < numbers.length; i++) {
    //         int start = i;
    //         for (int j = i; j < numbers.length; j++) {
    //             int end = j;
    //             for (int k = start; k <= end; k++) {
    //                 System.out.print(numbers[k] + " ");
    //                 sum = sum + numbers[k];

    //                 startSum = sum;
    //                 if (startSum > maxSum) {
    //                     maxSum = maxSum + numbers[k];
    //                 }
    //             }
    //             ts++;
    //             System.out.println();
    //         }
    //         System.out.println("The Sum is: " + sum);
    //         sum = 0;

    //         System.out.println();
    //     }
    //     System.out.println("The sum of min sum is: " + startSum);
    //     System.out.println("The sum of max sum is: " + maxSum);
    //     System.out.println("Total subarrays: " + ts);
    // }
    // public static void subArraysSum(int numbers[]) {//o(n^3)
    //     // int ts = 0; // (n(n+1))/2
    //     int currSum = 0;
    //     int maxSum = Integer.MIN_VALUE;
    //     for (int i = 0; i < numbers.length; i++) {
    //         int start = i;
    //         for (int j = i; j < numbers.length; j++) {
    //             int end = j;
                    //currSum = 0;
    //             for (int k = start; k <= end; k++) {
    //                currSum +=numbers[k];
    //             }
    //             System.out.println(currSum);
    //             if(maxSum < currSum) {
    //                 maxSum = currSum;
    //             }
    //         }
    //     }
    //     System.out.println("Max sum is : "+ maxSum);
    // }

    // prefix sum
    public static void subArraysSum(int numbers[]) {//o(n^3)
        // int ts = 0; // (n(n+1))/2
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];
        prefix[0] = numbers[0];
        for(int i = 1;i<prefix.length;i++){
            prefix[i] = prefix[i-1] + numbers[i];
        }
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                currSum = start == 0 ? prefix[end] :  prefix[end] - prefix[start-1];
                if(maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("Max sum is : "+ maxSum);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10, 100, 3, 5, 6, 7 };
        // String menu[] = {"dosa" ,"shole bhature" , "samosa"};
        // String key = "samosa";
        // System.out.println(lineaSearch(menu, key));
        // int key = 25;
        // System.out.print(binarySearch(arr , key));

        // reverseArray(arr);
        // for(int i =0;i<arr.length;i++){
        // System.out.print(arr[i]+ " ");
        // }
        // pairsArray(arr);
        subArraysSum(arr);

    }
}
