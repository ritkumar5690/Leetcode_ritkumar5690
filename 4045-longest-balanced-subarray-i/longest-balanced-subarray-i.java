class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            int odd = 0, even = 0;

            for (int j = i; j < n; j++) {
                if (!seen.contains(nums[j])) {
                    if (nums[j] % 2 == 0) even++;
                    else odd++;
                    seen.add(nums[j]);
                }
                if (odd == even) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
}
