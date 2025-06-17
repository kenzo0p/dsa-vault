package PrimsAlgo;

import java.util.*;

public class PrimsAlgoMST {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int c) {
            this.v = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void prims(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int finalCost = 0; // MST cost /total min weight
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                finalCost += curr.cost;
                // add the neighbors in pq
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.println("Final cost of mst is : " + finalCost);

    }

    // gfg solution
    //Tc -> 0(e*2*logE) -> o(eloge)
    // int this question we just want sum not parent so onlyad node and weight in pq
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.

        // min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, 0 }); // weight , node
        boolean inMst[] = new boolean[V];
        int sum = 0;
        while (!pq.isEmpty()) {
            int curr[] = pq.poll();

            int wt = curr[0];
            int node = curr[1];

            //if the node is already visited no need to ge there because its undirected graph remember we cant go back that is already  visited
            if (inMst[node] == true) {
                continue;
            }

            inMst[node] = true; // added to our minimum spannng tree
            sum += wt;

            for (int neigh[] : adj.get(node)) {
                int v = neigh[0];
                int wt_v = neigh[1];

                if (inMst[v] == false) {
                    pq.offer(new int[] { wt_v, v });
                }

            }

        }

        return sum;

    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        prims(graph);
    }
}