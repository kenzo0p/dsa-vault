package graphs.Dfs_and_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {

    public void bfsHelper(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, ArrayList<Integer> result) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        result.add(node);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int neighbour : adj.get(u)) {
                if (!vis[neighbour]) {
                    q.add(neighbour);
                    vis[neighbour] = true;
                    result.add(neighbour);
                }
            }
        }
    }

    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[] = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();
        bfsHelper(adj, 0, vis, result);
        return result;
    }



    public static void main(String[] args) {

    }
}
