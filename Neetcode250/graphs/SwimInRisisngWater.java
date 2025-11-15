package Neetcode250.graphs;

import java.util.*;

public class SwimInRisisngWater {

    class Solution {
        /*
         * What actually happens step by step:
         * 
         * PriorityQueue (min-heap) always gives you the cell with the lowest height
         * next (the “least time” so far).
         * So yes — it stores things like 0, 1, 2, 3… in ascending order.
         * 
         * Every time you take the smallest one (like 1),
         * you “enter” that cell — meaning water has risen to at least that height.
         * 
         * The variable result = max(result, currentHeight)
         * keeps track of the maximum height you’ve seen on your path —
         * because that’s the time you must wait to reach there safely.
         * 
         * You mark that cell visited,
         * then push all unvisited neighbors into the PQ with their heights (like
         * times).
         * 
         * PQ automatically sorts, so you always pick the next lowest “height” cell
         * that’s reachable.
         * 
         * When you finally reach the bottom-right cell,
         * the result holds the minimum possible water level (time) needed to get there.
         */
        private final int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        private boolean isSafe(int i, int j, int m, int n) {
            return i >= 0 && j >= 0 && i < m && j < n;
        }

        public int swimInWater(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            boolean visited[][] = new boolean[m][n];
            pq.offer(new int[] { 0, 0, grid[0][0] }); // i , j , time
            visited[0][0] = true;
            int result = 0;
            while (!pq.isEmpty()) {
                int curr[] = pq.poll();
                int i = curr[0];
                int j = curr[1];
                int time = curr[2];
                result = Math.max(time, result);

                if (i == m - 1 && j == n - 1)
                    return result;
                for (int dir[] : directions) {
                    int i_ = i + dir[0];
                    int j_ = j + dir[1];
                    if (isSafe(i_, j_, m, n) && !visited[i_][j_]) {
                        visited[i_][j_] = true;
                        pq.offer(new int[] { i_, j_, grid[i_][j_] });
                    }
                }
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        
    }
}