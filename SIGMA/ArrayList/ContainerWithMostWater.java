import java.util.ArrayList;

public class ContainerWithMostWater {
    // brute force
    public static int containerWithMostWater(ArrayList<Integer> height) { // o(n^2)
        int maxWater = 0;
        int n = height.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int width = j - i;
                int water = ht * width;
                if (water > maxWater) {
                    maxWater = water;
                }

            }
        }
        return maxWater;

    }

    // optimal solution two pointer aproach o(n)
    public static int con(ArrayList<Integer> height) {
        int n = height.size();
        int maxWater = 0;
        int lp = 0;
        int rp = n - 1;
        while (lp < rp) {
            // calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int water = ht * width;
            maxWater = Math.max(water, maxWater);
            // update pointer
            if (height.get(lp) < height.get(rp)) {
                lp++; //remeber you have to calculate the height  based on their height they will move
            } else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        int water = con(height);
        System.out.println(water);

    }
}
