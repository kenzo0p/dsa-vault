package stronglyConnectedComponents;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajusAlgo {
    //The kosarajus algo is help to find the number of strongly connected conponents
    //TC -> 0(v+e)
    private void dfs(int u , ArrayList<ArrayList<Integer>>adjRev , boolean vis[]){
        vis[u] = true;
        for(int v : adjRev.get(u)){
            if(!vis[v]){
                dfs(v , adjRev , vis);
            }
        }
    }
    private void topSortDfsFill(int u , ArrayList<ArrayList<Integer>>adj  , boolean []visited , Stack<Integer>st){
        visited[u] = true;
        for(int v : adj.get(u)){
            if(!visited[v]){
                topSortDfsFill(v , adj ,visited , st);
            }
        }
        
        st.push(u);
    }
    
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        // step : 1 Storre order of dfs in stack
        int V = adj.size();
        Stack<Integer>st = new Stack<>();
        boolean visited[] = new boolean[V];
        for(int i = 0;i<V;i++){
            if(!visited[i]){
                topSortDfsFill(i , adj ,visited , st); // to fill the stack in topo order dfs
            }
        }
        
        //step 2 -> make a reverse graph
        ArrayList<ArrayList<Integer>>adjRev = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adjRev.add(new ArrayList<>());
        }
        for(int u = 0;u<V;u++){
            for(int v : adj.get(u)){
                adjRev.get(v).add(u);
            }
        }
        
        //step 3 -> call dfs based on stack order
        int countScc = 0;
        visited = new boolean[V];
        
        while(!st.isEmpty()){
            int node = st.pop();
            if(!visited[node]){
                dfs(node , adjRev , visited);
                countScc++;    
            }
        }
        
        return countScc;
        
    }
}
}
