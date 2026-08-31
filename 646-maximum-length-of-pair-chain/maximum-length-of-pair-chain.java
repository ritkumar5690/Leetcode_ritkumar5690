class Solution {
    public int findLongestChain(int[][] nums) {
        Arrays.sort(nums, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int p = Integer.MIN_VALUE;
        for(int i =0;i<nums.length;i++){
            if(nums[i][0] > p){
                p = nums[i][1];
                count++;
            }
            
        }
        return count;
    }
    
}