package Neetcode250.graphs;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }
        List<String> result = new LinkedList<>();
        dfs("JFK", adj, result);
        return result;
    }

    private void dfs(String from, Map<String, PriorityQueue<String>> adj, List<String> result) {
        PriorityQueue<String> dests = adj.get(from);
        while (dests != null && !dests.isEmpty()) {
            dfs(dests.poll(), adj, result);
        }

        result.addFirst(from);
    }

    public static void main(String[] args) {

    }

}
