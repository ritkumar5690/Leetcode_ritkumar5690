class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int res =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            int count =0;
            for(int j = i;j<n;j++){
                if(nums[j] == target) count++;
                if(2 * count > (j-i+1)){
                    res++;
                }
            }
        }
        return res;
    }
    // private int subarray(int s,int e,int[] nums, int target){
    //     int count = 0;
    //     for(int i =s;i<= e;i++){
    //         if(nums[i] == target) count++;
    //     }
    //     return count;
    // }
}