import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOFArr {
    public static ArrayList<Integer> intersection(int arr[], int nums[]) {
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(arr); // Ensure sorted order
        Arrays.sort(nums);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (arr[i] == nums[j]) {
                    if (list.isEmpty() || list.get(list.size() - 1) != arr[i]) { // Avoid duplicates
                        list.add(arr[i]);
                    }
                    break; // Stop checking once an intersection is found
                }
            }
        }
        return list;
    }

    public static ArrayList<Integer> intersectionOptimal(int arr[], int nums[]) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0, j = 0; // Two pointers for arr[] and nums[]

        while (i < arr.length && j < nums.length) {
            if (arr[i] == nums[j]) {
                // Add only if the element is not already in the list
                if (list.isEmpty() || list.get(list.size() - 1) != arr[i]) {
                    list.add(arr[i]);
                }
                i++;
                j++; // Move both pointers forward
            } else if (arr[i] < nums[j]) {
                i++; // Move pointer `i` forward
            } else {
                j++; // Move pointer `j` forward
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 4, 8, 9, 0 };
        int nums[] = { 1, 3, 7, 5, 4, 0, 7, 5 };
        ArrayList<Integer> result = intersection(arr, nums);
        System.out.println("Intersection: " + result);
    }
}
