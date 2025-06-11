package DSu;

import java.util.HashMap;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {

    /*
     * 2316. Count Unreachable Pairs of Nodes in an Undirected Graph
     * You are given an integer n. There is an undirected graph with n nodes,
     * numbered from 0 to n - 1. You are given a 2D integer array edges where
     * edges[i] = [ai, bi] denotes that there exists an undirected edge connecting
     * nodes ai and bi.
     * 
     * Return the number of pairs of different nodes that are unreachable from each
     * other.
     * 
     * 
     * Input: n = 3, edges = [[0,1],[0,2],[1,2]]
     * Output: 0
     * Explanation: There are no pairs of nodes that are unreachable from each
     * other. Therefore, we return 0.
     * 
     * 
     * Input: n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
     * Output: 14
     * Explanation: There are 14 pairs of nodes that are unreachable from each
     * other:
     * [[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6
     * ],[5,6]].
     * Therefore, we return 14.
     */


     private int find(int i , int parent[]){
        if(i== parent[i]){
            return i;
        }

        return parent[i] = find(parent[i], parent);
     }

     private void union(int x ,int y, int parent[] , int rank[]){
        int x_parent = find(x, parent);
        int y_parent =  find(y, parent);
        if(x_parent == y_parent){
            return;
        }
        
        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else if(rank[y_parent] > rank[x_parent]){
            parent[x_parent] = y_parent;
        }else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
     }
     public long countPairs(int n, int[][] edges) {
        int parent[] = new int[n];
        int rank[] = new int[n];

        for(int i = 0;i<n;i++){
            parent[i] = i;
            rank[i] = 0;
        }

        //step 2 -> make the components
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            union(u, v, parent, rank);
        }
        //step 3 make the map for storing parent(compo) -> size compo
        //put the  nodes in the value
        HashMap<Integer , Integer>map = new HashMap<>();
        for(int i = 0;i<n;i++){
            int papa_i = find(i , parent); //representative
            //parent is key and how many nodes in that are the values
            map.put(papa_i , map.getOrDefault(papa_i , 0)+1);
        }

        //step 4 find result from map
        long result = 0;
        long remaining_nodes = n;
        for(int k : map.keySet()){
            long size = map.get(k);
            result+=(size) * (remaining_nodes - size);
            remaining_nodes -=size;
        }

        return result;

    }

}
