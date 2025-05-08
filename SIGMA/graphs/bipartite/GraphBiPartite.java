package graphs;

import java.util.*;

public class GraphBiPartite {

    // odd length cycle is not bipartitte
    // note* => if graph doesnt have cycles then its by default a bipartite only
    // even length cycle are bipartite
    //diving like questions
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(3, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

    }

    // tc o(v+e) -> o(v) sc
    public static boolean isBipartite(ArrayList<Edge> graph[]) {

        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { // bfs
                q.add(i);
                col[i] = 0; // yellow
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j);// e.dest
                        if (col[e.dest] == -1) {
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false; // not bipartite
                        }
                    }
                }
            }
        }
        return true;
    }


    //using dfs this is from gfg ->  go to the leetcode 785  for more change 
    private boolean checkBipartiteDfs(List<List<Integer>>adj , int u , int color[] , int currColor){
        color[u] = currColor;
        for(int v : adj.get(u)){
            if(color[v] == color[u]){
                return false;
            }
            if(color[v] ==-1){ //neven visisted (never colored)
                int colorV = 1- currColor;
                if(checkBipartiteDfs(adj  , v , color , colorV) == false){
                    return false;
                }
            }
        }
        
        return true;
        
        
    }
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        List<List<Integer>>adj = new ArrayList<>();
        for(int i  = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int color[] = new int[V];
        Arrays.fill(color , -1); // no node colored;
        for(int i = 0;i<V;i++){
            if(color[i] == -1){
                if(checkBipartiteDfs(adj , i , color , 1)== false){
                    return false;
                }
            }
        }
        
        
        return true;
        
        
    }
    //using bfs leetcode graph not edge
    private boolean checkBipartiteDfs(List<List<Integer>> adj, int curr, int color[], int currColor) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        color[curr] = currColor;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (color[v] == color[u]) {
                    return false;
                } else if (color[v] == -1) {
                    int colorV = 1 - color[u];
                    color[v] = colorV;
                    q.add(v);

                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int neighbour : graph[i]) {
                adj.get(i).add(neighbour);
            }
        }

        int color[] = new int[V];
        Arrays.fill(color, -1);
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (checkBipartiteDfs(adj, i, color, 1) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.print(isBipartite(graph));
    }

}
