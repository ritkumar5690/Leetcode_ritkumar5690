class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return n;
        }
        int x = 2;
        while(x <= n){
            x *= 2;
        }
        return x;
    }
}