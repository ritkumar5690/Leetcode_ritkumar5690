class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int max = -1, min = 101;
        Set<Integer> set =  new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            set.add(nums[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = min;i<=max;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}