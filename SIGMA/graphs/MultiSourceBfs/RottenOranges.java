package MultiSourceBfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    private final int direction[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int orangesRotten(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int freshCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) { // start from already rooten orange
                    q.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }

        }

        if (freshCount == 0) {
            return 0;
        }

        int minutes = 0;

        while (!q.isEmpty()) {
            int N = q.size();
            while (N-- > 0) {
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                for (int dir[] : direction) {
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i][new_j] == 1) {
                        grid[new_i][new_j] = 2;
                        freshCount--;
                        q.offer(new int[] { new_i, new_j });
                    }
                }
            }

            minutes++;
        }
        /*
         * 
         * minutes is incremented one extra time after the last orange is rotten.
         * 
         * minutes - 1 adjusts this off-by-one issue.
         */
        return freshCount == 0 ? minutes - 1 : -1; // why -1

    }

}