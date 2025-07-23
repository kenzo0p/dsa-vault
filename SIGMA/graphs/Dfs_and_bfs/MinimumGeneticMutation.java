package Dfs_and_bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class MinimumGeneticMutation {
    class Solution {
        private char[] genes = { 'A', 'C', 'G', 'T' };

        public int minMutation(String startGene, String endGene, String[] bank) {
            HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank)); // quick access

            HashSet<String> vis = new HashSet<>();
            Queue<String> q = new LinkedList<>();
            vis.add(startGene);
            q.add(startGene);
            int level = 0;
            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    String curr = q.poll();
                    if (curr.equals(endGene))
                        return level; // we have reached the target

                    for (char ch : genes) {
                        for (int i = 0; i < curr.length(); i++) {
                            char neigh[] = curr.toCharArray();
                            neigh[i] = ch; // first try with 'A' then 'C' then 'G' then 'T'
                            String newStr = new String(neigh);
                            if (!vis.contains(newStr) && bankSet.contains(newStr)) {
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
