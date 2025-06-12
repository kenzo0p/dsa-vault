import java.util.Arrays;

public class UniquePaths {
    // o(2^m+n) after doing memo o(m+1*n+1)
    private int solve(int i, int j, int m, int n, int t[][]) {
        if (i == m - 1 && j == n - 1) {
            return 1;// we found 1 path to reach [m-1][n-1]
        }

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if (t[i][j] != -1) {
            return t[i][j];
        }

        int right = solve(i, j + 1, m, n, t);
        int down = solve(i + 1, j, m, n, t);
        return t[i][j] = right + down;
    }

    public int uniquePaths(int m, int n) {
        int t[][] = new int[m + 1][n + 1];
        for (int memo[] : t) {
            Arrays.fill(memo, -1);
        }
        return solve(0, 0, m, n, t);
    }


    // o(m*n)
    public int uniquePaths(int m, int n) {


        int t[][] = new int[m][n];
        //t[i][j] => total no of ways o rreach [i][j] from [0][0]

        t[0][0] = 1; //total ways to reach 0,0 from 0 ,0 
        //fill the column
        for(int col  =1;col<n;col++){
            t[0][col] = 1;
        }
        // fill the row
        for(int row = 1;row<m;row++){
            t[row][0] = 1;
        }



        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                t[i][j] = t[i-1][j] + t[i][j-1];
            }
        }

        return t[m-1][n-1];
       
    }
}
