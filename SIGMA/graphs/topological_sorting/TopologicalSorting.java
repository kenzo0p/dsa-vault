package topological_sorting;
import java.util.*;

public class TopologicalSorting {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topologicalSortUtil(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                topologicalSortUtil(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void topologicalSort(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                topologicalSortUtil(graph, i, vis, s); // modified dfs function
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }

    }

    // gfg
    // top sort using dfs
    /*
     * topological sorting is only possible in directed acyclic graph (DAG) vid -> 7
     * 
     *  1 -> 2 -> 3 ans => 1,2,3 ✅ 2,1,3 ❌
     * 
     *  u <-> v not possible beacuse of cycle
     *  
     * u-> v  u,v
     * 
     * v ko dalo then u in stack 
     * pehele mere bacho ko dalo fir muje stack mein dalo
     * 
     */
    private static void topSortUtil(List<List<Integer>> adj, int u, boolean vis[], Stack<Integer> st) {
        vis[u] = true;

        // pehele mere (u ke node ke) bacho ko dalo
        for (int v : adj.get(u)) {
            if (!vis[v]) {
                topSortUtil(adj, v, vis, st);
            }
        }
        // fir muje dal0
        st.push(u);
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }


        //directed grpah
        for (int edge[] : edges) {
            int from = edge[0];
            int to = edge[1];
            adj.get(from).add(to);
        }
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topSortUtil(adj, i, vis, st);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!st.isEmpty()) {
            result.add(st.pop());
        }

        return result;
    }
    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        topologicalSort(graph);
    }
}
