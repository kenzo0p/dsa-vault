package DSu;




public class CycleDetectionUsingDSU {
    //google , amazon
    public static int find(int i, int[] parent) {
        if (i == parent[i]) {
            return i;
        }
        return parent[i] = find(parent[i], parent); // path compression
    }

    public static void union(int x, int y, int[] parent, int[] rank) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if (x_parent == y_parent) {
            return;
        }

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    public static boolean isCycle(int V, int[][] edges) {

        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int parent_u = find(u, parent);
            int parent_v = find(v, parent);

            if (parent_u == parent_v) {
                return true; // cycle found
            }
            //agar equal nahi hain to union kr denge
            union(u, v, parent, rank);
        }

        return false; // no cycle
    }
}

