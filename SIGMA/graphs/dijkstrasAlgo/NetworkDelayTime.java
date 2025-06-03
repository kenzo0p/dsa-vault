import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int time[] : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new Pair(v, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new Pair(k, 0));
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.dist;
            for (Pair neigh : adj.get(node)) {
                int u = neigh.node;
                int distN = neigh.dist;
                if (d + distN < dist[u]) {
                    dist[u] = d + distN;
                    pq.add(new Pair(u, d + distN));
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}
