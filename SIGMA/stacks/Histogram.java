import java.util.*;

/*
 * //TODO: Question - given an array of integers heights representing the histograms bar height where the width of each bar is 1 , return the area of the largest rectangle in the histograms
 *   
 * 
 * area = width * height
 * 
 * step 1 ) find next smaller right and left dont include them as they are boundaries i (nsl pointer) , j(nsr pointer)
 * widht  = j-i-1 -> i = 1 , j=4 4-1-1 => 2 as we dont have to get i,j
 * 
 * 
 * nsl -> [-1,-1,1,5,1,2] - actually here are indexes not values bcoz we have to calculate the widht
 * index nsl -> [-1,-1,1,2,1 ,4]
 * nsr -> [1,6,2,2,6,6] //  for valid length dont take -1 instead take arr.length in nsr but 
 * index nsr -> [1,n,4,4,n,n] n-> 6 here
 * 
 * 
 * step2  ) calculate the area area = height * widht(j-i-1)
 * area => 2*(1+1-1) = 2   similarly
 */



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
        int height[] = {2,1,5,6,2,3};
        int area = maxAreaInHistogram(height);
        System.out.println("Max area in histogram :- "+area);
    }
}
