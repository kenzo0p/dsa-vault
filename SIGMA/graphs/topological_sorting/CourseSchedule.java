package topological_sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    private boolean topologicalSortCheck(List<List<Integer>> adj, int n, int indeg[]) {
        Queue<Integer> q = new LinkedList<>();
        int count = 0; // kitne node maine visit kiye hain
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                count++;
                q.add(i);
            }

        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    count++;
                    q.add(v);
                }
            }
        }

        if (count == n) { // I was able to visit all node (courses)
            return true;
        }

        return false; // there was a cycle and I couldnt complete courses

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int indeg[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int pre[] : prerequisites) {
            int a = pre[0];
            int b = pre[1];
            // b->a
            adj.get(b).add(a);
            // arrow ja raha hain a mein
            indeg[a]++;
        }

        // if cycle is present , not possible

        return topologicalSortCheck(adj, numCourses, indeg);

    }



    //using dfs

    private boolean dfsIsCycle(List<List<Integer>>adj , int u , boolean vis[] , boolean stack[]){
        vis[u] = true;
        stack[u] = true;
        for(int v : adj.get(u)){
            if(!vis[v] &&dfsIsCycle(adj , v , vis , stack) ){
                return true;
            }else if(stack[v] == true){
                return true;
            }
            
        }
        stack[u] = false;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj = new ArrayList<>();
        boolean stack[] = new boolean[numCourses];
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int pre[] :prerequisites ){
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
        }

        boolean vis[] = new boolean[numCourses];
        for(int i = 0;i<numCourses;i++){
            if(!vis[i] && dfsIsCycle(adj  , i , vis  , stack)){
                return false; //if cyclec then we cant complete the courses
            }
        }
        return true; //agar cycle nahi hain to we can complete it
    }



    
    public static void main(String[] args) {

    }
}