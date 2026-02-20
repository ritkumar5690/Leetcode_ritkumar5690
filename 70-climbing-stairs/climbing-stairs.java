class Solution {
    public int climbStairs(int n) {
       return helper(n);

    }
    private int helper(int n){
        if(n == 0 || n ==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2;i<n+1;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
        
    }


    // private int helper(int n){
    //     if(n == 0 ){
    //         return 1;
    //     }
    //     else if(n < 0) return 0;
    //     return helper(n-1)+helper(n-2);
    // }
}