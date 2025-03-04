import java.util.*;

public class FractionalKnapsack {
    public static int fractionalKnapsack(int val[], int weight[], int w) {
        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        // ascending order sorting
        int capacity = w;
        int finalVal = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) {// include full item
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                // include fraction item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }
        return finalVal;
    }

    public static void main(String[] args) {
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int w = 50;
        int value = fractionalKnapsack(val, weight, w);
        System.out.println(value + " ");

    }
}
