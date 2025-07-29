package Dfs_and_bfs;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class NearestExitFromEntranceInMaze {
    class Solution {
        private int directions[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        public int nearestExit(char[][] maze, int[] entrance) {
            int m = maze.length;
            int n = maze[0].length;

            Queue<int[]> q = new LinkedList<>(); // que of (i , j)
            q.offer(new int[] { entrance[0], entrance[1] });

            // mark visited by making it a wall
            maze[entrance[0]][entrance[1]] = '+';
            int steps = 0;
            // write classic BFS code
            while (!q.isEmpty()) {
                int N = q.size();
                while (N-- > 0) {
                    int curr[] = q.poll();

                    int i = curr[0];
                    int j = curr[1];
                    // if boundary then return steps
                    if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && (!Arrays.equals(curr, entrance))) {
                        return steps;
                    }

                    // explore the neighbours
                    for (int dir[] : directions) {
                        int newI = i + dir[0];
                        int newJ = j + dir[1];

                        if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && maze[newI][newJ] != '+') {
                            // q mein add kardo and visit kardo
                            q.offer(new int[] { newI, newJ });
                            maze[newI][newJ] = '+';
                        }
                    }
                }

                steps++;
            }

            return -1;
        }
    }
}
