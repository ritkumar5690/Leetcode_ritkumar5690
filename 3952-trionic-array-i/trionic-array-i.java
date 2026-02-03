class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag3 = false;
        int i =1;
        for( ;i<n;i++){
            if(nums[i-1] < nums[i]){
                flag1= true;
            }
            else{
                break;
            }
        }
        for( ;i<n;i++){
            if(nums[i-1] > nums[i]){
                flag2= true;
            }
            else{
                break;
            }
        }
        for( ;i<n;i++){
            if(nums[i-1] < nums[i]){
                flag3= true;
            }
            else{
                break;
            }
        }
        if(i>=n && flag1 && flag2 && flag3) return true;
        return false;
    }
}