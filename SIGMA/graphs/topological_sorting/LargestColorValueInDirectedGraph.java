package topological_sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LargestColorValueInDirectedGraph {
    //Watch again the code
        public int largestPathValue(String colors, int[][] edges) {
        int N = colors.length();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[N];
        
        // Build the graph and indegree array
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[][] t = new int[N][26];  // to keep max count of each color per node

        // Initialize the queue with nodes with 0 indegree
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                t[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int answer = 0;
        int countNodes = 0;

        // Kahn's algorithm for topological sort
        while (!queue.isEmpty()) {
            int u = queue.poll();
            countNodes++;

            for (int i = 0; i < 26; i++) {
                answer = Math.max(answer, t[u][i]);
            }

            List<Integer> neighbors = adj.getOrDefault(u, new ArrayList<>());
            for (int v : neighbors) {
                for (int i = 0; i < 26; i++) {
                    int val = t[u][i] + (colors.charAt(v) - 'a' == i ? 1 : 0);
                    t[v][i] = Math.max(t[v][i], val);
                }

                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return countNodes < N ? -1 : answer;
    }
}
