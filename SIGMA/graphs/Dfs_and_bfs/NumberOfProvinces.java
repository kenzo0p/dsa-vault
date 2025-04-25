package Dfs_and_bfs;

import java.util.ArrayList;
import java.util.List;

//leetcode 547

/*
 * Explaination
 * 
 * Jiska [i][j] == 1 wo ek dusre se connected hoga and we need to find those 
 * 
 * 
 */
public class NumberOfProvinces {
    private int n;

    private void dfs(List<List<Integer>> adj, int u, boolean vis[]) {
        vis[u] = true;

        // visit neighbours
        // find neighbours
        for (int v : adj.get(u)) {
            if (!vis[v]) {
                dfs(adj, v, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean vis[] = new boolean[n];

        // make the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(adj, i, vis);
            }
        }

        return count;

    }

    // another solution

    private int n;

    private void dfs(int isConnected[][], int u, boolean vis[]) {
        vis[u] = true;
        for (int col = 0; col < n; col++) {
            if (!vis[col] && isConnected[u][col] == 1 && u != col) { // col i.e v and index should not equal to col ->
                                                                     // if its equal then its pointing to its own node
                                                                     // or u
                dfs(isConnected, col, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        boolean vis[] = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(isConnected, i, vis);
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
