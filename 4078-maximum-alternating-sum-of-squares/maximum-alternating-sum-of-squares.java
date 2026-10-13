class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0;i<n;i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        int k = (n%2 == 0)? n/2: n/2+1;
        long score= 0;
        int j = 0;
        for(j = 0;j<n-k;j++){
            score -= nums[j]*nums[j];
            
        }
        for(;j<n;j++){
            score += nums[j]*nums[j] ;
            
        }
        return score;
    }
}