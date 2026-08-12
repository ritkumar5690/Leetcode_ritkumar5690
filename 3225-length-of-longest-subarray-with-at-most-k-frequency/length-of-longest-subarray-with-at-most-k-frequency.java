class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int j = 0;
        int res = 0;
        for (int i = 0; i < n;i++) {
             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.get(nums[i]) > k) {
                map.computeIfPresent(nums[j], (key, value) -> value > 1 ? value - 1 : null);
                j++;
               
            }

            res = Math.max(res, i-j+1);
            

        }
        return res;
    }
}