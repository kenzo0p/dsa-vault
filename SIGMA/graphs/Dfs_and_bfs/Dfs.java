package graphs.Dfs_and_bfs;

import java.util.*;

public class Dfs {

    public static void helper(ArrayList<ArrayList<Integer>> adj, int node, ArrayList<Integer> list, boolean[] vis) {
        vis[node] = true;
        list.add(node);
        for (int neighbours : adj.get(node)) {
            if (!vis[neighbours]) {
                helper(adj, neighbours, list, vis);
            }
        }
    }

    // Function to return a list containing the DFS traversal of the graph.
    
    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> list = new ArrayList<>();
        boolean vis[] = new boolean[adj.size()];
        helper(adj, 0, list, vis);
        return list;
    }

    public static void main(String[]args){

    }

}
