package Dfs_and_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Counpaths {
    private int count = 0;

    private void hasPath(int src, int dest, List<List<Integer>> adj) {
        if (src == dest) {
            count++;
            return;
        }

        for (int neigh : adj.get(src)) {
            hasPath(neigh, dest, adj);
        }

    }

    public int countPaths(int[][] edges, int V, int src, int dest) {
        if (src == dest) {
            return 1;
        }
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        hasPath(src, dest, adj);
        return count;

    }

    // using memo
    private int hasPath(int src, int dest, List<List<Integer>> adj, int dp[]) {
        if (src == dest) {
            return 1;
        }
        if (dp[src] != -1) {
            return dp[src];
        }

        int ways = 0;
        for (int neigh : adj.get(src)) {
            ways += hasPath(neigh, dest, adj, dp);
        }
        return dp[src] = ways;

    }

    public int countPaths(int[][] edges, int V, int src, int dest) {
        if (src == dest) {
            return 1;
        }
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        int dp[] = new int[V];
        Arrays.fill(dp, -1);
        return hasPath(src, dest, adj, dp);

    }

    public int countPaths(int[][] edges, int V, int src, int dest) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        // Topological sort using Kahn's Algorithm (BFS)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int neigh : adj.get(node)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0)
                    q.add(neigh);
            }
        }

        // DP array to count paths
        int[] dp = new int[V];
        dp[src] = 1; // 1 way to reach src

        for (int node : topo) {
            for (int neigh : adj.get(node)) {
                dp[neigh] += dp[node];
            }
        }

        return dp[dest];
    }

    public int countPaths(int[][] edges, int V, int src, int dest) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Topo sort using DFS
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, adj, visited, stack);
            }
        }

        // DP to count paths
        int[] dp = new int[V];
        dp[src] = 1;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            for (int neigh : adj.get(node)) {
                dp[neigh] += dp[node];
            }
        }

        return dp[dest];
    }

    // DFS function for Topo Sort
    private void topoSort(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neigh : adj.get(node)) {
            if (!visited[neigh]) {
                topoSort(neigh, adj, visited, stack);
            }
        }

        stack.push(node); // push after visiting children
    }

}
