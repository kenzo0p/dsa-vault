import java.util.Arrays;

public class GridWays {
    public static int gridWays(int i, int j, int n, int m) {// brute force
        if (i == n - 1 && j == m - 1) {// condition for lastcell
            return 1; // if its go to the end then its have one path from start
        } else if (i >= m || j >= n) { // corner case agar wo baher ja raha hain to
            return 0;
        }
        int w1 = gridWays(i + 1, j, n, m); // down as i = rows
        int w2 = gridWays(i, j + 1, n, m); // right as j = cols
        return w1 + w2;
    }

    public int solve(int i, int j, int m, int n, int[][] t) {
        // Base case: Reached the bottom-right cell
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Out of bounds
        if (i >= m || j >= n) {    
            return 0;
        }

        // If already computed, return the stored result
        if (t[i][j] != -1) {
            return t[i][j];
        }

        // Calculate the number of paths by going right and down
        int right = solve(i, j + 1, m, n, t); //remember i and j kabhi 0 nahi hoga kuynki hmm usko plus kar rahe hain
        int down = solve(i + 1, j, m, n, t);

        // Store the result in the memoization table
        return t[i][j] = right + down;
    }

    public int uniquePaths(int m, int n) { // optimize using 2d dp
        // Create a memoization table initialized with -1
        int[][] t = new int[m][n];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        // Start the recursive computation from the top-left cell
        return solve(0, 0, m, n, t);
    }

    public static int uniquePath(int m, int n) { // optimize
        long res = 1;// result
        int small = Math.min(n - 1, m - 1);// choose smaller value to optimize
        int total = (m - 1) + (n - 1);// total steps
        for (int i = 1; i <= small; i++) {
            res = res * (total - i + 1) / i;// compute
        }
        return (int) res;// safe conversion to int
    }

    public static void main(String[] args) {
        int n = 3, m = 3;
        System.out.println(gridWays(0, 0, n, m));
        System.out.println(uniquePath(3, 3));
    }
}
