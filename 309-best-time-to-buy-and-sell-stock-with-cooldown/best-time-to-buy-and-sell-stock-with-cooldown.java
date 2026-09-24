class Solution {
    private int n;
    private int dp[][];
    public int maxProfit(int[] prices) {
        n = prices.length;
        if(n ==1)return 0;
        dp = new int[n+1][2];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return solve(prices,0,1);
    }
    private int solve(int[] nums,int i,int j){
        if(i>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if( j==1){
            return dp[i][j] = Math.max(-nums[i] + solve(nums,i+1,0),solve(nums,i+1,1));
        }
        return dp[i][j] = Math.max(nums[i]+solve(nums,i+2,1),solve(nums,i+1,0));
    }
}
