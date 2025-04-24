package cycleDetection;
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



    //gfg soln

    private boolean isCycleDfs(List<List<Integer>>adj , int u , boolean[]vis , boolean[]stack){
        vis[u] = true; 
        stack[u] = true; 
        
        for(int v : adj.get(u)){
            //if not visited , then we check for cycle in dfs
            if(vis[v] == false && isCycleDfs(adj , v , vis , stack)){
                return true;
            }else if (stack[v] == true){
                return true;
            }
            
        }
        stack[u] = false;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        List<List<Integer>>adj = new ArrayList<>();
        
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int edge[] : edges){
            int from = edge[0];
            int to = edge[1];
            adj.get(from).add(to); // directed graph
        }
        // code here
        boolean vis[] = new boolean[V];
        boolean stack[] = new boolean[V];
        for(int i = 0;i<V;i++){
           if(!vis[i] && isCycleDfs(adj , i, vis,stack )) {
               return true;
           }
        }
        return false;
    }



    //using bfs using top sort kahns algo agar top sort nahi hota to return true otherwise false  vid -9


    public boolean isCyclicUsingTopSortKahnsAlgo(int V, int[][] edges) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[] : edges){
            int from  = edge[0];
            int to = edge[1];
            adj.get(from).add(to);
        }
        
        
        //fill the indeg
        int inDeg[] = new int[V];
        for(int u = 0;u<V;u++){
            for(int v : adj.get(u)){
                inDeg[v]++;
            }
        }
        
        int count = 0;
        Queue<Integer>q = new LinkedList<>();
        //fill the queue
        for(int i = 0;i<V;i++){
            if(inDeg[i] == 0){
                q.add(i);
                count++;
            }
        }
        
        //3 simple bfs
        
        while(!q.isEmpty()){
            int u = q.remove();
            for(int v : adj.get(u)){
                inDeg[v]--;
                if(inDeg[v] == 0){
                    q.add(v);
                    count++;
                }
            }
        }
        
        if(count == V){ //mtlb we visited all nodes  , mtlb no cycle
            return false;
        }
        return true;
    }
    

    public static void main(String[] args) {
        int v = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>graph[] = new ArrayList[v];
        createGraph(graph);
        System.out.println(isCylce(graph));
    }
}