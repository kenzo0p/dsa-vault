package graphs.Euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidArrangementsOfPairs {
    // Hierholzers Algorithm
    /*
     * step 1 -> Build adjancy list -> graph banao
     * build indeg and outdeg
     * find the startNde of eulerpath
     * 
     * List<Integer>EulerPath
     */

    public int[][] validArrangement(int[][] pairs) {
        // Step 1: Build adjacency list using HashMap instead of List
        Map<Integer, List<Integer>> adj = new HashMap<>();

        // Build indegree and outdegree maps
        Map<Integer, Integer> indeg = new HashMap<>();
        Map<Integer, Integer> outdeg = new HashMap<>();

        // Process each edge
        for (int[] edge : pairs) {
            int u = edge[0];
            int v = edge[1];

            // Add to adjacency list
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);

            // Update degrees
            outdeg.put(u, outdeg.getOrDefault(u, 0) + 1);
            indeg.put(v, indeg.getOrDefault(v, 0) + 1);
        }

        // Find the start node for Euler path
        int startNode = pairs[0][0]; // default start

        // Look for a node with outdegree - indegree = 1
        for (int node : outdeg.keySet()) {
            if (outdeg.getOrDefault(node, 0) - indeg.getOrDefault(node, 0) == 1) {
                startNode = node;
                break;
            }
        }

        // Hierholzer's algorithm to find Eulerian path
        List<Integer> eulerPath = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {
            int curr = stack.peek();

            // If current node has outgoing edges
            if (adj.containsKey(curr) && !adj.get(curr).isEmpty()) {
                int next = adj.get(curr).remove(adj.get(curr).size() - 1);
                stack.push(next);
            } else {
                // No more outgoing edges, add to path
                eulerPath.add(stack.pop());
            }
        }

        // Build result array
        int[][] result = new int[eulerPath.size() - 1][2];
        Collections.reverse(eulerPath);

        for (int i = 0; i < eulerPath.size() - 1; i++) {
            result[i][0] = eulerPath.get(i);
            result[i][1] = eulerPath.get(i + 1);
        }

        return result;
    }
}
