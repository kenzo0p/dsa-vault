package topological_sorting;
import java.util.*;

public class TopologicalSortUsingBfs {
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

    public static void calIndeg(ArrayList<Edge>graph[] ,int inDeg[]){
        for(int i = 0;i<graph.length;i++){
            int v = i;
            for(int j= 0;j<graph[v].size();j++){
                Edge e = graph[v].get(j);
                inDeg[e.dest]++;
            }
        }
    }

    public static void topologicalSortUsingBfs(ArrayList<Edge> graph[]) {
        int inDeg[] = new int[graph.length];
        calIndeg(graph,inDeg);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;
                if (inDeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }


    //gfg soln top sort using kahns algo (bfs)
    // jiska indeg 0 hoga usko pehle likhenge 0u->2v<-x0    xuv or uxv
    /*
     * example in book ->
     * adj list ->
     * o->2,3
     * 1->4
     * 2->3,1
     * 3->1,
     * 4
     * 5->1,4
     * 
     * indeg array -> [0,3,1,2,2,0]
     * 2-> put in queue jiski indeg 0 hogi
     * 3-> simple bfs 
     * 
     * 
     */
    
      
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer>result = new ArrayList<>();

        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int edge[] : edges){
            int from = edge[0];
            int to = edge[1];
            adj.get(from).add(to);
        }
        
        // step -> 1
        int indeg[] = new int[V];
        for(int u = 0;u<V;u++){
            for(int v : adj.get(u)){
                indeg[v]++;
            }
        }
        
        
        //step -> 2 fill the queue jiski indeg 0  hogi uska index
        Queue<Integer>q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        
        
        //step -> 3 simple bfs
        while(!q.isEmpty()){
            int u =  q.poll();
            result.add(u);
            for(int v : adj.get(u)){ //neighbours
                indeg[v]--;
                if(indeg[v] == 0){
                    q.add(v);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int v = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        topologicalSortUsingBfs(graph);
    }
}