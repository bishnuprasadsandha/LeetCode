class Solution {
    public double soupServings(int n) {
        if (n >= 5000) return 1.0; // Optimization for large values

        n = (n + 24) / 25; // Convert ml to units of 25ml

        double[][] dp = new double[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0.5;
                } else if (i == 0) {
                    dp[i][j] = 1.0;
                } else if (j == 0) {
                    dp[i][j] = 0.0;
                } else {
                    dp[i][j] = 0.25 * (
                        dp[Math.max(0, i - 4)][j] +
                        dp[Math.max(0, i - 3)][Math.max(0, j - 1)] +
                        dp[Math.max(0, i - 2)][Math.max(0, j - 2)] +
                        dp[Math.max(0, i - 1)][Math.max(0, j - 3)]
                    );
                }
            }
        }

        return dp[n][n];
    }
}
