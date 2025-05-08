package BinarySearch.medium;

public class KokoEatingBananas {
    private static int findMax(int piles[]) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(piles[i], max);
        }

        return max;
    }

    private static int calculateTotalHours(int piles[], int mid) {
        int totalH = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) piles[i] / (double) mid);
        }
        return totalH;
    }

    public static int find(int piles[], int hrs) {
        int low = 1;
        int high = findMax(piles);
        while (low <= high) {
            int mid = (low + high) / 2;
            int totHrs = calculateTotalHours(piles, mid);
            if (totHrs <= hrs) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }

        }
        return low;
    }

    public static void main(String[] args) {

    }

}