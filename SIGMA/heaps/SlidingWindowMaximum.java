
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    static class Pair implements Comparable<Pair> { //o(nlogk)
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;

        }

        @Override
        public int compareTo(Pair p2) {
            // asc
            // return this.val - p2.val;

            // dsc
            return p2.val - this.val;
        }
    }

    public static int[] slidingWindow(int[] nums, int k) {
        if(k==1) return nums;
        int res[] = new int[nums.length - k + 1];// n-k+1
        PriorityQueue<Pair>pq = new PriorityQueue<>();
        //1st window
        for(int i = 0;i<k;i++){
            pq.add(new Pair(nums[i] , i));
        }
        res[0] = pq.peek().val;
        for(int i = k;i<nums.length;i++){
            while(pq.size() > 0 && pq.peek().idx < (i-k+1)){
                pq.remove();

            }
            pq.add(new Pair(nums[i], i));
            res[i-k+1] = pq.peek().val;
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        int res[] = slidingWindow(nums, k);
        for(int i = 0;i<res.length;i++){
            System.out.print(res[i] + ", ");
        }

    }
}
