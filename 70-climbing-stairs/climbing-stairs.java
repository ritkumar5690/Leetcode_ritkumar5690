class Solution {
    public int climbStairs(int n) {
       return helper(n);

    }
    private int helper(int n){
        if(n == 0 || n ==1){
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for(int i=0;i<n;i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
        
    }


    // private int helper(int n){
    //     if(n == 0 ){
    //         return 1;
    //     }
    //     else if(n < 0) return 0;
    //     return helper(n-1)+helper(n-2);
    // }
}