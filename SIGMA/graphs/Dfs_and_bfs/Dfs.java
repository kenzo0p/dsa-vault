package graphs.Dfs_and_bfs;

import java.util.*;

public class Dfs {
    private int v;
    private int e;
    private void dfs(int u , boolean vis[] , List<List<Integer>>adj){
        vis[u] = true;
        v++;
        e += adj.get(u).size();
        for(int v:adj.get(u)){
            if(!vis[v]){
                dfs(v , vis , adj);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int edge[]: edges){
            int u  = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean vis[] = new boolean[n];
        int comp = 0;
        for(int i = 0;i<n;i++){
            if(!vis[i]){
                v = 0;
                e = 0;
                dfs(i , vis,  adj);

                if(((v*(v-1)/2) )== (e/2)){ //edges and vertices count  its only possible if all vertice have connected edges invbetween them
                    comp++;
                }
            }
        }

        return comp;
    }
}

