//leetcode 1911
public class MaximumAlternatingSubsequeceSum {
    /*
     * //TODO: make the tree diagram one more time for clearity Google  ,amazon , meta
     * ex -> nums={4,2,5,3}
     * output -> 7
     * subseq -> {4,2,5} -> (4+5) - 2 = 7 ✅
     * subseq -> {2,5,3} -> (2+3) - 5 = 0
     * subseq -> {4,5,3} -> (4+3) - 5 = 2 and simi for other subseq there is no
     * greater than 7
     * 
     * take and skip thats why dp
     * flag -> true ,false => (+) ,(-)
     * 
     * in case of skip flag is same but in take flip the flag as per tree diagram
     * true -> false (!flip)
     */

    long t[][];

    private long solve(int idx, boolean flag, int nums[]) {
        if (idx >= nums.length) {
            return 0;
        }
        int f = flag ? 1 : 0;
        if (t[idx][f] != -1) {
            return t[idx][f];
        }

        long skip = solve(idx + 1, flag, nums);
        long val = nums[idx];
        if (flag == false) { //odd index -
            val = -val;
        }

        long take = solve(idx + 1, !flag, nums) + val;
        return t[idx][f] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        t = new long[nums.length][2];
        for (long[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve(0, true, nums); // 0 is even true : +
    }

    // bottom up
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long t[][] = new long[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            // even length subseq 
            t[i][0] = Math.max(t[i - 1][1] - nums[i - 1], t[i - 1][0]);
            // odd
            t[i][1] = Math.max(t[i - 1][0] + nums[i - 1], t[i - 1][1]);
        }
        return Math.max(t[n][0], t[n][1]);
    }

    public static void main(String[] args) {

    }
}
