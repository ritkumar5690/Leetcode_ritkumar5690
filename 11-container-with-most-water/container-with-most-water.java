class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n - 1;
        int maxWater = 0;

        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            int water = minHeight * (j - i);
            maxWater = Math.max(maxWater, water);

            // Move the smaller height pointer inward
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }
}
