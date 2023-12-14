import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static boolean isSafe(int wt[], int w, int n, int capacity, int currentWeight) {
        return (currentWeight + wt[w] <= capacity);
    }

    static void knapsackUtil(int wt[], int val[], int n, int capacity, int currentWeight, int currentValue,
            boolean selected[], boolean currentSelected[], int[] maxValue, boolean[] finalSelected) {
        if (currentWeight == capacity || n == -1) {
            if (currentValue > maxValue[0]) {
                maxValue[0] = currentValue;
                System.arraycopy(currentSelected, 0, finalSelected, 0, n + 2);
            }
            return;
        }

        currentSelected[n] = true;
        if (isSafe(wt, n, n, capacity, currentWeight + wt[n])) {
            knapsackUtil(wt, val, n - 1, capacity, currentWeight + wt[n],
                    currentValue + val[n], selected, currentSelected, maxValue, finalSelected);
        }

        currentSelected[n] = false;
        knapsackUtil(wt, val, n - 1, capacity, currentWeight, currentValue,
                selected, currentSelected, maxValue, finalSelected);
    }

    static void knapsack(int wt[], int val[], int n, int capacity) {
        boolean selected[] = new boolean[Knapsack.MAX_ITEMS];
        boolean currentSelected[] = new boolean[Knapsack.MAX_ITEMS];
        boolean finalSelected[] = new boolean[Knapsack.MAX_ITEMS];
        int[] maxValue = { 0 };

        knapsackUtil(wt, val, n - 1, capacity, 0, 0, selected, currentSelected, maxValue, finalSelected);

        System.out.println("Selected items for maximum value:");
        for (int i = 0; i < n; i++) {
            if (finalSelected[i]) {
                System.out.println("Item " + (i + 1));
            }
        }

        System.out.println("Maximum value: " + maxValue[0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int wt[] = new int[Knapsack.MAX_ITEMS];
        int val[] = new int[Knapsack.MAX_ITEMS];

        System.out.println("Enter the weights of the items:");
        for (int i = 0; i < n; i++)
            wt[i] = scanner.nextInt();

        System.out.println("Enter the values of the items:");
        for (int i = 0; i < n; i++)
            val[i] = scanner.nextInt();

        System.out.print("Enter the capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        Knapsack.knapsack(wt, val, n, capacity);

        scanner.close();
    }

    static final int MAX_ITEMS = 20;
}
