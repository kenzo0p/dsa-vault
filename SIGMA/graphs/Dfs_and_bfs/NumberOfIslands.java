import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    /*
     * 200. Number of Islands
     * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
     * '0's (water), return the number of islands.
     * 
     * An island is surrounded by water and is formed by connecting adjacent lands
     * horizontally or vertically. You may assume all four edges of the grid are all
     * surrounded by water.
     * 
     */
    // using dfs
    private int m;
    private int n;

    private void dfs(char grid[][], int i, int j) {
        if (i >= m || i < 0 || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        if (grid[i][j] == '$') {
            return;
        }
        grid[i][j] = '$'; 
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;

    }

    // using bfs
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;

    }

    private int m;
    private int n;
    private int direction[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    private boolean check(int i, int j, char grid[][]) {
        return i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == '1';
    }

    private void bfs(int i, int j, char grid[][]) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { i, j });
        grid[i][j] = '$';
        while (!q.isEmpty()) {
            int curr[] = q.poll();

            for (int dir[] : direction) {
                int i_ = curr[0] + dir[0];
                int j_ = curr[1] + dir[1];

                if (check(i_, j_, grid)) {
                    q.offer(new int[] { i_, j_ });
                    grid[i_][j_] = '$';
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    islands++;
                }
            }
        }

        return islands;

    }

}