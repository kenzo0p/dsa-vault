import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
        private void dfs(int node , int[][] graph ,List<List<Integer>>result , List<Integer>temp , int target ){
        temp.add(node);
        if(node  == target){
            result.add(new ArrayList<>(temp));
        }else {
            for(int v : graph[node] ){
                dfs(v , graph , result , temp , target);
            }

        }
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        int target  = n - 1;
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();

        dfs( 0 ,graph , result , temp , target);
        return result;
    }
}
