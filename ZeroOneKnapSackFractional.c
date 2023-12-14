#include <stdio.h> 
#define MAX_ITEMS 10
// Function to find the maximum of two integers
int max(int a, int b)
{
    return (a>b)?a:b;
}

// Function to solve the 0/1 Knapsack problem
int knapsack(int weights[], int values[], int n, int capacity)
{
    int dp[MAX_ITEMS + 1][capacity + 1];

    // Initialize the dp matrix
    for (int i = 0; i <= n; i++)
    {
        for (int w = 0; w <= capacity; w++)
        {
            if (i == 0 || w == 0)
            {
                dp[i][w] = 0;
            }
            else if (weights[i - 1] <= w)
            {
                dp[i][w] = max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
            }
            else
            {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }

    return dp[n][capacity];
}

int main()
{
    int n, capacity;

    // Get the number of items from the user 
    printf("Enter the number of items: "); 
    scanf("%d", &n);

    int weights[MAX_ITEMS];
    int values[MAX_ITEMS];

    // Get the weights and values of items from the user 
    printf("Enter the weights of items:\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &weights[i]);
    }

    printf("Enter the values of items:\n");
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &values[i]);
    }

    // Get the knapsack capacity from the user 
    printf("Enter the knapsack capacity: "); 
    scanf("%d", &capacity);
    // Calculate and print the maximum value that can be obtained 
    int maxValue = knapsack(weights, values, n, capacity); 
    printf("Maximum value that can be obtained: %d\n", maxValue);

    return 0;
}
