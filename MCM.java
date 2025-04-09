import java.util.*;

public class MCM {
    static String mcm(int[] p, int n) {
        int[][] dp = new int[n][n];
        String[][] s = new String[n][n];
        
        for (int i = 0; i < n; i++) s[i][i] = "A" + i; // Base case: single matrix
        
        for (int len = 2; len < n; len++) {
            for (int i = 1; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        s[i][j] = "(" + s[i][k] + s[k + 1][j] + ")";
                    }
                }
            }
        }
        System.out.println("Minimum cost: " + dp[1][n - 1]);
        return s[1][n - 1]; // Return parenthesized expression
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of matrices
        int[] p = new int[n + 1]; // Dimensions array
        for (int i = 0; i <= n; i++) p[i] = sc.nextInt();
        System.out.println("Optimal parenthesization: " + mcm(p, n + 1));
    }
}
