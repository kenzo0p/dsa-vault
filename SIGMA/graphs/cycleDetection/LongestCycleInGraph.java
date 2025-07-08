package cycleDetection;

public class LongestCycleInGraph {

    private int result = -1;

    private void dfs(int u, int edges[], boolean vis[], int count[], boolean inRecursion[]) {
        if (u != -1) {
            vis[u] = true;
            inRecursion[u] = true;
            int v = edges[u];

            if (v != -1 && !vis[v]) {
                count[v] = count[u] + 1; // wo us node pe ja raha hain bhai to to badha de usko

                dfs(v, edges, vis, count, inRecursion);
            } else if (v != -1 && inRecursion[v] == true) { // cycle hain but inrecursion wala visited hona chahiye
                result = Math.max(result, count[u] - count[v] + 1);
            }

            inRecursion[u] = false;
        }
    }

    public int longestCycle(int[] edges) {
        int n = edges.length;

        boolean vis[] = new boolean[n];
        boolean inRecursion[] = new boolean[n];
        int count[] = new int[n];

        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, edges, vis, count, inRecursion);
            }
        }

        return result;
    }
}