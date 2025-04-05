import java.util.ArrayList;

public class ArrayLeaders {
    public static ArrayList<Integer> leaders(int nums[]) { // brute force
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            boolean leader = true;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    leader = false;
                    break;
                }
            }
            if (leader) {
                list.add(nums[i]);
            }
        }
        return list;

    }

    public static ArrayList<Integer> leadersOptimal(int nums[]) { // optimal
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int max = nums[n - 1];
        ans.add(nums[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > max) {
                ans.add(nums[i]);
                max = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 16, 17, 4, 3, 5, 2 };
        System.out.println(leaders(nums));
    }
}
