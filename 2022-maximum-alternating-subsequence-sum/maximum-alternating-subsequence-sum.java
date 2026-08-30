class Solution {
    private int n;
    long dp[][];
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Long.MIN_VALUE);
        }
        return solve(nums,0,true);
    }
    private long solve(int nums[], int i,boolean sign){
        if(i == n) return 0;

        int s = sign ? 1 : 0;

        if (dp[i][s] != Long.MIN_VALUE) {
            return dp[i][s];
        }
        long take ;
        if(sign){
            take = nums[i] + solve(nums,i+1,false);
        }else{
            take = -nums[i] + solve(nums,i+1,true);
        }
        long skip = solve(nums,i+1,sign);
        return dp[i][s] = Math.max(skip,take); 

    }
}