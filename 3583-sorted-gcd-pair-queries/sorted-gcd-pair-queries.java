class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int count[] = new int[max + 1];
        for (int n : nums) {
            count[n]++;
        }
        long[] gcdC = new long[max + 1];

        for (int i = max; i >= 1; i--) {
            int countnums = 0;
            for (int j = i; j <= max; j += i) {
                countnums += count[j];
                gcdC[i] -= gcdC[j];
            }
            gcdC[i] += (long)countnums * (countnums - 1) / 2;
            
        }
        long prefixSum[] = new long[max + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + gcdC[i];
        }
        int res[] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = binary(prefixSum, queries[i]);
        }
        return res;
    }

    private int binary(long[] prefixSum, long target) {
        int low = 1, ans = 0;
        int high = prefixSum.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (prefixSum[mid] > target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}