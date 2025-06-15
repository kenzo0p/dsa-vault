package FloydsWarshallAlgo;

public class Main {
    // in this algo we have to go through all nodes and need to calculate the dist
    // from every node
    public void floydWarshall(int[][] dist) {
        // Code here
        int V = dist.length;

        for (int via = 0; via < V; via++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][via] < 1e8 && dist[via][j] < 1e8) {
                        dist[i][j] = Math.min(dist[i][via] + dist[via][j], dist[i][j]);
                    }
                }
            }
        }
    }
}
