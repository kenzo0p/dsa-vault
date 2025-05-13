package BinarySearch.medium;

import java.util.ArrayList;
import java.util.Collections;

public class PaintersPartition {
    
    //Painters partition &  split array largest sum

    //copied from book allocation
        public static int countStudents(ArrayList<Integer> arr, int pages) {
        int n = arr.size(); // size of array
        int students = 1;
        long pagesStudent = 0;
        for (int i = 0; i < n; i++) {
            if (pagesStudent + arr.get(i) <= pages) {
                // add pages to current student
                pagesStudent += arr.get(i);
            } else {
                // add pages to next student
                students++;
                pagesStudent = arr.get(i);
            }
        }
        return students;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        // book allocation impossible
        if (m > n)
            return -1;

        int low = Collections.max(arr);
        int high = arr.stream().mapToInt(Integer::intValue).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(arr, mid);
            if (students > m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int largestSubarraySumMinimized(ArrayList<Integer>a , int k){
        return (findPages(a, a.size(), k));
    }

    

    
}
