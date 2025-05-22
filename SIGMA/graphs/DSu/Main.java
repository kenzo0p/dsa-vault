package graphs.DSu;

import java.util.ArrayList;

public class Main {

    // Notes find function and union
    // DSU BY path compression and rank next vid
    public static int find(int i, int[] parent) {
        if (i == parent[i]) {
            return i;
        }

        return parent[i] = find(parent[i], parent);
    }

    public static void union(int x, int y, int[] parent, int rank[]) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if (x_parent == y_parent) {
            return;
        }

        if (rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        } else if (rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        } else {// if rank is same then kisiko bhi papa bana dooo
            parent[x_parent] = y_parent;
        }
    }

}
