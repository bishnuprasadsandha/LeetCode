class Solution {
    public double soupServings(int n) {
        if (n >= 5000) return 1.0;

        int N = (n + 24) / 25; 
        Double[][] memo = new Double[N + 1][N + 1];

        return helper(N, N, memo);
    }

    private double helper(int a, int b, Double[][] memo) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;
        if (memo[a][b] != null) return memo[a][b];

        memo[a][b] = 0.25 * (
            helper(a - 4, b, memo) +
            helper(a - 3, b - 1, memo) +
            helper(a - 2, b - 2, memo) +
            helper(a - 1, b - 3, memo)
        );

        return memo[a][b];
    }
}