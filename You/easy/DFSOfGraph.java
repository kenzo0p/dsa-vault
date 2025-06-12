package You.easy;

import java.util.ArrayList;

public class DFSOfGraph {
    private void dfs(int u ,boolean vis[] ,ArrayList<ArrayList<Integer>>adj , ArrayList<Integer>result){
        vis[u] = true;
        result.add(u);
        for(int V  :adj.get(u)){
            if(!vis[V]){
                dfs(V , vis  , adj , result);
            }
        }
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i<adj.size();i++){
            if(!vis[i]){
                dfs(i ,vis ,adj , result);
            }
        }
        
        
        return result;
    }
}
