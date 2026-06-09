class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        if(n<2) return 0;
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;
        for(int i = 0;i<n ;i++){
            if(nums[i] > max) max = nums[i];
            if(nums[i] < min) min = nums[i];
        }
        return (max-min) * k;
    }
}