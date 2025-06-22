import java.util.Queue;

public class MapOfHighestPeak {
    private final int directions[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private boolean isSafe(int i, int j, int m, int n, int height[][]) {
        return i >= 0 && j >= 0 && i < m && j < n && height[i][j] == -1;
    }

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) { // its water
                    q.offer(new int[] { i, j });
                    height[i][j] = 0;

                } else {
                    height[i][j] = -1;
                }
            }
        }

        // now perform multisource bfs
        while (!q.isEmpty()) {
            int N = q.size();
            while (N-- > 0) {
                int curr[] = q.poll();

                int i = curr[0];
                int j = curr[1];

                for (int[] dir : directions) {
                    int i_ = i + dir[0];
                    int j_ = j + dir[1];

                    if (isSafe(i_, j_, m, n, height)) {
                        height[i_][j_] = height[i][j] + 1;
                        q.offer(new int[] { i_, j_ });
                    }
                }
            }
        }

        return height;

    }
}
