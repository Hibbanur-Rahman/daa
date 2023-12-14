import java.util.Scanner;

public class OptimalBSTsAlgo {

    static final int MAX_KEYS = 10;

    // Function to calculate the cost of a binary search tree
    static int optimalBST(int[] keys, int[] freq, int n) {
        int[][] cost = new int[MAX_KEYS][MAX_KEYS];

        // Initialize cost matrix
        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
        }

        // Build the cost matrix
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                cost[i][j] = Integer.MAX_VALUE;

                // Try making all keys in the range [i, j] as the root and find the optimal cost
                for (int r = i; r <= j; r++) {
                    int c = ((r > i) ? cost[i][r - 1] : 0) +
                            ((r < j) ? cost[r + 1][j] : 0) + freq[r];

                    if (c < cost[i][j]) {
                        cost[i][j] = c;
                    }
                }
            }
        }

        return cost[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of keys: ");
        int n = scanner.nextInt();

        int[] keys = new int[MAX_KEYS];
        int[] freq = new int[MAX_KEYS];

        System.out.println("Enter the keys and their frequencies:");
        for (int i = 0; i < n; i++) {
            keys[i] = scanner.nextInt();
            freq[i] = scanner.nextInt();
        }

        // Calculate and print the optimal cost of the binary search tree
        int optimalCost = optimalBST(keys, freq, n);
        System.out.println("Optimal Cost of Binary Search Tree: " + optimalCost);

        scanner.close();
    }
}
