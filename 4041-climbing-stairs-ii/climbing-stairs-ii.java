class Solution {
    private int n;
    private int dp[];
    public int climbStairs(int n, int[] costs) {
        this.n = costs.length;
        dp = new int[n+3];
        return solve(costs);
    }

    private int solve(int[] cost) {
       for (int i = n - 1; i >= 0; i--){
            dp[i] = cost[i] + 1 + dp[i + 1];

            if (i + 1 < n) {
                dp[i] = Math.min(
                    dp[i],
                    cost[i + 1] + 4 + dp[i + 2]
                );
            }

            if (i + 2 < n) {
                dp[i] = Math.min(
                    dp[i],
                    cost[i + 2] + 9 + dp[i + 3]
                );
            }
        }
        return dp[0];

    }
}