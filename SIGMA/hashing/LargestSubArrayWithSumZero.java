import java.util.HashMap;

public class LargestSubArrayWithSumZero {

    public static int largestSub(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int len = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            if (map.containsKey(sum)) {
                len = Math.max(len, j - map.get(sum));
            } else {
                map.put(sum, j);
            }

        }

        return len;
    }

    public static void main(String[] args) {

    }

}
