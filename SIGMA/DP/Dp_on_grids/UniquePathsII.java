package SIGMA.DP.Dp_on_grids;

import java.util.Arrays;
public class UniquePathsII {
    private int m;
    private int n;
    private int t[][];

    private int solve(int i, int j, int grid[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        int right = solve(i + 1, j, grid);
        int down = solve(i, j + 1, grid);
        return t[i][j] = right + down;
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        t = new int[m + 1][n + 1];
        for (int memo[] : t) {
            Arrays.fill(memo, -1);
        }
        return solve(0, 0, grid);
    }
    public int uniquePathsWithObstacles(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        int t[][] = new int[m][n];
        for (int memo[] : t) {
            Arrays.fill(memo, -1);
        }
        
        if(grid[0][0] == 1){
            return 0;
        }

        //fill the column
        for(int col = 0;col<n;col++){
            if(col >0 && grid[0][col-1] == 1){
                t[0][col] = 0;
                grid[0][col] = 1;
            }else if(grid[0][col] == 1){
                t[0][col] = 0;
            }else {
                t[0][col] = 1;
            }
        }

        //fill the row
        for(int row = 0;row<m;row++){
            if(row >0 && grid[row-1][0] == 1){
                t[row][0] = 0;
                grid[row][0] = 1;
            }else if(grid[row][0] == 1){
                t[row][0] = 0;
            }else {
                t[row][0] = 1;
            }
        }

        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(grid[i][j] == 1){
                    t[i][j] = 0;
                }else {
                    t[i][j] = t[i-1][j] + t[i][j-1];
                }
            }
        }

        return t[m-1][n-1];

    }
}
