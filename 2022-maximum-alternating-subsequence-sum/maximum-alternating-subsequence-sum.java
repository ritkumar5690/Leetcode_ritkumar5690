class Solution {
    private int n;
    long dp[][];
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[n+1][2];
        long[][] t = new long[n+1][2];
        for(int i = 1;i<n+1;i++){
            t[i][0] = Math.max(t[i-1][0],-nums[i-1] + t[i-1][1]);
            t[i][1] = Math.max(t[i-1][1],nums[i-1] + t[i-1][0]);
        }
        return Math.max(t[n][0], t[n][1]);
    }
    // for (int i = 0; i < n; i++) {
    //         Arrays.fill(dp[i], Long.MIN_VALUE);
    //     }
    // private long solve(int nums[], int i,boolean sign){
    //     if(i == n) return 0;

    //     int s = sign ? 1 : 0;

    //     if (dp[i][s] != Long.MIN_VALUE) {
    //         return dp[i][s];
    //     }
    //     long take ;
    //     if(sign){
    //         take = nums[i] + solve(nums,i+1,false);
    //     }else{
    //         take = -nums[i] + solve(nums,i+1,true);
    //     }
    //     long skip = solve(nums,i+1,sign);
    //     return dp[i][s] = Math.max(skip,take); 

    // }
}