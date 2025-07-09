package FloydsWarshallAlgo;

import java.util.Arrays;

public class CountTheNumberOfHousesAtACertainDistance {
    class Solution {
        // shortest distance ki baat ho rahi hain to bfs and dijkstras algo , floyd
        // warshall , bellman ford

        // why floyd warshall kar ke node ka us node se distance nikalna hain isliye we
        // can solve it using bfs also
        // n^3 floyd warshall but here constrain are small so we can solve itusing floyd
        // warshall
        public int[] countOfPairs(int n, int x, int y) {
            int inf = (int) 1e9;
            int grid[][] = new int[n + 1][n + 1];
            for (int row[] : grid) {
                Arrays.fill(row, inf);
            }
            for (int i = 1; i < n; i++) {
                grid[i][i + 1] = 1;
                grid[i + 1][i] = 1;

            }

            grid[x][y] = 1;
            grid[y][x] = 1;

            // floyd warshal
            for (int via = 1; via <= n; via++) {

                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {

                        if (i == j) {
                            grid[i][j] = 0;
                        } else {
                            grid[i][j] = Math.min(grid[i][j], grid[i][via] + grid[via][j]);
                        }

                    }
                }
            }

            int result[] = new int[n];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i != j) {
                        int val = grid[i][j];
                        result[val - 1]++;
                    }

                }
            }

            return result;

        }
    }
}
