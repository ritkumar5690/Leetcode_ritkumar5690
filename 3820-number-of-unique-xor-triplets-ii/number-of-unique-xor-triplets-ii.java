class Solution {
    public int uniqueXorTriplets(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int val = nums[i] ^ nums[j];
                set2.add(val);
            }
        }
        for(int pairXor : set2) {
            for(int num : nums) {
                set.add(pairXor ^ num);
            }
        }
        return set.size();
    }
}