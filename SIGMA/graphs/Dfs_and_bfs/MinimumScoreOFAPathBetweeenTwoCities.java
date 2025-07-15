package Dfs_and_bfs;

import java.util.ArrayList;
import java.util.List;

public class MinimumScoreOFAPathBetweeenTwoCities {
    private class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private int result = Integer.MAX_VALUE;

    private void dfs(int u, boolean vis[], List<List<Pair>> adj) {
        vis[u] = true;
        for (Pair v : adj.get(u)) {
            int first = v.first;
            int second = v.second;

            result = Math.min(result, second);

            if (!vis[first]) {
                dfs(first, vis, adj);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int road[] : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        boolean vis[] = new boolean[n + 1];
        dfs(1, vis, adj);

        return result;
    }
}
