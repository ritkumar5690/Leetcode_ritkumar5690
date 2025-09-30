class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        while(n>1){
            int[] newNum = new int[n-1];
            for(int i =0;i<n-1;i++){
                newNum[i] = (nums[i] + nums[i+1])%10;
            }
            n = n-1;
            nums = new int[n];
            for(int i =0;i<n;i++){
                nums[i] = newNum[i];
            }
            
        }
        return nums[0];
    }
}