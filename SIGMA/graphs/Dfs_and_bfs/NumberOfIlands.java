package SIGMA.graphs.Dfs_and_bfs;

public class NumberOfIlands {


    //using dfs
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
    
    //using bfs
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
    

}