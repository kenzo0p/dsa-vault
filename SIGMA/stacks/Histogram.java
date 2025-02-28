import java.util.*;

public class Histogram {

    public static int maxAreaInHistogram(int height[]) {
        int maxArea = 0;
        int nsr[] = new int[height.length];
        int nsl[] = new int[height.length];

        // next smaller right
        Stack<Integer> st = new Stack<>();

        for (int i = height.length-1; i >= 0; i--) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                // -1
                nsr[i] = height.length;

            } else {
                // top
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        // next smaller left
        st = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                // -1
                nsl[i] = -1;

            } else {
                // top
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        // current area : widjt j-i-1 = nsr[i] - nsr[j] -1;
        for (int i = 0; i < height.length; i++) {
            int ht = height[i];
            int widht = nsr[i] - nsl[i] - 1;
            int currArea = ht * widht;
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int height[] = { 2,4 };
        int area = maxAreaInHistogram(height);
        System.out.println("Max area in histogram :- "+area);
    }
}
