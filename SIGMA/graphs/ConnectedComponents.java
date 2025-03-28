package graphs;

import java.util.*;

public class ConnectedComponents {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 0 -> vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        // 1 -> vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 -> verted
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 -> vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 -> vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));
    }
    public static void bfs(ArrayList<Edge>[] graph  ){
        boolean vis[] = new boolean[graph.length];

        for(int i = 0;i<graph.length;i++){
            if(!vis[i]){
                bfsUtil(graph, vis);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge>[] graph , boolean vis[]) { // o(n) -> o(v+e) || o(v^2) for matrix graph
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0); // src = 0
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {// visit curr
                System.out.print(curr + " ");
                vis[curr] = true;

                // for finding the neighbours of curr and add them in queue
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for(int i = 0 ;i<graph.length;i++){
            dfsUtil(graph, i, vis);
        }
    }
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis) {
        // visit the curr
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) { // dont check for curr because its already visited  , check for its neighbour
                dfsUtil(graph, e.dest, vis);
            }

        }

    }

    public static void main(String[] args) {

    }
}
