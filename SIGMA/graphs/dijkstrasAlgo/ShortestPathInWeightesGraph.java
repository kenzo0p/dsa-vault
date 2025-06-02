package dijkstrasAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathInWeightesGraph {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[] { v, w });
            adj.get(v).add(new int[] { u, w });
        }

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        dist[1] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, 1 }); // {distance, node}

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int weight = neighbor[1];

                if (d + weight < dist[adjNode]) {
                    dist[adjNode] = d + weight;
                    parent[adjNode] = node;
                    pq.offer(new int[] { dist[adjNode], adjNode });
                }
            }
        }

        // If no path found
        if (dist[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }

        // Reconstruct path
        List<Integer> path = new ArrayList<>();
        int node = n;
        while (node != parent[node]) {
            path.add(node);
            node = parent[node];
        }
        path.add(node);
        Collections.reverse(path);

        // Add distance at the beginning
        path.add(0, dist[n]);
        return path;
    }

}
