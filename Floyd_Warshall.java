public class Floyd_Warshall {
    static void floydWarshall(int[][] graph) {
        int V = graph.length;

        // Add all vertices one by one to
        // the set of intermediate vertices.
        for (int k = 0; k < V; k++) {

            // Pick all vertices as source one by one
            for (int i = 0; i < V; i++) {

                // Pick all vertices as destination
                // for the above picked source
                for (int j = 0; j < V; j++) {

                    // If vertex k is on the shortest path from
                    // i to j, then update the value of graph[i][j]

                    if ((graph[i][j] == -1 || 
                        graph[i][j] > (graph[i][k] + graph[k][j]))
                        && (graph[k][j] != -1 && graph[i][k] != -1))
                        graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 4, -1, 5, -1},
            {-1, 0, 1, -1, 6},
            {2, -1, 0, 3, -1},
            {-1, -1, 1, 0, 2},
            {1, -1, -1, 4, 0}
        };

        floydWarshall(graph);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}