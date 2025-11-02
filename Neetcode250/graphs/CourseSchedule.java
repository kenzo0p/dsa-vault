package Neetcode250.graphs;

import java.util.*;

public class CourseSchedule {
    /*
     * 207. Course Schedule
     * Solved
     * Medium
     * Topics
     * premium lock icon
     * Companies
     * Hint
     * There are a total of numCourses courses you have to take, labeled from 0 to
     * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
     * [ai, bi] indicates that you must take course bi first if you want to take
     * course ai.
     * 
     * For example, the pair [0, 1], indicates that to take course 0 you have to
     * first take course 1.
     * Return true if you can finish all courses. Otherwise, return false.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     * 
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you
     * should also have finished course 1. So it is impossible.
     * 
     * 
     * Constraints:
     * 
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * All the pairs prerequisites[i] are unique.
     * 
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int pre[] : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            adj.get(b).add(a);
        }

        boolean visited[] = new boolean[numCourses];
        boolean inRec[] = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && dfs(i, inRec, visited, adj)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, boolean inRec[], boolean visited[], List<List<Integer>> adj) {
        visited[node] = true;
        inRec[node] = true;
        for (int v : adj.get(node)) {
            if (!visited[v] && dfs(v, inRec, visited, adj)) {
                return true;
            } else if (inRec[v] == true) {
                return true;
            }
        }

        inRec[node] = false;
        return false;
    }
}
