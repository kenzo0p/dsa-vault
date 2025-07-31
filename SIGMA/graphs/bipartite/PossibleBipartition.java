package bipartite;
import java.util.*;
public class PossibleBipartition {
    private boolean bfsCheckBiPartite(int u, List<List<Integer>> adj, int color[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        color[u] = 1; //red
        //u - 1 v - 0
        //u - 0 v-1
        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int v : adj.get(curr)) {
                if (color[v] == color[curr]) {
                    return false;
                }

                if (color[v] == -1) {
                    q.add(v);
                    color[v] = 1 - color[curr];
                }
            }

        }

        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }

        for(int []vec  : dislikes){
            int u = vec[0];
            int v = vec[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int color[] = new int[n+1];
        Arrays.fill(color  , -1);
        Queue<Integer>q = new LinkedList<>();
        for(int i = 1;i<=n;i++){
            if(color[i] == -1){
                if(bfsCheckBiPartite(i , adj  , color) == false){
                    return false;
                }
            }
        }

        return true;

}
