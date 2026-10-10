class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int tk = k1 + k2;
        int n = nums1.length;
        int nums[] = new int[n];
    
        int maxDiff = 0;
        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            nums[i] = diff;
            maxDiff = Math.max(maxDiff, diff);
            
        }
      
        int[] countDiff = new int[maxDiff + 1];
        for (int d : nums) {
            countDiff[d]++;
        }

        long K = (long) k1 + k2;

        for (int currDiff = maxDiff; currDiff > 0 && K > 0; currDiff--) {
            int countOps = (int) Math.min(countDiff[currDiff], K);

            countDiff[currDiff] -= countOps;
            countDiff[currDiff - 1] += countOps;
            K -= countOps;
        }
        long result = 0;
        for (long d = 1; d <= maxDiff; d++) {
            result += countDiff[(int) d] * d * d;
        }

        return result;

    }
}