package SIGMA.DP;

import java.util.Arrays;

public class MinimumFallingPathSum {
    /*
     * 931. Minimum Falling Path Sum
     * Medium
     * Topics
     * premium lock icon
     * Companies
     * Given an n x n array of integers matrix, return the minimum sum of any
     * falling path through matrix.
     * 
     * A falling path starts at any element in the first row and chooses the element
     * in the next row that is either directly below or diagonally left/right.
     * Specifically, the next element from position (row, col) will be (row + 1, col
     * - 1), (row + 1, col), or (row + 1, col + 1).
     */
    private int n;
    private int t[][];

    private int solve(int matrix[][], int row, int col) {
        if (row == n - 1) {
            return matrix[row][col];
        }
        if (t[row][col] != -1) {
            return t[row][col];
        }
        int sum = matrix[row][col];
        int minSum = Integer.MAX_VALUE;
        // as col -1 , 0 ,1 thats why this loop will save us from writting three if
        // staements
        for (int shift = -1; shift <= 1; shift++) {
            if (row + 1 < n && col + shift < n && col + shift >= 0) {
                minSum = Math.min(sum + solve(matrix, row + 1, col + shift), minSum);
            }
        }

        // if (row + 1 < n && col - 1 >= 0) {
        // minSum = Math.min(sum + solve(matrix, row + 1, col - 1), minSum);
        // }
        // if (row + 1 < n) {
        // minSum = Math.min(sum + solve(matrix, row + 1, col), minSum);
        // }
        // if (row + 1 < n && col + 1 < n) {
        // minSum = Math.min(sum + solve(matrix, row + 1, col + 1), minSum);
        // }

        return t[row][col] = minSum;
    }

    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        t = new int[n + 1][n + 1];
        for (int m[] : t) {
            Arrays.fill(m, -1);
        }
        int row = 0;
        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, solve(matrix, row, col));
        }

        return minSum;

    }

    // optimal
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] t = new int[n][n];

        // populate first row
        for (int col = 0; col < n; col++) {
            t[0][col] = matrix[0][col];
        }

        //
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {
                /*
                 * 
                 * t[row-1][col-1]
                 * t[row-1][col]
                 * t[row-1][col+1]
                 */
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                if (col - 1 >= 0)
                    a = t[row - 1][col - 1];
                if (col + 1 < n)
                    b = t[row - 1][col + 1];

                t[row][col] = matrix[row][col] + Math.min(a, Math.min(b, t[row - 1][col]));

            }
        }

        int result = Integer.MAX_VALUE;
        int lastRow = n - 1;
        for (int col = 0; col < n; col++) {
            result = Math.min(result, t[lastRow][col]);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}