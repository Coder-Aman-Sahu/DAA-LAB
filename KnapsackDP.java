public class KnapsackDP {
    public static int knapsack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) 
            for (int w = 0; w <= W; w++)
                dp[i][w] = wt[i - 1] <= w ? Math.max(val[i - 1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]) : dp[i - 1][w];
        return dp[n][W];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), W = sc.nextInt();
        int[] val = new int[n], wt = new int[n];
        for (int i = 0; i < n; i++) val[i] = sc.nextInt();
        for (int i = 0; i < n; i++) wt[i] = sc.nextInt();
        System.out.println("Maximum value: " + knapsack(W, wt, val, n));
    }
}
