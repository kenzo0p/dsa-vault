import java.util.ArrayList;
import java.util.List;

public class SumOfDistanceOfTree {
    /*
     * child_ans = parent_and - x + (n -x)
     * where x is minus karne se kitne aaye i.e child_of_child_node including child
     * 
     */
    long root_result = 0;
    int N;
    int count[];

    private int dfsRoot(List<List<Integer>> adj, int curr_node, int prev_node, int curr_depth) {
        int tot_count = 1;

        root_result += curr_depth;
        for (int child : adj.get(curr_node)) {
            if (child == prev_node) {
                continue;
            }
            tot_count += dfsRoot(adj, child, curr_node, curr_depth + 1);
        }
        count[curr_node] = tot_count;
        return tot_count;
    }

    private void dfs(List<List<Integer>> adj, int parent_node, int prev_node, int result[]) {
        for (int child : adj.get(parent_node)) {
            if (child == prev_node) {
                continue;
            }

            result[child] = result[parent_node] - count[child] + (N - count[child]);
            dfs(adj, child, parent_node, result);
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        count = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        root_result = 0;
        dfsRoot(adj, 0, -1, 0);

        int result[] = new int[n];
        result[0] = (int) root_result;
        dfs(adj, 0, -1, result);
        return result;
    }

    public static void main(String[] args) {

    }
}
