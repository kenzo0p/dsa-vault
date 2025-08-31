package cycleDetection;

import java.util.*;

public class CycleDetactionsUndirectedGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean vis[], int curr, int par) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            // case 3
            if (!vis[e.dest]) { // its already visited and its not my parent
                if (detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }

            } else if (vis[e.dest] && e.dest != par) { // case 1
                return true;
            }
            // case 2 -> do nothing -> continue
        }

        return false;
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                    // cylcle exist in one of the part
                }
            }
        }
        return false;
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    // gfg sol
    private boolean isCycleDfs(int u, List<List<Integer>> adj, boolean[] vis, int parent) {
        vis[u] = true;
        for (int v : adj.get(u)) {
            if (v == parent)
                continue;
            if (vis[v])
                return true;
            if (isCycleDfs(v, adj, vis, u))
                return true;
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        /*
         * steps ->
         * convert into graph check is vis and isCycle dfs
         * 
         * then in helper function check if v == parent then continue parent nahi hona
         * chahiye agar v visted hain to return true other wise check for isCycleDfs if
         * nothing satisfies then false;
         * 
         */
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected graph
        }

        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i] && isCycleDfs(i, adj, vis, -1))
                return true;
        }
        return false;
    }

    // using bfs

    private static class Pair {
         private int node;
         private int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    private static boolean isCycleBfsUtil(List<List<Integer>> adj, int u, Queue<Pair> q, boolean vis[]) {
        q.add(new Pair(u, -1));
        vis[u] = true;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (int v : adj.get(curr.node)) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(new Pair(v, curr.node));// curr.node

                } else if (v != curr.parent) {
                    return true;
                }
            }

        }

        return false;
    }

    public static boolean isCycleBfs(int edges[][], int V) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean vis[] = new boolean[V];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i] && isCycleBfsUtil(adj, i, q, vis)) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }

}
