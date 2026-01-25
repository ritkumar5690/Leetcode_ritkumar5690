class Solution {
    public int findKthLargest(int[] nums, int k) {
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0;i < nums.length;i++){
            pq.add(nums[i]);
        }
        for(int i =0;i<k;i++){
           res = pq.poll();
        }
        return res;
    }
}