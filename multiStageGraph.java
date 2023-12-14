import java.util.Scanner;

class multiStageGraph {

    static final int INF = Integer.MAX_VALUE;

    public static int shortestDist(int[][] graph, int N, int[] path) {
        int[] dist = new int[N];
        dist[N - 1] = 0;

        for (int i = N - 2; i >= 0; i--) {
            dist[i] = INF;
            for (int j = i; j < N; j++) {
                if (graph[i][j] == INF) {
                    continue;
                }
                int newDist = graph[i][j] + dist[j];
                if (newDist < dist[i]) {
                    dist[i] = newDist;
                    path[i] = j;
                }
            }
        }

        return dist[0];
    }

    public static void printShortestPath(int[] path, int start, int end) {
        System.out.print("Shortest path: " + start + " ");
        while (start != end) {
            System.out.print("-> " + path[start] + " ");
            start = path[start];
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of nodes in the graph: ");
        int N = scanner.nextInt();

        // Taking input for the graph adjacency matrix
        int[][] graph = new int[N][N];
        System.out.println("Enter the adjacency matrix (Enter " + INF + " for no edge):");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        // Array to store the shortest path
        int[] path = new int[N];

        // Calculate and output the shortest distance and path
        int shortestDistance = shortestDist(graph, N, path);
        System.out.println("Shortest distance from node 0 to " + (N - 1) + ": " + shortestDistance);

        // Print the shortest path
        printShortestPath(path, 0, N - 1);

        // Close the scanner
        scanner.close();
    }
}
