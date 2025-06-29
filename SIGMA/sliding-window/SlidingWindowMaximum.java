package sliding-window;
import java.util.ArrayDeque;
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>(); // Stores values in decreasing order
        int i = 0, j = 0, ptr = 0;
        int n = nums.length;
        int[] res = new int[n - k + 1]; // Result array to store maximums

        while (j < n) {
            // Remove all elements smaller than nums[j] from the back
            while (!q.isEmpty() && q.peekLast() < nums[j]) {
                q.pollLast();
            }

            // Add the current element to the deque
            q.add(nums[j]);

            // Window size less than k -> just move the window forward
            if (j - i + 1 < k) {
                j++;
            }
            // Window size exactly k
            else if (j - i + 1 == k) {
                // The front of the deque is the max of the window
                res[ptr++] = q.peek();

                // If the element going out of the window is equal to front, remove it
                if (nums[i] == q.peek()) {
                    q.pollFirst();
                }

                // Slide the window
                i++;
                j++;
            }
        }

        return res;
    }
}
