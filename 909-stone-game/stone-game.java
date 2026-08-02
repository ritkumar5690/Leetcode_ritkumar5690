class Solution {
    public boolean stoneGame(int[] nums) {
        int n = nums.length;
       int[][] dp = new int[n][n];

       for(int[] i : dp){
        Arrays.fill(i,-1);
       }
       if((n & 1) == 0) return true;
       return maxDiff(dp, 0, n-1,nums)>0;
    }
    private int maxDiff(int[][] dp, int i,int j, int[] nums){
        if(dp[i][j] != -1) return dp[i][j];
        if(i == j) return dp[i][j] = nums[i];
       
        return  dp[i][j] = Math.max((nums[i] - maxDiff(dp,i+1, j ,nums)) , nums[j] - maxDiff(dp,i,j-1,nums));
    }
}