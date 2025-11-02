package Neetcode250.graphs;
import java.util.*;

public class PacificAtlanticOceanWaterFlow {
    private final int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private void dfs(int i, int j, int prev, int m, int n, int heights[][], boolean visited[][]) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        if (heights[i][j] < prev || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        for (int dir[] : directions) {
            int newI = i +  dir[0];
            int newJ = j + dir[1];
            dfs(newI, newJ, heights[i][j], m, n, heights, visited);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();
        boolean isAtlanticVisited[][] = new boolean[m][n];
        boolean isPacificVisited[][] = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            dfs(0, i, Integer.MIN_VALUE, m, n, heights, isPacificVisited);
            dfs(m - 1, i, Integer.MIN_VALUE, m, n, heights, isAtlanticVisited);
        }
        for (int i = 0; i < m; i++) {
            dfs(i, 0, Integer.MIN_VALUE, m, n, heights, isPacificVisited);
            dfs(i, n - 1, Integer.MIN_VALUE, m, n, heights, isAtlanticVisited);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isAtlanticVisited[i][j] && isPacificVisited[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {

    }
}