package MultiSourceBfs;

import java.util.Queue;

public class AsFarLandAsPossible {

    /*
     * 1162. As Far from Land as Possible
     * Given an n x n grid containing only values 0 and 1, where 0 represents water
     * and 1 represents land, find a water cell such that its distance to the
     * nearest land cell is maximized, and return the distance. If no land or water
     * exists in the grid, return -1.
     * 
     * The distance used in this problem is the Manhattan distance: the distance
     * between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
     * 
     * 
     */
    // brute force
    public int maxDistance(int grid[][]) {
        int n = grid.length;
        int maxDist = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    // why minDist is because we care about neared dist
                    int minDist = Integer.MAX_VALUE;

                    for (int x = 0; x < n; x++) {
                        for (int y = 0; y < n; y++) {
                            if (grid[x][y] == 1) {

                                int dist = Math.abs(i - x) + Math.abs(j - y);
                                minDist = Math.min(minDist, dist);
                            }
                        }
                    }

                    if (minDist != Integer.MAX_VALUE) {
                        maxDist = Math.max(minDist, maxDist);
                    }
                }
            }
        }
        return maxDist;
    }

    // using bfs optimal

    // four directions : up , down , left , right
    private int directions[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // A copy of matrix of the grid to mark water cells as land once visited.
        int visited[][] = new int[m][n];
        // Insert all the lande cells in the queue
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // copy grid to the visited matrix
                visited[i][j] = grid[i][j];
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                }
            }
        }

        int dist = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair<Integer, Integer> landCell = q.poll();

                // from the current cell , traverse to all the four directions
                // and check it its a water cell , if yes convert it to the land
                // and add it tot the queue

                for (int dir[] : directions) {
                    int x = landCell.getKey() + dir[0];
                    int y = landCell.getValue() + dir[1];

                    if (x >= 0 && y >= 0 && x < m && y < n && visited[x][y] == 0) {
                        // marking as 1 to avoid re-iterrating
                        visited[x][y] = 1;
                        q.offer(new Pair(x, y));
                    }
                }
            }

            // after each iteration of q elements, increment distance
            // as we coverre 1 unit distance from all cell in every directions

            dist++;
        }

        return dist == 0 ? -1 : dist;
    }

}
