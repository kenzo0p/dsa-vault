import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualTOk {

    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {//o(n)
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {10,2,-2,-20,10};
        System.out.println(subarraySum(arr, -10));
    }
}