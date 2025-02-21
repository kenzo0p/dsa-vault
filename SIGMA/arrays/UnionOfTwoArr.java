import java.util.ArrayList;
import java.util.TreeSet;

public class UnionOfTwoArr {

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (int j : b) {
            set.add(j);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int elem : set) {
            list.add(elem);
        }
        return list;
    }

    public static ArrayList<Integer> FindUnionOpti(int arr1[], int arr2[], int n, int m) {
        int i = 0, j = 0; // pointers
        ArrayList<Integer> Union = new ArrayList<>(); // Uninon vector
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) // Case 1 and 2
            {
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;
            } else // case 3
            {
                if (Union.size() == 0 || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;
            }
        }
        while (i < n) // IF any element left in arr1
        {
            if (Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }
        while (j < m) // If any elements left in arr2
        {
            if (Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }
        return Union;
    }

    public static void main(String[] args) {

    }
}
