import java.util.Arrays;

public class FindTheMaximumNumberOfFruitsCollected {
    private int n;
    private int t[][];

    private int child1Collect(int[][] fruits) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += fruits[i][i];
        }

        return count;
    }

    private int child2Collect(int i, int j, int[][] fruits) {
        if (i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (i == n - 1 && j == n - 1) {
            return 0;// because [n-1][n-1] was already collected by child one
        }
        if (i == j || i > j) {
            return 0;
        }
        if (t[i][j] != -1) {
            return t[i][j];
        }
        int bottomLeft = fruits[i][j] + child2Collect(i + 1, j - 1, fruits);
        int bottomDown = fruits[i][j] + child2Collect(i + 1, j, fruits);
        int bottomRight = fruits[i][j] + child2Collect(i + 1, j + 1, fruits);
        return t[i][j] = Math.max(bottomLeft, Math.max(bottomDown, bottomRight));
    }

    private int child3Collect(int i, int j, int[][] fruits) {
        if (i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (i == n - 1 && j == n - 1) {
            return 0;// because [n-1][n-1] was already collected by child one
        }
        if (i == j || i < j) {
            return 0;
        }
        if (t[i][j] != -1) {
            return t[i][j];
        }
        int upRight = fruits[i][j] + child3Collect(i - 1, j + 1, fruits);
        int rightCell = fruits[i][j] + child3Collect(i, j + 1, fruits);
        int bottomRightCell = fruits[i][j] + child3Collect(i + 1, j + 1, fruits);
        return t[i][j] = Math.max(upRight, Math.max(rightCell, bottomRightCell));
    }

    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        t = new int[n + 1][n + 1];
        for (int m[] : t) {
            Arrays.fill(m, -1);
        }
        int c1 = child1Collect(fruits); // o(d)
        int c2 = child2Collect(0, n - 1, fruits);
        int c3 = child3Collect(n - 1, 0, fruits);

        return c1 + c2 + c3;
    }

    // bottom-up
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int[][] t = new int[n][n];
        // t[i][j] = max fruits collected till [i][j]

        // child1Collect - Diagonal elements
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += fruits[i][i];
        }

        // Before child2 and child3, nullify the cells which can't be visited by child2
        // and child3
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j && i + j < n - 1) {
                    t[i][j] = 0;
                } else if (i > j && i + j < n - 1) {
                    t[i][j] = 0;
                } else {
                    t[i][j] = fruits[i][j];
                }
            }
        }

        // child2 collect fruits
        // cells upper to diagonal : i < j
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                t[i][j] += Math.max(t[i - 1][j - 1], Math.max(t[i - 1][j], (j + 1 < n) ? t[i - 1][j + 1] : 0));
            }
        }

        // child3 collect fruits
        // cells below diagonal : i > j
        for (int j = 1; j < n; j++) {
            for (int i = j + 1; i < n; i++) {
                t[i][j] += Math.max(t[i - 1][j - 1], Math.max(t[i][j - 1], (i + 1 < n) ? t[i + 1][j - 1] : 0));
            }
        }

        return result + t[n - 2][n - 1] + t[n - 1][n - 2];
    }
}
