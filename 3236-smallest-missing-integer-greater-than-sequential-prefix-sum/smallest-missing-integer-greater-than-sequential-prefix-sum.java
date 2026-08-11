class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxCount = 1;
        if(nums.length == 1) return  nums[0]+1;

        for(int i = 0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                maxCount += 1;
            } else {
                break;
            }
        }
        int seqSum = ((nums[maxCount -1] +nums[0]) * maxCount )/2;
        while(set.contains(seqSum)){
            seqSum++;
        }

        return seqSum;
    }
}