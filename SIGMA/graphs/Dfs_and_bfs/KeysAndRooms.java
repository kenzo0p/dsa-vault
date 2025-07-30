package Dfs_and_bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
    // explaination ->
    // https://leetcode.com/problems/keys-and-rooms/solutions/6886220/keys-and-rooms-simple-approach-using-dfs-9dyi/
    private void dfs(int u, int vis[], List<List<Integer>> rooms) {
        vis[u] = 1;
        for (int v : rooms.get(u)) {
            if (vis[v] == 0) {
                dfs(v, vis, rooms);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int V = rooms.size();
        int vis[] = new int[V];
        dfs(0, vis, rooms);
        for (int i = 0; i < vis.length; i++) {
            if (vis[i] == 0) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int u, boolean vis[], List<List<Integer>> rooms) {
        vis[u] = true;
        for (int v : rooms.get(u)) {
            if (!vis[v]) {
                dfs(v, vis, rooms);
            }
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int V = rooms.size();
        boolean vis[] = new boolean[V];
        dfs(0, vis, rooms);

        for (boolean room : vis) {
            if (room == false) {
                return false;
            }
        }

        return true;
    }


    //using bfs
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        boolean visRooms[] = new boolean[n];
        q.add(0);
        while (!q.isEmpty()) {
            int curr = q.poll();
            visRooms[curr] = true;

            for (int v : rooms.get(curr)) {
                if (!visRooms[v]) {
                    q.add(v);
                }
            }
        }

        for (boolean room : visRooms) {
            if (!room) {
                return false;
            }
        }

        return true;
    }
}
