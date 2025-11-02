package Neetcode250.graphs;

import java.util.*;

public class MinCostToConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adj = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int x2 = points[j][0];

                int y1 = points[i][1];
                int y2 = points[j][1];

                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.get(i).add(new int[] { j, d });
                adj.get(j).add(new int[] { i, d });

            }
        }

        return primsAlgo(adj, n);
    }

    private int primsAlgo(List<List<int[]>> adj, int n) {
        int sum = 0;
        boolean inMst[] = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[] { 0, 0 });
        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if (inMst[node]) {
                continue;
            }

            sum += d;
            inMst[node] = true;
            for (int neigh[] : adj.get(node)) {
                int point = neigh[0];
                int w = neigh[1];
                if (inMst[point] == false) {
                    pq.offer(new int[] { point, w });
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

    }
}
