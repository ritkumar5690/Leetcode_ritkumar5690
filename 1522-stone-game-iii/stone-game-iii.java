class Solution {
    private int[] dp ;
    public String stoneGameIII(int[] stoneValue) {
       dp = new int[stoneValue.length+1];
       Arrays.fill(dp, -1);

        int ans= solve(stoneValue,0);
        if(ans == 0){
            return "Tie";
        }
        return ans > 0? "Alice" : "Bob";
    }
    private int solve(int[] nums, int i){
        if(i>=nums.length) return 0;
        if(dp[i] != -1){
            return dp[i];
        }
        int res = nums[i]-solve(nums,i+1);
        if(i+1 < nums.length){
           res =Math.max(res, nums[i] + nums[i+1]-solve(nums,i+2));
        }
        if(i+2 < nums.length){
            res =Math.max(res, nums[i]+nums[i+1] + nums[i+2]-solve(nums,i+3));
        }
        
        return dp[i] = res;
    }
}