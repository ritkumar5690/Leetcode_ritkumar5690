class Solution {
    private int n;
    private int arr[];
    private int dp[][];
    public int maxCoins(int[] nums) {
        n = nums.length;
        if(n == 1) return nums[0];
        arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        dp = new int[n+2][n+2];
        for(int i[] :dp){
           Arrays.fill(i,-1);
        }
        return solve(1,n);
    }
    private int solve(int i ,int j){
        if(i > j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = 0;
        for(int k = i;k<=j;k++){
            int coins = solve(i,k-1)+solve(k+1,j) + arr[i-1] * arr[k] * arr[j+1];
            ans = Math.max(ans,coins);
        }
        return dp[i][j] = ans;
    }
}
