package bipartite;
import java.util.*;
public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n , int redEdges[][] , int [][] blueEdges){
        // Step1 -> create a adj list of type int[] as we want node and color
        List<List<int[]>>adj= new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        //Step 2 ->  merge into one list redEdges and blueEdges
        for(int red[] : redEdges){
            int a = red[0];
            int b = red[1];
            adj.get(a).add(new int[]{b , 0});//red color => 0
        }
        for(int blue[] : blueEdges){
            int a = blue[0];
            int b = blue[1];
            adj.get(a).add(new int[]{b , 1});//blue color => 1
        }

        //create a queue for node , steps , prevColor
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{0 ,0, -1});
        boolean vis[][] = new boolean[n][2];
        //we have already visited node 0 via red and blue
        vis[0][0] = vis[0][1] = true;

        int result[] = new int[n];
        Arrays.fill(result , -1);
        result[0] = 0;
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int node = curr[0];
            int steps = curr[1];
            int prevColor = curr[2];

            for(int edge[] : adj.get(node)){
                int neighbour = edge[0];
                int color = edge[1];
                
                // if not visited the visit it add in q and steps+1
                if(!vis[neighbour][color] && prevColor != color){
                    vis[neighbour][color] =true;
                    q.offer(new int[]{neighbour , steps+1 , color});
                    if(result[neighbour] == -1){
                        result[neighbour] = steps + 1;
                    }
                }
            }
        }

        return result;
    }
}
