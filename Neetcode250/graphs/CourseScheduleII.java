package Neetcode250.graphs;

import java.util.*;

public class CourseScheduleII {
    private boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int pre[] : prerequisites) {
            int a = pre[0];
            int b = pre[1];
            adj.get(b).add(a);
        }

        Stack<Integer> st = new Stack<>();
        boolean visited[] = new boolean[numCourses];
        boolean inRec[] = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(i, visited, inRec, st, adj);
            }
        }

        if (hasCycle) {
            return new int[] {};
        }

        int[] result = new int[st.size()];
        int i = 0;
        while (!st.isEmpty()) {
            result[i++] = st.pop();
        }
        return result;
    }

    private void dfs(int node, boolean visited[], boolean inRec[], Stack<Integer> st, List<List<Integer>> adj) {
        visited[node] = true;
        inRec[node] = true;
        for (int v : adj.get(node)) {
            if (inRec[v]) {
                hasCycle = true;
                return;
            }

            if (!visited[v]) {
                dfs(v, visited, inRec, st, adj);
            }
        }

        inRec[node] = false;
        st.push(node);
    }
}
