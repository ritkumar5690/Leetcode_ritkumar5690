class Solution {
    int n;
    int[][] t;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        t = new int[2501][2501];
        for(int[] r : t){
            Arrays.fill(r,-1);
        }
        return solve(nums,0,-1);
    }
    private int solve(int[] nums,int i,int p){
        if(i == n) return 0;
        int add = 0;
        if(p!=-1 && t[i][p] != -1){
            return t[i][p];
        }
        if(p ==-1 || nums[i] > nums[p]){
           add =1+ solve(nums, i+1,i);
        }
        int skip = solve(nums,i+1,p);
        if(p!=-1){
            t[i][p] = Math.max(add,skip);
        }
        return Math.max(add,skip);
    }
}