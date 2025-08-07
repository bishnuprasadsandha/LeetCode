class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;

        int dp[] [] = new int [n] [n];

        int ans =0;

        for(int i =0; i < n; i++){
            ans += fruits[i][i];
        }

        dp[0][n-1] = fruits[0][n - 1];
        for(int row = 1; row < n-1; row++){
            for(int col = n-1; col >= n - row - 1; col--){
                if(row == col)
                break;

                int max= dp[row - 1][col];
                if(col - 1 >= 0){
                    max = Math.max(max, dp [row-1][col -1]);
                }
                if(col + 1 < n){
                    max = Math.max(max,dp[row-1][col + 1]);
                }

                dp[row][col] = max + fruits[row][col];
            }
        }
        ans +=dp[n -2][n - 1];


        dp[n-1][0] = fruits[n - 1][0];
          for(int col = 1; col < n-1; col++){
            for(int row = n-1; row >= n - col - 1; row--){
                if(row == col)
                break;

                int max= dp[row][col - 1];
                if(row - 1 >= 0){
                    max = Math.max(max, dp [row-1][col -1]);
                }
                if(row + 1 < n){
                    max = Math.max(max,dp[row + 1][col - 1]);
                }

                dp[row][col] = max + fruits[row][col];
            }
        }
        ans +=dp[n -1][n - 2];

        return ans; 
    }
}