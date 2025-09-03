import java.util.ArrayList;
import java.util.List;

public class NumberofNodesIntheSubTreeWiththeSameLabel {

    private void dfs(List<List<Integer>> adj, int currNode, int parent, int result[], String labels, int count[]) {
        char myLabel = labels.charAt(currNode);
        int count_before_visiting_curr_children = count[myLabel - 'a'];
        // Now i will explore
        count[myLabel - 'a'] += 1;
        for (int childNode : adj.get(currNode)) {
            if (childNode == parent) {
                continue;
            }

            dfs(adj, childNode, currNode, result, labels, count);
        }

        // waqt aagaya hain after wala varible likhne ka
        // curr and uska children
        int count_after_visiting_curr_children = count[myLabel - 'a'];
        result[currNode] = count_after_visiting_curr_children - count_before_visiting_curr_children;
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] result = new int[n];
        int count[] = new int[26]; // small letters

        dfs(adj, 0, -1, result, labels, count);

        return result;
    }
}