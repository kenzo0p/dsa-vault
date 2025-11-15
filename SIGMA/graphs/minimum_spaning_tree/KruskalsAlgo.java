package minimum_spaning_tree;
import java.util.*;

import kruskalsAlgo.KruskalsAlgo.Edge;

// 0(v+eloge)
    static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt;
        }
    }

    static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n = 4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
    }

    public static int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]); // path compressoin
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);
        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] < rank[parB]) {
            par[parA] = parB;
        } else {
            par[parB] = parA;
        }
    }

    public static int kruskalsAlgo(ArrayList<Edge> edges, int V) {
        init();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;
        for (int i = 0; i < V - 1; i++) {
            Edge e = edges.get(i);
            int parA = find(e.src);// src = a
            int parB = find(e.dest);// dest = b
            if (parA != parB) {
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        return mstCost;
    }




    //gfg
    private int[] parent;
    private int[] rank;

    // DSU: Find with path compression
    int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    // DSU: Union by rank
    void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }

    // Kruskal's algorithm implementation
    int kruskal(List<int[]> edges) {
        int sum = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (find(u) != find(v)) {
                union(u, v);
                sum += wt;
            }
        }

        return sum;
    }

    // Main function to build edge list and apply Kruskal's
   public int spanningTree(int V,int E ,  List<List<int[]>> adj) {
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        List<int[]> edges = new ArrayList<>();

        for (int u = 0; u < V; u++) {
            for (int[] temp : adj.get(u)) {
                int v = temp[0];
                int wt = temp[1];

                if (u < v) { // To avoid duplicate edges in undirected graph
                    edges.add(new int[]{u, v, wt});
                }
            }
        }

        // Sort by weight
        edges.sort(Comparator.comparingInt(a -> a[2]));

        return kruskal(edges);
    }



    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        System.out.print(kruskalsAlgo(edges, v));
    }
}
