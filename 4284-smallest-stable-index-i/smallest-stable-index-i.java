class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int suffix[] = new int[n];
        suffix[n-1] = nums[n-1];
        for(int i =n-2;i>=0;i--){
            if(suffix[i+1] > nums[i]){
                suffix[i] = nums[i];
            }
            else{
                suffix[i] = suffix[i+1];
            }
        }
        int max = nums[0];
        for(int i=0;i<n;i++){
            if(max < nums[i]){
                max= nums[i];
            }
            int diff = max - suffix[i];
            if(diff <= k){
                return i;
            }
        }
        return -1;
    }
}