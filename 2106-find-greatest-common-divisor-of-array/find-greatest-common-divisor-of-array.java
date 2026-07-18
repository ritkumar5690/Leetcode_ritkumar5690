class Solution {
    public int findGCD(int[] nums) {
        int a =0;
        int b = 10001;
        for(int num : nums){
            a = Math.max(a,num);
            b = Math.min(b,num);
        }
        while( b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}