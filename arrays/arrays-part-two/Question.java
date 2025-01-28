import java.util.*;

public class Question {
    public static int trappedRainWater(int height[]) {
        int n = height.length;
        int lmax = height[0];
        int rmax = height[n - 1];

        int low = 1;
        int high = n - 2;
        int ans = 0;
        while (low <= high) {
            lmax = Math.max(lmax, height[low]);
            rmax = Math.max(rmax, height[high]);

            if (lmax < rmax) {
                ans += lmax - height[low];
                low++;
            } else {
                ans += rmax - height[high];
                high--;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int nums[]) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        int low = 0;
        int high = n - 1;
        int mid = high - 1;

        while (high >= 2) {
            while (low < mid) {
                int sum = nums[low] + nums[mid] + nums[high];

                if (sum == 0) {
                    // Add the triplet to the set to avoid duplicates
                    set.add(Arrays.asList(nums[low], nums[mid], nums[high]));
                    low++;
                    mid--;

                } else if (sum > 0) {
                    mid--;
                } else {
                    low++;
                }
            }
            high--;// Move to the next potential "high" value
            mid = high - 1; // reset mid to just before high
            low = 0;// reset low to the start
        }

        // convert the set to a list for the result
        result.addAll(set);
        return result;
    }

    public static void main(String[] args) {

    }
}
