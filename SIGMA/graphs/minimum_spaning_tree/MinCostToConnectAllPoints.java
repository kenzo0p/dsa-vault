package PrimsAlgo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
    // leetcode 1584

    private int primsAlgo(List<List<int[]>> adj, int V) {
        int sum = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); // a[0] dist , a[1] -> node
        boolean inMst[] = new boolean[V];
        pq.offer(new int[] { 0, 0 });
        while (!pq.isEmpty()) {
            int curr[] = pq.poll();

            int dist = curr[0];
            int node = curr[1];
            if (inMst[node] == true) {
                continue;
            }

            inMst[node] = true;
            sum += dist;

            for (int neigh[] : adj.get(node)) {
                int d = neigh[0];
                int v = neigh[1];
                if (inMst[v] == false) {
                    pq.offer(new int[] { d, v });
                }
            }
        }

        return sum;

    }

    public int minCostConnectPoints(int[][] points) {
        // create the adj
        int V = points.length;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.get(i).add(new int[] { dist, j }); // dist and then node
                adj.get(j).add(new int[] { dist, i });
            }
        }

        return primsAlgo(adj, V);
    }

    // using kruskals
    private int parent[];
    private int rank[];

    private int find(int u) {
        if (u == parent[u]) {
            return u;
        }

        return parent[u] = find(parent[u]);
    }

    private void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);

        if (x_parent == y_parent) {
            return;
        }

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[y_parent] > rank[x_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    private int kruskal(List<int[]> adj) {
        int sum = 0;
        for (int edge[] : adj) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (find(u) != find(v)) {
                union(u, v);
                sum += w;
            }
        }

        return sum;
    }

    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
        List<int[]> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            // why i+1 agar i->j gaye hain to j-> i kyun java isliye i+1
            for (int j = i + 1; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.add(new int[] { i, j, dist });
            }
        }

        adj.sort(Comparator.comparingInt(a -> a[2]));

        return kruskal(adj);

    }

}
