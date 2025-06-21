package graphs.Dfs_and_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

//Approach (Using BFS)
//T.C : O(V+E)
//S.C : O(V+E)
public class FindMinimumDiameterAfterMergingTwoTrees {
    private HashMap<Integer, List<Integer>> buildAdj(int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int edge[] : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        return adj;
    }

    private int findDiameter(HashMap<Integer, List<Integer>> adj) {
        // First BFS to find the farthest node from any arbitrary node (e.g., 0)
        List<Integer> farthestNode = BFS(adj, 0);

        // Second BFS from the farthest node to determine the diameter
        farthestNode = BFS(adj, farthestNode.get(0));
        return farthestNode.get(1);

    }

    private List<Integer> BFS(HashMap<Integer, List<Integer>> adj, int sourceNode) {
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Boolean> vis = new HashMap<>();

        // push the source node in the queue
        q.add(sourceNode);
        vis.put(sourceNode, true);
        int maxDistance = 0, farthestNode = sourceNode;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int currentNode = q.poll();
                // update farthest node

                farthestNode = currentNode;

                for (int neigh : adj.getOrDefault(currentNode, new ArrayList<>())) {
                    if (!vis.getOrDefault(neigh, false)) {
                        vis.put(neigh, true);
                        q.add(neigh);
                    }
                }
            }

            if (!q.isEmpty()) {
                maxDistance++;
            }
        }

        return Arrays.asList(farthestNode, maxDistance);
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        HashMap<Integer, List<Integer>> adj1 = buildAdj(edges1);
        HashMap<Integer, List<Integer>> adj2 = buildAdj(edges2);

        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);
        int combined = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;
        return Math.max(combined, Math.max(d1, d2));
    }
}
