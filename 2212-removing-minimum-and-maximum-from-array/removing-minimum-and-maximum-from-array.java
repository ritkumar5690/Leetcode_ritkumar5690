class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length <=1) return 1;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minI = 0;
        int maxI = 0;
        for(int i = 0;i<n;i++){
            if(max < nums[i]){
                max = nums[i];
                maxI =i;
            }
            if(nums[i] < min){
                min = nums[i];
                minI = i;
            }
        }
        int left = Math.min(minI, maxI);
        int right = Math.max(minI, maxI);
        int option1 = right + 1;
        int option2 = n - left;
        int option3 = (left + 1) + (n - right);

        return Math.min(
            option1,
            Math.min(option2, option3)
        );
    }
}