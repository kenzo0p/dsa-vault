import java.util.HashSet;

public class UnionAndIntersection {

    public static HashSet<Integer> findUnion(int nums[], int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set;
    }

    public static int findIntersection(int arr1[], int arr2[]) {
        /*
         * take count var to get number of intersection
         * step 1 ) add all elem of arr1
         * step 2) for lopp till arr2.length
         * check if exist in set
         * count++;
         * remove(el)
         */
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
            } else {
                set.remove(arr2[i]);
            }
        }

        return count;

    }

    public static void main(String[] args) {

    }
}
