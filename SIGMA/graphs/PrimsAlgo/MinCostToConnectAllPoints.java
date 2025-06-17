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

}
