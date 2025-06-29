package Dfs_and_bfs;

import java.util.List;

public class KeysAndRooms {
    //explaination -> https://leetcode.com/problems/keys-and-rooms/solutions/6886220/keys-and-rooms-simple-approach-using-dfs-9dyi/
    private void dfs(int u , int vis[] , List<List<Integer>>rooms){
        vis[u] = 1;
        for(int v : rooms.get(u)){
            if(vis[v] == 0){
                dfs(v, vis, rooms);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int V = rooms.size();
        int vis[] = new int[V];
        dfs(0 , vis , rooms);
        for(int i = 0;i<vis.length;i++){
            if(vis[i] == 0){
                return false;
            }
        }

        return true;
    }





       private void dfs(int u, boolean vis[] , List<List<Integer>>rooms){
        vis[u] = true;
        for(int v : rooms.get(u)){
            if(!vis[v]){
                dfs(v ,vis , rooms);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int V = rooms.size();
        boolean vis[] = new boolean[V];
        dfs(0 , vis , rooms);

        for(boolean room : vis){
            if(room == false){
                return false;
            }
        }

        return true;
    }
}
