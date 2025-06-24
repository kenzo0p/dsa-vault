import java.util.HashMap;

public class CountTheNumberOfGoodPartition {
    private final int M = (int) 1e9 + 7;

    public int numberOfGoodPartitions(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> last_index = new HashMap<>();

        for (int i = 0; i < n; i++) {
            last_index.put(nums[i], i);
        }

        int i = 0;
        int j = 0;
        j = Math.max(j, last_index.get(nums[0]));
        int result = 1;
        while (i < n) {
            if (i > j) {
                // we got a partition
                result = (int) (result * 2) % M;// becuase he have two possibilities to get partition ek to khud mein
                                                // lelo yato partition kardo

            }
            j = Math.max(j, last_index.get(nums[i]));
            i++;
        }

        return result;
    }
}
