package dijkstrasAlgo;

import java.util.*;

import dijkstrasAlgo.DijkstrasAlgo.Pair;

public class DijkstrasAlgo {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.dest = d;
            this.src = s;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        public Pair(int n, int path) {
            this.n = n;
            this.path = path;

        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;/// path based sorting for my pairs
        }
    }

    public static void dijkstrasAlgo(ArrayList<Edge> graph[], int src) {
        int dist[] = new int[graph.length]; // dist[i] -> src to i
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;// + infinity
            }
        }
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        // loop for bfs
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (!vis[curr.n]) {
                vis[curr.n] = true;

                // neighbour info
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;

                    if (dist[u] + wt < dist[v]) { // update distance of src to v;
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }
        // print all source to vertices shorest dist
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    static class Pair2 {
        int node, dist;

        Pair2(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void dijkstra(List<List<Pair2>> adj, int V, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Pair2> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Pair2(source, 0));

        while (!pq.isEmpty()) {
            Pair2 current = pq.poll();
            int u = current.node;
            int d = current.dist;

            for (Pair2 neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.dist;

                if (d + weight < dist[v]) {
                    dist[v] = d + weight;
                    pq.add(new Pair2(v, dist[v]));
                }
            }
        }

        // Print result
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from " + source + " to " + i + " is " + dist[i]);
        }
    }

    // using sets

    static class Pair implements Comparable<Pair> {
        int node, dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        public int compareTo(Pair other) {
            if (this.dist == other.dist)
                return this.node - other.node;
            return this.dist - other.dist;
        }
    }

    public static void dijkstra(List<List<Pair>> adj, int V, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE); // Step 1: set all distances to ∞
        dist[source] = 0; // Distance from source to itself is 0

        TreeSet<Pair> set = new TreeSet<>();
        set.add(new Pair(source, 0)); // Start from source node (0, distance 0)

        // Step 2: Loop while there are nodes to visit
        while (!set.isEmpty()) {
            Pair current = set.pollFirst(); // Get node with smallest distance
            int u = current.node; // Current node u

            // Step 3: Visit all neighbors of node u
            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.dist;

                // Relaxation step: if shorter path found, update it
                if (dist[u] + weight < dist[v]) {
                    set.remove(new Pair(v, dist[v])); // remove old entry if any
                    dist[v] = dist[u] + weight; // update with smaller distance
                    set.add(new Pair(v, dist[v])); // add updated distance
                }
            }
        }

        // Print result
        for (int i = 0; i < V; i++) {
            System.out.println("Distance from " + source + " to " + i + " is " + dist[i]);
        }
    }

    // Why not Priority queue
    /*
     * 
     * Time complexity ->  V * (log(v)  + elog(v))   || Vid no 26
     */

    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        int src = 0;
        dijkstrasAlgo(graph, src);
    }
}