package dijkstrasAlgo;

import java.util.*;

public class ShortestPathInBinaryMatrix {
    // using bfs

    private int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 },
            { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    private boolean isSafe(int x, int y, int m, int n) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        //it should visted to travel 
        if (m == 0 || n == 0 || grid[0][0] != 0) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0 });
        grid[0][0] = 1;
        int level = 0;
        while (!q.isEmpty()) {
            int N = q.size();
            while (N-- > 0) {
                int curr[] = q.poll();
                int x = curr[0];
                int y = curr[1];

                if (x == m - 1 && y == n - 1) {
                    return level + 1;
                }

                for (int dir[] : directions) {
                    int x_ = x + dir[0];
                    int y_ = y + dir[1];

                    if (isSafe(x_, y_, m, n) && grid[x_][y_] == 0) {
                        q.add(new int[] { x_, y_ });
                        grid[x_][y_] = 1;
                    }
                }
            }
            level++;
        }

        return -1;
    }

    // using dijkstras algo pq
    private static final int[][] directions = {
        {1, 1}, {0, 1}, {1, 0}, {0, -1},
        {-1, 0}, {-1, -1}, {1, -1}, {-1, 1}
    };

    private boolean isSafe(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) return -1;

        int[][] result = new int[m][n];
        for (int[] row : result) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[]{0, 0, 0}); // {distance, x, y}
        result[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0], x = top[1], y = top[2];

            if (x == m - 1 && y == n - 1) return d + 1;

            for (int[] dir : directions) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];

                if (isSafe(x_, y_, m, n) && grid[x_][y_] == 0) {
                    int newDist = d + 1;
                    if (newDist < result[x_][y_]) {
                        result[x_][y_] = newDist;
                        pq.offer(new int[]{newDist, x_, y_});
                        grid[x_][y_] = 1; // mark as visited
                    }
                }
            }
        }

        return -1;
    }



    private static final int[][] directions = {
            { 1, 1 }, { 0, 1 }, { 1, 0 }, { 0, -1 },
            { -1, 0 }, { -1, -1 }, { 1, -1 }, { -1, 1 }
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0)
            return -1;

        int[][] result = new int[m][n];
        for (int[] row : result)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.offer(new int[] { 0, 0, 0 }); // {distance, x, y}
        result[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0], x = top[1], y = top[2];

            if (x == m - 1 && y == n - 1)
                return d + 1;

            for (int[] dir : directions) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];

                if (x_ >= 0 && x_ < m && y_ >= 0 && y_ < n && grid[x_][y_] == 0) {
                    int newDist = d + 1;
                    if (newDist < result[x_][y_]) {
                        result[x_][y_] = newDist;
                        pq.offer(new int[] { newDist, x_, y_ });
                        grid[x_][y_] = 1; // mark visited
                    }
                }
            }
        }

        return -1;
    }
}
