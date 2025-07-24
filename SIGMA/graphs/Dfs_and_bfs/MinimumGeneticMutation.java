package Dfs_and_bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class MinimumGeneticMutation {
    class Solution {
        private char genes[] = {'A' , 'C' , 'G' , 'T'};
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String>q = new LinkedList<>();
        HashSet<String>validBank = new HashSet<>();
        for(String valid : bank){
            validBank.add(valid);
        }
        HashSet<String>vis = new HashSet<>();
        vis.add(startGene);
        q.add(startGene);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size -- > 0){
                String curr = q.poll();
                if(curr.equals(endGene)){
                    return level;// got the gene equal to the endGene
                }

                for(char gene : genes){
                    for(int i = 0;i<curr.length();i++){
                        char neigh[]= curr.toCharArray();
                        neigh[i] = gene;
                        String newStr = new String(neigh);
                        if(!vis.contains(newStr) && validBank.contains(newStr)){
                            vis.add(newStr);
                            q.add(newStr);
                        }
                    }
                }
            }

            level++;
        }

        return -1;
    }
    }
}
