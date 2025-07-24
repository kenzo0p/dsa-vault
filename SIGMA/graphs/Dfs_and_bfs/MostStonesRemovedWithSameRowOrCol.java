package Dfs_and_bfs;

public class MostStonesRemovedWithSameRowOrCol {
    class Solution {
    // | s |  | s |
    // |   |s |   |
    // | s |  | s |

    // Gang wali problem in stones
    // har gang mein sirf ek stone bachega  marte marte ek hi bachega
    // 

    private void dfs(int u,  boolean vis[] , int stones[][]){
        vis[u] = true;

        for(int i = 0;i<stones.length;i++){
            int r = stones[u][0];
            int c = stones[u][1];
            //yato row same hona chahiye yato col
            if(!vis[i] && (stones[i][0] == r ||  stones[i][1] == c)){
                dfs(i , vis, stones);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean vis[] =new boolean[n];
        int groups = 0;
        for(int i = 0;i<n;i++){
            if(vis[i] == true){
                continue;
            }
            dfs(i , vis , stones);
            groups++;
        }

        return n -  groups;//jitne groups honge usme se stone delete karenge to ans aayega
    }
}
}
