class Solution {
    private int n;
    private int m;
    private int dp[][];
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n+1][m+1];
        for(int i[] : dp){
            
            Arrays.fill(i,-1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                ans = Math.max(ans, solve(matrix, i, j));
            }
        }
        return ans;
    }
    private int solve(int[][] matrix,int i,int j){
        if(dp[i][j]!=-1)return dp[i][j];
        int ans = 1;
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            ans = Math.max(ans,
                    1 + solve(matrix, i , j-1));
        }
        if (j < m - 1 && matrix[i][j + 1] > matrix[i][j]) {
            ans = Math.max(ans,
                    1 + solve(matrix, i, j+1));
        }
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
           ans = Math.max(ans,
                    1 + solve(matrix, i - 1, j));
        }

        if (i < n - 1 && matrix[i + 1][j] > matrix[i][j]) {
            ans = Math.max(ans,
                    1 + solve(matrix, i + 1, j));
        }
        return dp[i][j] = ans;
    }
}
