import java.util.*;

public class CycleDetectionDirectedGraph {
    static class Edge {
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    public static void createGraph(ArrayList<Edge>graph[]){ //true
        for(int i = 0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge( 0 , 2));
        graph[1].add(new Edge( 1 , 0));
        graph[2].add(new Edge( 2 , 3));
        graph[3].add(new Edge( 3 , 0));
    }

    public static boolean isCylce(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (isCylceUtil(graph, i, vis, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCylceUtil(ArrayList<Edge> graph[], int curr, boolean vis[], boolean[] stack) {
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dest]) { // cycle
                return true;
            }
            if (!vis[e.dest] && isCylceUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(isCylce(graph));
    }
}