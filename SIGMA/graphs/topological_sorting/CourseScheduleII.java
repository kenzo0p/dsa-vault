package topological_sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

//vid 13
public class CourseScheduleII {

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



    //using dfs

      private boolean hasCycle;

    private void topologicalSortDFS(List<List<Integer>> adj, int u, boolean[] vis, Stack<Integer> st,
            boolean inRec[]) {
        vis[u] = true;
        inRec[u] = true;
        //pehle mere (u ke node ke ) bacho ko dalo stack mein
        for (int v : adj.get(u)) {
            if (inRec[v] == true) {
                hasCycle = true;
                return;
            }
            if (!vis[v]) {
                topologicalSortDFS(adj, v, vis, st, inRec);
            }
        }
        //ab muje dalo stack mein
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

            //first b then a
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
