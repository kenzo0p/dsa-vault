import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LonelyNumbers {

    public static List<Integer> findLonely(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if ((i == 0 || nums[i] - nums[i - 1] > 1) && (i == n - 1 || nums[i + 1] - nums[i] > 1)) {
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 8, 6, 5 };
        System.out.println(findLonely(arr));
    }
}
