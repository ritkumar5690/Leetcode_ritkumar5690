class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int max= 0;
        for(int num : nums){
            max = Math.max(max,num);
        }
        int t = 1;
        while(t <= max){
            t<<=1;
        }
        boolean[] s1 = new boolean[t];
        boolean[] s2 = new boolean[t];
        for(int i = 0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                s1[nums[i] ^ nums[j]] = true;
            }
        }
       for(int i = 0; i < t; i++) {
            if(s1[i] == true) {
                for(int num : nums) {
                    s2[i ^ num] = true;
                }
            }
        }
        int count = 0; 
        for(int i = 0; i < t; i++) {
            if(s2[i] == true)
                count++;
        }
        return count;
    }
}