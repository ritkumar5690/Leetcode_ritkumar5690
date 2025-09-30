class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        
        return findAns(nums,n);
    }
    private int findAns(int[] nums,int n){
        if(n == 1) return nums[0];
        for(int i =0;i<n-1;i++){
            nums[i] = (nums[i+1]+nums[i])%10;

        }
        return findAns(nums,n-1);
    }
}