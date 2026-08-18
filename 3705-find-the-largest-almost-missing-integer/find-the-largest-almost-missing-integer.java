class Solution {
    public int largestInteger(int[] nums, int k) {
        int count[] = new int[51];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        int ans = -1;
        if (k == 1) {
            for (int i = 0; i < 51; i++) {
                if (count[i] == 1) {
                    ans = i;
                }
            }
            return ans;
        }
        if (k == n) {
            for (int i = 0; i < 51; i++) {
                if (count[i] >= 1) {
                    ans = i;
                }
            }
            return ans;
        }
        if (count[nums[0]] == 1 && (nums[0] > nums[n - 1] || count[nums[n - 1]] > 1)) {
            return nums[0];

        } else if (count[nums[n - 1]] == 1 && (nums[n - 1] > nums[0] || count[nums[0]] > 1)) {
            return nums[n - 1];

        }
        return -1;
    }
}