package DP.Linear

import java.util.Arrays;
import java.util.HashSet;

-dp;

public class MinimumCostsForTickets {
    private int solve(int i, int n, int days[], int costs[], int t[]) {
        if (i >= n)
            return 0; // You cant traver , so cost is 0

        if (t[i] != -1) {
            return t[i];
        }
        // day 1 pass
        int cost_1 = costs[0] + solve(i + 1, n, days, costs, t);

        // day 7 pass
        int j = i;
        int max_day = days[i] + 7;
        while (j < n && days[j] < max_day) {
            j++;
        }

        int cost_7 = costs[1] + solve(j, n, days, costs, t);

        // day 30 pass
        j = i;
        max_day = days[j] + 30;
        while (j < n && days[i] < max_day) {
            j++;
        }

        int cost_30 = costs[2] + solve(j, n, days, costs, t);

        return t[i] = Math.min(cost_1, Math.min(cost_7, cost_30));

    }

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int t[] = new int[n + 1];
        Arrays.fill(t, -1);
        return solve(0, n, days, costs, t);

    }

    // using bottom up

    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            int n = days.length;
            int last_day = days[n - 1];
            HashSet<Integer> set = new HashSet<>(); // to store the valid days
            int t[] = new int[last_day + 1];// to store the minimum cost
            for (int day : days) {
                set.add(day);
            }

            for (int i = 1; i <= last_day; i++) {
                // check if you have to travel on ith day or not
                if (!set.contains(i)) {
                    t[i] = t[i - 1];
                } else {

                    t[i] = Integer.MAX_VALUE;
                    int day_1_pass = costs[0] + t[Math.max(i - 1, 0)];
                    int day_7_pass = costs[1] + t[Math.max(i - 7, 0)];
                    int day_30_pass = costs[2] + t[Math.max(i - 30, 0)];

                    t[i] = Math.min(day_1_pass, Math.min(day_7_pass, day_30_pass));

                }
            }

            return t[last_day];
        }
    }
}
