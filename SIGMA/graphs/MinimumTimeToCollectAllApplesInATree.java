package SIGMA.graphs;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {
    class Solution {
    /*
        pehle to graph bana lo
        dfs(adj , 0 , -1 , hasApple)
        time = 0
            for(int child: adj.get(curr)){
                if(child == parent){
                    continue;
                }

                int time_from_child = dfs(adj , child , curr , hasApple);
                if(time_from_child > 0 ||hadhApple[child] == true){
                    time += time_from_child+2;
                }

             retun time;   
     */

     //o(v+e)
    private int dfs(List<List<Integer>>adj , int curr , int parent , List<Boolean>hasApple){
        int time = 0;
        for(int child : adj.get(curr)){
            if(child == parent) continue;

            int time_from_my_child = dfs(adj , child  , curr , hasApple);
            if(time_from_my_child > 0 || hasApple.get(child)){
                time +=time_from_my_child + 2;
            }
        }

        return time;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int e[] :edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(adj , 0 , -1 , hasApple);


    }
}
}
