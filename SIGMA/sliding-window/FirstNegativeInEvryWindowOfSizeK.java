import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FirstNegativeInEvryWindowOfSizeK {

    static List<Integer> firstNegInt(int a[], int k) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int n = a.length;

        Deque<Integer> dq = new ArrayDeque<>();

        while (j < n) {
            // If current element is negative, add it to deque
            if (a[j] < 0) {
                dq.addLast(a[j]);
            }

            // If window size < k, expand window
            if (j - i + 1 < k) {
                j++;
            }
            // If window size == k
            else if (j - i + 1 == k) {
                // If deque is not empty, front element is the first negative integer
                if (!dq.isEmpty()) {
                    result.add(dq.peekFirst());
                } else {
                    result.add(0);
                }

                // Slide the window: if the outgoing element is negative, remove it from deque
                if (!dq.isEmpty() && a[i] == dq.peekFirst()) {
                    dq.pollFirst();
                }

                i++;
                j++;
            }
        }

        return result;
    }


    
}
