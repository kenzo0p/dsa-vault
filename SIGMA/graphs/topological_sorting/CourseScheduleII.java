package topological_sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//vid 13
public class CourseScheduleII {

    /*
     * There are a total of numCourses courses you have to take, labeled from 0 to
     * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
     * [ai, bi] indicates that you must take course bi first if you want to take
     * course ai.
     * 
     * For example, the pair [0, 1], indicates that to take course 0 you have to
     * first take course 1.
     * Return the ordering of courses you should take to finish all courses. If
     * there are many valid answers, return any of them. If it is impossible to
     * finish all courses, return an empty array.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: [0,1]
     * Explanation: There are a total of 2 courses to take. To take course 1 you
     * should have finished course 0. So the correct course order is [0,1].
     * Example 2:
     * 
     * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * Output: [0,2,1,3]
     * Explanation: There are a total of 4 courses to take. To take course 3 you
     * should have finished both courses 1 and 2. Both courses 1 and 2 should be
     * taken after you finished course 0.
     * So one correct course order is [0,1,2,3]. Another correct ordering is
     * [0,2,1,3].
     * Example 3:
     * 
     * Input: numCourses = 1, prerequisites = []
     * Output: [0]
     * 
     * 
     * 
     */

    private int[] topologicalSort(List<List<Integer>> adj, int numCourses, int indeg[]) {
        Queue<Integer> q = new LinkedList<>();
        int result[] = new int[numCourses];
        int index = 0;

        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            result[index++] = u;

            for (int v : adj.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    q.add(v);
                }
            }
        }

        if (index == numCourses) {
            return result;
        } else {
            return new int[0]; // return empty array if cycle exists
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int indeg[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int pre[] : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
            indeg[u]++;
        }
        return topologicalSort(adj, numCourses, indeg);

    }

    // using dfs

    private boolean hasCycle;

    private void topologicalSortDFS(List<List<Integer>> adj, int u, boolean[] vis, Stack<Integer> st,
            boolean inRec[]) {
        vis[u] = true;
        inRec[u] = true;
        // pehle mere (u ke node ke ) bacho ko dalo stack mein
        for (int v : adj.get(u)) {
            if (inRec[v] == true) {
                hasCycle = true;
                return;
            }
            if (!vis[v]) {
                topologicalSortDFS(adj, v, vis, st, inRec);
            }
        }
        // ab muje dalo stack mein
        st.push(u);
        inRec[u] = false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean vis[] = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        boolean inRec[] = new boolean[numCourses];
        hasCycle = false;
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int pre[] : prerequisites) {
            int u = pre[0];
            int v = pre[1];

            // first b then a
            adj.get(v).add(u);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                topologicalSortDFS(adj, i, vis, stack, inRec);
            }
        }
        if (hasCycle) {
            return new int[0];
        }

        int result[] = new int[numCourses];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.peek();
            stack.pop();
        }

        return result;

    }

}
