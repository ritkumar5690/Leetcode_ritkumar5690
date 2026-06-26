class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        long res =0;
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        long validp = 0;
        int count =0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                validp += map.getOrDefault(count, 0);
                count++;
            } else {
                count--;
                validp -= map.getOrDefault(count, 0);
            }

            map.put(count, map.getOrDefault(count, 0) + 1);
            res += validp;
        }
        return res;
    }
}