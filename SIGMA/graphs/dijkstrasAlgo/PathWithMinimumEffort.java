package dijkstrasAlgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
        private static final int[][] directions = {
             {0, 1}, {1, 0}, {0, -1}, {-1, 0} 
    };

    private boolean isSafe(int x , int y , int m , int  n){
        return x>=0 && x <m && y>=0 && y<n;
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int result[][] = new int[m][n];
        for (int row[] : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        result[0][0] = 0;
        pq.offer(new int[] { 0, 0, 0, });
        while (!pq.isEmpty()) {
            int[] diff = pq.poll();
            int d = diff[0];
            int x = diff[1];
            int y = diff[2];

            // if (x == m - 1 && y == n - 1) return d;
            for (int dir[] : directions) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];
                
                if(isSafe(x_ , y_ , m  , n)){
                    int absDiff = Math.abs(heights[x][y] - heights[x_][y_]);
                    int maxDiff = Math.max(d ,absDiff );

                    if(result[x_][y_] > maxDiff){
                        result[x_][y_] = maxDiff;
                        pq.offer(new int[]{maxDiff , x_ , y_});
                    }
                }
            }

        }

        return result[m-1][n-1];
    }
}
