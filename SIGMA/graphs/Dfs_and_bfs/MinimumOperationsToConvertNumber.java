package Dfs_and_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumOperationsToConvertNumber {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q = new LinkedList<>();
        int n = nums.length;
        boolean visited[] = new boolean[1000 + 1];
        q.add(start);
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int node = q.poll();

                if (node == goal) {
                    return ans;
                }
                if (node > 1000 || node < 0 || visited[node]) {
                    continue;
                }
                visited[node] = true; // why true no need to calculate again

                for (int i = 0; i < n; i++) {
                    int a = node + nums[i];
                    int b = node - nums[i];
                    int c = node ^ nums[i];
                    for (int j : new int[] { a, b, c }) {
                        q.add(j);
                    }
                }

            }
            ans++;
        }

        return -1;
    }

}
