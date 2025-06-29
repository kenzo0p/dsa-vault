package SIGMA.sliding-window;

public class MinimizeSizeSubArraySum {
    /*
     * [2,3,1,2,4,3] taret  -> 7
     * 
     * first window 2+3+1+2+4+3 -> 15 its greater than >  target
     * len = j-i+1 -> 6
     * 
     * second window minimize the window i++
     * and sum -=[nums[i]] delete that elem
     * 
     *2+3+1+2+4+3 -> 13 its also >  taret change the len -> j-i +1 -> 5


     same goes for next steps also
     */
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int min_len = Integer.MAX_VALUE;
        int sum = 0;
        while (j < n) {
            sum += nums[j];

            // chota karna cha rahe hain window ko
            while (sum >= target) {
                min_len = Math.min(min_len, j - i + 1);

                // window ko chota karde
                sum -= nums[i];
                i++;
            }
            j++;
        }

        return min_len == Integer.MAX_VALUE ? 0 : min_len;
    }
}
