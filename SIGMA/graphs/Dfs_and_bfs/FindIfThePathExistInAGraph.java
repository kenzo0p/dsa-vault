package Dfs_and_bfs;

import java.util.ArrayList;
import java.util.List;

public class FindIfThePathExistInAGraph {
    private boolean dfs(int u, int destination, boolean vis[], List<List<Integer>> adj) {
        if (u == destination) {
            return true;
        }

        vis[u] = true;
        for (int v : adj.get(u)) {
            if (!vis[v] && dfs(v, destination, vis, adj)) {
                return true;
            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[n];

        return dfs(source, destination, vis, adj);
    }
}
