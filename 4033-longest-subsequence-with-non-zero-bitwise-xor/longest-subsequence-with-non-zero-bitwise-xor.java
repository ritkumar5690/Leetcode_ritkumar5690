class Solution {
    public int longestSubsequence(int[] nums) {
        int res = nums[0];
        boolean flag = false;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]!=0){
               flag = true;
            }
        }
        for(int i = 1;i<nums.length;i++){
            res ^= nums[i];
        }
        if(!flag && res==0) return 0;
        return res !=0 ? nums.length: nums.length-1;
    }
}